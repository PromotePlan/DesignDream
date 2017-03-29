package com.designdream.bean;

import net.tsz.afinal.annotation.sqlite.Id;
import net.tsz.afinal.annotation.sqlite.Table;

/**
 * Created by leianjun on 2017/3/29.
 */
@Table(name = "loginResult")
public class LoginResultBean {

    @Id(column = "id")
    private int id;
    // 用户梦想Id号
    private String userDreId;
    // 手机号
    private String phone;
    // 加密后的密码
    private String password;
    // 用户昵称
    private String nicNam;
    // 用户头像
    private String imgStr;
    // 该用户关注的人数
    private int focToCount;
    // 粉丝数
    private int fansFromCount;
    // 被评论数
    private int comFromCount;
    // 被看好ta数
    private int supFromCount;
    // 登录方式(0-手机号登录，1-梦想ID号登陆)
    private int loginType;
    // 软件版本id号
    private int verId;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUserDreId() {
        return userDreId;
    }
    public void setUserDreId(String userDreId) {
        this.userDreId = userDreId;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getNicNam() {
        return nicNam;
    }
    public void setNicNam(String nicNam) {
        this.nicNam = nicNam;
    }
    public String getImgStr() {
        return imgStr;
    }
    public void setImgStr(String imgStr) {
        this.imgStr = imgStr;
    }
    public int getFocToCount() {
        return focToCount;
    }
    public void setFocToCount(int focToCount) {
        this.focToCount = focToCount;
    }
    public int getFansFromCount() {
        return fansFromCount;
    }
    public void setFansFromCount(int fansFromCount) {
        this.fansFromCount = fansFromCount;
    }
    public int getComFromCount() {
        return comFromCount;
    }
    public void setComFromCount(int comFromCount) {
        this.comFromCount = comFromCount;
    }
    public int getSupFromCount() {
        return supFromCount;
    }
    public void setSupFromCount(int supFromCount) {
        this.supFromCount = supFromCount;
    }
    public int getLoginType() {
        return loginType;
    }
    public void setLoginType(int loginType) {
        this.loginType = loginType;
    }
    public int getVerId() {
        return verId;
    }
    public void setVerId(int verId) {
        this.verId = verId;
    }
}
