package com.example.lhx.recovery;

import android.util.Log;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/*登陆部分数据收发*/
public class Internet {
    public static String gethttpresult(String urlStr) {
        try {
            URL url = new URL(urlStr);
            HttpURLConnection connect = (HttpURLConnection) url.openConnection();
            InputStream input = connect.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(input));
            String line = null;
            System.out.println(connect.getResponseCode());
            StringBuffer sb = new StringBuffer();
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }

   
    /**
     * 检查用户账号密码是否正确
     * @param urlStr 接口url
     * @param user_name   用户输入的帐号
     * @param user_password     用户输入的密码
     * @return
     */
    public static String checkuser(String urlStr,String user_name,String user_password){
        com.alibaba.fastjson.JSONObject user=new com.alibaba.fastjson.JSONObject();
        user.put("username",user_name);
        user.put("password",user_password);
        user.put("phone","null");
        user.put("money",0);
        try {
            URL url = new URL(urlStr);
            HttpURLConnection connect = (HttpURLConnection)url.openConnection();
            connect.setDoInput(true);
            connect.setDoOutput(true);
            connect.setRequestMethod("POST");
            connect.setUseCaches(false);
            connect.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            OutputStream outputStream = connect.getOutputStream();
            outputStream.write(user.toJSONString().getBytes());
            int response = connect.getResponseCode();
            if(response == HttpURLConnection.HTTP_OK){
                System.out.println(response);
                InputStream input = connect.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(input));
                String line = null;
                StringBuffer sb = new StringBuffer();
                while ((line = in.readLine()) != null){
                    sb.append(line);
                }
                return sb.toString();
            }
            else{
                System.out.println(response);
                return " ";
            }
        } catch (Exception e){
            Log.e("e:", String.valueOf(e));
            return e.toString();
        }
    }

    /**
     * 用户注册
     * @param urlStr    接口uel
     * @param user_password     用户输入的新密码
     * @param user_name     用户名
     * @param user_phone    用户手机号
     * @return
     */
    public static String rsetpassword(String urlStr,String user_name,String user_phone,String user_password){
        com.alibaba.fastjson.JSONObject user=new com.alibaba.fastjson.JSONObject();
        user.put("username",user_name);
        user.put("password",user_password);
        user.put("phone",user_phone);
        user.put("money",0);
        try {
            URL url=new URL(urlStr);
            HttpURLConnection connect=(HttpURLConnection)url.openConnection();
            connect.setDoInput(true);
            connect.setDoOutput(true);
            connect.setRequestMethod("POST");
            connect.setUseCaches(false);
            connect.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            OutputStream outputStream = connect.getOutputStream();
            outputStream.write(user.toJSONString().getBytes());
            int response = connect.getResponseCode();
            if (response== HttpURLConnection.HTTP_OK)
            {
                System.out.println(response);
                InputStream input=connect.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(input));
                String line = null;
                System.out.println(connect.getResponseCode());
                StringBuffer sb = new StringBuffer();
                while ((line = in.readLine()) != null) {
                    sb.append(line);
                }
                return sb.toString();
            }
            else {
                System.out.println(response);
                return "";
            }
        } catch (Exception e) {
            Log.e("e:", String.valueOf(e));
            return e.toString();
        }
    }

    /**
     * 查询用户
     * @param urlStr    接口uel
     * @param user_name     用户名
     * @return
     */
    public static String AskUser(String urlStr,String user_name){
        com.alibaba.fastjson.JSONObject user=new com.alibaba.fastjson.JSONObject();
        user.put("username",user_name);
        user.put("password","");
        user.put("phone","");
        user.put("money",0);
        try {
            URL url=new URL(urlStr);
            HttpURLConnection connect=(HttpURLConnection)url.openConnection();
            connect.setDoInput(true);
            connect.setDoOutput(true);
            connect.setRequestMethod("POST");
            connect.setUseCaches(false);
            connect.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            OutputStream outputStream = connect.getOutputStream();
            outputStream.write(user.toJSONString().getBytes());
            int response = connect.getResponseCode();
            if (response== HttpURLConnection.HTTP_OK)
            {
                System.out.println(response);
                InputStream input=connect.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(input));
                String line = null;
                System.out.println(connect.getResponseCode());
                StringBuffer sb = new StringBuffer();
                while ((line = in.readLine()) != null) {
                    sb.append(line);
                }
                return sb.toString();
            }
            else {
                System.out.println(response);
                return "";
            }
        } catch (Exception e) {
            Log.e("e:", String.valueOf(e));
            return e.toString();
        }
    }
    /**
     * 用户新增地址信息
     * @param urlStr    接口uel
     * @param user_name     用户名
     * @param user_phone    用户手机号
     * @param user_address    用户需要新增的地址
     * @return
     */
    public static String addaddresss(String urlStr,String user_name,String user_phone,String user_address,String sign)
    {
        com.alibaba.fastjson.JSONObject addaddres = new com.alibaba.fastjson.JSONObject();
        addaddres.put("username",user_name);
        addaddres.put("phone",user_phone);
        addaddres.put("address",user_address);
        addaddres.put("sign",sign);
        try {
            URL url=new URL(urlStr);
            HttpURLConnection connect=(HttpURLConnection)url.openConnection();
            connect.setDoInput(true);
            connect.setDoOutput(true);
            connect.setRequestMethod("POST");
            connect.setUseCaches(false);
            connect.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            OutputStream outputStream = connect.getOutputStream();
            outputStream.write(addaddres.toJSONString().getBytes());
            int response = connect.getResponseCode();
            if (response== HttpURLConnection.HTTP_OK)
            {
                System.out.println(response);
                InputStream input=connect.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(input));
                String line = null;
                System.out.println(connect.getResponseCode());
                StringBuffer sb = new StringBuffer();
                while ((line = in.readLine()) != null) {
                    sb.append(line);
                }
                return sb.toString();
            }
            else {
                System.out.println(response);
                return " ";
            }
        } catch (Exception e) {
            Log.e("e:", String.valueOf(e));
            return e.toString();
        }



    }

    /**
            * 用户新增地址信息
     * @param urlStr    接口uel
     * @param user_name     用户名
     * @return
             */
    public static String GetAddresss(String urlStr,String user_name,String sign)
    {
        com.alibaba.fastjson.JSONObject addaddres = new com.alibaba.fastjson.JSONObject();
        addaddres.put("username",user_name);
        addaddres.put("phone","");
        addaddres.put("address","");
        addaddres.put("sign",sign);
        try {
            URL url=new URL(urlStr);
            HttpURLConnection connect=(HttpURLConnection)url.openConnection();
            connect.setDoInput(true);
            connect.setDoOutput(true);
            connect.setRequestMethod("POST");
            connect.setUseCaches(false);
            connect.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            OutputStream outputStream = connect.getOutputStream();
            outputStream.write(addaddres.toJSONString().getBytes());
            int response = connect.getResponseCode();
            if (response== HttpURLConnection.HTTP_OK)
            {
                System.out.println(response);
                InputStream input=connect.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(input));
                String line = null;
                System.out.println(connect.getResponseCode());
                StringBuffer sb = new StringBuffer();
                while ((line = in.readLine()) != null) {
                    sb.append(line);
                }
                return sb.toString();
            }
            else {
                System.out.println(response);
                return " ";
            }
        } catch (Exception e) {
            Log.e("e:", String.valueOf(e));
            return e.toString();
        }



    }
    /**
     * 订单创建信息提交
     * @param urlStr 接口uel
     * @param user_address 收货地址
     * @param user_date 收货日期
     * @param thingtype 商品种类
     * @param thingnumber 商品数量
     * @return
     */
    public static String bookorder(String urlStr,String user_address,String user_date,String time,
                                   String salepeople,String thingtype,String thingnumber,String sign)
    {
        com.alibaba.fastjson.JSONObject order = new com.alibaba.fastjson.JSONObject();
        order.put("address",user_address);
        order.put("date",user_date);
        order.put("time",time);
        order.put("salepeople",salepeople);
        order.put("orderdes",thingtype);
        order.put("sum",thingnumber);
        order.put("sign",sign);
        try {
            URL url=new URL(urlStr);
            HttpURLConnection connect=(HttpURLConnection)url.openConnection();
            connect.setDoInput(true);
            connect.setDoOutput(true);
            connect.setRequestMethod("POST");
            connect.setUseCaches(false);
            connect.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            OutputStream outputStream = connect.getOutputStream();
            outputStream.write(order.toJSONString().getBytes());
            int response = connect.getResponseCode();
            if (response== HttpURLConnection.HTTP_OK)
            {
                System.out.println(response);
                InputStream input=connect.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(input));
                String line = null;
                System.out.println(connect.getResponseCode());
                StringBuffer sb = new StringBuffer();
                while ((line = in.readLine()) != null) {
                    sb.append(line);
                }
                return sb.toString();
            }
            else {
                System.out.println(response);
                return " ";
            }
        } catch (Exception e) {
            Log.e("e:", String.valueOf(e));
            return e.toString();
        }
    }
    /**
     * 订单创建信息提交
     * @param urlStr 接口uel
     * @param user_name 姓名
     * @return
     */
    public static String askorder(String urlStr,String user_name,String sign)
    {
        com.alibaba.fastjson.JSONObject order = new com.alibaba.fastjson.JSONObject();
        order.put("username",user_name);
        order.put("sign",sign);
        try {
            URL url=new URL(urlStr);
            HttpURLConnection connect=(HttpURLConnection)url.openConnection();
            connect.setDoInput(true);
            connect.setDoOutput(true);
            connect.setRequestMethod("POST");
            connect.setUseCaches(false);
            connect.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            OutputStream outputStream = connect.getOutputStream();
            outputStream.write(order.toJSONString().getBytes());
            int response = connect.getResponseCode();
            if (response== HttpURLConnection.HTTP_OK)
            {
                System.out.println(response);
                InputStream input=connect.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(input));
                String line = null;
                System.out.println(connect.getResponseCode());
                StringBuffer sb = new StringBuffer();
                while ((line = in.readLine()) != null) {
                    sb.append(line);
                }
                return sb.toString();
            }
            else {
                System.out.println(response);
                return " ";
            }
        } catch (Exception e) {
            Log.e("e:", String.valueOf(e));
            return e.toString();
        }
    }
    /**
     * 显示商品
     * @param urlStr 接口uel
     * @return
     */
    public static String showprice(String urlStr)
    {
        com.alibaba.fastjson.JSONObject order = new com.alibaba.fastjson.JSONObject();
        order.put("test","123");
        try {
            URL url=new URL(urlStr);
            HttpURLConnection connect=(HttpURLConnection)url.openConnection();
            connect.setDoInput(true);
            connect.setDoOutput(true);
            connect.setRequestMethod("POST");
            connect.setUseCaches(false);
            connect.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            OutputStream outputStream = connect.getOutputStream();
            outputStream.write(order.toJSONString().getBytes());
            int response = connect.getResponseCode();
            if (response== HttpURLConnection.HTTP_OK)
            {
                System.out.println(response);
                InputStream input=connect.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(input));
                String line = null;
                System.out.println(connect.getResponseCode());
                StringBuffer sb = new StringBuffer();
                while ((line = in.readLine()) != null) {
                    sb.append(line);
                }
                return sb.toString();
            }
            else {
                System.out.println(response);
                return " ";
            }
        } catch (Exception e) {
            Log.e("e:", String.valueOf(e));
            return e.toString();
        }
    }
}





