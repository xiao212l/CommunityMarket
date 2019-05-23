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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import pv.com.pvcloudgo.R;
import pv.com.pvcloudgo.model.bean.shareBillMessageBean;
import pv.com.pvcloudgo.utils.ToastUtils;
import pv.com.pvcloudgo.vc.view.ui.activity.other.ShareBillListActivity;

/**
 * Created by ZhengJiao on 2017/4/27.
 */
public class ShareBillRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<shareBillMessageBean.DataBean> goodlist;
    private final Context context;
    int type;
    private Activity activity;

    public ShareBillRecyclerViewAdapter(Context context, List<shareBillMessageBean.DataBean> goodlist,int  type,Activity activity) {
        this.context = context;
        this.goodlist = goodlist;
        this.type = type;
        this.activity = activity;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View baseView;
        baseView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_share_bill, parent, false);
        ShareBillRecyclerViewAdapter.LinearViewHolder linearViewHolder = new ShareBillRecyclerViewAdapter.LinearViewHolder(baseView);
        return linearViewHolder;

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {


        if (holder instanceof ShareBillRecyclerViewAdapter.LinearViewHolder) {



            ShareBillRecyclerViewAdapter.LinearViewHolder linearViewHolder = (ShareBillRecyclerViewAdapter.LinearViewHolder) holder;
            if (goodlist == null) {
                linearViewHolder.Content.setText("暂无拼单");
            } else if (goodlist.size() > 0) {

                int i = position % goodlist.size();
                String res;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                long lt = new Long(goodlist.get(i).getDeadline());
                Date date = new Date(lt);

                simpleDateFormat.getTimeInstance();
                res = simpleDateFormat.format(lt);




                linearViewHolder.Content.setText(goodlist.get(i).getTitle()  +  "     截止时间：" + res);

                linearViewHolder.Content.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ToastUtils.show(""+goodlist.get(i).getTitle());

                        next(ShareBillListActivity.class,1);

                    }
                });


                //            Glide.with(context).load(goodlist.get(position).getMainImage()).into(linearViewHolder.iv);


            }


        }


    }


    @Override
    public int getItemCount() {
        if (goodlist != null )
            if(type == 1){
                return Integer.MAX_VALUE;
            } else return goodlist.size();
        else return 1;
    }

    public static class LinearViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv;
        private TextView Content;

        public LinearViewHolder(View itemView) {

            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.user_image);
            Content = (TextView) itemView.findViewById(R.id.comment_content);
        }
    }


    public void next(Class cls,int data) {


        Intent intent = new Intent(activity, cls);
        intent.putExtra("position",data);

        activity.startActivity(intent);

    }


}
