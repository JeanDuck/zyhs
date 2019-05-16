package com.example.lhx.recovery;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class orderadapter extends ArrayAdapter <Orderlistview> {
    private int orderid;
    public orderadapter(Context context, int textViewResourceId, List<Orderlistview> objects){
        super(context,textViewResourceId,objects);
        orderid=textViewResourceId;

    }

    @NonNull
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        Orderlistview order=getItem(position);
        View view=LayoutInflater.from(getContext()).inflate(orderid,parent,false);
        ImageView orderimage=( ImageView) view.findViewById(R.id.jgimg_1);
        TextView time=(TextView) view.findViewById(R.id.time);
        TextView state=(TextView) view.findViewById(R.id.state);
        TextView orderdes=(TextView) view.findViewById(R.id.orderdes);
        TextView sum=(TextView) view.findViewById(R.id.sum);

        return view;
    }




}
