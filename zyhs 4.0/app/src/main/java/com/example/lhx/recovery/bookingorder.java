package com.example.lhx.recovery;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bookingorder extends AppCompatActivity {
    private Button date_btn,time_btn;
    private TextView tvdate1,tvtime2;//分别用于显示日期和时间
    private TextView tvaddress;//显示收货地址
    private EditText thingtpye;//输入物品种类
    private EditText thingnumber;//输入物品数量
    private Button chooseaddress;//选择地址
    private Button createod;//创建预约按钮

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_booking_order);
        //选择日期
        date_btn= (Button)findViewById(R.id.choosedate);
        date_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bookingorder.this,choosedate.class);
                startActivity(intent);
            }
        });
        //选择时间
        time_btn=(Button)findViewById(R.id.choosetime);
        time_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bookingorder.this,choosetime.class);
                startActivity(intent);
            }

        });
        //日期显示
        tvdate1 = (TextView)findViewById(R.id.bookdate);
        Intent intent = getIntent();
        String data = intent.getStringExtra("extra_data");
        tvdate1.setText(data);
        //时间显示
        tvtime2 = (TextView)findViewById(R.id.booktime);
        Intent intent2 = getIntent();
        String data2 = intent2.getStringExtra("extra_data1");
        tvtime2.setText(data2);

        tvaddress=(TextView)findViewById(R.id.addresschoose);
        thingtpye=(EditText)findViewById(R.id.thingstype);
        thingnumber=(EditText)findViewById(R.id.thingsnumber);
        chooseaddress=(Button)findViewById(R.id.chooseadd);
        createod=(Button)findViewById(R.id.createbook);
        createod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String urlStr="xxxxxxxxxxxx";
                final String tvadd=tvaddress.getText().toString().trim();
                final String date=tvdate1.getText().toString().trim();
                final String time=tvtime2.getText().toString().trim();
                final String thingtp=thingtpye.getText().toString().trim();
                final String thingnm=thingnumber.getText().toString().trim();
                if("".equals(tvadd))
                {
                    Toast.makeText(bookingorder.this,"请选择收货地址！",Toast.LENGTH_SHORT).show();
                }
                else if ("".equals(date))
                {
                    Toast.makeText(bookingorder.this,"请选择收货日期！",Toast.LENGTH_SHORT).show();
                }
                else if ("".equals(time))
                {
                    Toast.makeText(bookingorder.this,"请选择收货时间！",Toast.LENGTH_SHORT).show();
                }
                else if ("".equals(thingtp))
                {
                    Toast.makeText(bookingorder.this,"请选择货品种类！",Toast.LENGTH_SHORT).show();
                }
                else if ("".equals(thingnm))
                {
                    Toast.makeText(bookingorder.this,"请选择货品数量！",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    new Thread(){
                        @Override
                        public void run() {
                            //String urlStr,String user_address,String user_date,String user_time,String thingtype,String thingnuber
                            String result = Internet.bookorder(urlStr,tvadd,date,time,thingtp,thingnm);
                            parseJSONWithJSONObject(result);//获得服务器传回的数据
                            System.out.println(result);
                            try{
                                JSONObject result_json = new JSONObject(result);
                                String message = result_json.getString("message:");
                                if ("success".equals(message)) {
                                    Intent lookneworder = new Intent(bookingorder.this,lookorder.class);//跳转到查看订单界面
                                    startActivity(lookneworder);//新用户登陆
                                    finish();
                                }

                            }catch(JSONException e) {
                                e.printStackTrace();
                                System.out.println(e.toString());

                            }

                        }
                    }.start();


                }

            }
        });

    }
    private void parseJSONWithJSONObject(String jsondata)
    {
        try{
            JSONArray jsonArray=new JSONArray(jsondata);
            for(int i=0;i<jsonArray.length();i++)
            {
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                //String tvadd=jsonObject.getString("address");
                /*
                * 需要返回的数据类型包括date，time，thingstype，thingsnumber，订单完成状态和订单总价
                */
                String date=jsonObject.getString("date");
                String time=jsonObject.getString("time");
                String thingtp=jsonObject.getString("thingstype");
                String thingnm=jsonObject.getString("thingsnumber");
                String state=jsonObject.getString("state");//订单完成状态
                String sum=jsonObject.getString("sum");//总价


                //传递值
                Intent intent=new Intent(bookingorder.this,lookorder.class);
                intent.putExtra("date+time",date+time);
                intent.putExtra("state",state);
                intent.putExtra("thingstype",thingtp);
                intent.putExtra("thingsnumber",thingnm);
                intent.putExtra("sum",sum);
                startActivity(intent);


            }




        }catch (Exception e)
        {
            e.printStackTrace();
        }






    }



}