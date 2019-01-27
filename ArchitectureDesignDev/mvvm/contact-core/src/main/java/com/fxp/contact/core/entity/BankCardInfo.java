package com.fxp.contact.core.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Unique;

import java.io.Serializable;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Title:       BankCardInfo
 * <p>
 * Package:     com.fxp.contact.core.entity
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2019/1/26 6:28 PM
 * <p>
 * Description: 银行卡表
 * 联系人与银行卡1：N示例
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
public class BankCardInfo implements Serializable {

    public static final long serialVersionUID = 2L;

    @Id
    @Unique
    @NotNull
    private Long cardNum;

    private int cardType;

    private int bankName;

    @NotNull
    private String ownerId;

    @Generated(hash = 236986293)
    public BankCardInfo(@NotNull Long cardNum, int cardType, int bankName,
            @NotNull String ownerId) {
        this.cardNum = cardNum;
        this.cardType = cardType;
        this.bankName = bankName;
        this.ownerId = ownerId;
    }

    @Generated(hash = 79659959)
    public BankCardInfo() {
    }

    public Long getCardNum() {
        return this.cardNum;
    }

    public void setCardNum(Long cardNum) {
        this.cardNum = cardNum;
    }

    public int getCardType() {
        return this.cardType;
    }

    public void setCardType(int cardType) {
        this.cardType = cardType;
    }

    public int getBankName() {
        return this.bankName;
    }

    public void setBankName(int bankName) {
        this.bankName = bankName;
    }

    public String getOwnerId() {
        return this.ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }
}
