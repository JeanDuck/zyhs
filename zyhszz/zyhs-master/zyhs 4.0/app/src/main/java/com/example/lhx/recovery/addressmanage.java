package com.example.lhx.recovery;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class addressmanage extends AppCompatActivity {
    private Button add_btn;
    private Button look_btn;
    private ListView listView;
    //private ArrayAdapter<String> arrayAdapter;
    private List<addresslistview> addressList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address_manage);//地址管理界面

        //initaddress();

        //点击添加地址到添加地址界面
        add_btn= (Button)findViewById(R.id.addaddress);
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(addressmanage.this,addaddress.class);
                startActivity(intent);
            }
        });

        final addressadapter adapter=new addressadapter(addressmanage.this,R.layout.addresslistviewitem,addressList);
        ListView listview=findViewById(R.id.addresslistview);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                addresslistview addressobj = addressList.get(position);
                Intent intent1 = getIntent();
                int flag = intent1.getIntExtra("needadd",-1);
                if(flag == 1) {
                    SharedPreferences orderdes = getSharedPreferences("orderdes",MODE_PRIVATE);
                    SharedPreferences.Editor et = orderdes.edit();
                    et.putString("address",addressobj.getAddress());
                    et.commit();
                    Intent intent = new Intent(addressmanage.this,bookingorder.class);
                    startActivity(intent);
                }
            }
        });

        look_btn = findViewById(R.id.seeaddress);
        look_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int flag = 0;
                SharedPreferences user_data=getSharedPreferences("user_data",MODE_PRIVATE);
                final String name = user_data.getString("username","");

                final String urlStr = "http://10.0.2.2:8080/recovery/AddressServlet";
                if("".equals(name)){
                    Toast.makeText(addressmanage.this,"登录错误!",Toast.LENGTH_SHORT).show();
                }
                else{
                    new Thread(){
                        public void run(){ //那么多文件一个包下...
                            String result = Internet.GetAddresss(urlStr,name,"2");
                            System.out.println("result:"+result);
                            try{
                                if(JsonArray.isJson(result)){
                                    JSONArray manyaddress = new JSONArray(result);
                                    addressList.clear();
                                    for(int i = 0;i < manyaddress.length(); i++)
                                    {
                                        JSONObject ob = manyaddress.getJSONObject(i);
                                        String realnm = ob.getString("username");
                                        String phonm = ob.getString("phone");
                                        String adrs = ob.getString("address");
                                        addresslistview address=new addresslistview(realnm,phonm,adrs);
                                        addressList.add(address);

                                    }
                                }
                                else{
                                    Looper.prepare();
                                    Toast.makeText(addressmanage.this,"暂无数据！",Toast.LENGTH_SHORT).show();
                                    Looper.loop();
                                }
                            }
                            catch (JSONException e){
                                e.getCause();
                                System.out.println(e);
                            }
                        }
                    }.start();
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }
}