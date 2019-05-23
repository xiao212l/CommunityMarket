package pv.com.pvcloudgo.vc.view.ui.activity.order;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.okhttp.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pv.com.pvcloudgo.R;
import pv.com.pvcloudgo.app.App;
import pv.com.pvcloudgo.http.SpotsCallBack;
import pv.com.pvcloudgo.model.base.BaseRespMsg;
import pv.com.pvcloudgo.model.bean.createShareBillBean;
import pv.com.pvcloudgo.model.bean.goodsDetailMessageBean;
import pv.com.pvcloudgo.model.bean.payMessageBean;
import pv.com.pvcloudgo.utils.CartProvider;
import pv.com.pvcloudgo.utils.Contants;
import pv.com.pvcloudgo.utils.ToastUtils;
import pv.com.pvcloudgo.vc.adapter.WareOrderAdapter;
import pv.com.pvcloudgo.vc.base.BaseActivity;
import pv.com.pvcloudgo.vc.view.ui.activity.addr.AddressListActivity;
import pv.com.pvcloudgo.vc.view.ui.activity.other.PayResultActivity;
import pv.com.pvcloudgo.vc.view.ui.fragment.GoodsInfoFragment;

import static pv.com.pvcloudgo.vc.adapter.CartRecyclerViewAdapter.CartItem;

public class CreateBuyOnlyActivity  extends BaseActivity implements View.OnClickListener {

    String Title;
    int type;
    List<String> cartData;

    @Bind(R.id.txt_order)
    TextView txtOrder;

    @Bind(R.id.cart_list)
    ListView mListView;

    @Bind(R.id.rl_bd)
    RelativeLayout mLayoutBd;

    @Bind(R.id.rb_bd)
    RadioButton mRbBd;

    @Bind(R.id.btn_createOrder)
    Button mBtnCreateOrder;

    @Bind(R.id.txt_total)
    TextView mTxtTotal;

    @Bind(R.id.order_name)
    TextView mName;

    @Bind(R.id.order_addr)
    TextView mAddr;

    @Bind(R.id.select_addr)
    LinearLayout selectAddr;


    private double amount = 0;

    private HashMap<String, RadioButton> channels = new HashMap<>(3);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        cartData = new ArrayList<>();
        Intent intent = getIntent();
        type = intent.getIntExtra("position", 1);



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_order);
        ButterKnife.bind(this);

        init();

    }


    private void init() {

        mLayoutBd.setOnClickListener(this);

        mBtnCreateOrder.setText("确认订单");

        mHttpHelper.Get(Contants.API.BASE_URL + "product/" + type
                , App.getInstance().getToken(), new SpotsCallBack<goodsDetailMessageBean>(this) {
                    @Override
                    public void onSuccess(Response response, goodsDetailMessageBean DetailBean) {
                        if (DetailBean != null && DetailBean.getMessage().equals("请求成功")) {
                            for(int i = 0;i <   DetailBean.getData().getPurchaseProductSkus().size();i ++){
                                if(DetailBean.getData().getPurchaseProductSkus().get(i).getId() == GoodsInfoFragment.selectData[0]){
                                    Title = DetailBean.getData().getName() +  DetailBean.getData().getPurchaseProductSkus().get(i).getAttributeName() + "x"+GoodsInfoFragment.selectData[1];
                                    amount = GoodsInfoFragment.selectData[1]* DetailBean.getData().getPurchaseProductSkus().get(i).getSpellPrice();
                                }

                            }

                            cartData.add(Title);
                            showData();


                            mTxtTotal.setText("应付款： ￥" + amount);

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


    public void showData() {

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, cartData) {
            @Override
            public View getView(int position, View convertView, ViewGroup
                    parent) {
                View view = super.getView(position, convertView, parent);
                TextView text = (TextView) view.findViewById(android.R.id.text1);
                text.setTextColor(Color.BLACK);
                return view;
            }
        };

        mListView.setAdapter(adapter);


    }


    @Override
    public void onClick(View v) {

        selectPayChannle(v.getTag().toString());
    }


    public void selectPayChannle(String paychannel) {


        for (Map.Entry<String, RadioButton> entry : channels.entrySet()) {

            RadioButton rb = entry.getValue();
            if (entry.getKey().equals(paychannel)) {

                boolean isCheck = rb.isChecked();
                rb.setChecked(!isCheck);

            } else
                rb.setChecked(false);
        }


    }


    @OnClick(R.id.btn_createOrder)
    public void createNewOrder(View view) {

        createBuyOnly();
    }

    @OnClick(R.id.select_addr)
    public void selectOrder(View view) {

        next(AddressListActivity.class, 1);

    }


    private void createBuyOnly() {
        if(mName.getText().toString().equals("请选择收货地址")){
            ToastUtils.show("请选择收货地址！");
        }else {

            int skuId = GoodsInfoFragment.selectData[0];
            int count = GoodsInfoFragment.selectData[1];

                mHttpHelper.Post(Contants.API.BASE_URL + "order/place/separate/" + skuId + "/" +
                        count + "/" + AddressListActivity.addr.getId(), App.getInstance().getToken(), new SpotsCallBack<payMessageBean>(this) {
                    @Override
                    public void onSuccess(Response response, payMessageBean payMessageBean) {
                        if (payMessageBean != null && payMessageBean.getMessage().equals("下单成功")) {
                            ToastUtils.show("下单成功");

                            finish();

                        } else {
                            ToastUtils.show(payMessageBean.getMessage());
                        }
                    }

                    @Override
                    public void onError(Response response, int code, Exception e) {
                        ToastUtils.show("失败");
                    }

                    @Override
                    public void onServerError(Response response, int code, String errmsg) {
                        ToastUtils.show("请求失败，服务器出错");
                    }
                });



        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Contants.REQUEST_CODE) {
            mName.setText(AddressListActivity.addr.getReceiverName() + "(" + AddressListActivity.addr.getReceiverPhone() + ")");
            mAddr.setText(AddressListActivity.addr.getReceiverAddress());
        }


    }


    public void next(Class cls, int data) {


        Intent intent = new Intent(CreateBuyOnlyActivity.this, cls);
        intent.putExtra("position", data);

        startActivityForResult(intent, true, Contants.REQUEST_CODE);

    }
}