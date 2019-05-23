package pv.com.pvcloudgo.vc.view.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.squareup.okhttp.Response;

import java.util.List;

import pv.com.pvcloudgo.R;
import pv.com.pvcloudgo.app.App;
import pv.com.pvcloudgo.http.SpotsCallBack;
import pv.com.pvcloudgo.model.bean.goodsSimpleBean;
import pv.com.pvcloudgo.utils.Contants;
import pv.com.pvcloudgo.utils.ToastUtils;
import pv.com.pvcloudgo.vc.adapter.GoodsListRecyclerViewAdapter;

public class GoodsFragment4 extends BaseFragment implements View.OnClickListener {

    private List<goodsSimpleBean.DataBean>  goodlist;

    private int page = 1;
    private int type = 0;

    private boolean isEnd = false;

    private Context context;
    private ImageView ivGoodsType;

    private RecyclerView recyclerView;

    private GoodsListRecyclerViewAdapter adapter;

    private ImageView ivStick;//置顶

    private int goodsType = 0;

    @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_goods, container, false);

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        recyclerView = (RecyclerView) getActivity().findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setHasFixedSize(true);

        mHttpHelper.Get(Contants.API.BASE_URL + "product/list/simple/1/" + page + "/6"
                , App.getInstance().getToken(), new SpotsCallBack<goodsSimpleBean>(getActivity()) {
                    @Override
                    public void onSuccess(Response response, goodsSimpleBean goodsBean) {
                        if (goodsBean != null && goodsBean.getMessage().equals("请求成功")) {
                            goodlist = goodsBean.getData();

                            adapter = new GoodsListRecyclerViewAdapter(this.mContext , goodsBean.getData(),getActivity());
                            recyclerView.setAdapter(adapter);

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
//
//
        ivStick = (ImageView) getActivity().findViewById(R.id.iv_stick);
        ivStick.setOnClickListener(this);


        //设置滑动监听
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();

                if (layoutManager instanceof LinearLayoutManager) {
                    LinearLayoutManager linearManager = (LinearLayoutManager) layoutManager;
                    //获取第一个可见位置
                    int LastVisibleItemPosition = linearManager.findLastVisibleItemPosition();
                    //当滑动到第十个以上时显示置顶图标
//
//                    ToastUtils.show(""+LastVisibleItemPosition);
                    if (LastVisibleItemPosition == (adapter.getItemCount() - 1) && !isEnd) {
                        mHttpHelper.Get(Contants.API.BASE_URL + "product/list/simple/1/" + (++page) + "/6"
                                , App.getInstance().getToken(), new SpotsCallBack<goodsSimpleBean>(getActivity()) {
                                    @Override
                                    public void onSuccess(Response response, goodsSimpleBean goodsBean) {

                                        if (goodsBean != null && goodsBean.getMessage().equals("请求成功")) {
                                            if (goodsBean.getData() == null) {
                                                isEnd = true;
                                            } else if (goodsBean.getData().size() < 6) {
                                                goodlist = goodsBean.getData();
                                                adapter.setGoodlist(goodsBean.getData());
                                                ToastUtils.show("加载成功");
                                                adapter.notifyItemRangeChanged(adapter.getItemCount(), adapter.getItemCount() + goodlist.size());
                                                ToastUtils.show("" + adapter.getItemCount());
                                                adapter.notifyDataSetChanged();
                                                isEnd = true;
                                            } else {
                                                goodlist = goodsBean.getData();
                                                adapter.setGoodlist(goodlist);
                                                ToastUtils.show("加载成功");
                                                adapter.notifyItemRangeChanged(adapter.getItemCount(), adapter.getItemCount() + goodlist.size());
                                                ToastUtils.show("" + adapter.getItemCount());
                                                adapter.notifyDataSetChanged();
                                            }

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
        });


    }

    @Override
    public void init() {
        Fresco.initialize(getActivity());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
//            case R.id.iv_goods_type://切换布局
//                if (goodsType==0){
//                    ivGoodsType.setImageResource(R.mipmap.good_type_grid);
//                    //1：设置布局类型
//                    adapter.setType(1);
//                    //2：设置对应的布局管理器
//                    recyclerView.setLayoutManager(new GridLayoutManager(context,2));
//                    //3：刷新adapter
//                    adapter.notifyDataSetChanged();
//                    goodsType=1;
//                }else {
//                    ivGoodsType.setImageResource(R.mipmap.good_type_linear);
//                    adapter.setType(0);
//                    recyclerView.setLayoutManager(new LinearLayoutManager(context));
//                    adapter.notifyDataSetChanged();
//                    goodsType=0;
//                }
//                  break;
            case R.id.iv_stick://置顶
                recyclerView.scrollToPosition(0);
                break;
        }
    }


}
