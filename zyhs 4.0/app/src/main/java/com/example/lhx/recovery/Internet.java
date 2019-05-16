package com.example.lhx.recovery;

import android.util.Log;

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

    public static String gethttppostresult(String urlStr, int id) {
        String params = "{\"article_id\":1,\"user_id\":2}";
        try {
            URL url = new URL(urlStr);
            HttpURLConnection connect = (HttpURLConnection) url.openConnection();
            connect.setDoInput(true);
            connect.setDoOutput(true);
            connect.setRequestMethod("POST");//递交数据
            connect.setUseCaches(false);
            connect.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            OutputStream outputStream = connect.getOutputStream();
            outputStream.write(params.getBytes());
            int response = connect.getResponseCode();
            if (response == HttpURLConnection.HTTP_OK) {
                System.out.println(response);
                InputStream input = connect.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(input));
                String line = null;
                System.out.println(connect.getResponseCode());
                StringBuffer sb = new StringBuffer();
                while ((line = in.readLine()) != null) {
                    sb.append(line);
                }
                return sb.toString();
            } else {
                System.out.println(response);
                return "not exsits";
            }
        } catch (Exception e) {
            Log.e("e:", String.valueOf(e));
            return "internet error";
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
        String params = "{\"user_name\":" +user_name +",\"user_password\":" + user_password+  "}";
        try {
            URL url=new URL(urlStr);
            HttpURLConnection connect=(HttpURLConnection)url.openConnection();
            connect.setDoInput(true);
            connect.setDoOutput(true);
            connect.setRequestMethod("POST");
            connect.setUseCaches(false);
            connect.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            OutputStream outputStream = connect.getOutputStream();
            outputStream.write(params.getBytes());
            int response = connect.getResponseCode();
            if (response== HttpURLConnection.HTTP_OK)
            {
                System.out.println(response);
                InputStream input=connect.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(input));
                String line = null;
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
     * 用户注册
     * @param urlStr    接口uel
     * @param user_password     用户输入的新密码
     * @param user_name     用户名
     * @param user_phone    用户手机号
     * @param user_real 用户真实姓名
     * @return
     */
    public static String newaccount(String urlStr,String user_password,String user_name,String user_phone,String user_real){
        String params = "{\"user_password\":" +user_password +",\"user_name\":" + user_name+  ",\"user_phone\":"+user_phone+ "，\"user_real\":"+user_real+"}";
        try {
            URL url=new URL(urlStr);
            HttpURLConnection connect=(HttpURLConnection)url.openConnection();
            connect.setDoInput(true);
            connect.setDoOutput(true);
            connect.setRequestMethod("POST");
            connect.setUseCaches(false);
            connect.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            OutputStream outputStream = connect.getOutputStream();
            outputStream.write(params.getBytes());
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
     * @param user_phone    用户手机号
     * @param user_address    用户需要新增的地址
     * @return
     */
    public static String addaddresss(String urlStr,String user_name,String user_phone,String user_address)
    {
        String params = "{\"user_name\":" +user_name +",\"user_phone\":" + user_phone+  ",\"user_address\":"+user_address+ "}";
        try {
            URL url=new URL(urlStr);
            HttpURLConnection connect=(HttpURLConnection)url.openConnection();
            connect.setDoInput(true);
            connect.setDoOutput(true);
            connect.setRequestMethod("POST");
            connect.setUseCaches(false);
            connect.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            OutputStream outputStream = connect.getOutputStream();
            outputStream.write(params.getBytes());
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
     * @param user_time 收货时间
     * @param thingtype 商品种类
     * @param thingnumber 商品数量
     * @return
     */
    public static String bookorder(String urlStr,String user_address,String user_date,String user_time,String thingtype,String thingnumber)
    {
        String params = "{\"user_address\":" +user_address +",\"user_date\":" + user_date+  ",\"user_time\":"+user_time+ ",\"thingtype\":"+thingtype+",\"thingnumber\":"+thingnumber+"}";

        try {
            URL url=new URL(urlStr);
            HttpURLConnection connect=(HttpURLConnection)url.openConnection();
            connect.setDoInput(true);
            connect.setDoOutput(true);
            connect.setRequestMethod("POST");
            connect.setUseCaches(false);
            connect.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            OutputStream outputStream = connect.getOutputStream();
            outputStream.write(params.getBytes());
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
     * 用户账号信息修改
     * @param urlStr    接口uel
     * @param user_name     用户名
     * @param user_phone    用户手机号
     * @return
     */
    public static String changeaccount(String urlStr,String user_name,String user_phone){
        String params = "{\"user_name\":" + user_name+  ",\"user_phone\":"+user_phone+ "}";
        try {
            URL url=new URL(urlStr);
            HttpURLConnection connect=(HttpURLConnection)url.openConnection();
            connect.setDoInput(true);
            connect.setDoOutput(true);
            connect.setRequestMethod("POST");
            connect.setUseCaches(false);
            connect.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            OutputStream outputStream = connect.getOutputStream();
            outputStream.write(params.getBytes());
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
     * 地址管理界面接收地址信息
     * @param urlStr    接口uel
     * @param user_name     用户名
     * @param user_phone    用户手机号
     * @return
     */



}





