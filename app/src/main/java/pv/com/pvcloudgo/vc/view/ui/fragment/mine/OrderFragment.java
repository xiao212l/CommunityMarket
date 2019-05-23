package pv.com.pvcloudgo.vc.view.ui.fragment.mine;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.squareup.okhttp.Response;

import butterknife.Bind;
import butterknife.ButterKnife;
import pv.com.pvcloudgo.app.App;
import pv.com.pvcloudgo.http.SpotsCallBack;
import pv.com.pvcloudgo.model.bean.BillListBean;
import pv.com.pvcloudgo.model.bean.CartBean;
import pv.com.pvcloudgo.utils.Contants;
import pv.com.pvcloudgo.utils.ToastUtils;
import pv.com.pvcloudgo.vc.adapter.CartRecyclerViewAdapter;
import pv.com.pvcloudgo.vc.view.ui.fragment.BaseFragment;
import pv.com.pvcloudgo.vc.view.ui.fragment.interf.OnItemClickListener;
import pv.com.pvcloudgo.vc.view.ui.activity.mine.OrderDetailActivity;
import pv.com.pvcloudgo.R;
import pv.com.pvcloudgo.vc.adapter.OrderRecyclerViewAdapter;
import pv.com.pvcloudgo.vc.view.ui.fragment.dummy.DummyContent;


/**
 * 云商圈seg
 */
public class OrderFragment extends BaseFragment {

    @Bind(R.id.list)
    RecyclerView mRecyclerView;
    // TODO: Customize parameters

    private OnItemClickListener mListener;
    private  OrderRecyclerViewAdapter adapter;


    public OrderFragment() {
    }

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cir_funslist, container, false);

        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void init() {
        mListener = new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
            }
        };
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        mHttpHelper.Get(Contants.API.BASE_URL + "order/listorders"
                , App.getInstance().getToken(), new SpotsCallBack<BillListBean>(getActivity()) {
                    @Override
                    public void onSuccess(Response response, BillListBean BillBean) {
                        if (BillBean != null && BillBean.getMessage().equals("订单获取成功")) {

                            adapter = new OrderRecyclerViewAdapter(getContext(),BillBean.getData());
                            mRecyclerView.setAdapter(adapter);

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


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}
