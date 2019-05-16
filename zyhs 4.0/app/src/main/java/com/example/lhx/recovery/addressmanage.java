package com.example.lhx.recovery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class addressmanage extends AppCompatActivity {
    private Button add_btn;
    private ListView listView;
    //private ArrayAdapter<String> arrayAdapter;
    private List<addresslistview> addressList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_manage);//地址管理界面

        initaddress();

        addressadapter adapter=new addressadapter(addressmanage.this,R.layout.addresslistviewitem,addressList);
        ListView listview=(ListView)findViewById(R.id.addresslistview);
        listview.setAdapter(adapter);


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
    private void initaddress()
    {

        for(int i=0;i<10;i++)
        {



           addresslistview address=new addresslistview("xxx "," xxx","xxx");
            addressList.add(address);

        }


    }
    private void getaddress()
    {

        for(int i=0;i<10;i++)
        {
            Intent intent = getIntent();
            String realnm = intent.getStringExtra("realname");
            String phonm=intent.getStringExtra("phonenumber");
            String adrs=intent.getStringExtra("address");
            addresslistview address=new addresslistview(realnm,phonm,adrs);
            addressList.add(address);

        }





    }



}
/*  Intent intent=new Intent(register.this,person_Activity.class);
                intent.putExtra("realname",realname);
                intent.putExtra("phonenumber",phonenumber);
                intent.putExtra("address",address);*/
