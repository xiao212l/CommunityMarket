package pv.com.pvcloudgo.vc.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import pv.com.pvcloudgo.R;
import pv.com.pvcloudgo.model.bean.BillListBean;
import pv.com.pvcloudgo.utils.ToastUtils;
import pv.com.pvcloudgo.vc.view.ui.fragment.dummy.DummyContent.DummyItem;

public class OrderRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<BillListBean.DataBean> mValues;
    Context context;

    public OrderRecyclerViewAdapter(Context context, List<BillListBean.DataBean> items) {
        mValues = items;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mValues != null) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_order, parent, false);
            return new ViewHolder(view);
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
        if(holder instanceof ViewHolder){

            String res;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            long lt = new Long(mValues.get(position).getPaymentTime());
            Date date = new Date(lt);

            res = simpleDateFormat.format(lt);

            ViewHolder Holder = (ViewHolder) holder;
            Holder.value.setText("￥" + mValues.get(position).getPayment());
            Holder.time.setText("下单时间：" + res);
            Holder.title.setText(mValues.get(position).getOrderItems().get(0).getProductName());
            Glide.with(context).load(mValues.get(position).getOrderItems().get(0).getProductImage()).into(Holder.iv);
        }

        else{

            CommentRecyclerViewAdapter.NoneViewHolder linearViewHolder =(CommentRecyclerViewAdapter.NoneViewHolder)holder;
            linearViewHolder.noneText.setText("暂无定单");

        }

    }

    @Override
    public int getItemCount() {
        if (mValues != null)
            return mValues.size();
        else return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public TextView title, time, value, num_price;
        public ImageView iv;


        public ViewHolder(View view) {
            super(view);
            mView = view;
            iv = (ImageView) view.findViewById(R.id.list_item_user_avater);
            title = (TextView) view.findViewById(R.id.title);
            time = (TextView) view.findViewById(R.id.time);
            value = (TextView) view.findViewById(R.id.value);
            num_price = (TextView) view.findViewById(R.id.num_and_price);
        }

    }
}
