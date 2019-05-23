package pv.com.pvcloudgo.model.bean;

public class deleteAddressBean {
    /**
     * status : 10001
     * message : 删除成功
     * data : {"id":3,"userId":44,"receiverName":"hanson24","receiverPhone":"17864195311","receiverProvince":"山东省","receiverCity":"济南市","receiverDistrict":"长清区","receiverAddress":"山东省济南市长清区山东师范大学","receiverZip":"250358"}
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
         * id : 3
         * userId : 44
         * receiverName : hanson24
         * receiverPhone : 17864195311
         * receiverProvince : 山东省
         * receiverCity : 济南市
         * receiverDistrict : 长清区
         * receiverAddress : 山东省济南市长清区山东师范大学
         * receiverZip : 250358
         */

        private int id;
        private int userId;
        private String receiverName;
        private String receiverPhone;
        private String receiverProvince;
        private String receiverCity;
        private String receiverDistrict;
        private String receiverAddress;
        private String receiverZip;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getReceiverName() {
            return receiverName;
        }

        public void setReceiverName(String receiverName) {
            this.receiverName = receiverName;
        }

        public String getReceiverPhone() {
            return receiverPhone;
        }

        public void setReceiverPhone(String receiverPhone) {
            this.receiverPhone = receiverPhone;
        }

        public String getReceiverProvince() {
            return receiverProvince;
        }

        public void setReceiverProvince(String receiverProvince) {
            this.receiverProvince = receiverProvince;
        }

        public String getReceiverCity() {
            return receiverCity;
        }

        public void setReceiverCity(String receiverCity) {
            this.receiverCity = receiverCity;
        }

        public String getReceiverDistrict() {
            return receiverDistrict;
        }

        public void setReceiverDistrict(String receiverDistrict) {
            this.receiverDistrict = receiverDistrict;
        }

        public String getReceiverAddress() {
            return receiverAddress;
        }

        public void setReceiverAddress(String receiverAddress) {
            this.receiverAddress = receiverAddress;
        }

        public String getReceiverZip() {
            return receiverZip;
        }

        public void setReceiverZip(String receiverZip) {
            this.receiverZip = receiverZip;
        }
    }
}
