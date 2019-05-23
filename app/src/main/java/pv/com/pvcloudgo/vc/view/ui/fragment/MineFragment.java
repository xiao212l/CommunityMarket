package pv.com.pvcloudgo.vc.view.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.okhttp.Response;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import pv.com.pvcloudgo.utils.Contants;
import pv.com.pvcloudgo.R;
import pv.com.pvcloudgo.app.App;
import pv.com.pvcloudgo.model.bean.Param;
import pv.com.pvcloudgo.model.bean.User;
import pv.com.pvcloudgo.http.SpotsCallBack;
import pv.com.pvcloudgo.model.base.BaseRespMsg;
import pv.com.pvcloudgo.model.msg.MineMsg;
import pv.com.pvcloudgo.utils.ToastUtil;
import pv.com.pvcloudgo.vc.view.ui.activity.addr.AddressListActivity;
import pv.com.pvcloudgo.vc.view.ui.activity.mine.OrderActivity;
import pv.com.pvcloudgo.vc.view.ui.activity.mine.PersonalInfoActivity;
import pv.com.pvcloudgo.vc.view.ui.activity.mine.SettingActivity;
import pv.com.pvcloudgo.utils.ToastUtils;
import pv.com.pvcloudgo.utils.Utils;
import pv.com.pvcloudgo.vc.view.ui.activity.other.DetailActivity;
import pv.com.pvcloudgo.vc.view.ui.activity.other.WareDetailActivity;
import pv.com.pvcloudgo.vc.view.ui.activity.other.goodsActivity;
import pv.com.pvcloudgo.vc.widget.pulldownview.PullToZoomScrollViewEx;
import pv.com.pvcloudgo.utils.ToastUtils;

public class MineFragment extends BaseFragment implements View.OnClickListener {

    @Bind(R.id.pull_scroll)
    PullToZoomScrollViewEx pullScrollView;
    TextView mineFunAllOrder;
    TextView mineFunWaitPay;
    TextView mineFunWaitReceive;
    TextView mineFunPayback;
    TextView mineFunEvaluate;

    TextView mineHistory;
    TextView mineGoodsFavor;
    TextView mineTicket;
    TextView mineAddress;

    TextView mTxtUserName;
    CircleImageView imgHead;
    LinearLayout contentContainer;


    @Override
    public View createView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mine, container, false);
    }


    @Override
    public void init() {


//        scrollView.getPullRootView().findViewById(R.id.tv_test1).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            }
//        });
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        int mScreenHeight = localDisplayMetrics.heightPixels;
        int mScreenWidth = localDisplayMetrics.widthPixels;
        LinearLayout.LayoutParams localObject = new LinearLayout.LayoutParams(mScreenWidth, (int) (9.0F * (mScreenWidth / 14.0F)));
        pullScrollView.setHeaderLayoutParams(localObject);
        View headView = LayoutInflater.from(getActivity()).inflate(R.layout.mine_tt, null, false);
        View zoomView = LayoutInflater.from(getActivity()).inflate(R.layout.profile_zoom_view, null, false);
        View contentView = LayoutInflater.from(getActivity()).inflate(R.layout.profile_content_view, null, false);
        pullScrollView.setHeaderView(headView);
        pullScrollView.setZoomView(zoomView);
        pullScrollView.setScrollContentView(contentView);
        pullScrollView.setParallax(true);
        initView();
        showUser();
    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mine_fun_all_order:
                next(OrderActivity.class,0);
                break;
            case R.id.mine_fun_wait_pay:
                next(OrderActivity.class,1);
                break;
            case R.id.mine_fun_wait_receive:
                next(OrderActivity.class,2);
                break;
            case R.id.mine_fun_payback:
                next(OrderActivity.class,3);
                break;
            case R.id.mine_fun_evaluate:
                next(OrderActivity.class,4);
                break;
            case R.id.mine_tt_settings_iv:
                next(SettingActivity.class,0);
                break;
            case R.id.mine_history:
                ToastUtils.show(getActivity(), "敬请期待！");
                break;
            case R.id.mine_goods_favor:
                next(DetailActivity.class,0);

                ToastUtils.show(getActivity(), "敬请期待！");
                break;
            case R.id.mine_ticket:
                ToastUtils.show(getActivity(), "敬请期待！");
                break;
            case R.id.mine_address:
                next(AddressListActivity.class,0);
                break;
            case R.id.txt_username:
            case R.id.img_head:
                next(PersonalInfoActivity.class,0);
                break;
        }
    }


    private void showUser() {

        User user = App.getInstance().getUser();
        if (user == null) {
            mTxtUserName.setText(R.string.to_login);
        } else {
            mTxtUserName.setText(user.getNickname());
                if(user.getProfileImg()!=null)
                { Glide.with(this).load(user.getProfileImg()).into(imgHead);}


//            loadMineData();
        }

    }


    public void next(Class cls,int data) {


        Intent intent = new Intent(getActivity(), cls);
        intent.putExtra("position",data);

        startActivityForResult(intent, true, Contants.REQUEST_CODE);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Contants.REQUEST_CODE && resultCode == getActivity().RESULT_OK) {
            showUser();
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {   // 不在最前端显示 相当于调用了onPause();
            return;
        }else{  // 在最前端显示 相当于调用了onResume();
            showUser();
        }
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    private void initView() {
        mineFunAllOrder = (TextView) pullScrollView.getPullRootView().findViewById(R.id.mine_fun_all_order);
        mineFunWaitPay = (TextView) pullScrollView.getPullRootView().findViewById(R.id.mine_fun_wait_pay);
        mineFunWaitReceive = (TextView) pullScrollView.getPullRootView().findViewById(R.id.mine_fun_wait_receive);
        mineFunPayback = (TextView) pullScrollView.getPullRootView().findViewById(R.id.mine_fun_payback);
        mineFunEvaluate = (TextView) pullScrollView.getPullRootView().findViewById(R.id.mine_fun_evaluate);

        mineHistory = (TextView) pullScrollView.getPullRootView().findViewById(R.id.mine_history);
        mineGoodsFavor = (TextView) pullScrollView.getPullRootView().findViewById(R.id.mine_goods_favor);
        mineTicket = (TextView) pullScrollView.getPullRootView().findViewById(R.id.mine_ticket);
        mineAddress = (TextView) pullScrollView.getPullRootView().findViewById(R.id.mine_address);

//        mTBoardBottom = (LinearLayout) pullScrollView.getPullRootView().findViewById(R.id.m_t_board_bottom);
        contentContainer = (LinearLayout) pullScrollView.getPullRootView().findViewById(R.id.content_container);
        mTxtUserName = (TextView) pullScrollView.getPullRootView().findViewById(R.id.txt_username);


//        bankNoTv = (TextView) pullScrollView.getPullRootView().findViewById(R.id.mine_hb_bankno_tv);
//        availableMoneyTv = (TextView) pullScrollView.getPullRootView().findViewById(R.id.mine_hb_availablemoney_tv);
//        frozenMoneyTv = (TextView) pullScrollView.getPullRootView().findViewById(R.id.mine_hb_frozenmoney_tv);

        imgHead = (CircleImageView) pullScrollView.getPullRootView().findViewById(R.id.img_head);

        mineFunAllOrder.setOnClickListener(this);
        mineFunWaitPay.setOnClickListener(this);
        mineFunWaitReceive.setOnClickListener(this);
        mineFunPayback.setOnClickListener(this);
        mineFunEvaluate.setOnClickListener(this);

        mineHistory.setOnClickListener(this);
        mineGoodsFavor.setOnClickListener(this);
        mineTicket.setOnClickListener(this);
        mineAddress.setOnClickListener(this);

        mTxtUserName.setOnClickListener(this);
        imgHead.setOnClickListener(this);
        pullScrollView.getPullRootView().findViewById(R.id.mine_tt_settings_iv).setOnClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

//    private void loadMineData() {
//
//        HashMap<String, Object> param = new Param();
//        param.put("token", App.getInstance().getToken());
//        mHttpHelper.get(Contants.API.MINE, param, new SpotsCallBack<MineMsg>(getActivity()) {
//
//
//            @Override
//            public void onSuccess(Response response, MineMsg respMsg) {
//                if (respMsg != null && respMsg.getStatus().equals(BaseRespMsg.STATUS_SUCCESS)) {
//                    MineMsg.Result result = respMsg.getResult();
//                    Utils.bindStrText(bankNoTv, result.getBrankcount() + "");
//                    Utils.bindStrText(availableMoneyTv, result.getAccount().getAvailablePrice() + "");
//                    Utils.bindStrText(frozenMoneyTv, result.getAccount().getFrozenPrice() + "");
//                } else {
//                    showNormalErr(respMsg);
//                }
//            }
//
//            @Override
//            public void onError(Response response, int code, Exception e) {
//                showFail();
//            }
//
//            @Override
//            public void onServerError(Response response, int code, String errmsg) {
//                ToastUtils.show(errmsg);
//            }
//        });
//
//
//    }
}
