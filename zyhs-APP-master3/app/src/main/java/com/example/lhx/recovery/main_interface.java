package com.example.lhx.recovery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class main_interface extends AppCompatActivity {

    private Button t_btn;//测试按钮
    private Button book_btn;//预约按钮
    private RadioGroup rpTab;
    private RadioButton rbmain,rborder,rbprice,rbuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_interface);

        //测试按钮点击事件
       /* t_btn = (Button) findViewById(R.id.testbtn);
        t_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(main_interface.this, person_Activity.class);
                startActivity(intent);
            }
        });*/
        //上面的预约订单按钮点击事件
        book_btn = (Button) findViewById(R.id.yyan);
        book_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(main_interface.this, bookingorder.class);
                startActivity(intent);
            }
        });



        rpTab = (RadioGroup)findViewById(R.id.navigation_btn);
        rpTab.check(R.id.btn1);
        rpTab.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.btn1:
                        //Intent intent = new Intent(g);
                        break;
                    case R.id.btn2:
                        Intent intent2 = new Intent(main_interface.this,lookorder.class);
                        startActivity(intent2);
                        break;
                    case R.id.btn3:
                        Intent intent3 = new Intent(main_interface.this,showprice.class);
                        startActivity(intent3);
                        break;
                    case R.id.btn4:
                        Intent intent4 = new Intent(main_interface.this,person_Activity.class);
                        startActivity(intent4);

                        break;
                    default:
                        break;
                }



            }
        });

    }


    }


 /*rbmain = (RadioButton)findViewById(R.id.btn1);
        rborder = (RadioButton)findViewById(R.id.btn2);
        rbprice = (RadioButton)findViewById(R.id.btn3);
        rbuser = (RadioButton)findViewById(R.id.btn4);
        rpTab.check(R.id.btn1);*/