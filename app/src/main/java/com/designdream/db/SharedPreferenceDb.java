package com.designdream.db;

import android.content.Context;
import android.content.SharedPreferences;

import com.designdream.constants.DbConstants;

/**
 * Created by leianjun on 2017/3/28.
 */

public class SharedPreferenceDb {

    private Context context;

    public SharedPreferenceDb(Context context) {
        this.context = context;
    }

    public void setIsFirstInstall() {
        SharedPreferences sp = context.getSharedPreferences(DbConstants.DB_IS_INSTALL,
                Context.MODE_PRIVATE);
        sp.edit().putBoolean(DbConstants.KEY_IS_INSTALL, true).commit();
    }
    public boolean getIsFirstInstall(){
        SharedPreferences sp=context.getSharedPreferences(DbConstants.DB_IS_INSTALL,
                Context.MODE_PRIVATE);
        return sp.getBoolean(DbConstants.KEY_IS_INSTALL, false);
    }
    public void setUserId(String userId){
        SharedPreferences sp=context.getSharedPreferences(DbConstants.DB_USER_ID, Context.MODE_PRIVATE);
        sp.edit().putString(DbConstants.KEY_USER_ID, userId).commit();
    }

    public String getUserId(){
        SharedPreferences sp=context.getSharedPreferences(DbConstants.DB_USER_ID, Context.MODE_PRIVATE);
        return sp.getString(DbConstants.KEY_USER_ID, "");
    }

    public String getPassword(){
        SharedPreferences sp=context.getSharedPreferences(DbConstants.DB_USER_PWD, Context.MODE_PRIVATE);
        return sp.getString(DbConstants.KEY_USER_PWD, "");
    }
    public void setPassword(String password){
        SharedPreferences sp=context.getSharedPreferences(DbConstants.DB_USER_PWD, Context.MODE_PRIVATE);
        sp.edit().putString(DbConstants.KEY_USER_PWD, password).commit();
    }

    public String getIsRemember(){
        SharedPreferences sp=context.getSharedPreferences(DbConstants.DB_IS_REMEMBRT_PWD, Context.MODE_PRIVATE);
        return sp.getString(DbConstants.KEY_IS_REMEMBER_PWD, "");
    }
    public void setIsRemember(String str){
        SharedPreferences sp=context.getSharedPreferences(DbConstants.DB_IS_REMEMBRT_PWD, Context.MODE_PRIVATE);
        sp.edit().putString(DbConstants.KEY_IS_REMEMBER_PWD, str).commit();
    }
}
