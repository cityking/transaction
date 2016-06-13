package com.example.transaction;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	MyOpenHelper openHelper;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		openHelper = new MyOpenHelper(this);
	}

	public void click(View v) {
		SQLiteDatabase db = openHelper.getWritableDatabase();

		db.beginTransaction();
		try {
			db.execSQL("update info set money=money-200 where name=?", new Object[] { "wangcheng" });
			
			db.execSQL("update info set money=money+200 where name=?", new Object[] { "chenhai" });
			db.setTransactionSuccessful();
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), "·þÎñÆ÷Ã¦£¬ÇëÉÔºó", 0).show();
		} finally {
			db.endTransaction();
		}
		db.close();
	}

}
