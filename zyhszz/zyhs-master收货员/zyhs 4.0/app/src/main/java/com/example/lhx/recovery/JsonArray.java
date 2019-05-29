package com.example.lhx.recovery;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonArray {
    public static boolean isJson(String str){
        if(str == null){
            System.out.println("1");
            return false;
        }
        try {
            System.out.println("2");
            new JSONArray(str);
        } catch (JSONException e) {
            System.out.println("3");
            return false;
        }
        System.out.println("4");
        return true;
    }

}
