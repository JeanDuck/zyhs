package com.example.lhx.recovery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class changeaccount extends AppCompatActivity {
    private EditText username;//用户名
    private EditText userphone;//电话
    private Button savechange;//保存修改

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changeaccount);//显示账户信息修改界面
        username=(EditText)findViewById(R.id.et1_name);
        userphone=(EditText)findViewById(R.id.et2_phone);
        savechange=(Button)findViewById(R.id.save_btn);
        /*savechange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String urlStr="xxxxxxxxxxxx";
                final String nname=username.getText().toString().trim();
                final String nphone=userphone.getText().toString().trim();
                if("".equals(nname)||"".equals(nphone))
                {
                    Toast.makeText(changeaccount.this,"输入信息不能为空！",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    new Thread()
                    {
                        @Override
                        public void run() {
                            String result = Internet.changeaccount(urlStr,nname,nphone);
                            System.out.println(result);
                            try{
                                JSONObject result_json = new JSONObject(result);
                                String message = result_json.getString("message:");
                                if ("success".equals(message)) {
                                    Intent changeaccount = new Intent(changeaccount.this,person_Activity.class);//跳转到登陆界面
                                    startActivity(changeaccount);//新用户登陆
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
        });*/


    }


}
