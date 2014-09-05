package com.androidassignment.database;

import java.util.ArrayList;
import java.util.List;

import com.androidassignment.model.ProductModel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDBHandler extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "productDB.db";
	public static final String TABLE_PRODUCTS = "products";

	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_PRODUCTNAME = "_productname";
	public static final String COLUMN_RATING = "_rating";

	public MyDBHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Creating Database Tables
	@Override
	public void onCreate(SQLiteDatabase db) {

		String CREATE_PRODUCTS_TABLE = "CREATE TABLE " + TABLE_PRODUCTS + "("
				+ COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_PRODUCTNAME
				+ " TEXT," + COLUMN_RATING + " INTEGER" + ")";

		db.execSQL(CREATE_PRODUCTS_TABLE);
	}

	// Updating tables
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
		onCreate(db);
	}

	public void addProduct(ProductModel mProduct) {

		
        ContentValues values = new ContentValues();
        values.put(COLUMN_PRODUCTNAME, mProduct.getProductName());
        values.put(COLUMN_RATING, mProduct.getQuantity());
 
        SQLiteDatabase db = this.getWritableDatabase();
        
        db.insert(TABLE_PRODUCTS, null, values);
        
        db.close();
}
	
	
	public double getProduct_1Data(String productname)	{
		String query_1 = "Select * FROM " + TABLE_PRODUCTS + " WHERE " + COLUMN_PRODUCTNAME + " =  \"" + productname + "\"";
		Cursor cursor1 = null ;
		double avgResult_1 = 0;
		double sum_1 = 0;
		SQLiteDatabase db = this.getWritableDatabase();
//		if(productname.equalsIgnoreCase("PRODUCT 1")){
			cursor1 = db.rawQuery(query_1, null);
//		}
		
		List<Integer> product_1_data = new ArrayList<Integer>();
		if (cursor1.moveToFirst()) {
			
			cursor1.moveToFirst();
			
			for(int i=0;i<cursor1.getCount();i++){
				
			    product_1_data.add(Integer.parseInt(cursor1.getString(2)));
			    sum_1 = sum_1 + product_1_data.get(i);
			 }
			
			avgResult_1 = sum_1/product_1_data.size();
			 
			cursor1.close();
			
		}
		
	        db.close();
		
		return avgResult_1;
	}
	
	

	
	public double getProduct_2Data()	{
		
		return 0;
	}
	public double getProduct_3Data()	{
		
		return 0;
	}
	public double getProduct_4Data()	{
		
		return 0;
	}
	public double getProduct_5Data()	{
		
		return 0;
	}
	public double getProduct_6Data()	{
		
		return 0;
	}
	
	
	
	
}
