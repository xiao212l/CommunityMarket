package pv.com.pvcloudgo.model.bean;


import java.util.List;

import pv.com.pvcloudgo.model.base.BaseBean;

public class CRoot2 extends BaseBean {

    String orderIndex;
    String webTiCheng;
    String isQuanqiugou;
    String quanqiugouShuiType;
    float omoy_root_backbill;
    String status;
    String wrap_ptlist_rootImage;
    String wrap_ptlist_threeImage;
    String name;
    int rootTypeId;
    int isRoot;
    int isLeaf;
    int jibie;
    String url;
    String treeId;
    int fatherId;
    String allName;
    List<Category> childs;


    public List<Category> getChilds() {
        return childs;
    }

    public CRoot2() {
        orderIndex = "1";
        webTiCheng = "123123213";
        isQuanqiugou = "全球购";
        quanqiugouShuiType = "啥东西";
        omoy_root_backbill = 111;
        status = "status";
        wrap_ptlist_rootImage = "https://picsum.photos/200/100";
        wrap_ptlist_threeImage = "https://picsum.photos/100/100";
        name = "案例";
        rootTypeId = 1;
        isRoot = 1;
        isLeaf = 0;
        jibie = 1;
        url = "";
        treeId = "11111111";
        fatherId = 2;
        allName = "全部名字";

    }

    public CRoot2(String name) {

        this.name = name;
    }

    public CRoot2(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getOrderIndex() {
        return orderIndex;
    }

    public String getWebTiCheng() {
        return webTiCheng;
    }

    public String getIsQuanqiugou() {
        return isQuanqiugou;
    }

    public String getQuanqiugouShuiType() {
        return quanqiugouShuiType;
    }

    public float getOmoy_root_backbill() {
        return omoy_root_backbill;
    }

    public String getStatus() {
        return status;
    }

    public String getWrap_ptlist_rootImage() {
        return wrap_ptlist_rootImage;
    }

    public String getWrap_ptlist_threeImage() {
        return wrap_ptlist_threeImage;
    }

    public int getRootTypeId() {
        return rootTypeId;
    }

    public int getIsRoot() {
        return isRoot;
    }

    public int getIsLeaf() {
        return isLeaf;
    }

    public int getJibie() {
        return jibie;
    }

    public String getUrl() {
        return url;
    }

    public String getTreeId() {
        return treeId;
    }

    public int getFatherId() {
        return fatherId;
    }

    public String getAllName() {
        return allName;
    }
}
