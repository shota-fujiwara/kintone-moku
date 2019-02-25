package main;

import java.util.ArrayList;
import java.util.HashMap;

import com.cybozu.kintone.client.authentication.Auth;
import com.cybozu.kintone.client.connection.Connection;
import com.cybozu.kintone.client.exception.KintoneAPIException;
import com.cybozu.kintone.client.model.app.form.FieldType;
import com.cybozu.kintone.client.model.record.RecordUpdateItem;
import com.cybozu.kintone.client.model.record.UpdateRecordsResponse;
import com.cybozu.kintone.client.model.record.field.FieldValue;
import com.cybozu.kintone.client.module.record.Record;

public class JavaSdkSample {

    public static void main(String[] args) throws KintoneAPIException {

        String USERNAME = "xxxx";
        String PASSWORD = "xxxx";

        // Init authenticationAuth
        Auth kintoneAuthWithPassword = new Auth();
        kintoneAuthWithPassword.setPasswordAuth(USERNAME, PASSWORD);

        // Init Connection without "guest space ID"
        Connection kintoneConnection = new Connection("sample.cybozu.com", kintoneAuthWithPassword);

        // Init Record Module
        Record kintoneRecord = new Record(kintoneConnection);

        Integer appID = 457;
        // TRY1 顧客管理アプリのレコードを全て取得する
        // execute GET RECORD API


        // TRY2 顧客管理アプリにレコードを２件追加する
        // execute POST RECORD API

        // TRY3 顧客管理アプリのレコードを２件更新する
        // execute PUT RECORD API
    }
}