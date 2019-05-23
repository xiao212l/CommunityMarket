package pv.com.pvcloudgo.vc.view.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.squareup.okhttp.Response;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import pv.com.pvcloudgo.R;
import pv.com.pvcloudgo.app.App;
import pv.com.pvcloudgo.http.SpotsCallBack;
import pv.com.pvcloudgo.model.bean.goodsSimpleBean;
import pv.com.pvcloudgo.utils.Contants;
import pv.com.pvcloudgo.utils.ToastUtils;
import pv.com.pvcloudgo.vc.adapter.GoodsListRecyclerViewAdapter;
import pv.com.pvcloudgo.vc.adapter.RecommendViewAdapter;
import pv.com.pvcloudgo.vc.view.ui.fragment.dummy.DummyContent;
import pv.com.pvcloudgo.vc.view.ui.activity.vip.ShopActivity;

public class RecommandFragment extends BaseFragment {


    @Bind(R.id.list)
    RecyclerView recyclerView;
    private int page = 1;
    private Context context;
    private RecommendViewAdapter adapter;
    private List<goodsSimpleBean.DataBean> goodlist;
    private boolean isEnd = false;

    // TODO: Customize parameters

    private OnListFragmentInteractionListener mListener;

    public RecommandFragment() {
    }

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shopmodel_list, container, false);

        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void init() {

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

    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyContent.DummyItem item);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        recyclerView = (RecyclerView) getActivity().findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setHasFixedSize(true);

        adapter = new RecommendViewAdapter(getContext() , null,getActivity(),this);
        recyclerView.setAdapter(adapter);

        mHttpHelper.Get(Contants.API.BASE_URL + "portal/recommend"
                , App.getInstance().getToken(), new SpotsCallBack<goodsSimpleBean>(getActivity()) {
                    @Override
                    public void onSuccess(Response response, goodsSimpleBean goodsBean) {
                        if (goodsBean != null && goodsBean.getMessage().equals("请求成功")) {
                            goodlist = goodsBean.getData();

                            setAdapter(goodsBean);

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

    public void refData(){
        recyclerView = (RecyclerView) getActivity().findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setHasFixedSize(true);

        adapter = new RecommendViewAdapter(getContext() , null,getActivity(),this);
        recyclerView.setAdapter(adapter);

        mHttpHelper.Get(Contants.API.BASE_URL + "portal/recommend"
                , App.getInstance().getToken(), new SpotsCallBack<goodsSimpleBean>(getActivity()) {
                    @Override
                    public void onSuccess(Response response, goodsSimpleBean goodsBean) {
                        if (goodsBean != null && goodsBean.getMessage().equals("请求成功")) {
                            goodlist = goodsBean.getData();

                            setAdapter(goodsBean);
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

    public void setAdapter(goodsSimpleBean goodsBean){

        adapter = new RecommendViewAdapter(getContext() , goodsBean.getData(),getActivity(),this);
        recyclerView.setAdapter(adapter);


    }


}
