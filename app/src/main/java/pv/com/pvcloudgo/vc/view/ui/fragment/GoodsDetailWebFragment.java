package pv.com.pvcloudgo.vc.view.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.squareup.okhttp.Response;

import java.util.Arrays;

import pv.com.pvcloudgo.R;
import pv.com.pvcloudgo.app.App;
import pv.com.pvcloudgo.http.OkHttpHelper;
import pv.com.pvcloudgo.http.SpotsCallBack;
import pv.com.pvcloudgo.model.bean.goodsDetailMessageBean;
import pv.com.pvcloudgo.utils.Contants;
import pv.com.pvcloudgo.utils.ToastUtils;
import pv.com.pvcloudgo.vc.adapter.CommentRecyclerViewAdapter;
import pv.com.pvcloudgo.vc.adapter.GoodsDetailAdapter;
import pv.com.pvcloudgo.vc.view.ui.activity.other.DetailActivity;

public class GoodsDetailWebFragment extends Fragment {
    public RecyclerView DetailImages;

    private LayoutInflater inflater;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.inflater = inflater;

        View rootView = inflater.inflate(R.layout.goods_detail_image_list, null);
        initView(rootView);
        return rootView;
    }


    public void initView(View rootView) {

        DetailImages = (RecyclerView) rootView.findViewById(R.id.goods_image_list);

        OkHttpHelper HttpHelper = new OkHttpHelper();
        HttpHelper.Get(Contants.API.BASE_URL + "product/" + DetailActivity.type
                , App.getInstance().getToken(), new SpotsCallBack<goodsDetailMessageBean>(getActivity()) {
                    @Override
                    public void onSuccess(Response response, goodsDetailMessageBean DetailBean) {
                        if (DetailBean != null && DetailBean.getMessage().equals("请求成功")) {

                            String[] image = DetailBean.getData().getSubImages().split(",");

                            DetailImages.setLayoutManager(new LinearLayoutManager(getContext()));
                            GoodsDetailAdapter adapter = new GoodsDetailAdapter(getContext(), image);
                            DetailImages.setAdapter(adapter);

                        } else {
                            ToastUtils.show(DetailBean.getMessage());
                        }
                    }

                    @Override
                    public void onError(Response response, int code, Exception e) {
                        ToastUtils.show("失败");
                    }

                    @Override
                    public void onServerError(Response response, int code, String errmsg) {
                        ToastUtils.show("请求失败,服务器无响应");
                    }
                });
        HttpHelper = null;


    }

}
