package com.hansung.android.project2;

import android.provider.BaseColumns;


/***********************************************************************************
 *                                                                                  *
 *   출처:https://github.com/kwanulee/Android/blob/master/examples/SQLiteDBTest     *
 *                                                                                  *
 ***********************************************************************************/




public final class UserContract {
    public static final String DB_NAME="user.db";
    public static final int DATABASE_VERSION = 1;
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private UserContract() {}

    /* Inner class that defines the table contents */
    public static class Users implements BaseColumns {
        public static final String TABLE_NAME="Restaurant";
        public static final String KEY_NAME = "Name";
        public static final String KEY_ADD = "Ad2d";
        public static final String KEY_TEL = "Tel";
        public static final String KEY_PHOTO = "Photo";


        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY" + COMMA_SEP +
                KEY_NAME + TEXT_TYPE + COMMA_SEP +
                KEY_ADD + TEXT_TYPE + COMMA_SEP +
                KEY_TEL + TEXT_TYPE + COMMA_SEP +
                KEY_PHOTO + TEXT_TYPE +  " )";
        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }
}