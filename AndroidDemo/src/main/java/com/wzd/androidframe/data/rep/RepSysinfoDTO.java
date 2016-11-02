package com.wzd.androidframe.data.rep;

import com.wzd.androidframe.data.BaseResultDTO;

/**
 * <p>Description: </p>
 * Created by wzd on 2016/11/2.
 */
public class RepSysinfoDTO extends BaseResultDTO {
    /**
     * 合同寄回地址
     */
    private String contractAddress = "";
    /**
     * 合同寄回 收件人电话
     */
    private String receiverTel = "";
    /**
     * 合同寄回 收件人
     */
    private String receiverName = "";
    /**
     * app更新地址
     */
    private String appUpdateUrl;

    @Override
    public String toString() {
        return "RepSysinfoDTO{" +
                "contractAddress='" + contractAddress + '\'' +
                ", receiverTel='" + receiverTel + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", appUpdateUrl='" + appUpdateUrl + '\'' +
                '}';
    }
}
