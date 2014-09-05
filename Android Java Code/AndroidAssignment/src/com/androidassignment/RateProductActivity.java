package com.androidassignment;


import com.androidassignment.database.MyDBHandler;
import com.androidassignment.model.ProductModel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class RateProductActivity extends Activity implements SeekBar.OnSeekBarChangeListener,OnClickListener{

	SeekBar seekBar;
	Button  btnSubmit;
	int mProgress;
	String productName;
	ProductModel mProduct;
	MyDBHandler myDBHandler;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		  requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.rate_product);
		seekBar = (SeekBar)findViewById(R.id.seekBar1);
		seekBar.setOnSeekBarChangeListener(this);
		
		Intent intent = getIntent();
	    productName = intent.getStringExtra("product_name");
	
		btnSubmit = (Button)findViewById(R.id.btn_submit);
		btnSubmit.setOnClickListener(this);
		
		myDBHandler = new MyDBHandler(RateProductActivity.this);
		
	}
	

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
	
		// TODO Auto-generated method stub
		TextView tv=(TextView)findViewById(R.id.textView2);
		tv.setText(Integer.toString(progress));
		mProgress = progress;
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_submit:
			mProduct = new ProductModel();
			mProduct.setProductName(productName);
			mProduct.setQuantity(mProgress);
			
			Log.i("Set Quantity ",mProgress+"");
			myDBHandler.addProduct(mProduct);
		    finish();
			break;

		default:
			break;
		}
	}
	
	
}
