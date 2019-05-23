package pv.com.pvcloudgo.model.bean;

public class LoginBean {

    /**
     * status : 10001
     * message : 用户登录成功
     * data : {"Authorization":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJsYXNoMSIsImlzcyI6ImF1dGgwIiwiZXhwIjoxNTUzNTc2MDQwLCJpYXQiOjE1NTM1NzI0NDB9.Ga66za23igQ_xJ2Ll0hN0VuuBXncV93H72p90aYKPAI"}
     */

    private int status;
    private String message;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * Authorization : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJsYXNoMSIsImlzcyI6ImF1dGgwIiwiZXhwIjoxNTUzNTc2MDQwLCJpYXQiOjE1NTM1NzI0NDB9.Ga66za23igQ_xJ2Ll0hN0VuuBXncV93H72p90aYKPAI
         */

        private String Authorization;

        public String getAuthorization() {
            return Authorization;
        }

        public void setAuthorization(String Authorization) {
            this.Authorization = Authorization;
        }
    }
}
