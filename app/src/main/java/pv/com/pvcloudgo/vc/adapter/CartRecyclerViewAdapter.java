package pv.com.pvcloudgo.vc.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import pv.com.pvcloudgo.R;
import pv.com.pvcloudgo.model.bean.CartBean;
import pv.com.pvcloudgo.model.bean.goodsSimpleBean;
import pv.com.pvcloudgo.utils.ToastUtil;
import pv.com.pvcloudgo.utils.ToastUtils;

/**
 * Created by ZhengJiao on 2017/4/27.
 */
public class CartRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<CartBean.DataBean.CartItemsBean> goodlist;
    private final Context context;
    private int type = 0;//0:LinearViewHolder  1:GridViewHolder
    public static cartBindItem CartItem = new cartBindItem();

    public CartRecyclerViewAdapter(Context context, List<CartBean.DataBean.CartItemsBean> goodlist) {
        this.context = context;
        this.goodlist = goodlist;
        CartItem.checkgroup = new CheckBox[this.getItemCount()];
        CartItem.cartItem = new CartBean.DataBean.CartItemsBean[this.getItemCount()];
    }

    public void setType(int type) {
        this.type = type;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View baseView;
        baseView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_good_info, parent, false);
        LinearViewHolder linearViewHolder = new LinearViewHolder(baseView);
        return linearViewHolder;

    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {


        if (holder instanceof LinearViewHolder) {
//            ToastUtils.show("" + position);

            LinearViewHolder linearViewHolder = (LinearViewHolder) holder;
            linearViewHolder.Name.setText(goodlist.get(position).getName());
            linearViewHolder.Subtitle.setText(goodlist.get(position).getSubtitle());
            linearViewHolder.Price.setText("￥"+goodlist.get(position).getPrice());
            linearViewHolder.Totalprice.setText("￥"+goodlist.get(position).getTotalPrice());
            linearViewHolder.Count.setText("x" + goodlist.get(position).getCount());
            Glide.with(context).load(goodlist.get(position).getSubImage()).into(linearViewHolder.iv);
            CartItem.checkgroup[position] = linearViewHolder.Check;
            CartItem.cartItem[position] = goodlist.get(position);
        }


    }


    @Override
    public int getItemViewType(int position) {
        return type;

    }


    @Override
    public int getItemCount() {
        if (goodlist != null) {
            return goodlist.size();

        } else {
            return 0;
        }
    }

    public static class LinearViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv;
        private TextView Name, Subtitle, Price, Totalprice, Count;
        private CheckBox Check;

        public LinearViewHolder(View itemView) {

            super(itemView);
            iv = (ImageView) itemView.findViewById(R.id.cart_img);
            Name = (TextView) itemView.findViewById(R.id.cart_name);
            Subtitle = (TextView) itemView.findViewById(R.id.cart_subtitle);
            Price = (TextView) itemView.findViewById(R.id.cart_price);
            Totalprice = (TextView) itemView.findViewById(R.id.cart_totalprice);
            Count = (TextView) itemView.findViewById(R.id.cart_count);
            Check = (CheckBox)itemView.findViewById(R.id.cart_check);

        }
    }


    public static class cartBindItem {
        public CheckBox checkgroup[];
        public CartBean.DataBean.CartItemsBean cartItem[];

    }



}
