package com.example.transaction;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyOpenHelper extends SQLiteOpenHelper {

	public MyOpenHelper(Context context) {
		super(context, "account.db", null, 1);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table info(_id integer primary key autoincrement,name varchar(20),money varchar(20))");
		ContentValues[] values = new ContentValues[2];
		values[0]=new ContentValues();
		values[0].put("name", "wangcheng");
		values[0].put("money", "3000");
		values[1]=new ContentValues();
		values[1].put("name", "chenhai");
		values[1].put("money", "5000");
		db.insert("info", null, values[0]);
		db.insert("info", null, values[1]);
	}


	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	

	}

}
