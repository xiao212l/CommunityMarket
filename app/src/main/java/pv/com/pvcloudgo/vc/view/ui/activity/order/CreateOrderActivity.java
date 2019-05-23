package pv.com.pvcloudgo.vc.view.ui.activity.order;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
import pv.com.pvcloudgo.app.App;
import pv.com.pvcloudgo.model.bean.deleteCartBean;
import pv.com.pvcloudgo.model.bean.payMessageBean;
import pv.com.pvcloudgo.utils.ToastUtil;
import pv.com.pvcloudgo.utils.ToastUtils;
import pv.com.pvcloudgo.vc.view.ui.activity.addr.AddressListActivity;
import pv.com.pvcloudgo.vc.view.ui.activity.other.PayResultActivity;
import pv.com.pvcloudgo.R;
import pv.com.pvcloudgo.vc.adapter.WareOrderAdapter;
import pv.com.pvcloudgo.http.SpotsCallBack;
import pv.com.pvcloudgo.model.base.BaseRespMsg;
import pv.com.pvcloudgo.utils.CartProvider;
import pv.com.pvcloudgo.utils.Contants;
import pv.com.pvcloudgo.vc.base.BaseActivity;

import static pv.com.pvcloudgo.vc.adapter.CartRecyclerViewAdapter.CartItem;


public class CreateOrderActivity extends BaseActivity implements View.OnClickListener {

    Handler mHandler;
    int mark;
    int type;
    List<String> cartData;
    /**
     * 银联支付渠道
     */
    private static final String CHANNEL_UPACP = "upacp";
    /**
     * 微信支付渠道
     */
    private static final String CHANNEL_WECHAT = "wx";
    /**
     * 支付支付渠道
     */
    private static final String CHANNEL_ALIPAY = "alipay";
    /**
     * 百度支付渠道
     */
    private static final String CHANNEL_BFB = "bfb";
    /**
     * 京东支付渠道
     */
    private static final String CHANNEL_JDPAY_WAP = "jdpay_wap";


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

    private CartProvider cartProvider;

    private WareOrderAdapter mAdapter;

    private String orderNum;
    private String payChannel = CHANNEL_ALIPAY;
    private double amount = 0;

    private HashMap<String, RadioButton> channels = new HashMap<>(3);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        cartData = new ArrayList<>();
        Intent intent = getIntent();
        type = intent.getIntExtra("position", 0);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_order);
        ButterKnife.bind(this);

        init();

        showData();

        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 1:
                        int i = 0;
                        String Token = msg.getData().getString("mark");
                        for(CheckBox check : CartItem.checkgroup){
                            if(check.isChecked()){
                                i ++;
                            }
                        }

                        if(mark == i){
                            ToastUtils.show("下单成功");
                        }

                        break;
                    default:
                        break;
                }
            }
        };


    }


    private void init() {


        mLayoutBd.setOnClickListener(this);

        mBtnCreateOrder.setText("提交订单");

        for (int i = 0; i < CartItem.checkgroup.length; i++) {
            if (CartItem.checkgroup[i].isChecked()) {
                amount += CartItem.cartItem[i].getPrice() * CartItem.cartItem[i].getCount();
                cartData.add(CartItem.cartItem[i].getName() + "     x" + CartItem.cartItem[i].getCount());
            }
        }
        mTxtTotal.setText("应付款： ￥" + amount);
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

//调整listview高度避免与scollview发生冲突
        int totalHeight = 0;
        for (int i = 0; i < adapter.getCount(); i++) {
            View listItem = adapter.getView(i, null, mListView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = mListView.getLayoutParams();
        params.height = totalHeight + (mListView.getDividerHeight() * (adapter.getCount() - 1));
        params.height += 5;
        mListView.setLayoutParams(params);
//

    }


    @Override
    public void onClick(View v) {

        selectPayChannle(v.getTag().toString());
    }


    public void selectPayChannle(String paychannel) {


        for (Map.Entry<String, RadioButton> entry : channels.entrySet()) {

            payChannel = paychannel;
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

        postNewOrder();
    }

    @OnClick(R.id.select_addr)
    public void selectOrder(View view) {

        next(AddressListActivity.class, 1);

    }


    private void postNewOrder() {

        if(mName.getText().toString().equals("请选择收货地址")){
            ToastUtils.show("请选择收货地址！");
        }else{
            for (int i = 0; i < CartItem.checkgroup.length; i++) {

                int num = i;

                mHttpHelper.Post(Contants.API.BASE_URL + "order/place/separate/" + CartItem.cartItem[i].getSkuId() + "/" +
                        CartItem.cartItem[i].getCount() + "/" + AddressListActivity.addr.getId(), App.getInstance().getToken(), new SpotsCallBack<payMessageBean>(this) {
                    @Override
                    public void onSuccess(Response response, payMessageBean payMessageBean) {
                        if (payMessageBean != null && payMessageBean.getMessage().equals("下单成功")) {

                            deleteCart(CartItem.cartItem[num].getSkuId());

                            Message msg = new Message();
                            msg.what = 1;
                            Bundle bundle = new Bundle();
                            bundle.putString("mark",""+ (mark++));
                            msg.setData(bundle);
                            mHandler.sendMessage(msg);


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

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //支付页面返回处理
        if (requestCode == Contants.REQUEST_CODE_PAYMENT) {
            if (resultCode == Activity.RESULT_OK) {
                String result = data.getExtras().getString("pay_result");

                if (result.equals("success"))
                    changeOrderStatus(1);
                else if (result.equals("fail"))
                    changeOrderStatus(-1);
                else if (result.equals("cancel"))
                    changeOrderStatus(-2);
                else
                    changeOrderStatus(0);

            }
        } else if (requestCode == Contants.REQUEST_CODE) {
            mName.setText(AddressListActivity.addr.getReceiverName() + "(" + AddressListActivity.addr.getReceiverPhone() + ")");
            mAddr.setText(AddressListActivity.addr.getReceiverAddress());
        }


    }


    private void changeOrderStatus(final int status) {

        Map<String, Object> params = new HashMap<>(5);
        params.put("order_num", orderNum);
        params.put("status", status + "");


        mHttpHelper.post(Contants.API.ORDER_COMPLEPE, params, new SpotsCallBack<BaseRespMsg>(this) {
            @Override
            public void onSuccess(Response response, BaseRespMsg o) {

                toPayResultActivity(status);
            }

            @Override
            public void onError(Response response, int code, Exception e) {
                toPayResultActivity(-1);
            }

            @Override
            public void onServerError(Response response, int code, String errmsg) {

            }
        });

    }


    private void toPayResultActivity(int status) {

        Intent intent = new Intent(this, PayResultActivity.class);
        intent.putExtra("status", status);

        startActivity(intent);
        this.finish();

    }




    public void next(Class cls, int data) {


        Intent intent = new Intent(CreateOrderActivity.this, cls);
        intent.putExtra("position", data);

        startActivityForResult(intent, true, Contants.REQUEST_CODE);

    }

    public void deleteCart(int skuId){
        mHttpHelper.Delete(Contants.API.BASE_URL + "cart/delete/"+ skuId
                , App.getInstance().getToken(), new SpotsCallBack<deleteCartBean>(this) {
                    @Override
                    public void onSuccess(Response response, deleteCartBean DeleteBean) {
                        if (DeleteBean != null && DeleteBean.getMessage().equals("购物车商品删除成功")) {



                        } else {
                            ToastUtils.show("删除购物车请求失败");
                        }

                    }

                    @Override
                    public void onError(Response response, int code, Exception e) {
                        ToastUtils.show("删除购物车请求失败");
                    }

                    @Override
                    public void onServerError(Response response, int code, String errmsg) {
                        ToastUtils.show("删除购物车请求失败,服务器无响应");
                    }
                });
    }

}
