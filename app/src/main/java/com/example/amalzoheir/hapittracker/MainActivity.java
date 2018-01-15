package com.example.amalzoheir.hapittracker;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.amalzoheir.hapittracker.Data.habitContract;
import com.example.amalzoheir.hapittracker.Data.hapitDbHelper;

public class MainActivity extends AppCompatActivity {
    Button addHabit;
    TextView showData;
    private hapitDbHelper mDBHlper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addHabit=(Button)findViewById(R.id.button_add_habit);
        showData=(TextView)findViewById(R.id.display_view);
        mDBHlper=new hapitDbHelper(this);
        addHabit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                insertHabit();
            }
        });
    }
    private void insertHabit(){
        SQLiteDatabase db=mDBHlper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(habitContract.habitEntry.COLUMN_habit_NAME, "reading");
        contentValues.put(habitContract.habitEntry.COLUMN_habit_numberOfPractice, 7);
        long rowId=db.insert(habitContract.habitEntry.TABLE_NAME,null,contentValues);
    }
}
