package com.fxp.contact.core.greendao.gen;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import com.fxp.contact.core.entity.PhoneNumInfo;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "PHONE_NUM_INFO".
*/
public class PhoneNumInfoDao extends AbstractDao<PhoneNumInfo, String> {

    public static final String TABLENAME = "PHONE_NUM_INFO";

    /**
     * Properties of entity PhoneNumInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property PhoneNum = new Property(0, String.class, "phoneNum", true, "PHONE_NUM");
        public final static Property OwnerId = new Property(1, String.class, "ownerId", false, "OWNER_ID");
        public final static Property Type = new Property(2, int.class, "type", false, "TYPE");
        public final static Property Area = new Property(3, String.class, "area", false, "AREA");
    }

    private Query<PhoneNumInfo> contactInfo_PhoneNumInfosQuery;

    public PhoneNumInfoDao(DaoConfig config) {
        super(config);
    }
    
    public PhoneNumInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"PHONE_NUM_INFO\" (" + //
                "\"PHONE_NUM\" TEXT PRIMARY KEY NOT NULL UNIQUE ," + // 0: phoneNum
                "\"OWNER_ID\" TEXT," + // 1: ownerId
                "\"TYPE\" INTEGER NOT NULL ," + // 2: type
                "\"AREA\" TEXT);"); // 3: area
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"PHONE_NUM_INFO\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, PhoneNumInfo entity) {
        stmt.clearBindings();
        stmt.bindString(1, entity.getPhoneNum());
 
        String ownerId = entity.getOwnerId();
        if (ownerId != null) {
            stmt.bindString(2, ownerId);
        }
        stmt.bindLong(3, entity.getType());
 
        String area = entity.getArea();
        if (area != null) {
            stmt.bindString(4, area);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, PhoneNumInfo entity) {
        stmt.clearBindings();
        stmt.bindString(1, entity.getPhoneNum());
 
        String ownerId = entity.getOwnerId();
        if (ownerId != null) {
            stmt.bindString(2, ownerId);
        }
        stmt.bindLong(3, entity.getType());
 
        String area = entity.getArea();
        if (area != null) {
            stmt.bindString(4, area);
        }
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.getString(offset + 0);
    }    

    @Override
    public PhoneNumInfo readEntity(Cursor cursor, int offset) {
        PhoneNumInfo entity = new PhoneNumInfo( //
            cursor.getString(offset + 0), // phoneNum
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // ownerId
            cursor.getInt(offset + 2), // type
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3) // area
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, PhoneNumInfo entity, int offset) {
        entity.setPhoneNum(cursor.getString(offset + 0));
        entity.setOwnerId(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setType(cursor.getInt(offset + 2));
        entity.setArea(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
     }
    
    @Override
    protected final String updateKeyAfterInsert(PhoneNumInfo entity, long rowId) {
        return entity.getPhoneNum();
    }
    
    @Override
    public String getKey(PhoneNumInfo entity) {
        if(entity != null) {
            return entity.getPhoneNum();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(PhoneNumInfo entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "phoneNumInfos" to-many relationship of ContactInfo. */
    public List<PhoneNumInfo> _queryContactInfo_PhoneNumInfos(String ownerId) {
        synchronized (this) {
            if (contactInfo_PhoneNumInfosQuery == null) {
                QueryBuilder<PhoneNumInfo> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.OwnerId.eq(null));
                contactInfo_PhoneNumInfosQuery = queryBuilder.build();
            }
        }
        Query<PhoneNumInfo> query = contactInfo_PhoneNumInfosQuery.forCurrentThread();
        query.setParameter(0, ownerId);
        return query.list();
    }

}
