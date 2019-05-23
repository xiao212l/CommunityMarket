package pv.com.pvcloudgo.model.bean;

public class LogoutBean {

    /**
     * status : 200
     * message : 用户登出成功
     */

    private int status;
    private String message;

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
}
