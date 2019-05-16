package com.example.lhx.recovery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.view.View;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class lookorder extends AppCompatActivity {
    private Button btn_finished;//显示已完成订单按钮
    private Button btn_unfinished;//显示未完成订单按钮
    private RadioGroup rpTab;
   //两个按钮功能尚未实现
    private List<Orderlistview> orderList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look_order);//查看订单界面

        initOrder();//测试
        orderadapter adapter=new orderadapter(lookorder.this,R.layout.orderlistviewitem,orderList);
        ListView listview=(ListView)findViewById(R.id.orderlist);
        listview.setAdapter(adapter);


        btn_finished = (Button) findViewById(R.id.finished);
        btn_finished.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initOrderfinished();
                //显示已完成订单
            }
        });
        btn_unfinished = (Button) findViewById(R.id.unfinished);
        btn_unfinished.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initOrderunfinished();

                //显示未完成订单
            }
        });




    }
    private void initOrder()
    {

        for(int i=0;i<10;i++)
        {


            Orderlistview order=new Orderlistview("date","state","xxx","xxx",R.drawable.test_image);
            orderList.add(order);

        }


    }

    private  void initOrderfinished(){
        //10项不定
        //String time,String state,String orderdes,String sum,int imageid
        for(int i=0;i<10;i++)
        {
            Intent intent = getIntent();
            String data = intent.getStringExtra("date+time");
            String state=intent.getStringExtra("state");

            Orderlistview order=new Orderlistview(data,state,"xxx","xxx",R.drawable.test_image);
            orderList.add(order);

        }

    }

    private  void initOrderunfinished(){
        //10项不定
        //String time,String state,String orderdes,String sum,int imageid
        for(int i=0;i<10;i++)
        {
            Intent intent = getIntent();
            String data = intent.getStringExtra("date+time");//订单时间
            String state=intent.getStringExtra("state");//订单状态
            String thingstype=intent.getStringExtra("thingstype");
            String thingsnumber=intent.getStringExtra("thingsnumber");
            String sum=intent.getStringExtra("sum");//订单总价
            String orderdescription="商品种类:"+thingstype+"\n"+"商品数量:"+thingsnumber+"\n";//订单描述
            Orderlistview order=new Orderlistview(data,state,orderdescription,sum,R.drawable.test_image);
            orderList.add(order);

        }

    }
}
