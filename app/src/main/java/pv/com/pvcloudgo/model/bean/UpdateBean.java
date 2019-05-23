package pv.com.pvcloudgo.model.bean;

public class UpdateBean {
    /**
     * status : 2
     * message : 请求成功
     * data : {"id":2,"username":"王小灏","integral":100,"gender":"male","birthday":1549296000000,"profileImg":"http://pmt5ma5mu.bkt.clouddn.com/34a19b7f-7b6a-4710-9431-01d3279277cd.jpg","motto":"6666666","email":"beautifulsoup@163.com"}
     */

    private int status;
    private String message;
    private User data;

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

    public User getData() {
        return data;
    }

    public void setData(User data) {
        this.data = data;
    }


}
