package pv.com.pvcloudgo.vc.view.ui.activity.mine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.okhttp.Response;

import butterknife.Bind;
import butterknife.ButterKnife;
import pv.com.pvcloudgo.http.SpotsCallBack;
import pv.com.pvcloudgo.model.bean.LogoutBean;
import pv.com.pvcloudgo.utils.Contants;
import pv.com.pvcloudgo.vc.base.BaseActivity;
import pv.com.pvcloudgo.R;
import pv.com.pvcloudgo.app.App;
import pv.com.pvcloudgo.utils.ToastUtils;


public class SettingActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;
    @Bind(R.id.person_ll)
    LinearLayout personLl;
    @Bind(R.id.logout_btn)
    Button logoutBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);


        initToolBar();

        personLl.setOnClickListener(v -> startActivity(new Intent(mContext, PersonalInfoActivity.class)));
        logoutBtn.setOnClickListener(v -> logout(v));
    }


    private void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbarTitle = (TextView) findViewById(R.id.toolbar_title);
        setupToolbar(toolbar, true);

        toolbarTitle.setText("设置");

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();
    }

    public void logout(View view) {

//        App application = App.getInstance();
//        application.clearUser();
//        finish();
//        System.exit(0);
//        ToastUtils.show("注销成功！");


        mHttpHelper.Get(Contants.API.BASE_URL + "logout", App.getInstance().getToken(), new SpotsCallBack<LogoutBean>(this) {


                    @Override
                    public void onSuccess(Response response, LogoutBean LogoutBean) {
                        if (LogoutBean != null && LogoutBean.getMessage().equals("用户登出成功")) {
                            App application = App.getInstance();
                            application.clearUser();
                            setResult(RESULT_OK);
                            finish();
                            ToastUtils.show("用户登出成功！");


                        } else if (LogoutBean != null && LogoutBean.getMessage().equals("用户登出失败")) {
                            ToastUtils.show("登录状态失效，请重新登录");
                            App application = App.getInstance();
                            application.clearUser();
                            setResult(RESULT_OK);
                            finish();

                        }

                    }

                    @Override
                    public void onError(Response response, int code, Exception e) {
                        App application = App.getInstance();
                        application.clearUser();
                        setResult(RESULT_OK);
                        finish();

                    }

                    @Override
                    public void onServerError(Response response, int code, String errmsg) {
                        ToastUtils.show("服务器出错");
                        App application = App.getInstance();
                        application.clearUser();
                        setResult(RESULT_OK);
                        finish();

                    }

                }

        );


    }

}
