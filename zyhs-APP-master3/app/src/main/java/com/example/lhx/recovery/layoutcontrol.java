package com.example.lhx.recovery;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import static android.support.v4.content.ContextCompat.startActivity;

public class layoutcontrol extends LinearLayout {
    public layoutcontrol (Context context, AttributeSet attrs)
    {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.fragment_blank,this);
       /* Button main=(Button)findViewById(R.id.btn1);
        Button order=(Button)findViewById(R.id.btn2);
        Button price=(Button)findViewById(R.id.btn3);
        Button person=(Button)findViewById(R.id.btn4);
        main.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
        */


    }
}
