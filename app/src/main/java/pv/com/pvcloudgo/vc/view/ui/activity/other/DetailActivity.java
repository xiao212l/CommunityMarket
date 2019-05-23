package pv.com.pvcloudgo.vc.view.ui.activity.other;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gxz.PagerSlidingTabStrip;
import com.squareup.okhttp.Response;

import pv.com.pvcloudgo.app.App;
import pv.com.pvcloudgo.http.OkHttpHelper;
import pv.com.pvcloudgo.http.SpotsCallBack;
import pv.com.pvcloudgo.model.bean.CartBean;
import pv.com.pvcloudgo.model.bean.addCartMessageBean;
import pv.com.pvcloudgo.model.bean.commentMessageBean;
import pv.com.pvcloudgo.model.bean.commentPublishBean;
import pv.com.pvcloudgo.model.bean.goodsDetailMessageBean;
import pv.com.pvcloudgo.model.bean.shareBillMessageBean;
import pv.com.pvcloudgo.utils.Contants;
import pv.com.pvcloudgo.utils.ToastUtil;
import pv.com.pvcloudgo.utils.ToastUtils;
import pv.com.pvcloudgo.vc.adapter.CartRecyclerViewAdapter;
import pv.com.pvcloudgo.vc.adapter.CommentRecyclerViewAdapter;
import pv.com.pvcloudgo.vc.adapter.ItemTitlePagerAdapter;
import pv.com.pvcloudgo.vc.adapter.ShareBillRecyclerViewAdapter;
import pv.com.pvcloudgo.vc.base.BaseActivity;
import pv.com.pvcloudgo.vc.view.ui.activity.order.CreateBuyOnlyActivity;
import pv.com.pvcloudgo.vc.view.ui.activity.order.CreateOrderActivity;
import pv.com.pvcloudgo.vc.view.ui.activity.order.CreateShareActivity;
import pv.com.pvcloudgo.vc.view.ui.fragment.GoodsCommentFragment;
import pv.com.pvcloudgo.vc.view.ui.fragment.GoodsDetailFragment;
import pv.com.pvcloudgo.vc.view.ui.fragment.GoodsDetailWebFragment;
import pv.com.pvcloudgo.vc.view.ui.fragment.GoodsInfoFragment;
import pv.com.pvcloudgo.vc.widget.NoScrollViewPager;

import pv.com.pvcloudgo.R;
import pv.com.pvcloudgo.vc.widget.SelectPicPopupWindow;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetailActivity extends BaseActivity {
    public static int type = 1;
    public PagerSlidingTabStrip psts_tabs;
    public NoScrollViewPager vp_content;
    public TextView tv_title;
    public Button buy_only, share_bill;
    public TextView add_cart_text, good, meh, bad;
    public ImageView add_cart;
    public EditText comment_text;
    public int id;
    private int positionMark = 0;

    private Context context;

    private View selectView;
    private LayoutInflater inflater;

    AlertDialog.Builder builder;
    AlertDialog selectDialog;

    RecyclerView recyclerView,recyclerview;

    OkHttpHelper HttpHelper = new OkHttpHelper();

    SelectPicPopupWindow menuWindow;

    private List<Fragment> fragmentList = new ArrayList<>();
    private GoodsInfoFragment goodsInfoFragment;
    private GoodsDetailWebFragment goodsDetailFragment;
    private GoodsCommentFragment goodsCommentFragment;

    private CommentRecyclerViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle bundle = this.getIntent().getExtras();
        type = bundle.getInt("position");

        psts_tabs = (PagerSlidingTabStrip) findViewById(R.id.psts_tabs);
        vp_content = (NoScrollViewPager) findViewById(R.id.vp_content);
        tv_title = (TextView) findViewById(R.id.tv_title);
        buy_only = (Button) findViewById(R.id.buy_only);
        share_bill = (Button) findViewById(R.id.share_bill);
        add_cart = (ImageView) findViewById(R.id.add_cart);
        add_cart_text = (TextView) findViewById(R.id.add_cart_text);
        comment_text = (EditText) findViewById(R.id.comment);

        fragmentList.add(goodsInfoFragment = new GoodsInfoFragment());
        fragmentList.add(goodsDetailFragment = new GoodsDetailWebFragment());
        fragmentList.add(goodsCommentFragment = new GoodsCommentFragment());
        vp_content.setAdapter(new ItemTitlePagerAdapter(getSupportFragmentManager(),
                fragmentList, new String[]{"商品", "详情", "评价"}));
        vp_content.setOffscreenPageLimit(3);
        psts_tabs.setViewPager(vp_content);


        vp_content.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            //页面被滑动,或者被触碰的时候被调用
            @Override
            public void onPageScrolled(int a, float b, int c) {
            }

            //一个新的页面被选中时调用
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        positionMark = 0;
                        add_cart.setBackgroundDrawable(getResources().getDrawable(R.drawable.add_cart));
                        add_cart_text.setText("购物车");
                        buy_only.setVisibility(View.VISIBLE);
                        comment_text.setVisibility(View.INVISIBLE);
                        share_bill.setText("拼单");
                        break;
                    case 1:
                        positionMark = 1;
                        add_cart.setBackgroundDrawable(getResources().getDrawable(R.drawable.add_cart));
                        buy_only.setVisibility(View.VISIBLE);
                        add_cart_text.setText("购物车");
                        comment_text.setVisibility(View.INVISIBLE);
                        share_bill.setText("拼单");
                        break;
                    case 2:
                        positionMark = 2;
                        add_cart.setBackgroundDrawable(getResources().getDrawable(R.drawable.icon_grid_32));
                        add_cart_text.setText("写评论");
                        buy_only.setVisibility(View.INVISIBLE);
                        comment_text.setVisibility(View.VISIBLE);
                        share_bill.setText("评论");
                        break;

                }


            }

            @Override
            public void onPageScrollStateChanged(int d) {
            }
        });


        add_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (positionMark) {


                    case 0:
                        if (GoodsInfoFragment.selectData[0] != 0) {

                            int skuId = GoodsInfoFragment.selectData[0];
                            int count = GoodsInfoFragment.selectData[1];

                            HttpHelper.Post(Contants.API.BASE_URL + "cart/add/" + skuId + "/" + count
                                    , App.getInstance().getToken(), new SpotsCallBack<addCartMessageBean>(v.getContext()) {
                                        @Override
                                        public void onSuccess(Response response, addCartMessageBean addCartBean) {
                                            if (addCartBean != null && addCartBean.getMessage().equals("商品添加购物车成功")) {
                                                ToastUtils.show("添加购物车成功！");
                                                finish();

                                            } else {
                                                ToastUtils.show("请求失败");

                                            }

                                        }

                                        @Override
                                        public void onError(Response response, int code, Exception e) {
                                            ToastUtils.show("请求失败");
                                        }

                                        @Override
                                        public void onServerError(Response response, int code, String errmsg) {
                                            ToastUtils.show("请求失败,服务器无响应");
                                        }
                                    });

                        } else {
                            ToastUtils.show("请选择型号数量！");
                        }
                        break;
                    case 2:
                        ShowWindow();
                    default:
                        break;
                }

            }
        });


        share_bill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                switch (positionMark) {


                    case 0:
                        if (GoodsInfoFragment.selectData[0] != 0) {
                            next(CreateShareActivity.class, type);

                        } else {
                            ToastUtils.show("请选择型号数量！");
                        }
                        break;
                    case 2:

                        showWindow();


                    default:
                        break;
                }


            }
        });


        buy_only.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                switch (positionMark) {


                    case 0:
                        if (GoodsInfoFragment.selectData[0] != 0) {
                            next(CreateBuyOnlyActivity.class, type);

                        } else {
                            ToastUtils.show("请选择型号数量！");
                        }

                    default:
                        break;
                }


            }
        });

    }

    public void next(Class cls, int data) {


        Intent intent = new Intent(DetailActivity.this, cls);
        intent.putExtra("position", data);

        startActivityForResult(intent, true, Contants.REQUEST_CODE);

    }



    public void GoToFragment(int position) {
        vp_content.setCurrentItem(position);
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
        menuWindow.showAtLocation(findViewById(R.id.detail),
                Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
    }


    public void showWindow() {
        {
            int i = 0;
            inflater = getLayoutInflater();

            selectView = inflater.inflate(R.layout.select_comment_type_dialog, null);
            good = (TextView) selectView.findViewById(R.id.good);
            meh = (TextView) selectView.findViewById(R.id.meh);
            bad = (TextView) selectView.findViewById(R.id.bad);


            good.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OKComment(1);
                    selectDialog.dismiss();
                }
            });

            meh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OKComment(2);
                    selectDialog.dismiss();
                }
            });


            bad.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OKComment(3);
                    selectDialog.dismiss();
                }
            });
            builder = new AlertDialog.Builder(this);

            //通过布局填充器获login_layout
            //获取两个文本编辑框（密码这里不做登陆实现，仅演示）

            builder.setView(selectView);//设置login_layout为对话提示框

//                            builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialogInterface, int i) {
//
//                                }
//                            });

            builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            selectDialog = builder.show();

        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        refData();



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
//                    Glide.with(this).load(data.getData()).into(add_cart);
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
            ToastUtils.show(photo.toString());
            add_cart.setImageDrawable(drawable);

//            File urlpath = FileUtil.saveFile(mContext, "temphead.jpg", photo);

        }
    }


    public void OKComment(int commentType) {


        if (GoodsInfoFragment.selectData[0] != 0) {


            String json = "{\n" +
                    "\"content\":\"" + comment_text.getText().toString() + "\",\n" +
                    "\"imageUrl\":\"" + "\",\n" +
                    "\"skuId\":\"" + GoodsInfoFragment.selectData[0] + "\",\n" +
                    "\"type\":\"" + commentType + "\"\n}";

            //  comment_text.getText().toString();


            HttpHelper.Post(Contants.API.BASE_URL + "evaluation/publish",json
                    , App.getInstance().getToken(), new SpotsCallBack<commentPublishBean>(this) {
                        @Override
                        public void onSuccess(Response response, commentPublishBean commentBean) {
                            if (commentBean != null && commentBean.getMessage().equals("发表评价成功")) {
                                ToastUtils.show("发表评价成功！");

                                refData();

                            } else {
                                ToastUtils.show(commentBean.getMessage());

                            }

                        }

                        @Override
                        public void onError(Response response, int code, Exception e) {
                            ToastUtils.show("请求失败");
                        }

                        @Override
                        public void onServerError(Response response, int code, String errmsg) {
                            ToastUtils.show("请求失败,服务器无响应");
                        }
                    });

        }


    }


    public void refData() {

        recyclerView = (RecyclerView) findViewById(R.id.comment_list_total);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        recyclerview = (RecyclerView) findViewById(R.id.comment_list);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setHasFixedSize(true);

        mHttpHelper.Get(Contants.API.BASE_URL + "evaluation/listall/" + type + "?pageNum=1"
                , App.getInstance().getToken(), new SpotsCallBack<commentMessageBean>(this) {
                    @Override
                    public void onSuccess(Response response, commentMessageBean commentBean) {
                        if (commentBean != null && commentBean.getMessage().equals("获取商品评价成功")) {
                            List<commentMessageBean.DataBean> goodlist = new ArrayList<commentMessageBean.DataBean>();
                            refSetAdapter(commentBean.getData(),recyclerView);
                            if (commentBean.getData() != null) {
                                for (int i = 0; i < 3 && i < commentBean.getData().size(); i++) {
                                    goodlist.add(commentBean.getData().get(i));
                                }
                                refSetAdapter(goodlist,recyclerview);
                            }

                        } else {
                            ToastUtils.show("请求失败");
                        }

                    }

                    @Override
                    public void onError(Response response, int code, Exception e) {
                        ToastUtils.show("请求失败");
                    }

                    @Override
                    public void onServerError(Response response, int code, String errmsg) {
                        ToastUtils.show("请求失败,服务器无响应");
                    }
                });


    }

    public void refSetAdapter( List<commentMessageBean.DataBean> goodlist,RecyclerView recyclerView){
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CommentRecyclerViewAdapter adapter = new CommentRecyclerViewAdapter(this, goodlist,this);
        recyclerView.setAdapter(adapter);
    }




}