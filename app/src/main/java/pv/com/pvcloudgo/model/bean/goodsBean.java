package pv.com.pvcloudgo.model.bean;

import java.util.List;

public class goodsBean {

    /**
     * status : 10001
     * message : 请求成功
     * data : [{"id":1,"parentId":0,"name":"家用电器","images":[{"id":4,"imageUrl":"dadsafsd","categoryId":1,"addTime":1552797743000,"keyword":"电视机"}],"products":[{"id":1,"categoryId":1,"name":"长虹 55D2P","subtitle":"55英寸32核人工智能4K超高清HDR全金属轻薄语音平板LED液晶电视机（浅金色）","evaluationNums":628,"goodEvaluationNums":573},{"id":5,"categoryId":1,"name":"心想（SCISHARE）","subtitle":"胶囊咖啡机 全自动咖啡机家用加心想甄选JACOBS全系列50粒咖啡胶囊 组合*1","evaluationNums":523,"goodEvaluationNums":390,"mainImage":"rqwerwrf","subImages":"qrewrqwrqwer"},{"id":6,"categoryId":1,"name":"AEG对开门冰箱","subtitle":"家用 1级能效 高效节能 精控变温空间 干湿分储RXB66186TX","evaluationNums":580,"goodEvaluationNums":467,"mainImage":"rqwerwrf","subImages":"qrewrqwrqwer"},{"id":7,"categoryId":1,"name":"TCL 8.5公斤","subtitle":"洗烘一体变频滚筒洗衣机洗烘一体机 羽绒服洗 超薄 烘干洗衣机 婴儿洗 除螨 XQG85-F14303HBDP","evaluationNums":810,"goodEvaluationNums":779,"mainImage":"rqwerwrf","subImages":"qrewrqwrqwer"},{"id":8,"categoryId":1,"name":"海尔(Haier) 滚筒","subtitle":"洗衣机全自动 10公斤变频纤维级蒸汽防皱洗烘一体 洗10烘7 XQG100-14HBX20SJD","evaluationNums":795,"goodEvaluationNums":778,"mainImage":"rqwerwrf","subImages":"qrewrqwrqwer"}]}]
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
         * id : 1
         * parentId : 0
         * name : 家用电器
         * images : [{"id":4,"imageUrl":"dadsafsd","categoryId":1,"addTime":1552797743000,"keyword":"电视机"}]
         * products : [{"id":1,"categoryId":1,"name":"长虹 55D2P","subtitle":"55英寸32核人工智能4K超高清HDR全金属轻薄语音平板LED液晶电视机（浅金色）","evaluationNums":628,"goodEvaluationNums":573},{"id":5,"categoryId":1,"name":"心想（SCISHARE）","subtitle":"胶囊咖啡机 全自动咖啡机家用加心想甄选JACOBS全系列50粒咖啡胶囊 组合*1","evaluationNums":523,"goodEvaluationNums":390,"mainImage":"rqwerwrf","subImages":"qrewrqwrqwer"},{"id":6,"categoryId":1,"name":"AEG对开门冰箱","subtitle":"家用 1级能效 高效节能 精控变温空间 干湿分储RXB66186TX","evaluationNums":580,"goodEvaluationNums":467,"mainImage":"rqwerwrf","subImages":"qrewrqwrqwer"},{"id":7,"categoryId":1,"name":"TCL 8.5公斤","subtitle":"洗烘一体变频滚筒洗衣机洗烘一体机 羽绒服洗 超薄 烘干洗衣机 婴儿洗 除螨 XQG85-F14303HBDP","evaluationNums":810,"goodEvaluationNums":779,"mainImage":"rqwerwrf","subImages":"qrewrqwrqwer"},{"id":8,"categoryId":1,"name":"海尔(Haier) 滚筒","subtitle":"洗衣机全自动 10公斤变频纤维级蒸汽防皱洗烘一体 洗10烘7 XQG100-14HBX20SJD","evaluationNums":795,"goodEvaluationNums":778,"mainImage":"rqwerwrf","subImages":"qrewrqwrqwer"}]
         */

        private int id;
        private int parentId;
        private String name;
        private List<ImagesBean> images;
        private List<ProductsBean> products;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getParentId() {
            return parentId;
        }

        public void setParentId(int parentId) {
            this.parentId = parentId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<ImagesBean> getImages() {
            return images;
        }

        public void setImages(List<ImagesBean> images) {
            this.images = images;
        }

        public List<ProductsBean> getProducts() {
            return products;
        }

        public void setProducts(List<ProductsBean> products) {
            this.products = products;
        }

        public static class ImagesBean {
            /**
             * id : 4
             * imageUrl : dadsafsd
             * categoryId : 1
             * addTime : 1552797743000
             * keyword : 电视机
             */

            private int id;
            private String imageUrl;
            private int categoryId;
            private long addTime;
            private String keyword;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public int getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(int categoryId) {
                this.categoryId = categoryId;
            }

            public long getAddTime() {
                return addTime;
            }

            public void setAddTime(long addTime) {
                this.addTime = addTime;
            }

            public String getKeyword() {
                return keyword;
            }

            public void setKeyword(String keyword) {
                this.keyword = keyword;
            }
        }

        public static class ProductsBean {
            /**
             * id : 1
             * categoryId : 1
             * name : 长虹 55D2P
             * subtitle : 55英寸32核人工智能4K超高清HDR全金属轻薄语音平板LED液晶电视机（浅金色）
             * evaluationNums : 628
             * goodEvaluationNums : 573
             * mainImage : rqwerwrf
             * subImages : qrewrqwrqwer
             */

            private int id;
            private int categoryId;
            private String name;
            private String subtitle;
            private int evaluationNums;
            private int goodEvaluationNums;
            private String mainImage;
            private String subImages;

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

            public int getEvaluationNums() {
                return evaluationNums;
            }

            public void setEvaluationNums(int evaluationNums) {
                this.evaluationNums = evaluationNums;
            }

            public int getGoodEvaluationNums() {
                return goodEvaluationNums;
            }

            public void setGoodEvaluationNums(int goodEvaluationNums) {
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
        }
    }
}
