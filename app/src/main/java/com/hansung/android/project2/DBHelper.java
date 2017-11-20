package com.hansung.android.project2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/***********************************************************************************
 *                                                                                  *
 *   출처:https://github.com/kwanulee/Android/blob/master/examples/SQLiteDBTest     *
 *                                                                                  *
 ***********************************************************************************/

public class DBHelper extends SQLiteOpenHelper {
    final static String TAG="SQLiteDBTest";

    public DBHelper(Context context) {
        super(context, UserContract.DB_NAME, null, UserContract.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(TAG,UserContract.Users.CREATE_TABLE);
        db.execSQL(UserContract.Users.CREATE_TABLE);
        Log.i(TAG,getClass().getName()+".onCreate()");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        Log.i(TAG,getClass().getName() +".onUpgrade()");
        db.execSQL(UserContract.Users.DELETE_TABLE);
        onCreate(db);
    }


    public long insertUserByMethod(String Name, String Add,  String Tel,  String Photo) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(UserContract.Users.KEY_NAME, Name);
        values.put(UserContract.Users.KEY_ADD, Add);
        values.put(UserContract.Users.KEY_TEL, Tel);
        values.put(UserContract.Users.KEY_PHOTO, Photo);


        return db.insert(UserContract.Users.TABLE_NAME,null,values);
    }

    public Cursor getAllUsersByMethod() {
        SQLiteDatabase db = getReadableDatabase();
        return db.query(UserContract.Users.TABLE_NAME,null,null,null,null,null,null);
    }



    public long updateUserByMethod(String _id, String Name, String Add,  String Tel,  String Photo) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(UserContract.Users.KEY_NAME, Name);
        values.put(UserContract.Users.KEY_ADD, Add);
        values.put(UserContract.Users.KEY_TEL, Tel);
        values.put(UserContract.Users.KEY_PHOTO, Photo);

        String whereClause = UserContract.Users._ID +" = ?";
        String[] whereArgs ={_id};

        return db.update(UserContract.Users.TABLE_NAME, values, whereClause, whereArgs);
    }

}