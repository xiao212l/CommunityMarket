package pv.com.pvcloudgo.vc.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import pv.com.pvcloudgo.R;
import pv.com.pvcloudgo.model.bean.shareBillMessageBean;
import pv.com.pvcloudgo.utils.ToastUtils;
import pv.com.pvcloudgo.vc.view.ui.activity.other.ShareBillListActivity;

public class GoodsDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private String[] goodlist;
    private final Context context;

    public GoodsDetailAdapter(Context context, String[] goodlist) {
        this.context = context;
        this.goodlist = goodlist;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View baseView;
        baseView = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_images, parent, false);
        GoodsDetailAdapter.LinearViewHolder linearViewHolder = new GoodsDetailAdapter.LinearViewHolder(baseView);
        return linearViewHolder;

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {


        if (holder instanceof GoodsDetailAdapter.LinearViewHolder) {
            GoodsDetailAdapter.LinearViewHolder linearViewHolder = (GoodsDetailAdapter.LinearViewHolder) holder;
            Glide.with(context).load(goodlist[position]).into(linearViewHolder.iv);

//            Glide.with(context).load("http://hansonoss.oss-cn-beijing.aliyuncs.com/shop/sub/39/59be0f9fN9db9e4a6.jpg%20(350%C3%97350).jpg").into(linearViewHolder.iv);
        }
    }


    @Override
    public int getItemCount() {
        if (goodlist != null) {
            return goodlist.length;

        } else {
            return 0;
        }
    }

    public static class LinearViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv;

        public LinearViewHolder(View itemView) {

            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.goods_detail_image);
        }
    }

}


