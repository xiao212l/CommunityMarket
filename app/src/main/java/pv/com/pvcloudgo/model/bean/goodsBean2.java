package pv.com.pvcloudgo.model.bean;

import java.util.List;

public class goodsBean2 {


    private int code;
    private String message;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

        private int id;
        private int categoryID;
        private String name;
        private String subtitle;
        private int status;
        private Object evaluationNums;
        private Object goodEvaluationNums;
        private String mainImage;
        private String subImages;
        private List<ProductSkusBean> product_skus;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCategoryID() {
            return categoryID;
        }

        public void setCategoryID(int categoryID) {
            this.categoryID = categoryID;
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

        public Object getEvaluationNums() {
            return evaluationNums;
        }

        public void setEvaluationNums(Object evaluationNums) {
            this.evaluationNums = evaluationNums;
        }

        public Object getGoodEvaluationNums() {
            return goodEvaluationNums;
        }

        public void setGoodEvaluationNums(Object goodEvaluationNums) {
            this.goodEvaluationNums = goodEvaluationNums;
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

        public List<ProductSkusBean> getProduct_skus() {
            return product_skus;
        }

        public void setProduct_skus(List<ProductSkusBean> product_skus) {
            this.product_skus = product_skus;
        }

        public static class ProductSkusBean {
            /**
             * id : 7
             * name : 小笼汤包
             * sales : 2
             * stock : 56
             * price : 32.00
             * groupPrice : 25.00
             * productID : 35
             */

            private int id;
            private String name;
            private int sales;
            private int stock;
            private String price;
            private String groupPrice;
            private int productID;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
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

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getGroupPrice() {
                return groupPrice;
            }

            public void setGroupPrice(String groupPrice) {
                this.groupPrice = groupPrice;
            }

            public int getProductID() {
                return productID;
            }

            public void setProductID(int productID) {
                this.productID = productID;
            }
        }
    }
}
