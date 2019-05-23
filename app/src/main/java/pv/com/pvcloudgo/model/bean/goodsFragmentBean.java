package pv.com.pvcloudgo.model.bean;

import java.util.List;

public class goodsFragmentBean {

    /**
     * status : 2
     * message : 请求成功
     * data : [{"id":1,"categoryId":1,"name":"容声(Ronshen) 529升","subtitle":"对开门冰箱 矢量双变频 纤薄机身 风冷无霜 节能静音 沐光金 BCD-529WD11HP","mainImage":"http://pmt5ma5mu.bkt.clouddn.com/meidi638.jpg","spellPrice":0,"status":1}]
     */

    private int status;
    private String message;
    private List<good> data;

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

    public List<good> getData() {
        return data;
    }

    public void setData(List<good> data) {
        this.data = data;
    }

    public static class good {
        /**
         * id : 1
         * categoryId : 100006
         * name : 容声(Ronshen) 529升
         * subtitle : 对开门冰箱 矢量双变频 纤薄机身 风冷无霜 节能静音 沐光金 BCD-529WD11HP
         * mainImage : http://pmt5ma5mu.bkt.clouddn.com/meidi638.jpg
         * spellPrice : 0
         * status : 1
         */

        private int id;
        private int categoryId;
        private String name;
        private String subtitle;
        private String mainImage;
        private int spellPrice;
        private int status;

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

        public String getMainImage() {
            return mainImage;
        }

        public void setMainImage(String mainImage) {
            this.mainImage = mainImage;
        }

        public int getSpellPrice() {
            return spellPrice;
        }

        public void setSpellPrice(int spellPrice) {
            this.spellPrice = spellPrice;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
