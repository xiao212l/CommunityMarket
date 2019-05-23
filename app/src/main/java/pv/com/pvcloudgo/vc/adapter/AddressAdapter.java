package pv.com.pvcloudgo.vc.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import com.squareup.okhttp.Response;

import java.util.List;

import pv.com.pvcloudgo.R;
import pv.com.pvcloudgo.app.App;
import pv.com.pvcloudgo.http.OkHttpHelper;
import pv.com.pvcloudgo.http.SpotsCallBack;
import pv.com.pvcloudgo.model.bean.Address;
import pv.com.pvcloudgo.model.bean.addressBean;
import pv.com.pvcloudgo.model.bean.addressMessageBean;
import pv.com.pvcloudgo.model.bean.deleteAddressBean;
import pv.com.pvcloudgo.utils.Contants;
import pv.com.pvcloudgo.utils.ToastUtils;
import pv.com.pvcloudgo.vc.view.ui.activity.addr.AddressListActivity;

import static android.app.Activity.RESULT_OK;


/**
 * Created by <a href="http://www.cniao5.com">菜鸟窝</a>
 * 一个专业的Android开发在线教育平台
 */
public class AddressAdapter extends SimpleAdapter<addressBean> {


    private Activity activity;
    private AddressLisneter lisneter;

    public AddressAdapter(Context context, List<addressBean> datas, AddressLisneter lisneter, Activity activity) {
        super(context, R.layout.template_address, datas);

        this.lisneter = lisneter;
        this.activity = activity;

    }


    @Override
    protected void convert(BaseViewHolder viewHoder, final addressBean item) {

        viewHoder.getTextView(R.id.txt_name).setText(item.getReceiverName());
        viewHoder.getTextView(R.id.txt_phone).setText(item.getReceiverPhone());
        viewHoder.getTextView(R.id.txt_province).setText(item.getReceiverProvince() == null ? "" : item.getReceiverProvince());
        viewHoder.getTextView(R.id.txt_city).setText(item.getReceiverCity() == null ? "" : item.getReceiverCity());
        viewHoder.getTextView(R.id.txt_district).setText(item.getReceiverDistrict() == null ? "" : item.getReceiverDistrict());
        viewHoder.getTextView(R.id.txt_address).setText(item.getReceiverAddress());

        viewHoder.getView(R.id.address).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //触发自定义监听的单击事件
                if (Activity.class.isInstance(v.getContext())) {
                    // 转化为activity，然后finish就行了
                    AddressListActivity.addr = item;
                    Activity activity = (Activity) v.getContext();
                    activity.setResult(RESULT_OK);
                    activity.finish();
                }
            }

        });

        viewHoder.getTextView(R.id.txt_del).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteAddress(item.getId());
            }
        });

//        viewHoder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //触发自定义监听的单击事件
//                switch (v.getId()){
//                    case R.id.txt_del:
//                        deleteAddress(item.getId());
//                        break;
//
//                        default:
//                            if (Activity.class.isInstance(v.getContext())) {
//                                // 转化为activity，然后finish就行了
//                                AddressListActivity.addr = item;
//                                Activity activity = (Activity) v.getContext();
//                                activity.setResult(RESULT_OK);
//                                activity.finish();
//                            }
//
//                            ToastUtils.show(""+v.getId());
//
//                            break;
//
//                }
//
//
//
//            }
//        });


    }


    public String replacePhoneNum(String phone) {

        return phone.substring(0, phone.length() - (phone.substring(3)).length()) + "****" + phone.substring(7);
    }


    public interface AddressLisneter {


        void setDefault(Address address);

        void setDefault(addressBean address);
    }

    public void deleteAddress(int addressId) {

        OkHttpHelper HttpHelper = new OkHttpHelper();
        HttpHelper.Delete(Contants.API.BASE_URL + "shipping/delete/" + addressId, App.getInstance().getToken(), new SpotsCallBack<deleteAddressBean>(activity) {


            @Override
            public void onSuccess(Response response, deleteAddressBean addressDeleteMessage) {
                ToastUtils.show(addressDeleteMessage.getMessage());
                ((AddressListActivity)activity).initAddress();
            }

            @Override
            public void onError(Response response, int code, Exception e) {
                ToastUtils.show("请求失败");
            }

            @Override
            public void onServerError(Response response, int code, String errmsg) {
                ToastUtils.show("请求失败，服务器已关闭");
            }
        });
    }


}




