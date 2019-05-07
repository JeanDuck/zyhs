package com.example.lhx.recovery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;


import android.widget.TimePicker;
import android.widget.Toast;
import java.util.Calendar;
import java.text.SimpleDateFormat;


public class choosedate extends AppCompatActivity

    {

        private DatePicker datePicker;
        private Button date_btn;
        String date;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_choose_date);
            datePicker = (DatePicker) findViewById(R.id.dpPicker);
                //timePicker = (TimePicker) findViewById(R.id.tpPicker);
                    datePicker.init(2019, 4, 25, new DatePicker.OnDateChangedListener() {

                  @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth)
                  {
                                    // 获取一个日历对象，并初始化为当前选中的时间
                                    Calendar calendar = Calendar.getInstance();
                                    calendar.set(year, monthOfYear, dayOfMonth);
                                    SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 ");
                                    Toast.makeText(choosedate.this, format.format(calendar.getTime()), Toast.LENGTH_SHORT).show();
                                    date=format.format(calendar.getTime());

                  }
         });

            date_btn= (Button)findViewById(R.id.sure_btn);
            date_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String data=date;
                    Intent intent=new Intent(choosedate.this,bookingorder.class);
                    intent.putExtra("extra_data",date);
                    startActivity(intent);


                }
            });



               }
    }



