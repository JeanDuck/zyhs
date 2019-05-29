package com.example.lhx.recovery;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class main_interface extends AppCompatActivity {

    private Button t_btn;//测试按钮
    private Button book_btn;//预约按钮
    private RadioGroup rpTab;
    private RadioButton rbmain,rborder,rbprice,rbuser;
    public static int ss=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ss+=1;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_interface);

        SharedPreferences et = getSharedPreferences("user_data",MODE_PRIVATE);
        if(ss == 1){
            SharedPreferences.Editor eet = et.edit();
            eet.remove("username");
            eet.commit();
            Intent intent = new Intent(main_interface.this,LoadActivity.class);
            startActivity(intent);
        }

        //上面的预约订单按钮点击事件
        book_btn = (Button) findViewById(R.id.yyan);
        book_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(main_interface.this, bookingorder.class);
                startActivity(intent);*/
            }
        });

    }

    @Override
    protected void onRestart() {
        SharedPreferences et = getSharedPreferences("user_data",MODE_PRIVATE);
        if(new UserLoginUtil().UserLogin(et)){
            Toast.makeText(main_interface.this,"请先登录",Toast.LENGTH_LONG).show();
            SharedPreferences.Editor eet = et.edit();
            Intent intent = new Intent(main_interface.this,LoadActivity.class);
            startActivity(intent);
        }
        super.onRestart();
    }
}
