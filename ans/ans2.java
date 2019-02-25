package main;

import java.util.ArrayList;
import java.util.HashMap;

import com.cybozu.kintone.client.authentication.Auth;
import com.cybozu.kintone.client.connection.Connection;
import com.cybozu.kintone.client.exception.KintoneAPIException;
import com.cybozu.kintone.client.model.app.form.FieldType;
import com.cybozu.kintone.client.model.record.AddRecordsResponse;
import com.cybozu.kintone.client.model.record.field.FieldValue;
import com.cybozu.kintone.client.module.record.Record;

public class JavaSdkSample {

    public static void main(String[] args) throws KintoneAPIException {

        String USERNAME = "tanaka";
        String PASSWORD = "tanaka";

        // Init authenticationAuth
        Auth kintoneAuthWithPassword = new Auth();
        kintoneAuthWithPassword.setPasswordAuth(USERNAME, PASSWORD);

        // Init Connection without "guest space ID"
        Connection kintoneConnection = new Connection("cy2013.cybozu.com", kintoneAuthWithPassword);

        // Init Record Module
        Record kintoneRecord = new Record(kintoneConnection);

        Integer appID = 457;

        // TRY2 顧客管理アプリにレコードを２件追加する
        // execute POST RECORD API
        HashMap<String, FieldValue> record1 = new HashMap<String, FieldValue>();
        FieldValue fv1 = new FieldValue();
        fv1.setType(FieldType.SINGLE_LINE_TEXT);
        fv1.setValue("テストシステムズ");
        record1.put("顧客名", fv1);

        HashMap<String, FieldValue> record2 = new HashMap<String, FieldValue>();
        FieldValue fv2 = new FieldValue();
        fv2.setType(FieldType.SINGLE_LINE_TEXT);
        fv2.setValue("テスト建設");
        record2.put("顧客名", fv2);

        ArrayList<HashMap<String, FieldValue>> postRecords = new ArrayList<>();
        postRecords.add(record1);
        postRecords.add(record2);
        AddRecordsResponse postResponse = kintoneRecord.addRecords(appID, postRecords);

        System.out.println("Record ID1: " + postResponse.getIDs().get(0));
        System.out.println("Record ID2: " + postResponse.getIDs().get(1));
    }
}
