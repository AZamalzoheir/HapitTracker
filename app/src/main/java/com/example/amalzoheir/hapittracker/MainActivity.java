package com.example.amalzoheir.hapittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.amalzoheir.hapittracker.Data.habitContract;
import com.example.amalzoheir.hapittracker.Data.hapitDbHelper;

public class MainActivity extends AppCompatActivity {
    Button addHabit;
    Button displayHabit;
    TextView showData;
    private hapitDbHelper mDBHlper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addHabit = (Button) findViewById(R.id.button_add_habit);
        displayHabit = (Button) findViewById(R.id.display_habit);
        showData = (TextView) findViewById(R.id.display_view);
        mDBHlper = new hapitDbHelper(this);
        addHabit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertHabit();
            }
        });
        displayHabit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayDatabaseInfo();
            }
        });
    }

    private void displayDatabaseInfo() {
        Cursor cursor = read();
        try {
            showData.setText("Number of rows in pets database table: " + cursor.getCount());
            int idIndex = cursor.getColumnIndex(habitContract.habitEntry._ID);
            int nameIndex = cursor.getColumnIndex(habitContract.habitEntry.COLUMN_habit_NAME);
            int numberOfPracticeIndex = cursor.getColumnIndex(habitContract.habitEntry.COLUMN_habit_numberOfPractice);
            while (cursor.moveToNext()) {
                int id = cursor.getInt(idIndex);
                String name = cursor.getString(nameIndex);
                int numberOfPractice = cursor.getInt(numberOfPracticeIndex);
                showData.append("\n" + id + "-" + name + "-" + numberOfPractice);
            }

        } finally {
            cursor.close();
        }
    }
    private Cursor read(){
        hapitDbHelper mDbHelper = new hapitDbHelper(this);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        String[] projection = {
                habitContract.habitEntry._ID,
                habitContract.habitEntry.COLUMN_habit_NAME,
                habitContract.habitEntry.COLUMN_habit_numberOfPractice
        };
        Cursor cursor = db.query(habitContract.habitEntry.TABLE_NAME, projection, null, null, null, null, null);
        return cursor;
    }
    private void insertHabit() {
        SQLiteDatabase db = mDBHlper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(habitContract.habitEntry.COLUMN_habit_NAME, "reading");
        contentValues.put(habitContract.habitEntry.COLUMN_habit_numberOfPractice, 7);
        db.insert(habitContract.habitEntry.TABLE_NAME, null, contentValues);
    }
}
