package pv.com.pvcloudgo.vc.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.okhttp.Response;

import java.util.List;
import java.util.Map;

import pv.com.pvcloudgo.R;
import pv.com.pvcloudgo.app.App;
import pv.com.pvcloudgo.http.OkHttpHelper;
import pv.com.pvcloudgo.http.SpotsCallBack;
import pv.com.pvcloudgo.model.bean.LoginBean;
import pv.com.pvcloudgo.model.bean.Param;
import pv.com.pvcloudgo.model.bean.goodsBean;
import pv.com.pvcloudgo.model.bean.goodsFragmentBean;
import pv.com.pvcloudgo.model.bean.goodsSimpleBean;
import pv.com.pvcloudgo.utils.Contants;
import pv.com.pvcloudgo.utils.ToastUtils;
import pv.com.pvcloudgo.vc.base.BaseActivity;
import pv.com.pvcloudgo.vc.view.ui.activity.other.DetailActivity;

/**
 * Created by ZhengJiao on 2017/4/27.
 */
public class GoodsListRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<goodsSimpleBean.DataBean> goodlist;
    private final Context context;
    private int type = 0;//0:LinearViewHolder  1:GridViewHolder
    private Activity activity;

    public GoodsListRecyclerViewAdapter(Context context, List<goodsSimpleBean.DataBean> goodlist,Activity activity) {
        this.context = context;
        this.goodlist = goodlist;
        this.activity = activity;

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
        if (viewType == 0) {
            baseView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_listview_goods_list, parent, false);
            LinearViewHolder linearViewHolder = new LinearViewHolder(baseView);
            return linearViewHolder;
        } else{
            View footer = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_goods_foot, parent, false);
            RecyclerView.ViewHolder viewHolder = new FooterHolder(footer);
            return viewHolder;

        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {


        if (holder instanceof LinearViewHolder&&position<goodlist.size()) {
//            ToastUtils.show("" + position);

            LinearViewHolder linearViewHolder = (LinearViewHolder) holder;
            linearViewHolder.tvName.setText(goodlist.get(position).getName());
            linearViewHolder.tvSub.setText(goodlist.get(position).getSubtitle());
            Glide.with(context).load(goodlist.get(position).getMainImage()).into(linearViewHolder.iv);

            linearViewHolder.GoodList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    next(DetailActivity.class,goodlist.get(position).getId());
                }
            });

        }else if(goodlist.size() % 6 != 0){
            FooterHolder viewHolder = (FooterHolder)holder;
            viewHolder.progressBar.setVisibility(View.INVISIBLE);
            viewHolder.message.setText("-------------到头了-------------");
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
            return 0;
        }
    }

public static class LinearViewHolder extends RecyclerView.ViewHolder {

    private ImageView iv;
    private TextView tvName,  tvSub,tv_Price;
    private LinearLayout GoodList;

    public LinearViewHolder(View itemView) {
        super(itemView);
        iv = (ImageView) itemView.findViewById(R.id.imageview);
        tvName = (TextView) itemView.findViewById(R.id.tv_name);
        tvSub = (TextView) itemView.findViewById(R.id.tv_sub);
        tv_Price = (TextView) itemView.findViewById(R.id.tv_price_yz);
        GoodList = (LinearLayout) itemView.findViewById(R.id.goodlist);

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


    public void next(Class cls,int data) {


        Intent intent = new Intent(activity, cls);
        intent.putExtra("position",data);

        activity.startActivity(intent);

    }




}
