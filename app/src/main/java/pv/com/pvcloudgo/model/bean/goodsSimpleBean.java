package pv.com.pvcloudgo.model.bean;

import java.util.List;

public class goodsSimpleBean {

    /**
     * status : 10001
     * message : 请求成功
     * data : [{"id":23,"name":"寻天果蔬 泰国山竹 新鲜水果","subtitle":"天气炎热，山竹会有蚂蚁产生，收到清水清洗即可","categoryId":2,"mainImage":"http://hansonoss.oss-cn-beijing.aliyuncs.com/shop/main/23/5b487224N91b2287c.jpg%20(350%C3%97350).jpg"},{"id":30,"name":"陕西阎良甜瓜2斤装 蜜瓜香瓜","subtitle":"阎良甜瓜产地直采，皮白肉鲜，香甜多汁","categoryId":2,"mainImage":"http://hansonoss.oss-cn-beijing.aliyuncs.com/shop/main/30/58f97392Ndb3c0d06.jpg%20(350%C3%97350).jpg"},{"id":35,"name":"杏花楼小笼汤包375g","subtitle":"15只鲜肉汤包灌汤包南翔小笼包上海点心包子馒头儿童早餐速冻面点早点早茶点心烧烤","categoryId":2,"mainImage":"http://hansonoss.oss-cn-beijing.aliyuncs.com/shop/main/35/dc96eeb66c71ee3d.jpg%20(350%C3%97350).jpg"},{"id":38,"name":"现货海南贵妃芒果 小芒果 生鲜4斤精品装","subtitle":"海南贵妃芒果又名红金龙，产地直采，多仓发货。贵妃芒果收到需先催熟之后再食用哦！","categoryId":2,"mainImage":"http://hansonoss.oss-cn-beijing.aliyuncs.com/shop/main/38/f8c10d69b9f30568.jpg%20(350%C3%97350).jpg"},{"id":39,"name":"南湖牌 咸鸭蛋盐蛋20枚 65g/枚","subtitle":"绿色食品认证！原产地，高品质！红沙流油，鲜细嫩白！破损包赔，售后无忧！新老包装随机发货","categoryId":2,"mainImage":"http://hansonoss.oss-cn-beijing.aliyuncs.com/shop/main/39/4fab61c77993f67b.jpg%20(350%C3%97350).jpg"},{"id":40,"name":"山西特产 冠云平遥牛肉牛后腿454g","subtitle":"中华老字号食品熟食牛肉脯休闲零食","categoryId":2,"mainImage":"http://hansonoss.oss-cn-beijing.aliyuncs.com/shop/main/40/5b5a846cN8fbff7a0.jpg%20(350%C3%97350).jpg"}]
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
         * id : 23
         * name : 寻天果蔬 泰国山竹 新鲜水果
         * subtitle : 天气炎热，山竹会有蚂蚁产生，收到清水清洗即可
         * categoryId : 2
         * mainImage : http://hansonoss.oss-cn-beijing.aliyuncs.com/shop/main/23/5b487224N91b2287c.jpg%20(350%C3%97350).jpg
         */

        private int id;
        private String name;
        private String subtitle;
        private int categoryId;
        private String mainImage;

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

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        public String getMainImage() {
            return mainImage;
        }

        public void setMainImage(String mainImage) {
            this.mainImage = mainImage;
        }
    }
}
