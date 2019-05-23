package pv.com.pvcloudgo.model.bean;

public class addressCreateBean {
    /**
     * status : 10001
     * message : 订单创建成功
     * data : {"id":3,"userId":44,"receiverName":"hanson24","receiverPhone":"17864195311","receiverProvince":"山东省","receiverCity":"济南市","receiverDistrict":"长清区","receiverAddress":"山东省济南市长清区山东师范大学","receiverZip":"250358"}
     */

    private int status;
    private String message;
    private addressBean data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public addressBean getData() {
        return data;
    }

    public void setData(addressBean data) {
        this.data = data;
    }


}
