package com.fxp.contact.core.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Unique;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Title:       PhoneNumInfo
 * <p>
 * Package:     com.fxp.contact.core.entity
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2019/1/26 3:33 PM
 * <p>
 * Description: 电话号码表
 * 联系人与电话号码1：N示例
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date       Author       Version      Description
 * -----------------------------------------------------------------
 * 2019/1/26    fxp       1.0         First Created
 * <p>
 * Github:  https://github.com/fangxiaopeng
 */
@Entity
public class PhoneNumInfo implements Serializable {

    public static final long serialVersionUID = 5L;

    /**
     * 主键
     */
    @Id
    @NotNull
    @Unique
    private String phoneNum;

    private String ownerId;

    /**
     * 运营商类型: 0移动，1联通，2电信，3其他
     */
    private int type;

    private String area;

    @Generated(hash = 484505383)
    public PhoneNumInfo(@NotNull String phoneNum, String ownerId, int type,
            String area) {
        this.phoneNum = phoneNum;
        this.ownerId = ownerId;
        this.type = type;
        this.area = area;
    }

    @Generated(hash = 1681577060)
    public PhoneNumInfo() {
    }

    public String getPhoneNum() {
        return this.phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getOwnerId() {
        return this.ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getArea() {
        return this.area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
