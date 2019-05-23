package pv.com.pvcloudgo.vc.view.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.okhttp.Response;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pv.com.pvcloudgo.app.App;
import pv.com.pvcloudgo.http.SpotsCallBack;
import pv.com.pvcloudgo.model.bean.BillListBean;
import pv.com.pvcloudgo.model.bean.CartBean;
import pv.com.pvcloudgo.model.bean.deleteCartBean;
import pv.com.pvcloudgo.utils.Contants;
import pv.com.pvcloudgo.utils.ToastUtil;
import pv.com.pvcloudgo.utils.ToastUtils;
import pv.com.pvcloudgo.vc.adapter.CartRecyclerViewAdapter;
import pv.com.pvcloudgo.vc.adapter.OrderRecyclerViewAdapter;
import pv.com.pvcloudgo.vc.view.ui.activity.order.CreateOrderActivity;
import pv.com.pvcloudgo.R;
import pv.com.pvcloudgo.vc.adapter.ShopCartAdapter;
import pv.com.pvcloudgo.model.bean.ShoppingCart;
import pv.com.pvcloudgo.utils.CartProvider;

import static pv.com.pvcloudgo.vc.adapter.CartRecyclerViewAdapter.CartItem;

public class CartFragment extends BaseFragment implements View.OnClickListener {

    private CartRecyclerViewAdapter adapter;
    public static final int ACTION_EDIT = 1;
    public static final int ACTION_CAMPLATE = 2;
    private static final String TAG = "CartFragment";
    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;
    @Bind(R.id.checkbox_all)
    CheckBox mCheckBox;
    @Bind(R.id.btn_order)
    Button mBtnOrder;
    @Bind(R.id.btn_delete)
    Button mBtnDel;
    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;
    @Bind(R.id.toolbar_logo)
    ImageView toolbarLogo;
    @Bind(R.id.toolbar_left_logo)
    ImageView toolbarLeftLogo;
    @Bind(R.id.toolbar_left_title)
    TextView toolbarLeftTitle;
    @Bind(R.id.toolbar_right_title)
    TextView toolbarRightTitle;
    @Bind(R.id.image_right)
    ImageView imageRight;
    @Bind(R.id.image_exit)
    ImageView imageExit;


    private ShopCartAdapter mAdapter;
    private CartProvider cartProvider;

    private Context context;


    @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cart, container, false);
    }


    @Override
    public void init() {

        changeToolbar();
        mCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox V = (CheckBox) v;
                if (V.isChecked()) {
                    for (CheckBox check : CartItem.checkgroup) {
                        check.setChecked(true);
                    }
                } else {
                    for (CheckBox check : CartItem.checkgroup) {
                        check.setChecked(false);
                    }
                }
            }
        });

    }

    @OnClick(R.id.btn_delete)
    public void delCart(View view) {

        for (int i = 0; i < CartItem.checkgroup.length; i++) {
            if (CartItem.checkgroup[i].isChecked()) {

                mHttpHelper.Delete(Contants.API.BASE_URL + "cart/delete/"+ CartItem.cartItem[i].getSkuId()
                        , App.getInstance().getToken(), new SpotsCallBack<deleteCartBean>(getActivity()) {
                            @Override
                            public void onSuccess(Response response, deleteCartBean DeleteBean) {
                                if (DeleteBean != null && DeleteBean.getMessage().equals("购物车商品删除成功")) {
                                    ToastUtils.show("删除成功");
                                    refData();
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
        }


    }

    @OnClick(R.id.btn_order)
    public void toOrder(View view) {
        boolean isSelected = false;
        for (CheckBox check : CartItem.checkgroup) {
            if (check.isChecked()) {
                isSelected = true;
            }
        }
        if (isSelected) {
            Intent intent = new Intent(getActivity(), CreateOrderActivity.class);
            intent.putExtra("type", 1);
            startActivity(intent, true);
        } else {
            ToastUtils.show("请选择至少一项商品");
        }


    }


    public void refData() {

        recyclerView = (RecyclerView) getActivity().findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setHasFixedSize(true);

        mHttpHelper.Get(Contants.API.BASE_URL + "cart/listall"
                , App.getInstance().getToken(), new SpotsCallBack<CartBean>(getActivity()) {
                    @Override
                    public void onSuccess(Response response, CartBean CartBean) {
                        if (CartBean != null && CartBean.getMessage().equals("请求成功")) {

                            adapter = new CartRecyclerViewAdapter(this.mContext, CartBean.getData().getCartItems());
                            recyclerView.setAdapter(adapter);

                        } else {
                            ToastUtils.show("请求失败");
                        }

                    }

                    @Override
                    public void onError(Response response, int code, Exception e) {
                        ToastUtils.show("请求出错");
                    }

                    @Override
                    public void onServerError(Response response, int code, String errmsg) {
                        ToastUtils.show("请求失败,服务器无响应");
                    }
                });


    }


    public void changeToolbar() {
        toolbarTitle.setText(R.string.cart);
        toolbarRightTitle.setText("编辑");
        toolbarLeftTitle.setText("刷新");
        toolbarLeftTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refData();
            }
        });


        toolbarRightTitle.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        TextView V = (TextView) v;
        if (mBtnDel.getVisibility() == View.INVISIBLE) {
            mBtnDel.setVisibility(View.VISIBLE);
            V.setText("完成");
        } else {
            mBtnDel.setVisibility(View.INVISIBLE);
            V.setText("编辑");
            mCheckBox.setChecked(false);
            for (CheckBox check : CartItem.checkgroup) {
                check.setChecked(false);
            }
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        refData();

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {   // 不在最前端显示 相当于调用了onPause();
            return;
        } else {  // 在最前端显示 相当于调用了onResume();
            refData();
        }
    }


    public void next(Class cls, int data) {


        Intent intent = new Intent(getActivity(), cls);
        intent.putExtra("position", data);

        startActivityForResult(intent, true, Contants.REQUEST_CODE);

    }

}