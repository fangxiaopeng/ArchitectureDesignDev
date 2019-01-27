package com.fxp.contact.core.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Unique;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Title:       IDCardInfo
 * <p>
 * Package:     com.fxp.contact.core.entity
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2019/1/26 3:45 PM
 * <p>
 * Description: 身份证表
 * 联系人与身份证 1：1示例
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
public class IDCardInfo implements Serializable {

    public static final long serialVersionUID = 4L;

    @Id
    @NotNull
    @Unique
    private String IDNum;

    private String name;

    /**
     * 性别：0未知，1男，2女
     */
    private int sex;

    /**
     * 民族
     */
    private String nation;

    private String validDate;

    @Generated(hash = 167363808)
    public IDCardInfo(@NotNull String IDNum, String name, int sex, String nation,
            String validDate) {
        this.IDNum = IDNum;
        this.name = name;
        this.sex = sex;
        this.nation = nation;
        this.validDate = validDate;
    }

    @Generated(hash = 1605820148)
    public IDCardInfo() {
    }

    public String getIDNum() {
        return this.IDNum;
    }

    public void setIDNum(String IDNum) {
        this.IDNum = IDNum;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return this.sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getNation() {
        return this.nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getValidDate() {
        return this.validDate;
    }

    public void setValidDate(String validDate) {
        this.validDate = validDate;
    }
}
