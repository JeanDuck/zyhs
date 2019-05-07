package com.example.lhx.recovery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class showprice extends AppCompatActivity {
    private Button btn_metal;//金属制品
    private Button btn_plastic;//塑料制品
    private Button btn_paper;//纸制品
    private Button btn_oldbattery;//废旧电池
    private Button btn_homeappliance;//家电回收
    private Button btn_furniture;//家具回收
    private Button btn_drygoods;//纺织品回收
    private RadioGroup rpTab;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_price);//查看展示价格界面
    btn_metal = (Button) findViewById(R.id.metal);
    btn_metal.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //展示价格
        }
    });
    btn_plastic = (Button) findViewById(R.id.metal);
    btn_plastic.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //展示价格
        }
    });
    btn_paper = (Button) findViewById(R.id.metal);
    btn_paper.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //展示价格
        }
    });
    btn_oldbattery = (Button) findViewById(R.id.metal);
    btn_oldbattery.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //展示价格
        }
    });
    btn_furniture = (Button) findViewById(R.id.metal);
    btn_furniture.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //展示价格
        }
    });
    btn_homeappliance = (Button) findViewById(R.id.metal);
    btn_homeappliance.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //展示价格
        }
    });
    btn_drygoods = (Button) findViewById(R.id.metal);
    btn_drygoods.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //展示价格
        }
    });

    rpTab = (RadioGroup)findViewById(R.id.navigation_btn);
    rpTab.check(R.id.btn3);
    rpTab.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.btn1:
                    Intent intent1 = new Intent(showprice.this,main_interface.class);
                    startActivity(intent1);
                    break;
                case R.id.btn2:
                    Intent intent2 = new Intent(showprice.this,lookorder.class);
                    startActivity(intent2);
                    break;
                case R.id.btn3:
                    break;
                case R.id.btn4:
                    Intent intent4 = new Intent(showprice.this,person_Activity.class);
                    startActivity(intent4);
                    break;
                default:
                    break;
            }



        }
    });

}
}
