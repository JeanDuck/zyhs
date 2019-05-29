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
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(orderid,parent,false);
        } else {
            view = convertView;
        }
        TextView time = view.findViewById(R.id.time);
        TextView state = view.findViewById(R.id.state);
        TextView address = view.findViewById(R.id.address);
        TextView salepeople = view.findViewById(R.id.salepeople);
        TextView buypeople = view.findViewById(R.id.buypeople);
        TextView orderdes = view.findViewById(R.id.orderdes);
        TextView sum = view.findViewById(R.id.sum);
        time.setText("订单时间："+order.getTime());
        state.setText("订单状态："+order.getState());
        address.setText("订单地址："+order.getAddress());
        salepeople.setText("用户："+order.getSalepeople());
        buypeople.setText("收货员："+order.getBuypeople());
        orderdes.setText("订单详情："+order.getOrderdes());
        sum.setText("订单总价："+order.getSum());
        return view;
    }




}
