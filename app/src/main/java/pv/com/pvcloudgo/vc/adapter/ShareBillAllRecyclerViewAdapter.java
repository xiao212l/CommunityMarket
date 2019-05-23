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
import pv.com.pvcloudgo.model.bean.commentMessageBean;
import pv.com.pvcloudgo.model.bean.shareBillMessageBean;
import pv.com.pvcloudgo.utils.ToastUtils;
import pv.com.pvcloudgo.vc.view.ui.activity.addr.AddressListActivity;
import pv.com.pvcloudgo.vc.view.ui.activity.other.ShareBillListActivity;

import static android.app.Activity.RESULT_OK;

/**
 * Created by ZhengJiao on 2017/4/27.
 */
public class ShareBillAllRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<shareBillMessageBean.DataBean> goodlist;
    private final Context context;
    private Activity activity;

    public ShareBillAllRecyclerViewAdapter(Context context, List<shareBillMessageBean.DataBean> goodlist, Activity activity) {
        this.context = context;
        this.goodlist = goodlist;
        this.activity = activity;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(goodlist!=null){

            View baseView;
            baseView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_share_bill_all, parent, false);
            ShareBillAllRecyclerViewAdapter.LinearViewHolder linearViewHolder = new ShareBillAllRecyclerViewAdapter.LinearViewHolder(baseView);
            return linearViewHolder;
        }
        else{
            View baseView;
            baseView = LayoutInflater.from(parent.getContext()).inflate(R.layout.none_comment, parent, false);
            CommentRecyclerViewAdapter.NoneViewHolder linearViewHolder = new CommentRecyclerViewAdapter.NoneViewHolder(baseView);
            return linearViewHolder;
        }

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {


        if (holder instanceof ShareBillAllRecyclerViewAdapter.LinearViewHolder) {

            String res;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            long lt = new Long(goodlist.get(position).getDeadline());
            Date date = new Date(lt);

            res = simpleDateFormat.format(lt);

            ShareBillAllRecyclerViewAdapter.LinearViewHolder linearViewHolder = (ShareBillAllRecyclerViewAdapter.LinearViewHolder) holder;
            linearViewHolder.Title.setText(goodlist.get(position).getTitle());
            linearViewHolder.Deadline.setText("截至时间："+ res);
//            Glide.with(context).load(goodlist.get(position).getMainImage()).into(linearViewHolder.iv);

            linearViewHolder.join.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                        // 转化为activity，然后finish就行了
                    ((ShareBillListActivity) activity).showWindow(goodlist.get(position).getId());




                }
            });

        }else{
            CommentRecyclerViewAdapter.NoneViewHolder linearViewHolder =(CommentRecyclerViewAdapter.NoneViewHolder)holder;
            linearViewHolder.noneText.setText("暂无拼单");

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

        private ImageView iv;
        private TextView Title, Deadline;
        private Button join;

        public LinearViewHolder(View itemView) {

            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.user_image);
            Title = (TextView) itemView.findViewById(R.id.share_bill_title);
            Deadline = (TextView) itemView.findViewById(R.id.deadline);
            join = (Button)itemView.findViewById(R.id.share_bill);
        }
    }

    public void next(Class cls,int data) {


        Intent intent = new Intent(activity, cls);
        intent.putExtra("position",data);

        activity.startActivity(intent);

    }
}
