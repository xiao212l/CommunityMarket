package pv.com.pvcloudgo.model.bean;

public class commentPublishBean {
    /**
     * status : 10001
     * message : 发表评价成功
     * data : {"id":29,"nickname":"hanson18","avatar":"","content":"这个东西一般","imageUrl":"http://changhong.png","attributeName":"银色","evaluationTime":1553913875582,"type":2}
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
         * id : 29
         * nickname : hanson18
         * avatar :
         * content : 这个东西一般
         * imageUrl : http://changhong.png
         * attributeName : 银色
         * evaluationTime : 1553913875582
         * type : 2
         */

        private int id;
        private String nickname;
        private String avatar;
        private String content;
        private String imageUrl;
        private String attributeName;
        private long evaluationTime;
        private int type;

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

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public String getAttributeName() {
            return attributeName;
        }

        public void setAttributeName(String attributeName) {
            this.attributeName = attributeName;
        }

        public long getEvaluationTime() {
            return evaluationTime;
        }

        public void setEvaluationTime(long evaluationTime) {
            this.evaluationTime = evaluationTime;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
