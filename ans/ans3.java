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
		
        // TRY3 顧客管理アプリのレコードを２件更新する
        // execute PUT RECORD API
        ArrayList<HashMap<String, FieldValue>> putRecords = new ArrayList<>();
        HashMap<String, FieldValue> record3 = new HashMap<String, FieldValue>();
        FieldValue fv3 = new FieldValue();
        fv3.setType(FieldType.SINGLE_LINE_TEXT);
        fv3.setValue("テストシステムズ");
        record3.put("顧客名", fv3);

        HashMap<String, FieldValue> record4 = new HashMap<String, FieldValue>();
        FieldValue fv4 = new FieldValue();
        fv4.setType(FieldType.SINGLE_LINE_TEXT);
        fv4.setValue("テスト建設");
        record4.put("顧客名", fv4);

        ArrayList<RecordUpdateItem> items = new ArrayList<>();
        RecordUpdateItem item1 = new RecordUpdateItem(1, null, null, record3);
        RecordUpdateItem item2 = new RecordUpdateItem(2, null, null, record4);
        items.add(item1);
        items.add(item2);

        UpdateRecordsResponse putResponse = kintoneRecord.updateRecords(appID, items);

        System.out.println("Record Revision1: " + putResponse.getRecords().get(0).getRevision());
        System.out.println("Record Revision2: " + putResponse.getRecords().get(1).getRevision());
    }
}