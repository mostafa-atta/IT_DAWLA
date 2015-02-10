package com.example.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class UsersDBHelper extends SQLiteOpenHelper {

	
	
	
	public UsersDBHelper(Context context) {
		super(context, "Users", null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String creation = "Create Table Users (" +
				"id INTEGER PRIMARY KEY," +
				"name varchar(150)" +
				")";
		db.execSQL(creation);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS Users");
		onCreate(db);
	}
	
	public void addUser(User u){
		
		ContentValues cv = new ContentValues();
		cv.put("id", u.getId());
		cv.put("name", u.getName());
		
		SQLiteDatabase db = this.getWritableDatabase();
		db.insert("Users", null, cv);
		db.close();
		
	}
	
	public User getUser(int id){
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor c = db.rawQuery("Select * from users where id = "+ id, null);
		c.moveToFirst();
		return new User(Integer.parseInt(c.getString(0)),c.getString(1));
		
	}

}
