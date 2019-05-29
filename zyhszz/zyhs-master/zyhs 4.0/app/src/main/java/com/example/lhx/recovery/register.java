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


public class register extends AppCompatActivity {
    private EditText newname;//用户名
    private EditText realname;//姓名
    private EditText newphone;//电话
    private EditText password;//密码
    private EditText surepsw;//确认密码
    private Button register;//注册


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);//显示注册界面
        newname=(EditText)findViewById(R.id.et1_name);
        newphone=(EditText)findViewById(R.id.et2_phone);
        password=(EditText)findViewById(R.id.edt3_mima);
        surepsw=(EditText)findViewById(R.id.et2_querenmima);
        register=(Button)findViewById(R.id.res_btn);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String urlStr="http://10.0.2.2:8080/recovery/RegisterServlrt";
                final String nname=newname.getText().toString().trim();
                final String nphone=newphone.getText().toString().trim();
                final String psw=password.getText().toString().trim();
                //final String real=realname.getText().toString().trim();
                String spsw=surepsw.getText().toString().trim();
                if("".equals(nname)||"".equals(nphone)||"".equals(psw)||"".equals(spsw))
                {
                    Toast.makeText(register.this,"输入信息不能为空！",Toast.LENGTH_SHORT).show();
                }
                else if(!psw.equals(spsw))
                {
                    Toast.makeText(register.this,"两次密码不同！",Toast.LENGTH_SHORT).show();
                }
                else if(nphone.length()!=11)
                {

                    Toast.makeText(register.this,"手机号码信息错误！",Toast.LENGTH_SHORT).show();
                }
                else
                {
                   new Thread()
                   {
                       @Override
                       public void run() {
                           //newaccount(String urlStr,String user_password,String user_name,String user_phone,String user_surepsw)
                           String result = Internet.rsetpassword(urlStr,nname,nphone,psw);
                           System.out.println(result);
                           try{
                               if(JsonUtil.isJson(result)){
                                   JSONObject result_json = new JSONObject(result);
                                   String message = result_json.getString("message");
                                   Intent int_preson = new Intent(register.this,LoadActivity.class);
                                   startActivity(int_preson);
                                   finish();
                               }
                               else {
                                   Looper.prepare();
                                   Toast.makeText(register.this, "用户已存在", Toast.LENGTH_SHORT).show();
                                   Looper.loop();
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
                 * 需要返回的数据类型包括真名，电话，详细地址
                 */
                String realname=jsonObject.getString("realname");//用户名
                String phonenumber=jsonObject.getString("phonenumber");//电话
                String address=jsonObject.getString("address");//余额


                //传递值
                Intent intent=new Intent(register.this,person_Activity.class);
                intent.putExtra("realname",realname);
                intent.putExtra("phonenumber",phonenumber);
                intent.putExtra("address",address);
                startActivity(intent);



            }




        }catch (Exception e)
        {
            e.printStackTrace();
        }




    }
}
