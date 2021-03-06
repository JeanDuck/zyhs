package com.example.lhx.recovery;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class addaddress extends AppCompatActivity {
    private EditText username;//用户名
    private EditText phonenumber;//电话号码
    private EditText address;//用户地址
    private Button addars;//添加地址按钮

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);//添加地址界面

        username=(EditText)findViewById(R.id.editname);
        phonenumber=(EditText)findViewById(R.id.editphonenumber);
        address=(EditText)findViewById(R.id.editaddress);
        addars=(Button)findViewById(R.id.addaddress);

        addars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String urlStr = "http://10.0.2.2:8080/recovery/AddressServlet";
                final String uname = username.getText().toString().trim();
                final String phone = phonenumber.getText().toString().trim();
                final String addres = address.getText().toString().trim();
                final String sign = "1";

                if("".equals(uname)||"".equals(phone)||"".equals(addres))
                {
                    Toast.makeText(addaddress.this,"输入信息不能为空！",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    new Thread()
                    {
                        @Override
                        public void run() {
                            super.run();
                            //String urlStr,String user_name,String user_phone,String user_address
                            String result = Internet.addaddresss(urlStr, uname, phone, addres, sign);
                            System.out.println(result);
                            if ("success".equals(result)) {
                                Intent newaccountload = new Intent(addaddress.this, addressmanage.class);//跳转到地址管理界面
                                startActivity(newaccountload);//新用户登陆
                                finish();
                            } else
                            {
                                Looper.prepare();
                                Toast.makeText(addaddress.this,"地址已存在",Toast.LENGTH_SHORT).show();
                                Looper.loop();
                            }
                        }
                    }.start();

                }
            }
        });



    }





}