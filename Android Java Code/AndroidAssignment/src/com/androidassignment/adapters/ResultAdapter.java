package com.androidassignment.adapters;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidassignment.R;
import com.androidassignment.model.ResultModel;
import com.androidassignment.model.ServiceItemModel;

public class ResultAdapter extends ArrayAdapter<ResultModel> implements OnClickListener {
	
	private final Context context;
	private List<ResultModel> items;
	
	public ResultAdapter(Context context,int resourceId,List<ResultModel> items) {
        super(context, resourceId,items);
        this.context = context;
        this.items = items;
        
        Log.i("At ","Result Adapter");
	}
	
	 /*private view holder class*/
    private class ViewHolder {
    	TextView txtMTD;
        TextView txtYTD;
        TextView txtProduct;
    }
     
    
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		   Log.i("At ","Result Adapter view");
		 ViewHolder holder = null;
		 ResultModel rowItem = getItem(position);
		 LayoutInflater mInflater = (LayoutInflater) context
	                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
	        if (convertView == null) {
	            convertView = mInflater.inflate(R.layout.result_items, null);
	            holder = new ViewHolder();
	            holder.txtMTD = (TextView) convertView.findViewById(R.id.txt_mtd);
	            holder.txtYTD = (TextView) convertView.findViewById(R.id.txt_ytd);
	            holder.txtProduct = (TextView) convertView.findViewById(R.id.txt_product);
	            convertView.setTag(holder);
	        } else
	            holder = (ViewHolder) convertView.getTag();
	                 
	        int itemNo = position+1;
	        holder.txtMTD.setText(rowItem.mtd+"");
	        holder.txtYTD.setText(rowItem.ytd+"");
	        holder.txtProduct.setText("PRODUCT "+itemNo);
	        return convertView;
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
}
