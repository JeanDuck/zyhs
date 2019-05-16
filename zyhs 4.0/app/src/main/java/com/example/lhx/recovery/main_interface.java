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

    private Button book_btn;//预约按钮

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_interface);
        //上面的预约订单按钮点击事件
        book_btn = (Button) findViewById(R.id.yyan);
        book_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(main_interface.this, bookingorder.class);
                startActivity(intent);
            }
        });





    }


    }


