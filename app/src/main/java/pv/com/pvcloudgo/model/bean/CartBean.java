package pv.com.pvcloudgo.model.bean;

import java.util.List;

public class CartBean {


    /**
     * status : 10001
     * message : 请求成功
     * data : {"nickname":"llash","cartItems":[{"productId":23,"skuId":8,"name":"寻天果蔬 泰国山竹 新鲜水果 小号","subtitle":"天气炎热，山竹会有蚂蚁产生，收到清水清洗即可","subImage":"http://hansonoss.oss-cn-beijing.aliyuncs.com/shop/sub/23/5b487223Nbcbaae07.jpg%20(350%C3%97350).jpg","isChecked":1,"price":43,"count":2,"totalPrice":86}]}
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
         * nickname : llash
         * cartItems : [{"productId":23,"skuId":8,"name":"寻天果蔬 泰国山竹 新鲜水果 小号","subtitle":"天气炎热，山竹会有蚂蚁产生，收到清水清洗即可","subImage":"http://hansonoss.oss-cn-beijing.aliyuncs.com/shop/sub/23/5b487223Nbcbaae07.jpg%20(350%C3%97350).jpg","isChecked":1,"price":43,"count":2,"totalPrice":86}]
         */

        private String nickname;
        private List<CartItemsBean> cartItems;

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public List<CartItemsBean> getCartItems() {
            return cartItems;
        }

        public void setCartItems(List<CartItemsBean> cartItems) {
            this.cartItems = cartItems;
        }

        public static class CartItemsBean {
            /**
             * productId : 23
             * skuId : 8
             * name : 寻天果蔬 泰国山竹 新鲜水果 小号
             * subtitle : 天气炎热，山竹会有蚂蚁产生，收到清水清洗即可
             * subImage : http://hansonoss.oss-cn-beijing.aliyuncs.com/shop/sub/23/5b487223Nbcbaae07.jpg%20(350%C3%97350).jpg
             * isChecked : 1
             * price : 43
             * count : 2
             * totalPrice : 86
             */

            private int productId;
            private int skuId;
            private String name;
            private String subtitle;
            private String subImage;
            private int isChecked;
            private double price;
            private int count;
            private double totalPrice;

            public int getProductId() {
                return productId;
            }

            public void setProductId(int productId) {
                this.productId = productId;
            }

            public int getSkuId() {
                return skuId;
            }

            public void setSkuId(int skuId) {
                this.skuId = skuId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getSubtitle() {
                return subtitle;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

            public String getSubImage() {
                return subImage;
            }

            public void setSubImage(String subImage) {
                this.subImage = subImage;
            }

            public int getIsChecked() {
                return isChecked;
            }

            public void setIsChecked(int isChecked) {
                this.isChecked = isChecked;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public double getTotalPrice() {
                return totalPrice;
            }

            public void setTotalPrice(int totalPrice) {
                this.totalPrice = totalPrice;
            }
        }
    }
}
