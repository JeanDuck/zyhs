package com.example.lhx.recovery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class choosetime extends AppCompatActivity {
    private TimePicker timePicker;
    String time;
    private Button time_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_time);
        timePicker = (TimePicker) findViewById(R.id.tpPicker);
        timePicker.setIs24HourView(true);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay,
                                      int minute) {
                Toast.makeText(choosetime.this,
                        hourOfDay + "小时" + minute + "分钟",
                        Toast.LENGTH_SHORT).show();
                      time=hourOfDay+"小时"+minute+"分钟";

            }
        });

        time_btn= (Button)findViewById(R.id.sure2_btn);
        time_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data=time;
                Intent intent=new Intent(choosetime.this,bookingorder.class);
                intent.putExtra("extra_data1",time);
                startActivity(intent);


            }
        });

    }
}

