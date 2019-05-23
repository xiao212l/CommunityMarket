package pv.com.pvcloudgo.vc.view.ui.activity.mine;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.facebook.common.file.FileUtils;
import com.facebook.drawee.view.DraweeView;
import com.squareup.okhttp.Response;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import butterknife.Bind;
import butterknife.ButterKnife;
import pv.com.pvcloudgo.model.bean.LoginBean;
import pv.com.pvcloudgo.model.bean.addressCreateBean;
import pv.com.pvcloudgo.model.bean.uploadFileBean;
import pv.com.pvcloudgo.utils.Contants;
import pv.com.pvcloudgo.utils.ToastUtils;
import pv.com.pvcloudgo.vc.base.BaseActivity;
import pv.com.pvcloudgo.R;
import pv.com.pvcloudgo.app.App;
import pv.com.pvcloudgo.model.bean.User;
import pv.com.pvcloudgo.http.SpotsCallBack;
import pv.com.pvcloudgo.utils.Utils;
import pv.com.pvcloudgo.vc.view.ui.activity.start.UpdateUserInfoActivity;
import pv.com.pvcloudgo.vc.widget.SelectPicPopupWindow;

public class PersonalInfoActivity extends BaseActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.toolbar_title)
    TextView toolbarTitle;
    @Bind(R.id.toolbar_left_logo)
    ImageView toolbarLeftLogo;
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
    @Bind(R.id.user_avater)
    DraweeView userAvater;
    @Bind(R.id.user_avater_update)
    ImageView avaterUpdateButton;
    @Bind(R.id.user_update)
    Button updateButton;
    @Bind(R.id.user_nickname_tv)
    TextView userNicknameTv;
    @Bind(R.id.user_email_tv)
    TextView userEmailTv;
    @Bind(R.id.user_sex_tv)
    TextView userSexTv;
    @Bind(R.id.user_birth_tv)
    TextView userBirthTv;
    @Bind(R.id.user_phone_tv)
    TextView userWorkTv;
    @Bind(R.id.user_motto_tv)
    TextView userMottoTv;

    SelectPicPopupWindow menuWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalinfo);
        ButterKnife.bind(this);

        initToolBar();

        bindData();
    }

    private void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbarTitle = (TextView) findViewById(R.id.toolbar_title);
        setupToolbar(toolbar, true);

        toolbarTitle.setText("个人信息");

    }

    private void bindData() {
        User user = App.getInstance().getUser();
        if (user == null) return;
        if (user.getProfileImg() != null) {
            Glide.with(this).load(user.getProfileImg()).into(userAvater);
        }

        Utils.bindStrText(userNicknameTv, user.getNickname());
        Utils.bindStrText(userEmailTv, user.getEmail() == null ? "未设置" : user.getEmail());
        Utils.bindStrText(userSexTv, user.getGender() == null ? "未设置" : (user.getGender().equals("male") ? "男" : "女"));
        Utils.bindStrText(userBirthTv, user.getBirthday() == null ? "未设置" : user.getBirthday());
        Utils.bindStrText(userWorkTv, user.getPhone() == null ? "未设置" : user.getPhone());
        Utils.bindStrText(userMottoTv, user.getMotto() == null ? "未设置" : user.getMotto());

        updateButton.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                next(UpdateUserInfoActivity.class);

                                            }
                                        }
        );

        avaterUpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowWindow();


            }
        });

//        receipLl.setOnClickListener(v ->);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();
    }

    public void next(Class cls) {

        Intent intent = new Intent(this, cls);

        startActivity(intent);

        this.finish();
    }

    public void ShowWindow() {
        menuWindow = new SelectPicPopupWindow(this, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuWindow.dismiss();
                switch (v.getId()) {
                    case R.id.btn_take_photo:
                        ToastUtils.show("拍照---");

                        Intent takeIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                        //下面这句指定调用相机拍照后的照片存储的路径
                        takeIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                                Uri.fromFile(new File(Environment.getExternalStorageDirectory(), "userHead")));
                        startActivityForResult(takeIntent, 1);
                        break;
                    case R.id.btn_pick_photo:
                        ToastUtils.show("选择");
                        break;
                    case R.id.btn_cancel:
                        menuWindow.dismiss();
                    default:
                        break;
                }
            }
        });
        menuWindow.showAtLocation(findViewById(R.id.personalinfo),
                Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode) {
            case 2:// 直接从相册获取
                try {
                    startPhotoZoom(data.getData());
                } catch (NullPointerException e) {
                    e.printStackTrace();// 用户点击取消操作
                }
                break;
            case 1:// 调用相机拍照
                try {
                    File temp = new File(Environment.getExternalStorageDirectory() + "/" + "userHead");
                    startPhotoZoom(Uri.fromFile(temp));
                } catch (NullPointerException e) {
                    e.printStackTrace();// 用户点击取消操作
                }

                break;
            case 3:// 取得裁剪后的图片
                if (data != null) {
//                    Glide.with(this).load(data.getData()).into(userAvater);
                    setPicToView(data);
                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void startPhotoZoom(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/png");
        // crop=true是设置在开启的Intent中设置显示的VIEW可裁剪
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 300);
        intent.putExtra("outputY", 300);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, 3);
    }

    private void setPicToView(Intent picdata) {
        Bundle extras = picdata.getExtras();
        if (extras != null) {
            // 取得SDCard图片路径做显示
            Bitmap photo = extras.getParcelable("data");
            Drawable drawable = new BitmapDrawable(null, photo);
//            userAvater.setImageDrawable(drawable);


            updateAvater(saveBitmapFile(photo));
            Glide.with(this).load(saveBitmapFile(photo)).into(userAvater);
        }
    }


    public void updateAvater(File file) {

        mHttpHelper.PostImage(Contants.API.BASE_URL + "file/uploads", file, App.getInstance().getToken(), new SpotsCallBack<uploadFileBean>(this) {

            @Override
            public void onSuccess(Response response, uploadFileBean uploadFileBean) {
                if (uploadFileBean != null && uploadFileBean.getMessage().equals("图片上传成功")) {
                    ToastUtils.show("图片上传成功");

                }
            }

            @Override
            public void onError(Response response, int code, Exception e) {
                ToastUtils.show("上传出错！");
            }

            @Override
            public void onServerError(Response response, int code, String errmsg) {
                ToastUtils.show("图片上传出错！服务器出错");
            }
        });
    }


    public File saveBitmapFile(Bitmap bitmap)

    {
        File file = new File(Environment.getExternalStorageDirectory() + "/temp");//将要保存图片的路径
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            bos.flush();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ToastUtils.show(file.toString());
        return file;
    }


}
