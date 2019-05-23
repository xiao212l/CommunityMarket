package pv.com.pvcloudgo.model.bean;

public class uploadFileBean {
    /**
     * status : 10001
     * message : 图片上传成功
     * data : http://47.95.244.237:8888/group1/M00/00/00/rBElLFyPFl-AaNFDAAAZFoy4-OY554.jpg,http://47.95.244.237:8888/group1/M00/00/00/rBElLFyPFmCAMFTMAAiQx3COPNA417.jpg
     */

    private int status;
    private String message;
    private String data;

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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
