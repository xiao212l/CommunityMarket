package pv.com.pvcloudgo.model.bean;

import java.util.List;

public class BillListBean {

    /**
     * status : 10001
     * message : 订单获取成功
     * data : [{"orderNo":324,"nickname":"llash","avatar":"","payment":224,"status":3,"paymentTime":1558325293000,"sendTime":1558325293000,"orderItems":[{"productId":18,"productName":"寻天果蔬 泰国山竹 新鲜水果 中号","productImage":"http://hansonoss.oss-cn-beijing.aliyuncs.com/shop/main/23/5b487224N91b2287c.jpg%20(350%C3%97350).jpg"}]},{"orderNo":424,"nickname":"llash","avatar":"","payment":86,"status":3,"paymentTime":1558325293000,"sendTime":1558325293000,"orderItems":[{"productId":8,"productName":"寻天果蔬 泰国山竹 新鲜水果 小号","productImage":"http://hansonoss.oss-cn-beijing.aliyuncs.com/shop/main/23/5b487224N91b2287c.jpg%20(350%C3%97350).jpg"}]},{"orderNo":524,"nickname":"llash","avatar":"","payment":112,"status":3,"paymentTime":1558326069000,"sendTime":1558326069000,"orderItems":[{"productId":18,"productName":"寻天果蔬 泰国山竹 新鲜水果 中号","productImage":"http://hansonoss.oss-cn-beijing.aliyuncs.com/shop/main/23/5b487224N91b2287c.jpg%20(350%C3%97350).jpg"}]},{"orderNo":724,"nickname":"llash","avatar":"","payment":86,"status":3,"paymentTime":1558326906000,"sendTime":1558326906000,"orderItems":[{"productId":8,"productName":"寻天果蔬 泰国山竹 新鲜水果 小号","productImage":"http://hansonoss.oss-cn-beijing.aliyuncs.com/shop/main/23/5b487224N91b2287c.jpg%20(350%C3%97350).jpg"}]},{"orderNo":624,"nickname":"llash","avatar":"","payment":224,"status":3,"paymentTime":1558326906000,"sendTime":1558326906000,"orderItems":[{"productId":18,"productName":"寻天果蔬 泰国山竹 新鲜水果 中号","productImage":"http://hansonoss.oss-cn-beijing.aliyuncs.com/shop/main/23/5b487224N91b2287c.jpg%20(350%C3%97350).jpg"}]},{"orderNo":824,"nickname":"llash","avatar":"","payment":224,"status":3,"paymentTime":1558327139000,"sendTime":1558327139000,"orderItems":[{"productId":10,"productName":"陕西阎良甜瓜2斤装 蜜瓜香瓜 新疆产","productImage":"http://hansonoss.oss-cn-beijing.aliyuncs.com/shop/main/30/58f97392Ndb3c0d06.jpg%20(350%C3%97350).jpg"}]},{"orderNo":924,"nickname":"llash","avatar":"","payment":64,"status":3,"paymentTime":1558328108000,"sendTime":1558328108000,"orderItems":[{"productId":7,"productName":"杏花楼小笼汤包375g 小笼汤包","productImage":"http://hansonoss.oss-cn-beijing.aliyuncs.com/shop/main/35/dc96eeb66c71ee3d.jpg%20(350%C3%97350).jpg"}]},{"orderNo":927,"nickname":"llash","avatar":"","payment":75,"status":2,"paymentTime":1558335844000,"orderItems":[{"productId":7,"productName":"杏花楼小笼汤包375g 小笼汤包","productImage":"http://hansonoss.oss-cn-beijing.aliyuncs.com/shop/main/35/dc96eeb66c71ee3d.jpg%20(350%C3%97350).jpg"}]},{"orderNo":928,"nickname":"llash","avatar":"","payment":75,"status":2,"paymentTime":1558335944000,"orderItems":[{"productId":7,"productName":"杏花楼小笼汤包375g 小笼汤包","productImage":"http://hansonoss.oss-cn-beijing.aliyuncs.com/shop/main/35/dc96eeb66c71ee3d.jpg%20(350%C3%97350).jpg"}]},{"orderNo":932,"nickname":"llash","avatar":"","payment":50,"status":2,"paymentTime":1558337738000,"orderItems":[{"productId":7,"productName":"杏花楼小笼汤包375g 小笼汤包","productImage":"http://hansonoss.oss-cn-beijing.aliyuncs.com/shop/main/35/dc96eeb66c71ee3d.jpg%20(350%C3%97350).jpg"}]},{"orderNo":934,"nickname":"llash","avatar":"","payment":135,"status":2,"paymentTime":1558418384000,"orderItems":[{"productId":18,"productName":"寻天果蔬 泰国山竹 新鲜水果 中号","productImage":"http://hansonoss.oss-cn-beijing.aliyuncs.com/shop/main/23/5b487224N91b2287c.jpg%20(350%C3%97350).jpg"}]},{"orderNo":1035,"nickname":"llash","avatar":"","payment":45,"status":2,"paymentTime":1558419136000,"orderItems":[{"productId":18,"productName":"寻天果蔬 泰国山竹 新鲜水果 中号","productImage":"http://hansonoss.oss-cn-beijing.aliyuncs.com/shop/main/23/5b487224N91b2287c.jpg%20(350%C3%97350).jpg"}]},{"orderNo":1339,"nickname":"llash","avatar":"","payment":90,"status":2,"paymentTime":1558421114000,"orderItems":[{"productId":18,"productName":"寻天果蔬 泰国山竹 新鲜水果 中号","productImage":"http://hansonoss.oss-cn-beijing.aliyuncs.com/shop/main/23/5b487224N91b2287c.jpg%20(350%C3%97350).jpg"}]},{"orderNo":1340,"nickname":"llash","avatar":"","payment":180,"status":2,"paymentTime":1558421844000,"orderItems":[{"productId":18,"productName":"寻天果蔬 泰国山竹 新鲜水果 中号","productImage":"http://hansonoss.oss-cn-beijing.aliyuncs.com/shop/main/23/5b487224N91b2287c.jpg%20(350%C3%97350).jpg"}]},{"orderNo":1641,"nickname":"llash","avatar":"","payment":90,"status":2,"paymentTime":1558425230000,"orderItems":[{"productId":18,"productName":"寻天果蔬 泰国山竹 新鲜水果 中号","productImage":"http://hansonoss.oss-cn-beijing.aliyuncs.com/shop/main/23/5b487224N91b2287c.jpg%20(350%C3%97350).jpg"}]},{"orderNo":1842,"nickname":"llash","avatar":"","payment":135,"status":2,"paymentTime":1558431594000,"orderItems":[{"productId":18,"productName":"寻天果蔬 泰国山竹 新鲜水果 中号","productImage":"http://hansonoss.oss-cn-beijing.aliyuncs.com/shop/main/23/5b487224N91b2287c.jpg%20(350%C3%97350).jpg"}]},{"orderNo":1942,"nickname":"llash","avatar":"","payment":168,"status":3,"paymentTime":1558441103000,"sendTime":1558441103000,"orderItems":[{"productId":18,"productName":"寻天果蔬 泰国山竹 新鲜水果 中号","productImage":"http://hansonoss.oss-cn-beijing.aliyuncs.com/shop/main/23/5b487224N91b2287c.jpg%20(350%C3%97350).jpg"}]},{"orderNo":2042,"nickname":"llash","avatar":"","payment":168,"status":3,"paymentTime":1558442555000,"sendTime":1558442555000,"orderItems":[{"productId":18,"productName":"寻天果蔬 泰国山竹 新鲜水果 中号","productImage":"http://hansonoss.oss-cn-beijing.aliyuncs.com/shop/main/23/5b487224N91b2287c.jpg%20(350%C3%97350).jpg"}]},{"orderNo":2043,"nickname":"llash","avatar":"","payment":261,"status":2,"paymentTime":1558493569000,"orderItems":[{"productId":15,"productName":"士力架 花生夹心巧克力（全家桶）糖果 大桶","productImage":"http://hansonoss.oss-cn-beijing.aliyuncs.com/shop/main/41/5bc405d0N65e9ebfb.jpg%20(350%C3%97350).jpg"}]}]
     */

    private int status;
    private String message;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * orderNo : 324
         * nickname : llash
         * avatar :
         * payment : 224
         * status : 3
         * paymentTime : 1558325293000
         * sendTime : 1558325293000
         * orderItems : [{"productId":18,"productName":"寻天果蔬 泰国山竹 新鲜水果 中号","productImage":"http://hansonoss.oss-cn-beijing.aliyuncs.com/shop/main/23/5b487224N91b2287c.jpg%20(350%C3%97350).jpg"}]
         */

        private int orderNo;
        private String nickname;
        private String avatar;
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

        public static class OrderItemsBean {
            /**
             * productId : 18
             * productName : 寻天果蔬 泰国山竹 新鲜水果 中号
             * productImage : http://hansonoss.oss-cn-beijing.aliyuncs.com/shop/main/23/5b487224N91b2287c.jpg%20(350%C3%97350).jpg
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
