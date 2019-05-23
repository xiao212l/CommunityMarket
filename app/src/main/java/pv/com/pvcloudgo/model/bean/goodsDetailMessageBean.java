package pv.com.pvcloudgo.model.bean;

import java.util.List;

public class goodsDetailMessageBean {

    /**
     * status : 10001
     * message : 请求成功
     * data : {"id":39,"categoryId":2,"name":"南湖牌 咸鸭蛋盐蛋20枚 65g/枚","subtitle":"绿色食品认证！原产地，高品质！红沙流油，鲜细嫩白！破损包赔，售后无忧！新老包装随机发货","status":1,"mainImage":"http://hansonoss.oss-cn-beijing.aliyuncs.com/shop/main/39/4fab61c77993f67b.jpg%20(350%C3%97350).jpg","subImages":"http://hansonoss.oss-cn-beijing.aliyuncs.com/shop/sub/39/59be0f9fN9db9e4a6.jpg%20(350%C3%97350).jpg,http://hansonoss.oss-cn-beijing.aliyuncs.com/shop/sub/39/59c875abNf8ea9226.jpg%20(350%C3%97350).jpg,http://hansonoss.oss-cn-beijing.aliyuncs.com/shop/sub/39/59fa76c6Ne13fe09e.jpg%20(350%C3%97350).jpg","purchaseProductSkus":[{"id":12,"attributeName":"偏咸","sales":34,"stock":17,"price":45,"spellPrice":43.5,"productId":39,"purchaseProduct":null}]}
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
         * id : 39
         * categoryId : 2
         * name : 南湖牌 咸鸭蛋盐蛋20枚 65g/枚
         * subtitle : 绿色食品认证！原产地，高品质！红沙流油，鲜细嫩白！破损包赔，售后无忧！新老包装随机发货
         * status : 1
         * mainImage : http://hansonoss.oss-cn-beijing.aliyuncs.com/shop/main/39/4fab61c77993f67b.jpg%20(350%C3%97350).jpg
         * subImages : http://hansonoss.oss-cn-beijing.aliyuncs.com/shop/sub/39/59be0f9fN9db9e4a6.jpg%20(350%C3%97350).jpg,http://hansonoss.oss-cn-beijing.aliyuncs.com/shop/sub/39/59c875abNf8ea9226.jpg%20(350%C3%97350).jpg,http://hansonoss.oss-cn-beijing.aliyuncs.com/shop/sub/39/59fa76c6Ne13fe09e.jpg%20(350%C3%97350).jpg
         * purchaseProductSkus : [{"id":12,"attributeName":"偏咸","sales":34,"stock":17,"price":45,"spellPrice":43.5,"productId":39,"purchaseProduct":null}]
         */

        private int id;
        private int categoryId;
        private String name;
        private String subtitle;
        private int status;
        private String mainImage;
        private String subImages;
        private List<PurchaseProductSkusBean> purchaseProductSkus;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
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

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getMainImage() {
            return mainImage;
        }

        public void setMainImage(String mainImage) {
            this.mainImage = mainImage;
        }

        public String getSubImages() {
            return subImages;
        }

        public void setSubImages(String subImages) {
            this.subImages = subImages;
        }

        public List<PurchaseProductSkusBean> getPurchaseProductSkus() {
            return purchaseProductSkus;
        }

        public void setPurchaseProductSkus(List<PurchaseProductSkusBean> purchaseProductSkus) {
            this.purchaseProductSkus = purchaseProductSkus;
        }

        public static class PurchaseProductSkusBean {
            /**
             * id : 12
             * attributeName : 偏咸
             * sales : 34
             * stock : 17
             * price : 45
             * spellPrice : 43.5
             * productId : 39
             * purchaseProduct : null
             */

            private int id;
            private String attributeName;
            private int sales;
            private int stock;
            private double price;
            private double spellPrice;
            private int productId;
            private Object purchaseProduct;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getAttributeName() {
                return attributeName;
            }

            public void setAttributeName(String attributeName) {
                this.attributeName = attributeName;
            }

            public int getSales() {
                return sales;
            }

            public void setSales(int sales) {
                this.sales = sales;
            }

            public int getStock() {
                return stock;
            }

            public void setStock(int stock) {
                this.stock = stock;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public double getSpellPrice() {
                return spellPrice;
            }

            public void setSpellPrice(double spellPrice) {
                this.spellPrice = spellPrice;
            }

            public int getProductId() {
                return productId;
            }

            public void setProductId(int productId) {
                this.productId = productId;
            }

            public Object getPurchaseProduct() {
                return purchaseProduct;
            }

            public void setPurchaseProduct(Object purchaseProduct) {
                this.purchaseProduct = purchaseProduct;
            }
        }
    }
}
