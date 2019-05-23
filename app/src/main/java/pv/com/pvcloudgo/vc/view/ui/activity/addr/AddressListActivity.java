package pv.com.pvcloudgo.vc.view.ui.activity.addr;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.okhttp.Response;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import pv.com.pvcloudgo.R;
import pv.com.pvcloudgo.model.bean.addressBean;
import pv.com.pvcloudgo.model.bean.addressMessageBean;
import pv.com.pvcloudgo.model.bean.commentMessageBean;
import pv.com.pvcloudgo.vc.adapter.AddressAdapter;
import pv.com.pvcloudgo.vc.adapter.CommentRecyclerViewAdapter;
import pv.com.pvcloudgo.vc.adapter.decoration.DividerItemDecoration;
import pv.com.pvcloudgo.app.App;
import pv.com.pvcloudgo.model.bean.Address;
import pv.com.pvcloudgo.http.SpotsCallBack;
import pv.com.pvcloudgo.model.base.BaseRespMsg;
import pv.com.pvcloudgo.utils.Contants;
import pv.com.pvcloudgo.utils.ToastUtils;
import pv.com.pvcloudgo.vc.base.BaseActivity;
import pv.com.pvcloudgo.vc.widget.PVToolBar;


public class AddressListActivity extends BaseActivity {


    //    public static int id;
    public static addressBean addr;

    @Bind(R.id.toolbar)
     PVToolBar mToolBar;

    @Bind(R.id.recycler_view)
     RecyclerView mRecyclerview;

    @Bind(R.id.address_add)
    FloatingActionButton addButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_list);
        ButterKnife.bind(this);

        initToolbar();

        initAddress();


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toAddActivity();

            }
        });

    }


    private void initToolbar(){

        mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


    private void toAddActivity() {

        Intent intent = new Intent(this,AddressAddActivity.class);
        startActivityForResult(intent, Contants.REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        initAddress();
    }

    public void initAddress(){



        mHttpHelper.Get(Contants.API.BASE_URL +"shipping/listall", App.getInstance().getToken(), new SpotsCallBack<addressMessageBean>(this) {


            @Override
            public void onSuccess(Response response, addressMessageBean addressMessage) {
                List<addressBean> addresses = addressMessage.getData();
                showAddress(addresses);
            }

            @Override
            public void onError(Response response, int code, Exception e) {

            }

            @Override
            public void onServerError(Response response, int code, String errmsg) {

            }
        });
    }


    private void showAddress(List<addressBean> addresses) {


        AddressAdapter mAdapter = new AddressAdapter(this, addresses, new AddressAdapter.AddressLisneter() {
                @Override
                public void setDefault(addressBean address) {
//                    updateAddress(address);
                }

                @Override
                public void setDefault(Address address) {

                }

            },this);
            mRecyclerview.setAdapter(mAdapter);
            mRecyclerview.setLayoutManager(new LinearLayoutManager(AddressListActivity.this));
            mRecyclerview.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));



    }




}
