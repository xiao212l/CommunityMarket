package pv.com.pvcloudgo.model.bean;

import java.util.List;

public class deleteCartBean {
    /**
     * status : 10001
     * message : 购物车商品删除成功
     * data : {"nickname":"llash","cartItems":[{"productId":30,"skuId":9,"name":"陕西阎良甜瓜2斤装 蜜瓜香瓜 白玉","subtitle":"阎良甜瓜产地直采，皮白肉鲜，香甜多汁","subImage":"http://hansonoss.oss-cn-beijing.aliyuncs.com/shop/sub/30/58f97394Nbd89d1d8.jpg%20(350%C3%97350).jpg","isChecked":1,"price":45,"count":3,"totalPrice":135,"attributeName":"白玉"}]}
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
         * cartItems : [{"productId":30,"skuId":9,"name":"陕西阎良甜瓜2斤装 蜜瓜香瓜 白玉","subtitle":"阎良甜瓜产地直采，皮白肉鲜，香甜多汁","subImage":"http://hansonoss.oss-cn-beijing.aliyuncs.com/shop/sub/30/58f97394Nbd89d1d8.jpg%20(350%C3%97350).jpg","isChecked":1,"price":45,"count":3,"totalPrice":135,"attributeName":"白玉"}]
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
             * productId : 30
             * skuId : 9
             * name : 陕西阎良甜瓜2斤装 蜜瓜香瓜 白玉
             * subtitle : 阎良甜瓜产地直采，皮白肉鲜，香甜多汁
             * subImage : http://hansonoss.oss-cn-beijing.aliyuncs.com/shop/sub/30/58f97394Nbd89d1d8.jpg%20(350%C3%97350).jpg
             * isChecked : 1
             * price : 45
             * count : 3
             * totalPrice : 135
             * attributeName : 白玉
             */

            private int productId;
            private int skuId;
            private String name;
            private String subtitle;
            private String subImage;
            private int isChecked;
            private int price;
            private int count;
            private int totalPrice;
            private String attributeName;

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

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public int getTotalPrice() {
                return totalPrice;
            }

            public void setTotalPrice(int totalPrice) {
                this.totalPrice = totalPrice;
            }

            public String getAttributeName() {
                return attributeName;
            }

            public void setAttributeName(String attributeName) {
                this.attributeName = attributeName;
            }
        }
    }
}
