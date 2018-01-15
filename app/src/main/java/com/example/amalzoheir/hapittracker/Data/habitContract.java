package com.example.amalzoheir.hapittracker.Data;

import android.provider.BaseColumns;

/**
 * Created by Amalzoheir on 1/15/2018.
 */

public final class habitContract {
    private habitContract(){}
    public static final class habitEntry implements BaseColumns {

        public final static String TABLE_NAME="habit";
        public final static String _ID=BaseColumns._ID;
        public final static String COLUMN_habit_NAME="name";
        public final static String COLUMN_habit_numberOfPractice="_numberOfPractice";

    }

}
