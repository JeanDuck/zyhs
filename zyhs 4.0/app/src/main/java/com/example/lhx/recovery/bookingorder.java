package com.example.lhx.recovery;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class bookingorder extends AppCompatActivity {
    private Button date_btn,time_btn;
    private Button back_btn;
    private TextView tv1,tv2;//分别用于显示日期和时间
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_booking_order);
        //选择日期
        date_btn= (Button)findViewById(R.id.choosedate);
        date_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bookingorder.this,choosedate.class);
                startActivity(intent);
            }
        });
        //选择时间
        time_btn=(Button)findViewById(R.id.choosetime);
        time_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(bookingorder.this,choosetime.class);
                startActivity(intent);
            }

        });
        //日期显示
        tv1 = (TextView)findViewById(R.id.bookdate);
        Intent intent = getIntent();
        String data = intent.getStringExtra("extra_data");
        tv1.setText(data);
        //时间显示
        tv2 = (TextView)findViewById(R.id.booktime);
        Intent intent2 = getIntent();
        String data2 = intent2.getStringExtra("extra_data1");
        tv2.setText(data2);


    }



}