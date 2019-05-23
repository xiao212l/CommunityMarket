package pv.com.pvcloudgo.vc.view.ui.activity.start;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.squareup.okhttp.Response;

import java.util.Calendar;

import butterknife.Bind;
import butterknife.ButterKnife;
import pv.com.pvcloudgo.R;
import pv.com.pvcloudgo.app.App;
import pv.com.pvcloudgo.http.SpotsCallBack;
import pv.com.pvcloudgo.model.bean.LoginBean;
import pv.com.pvcloudgo.model.bean.UpdateBean;
import pv.com.pvcloudgo.model.bean.User;
import pv.com.pvcloudgo.utils.ToastUtils;
import pv.com.pvcloudgo.vc.base.BaseActivity;

public class UpdateUserInfoActivity extends BaseActivity {

    @Bind(R.id.update_email)
    TextView email;
    @Bind(R.id.update_id)
    TextView id;
    @Bind(R.id.update_motto)
    TextView motto;
    @Bind(R.id.update_phone)
    TextView phone;
    @Bind(R.id.update_sex)
    RadioGroup sex;
    @Bind(R.id.ensure)
    Button ensure;
    @Bind(R.id.update_date)
    TextView Date;
    @Bind(R.id.update_date_button)
    Button date;

    private Calendar calendar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatepersonalinfo);
        ButterKnife.bind(this);
        calendar = Calendar.getInstance();

        ensure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                onEnsure();
            }
        });

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onChooseDate();
            }
        });
    }

    public void onEnsure() {
        User user = App.getInstance().getUser();
        RadioButton choise = (RadioButton) findViewById(sex.getCheckedRadioButtonId());
        String json;
        if (choise != null) {
            json = "{\n" +
                    "\"username\":" + "\"" + user.getNickname() + "\"" + ",\n" +
                    "\"id\":" + user.getId() + ",\n" +
                    "\"password\":" + "\"" + user.getPassword() + "\"" +
                    (id.getText().toString().trim().isEmpty() ? "" : (",\n"+"\"idcard\":" + "\"" + id.getText().toString().trim() + "\"" )) +
                    (email.getText().toString().trim().isEmpty() ? "" : (",\n"+"\"email\":" + "\"" + email.getText().toString().trim() + "\"" )) +
                    (motto.getText().toString().trim().isEmpty() ? "" : (",\n"+"\"motto\":" + "\"" + motto.getText().toString().trim() + "\"" )) +
                    (phone.getText().toString().trim().isEmpty() ? "" : (",\n"+"\"phone\":" + "\"" + phone.getText().toString().trim() + "\"" ))+
                    "\",\n" +"\"gender\": \"" + (choise.getText().equals("男") ? "male" : "female") + "\"" +"\n" +
                    "}";
        } else {
            json = "{\n" +
                    "\"username\":" + "\"" + user.getNickname() + "\"" + ",\n" +
                    "\"id\":" + user.getId() + ",\n" +
                    "\"password\":" + "\"" + user.getPassword() + "\"" +
                    (id.getText().toString().trim().isEmpty() ? "" : ( ",\n"+"\"idcard\":" + "\"" + id.getText().toString().trim() + "\"" )) +
                    (email.getText().toString().trim().isEmpty() ? "" : ( ",\n"+"\"email\":" + "\"" + email.getText().toString().trim() + "\"" )) +
                    (motto.getText().toString().trim().isEmpty() ? "" : (",\n"+"\"motto\":" + "\"" + motto.getText().toString().trim() + "\""  )) +
                    (phone.getText().toString().trim().isEmpty() ? "" : (",\n"+"\"phone\":" + "\"" + phone.getText().toString().trim() + "\"" + "\n")) +
                    "}";

        }

        mHttpHelper.put("http://47.95.244.237:9990/chengfeng/per/updateinfo"
                , json, new SpotsCallBack<UpdateBean>(this) {
                    @Override
                    public void onSuccess(Response response, UpdateBean updateBean) {
                        if (updateBean != null && updateBean.getMessage().equals("请求成功")) {

                            ToastUtils.show("修改成功");
                            App application = App.getInstance();
                            setResult(RESULT_OK);
                            finish();

                        } else {
                            ToastUtils.show(updateBean.getMessage());
                        }


                    }

                    @Override
                    public void onError(Response response, int code, Exception e) {
                        ToastUtils.show(json);

                    }

                    @Override
                    public void onServerError(Response response, int code, String errmsg) {
                        ToastUtils.show(errmsg);
                    }
                });


    }

    public void onChooseDate() {

        new DatePickerDialog(this, AlertDialog.THEME_HOLO_LIGHT,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int month, int day) {
                        // TODO Auto-generated method stub
                        int mYear = year;
                        int mMonth = month;
                        int mDay = day;
                        // 更新EditText控件日期 小于10加0
                        Date.setText(new StringBuilder()
                                .append(mYear)
                                .append("-")
                                .append((mMonth + 1) < 10 ? "0"
                                        + (mMonth + 1) : (mMonth + 1))
                                .append("-")
                                .append((mDay < 10) ? "0" + mDay : mDay));
                    }
                }, calendar.get(Calendar.YEAR), calendar
                .get(Calendar.MONTH), calendar
                .get(Calendar.DAY_OF_MONTH)).show();
    }
}



