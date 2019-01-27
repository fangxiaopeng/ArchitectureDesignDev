package com.fxp.contact.core.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.JoinProperty;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Transient;

import java.io.Serializable;
import java.util.List;
import org.greenrobot.greendao.DaoException;
import com.fxp.contact.core.greendao.gen.DaoSession;
import com.fxp.contact.core.greendao.gen.HobbyInfoDao;
import com.fxp.contact.core.greendao.gen.BankCardInfoDao;
import com.fxp.contact.core.greendao.gen.PhoneNumInfoDao;
import com.fxp.contact.core.greendao.gen.IDCardInfoDao;
import com.fxp.contact.core.greendao.gen.ContactInfoDao;

/**
 * Title:       ContactInfo
 * <p>
 * Package:     com.fxp.contact.core.entity
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2019/1/26 11:56 AM
 * <p>
 * Description: GreenDao建表示例
 * 参考：https://blog.csdn.net/crazymo_/article/details/54629916
 * https://www.jianshu.com/p/53083f782ea2
 * https://www.jianshu.com/p/dbec25bd575f
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
@Entity(
        /**
         * schema 名，多个 schema 时设置关联实体。插件产生不支持，需使用产生器
        */
//        schema = "fxp",
        /**
         * 标记一个实体是否处于活动状态，活动实体有 update、delete、refresh 方法。默认为 false
        */
        active = false,
        /**
         * 表名，默认为类名
        */
        nameInDb = "CONTACT_INFO",
        /**
         * 定义多列索引
        */
        indexes = {
                @Index(value = "contactId DESC", unique = true)
        },
        /**
         * 标记是否创建表，默认 true。多实体对应一个表或者表已创建，不需要 greenDAO 创建时设置 false
        */
        createInDb = false,
        /**
         * 是否产生所有参数构造器。默认为 true。无参构造器必定产生
        */
        generateConstructors = true,
        /**
         * 如果没有 get/set 方法，是否生成。默认为 true
        */
        generateGettersSetters = true
)
public class ContactInfo implements Serializable{

    public static final long serialVersionUID = 1L;

    /**
     * 主键，默认索引
     */
    @Id
    private String contactId;

    /**
     * 非空
     */
    @NotNull
    private String name;

    /**
     * 通过@Property(nameInDb="XXX")指定列名，默认使用变量名
     * 设置后，数据库表中列名为"job",如果不设置，则为"JOB"
     */
    @Property(nameInDb="job")
    private String job;

    private String adress;

    /**
     * 定义与另一个实体(一个实体对象)的关系1：1
     * 一个联系人对应一个身份证信息
     * 通过 @ToOne(joinProperty = “contactId”)注解，最终将会在数据库表IDCardInfo中以 IDNum 这一列作为外键，与IDCardInfo数据表建立联系
     * ContactInfo表主键 contactId --> IDCardInfo表外键 IDNum
     */
    @ToOne(joinProperty = "contactId")
    private IDCardInfo idCardInfo;

    /**
     * 定义与多个实体对象的关系1：N
     * 一个联系人对应多个电话号码，一个电话号码对应一个人
     * 通过@ToMany(referencedJoinProperty = "ownerId")注解，最终将会在目标实体（PhoneNumInfo）的数据表中建立外键（ownerId），指向源实体类（ContactInfo）的数据表
     * ContactInfo表主键 contactId --> PhoneNumInfo表外键 ownerId
     * 目标数据表中的外键由referencedJoinProperty指定。ownerId 是在PhoneNumInfo表中的外键，指向ContactInfo的主键 contactId
     */
    @ToMany(referencedJoinProperty = "ownerId")
    private List<PhoneNumInfo> phoneNumInfos;

    /**
     * 定义与多个实体对象的关系1：N
     * 一个联系人对应N张银行卡，1张银行卡对应1个联系人
     * 较为复杂的关系可以使用joinProperties属性，其值可以设置一系列的@JoinProperty(name = “XXXX”, referencedName = “YYYY”)
     * 目标实体类中YYYY属性指向源实体类XXXX的属性，其中YYYY为非空，XXXX为unique的，不一定是主键，这样的关系可以有多个
     * ContactInfo表主键 contactId --> BankCardInfo表外键 ownerId
     */
    @ToMany(joinProperties = {
            @JoinProperty(name = "contactId", referencedName = "ownerId")
    })
    private List<BankCardInfo> bankCardInfos;

    /**
     * 定义与多个实体对象的关系N：N
     * 一个联系人对应N种爱好，一种爱好对应N个联系人
     * 需要通过中间表实现。源实体类与目标实体类中均需要使用 @ToMany @JoinEntity(entity = ContactAndHobby.class, sourceProperty = "XXX",targetProperty = "YYY")注解
     */
    @ToMany
    @JoinEntity(entity = ContactAndHobby.class, sourceProperty = "contactId",targetProperty = "hobbyId")
    private List<HobbyInfo> hobbyInfos;

    /**
     * 不对该属性持久化，即添加此标记后不会在数据表中创建对应的列
     */
    @Transient
    private String email;

/** Used to resolve relations */
@Generated(hash = 2040040024)
private transient DaoSession daoSession;

/** Used for active entity operations. */
@Generated(hash = 1404638527)
private transient ContactInfoDao myDao;

@Generated(hash = 669811016)
private transient String idCardInfo__resolvedKey;

@Generated(hash = 1226179002)
public ContactInfo(String contactId, @NotNull String name, String job, String adress) {
    this.contactId = contactId;
    this.name = name;
    this.job = job;
    this.adress = adress;
}

@Generated(hash = 2019856331)
public ContactInfo() {
}

public String getContactId() {
    return this.contactId;
}

public void setContactId(String contactId) {
    this.contactId = contactId;
}

public String getName() {
    return this.name;
}

public void setName(String name) {
    this.name = name;
}

public String getJob() {
    return this.job;
}

public void setJob(String job) {
    this.job = job;
}

public String getAdress() {
    return this.adress;
}

public void setAdress(String adress) {
    this.adress = adress;
}

/** To-one relationship, resolved on first access. */
@Generated(hash = 305383589)
public IDCardInfo getIdCardInfo() {
    String __key = this.contactId;
    if (idCardInfo__resolvedKey == null || idCardInfo__resolvedKey != __key) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        IDCardInfoDao targetDao = daoSession.getIDCardInfoDao();
        IDCardInfo idCardInfoNew = targetDao.load(__key);
        synchronized (this) {
            idCardInfo = idCardInfoNew;
            idCardInfo__resolvedKey = __key;
        }
    }
    return idCardInfo;
}

/** called by internal mechanisms, do not call yourself. */
@Generated(hash = 1571298553)
public void setIdCardInfo(IDCardInfo idCardInfo) {
    synchronized (this) {
        this.idCardInfo = idCardInfo;
        contactId = idCardInfo == null ? null : idCardInfo.getIDNum();
        idCardInfo__resolvedKey = contactId;
    }
}

/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 1090130018)
public List<PhoneNumInfo> getPhoneNumInfos() {
    if (phoneNumInfos == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        PhoneNumInfoDao targetDao = daoSession.getPhoneNumInfoDao();
        List<PhoneNumInfo> phoneNumInfosNew = targetDao._queryContactInfo_PhoneNumInfos(contactId);
        synchronized (this) {
            if (phoneNumInfos == null) {
                phoneNumInfos = phoneNumInfosNew;
            }
        }
    }
    return phoneNumInfos;
}

/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 930671651)
public synchronized void resetPhoneNumInfos() {
    phoneNumInfos = null;
}

/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 1450979539)
public List<BankCardInfo> getBankCardInfos() {
    if (bankCardInfos == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        BankCardInfoDao targetDao = daoSession.getBankCardInfoDao();
        List<BankCardInfo> bankCardInfosNew = targetDao._queryContactInfo_BankCardInfos(contactId);
        synchronized (this) {
            if (bankCardInfos == null) {
                bankCardInfos = bankCardInfosNew;
            }
        }
    }
    return bankCardInfos;
}

/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 384178120)
public synchronized void resetBankCardInfos() {
    bankCardInfos = null;
}

/**
 * To-many relationship, resolved on first access (and after reset).
 * Changes to to-many relations are not persisted, make changes to the target entity.
 */
@Generated(hash = 1057707998)
public List<HobbyInfo> getHobbyInfos() {
    if (hobbyInfos == null) {
        final DaoSession daoSession = this.daoSession;
        if (daoSession == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        HobbyInfoDao targetDao = daoSession.getHobbyInfoDao();
        List<HobbyInfo> hobbyInfosNew = targetDao._queryContactInfo_HobbyInfos(contactId);
        synchronized (this) {
            if (hobbyInfos == null) {
                hobbyInfos = hobbyInfosNew;
            }
        }
    }
    return hobbyInfos;
}

/** Resets a to-many relationship, making the next get call to query for a fresh result. */
@Generated(hash = 786567202)
public synchronized void resetHobbyInfos() {
    hobbyInfos = null;
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
@Generated(hash = 323812056)
public void __setDaoSession(DaoSession daoSession) {
    this.daoSession = daoSession;
    myDao = daoSession != null ? daoSession.getContactInfoDao() : null;
}
}
