package com.androidassignment;

import java.util.ArrayList;
import java.util.List;

import com.androidassignment.adapters.ResultAdapter;
import com.androidassignment.adapters.ServicesAdapter;
import com.androidassignment.database.MyDBHandler;
import com.androidassignment.model.ResultModel;
import com.androidassignment.model.ServiceItemModel;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ListView;
import android.widget.ProgressBar;

public class ResultsActivity extends Activity {

	MyDBHandler myDBHandler;
	ProgressBar mProgress;

	String[] arryRes;
	ListView listView;
	ResultAdapter myResAdapter;
	String r1, r2, r3, r4, r5, r6;
	List<String> myList;
	List<ResultModel> rowItems;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		  requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.results);

		myDBHandler = new MyDBHandler(ResultsActivity.this);

		mProgress = (ProgressBar) findViewById(R.id.progressBar1);
		listView = (ListView) findViewById(R.id.list_ratings);

		new loadDataAsync().execute();
	}

	public class loadDataAsync extends AsyncTask<String, String, String> {
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
		}

		@Override
		protected String doInBackground(String... params) {

			readData();
			return null;
		}

		@Override
		protected void onPostExecute(String result) {
			mProgress.setVisibility(View.GONE);
			
			ResultAdapter adapter = new ResultAdapter(ResultsActivity.this,
					R.layout.result_items, rowItems);
			listView.setAdapter(adapter);

		}
	}

	public void readData() {

		myList = new ArrayList<String>();

		try {
			for (int i = 0; i < 6; i++) {

				myList.add(myDBHandler.getProduct_1Data("PRODUCT " + i) + "");

				Log.e("++++++++++++", myList.get(i) + "");
			}
			
			arryRes  = myList.toArray(new String[myList.size()]);
			
			rowItems = new ArrayList<ResultModel>();
			for (int i = 0; i < arryRes.length; i++) {
				ResultModel item = new ResultModel(arryRes[i], arryRes[i]);
				rowItems.add(item);
			}

			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
