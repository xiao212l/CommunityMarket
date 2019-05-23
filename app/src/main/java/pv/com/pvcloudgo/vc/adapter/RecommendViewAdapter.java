package pv.com.pvcloudgo.vc.adapter;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import pv.com.pvcloudgo.R;
import pv.com.pvcloudgo.model.bean.goodsSimpleBean;
import pv.com.pvcloudgo.utils.ToastUtils;
import pv.com.pvcloudgo.vc.view.ui.activity.other.DetailActivity;
import pv.com.pvcloudgo.vc.view.ui.fragment.RecommandFragment;

public class RecommendViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private List<goodsSimpleBean.DataBean> goodlist;
    private final Context context;
    private int type = 0;
    private Activity activity;
    private RecommandFragment fragment;

    public RecommendViewAdapter(Context context, List<goodsSimpleBean.DataBean> goodlist, Activity activity, RecommandFragment fragment) {
        this.context = context;
        this.goodlist = goodlist;
        this.activity = activity;
        this.fragment = fragment;
    }


    public void setGoodlist(List<goodsSimpleBean.DataBean> goodlist){
        this.goodlist.addAll(goodlist);
    }

    public void setType(int type) {
        this.type = type;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View baseView;
        if (viewType == 0&&goodlist!=null) {
            baseView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_vip, parent, false);
            RecommendViewAdapter.LinearViewHolder linearViewHolder = new RecommendViewAdapter .LinearViewHolder(baseView);
            return linearViewHolder;
        } else if(viewType != 0&&goodlist!=null){
            View footer = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_goods_foot, parent, false);
            RecyclerView.ViewHolder viewHolder = new GoodsListRecyclerViewAdapter.FooterHolder(footer);
            return viewHolder;
        }else {
            View footer = LayoutInflater.from(parent.getContext()).inflate(R.layout.refresh, parent, false);
            RecyclerView.ViewHolder viewHolder = new RecommendViewAdapter.NoneDataHolder(footer);
            return viewHolder;

        }

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {


        if (goodlist!=null&&holder instanceof RecommendViewAdapter.LinearViewHolder &&position<goodlist.size()) {

            RecommendViewAdapter.LinearViewHolder linearViewHolder = (RecommendViewAdapter.LinearViewHolder) holder;
            linearViewHolder.goodName.setText(goodlist.get(position).getName());
            linearViewHolder.goodDetail.setText(goodlist.get(position).getSubtitle());
            Glide.with(context).load(goodlist.get(position).getMainImage()).into(linearViewHolder.goodImage);

            linearViewHolder.GoodList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    next(DetailActivity.class,goodlist.get(position).getId());
                }
            });

        }else if(goodlist!=null&&goodlist.size() % 6 != 0){
            GoodsListRecyclerViewAdapter.FooterHolder viewHolder = (GoodsListRecyclerViewAdapter.FooterHolder)holder;
            viewHolder.progressBar.setVisibility(View.INVISIBLE);
            viewHolder.message.setText("-------------到头了-------------");
        }else if(holder instanceof RecommendViewAdapter.NoneDataHolder){
            RecommendViewAdapter.NoneDataHolder noneDataHolder = (RecommendViewAdapter.NoneDataHolder) holder;
            noneDataHolder.refresh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ToastUtils.show("刷新中");
                    ((RecommandFragment)fragment).refData();

                }
            });

        }


    }


    @Override
    public int getItemViewType(int position) {
        if (position + 1 == getItemCount()&&getItemCount()!=0) {
            return 1;
        } else {
            return type;
        }
    }


    @Override
    public int getItemCount() {
        if(goodlist!=null){return (goodlist.size() + 1);

        }else{
            return 1;
        }
    }

    public static class LinearViewHolder extends RecyclerView.ViewHolder {

        private ImageView goodImage;
        private TextView goodName,  goodDetail;
        private CardView GoodList;

        public LinearViewHolder(View itemView) {
            super(itemView);
            goodImage = (ImageView) itemView.findViewById(R.id.item_ff);
            goodName = (TextView) itemView.findViewById(R.id.good_name);
            goodDetail = (TextView) itemView.findViewById(R.id.good_detail);
            GoodList = (CardView) itemView.findViewById(R.id.recommendlist);

        }
    }


    static class FooterHolder extends RecyclerView.ViewHolder {
        ProgressBar progressBar;
        TextView message;

        FooterHolder(View itemView) {
            super(itemView);
            progressBar = (ProgressBar) itemView.findViewById(R.id.item_footer_progress);
            message = (TextView) itemView.findViewById(R.id.item_footer_message);
        }
    }

    public static class NoneDataHolder extends RecyclerView.ViewHolder {
        Button refresh;
        NoneDataHolder(View itemView) {
            super(itemView);
            refresh = (Button) itemView.findViewById(R.id.refresh);
        }
    }



    public void next(Class cls,int data) {


        Intent intent = new Intent(activity, cls);
        intent.putExtra("position",data);

        activity.startActivity(intent);

    }

}
