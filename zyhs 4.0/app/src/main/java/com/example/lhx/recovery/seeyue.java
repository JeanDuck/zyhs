package com.example.lhx.recovery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class seeyue extends AppCompatActivity {
    private Button tixian;
    private TextView showbalance;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seeyue);
        //查看余额界面显示
         tixian=(Button)findViewById(R.id.tixian);

         showbalance=(TextView)findViewById(R.id.showmoney);
        Intent intent = getIntent();

        String balance2=intent.getStringExtra("balance2");//余额
        /*在查看余额框中显示余额*/
        showbalance.setText(balance2);



    }


}
