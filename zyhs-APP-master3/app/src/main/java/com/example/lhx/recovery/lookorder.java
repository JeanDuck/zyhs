package com.example.lhx.recovery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.view.View;
import android.widget.RadioGroup;

public class lookorder extends AppCompatActivity {
    private Button btn_finished;//显示已完成订单按钮
    private Button btn_unfinished;//显示未完成订单按钮
    private Button btn_creat;//创建订单
    private RadioGroup rpTab;
//两个按钮功能尚未实现
    private Button back_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look_order);//查看订单界面

        btn_finished = (Button) findViewById(R.id.finished);
        btn_finished.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显示已完成订单
            }
        });
        btn_unfinished = (Button) findViewById(R.id.unfinished);
        btn_unfinished.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显示未完成订单
            }
        });
        btn_creat = (Button) findViewById(R.id.creatorder);
        btn_creat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(lookorder.this, bookingorder.class);
                startActivity(intent);
            }
        });



        Button main=(Button)findViewById(R.id.btn1);
        Button order=(Button)findViewById(R.id.btn2);
        Button price=(Button)findViewById(R.id.btn3);
        Button person=(Button)findViewById(R.id.btn4);
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(lookorder.this,main_interface.class);
                startActivity(intent);


            }
        });
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(lookorder.this,lookorder.class);
                startActivity(intent);


            }
        });
        price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(lookorder.this,showprice.class);
                startActivity(intent);


            }
        });
        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(lookorder.this,person_Activity.class);
                startActivity(intent);


            }
        });
        rpTab = (RadioGroup)findViewById(R.id.navigation_btn);
        rpTab.check(R.id.btn2);
        rpTab.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.btn1:
                        Intent intent1 = new Intent(lookorder.this,main_interface.class);
                        startActivity(intent1);
                        break;
                    case R.id.btn2:
                        break;
                    case R.id.btn3:
                        Intent intent3 = new Intent(lookorder.this,showprice.class);
                        startActivity(intent3);
                        break;
                    case R.id.btn4:
                        Intent intent4 = new Intent(lookorder.this,person_Activity.class);
                        startActivity(intent4);
                        break;
                    default:
                        break;
                }

            }
        });


    }
}
