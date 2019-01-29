package com.fxp.contact.core.entity;

import com.fxp.contact.core.greendao.gen.ContactInfoDao;
import com.fxp.contact.core.greendao.gen.DaoSession;
import com.fxp.contact.core.greendao.gen.HobbyInfoDao;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToMany;

import java.io.Serializable;
import java.util.List;

/**
 * Title:       HobbyInfo
 * <p>
 * Package:     com.fxp.contact.core.entity
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2019/1/26 4:42 PM
 * <p>
 * Description: 爱好表
 * 联系人与爱好N：N示例
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
public class HobbyInfo implements Serializable {

    public static final long serialVersionUID = 3L;

    @Id
    @NotNull
    private String hobbyId;

    private String hobbyName;

    @ToMany
    @JoinEntity(entity = ContactAndHobby.class, sourceProperty = "hobbyId",targetProperty = "contactId")
    private List<ContactInfo> contactInfos;

    @Override
    public String toString() {
        return "HobbyInfo{" +
                "hobbyId='" + hobbyId + '\'' +
                ", hobbyName='" + hobbyName + '\'' +
                ", contactInfos=" + getContactInfos() +
                '}';
    }

    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated(hash = 1688606219)
    private transient HobbyInfoDao myDao;

    @Generated(hash = 672219501)
    public HobbyInfo(@NotNull String hobbyId, String hobbyName) {
        this.hobbyId = hobbyId;
        this.hobbyName = hobbyName;
    }

    @Generated(hash = 331750095)
    public HobbyInfo() {
    }

    public String getHobbyId() {
        return this.hobbyId;
    }

    public void setHobbyId(String hobbyId) {
        this.hobbyId = hobbyId;
    }

    public String getHobbyName() {
        return this.hobbyName;
    }

    public void setHobbyName(String hobbyName) {
        this.hobbyName = hobbyName;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1945055763)
    public List<ContactInfo> getContactInfos() {
        if (contactInfos == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            ContactInfoDao targetDao = daoSession.getContactInfoDao();
            List<ContactInfo> contactInfosNew = targetDao._queryHobbyInfo_ContactInfos(hobbyId);
            synchronized (this) {
                if (contactInfos == null) {
                    contactInfos = contactInfosNew;
                }
            }
        }
        return contactInfos;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 231846770)
    public synchronized void resetContactInfos() {
        contactInfos = null;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1817378368)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getHobbyInfoDao() : null;
    }
}
