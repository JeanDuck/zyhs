package com.example.lhx.recovery;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.List;

import static android.content.Context.ACTIVITY_SERVICE;
import static android.support.v4.content.ContextCompat.startActivity;

public class layoutcontrol extends LinearLayout  {
    private RadioGroup rpTab;
    private RadioButton rbmain,rborder,rbprice,rbuser;
    public layoutcontrol (Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.fragment_blank, this);


        rpTab = (RadioGroup)findViewById(R.id.navigation_btn);
        rbmain=(RadioButton)findViewById(R.id.btn1);
        rborder = (RadioButton)findViewById(R.id.btn2);
        rbprice = (RadioButton)findViewById(R.id.btn3);
        rbuser = (RadioButton)findViewById(R.id.btn4);

        rpTab.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Intent intent;
                Context context = getContext();
                switch (checkedId) {
                    case R.id.btn1:
                        intent = new Intent(context, main_interface.class);
                        context.startActivity(intent);
                        break;
                    case R.id.btn2:
                        intent = new Intent(context, lookorder.class);
                        context.startActivity(intent);
                        break;
                    case R.id.btn3:
                        intent = new Intent(context, showprice.class);
                        context.startActivity(intent);
                        break;
                    case R.id.btn4:
                        intent = new Intent(context, person_Activity.class);
                        context.startActivity(intent);
                        break;
                    default:
                        break;
                }


            }


        });

    }



}
