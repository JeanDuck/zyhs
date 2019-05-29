package com.example.lhx.recovery;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
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
    private Button ads_btn, date_btn, time_btn;
    private TextView tvdate1, tvtime2;//分别用于显示日期和时间
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

        SharedPreferences user_data = getSharedPreferences("user_data",MODE_PRIVATE);
        final String salepeople = user_data.getString("username","");
        //if("".equals(salepeople)){
            //Toast.makeText(bookingorder.this,"请先登录",Toast.LENGTH_SHORT).show();
            //Intent intent = new Intent(bookingorder.this,LoadActivity.class);
           // startActivity(intent);
        //}

        time_btn = (Button) findViewById(R.id.choosetime);
        ads_btn = findViewById(R.id.chooseadd);
        tvdate1 = (TextView) findViewById(R.id.bookdate);
        tvaddress = findViewById(R.id.addresschoose);
        tvtime2 = (TextView) findViewById(R.id.booktime);
        //chose address
        ads_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bookingorder.this, addressmanage.class);
                intent.putExtra("needadd", 1);
                startActivity(intent);
            }
        });
        //选择日期
        date_btn = (Button) findViewById(R.id.choosedate);
        date_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bookingorder.this, choosedate.class);
                startActivity(intent);
            }
        });
        //选择时间
        time_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bookingorder.this, choosetime.class);
                startActivity(intent);
            }

        });

        tvaddress = (TextView) findViewById(R.id.addresschoose);
        thingtpye = (EditText) findViewById(R.id.thingstype);
        thingnumber = (EditText) findViewById(R.id.thingsnumber);
        chooseaddress = (Button) findViewById(R.id.chooseadd);
        createod = (Button) findViewById(R.id.createbook);
        createod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String urlStr = "http://10.0.2.2:8080/recovery/OrderServlet";
                final String tvadd = tvaddress.getText().toString().trim();
                final String date = tvdate1.getText().toString().trim();
                final String time = tvtime2.getText().toString().trim();
                final String thingtp = thingtpye.getText().toString().trim();
                final String thingnm = thingnumber.getText().toString().trim();
                SharedPreferences user_data = getSharedPreferences("user_data",MODE_PRIVATE);
                final String salepeople = user_data.getString("username","");
                if ("".equals(tvadd)) {
                    Toast.makeText(bookingorder.this, "请选择收货地址！", Toast.LENGTH_SHORT).show();
                } else if ("".equals(date)) {
                    Toast.makeText(bookingorder.this, "请选择收货日期！", Toast.LENGTH_SHORT).show();
                } else if ("".equals(time)) {
                    Toast.makeText(bookingorder.this, "请选择收货时间！", Toast.LENGTH_SHORT).show();
                } else if ("".equals(thingtp)) {
                    Toast.makeText(bookingorder.this, "请选择货品种类！", Toast.LENGTH_SHORT).show();
                } else if ("".equals(thingnm)) {
                    Toast.makeText(bookingorder.this, "请输入总额！", Toast.LENGTH_SHORT).show();
                } else {
                    new Thread() {
                        @Override
                        public void run() {
                            //String urlStr,String user_address,String user_date,String user_time,String thingtype,String thingnuber
                            String result = Internet.bookorder(urlStr, tvadd, date, time, salepeople,thingtp, thingnm,"1");
                            System.out.println(result);
                            if("success".equals(result)){
                                Looper.prepare();
                                Toast.makeText(bookingorder.this, "创建成功！", Toast.LENGTH_SHORT).show();
                                final SharedPreferences orderdes = getSharedPreferences("orderdes",MODE_PRIVATE);
                                SharedPreferences.Editor et = orderdes.edit();
                                et.remove("address");
                                et.remove("date");
                                et.remove("time");
                                et.apply();
                                Intent intent = new Intent(bookingorder.this,main_interface.class);
                                startActivity(intent);
                                Looper.loop();
                            }
                            else{
                                Looper.prepare();
                                Toast.makeText(bookingorder.this, "创建失败！", Toast.LENGTH_SHORT).show();
                                Looper.loop();
                            }
                        }
                    }.start();

                }

            }
        });

    }

    @Override
    protected void onRestart() {
        System.out.println("in  here");
        final SharedPreferences orderdes = getSharedPreferences("orderdes",MODE_PRIVATE);

        if(!"".equals(orderdes.getString("address",""))){
            tvaddress.setText(orderdes.getString("address",""));
        }
        System.out.println(orderdes.getString("date",""));
        if(!"".equals(orderdes.getString("date",""))){
            tvdate1.setText(orderdes.getString("date",""));
        }
        if(!"".equals(orderdes.getString("time",""))){
            tvtime2.setText(orderdes.getString("time",""));
        }
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        final SharedPreferences orderdes = getSharedPreferences("orderdes",MODE_PRIVATE);
        SharedPreferences.Editor et = orderdes.edit();
        et.remove("address");
        et.remove("date");
        et.remove("time");
        et.commit();
        super.onDestroy();
    }
}