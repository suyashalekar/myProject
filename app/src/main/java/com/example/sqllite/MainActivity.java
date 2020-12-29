package com.example.sqllite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase sqLiteDatabase = this.openOrCreateDatabase("User",MODE_PRIVATE,null);

        sqLiteDatabase.execSQL("Create table IF NOT EXISTS user(name varchar(10),age int(10))");
        sqLiteDatabase.execSQL("Insert into user values('suyash',20)");
        sqLiteDatabase.execSQL("Insert into user values('Alekar',29)");

      Cursor cursor =  sqLiteDatabase.rawQuery("select * from user ",null);
      int nameIndex = cursor.getColumnIndex("name");
      int ageIndex = cursor.getColumnIndex("age");

      cursor.moveToFirst();

      while (!cursor.isAfterLast()){
          Log.d("suyash","Name = " +cursor.getString(nameIndex));
          Log.d("suyash","Age = "+cursor.getString(ageIndex));

          cursor.moveToNext();
      }


    }
}