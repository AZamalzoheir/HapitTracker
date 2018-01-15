package com.example.amalzoheir.hapittracker.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Amalzoheir on 1/15/2018.
 */

public class hapitDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="shelter.db";
    private static final int DATABASE_VERSION=1;
    public  hapitDbHelper(Context context){super(context,DATABASE_NAME,null,DATABASE_VERSION);}

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_CREATE_PETS_TABLE =  "CREATE TABLE " + habitContract.habitEntry.TABLE_NAME+ " ("
                + habitContract.habitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + habitContract.habitEntry.COLUMN_habit_NAME + " TEXT NOT NULL,"
                + habitContract.habitEntry.COLUMN_habit_numberOfPractice+ " INTEGER NOT NULL);";
                sqLiteDatabase.execSQL(SQL_CREATE_PETS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
