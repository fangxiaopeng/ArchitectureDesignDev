package com.fxp.contact.core.greendao.gen;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.fxp.contact.core.entity.ContactAndHobby;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "CONTACT_AND_HOBBY".
*/
public class ContactAndHobbyDao extends AbstractDao<ContactAndHobby, Long> {

    public static final String TABLENAME = "CONTACT_AND_HOBBY";

    /**
     * Properties of entity ContactAndHobby.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property ContactId = new Property(1, String.class, "contactId", false, "CONTACT_ID");
        public final static Property HobbyId = new Property(2, String.class, "hobbyId", false, "HOBBY_ID");
    }


    public ContactAndHobbyDao(DaoConfig config) {
        super(config);
    }
    
    public ContactAndHobbyDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"CONTACT_AND_HOBBY\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"CONTACT_ID\" TEXT," + // 1: contactId
                "\"HOBBY_ID\" TEXT);"); // 2: hobbyId
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CONTACT_AND_HOBBY\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, ContactAndHobby entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String contactId = entity.getContactId();
        if (contactId != null) {
            stmt.bindString(2, contactId);
        }
 
        String hobbyId = entity.getHobbyId();
        if (hobbyId != null) {
            stmt.bindString(3, hobbyId);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, ContactAndHobby entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String contactId = entity.getContactId();
        if (contactId != null) {
            stmt.bindString(2, contactId);
        }
 
        String hobbyId = entity.getHobbyId();
        if (hobbyId != null) {
            stmt.bindString(3, hobbyId);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public ContactAndHobby readEntity(Cursor cursor, int offset) {
        ContactAndHobby entity = new ContactAndHobby( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // contactId
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2) // hobbyId
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, ContactAndHobby entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setContactId(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setHobbyId(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(ContactAndHobby entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(ContactAndHobby entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(ContactAndHobby entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
