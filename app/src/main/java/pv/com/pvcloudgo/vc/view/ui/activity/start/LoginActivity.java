package pv.com.pvcloudgo.vc.view.ui.activity.start;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okio.BufferedSink;
import pv.com.pvcloudgo.R;
import pv.com.pvcloudgo.app.App;
import pv.com.pvcloudgo.model.bean.LoginBean;
import pv.com.pvcloudgo.model.bean.Param;
import pv.com.pvcloudgo.model.bean.User;
import pv.com.pvcloudgo.http.SpotsCallBack;
import pv.com.pvcloudgo.model.bean.UserInfoBean;
import pv.com.pvcloudgo.utils.Contants;
import pv.com.pvcloudgo.utils.JSONUtil;
import pv.com.pvcloudgo.utils.ToastUtil;
import pv.com.pvcloudgo.utils.ToastUtils;
import pv.com.pvcloudgo.vc.base.BaseActivity;
import pv.com.pvcloudgo.vc.widget.ClearEditText;

public class LoginActivity extends BaseActivity {

    String Token = "";
    Handler mHandler;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;
    @Bind(R.id.toolbar_logo)
    ImageView toolbarLogo;
    @Bind(R.id.toolbar_left_title)
    TextView toolbarLeftTitle;
    @Bind(R.id.toolbar_right_title)
    TextView toolbarRightTitle;
    @Bind(R.id.image_right)
    ImageView imageRight;
    @Bind(R.id.image_exit)
    ImageView imageExit;
    @Bind(R.id.etxt_phone)
    ClearEditText mEtxtPhone;
    @Bind(R.id.etxt_pwd)
    ClearEditText mEtxtPwd;
    @Bind(R.id.txt_toReg)
    TextView txtToReg;
    @Bind(R.id.find_pass_tv)
    TextView findPassTv;
    @Bind(R.id.btn_login)
    Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);



        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 1:
                        String Token = msg.getData().getString("token");
                        getUserData(Token);

                        break;
                    default:
                        break;
                }
            }
        };

        initToolBar();

        txtToReg.setOnClickListener(view -> startActivity(new Intent(LoginActivity.this, RegActivity.class)));
        findPassTv.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, FindPassActivity.class)));
    }


    private void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbarTitle = (TextView) findViewById(R.id.toolbar_title);
        setupToolbar(toolbar, true);

        toolbarTitle.setText("登录");

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();
    }

    @OnClick(R.id.btn_login)
    public void login(View view) {
        App.getInstance().clearUser();



        new Thread(new Runnable() {
            @Override
            public void run() {
                getToken();

            }
        }).start();


    }


    public static String getJson(Context context, String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        //获得assets资源管理器
        AssetManager assetManager = context.getAssets();
        //使用IO流读取json文件内容
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    assetManager.open(fileName), "utf-8"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }


    public void getUserData(String Token) {
        mHttpHelper.Get(Contants.API.BASE_URL+"user/find"
                , Token, new SpotsCallBack<UserInfoBean>(this) {
                    @Override
                    public void onSuccess(Response response, UserInfoBean UserInfoBean) {
                        if (UserInfoBean != null && UserInfoBean.getMessage().equals("请求成功")) {

                            ToastUtils.show(UserInfoBean.getMessage());

                            App application = App.getInstance();

                            application.putUser(UserInfoBean.getData().getBase_info(), Token);
                            setResult(RESULT_OK);
                            finish();

                        } else {
                            ToastUtils.show(UserInfoBean.getMessage());
                        }

                    }

                    @Override
                    public void onError(Response response, int code, Exception e) {
                        ToastUtils.show("出错，无法获取用户信息");
                    }

                    @Override
                    public void onServerError(Response response, int code, String errmsg) {
                        ToastUtils.show("服务器出错");
                    }


                    @Override
                    public void onTokenError(Response response, int code) {
                        Log.w("CODE", "" + code);

                    }
                });
    }

    public void getToken() {

        App.getInstance().clearUser();
        String phone = mEtxtPhone.getText().toString().trim();
        if (TextUtils.isEmpty(phone)) {
            ToastUtils.show(this, "请输入手机号码");
            return;
        }

        String pwd = mEtxtPwd.getText().toString().trim();
        if (TextUtils.isEmpty(pwd)) {
            ToastUtils.show(this, "请输入密码");
            return;
        }


        OkHttpClient Client = new OkHttpClient();
        Request request = new Request.Builder().url(Contants.API.BASE_URL+"user/login?nickname=" + phone + "&password=" + pwd).post(new RequestBody() {
            @Override
            public MediaType contentType() {
                return null;
            }

            @Override
            public void writeTo(BufferedSink sink) throws IOException {

            }
        }).build();
        Client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                ToastUtils.show("登录失败！");
            }

            @Override
            public void onResponse(Response response) throws IOException {

                LoginBean loginBean = JSONUtil.fromJson(response.body().string(), LoginBean.class);
                if (loginBean != null && loginBean.getMessage().equals("用户登录成功")) {

                    ToastUtils.show("登录成功 ");
                    Message msg = new Message();
                    msg.what = 1;
                    Bundle bundle = new Bundle();
                    bundle.putString("token", loginBean.getData().getAuthorization());
                    msg.setData(bundle);
                    mHandler.sendMessage(msg);

                } else {
                    ToastUtils.show(loginBean.getMessage());
                }
            }
        });

    }


}
