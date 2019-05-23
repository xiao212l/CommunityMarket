package pv.com.pvcloudgo.model.bean;

import java.util.List;

public class shareBillMessageBean {
    /**
     * status : 10001
     * message : 拼单列表获取成功
     * data : [{"id":41,"title":"afu 的拼单","spellNums":1,"productId":1,"status":1,"deadline":1554813840000}]
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
         * id : 41
         * title : afu 的拼单
         * spellNums : 1
         * productId : 1
         * status : 1
         * deadline : 1554813840000
         */

        private int id;
        private String title;
        private int spellNums;
        private int productId;
        private int status;
        private long deadline;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getSpellNums() {
            return spellNums;
        }

        public void setSpellNums(int spellNums) {
            this.spellNums = spellNums;
        }

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public long getDeadline() {
            return deadline;
        }

        public void setDeadline(long deadline) {
            this.deadline = deadline;
        }
    }
}
