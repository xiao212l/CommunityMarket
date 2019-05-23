package pv.com.pvcloudgo.model.bean;

import java.util.List;

public class payMessageBean {
    /**
     * status : 10001
     * message : 下单成功
     * data : {"orderNo":29,"nickname":"hanson18","avatar":"","shippingVo":{"id":1,"userId":1,"receiverName":"BeautifulSoup","receiverPhone":"17864195333","receiverProvince":"山东省","receiverCity":"济南市","receiverDistrict":"长清区","receiverAddress":"山东省济南市长清区崮云湖街道山东师范大学","receiverZip":"250358"},"payment":23940,"status":3,"paymentTime":1553742384119,"sendTime":1553742384119,"orderItems":[{"productId":1,"productName":"长虹 55D2P 黑色","productImage":""}]}
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
         * orderNo : 29
         * nickname : hanson18
         * avatar :
         * shippingVo : {"id":1,"userId":1,"receiverName":"BeautifulSoup","receiverPhone":"17864195333","receiverProvince":"山东省","receiverCity":"济南市","receiverDistrict":"长清区","receiverAddress":"山东省济南市长清区崮云湖街道山东师范大学","receiverZip":"250358"}
         * payment : 23940
         * status : 3
         * paymentTime : 1553742384119
         * sendTime : 1553742384119
         * orderItems : [{"productId":1,"productName":"长虹 55D2P 黑色","productImage":""}]
         */

        private int orderNo;
        private String nickname;
        private String avatar;
        private ShippingVoBean shippingVo;
        private int payment;
        private int status;
        private long paymentTime;
        private long sendTime;
        private List<OrderItemsBean> orderItems;

        public int getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(int orderNo) {
            this.orderNo = orderNo;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public ShippingVoBean getShippingVo() {
            return shippingVo;
        }

        public void setShippingVo(ShippingVoBean shippingVo) {
            this.shippingVo = shippingVo;
        }

        public int getPayment() {
            return payment;
        }

        public void setPayment(int payment) {
            this.payment = payment;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public long getPaymentTime() {
            return paymentTime;
        }

        public void setPaymentTime(long paymentTime) {
            this.paymentTime = paymentTime;
        }

        public long getSendTime() {
            return sendTime;
        }

        public void setSendTime(long sendTime) {
            this.sendTime = sendTime;
        }

        public List<OrderItemsBean> getOrderItems() {
            return orderItems;
        }

        public void setOrderItems(List<OrderItemsBean> orderItems) {
            this.orderItems = orderItems;
        }

        public static class ShippingVoBean {
            /**
             * id : 1
             * userId : 1
             * receiverName : BeautifulSoup
             * receiverPhone : 17864195333
             * receiverProvince : 山东省
             * receiverCity : 济南市
             * receiverDistrict : 长清区
             * receiverAddress : 山东省济南市长清区崮云湖街道山东师范大学
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

        public static class OrderItemsBean {
            /**
             * productId : 1
             * productName : 长虹 55D2P 黑色
             * productImage :
             */

            private int productId;
            private String productName;
            private String productImage;

            public int getProductId() {
                return productId;
            }

            public void setProductId(int productId) {
                this.productId = productId;
            }

            public String getProductName() {
                return productName;
            }

            public void setProductName(String productName) {
                this.productName = productName;
            }

            public String getProductImage() {
                return productImage;
            }

            public void setProductImage(String productImage) {
                this.productImage = productImage;
            }
        }
    }
}
