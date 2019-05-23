package pv.com.pvcloudgo.model.bean;

public class SignInBean {


    /**
     * status : 10001
     * message : 用户注册成功
     * data : {"id":14,"nickname":"Leona","signUp":1552879612505}
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
         * id : 14
         * nickname : Leona
         * signUp : 1552879612505
         */

        private int id;
        private String nickname;
        private long signUp;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public long getSignUp() {
            return signUp;
        }

        public void setSignUp(long signUp) {
            this.signUp = signUp;
        }
    }
}
