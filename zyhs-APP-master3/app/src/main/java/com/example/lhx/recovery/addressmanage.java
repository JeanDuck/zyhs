package com.example.lhx.recovery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class addressmanage extends AppCompatActivity {
    private Button add_btn;
    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_manage);//地址管理界面
        listView = (ListView) findViewById(R.id.listview);

        String[] arrayData = {"xxx1","xxx2","xxx3","xxx4","xxx5"};
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayData);
        //3.视图（ListView）加载适配器（arrayAdapter）
        listView.setAdapter(arrayAdapter);

        //点击添加地址到添加地址界面
        add_btn= (Button)findViewById(R.id.addaddress);
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(addressmanage.this,addaddress.class);
                startActivity(intent);
            }
        });


    }
}
