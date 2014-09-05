package com.androidassignment.adapters;

import java.util.List;

import com.androidassignment.R;
import com.androidassignment.model.ServiceItemModel;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ServicesAdapter extends ArrayAdapter<ServiceItemModel> implements OnClickListener {
	
	private final Context context;
	private List<ServiceItemModel> items;
	
	public ServicesAdapter(Context context,int resourceId,List<ServiceItemModel> items) {
        super(context, resourceId, items);
        this.context = context;
        this.items = items;
        
	}
	
	 /*private view holder class*/
    private class ViewHolder {
        ImageView imageView;
        TextView txtProduct;
    }
     
    
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		 ViewHolder holder = null;
		 ServiceItemModel rowItem = getItem(position);
		 LayoutInflater mInflater = (LayoutInflater) context
	                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
	        if (convertView == null) {
	            convertView = mInflater.inflate(R.layout.products_item, null);
	            holder = new ViewHolder();
	            holder.txtProduct = (TextView) convertView.findViewById(R.id.txt_product_name);
	            holder.imageView = (ImageView) convertView.findViewById(R.id.img_item);
	            convertView.setTag(holder);
	        } else
	            holder = (ViewHolder) convertView.getTag();
	                 
	        holder.txtProduct.setText(rowItem.product);
	        holder.imageView.setImageResource(rowItem.imageId);
	         
	        return convertView;
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
}
