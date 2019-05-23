
package pv.com.pvcloudgo.model.msg;


import pv.com.pvcloudgo.model.base.BaseRespMsg;
import pv.com.pvcloudgo.model.bean.User;

public class LoginResp extends BaseRespMsg {

    Result results;


    public Result getResults() {
        return results;
    }


    public class Result {
        User data;
        private int status;
        private String message;

        public User getData() {
            return data;
        }

//        public String getToken() {
//            return token;
//        }

        public int getStatus() {
            return status;
        }

        public String getMessage() {
            return message;
        }


    }
}
