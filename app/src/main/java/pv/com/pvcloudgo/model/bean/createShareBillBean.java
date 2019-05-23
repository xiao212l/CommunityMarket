package pv.com.pvcloudgo.model.bean;

import java.util.List;

public class createShareBillBean {
    /**
     * status : 10001
     * message : 拼单创建成功
     * data : {"id":2,"title":"hanson24 的拼单","spellNums":1,"productId":1,"status":1,"deadline":1553835192059,"assembleItemList":[{"id":2,"nickname":"hanson24","avatar":"","assembleId":2}]}
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
         * id : 2
         * title : hanson24 的拼单
         * spellNums : 1
         * productId : 1
         * status : 1
         * deadline : 1553835192059
         * assembleItemList : [{"id":2,"nickname":"hanson24","avatar":"","assembleId":2}]
         */

        private int id;
        private String title;
        private int spellNums;
        private int productId;
        private int status;
        private long deadline;
        private List<AssembleItemListBean> assembleItemList;

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

        public List<AssembleItemListBean> getAssembleItemList() {
            return assembleItemList;
        }

        public void setAssembleItemList(List<AssembleItemListBean> assembleItemList) {
            this.assembleItemList = assembleItemList;
        }

        public static class AssembleItemListBean {
            /**
             * id : 2
             * nickname : hanson24
             * avatar :
             * assembleId : 2
             */

            private int id;
            private String nickname;
            private String avatar;
            private int assembleId;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
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

            public int getAssembleId() {
                return assembleId;
            }

            public void setAssembleId(int assembleId) {
                this.assembleId = assembleId;
            }
        }
    }
}
