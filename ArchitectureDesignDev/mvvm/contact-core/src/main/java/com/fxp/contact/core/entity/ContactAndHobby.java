package com.fxp.contact.core.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Title:       ContactAndHobby
 * <p>
 * Package:     com.fxp.contact.core.entity
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2019/1/26 5:49 PM
 * <p>
 * Description: 联系人与爱好N：N示例 中间表
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
public class ContactAndHobby {

    /**
     * 主键，autoincrement设置自增
     */
    @Id(autoincrement = true)
    private Long id;

    private String contactId;

    private String hobbyId;

    @Generated(hash = 1951815082)
    public ContactAndHobby(Long id, String contactId, String hobbyId) {
        this.id = id;
        this.contactId = contactId;
        this.hobbyId = hobbyId;
    }

    @Generated(hash = 1192126144)
    public ContactAndHobby() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContactId() {
        return this.contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getHobbyId() {
        return this.hobbyId;
    }

    public void setHobbyId(String hobbyId) {
        this.hobbyId = hobbyId;
    }
}
