package pv.com.pvcloudgo.vc.view.ui.activity.other;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.okhttp.Response;

import java.util.ArrayList;
import java.util.List;

import pv.com.pvcloudgo.R;
import pv.com.pvcloudgo.app.App;
import pv.com.pvcloudgo.http.SpotsCallBack;
import pv.com.pvcloudgo.model.bean.goodsDetailMessageBean;
import pv.com.pvcloudgo.model.bean.shareBillMessageBean;
import pv.com.pvcloudgo.utils.Contants;
import pv.com.pvcloudgo.utils.ToastUtils;
import pv.com.pvcloudgo.vc.adapter.ShareBillAllRecyclerViewAdapter;
import pv.com.pvcloudgo.vc.base.BaseActivity;
import pv.com.pvcloudgo.vc.view.ui.activity.addr.AddressListActivity;
import pv.com.pvcloudgo.vc.view.ui.activity.order.CreateAddShareActivity;

import android.widget.ArrayAdapter;

import static pv.com.pvcloudgo.vc.view.ui.fragment.GoodsInfoFragment.selectData;

public class ShareBillListActivity extends BaseActivity {

    private View selectView;
    AlertDialog selectDialog;
    private ListView selectStyle;
    RecyclerView shareBill;
    private LayoutInflater inflater;
    ArrayAdapter<String> adapter;
    EditText num;
    List<String> styleData;
    AlertDialog.Builder builder;

    public TextView tv_goods_title, tv_new_price, tv_old_price, tv_current_goods, tv_comment_count, tv_good_comment, tv_current_goods_num, numPlus, numMinus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_share_bill);
        shareBill = (RecyclerView) findViewById(R.id.share_bill_alllist);
        inflater = getLayoutInflater();

        selectView = inflater.inflate(R.layout.select_dialog, null);
        selectStyle = (ListView) selectView.findViewById(R.id.select_style);

        mHttpHelper.Get(Contants.API.BASE_URL + "order/assemble/list/" + DetailActivity.type
                , App.getInstance().getToken(), new SpotsCallBack<shareBillMessageBean>(this) {
                    @Override
                    public void onSuccess(Response response, shareBillMessageBean shareBillBean) {
                        if (shareBillBean != null && shareBillBean.getMessage().equals("拼单列表获取成功")) {

                            List<shareBillMessageBean.DataBean> goodlist;
                            goodlist = shareBillBean.getData();
                            setAdapter(goodlist);

                        } else {
                            ToastUtils.show("拼单信息获取失败");
                        }

                    }

                    @Override
                    public void onError(Response response, int code, Exception e) {
                        ToastUtils.show("拼单信息获取失败");
                    }

                    @Override
                    public void onServerError(Response response, int code, String errmsg) {
                        ToastUtils.show("拼单信息获取失败,服务器无响应");
                    }

                    @Override
                    public void onTokenError(Response response, int code) {

                    }

                });


    }


    public void setAdapter(List<shareBillMessageBean.DataBean> goodlist) {

        shareBill.setLayoutManager(new LinearLayoutManager(this));

        ShareBillAllRecyclerViewAdapter Adapter = new ShareBillAllRecyclerViewAdapter(this, goodlist, this);
        shareBill.setAdapter(Adapter);

    }


    public void showWindow(int assembleId) {

        mHttpHelper.Get(Contants.API.BASE_URL + "product/" + DetailActivity.type
                , App.getInstance().getToken(), new SpotsCallBack<goodsDetailMessageBean>(this) {
                    @Override
                    public void onSuccess(Response response, goodsDetailMessageBean DetailBean) {
                        if (DetailBean != null && DetailBean.getMessage().equals("请求成功")) {

                            styleData = new ArrayList<>();
                            for (goodsDetailMessageBean.DataBean.PurchaseProductSkusBean style : DetailBean.getData().getPurchaseProductSkus()) {
                                styleData.add(style.getAttributeName());
                            }

                            setAdapter(DetailBean, assembleId);

                        } else {
                            ToastUtils.show("请求失败");
                        }
                    }

                    @Override
                    public void onError(Response response, int code, Exception e) {
                        ToastUtils.show("请求失败");
                    }

                    @Override
                    public void onServerError(Response response, int code, String errmsg) {
                        ToastUtils.show("请求失败,服务器无响应");
                    }
                });

    }

    public void setAdapter(goodsDetailMessageBean DetailBean, int assembleId) {

        selectView = inflater.inflate(R.layout.select_dialog, null);
        selectStyle = (ListView) selectView.findViewById(R.id.select_style);
        numPlus = (TextView) selectView.findViewById(R.id.plus);
        numMinus = (TextView) selectView.findViewById(R.id.minus);
        num = (EditText) selectView.findViewById(R.id.num);

        if (adapter == null) {
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, styleData) {
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    View view = super.getView(position, convertView, parent);
                    TextView text = (TextView) view.findViewById(android.R.id.text1);
                    text.setTextColor(Color.BLACK);
                    return view;
                }
            };

        }
        selectStyle.setAdapter(adapter);

        numPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Num = Integer.parseInt(num.getText().toString());
                Num += 1;
                num.setText("" + Num);
            }
        });

        numMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int Num = Integer.parseInt(num.getText().toString());
                if (Num != 0) {
                    Num -= 1;
                }


                num.setText("" + Num);
            }
        });


        selectStyle.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (!num.getText().equals("0")) {
                    selectDialog.dismiss();

                    selectData[0] = DetailBean.getData().getPurchaseProductSkus().get(position).getId();
                    selectData[1] = Integer.parseInt(num.getText().toString());
                    next(CreateAddShareActivity.class, assembleId);

                } else ToastUtils.show("请选择数量！");


            }
        });
        builder = new AlertDialog.Builder(this);

        //通过布局填充器获login_layout
        //获取两个文本编辑框（密码这里不做登陆实现，仅演示）

        builder.setView(selectView);//设置login_layout为对话提示框

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        selectDialog = builder.show();

    }

    public void next(Class cls, int data) {


        Intent intent = new Intent(this, cls);
        intent.putExtra("assembleId", data);

        startActivity(intent);

    }

    public void refData() {
        mHttpHelper.Get(Contants.API.BASE_URL + "order/assemble/list/" + DetailActivity.type
                , App.getInstance().getToken(), new SpotsCallBack<shareBillMessageBean>(this) {
                    @Override
                    public void onSuccess(Response response, shareBillMessageBean shareBillBean) {
                        if (shareBillBean != null && shareBillBean.getMessage().equals("拼单列表获取成功")) {

                            List<shareBillMessageBean.DataBean> goodlist;
                            goodlist = shareBillBean.getData();
                            setAdapter(goodlist);

                        } else {
                            ToastUtils.show("拼单信息获取失败");
                        }

                    }

                    @Override
                    public void onError(Response response, int code, Exception e) {
                        ToastUtils.show("拼单信息获取失败");
                    }

                    @Override
                    public void onServerError(Response response, int code, String errmsg) {
                        ToastUtils.show("拼单信息获取失败,服务器无响应");
                    }

                    @Override
                    public void onTokenError(Response response, int code) {

                    }

                });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        setResult(RESULT_OK);

    }

}
