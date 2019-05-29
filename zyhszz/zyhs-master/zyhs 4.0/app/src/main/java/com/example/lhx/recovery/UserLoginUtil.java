package com.example.lhx.recovery;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;


import com.example.lhx.recovery.LoadActivity;

import static android.content.Context.MODE_PRIVATE;

public class UserLoginUtil {
    public boolean UserLogin(SharedPreferences et){
        String userlogin = et.getString("username","");
        System.out.println("1111"+userlogin+"111111111");
        if("".equals(userlogin)){
            return true;
        }
        return false;
    }
}
