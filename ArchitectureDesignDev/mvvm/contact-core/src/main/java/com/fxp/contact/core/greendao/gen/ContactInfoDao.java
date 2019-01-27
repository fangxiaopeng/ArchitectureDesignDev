package com.fxp.contact.core.greendao.gen;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.SqlUtils;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import com.fxp.contact.core.entity.ContactAndHobby;
import com.fxp.contact.core.entity.IDCardInfo;

import com.fxp.contact.core.entity.ContactInfo;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "CONTACT_INFO".
*/
public class ContactInfoDao extends AbstractDao<ContactInfo, String> {

    public static final String TABLENAME = "CONTACT_INFO";

    /**
     * Properties of entity ContactInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property ContactId = new Property(0, String.class, "contactId", true, "CONTACT_ID");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Job = new Property(2, String.class, "job", false, "job");
        public final static Property Adress = new Property(3, String.class, "adress", false, "ADRESS");
    }

    private DaoSession daoSession;

    private Query<ContactInfo> hobbyInfo_ContactInfosQuery;

    public ContactInfoDao(DaoConfig config) {
        super(config);
    }
    
    public ContactInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, ContactInfo entity) {
        stmt.clearBindings();
 
        String contactId = entity.getContactId();
        if (contactId != null) {
            stmt.bindString(1, contactId);
        }
        stmt.bindString(2, entity.getName());
 
        String job = entity.getJob();
        if (job != null) {
            stmt.bindString(3, job);
        }
 
        String adress = entity.getAdress();
        if (adress != null) {
            stmt.bindString(4, adress);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, ContactInfo entity) {
        stmt.clearBindings();
 
        String contactId = entity.getContactId();
        if (contactId != null) {
            stmt.bindString(1, contactId);
        }
        stmt.bindString(2, entity.getName());
 
        String job = entity.getJob();
        if (job != null) {
            stmt.bindString(3, job);
        }
 
        String adress = entity.getAdress();
        if (adress != null) {
            stmt.bindString(4, adress);
        }
    }

    @Override
    protected final void attachEntity(ContactInfo entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    @Override
    public ContactInfo readEntity(Cursor cursor, int offset) {
        ContactInfo entity = new ContactInfo( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // contactId
            cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // job
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3) // adress
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, ContactInfo entity, int offset) {
        entity.setContactId(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setName(cursor.getString(offset + 1));
        entity.setJob(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setAdress(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
     }
    
    @Override
    protected final String updateKeyAfterInsert(ContactInfo entity, long rowId) {
        return entity.getContactId();
    }
    
    @Override
    public String getKey(ContactInfo entity) {
        if(entity != null) {
            return entity.getContactId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(ContactInfo entity) {
        return entity.getContactId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "contactInfos" to-many relationship of HobbyInfo. */
    public List<ContactInfo> _queryHobbyInfo_ContactInfos(String hobbyId) {
        synchronized (this) {
            if (hobbyInfo_ContactInfosQuery == null) {
                QueryBuilder<ContactInfo> queryBuilder = queryBuilder();
                queryBuilder.join(ContactAndHobby.class, ContactAndHobbyDao.Properties.ContactId)
                    .where(ContactAndHobbyDao.Properties.HobbyId.eq(hobbyId));
                hobbyInfo_ContactInfosQuery = queryBuilder.build();
            }
        }
        Query<ContactInfo> query = hobbyInfo_ContactInfosQuery.forCurrentThread();
        query.setParameter(0, hobbyId);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getIDCardInfoDao().getAllColumns());
            builder.append(" FROM CONTACT_INFO T");
            builder.append(" LEFT JOIN IDCARD_INFO T0 ON T.\"CONTACT_ID\"=T0.\"IDNUM\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected ContactInfo loadCurrentDeep(Cursor cursor, boolean lock) {
        ContactInfo entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        IDCardInfo idCardInfo = loadCurrentOther(daoSession.getIDCardInfoDao(), cursor, offset);
        entity.setIdCardInfo(idCardInfo);

        return entity;    
    }

    public ContactInfo loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<ContactInfo> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<ContactInfo> list = new ArrayList<ContactInfo>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<ContactInfo> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<ContactInfo> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
