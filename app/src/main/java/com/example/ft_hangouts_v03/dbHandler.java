package com.example.ft_hangouts_v03;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class dbHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contactsManager";
    private static final String TABLE_CONTACTS = "contacts";
    private static final String KEY_ID = "id";
    private static final String KEY_F_NAME = "first_name";
    private static final String KEY_L_NAME = "last_name";
    private static final String KEY_PH_NR = "phone_nr";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_STREET = "street";

    public dbHandler(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String CREATE_MY_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "(" +
                KEY_ID + "INTEGER PRIMARY KEY," +
                KEY_F_NAME + "TEXT," +
                KEY_L_NAME + "TEXT," +
                KEY_PH_NR + "TEXT," +
                KEY_EMAIL + "TEXT," +
                KEY_STREET + "TEXT" + ")";
        db.execSQL(CREATE_MY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        onCreate(db);
    }

    void addContact(Contact contact)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_F_NAME, contact.getFirstName());
        values.put(KEY_L_NAME, contact.getLastName());
        values.put(KEY_PH_NR, contact.getPhoneNr());
        values.put(KEY_EMAIL, contact.getEmail());
        values.put(KEY_STREET, contact.getStreet());

        db.insert(TABLE_CONTACTS, null, values);
        db.close();
    }

    Contact getContact(int id)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS, new String[] {KEY_ID, KEY_F_NAME, KEY_L_NAME, KEY_PH_NR, KEY_EMAIL, KEY_STREET}, KEY_ID + "=?",
                new String[] {String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        Contact contact = new Contact(Integer.parseInt(
                cursor.getString(0)), cursor.getString(1), cursor.getString(2),
                cursor.getString(3), cursor.getString(4), cursor.getString(5));
        return contact;
    }

    public ArrayList<Contact> getAllContacts()
    {
        ArrayList<Contact> contactList = new ArrayList<Contact>();

        String selectQuery = "SELECT * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst())
        {
            do
            {
                Contact contact = new Contact();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setFirstName(cursor.getString(1));
                contact.setLastName(cursor.getString(2));
                contact.setPhoneNr(cursor.getString(3));
                contact.setEmail(cursor.getString(4));
                contact.setStreet(cursor.getString(5));

                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        return contactList;
    }

    public boolean updateContact(Contact contact, Integer id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_F_NAME, contact.getFirstName());
        values.put(KEY_L_NAME, contact.getLastName());
        values.put(KEY_PH_NR, contact.getPhoneNr());
        values.put(KEY_EMAIL, contact.getEmail());
        values.put(KEY_STREET, contact.getStreet());

        if (db.update(TABLE_CONTACTS, values, KEY_ID + "= ?", new String[] {String.valueOf(id)}) == -1)
            return false;
        return true;
    }

    public void deleteContact(int id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID + " = ?", new String[] {String.valueOf(id)});
    }

    public int getContactCount()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_CONTACTS, null);
        cursor.close();
        return cursor.getCount();
    }
}
