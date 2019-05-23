package pv.com.pvcloudgo.vc.view.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.okhttp.Response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pv.com.pvcloudgo.R;
import pv.com.pvcloudgo.app.App;
import pv.com.pvcloudgo.http.OkHttpHelper;
import pv.com.pvcloudgo.http.SpotsCallBack;
import pv.com.pvcloudgo.model.bean.commentMessageBean;
import pv.com.pvcloudgo.model.bean.goodsDetailMessageBean;
import pv.com.pvcloudgo.utils.Contants;
import pv.com.pvcloudgo.utils.ToastUtils;
import pv.com.pvcloudgo.vc.adapter.CommentRecyclerViewAdapter;
import pv.com.pvcloudgo.vc.view.ui.activity.other.DetailActivity;

/**
 * item页ViewPager里的评价Fragment
 */
public class GoodsCommentFragment extends Fragment{
    public TextView tv_good_comment;
    public RecyclerView comment_list;
    public DetailActivity activity;
    public int style = DetailActivity.type;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = (DetailActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_goods_comment, null);
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView) {
        tv_good_comment = (TextView) rootView.findViewById(R.id.tv_good_comment);
        comment_list = (RecyclerView) rootView.findViewById(R.id.comment_list_total);
        getData();


    }


    public void getData() {
        OkHttpHelper HttpHelper = new OkHttpHelper();

        HttpHelper.Get(Contants.API.BASE_URL + "evaluation/listall/" + style + "?pageNum=1"
                , App.getInstance().getToken(), new SpotsCallBack<commentMessageBean>(getActivity()) {
                    @Override
                    public void onSuccess(Response response, commentMessageBean commentBean) {
                        if (commentBean != null && commentBean.getMessage().equals("获取商品评价成功")) {
                            List<commentMessageBean.DataBean> goodlist = commentBean.getData();

                            comment_list.setLayoutManager(new LinearLayoutManager(getContext()));
                            CommentRecyclerViewAdapter adapter = new CommentRecyclerViewAdapter(getContext(), goodlist,getActivity());
                            comment_list.setAdapter(adapter);


                        } else {
                            ToastUtils.show("用户评价获取失败");
                        }

                    }

                    @Override
                    public void onError(Response response, int code, Exception e) {
                        ToastUtils.show("用户评价获取失败");
                    }

                    @Override
                    public void onServerError(Response response, int code, String errmsg) {
                        ToastUtils.show("用户评价获取失败,服务器无响应");
                    }

                    @Override
                    public void onTokenError(Response response, int code) {

                    }
                });

    }


}
