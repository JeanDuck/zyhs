package com.example.lhx.recovery;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class LoadActivity extends AppCompatActivity {
    private Button loadbtn;//登陆按钮
    private Button registerbtn;//注册按钮
    private EditText logname;//用户名
    private EditText password;//密码
    int flag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        //点击注册按钮进入登陆界面
        final Intent intent=getIntent();
        flag=intent.getIntExtra("flag",0);
        logname=(EditText)findViewById(R.id.et1_name);
        password=(EditText)findViewById(R.id.et2_pwd);
        loadbtn=(Button)findViewById(R.id.load_btn);
        registerbtn = (Button) findViewById(R.id.res_btn);
        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoadActivity.this, register.class);
                startActivity(intent);
            }

        });

        loadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name=logname.getText().toString().trim();
                final String pwd=password.getText().toString().trim();
                //final String sign="1";
                final String urlStr="http://10.0.2.2:8080/recovery/LoginServlrt2";
                if("".equals(name)||"".equals(pwd))
                {

                    Toast.makeText(LoadActivity.this,"账户和密码不能为空！",Toast.LENGTH_SHORT).show();

                }
                else
                {
                   new Thread(){

                       @Override
                       public void run() {
                           String result= Internet.checkuser(urlStr,name,pwd);
                           System.out.println(result);
                           Log.v("LoadActivity result", "result");
                           if (result.equals("not exsits"))
                           {
                               Looper.prepare();
                               Toast.makeText(LoadActivity.this,"用户名不存在！",Toast.LENGTH_SHORT).show();
                               Looper.loop();
                           }
                           else if(result.equals("internet error"))
                           {
                               Looper.prepare();
                               Toast.makeText(LoadActivity.this,"网络连接错误！",Toast.LENGTH_SHORT).show();
                               Looper.loop();
                           }
                           else{
                               try {
                                   //JSONObject result_json=new JSONObject(result);

                                   //String message=result_json.getString("message:");
                                   if(JsonUtil.isJson(result))
                                   {
                                       JSONObject result_json = new JSONObject(result); //result " "
                                       String message=result_json.getString("message");
                                       if("success".equals(message)) {
                                           SharedPreferences user_data = getSharedPreferences("user_data", MODE_PRIVATE);
                                           SharedPreferences.Editor et = user_data.edit();
                                           et.putString("username", name);
                                           et.apply();

                                           Intent intent1 = new Intent(LoadActivity.this, person_Activity.class);
                                           startActivity(intent1);
                                           finish();
                                       }
                                       else{
                                           Looper.prepare();
                                           Toast.makeText(LoadActivity.this,"用户名或者密码错误！",Toast.LENGTH_SHORT).show();
                                           Looper.loop();
                                       }
                                   }
                                   else
                                   {
                                       Looper.prepare();
                                       Toast.makeText(LoadActivity.this,"未知错误！",Toast.LENGTH_SHORT).show();
                                       Looper.loop();
                                   }

                               } catch (JSONException e) {
                                   e.printStackTrace();
                                   System.out.println(e.toString());
                               }
                           }
                           super.run();
                       }
                   }.start();
                }
            }
        });

    }

}


