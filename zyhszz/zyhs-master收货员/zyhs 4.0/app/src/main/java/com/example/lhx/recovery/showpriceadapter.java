package com.example.lhx.recovery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class showpriceadapter extends ArrayAdapter<showpriceview> {
    private int showpriceid;
    public showpriceadapter(Context context, int resource, List<showpriceview> objects) {
        super(context, resource,objects);
        showpriceid = resource;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        showpriceview spw=getItem(position);
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(showpriceid, parent,false);
        } else {
            view = convertView;
        }
        ImageView img = view.findViewById(R.id.image1);
        TextView text = view.findViewById(R.id.text1);
        TextView price = view.findViewById(R.id.price);
        text.setText(spw.getText());
        Glide.with(view).load(spw.getPictureUrl()).into(img);
        price.setText(Double.toString(spw.getPrice()));
        return view;
    }
}
