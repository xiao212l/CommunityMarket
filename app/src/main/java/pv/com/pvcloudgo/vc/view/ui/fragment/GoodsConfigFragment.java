package pv.com.pvcloudgo.vc.view.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import pv.com.pvcloudgo.R;
import pv.com.pvcloudgo.vc.view.ui.activity.other.DetailActivity;
import pv.com.pvcloudgo.vc.adapter.GoodsConfigAdapter;
import pv.com.pvcloudgo.model.bean.GoodsConfigBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 图文详情里的规格参数的Fragment
 */
public class GoodsConfigFragment extends Fragment {
    public DetailActivity activity;
    public ListView lv_config;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.activity = (DetailActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_config, null);
        lv_config = (ListView) view.findViewById(R.id.lv_config);
        lv_config.setFocusable(false);

        List<GoodsConfigBean> data = new ArrayList<>();
        data.add(new GoodsConfigBean("品牌", "Letv/乐视"));
        data.add(new GoodsConfigBean("型号", "LETV体感-超级枪王"));
        lv_config.setAdapter(new GoodsConfigAdapter(activity, data));
        return view;
    }
}
