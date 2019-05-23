package pv.com.pvcloudgo.vc.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import pv.com.pvcloudgo.R;
import pv.com.pvcloudgo.model.bean.commentMessageBean;

/**
 * Created by ZhengJiao on 2017/4/27.
 */
public class CommentRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<commentMessageBean.DataBean> goodlist;
    private final Context context;
    private Activity activity;

    public CommentRecyclerViewAdapter(Context context, List<commentMessageBean.DataBean> goodlist, Activity activity) {
        this.context = context;
        this.goodlist = goodlist;
        this.activity = activity;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(goodlist!=null){
            View baseView;
            baseView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment, parent, false);
            CommentRecyclerViewAdapter.LinearViewHolder linearViewHolder = new CommentRecyclerViewAdapter.LinearViewHolder(baseView);
            return linearViewHolder;
        }
        else {
            View baseView;
            baseView = LayoutInflater.from(parent.getContext()).inflate(R.layout.none_comment, parent, false);
            CommentRecyclerViewAdapter.NoneViewHolder linearViewHolder = new CommentRecyclerViewAdapter.NoneViewHolder(baseView);
            return linearViewHolder;
        }

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {


        if (holder instanceof CommentRecyclerViewAdapter.LinearViewHolder) {

//            String res;
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            long lt = new Long(goodlist.get(position).getEvaluationTime());
//            Date date = new Date(lt);
//            res = simpleDateFormat.format(date);

            CommentRecyclerViewAdapter.LinearViewHolder linearViewHolder = (CommentRecyclerViewAdapter.LinearViewHolder) holder;
            linearViewHolder.Name.setText(goodlist.get(position).getNickname());
            linearViewHolder.attributeName.setText("购买型号："+goodlist.get(position).getAttributeName());
            linearViewHolder.Content.setText(goodlist.get(position).getContent());
//            linearViewHolder.commentTime.setText(res);
//            Glide.with(context).load(goodlist.get(position).getMainImage()).into(linearViewHolder.iv);
            if(goodlist.get(position).getType() == 1){
                linearViewHolder.commentType.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.like));
            }else if(goodlist.get(position).getType() == 2){
                linearViewHolder.commentType.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.meh));
            }else{
                linearViewHolder.commentType.setBackgroundDrawable(activity.getResources().getDrawable(R.drawable.unlike));
            }
        }else{
            CommentRecyclerViewAdapter.NoneViewHolder linearViewHolder = (CommentRecyclerViewAdapter.NoneViewHolder) holder;
            linearViewHolder.noneText.setText("暂无评论");
        }
    }


    @Override
    public int getItemCount() {
        if (goodlist!=null) {
            return goodlist.size();

        } else {
            return 1;
        }
    }

    public static class LinearViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv,commentType;
        private TextView Name, attributeName, Content;


        public LinearViewHolder(View itemView) {

            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.user_image);
            Name = (TextView) itemView.findViewById(R.id.user_name);
            attributeName = (TextView) itemView.findViewById(R.id.content_attribute_name);
            Content = (TextView) itemView.findViewById(R.id.comment_content);
//            commentTime = (TextView) itemView.findViewById(R.id.content_time);
            commentType = (ImageView) itemView.findViewById(R.id.comment_type);
        }
    }

    public static class NoneViewHolder extends RecyclerView.ViewHolder {
        public TextView noneText;
        public NoneViewHolder(View itemView) {

            super(itemView);
            noneText = (TextView)itemView.findViewById(R.id.none_message);

        }
    }

}
