package com.spinlogics.icrisat_db;
/*
 * Developed by Rana pratap
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class ICRISAT extends SQLiteOpenHelper {

	public static final String TABLE_ONE = "table_1";
	
	
	public static final String T1_ID ="t1_id";

	public static final String T1_NAME ="t1_name";
	public static final String T1_RATE ="t1_rate";
	public static final String T1_DM = "t1_dm";
	public static final String T1_CP="t1_cp";
	public static final String T1_ME ="t1_me";
	public static final String T1_CA="t1_ca";
	public static final String T1_P="t1_p";
	public static final String T1_OMD="t1_omd";
	
	public static final String TABLE_TWO = "table_2";
	
	public static final String T2_ID ="t2_id";
	public static final String T2_NAME ="t2_name";
	public static final String T2_RATE ="t2_rate";
	public static final String T2_DM = "t2_dm";
	public static final String T2_CP="t2_cp";
	public static final String T2_ME ="t2_me";
	public static final String T2_CA="t2_ca";
	public static final String T2_P="t2_p";
	

	// creating table..
	private static final String TABLE_CREATE_ONE = "CREATE TABLE " + TABLE_ONE
			+ "(" 
			+ T1_ID+" INTEGER PRIMARY KEY AUTOINCREMENT ," 
			+ T1_NAME+ " TEXT NOT NULL," 
			+ T1_RATE+ " TEXT NOT NULL," 
			+ T1_DM + " TEXT ," 
			+ T1_CP + " TEXT ," 
			+ T1_ME + " TEXT ," 
			+ T1_CA + " TEXT ,"
			+ T1_P + " TEXT ,"
			+ T1_OMD + " TEXT"
			+")";
	
	private static final String TABLE_CREATE_TWO = "CREATE TABLE " + TABLE_TWO
			+ "(" 
			+ T2_ID+" INTEGER PRIMARY KEY AUTOINCREMENT ," 
			+ T2_NAME+ " TEXT NOT NULL," 
			+ T2_RATE+ " TEXT NOT NULL," 
			+ T2_DM + " TEXT ," 
			+ T2_CP + " TEXT ," 
			+ T2_ME + " TEXT ," 
			+ T2_CA + " TEXT ,"
			+ T2_P + " TEXT"
			+")";
	

	private static final String DATABASE_NAME = "FORM.db";
	private static final int DATABASE_VERSION = 1;

	public ICRISAT(Context context, String name, CursorFactory factory,
			int version) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(TABLE_CREATE_ONE);
		db.execSQL(TABLE_CREATE_TWO);
		
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}
}
