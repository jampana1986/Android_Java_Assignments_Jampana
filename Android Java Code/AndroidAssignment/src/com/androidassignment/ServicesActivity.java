package com.androidassignment;

import java.util.ArrayList;
import java.util.List;

import com.androidassignment.adapters.ServicesAdapter;
import com.androidassignment.model.ServiceItemModel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class ServicesActivity extends Activity {
	ListView list;
	ImageView imgResults;

	Integer[] imageId = { R.drawable.icon_settings, R.drawable.icon_settings,
			R.drawable.icon_settings, R.drawable.icon_settings,
			R.drawable.icon_settings, R.drawable.icon_settings,
			R.drawable.icon_settings };

	 String[] products = { "PRODUCT 1", "PRODUCT 2", "PRODUCT 3", "PRODUCT 4",
			"PRODUCT 5", "PRODUCT 6", "PRODUCT 7" };
	 List<ServiceItemModel> rowItems;
	 
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		  requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		setContentView(R.layout.products);
		
		
		imgResults = (ImageView)findViewById(R.id.img_results);
		
		imgResults.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				Intent intent = new Intent(ServicesActivity.this,ResultsActivity.class);
				startActivity(intent);
				
			}
		});
		
		
		rowItems = new ArrayList<ServiceItemModel>();
        for (int i = 0; i < products.length; i++) {
        	ServiceItemModel item = new ServiceItemModel(imageId[i], products[i]);
            rowItems.add(item);
        }
        
        
		ServicesAdapter adapter = new ServicesAdapter(ServicesActivity.this,R.layout.products_item, rowItems);
		list = (ListView) findViewById(R.id.list_services);
		list.setAdapter(adapter);
	    
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Toast.makeText(ServicesActivity.this,
						"You Clicked at " + products[+position],
						Toast.LENGTH_SHORT).show();
				

				Intent intent = new Intent(ServicesActivity.this,RateProductActivity.class);
				intent.putExtra("product_name", products[+position]);
				startActivity(intent);
				
			}
		});
		
		
		
	}
	
	
	
	
}
