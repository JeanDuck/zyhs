package com.example.lhx.recovery;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import org.json.JSONException;

public class person_Activity extends AppCompatActivity {
    private Button address_btn;//地址管理按钮
    private Button exit_btn;//退出登陆按钮
    private Button change_btn;//切换账户按钮
    private Button yue_btn;//查看余额详情
    private Button edit_btn;//修改个人信息
    private TextView username;//用户名
    private TextView phonenumber;//电话
    private TextView balance;//余额
    private RadioGroup rpTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_);
        address_btn =(Button) findViewById(R.id.addressman);
        address_btn = (Button) findViewById(R.id.addressman);
        address_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(person_Activity.this, addressmanage.class);
                //显示地址管理界面
                startActivity(intent);

            }
        });

        //显示用户信息
        setuser();


        //退出登陆，返回登陆界面
        exit_btn = (Button) findViewById(R.id.exitlog);
        exit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(person_Activity.this, LoadActivity.class);
                startActivity(intent);
            }
        });

        //切换账户，返回登陆界面
        change_btn = (Button) findViewById(R.id.changeaccount);
        change_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(person_Activity.this, LoadActivity.class);
                startActivity(intent);
            }
        });

        //查看余额详情
        yue_btn = (Button) findViewById(R.id.see);
        yue_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(person_Activity.this, seeyue.class);
                startActivity(intent);
            }
        });

        //修改账户信息
        edit_btn = (Button) findViewById(R.id.editaccount);
        edit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(person_Activity.this, changeaccount.class);
                startActivity(intent);
            }
        });
        username=(TextView)findViewById(R.id.namein);
        phonenumber=(TextView)findViewById(R.id.phonein);
        balance=(TextView)findViewById(R.id.balancein);
        Intent intent = getIntent();
        String username1= intent.getStringExtra("username");//用户名
        String phonenumber1=intent.getStringExtra("phonenumber");//用户电话
        String balance1=intent.getStringExtra("balance");//余额
        /*在个人中心的对应框中显示对应信息*/
        username.setText(username1);
        phonenumber.setText(phonenumber1);
        balance.setText(balance1);




    }
    private void setuser() {
        SharedPreferences et = getSharedPreferences("user_data", MODE_PRIVATE);
        final String uname = et.getString("username","");
        final String urlStr ="http://10.0.2.2:8080/recovery/AskUserServlrt";
        if("".equals(username)){
            System.out.println("name is null");
        }
        else {
            System.out.println(uname);
            new Thread() {
                public void run() {
                    String user = Internet.AskUser(urlStr, uname);
                    try {
                        Looper.prepare();
                        System.out.println("go here" + user);
                        System.out.println("1111" + user + "1111");
                        com.alibaba.fastjson.JSONObject jsuser = com.alibaba.fastjson.JSONObject.parseObject(user);
                        username.setText(jsuser.getString("username"));
                        phonenumber.setText(jsuser.getString("phone"));
                        balance.setText(jsuser.getInteger("money").toString());
                        Looper.loop();
                    } catch (Exception e) {
                        e.getCause();
                    }
                }
            }.start();
        }

    }


}


