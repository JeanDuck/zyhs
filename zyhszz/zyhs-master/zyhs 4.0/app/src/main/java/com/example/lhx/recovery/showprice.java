package com.example.lhx.recovery;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class showprice extends AppCompatActivity {
    private Button btn_metal;//金属制品
    private Button btn_plastic;//塑料制品
    private Button btn_paper;//纸制品
    private Button btn_oldbattery;//废旧电池
    private Button btn_homeappliance;//家电回收
    private Button btn_furniture;//家具回收
    private Button btn_drygoods;//纺织品回收

    private List<showpriceview> splist = new ArrayList<>();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_price);//查看展示价格界面
        btn_metal = (Button) findViewById(R.id.metal);
        btn_plastic = (Button) findViewById(R.id.plastic);
        btn_paper = (Button) findViewById(R.id.paper);
        btn_oldbattery = (Button) findViewById(R.id.oldbattery);
        btn_homeappliance = (Button) findViewById(R.id.homeappliance);
        btn_furniture = (Button) findViewById(R.id.furniture);
        btn_drygoods = (Button) findViewById(R.id.drygoods);

        final showpriceadapter adapter = new showpriceadapter(showprice.this, R.layout.price_item, splist);
        ListView listview = (ListView) findViewById(R.id.showprice);
        listview.setAdapter(adapter);

        final String urlStr = "http://10.0.2.2:8080/recovery/ShowPriceServlrt";
        //final String urlStr = "http://10.0.2.2:8080/recovery/OrderServlet";
        btn_metal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread() {
                    public void run() { //那么多文件一个包下...
                        String result = Internet.showprice(urlStr);
                        System.out.println("result1:" + result);
                        try {
                            if (JsonArray.isJson(result)) {
                                JSONArray manysp = new JSONArray(result);
                                splist.clear();
                                System.out.println("size is"+manysp.length());
                                for (int i = 0; i < manysp.length(); i++) {
                                    System.out.println("add");
                                    JSONObject spobj = manysp.getJSONObject(i);
                                    int type = spobj.getInt("type");
                                    String pictureurl =spobj.getString("id");
                                    String text = spobj.getString("text");
                                    double price = spobj.getDouble("price");
                                    showpriceview sp = new showpriceview(pictureurl,text,price);
                                    if (type == 1) {
                                        splist.add(sp);
                                    }
                                }
                                System.out.println("hava size: "+splist.size());
                            }
                            else{
                                System.out.println("nto ib");
                            }
                        } catch (JSONException e) {
                            e.getCause();
                            System.out.println(e);
                        }
                    }
                }.start();
                adapter.notifyDataSetChanged();
            }
        });
        btn_plastic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread() {
                    public void run() { //那么多文件一个包下...
                        String result = Internet.showprice(urlStr);
                        System.out.println("result2:" + result);
                        try {
                            if (JsonArray.isJson(result)) {
                                JSONArray manysp = new JSONArray(result);
                                splist.clear();
                                for (int i = 0; i < manysp.length(); i++) {
                                    JSONObject spobj = manysp.getJSONObject(i);
                                    int type = spobj.getInt("type");
                                    String pictureurl =spobj.getString("id");
                                    String text = spobj.getString("text");
                                    double price = spobj.getDouble("price");
                                    showpriceview sp = new showpriceview(pictureurl,text,price);
                                    if (type == 2) {
                                        splist.add(sp);
                                    }
                                }
                            }
                        } catch (JSONException e) {
                            e.getCause();
                            System.out.println(e);
                        }
                    }
                }.start();
                adapter.notifyDataSetChanged();
            }
        });
        btn_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread() {
                    public void run() { //那么多文件一个包下...
                        String result = Internet.showprice(urlStr);
                        System.out.println("result3:" + result);
                        try {
                            if (JsonArray.isJson(result)) {
                                JSONArray manysp = new JSONArray(result);
                                splist.clear();
                                for (int i = 0; i < manysp.length(); i++) {
                                    JSONObject spobj = manysp.getJSONObject(i);
                                    int type = spobj.getInt("type");
                                    String pictureurl =spobj.getString("id");
                                    String text = spobj.getString("text");
                                    double price = spobj.getDouble("price");
                                    showpriceview sp = new showpriceview(pictureurl,text,price);
                                    if (type == 3) {
                                        splist.add(sp);
                                    }
                                }
                            }
                        } catch (JSONException e) {
                            e.getCause();
                            System.out.println(e);
                        }
                    }
                }.start();
                adapter.notifyDataSetChanged();
            }
        });
        btn_oldbattery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread() {
                    public void run() { //那么多文件一个包下...
                        String result = Internet.showprice(urlStr);
                        System.out.println("result4:" + result);
                        try {
                            if (JsonArray.isJson(result)) {
                                JSONArray manysp = new JSONArray(result);
                                splist.clear();
                                for (int i = 0; i < manysp.length(); i++) {
                                    JSONObject spobj = manysp.getJSONObject(i);
                                    int type = spobj.getInt("type");
                                    String pictureurl =spobj.getString("id");
                                    String text = spobj.getString("text");
                                    double price = spobj.getDouble("price");
                                    showpriceview sp = new showpriceview(pictureurl,text,price);
                                    if (type == 4) {
                                        splist.add(sp);
                                    }
                                }
                            }
                        } catch (JSONException e) {
                            e.getCause();
                            System.out.println(e);
                        }
                    }
                }.start();
                adapter.notifyDataSetChanged();
            }
        });
        btn_furniture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread() {
                    public void run() { //那么多文件一个包下...
                        String result = Internet.showprice(urlStr);
                        System.out.println("result5:" + result);
                        try {
                            if (JsonArray.isJson(result)) {
                                JSONArray manysp = new JSONArray(result);
                                splist.clear();
                                for (int i = 0; i < manysp.length(); i++) {
                                    JSONObject spobj = manysp.getJSONObject(i);
                                    int type = spobj.getInt("type");
                                    String pictureurl =spobj.getString("id");
                                    String text = spobj.getString("text");
                                    double price = spobj.getDouble("price");
                                    showpriceview sp = new showpriceview(pictureurl,text,price);
                                    if (type == 5) {
                                        splist.add(sp);
                                    }
                                }
                            }
                        } catch (JSONException e) {
                            e.getCause();
                            System.out.println(e);
                        }
                    }
                }.start();
                adapter.notifyDataSetChanged();
            }
        });
        btn_homeappliance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread() {
                    public void run() { //那么多文件一个包下...
                        String result = Internet.showprice(urlStr);
                        System.out.println("result6:" + result);
                        try {
                            if (JsonArray.isJson(result)) {
                                JSONArray manysp = new JSONArray(result);
                                splist.clear();
                                for (int i = 0; i < manysp.length(); i++) {
                                    JSONObject spobj = manysp.getJSONObject(i);
                                    int type = spobj.getInt("type");
                                    String pictureurl =spobj.getString("id");
                                    String text = spobj.getString("text");
                                    double price = spobj.getDouble("price");
                                    showpriceview sp = new showpriceview(pictureurl,text,price);
                                    if (type == 6) {
                                        splist.add(sp);
                                    }
                                }
                            }
                        } catch (JSONException e) {
                            e.getCause();
                            System.out.println(e);
                        }
                    }
                }.start();
                adapter.notifyDataSetChanged();
            }
        });
        btn_drygoods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread() {
                    public void run() { //那么多文件一个包下...
                        String result = Internet.showprice(urlStr);
                        System.out.println("result7:" + result);
                        try {
                            if (JsonArray.isJson(result)) {
                                JSONArray manysp = new JSONArray(result);
                                splist.clear();
                                for (int i = 0; i < manysp.length(); i++) {
                                    JSONObject spobj = manysp.getJSONObject(i);
                                    int type = spobj.getInt("type");
                                    String pictureurl =spobj.getString("id");
                                    String text = spobj.getString("text");
                                    double price = spobj.getDouble("price");
                                    showpriceview sp = new showpriceview(pictureurl,text,price);
                                    if (type == 7) {
                                        splist.add(sp);
                                    }
                                }
                            }
                        } catch (JSONException e) {
                            e.getCause();
                            System.out.println(e);
                        }
                    }
                }.start();
                adapter.notifyDataSetChanged();
            }
        });

    }
}
