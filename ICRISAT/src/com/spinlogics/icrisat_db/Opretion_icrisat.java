package com.spinlogics.icrisat_db;
/*
 * Developed by Rana pratap
 */

import java.util.ArrayList;
import java.util.HashMap;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class Opretion_icrisat {

	private SQLiteDatabase db_obj;
	private ICRISAT BMDB_obj;

	public Opretion_icrisat(Context Ctx) {
		BMDB_obj = new ICRISAT(Ctx, null, null, 0);
	}

	public void open() {
		db_obj = BMDB_obj.getWritableDatabase();
	}

	public void close() {
		BMDB_obj.close();
	}

	public long INSERT_TABLE1(String rate,String name, String dm, String cp, String me,String ca,String p,String omd) {

		ContentValues initialValues = new ContentValues();

		

/*		
	public static final String T1_ID ="t1_id";
	public static final String T1_RATE ="t1_rate";
	public static final String T1_DM = "t1_dm";
	public static final String T1_CP="t1_cp";
	public static final String T1_ME ="t1_me";
	public static final String T1_CA="t1_ca";
	public static final String T1_P="t1_p";
	public static final String T1_OMD="t1_omd";*/

		initialValues.put(ICRISAT.T1_RATE, rate);
		initialValues.put(ICRISAT.T1_NAME, name);
		initialValues.put(ICRISAT.T1_DM, dm);
		initialValues.put(ICRISAT.T1_CP, cp);
		initialValues.put(ICRISAT.T1_ME, me);
		initialValues.put(ICRISAT.T1_CA, ca);
		initialValues.put(ICRISAT.T1_P, p);
		initialValues.put(ICRISAT.T1_OMD, omd);
		
		return db_obj.insert(ICRISAT.TABLE_ONE, null, initialValues);
	}
	
	
	
	
	public long INSERT_TABLE2(String rate,String name, String dm, String cp, String me,String ca,String p) {

		ContentValues initialValues = new ContentValues();

/*		
	public static final String T1_ID ="t1_id";
	public static final String T1_RATE ="t1_rate";
	public static final String T1_DM = "t1_dm";
	public static final String T1_CP="t1_cp";
	public static final String T1_ME ="t1_me";
	public static final String T1_CA="t1_ca";
	public static final String T1_P="t1_p";
	public static final String T1_OMD="t1_omd";*/

		initialValues.put(ICRISAT.T2_RATE, rate);
		initialValues.put(ICRISAT.T2_NAME, name);
		initialValues.put(ICRISAT.T2_DM, dm);
		initialValues.put(ICRISAT.T2_CP, cp);
		initialValues.put(ICRISAT.T2_ME, me);
		initialValues.put(ICRISAT.T2_CA, ca);
		initialValues.put(ICRISAT.T2_P, p);
		
		return db_obj.insert(ICRISAT.TABLE_TWO, null, initialValues);
	}
	
	
	

	public ArrayList<HashMap<String, String>> GET_TABBLE_ONE() {

		Cursor c = db_obj.rawQuery("select * from "+ICRISAT.TABLE_ONE, null);
		ArrayList<HashMap<String, String>> LISTITEMS = new ArrayList<HashMap<String, String>>();
		if (c.getCount() != 0) {
			if (c.moveToFirst()) {
				do {
					
					/*		
					public static final String T1_ID ="t1_id";
					public static final String T1_RATE ="t1_rate";
					public static final String T1_DM = "t1_dm";
					public static final String T1_CP="t1_cp";
					public static final String T1_ME ="t1_me";
					public static final String T1_CA="t1_ca";
					public static final String T1_P="t1_p";
					public static final String T1_OMD="t1_omd";*/					
					
					
					HashMap<String, String> vale = new HashMap<String, String>();
					vale.put(ICRISAT.T1_ID, c.getString(0));
					vale.put(ICRISAT.T1_NAME, c.getString(1));
					vale.put(ICRISAT.T1_RATE, c.getString(2));
					vale.put(ICRISAT.T1_DM, c.getString(3));
					vale.put(ICRISAT.T1_CP, c.getString(4));
					vale.put(ICRISAT.T1_ME, c.getString(5));
					vale.put(ICRISAT.T1_CA, c.getString(6));
					vale.put(ICRISAT.T1_P, c.getString(7));
					vale.put(ICRISAT.T1_OMD, c.getString(8));
					LISTITEMS.add(vale);
				} while (c.moveToNext());
			}
		} else if (c.getCount() == 0) {

			return null;
		}

		return LISTITEMS;
	}
	
	
	public ArrayList<Options_selected> GET_TABBLE_TWO() {

		Cursor c = db_obj.rawQuery("select * from "+ICRISAT.TABLE_TWO, null);
		ArrayList<Options_selected> LISTITEMS = new ArrayList<Options_selected>();
		if (c.getCount() != 0) {
			if (c.moveToFirst()) {
				do {
					
					Options_selected op=new Options_selected();
					/*		
					public static final String T2_ID ="t2_id";
					public static final String T2_RATE ="t2_rate";
					public static final String T2_DM = "t2_dm";
					public static final String T2_CP="t2_cp";
					public static final String T2_ME ="t2_me";
					public static final String T2_CA="t2_ca";
					public static final String T2_P="t2_p";*/					
					
Log.v("------------>", c.getString(1));
					op.setOptions_id(c.getString(0));

					op.setOptions_name(c.getString(1));
					op.setOptions_rate(c.getString(2));
					op.setOptions_dm( c.getString(3));
					op.setOptions_cp(c.getString(4));
					op.setOptions_me(c.getString(5));
					op.setOptions_ca(c.getString(6));
					op.setOptiuons_p(c.getString(7));
					LISTITEMS.add(op);
				} while (c.moveToNext());
			}
		} else if (c.getCount() == 0) {

			return null;
		}

		return LISTITEMS;
	}
	
	
	public ArrayList<HashMap<String, String>> getmedication_list(){

		Cursor c = db_obj.rawQuery("select * from Medication", null);
		ArrayList<HashMap<String, String>> LISTITEMS = new ArrayList<HashMap<String, String>>();
		Log.v("COUNTS OF THE DB", "-->"+c.getCount());
		if (c.getCount() != 0) {
	
			if (c.moveToFirst()) {
				do {
					HashMap<String, String> vale = new HashMap<String, String>();
					vale.put("MID", c.getString(0));
					vale.put("MNAME", c.getString(1));
					vale.put("MRX", c.getString(2));
					vale.put("MDOS", c.getString(3));
					vale.put("MFRQ", c.getString(4));
					vale.put("MPRE", c.getString(5));
					vale.put("MPUR", c.getString(6));
					LISTITEMS.add(vale);
				} while (c.moveToNext());
			}
		} else if (c.getCount() == 0) {

			return null;
		}

		return LISTITEMS;

	}

	public void UPDATE_TABLE_ONE(String name,String rate, String dm, String cp, String me,String ca,String p,String omd, String id) {
		ContentValues initialValues = new ContentValues();

		initialValues.put(ICRISAT.T1_NAME, name);
		initialValues.put(ICRISAT.T1_RATE, rate);
		initialValues.put(ICRISAT.T1_DM, dm);
		initialValues.put(ICRISAT.T1_CP, cp);
		initialValues.put(ICRISAT.T1_ME, me);
		initialValues.put(ICRISAT.T1_CA, ca);
		initialValues.put(ICRISAT.T1_P, p);
		initialValues.put(ICRISAT.T1_OMD, omd);

		db_obj.update(ICRISAT.TABLE_ONE, initialValues,
				"t1_id=" + id, null);

	}
	
	public void UPDATE_TABLE_TWO(String name,String rate, String dm, String cp, String me,String ca,String p, String id) {
		ContentValues initialValues = new ContentValues();

		initialValues.put(ICRISAT.T2_NAME, rate);
		initialValues.put(ICRISAT.T2_RATE, rate);
		initialValues.put(ICRISAT.T2_DM, dm);
		initialValues.put(ICRISAT.T2_CP, cp);
		initialValues.put(ICRISAT.T2_ME, me);
		initialValues.put(ICRISAT.T2_CA, ca);
		initialValues.put(ICRISAT.T2_P, p);

		db_obj.update(ICRISAT.TABLE_TWO, initialValues,
				"t2_id=" + id, null);

	}
	
	
	public boolean  check_records_T_ONE()
	{
		Cursor cursor = db_obj.rawQuery("SELECT * FROM "+ICRISAT.TABLE_ONE,null);
		if (cursor != null &&cursor.getCount()> 0) 
			return true;
		else
			return false;
	}
	public boolean  check_records_T_TWO()
	{
		Cursor cursor = db_obj.rawQuery("SELECT * FROM "+ICRISAT.TABLE_TWO,null);
	
		if (cursor != null &&cursor.getCount() > 0) 
			return true;
		else
			return false;
	}
	
	public boolean delete_TABLE_ONE(String aid) 
	{
	    return db_obj.delete(ICRISAT.TABLE_ONE, "t1_id"+ "=" + aid, null) > 0;
	}
	public boolean delete_TABLE_TWO(String aid) 
	{
	    return db_obj.delete(ICRISAT.TABLE_TWO, "t2_id"+ "=" + aid, null) > 0;
	}
	
}
