package com.wzd.androidframe.data.rep;

import com.wzd.androidframe.data.BaseResultDTO;

/**
 * <p>Description: </p>
 * Created by wzd on 2016/11/2.
 */

public class RepUserDTO extends BaseResultDTO {
    /** userid */
    private long id;
    /** 姓名 */
    private String realname = "";
    /** 用户类型 0-理财师，1-理财机构 */
    private int userType;
    /** 头像图片地址 */
    private String headimgurl = "";
    /** 手机号 */
    private String mobileno = "";
    /** 推荐码 */
    private String recommended = "";
    /** 是否设置提现密码 */
    private boolean flowFlag;
    /** 邮箱 */
    private String mail = "";
    /** 工作单位 */
    private String workUnit = "";
    /** qq */
    private String qq = "";
    /** tel */
    private String tel = "";
    /** 积分 */
    private int integralScore;
    /** 二维码 */
    private String qrcode = "";

    public long getId() {
        return id;
    }

    public String getRealname() {
        return realname;
    }

    public int getUserType() {
        return userType;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public String getMobileno() {
        return mobileno;
    }

    public String getRecommended() {
        return recommended;
    }

    public boolean isFlowFlag() {
        return flowFlag;
    }

    public String getMail() {
        return mail;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public String getQq() {
        return qq;
    }

    public String getTel() {
        return tel;
    }

    public int getIntegralScore() {
        return integralScore;
    }

    public String getQrcode() {
        return qrcode;
    }
}
