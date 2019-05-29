package com.example.lhx.recovery;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.Button;
import android.view.View;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class lookorder extends AppCompatActivity {
    private Button btn_finished;//显示已完成订单按钮
    private Button btn_unfinished;//显示未完成订单按钮
    private RadioGroup rpTab;
    private List<Orderlistview> orderList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look_order);//查看订单界面

        SharedPreferences user_data = getSharedPreferences("user_data", MODE_PRIVATE);
        final String name = user_data.getString("username", "");
        final String urlStr = "http://10.0.2.2:8080/recovery/OrderServlet";

        //initOrder();//测试
        final orderadapter adapter = new orderadapter(lookorder.this, R.layout.orderlistviewitem, orderList);
        ListView listview = (ListView) findViewById(R.id.orderlist);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final Orderlistview choseorder = orderList.get(position);
                if(!choseorder.getState().equals("已完成")){
                    String message;
                    final int state;
                    if(choseorder.getState().equals("未完成")){
                        message = "接单吗";
                        state = 0;
                    }
                    else {
                        message = "完成订单吗";
                        state = 1;
                    }
                    AlertDialog.Builder builder= new AlertDialog.Builder(lookorder.this);
                    builder.setMessage("您确定要"+message)
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    new Thread() {
                                        public void run() {
                                            String result = Internet.changeorder(urlStr, name, choseorder.getNum(), state, "4");
                                            if ("success".equals(result)) {
                                                Looper.prepare();
                                                Toast.makeText(lookorder.this, "操作完成", Toast.LENGTH_SHORT).show();
                                                Looper.loop();
                                            }
                                        }
                                    }.start();
                                }
                            }).show();
                }
            }
        });

        //显示已完成订单
        btn_finished = (Button) findViewById(R.id.finished);
        btn_finished.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ("".equals(name)) {
                    Toast.makeText(lookorder.this, "登录错误!", Toast.LENGTH_SHORT).show();
                } else {
                    new Thread() {
                        public void run() { //那么多文件一个包下...
                            String result = Internet.askorder(urlStr, name, "3");
                            System.out.println("result:" + result);
                            try {
                                if (JsonArray.isJson(result)) {
                                    JSONArray manyorder = new JSONArray(result);
                                    orderList.clear();
                                    for (int i = 0; i < manyorder.length(); i++) {
                                        JSONObject orderobj = manyorder.getJSONObject(i);
                                        int num = orderobj.getInt("num");
                                        String time = orderobj.getString("time");
                                        String state;
                                        if (-1 == orderobj.getInt("state")) state = "未完成";
                                        else if (0 == orderobj.getInt("state")) state = "已接单";
                                        else  state = "已完成";
                                        String address = orderobj.getString("address");
                                        String salepeople = orderobj.getString("salepeople");
                                        String buypeople = orderobj.getString("buypeople");
                                        String orderdes = orderobj.getString("orderdes");
                                        String sum = String.valueOf(orderobj.getInt("sum"));
                                        Orderlistview order = new Orderlistview(num,time, state, address, salepeople, buypeople, orderdes, sum);
                                        if ("已完成".equals(state)&&buypeople.equals(name)) {
                                            orderList.add(order);
                                        }

                                    }
                                } else {
                                    Looper.prepare();
                                    Toast.makeText(lookorder.this, "暂无数据！", Toast.LENGTH_SHORT).show();
                                    Looper.loop();
                                }
                            } catch (JSONException e) {
                                e.getCause();
                                System.out.println(e);
                            }
                        }
                    }.start();
                    adapter.notifyDataSetChanged();
                }
            }
        });
        //显示未完成订单
        btn_unfinished = (Button) findViewById(R.id.unfinished);
        btn_unfinished.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if ("".equals(name)) {
                    Toast.makeText(lookorder.this, "登录错误!", Toast.LENGTH_SHORT).show();
                } else {
                    new Thread() {
                        public void run() { //那么多文件一个包下...
                            String result = Internet.askorder(urlStr, name, "3");
                            System.out.println("result:" + result);
                            try {
                                if (JsonArray.isJson(result)) {
                                    JSONArray manyorder = new JSONArray(result);
                                    orderList.clear();
                                    for (int i = 0; i < manyorder.length(); i++) {
                                        JSONObject orderobj = manyorder.getJSONObject(i);
                                        int num = orderobj.getInt("num");
                                        String time = orderobj.getString("time");
                                        String state;
                                        if (-1 == orderobj.getInt("state")) state = "未完成";
                                        else if (0 == orderobj.getInt("state")) state = "已接单";
                                        else state = "已完成";
                                        String address = orderobj.getString("address");
                                        String salepeople = orderobj.getString("salepeople");
                                        String buypeople = orderobj.getString("buypeople");
                                        String orderdes = orderobj.getString("orderdes");
                                        String sum = String.valueOf(orderobj.getInt("sum"));
                                        Orderlistview order = new Orderlistview(num,time, state, address, salepeople, buypeople, orderdes, sum);
                                        if (!"已完成".equals(state)) {
                                            orderList.add(order);
                                        }

                                    }
                                } else {
                                    Looper.prepare();
                                    Toast.makeText(lookorder.this, "暂无数据！", Toast.LENGTH_SHORT).show();
                                    Looper.loop();
                                }
                            } catch (JSONException e) {
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
