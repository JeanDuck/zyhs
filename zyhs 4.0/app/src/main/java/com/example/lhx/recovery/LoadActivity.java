package com.example.lhx.recovery;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoadActivity extends AppCompatActivity {
    private Button loadbtn;//登陆按钮
    private Button registerbtn;//注册按钮
    private EditText logname;//用户名
    private EditText password;//密码
    private String name,pwd;
    private List<Loggson> list;

    final OkHttpClient client = new OkHttpClient();

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            if(msg.what==1){
                String ReturnMessage = (String) msg.obj;
                Log.i("获取的返回信息",ReturnMessage);
                final Loggson log = new Gson().fromJson(ReturnMessage, Loggson.class);
                final String logMsg = log.getMsg();
                /***
                 * 在此处可以通过获取到的Msg值来判断
                 */
                Log.i("MSG", logMsg);
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        //点击注册按钮进入登陆界面
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
                name=logname.getText().toString().trim();
                pwd=password.getText().toString().trim();
                //通过okhttp发起post请求
                postRequest(name,pwd);
            }
        });

    }
    private void postRequest(String username,String password)
    {
        //建立请求表单，添加上传服务器的参数
        RequestBody formBody = new FormBody.Builder()
                .add("username",name)
                .add("password",pwd)
                .build();
        //发起请求
        final Request request = new Request.Builder()
                .url("http://**************/login?")
                .post(formBody)
                .build();
       //线程用于得到服务器响应参数
        new Thread(new Runnable() {
            @Override
            public void run() {
                Response response=null;
                try{
                    response = client.newCall(request).execute();
                    if (response.isSuccessful()) {
                        //将服务器响应的参数response.body().string())发送到hanlder中，并更新ui
                        mHandler.obtainMessage(1, response.body().string()).sendToTarget();

                    } else {
                        throw new IOException("Unexpected code:" + response);
                    }



                }catch (IOException e){

                    e.printStackTrace();
                }

            }
        }).start();



    }


}


