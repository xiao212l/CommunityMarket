
package pv.com.pvcloudgo.model.bean;

import java.io.Serializable;


public class User implements Serializable {

    private Long id;
    private String nickname;
    private String motto;
    private String gender;
    private String idcard;
    private String profileImg;
    private String email;
    private String phone;
    private String birthday;
    private String password;
    private Long communityId;

    public String getBirthday() {
        return birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdcard() {
        return idcard;
    }

    public String getPhone() {
        return phone;
    }

    public Long getId() {
        return id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getMotto() {
        return motto;
    }

    public String getProfileImg() {
        return profileImg;
    }

    public String getNickname() {
        return nickname;
    }

    public Long getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Long communityId) {
        this.communityId = communityId;
    }

    public User() {
    }

//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", logo_url='" + logo_url + '\'' +
//                ", mobi='" + mobi + '\'' +
//                ", wxId='" + wxId + '\'' +
//                ", bianhan='" + bianhan + '\'' +
//                ", nicheng='" + nicheng + '\'' +
//                ", password='" + password + '\'' +
//                ", telPhone='" + telPhone + '\'' +
//                ", email='" + email + '\'' +
//                ", touxiang='" + touxiang + '\'' +
//                ", touxiangMin='" + touxiangMin + '\'' +
//                ", qq='" + qq + '\'' +
//                ", weibo='" + weibo + '\'' +
//                ", addressTreeIds='" + addressTreeIds + '\'' +
//                ", selfInfo='" + selfInfo + '\'' +
//                ", status='" + status + '\'' +
//                ", vo_sex='" + vo_sex + '\'' +
//                ", vo_gradeName='" + vo_gradeName + '\'' +
//                ", salt='" + salt + '\'' +
//                ", laiyuan='" + laiyuan + '\'' +
//                ", addressId=" + addressId +
//                ", sex=" + sex +
//                ", age=" + age +
//                ", shopId=" + shopId +
//                ", vckDataId=" + vckDataId +
//                ", zhuceDate='" + zhuceDate + '\'' +
//                '}';
//   }
}
