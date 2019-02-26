package main;

import com.cybozu.kintone.client.authentication.Auth;
import com.cybozu.kintone.client.connection.Connection;
import com.cybozu.kintone.client.exception.KintoneAPIException;
import com.cybozu.kintone.client.model.record.GetRecordsResponse;
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

        Integer appID = 00;
        // TRY1 顧客管理アプリのレコードを全て取得する
        // execute GET RECORD API
        GetRecordsResponse getResponse = kintoneRecord.getRecords(appID, null, null, true);
        for (int i = 0; i < getResponse.getTotalCount(); i++) {
            System.out.println("Record ID:" + getResponse.getRecords().get(i).get("$id").getValue());
            System.out.println("顧客名" + getResponse.getRecords().get(i).get("顧客名").getValue());
        }
    }
}
