package pv.com.pvcloudgo.model.bean;

public class UserInfoBean {

    /**
     * status : 10001
     * message : 请求成功
     * data : {"posts":0,"replys":0,"collections":0,"followerNums":0,"followingNums":0,"base_info":{"id":64,"nickname":"lash4","phone":"17864195002","communityId":3,"signUp":1554022669168}}
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
         * posts : 0
         * replys : 0
         * collections : 0
         * followerNums : 0
         * followingNums : 0
         * base_info : {"id":64,"nickname":"lash4","phone":"17864195002","communityId":3,"signUp":1554022669168}
         */

        private int posts;
        private int replys;
        private int collections;
        private int followerNums;
        private int followingNums;
        private User base_info;

        public int getPosts() {
            return posts;
        }

        public void setPosts(int posts) {
            this.posts = posts;
        }

        public int getReplys() {
            return replys;
        }

        public void setReplys(int replys) {
            this.replys = replys;
        }

        public int getCollections() {
            return collections;
        }

        public void setCollections(int collections) {
            this.collections = collections;
        }

        public int getFollowerNums() {
            return followerNums;
        }

        public void setFollowerNums(int followerNums) {
            this.followerNums = followerNums;
        }

        public int getFollowingNums() {
            return followingNums;
        }

        public void setFollowingNums(int followingNums) {
            this.followingNums = followingNums;
        }

        public User getBase_info() {
            return base_info;
        }

        public void setBase_info(User base_info) {
            this.base_info = base_info;
        }

    }
}
