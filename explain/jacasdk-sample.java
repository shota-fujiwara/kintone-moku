package javasdk-sample;
 
import java.util.HashMap;
 
import com.cybozu.kintone.client.authentication.Auth;
import com.cybozu.kintone.client.connection.Connection;
import com.cybozu.kintone.client.exception.KintoneAPIException;
import com.cybozu.kintone.client.model.record.GetRecordResponse;
import com.cybozu.kintone.client.model.record.field.FieldValue;
import com.cybozu.kintone.client.module.record.Record;
 
public class JavaSdkGetTest {
 
    public static void main(String[] args) throws KintoneAPIException {
        // TODO 自動生成されたメソッド・スタブ
        String USERNAME = "XXXXXX";
        String PASSWORD = "YYYYYY";
 
        // Init authenticationAuth
        Auth kintoneAuthWithPassword = new Auth();
        kintoneAuthWithPassword.setPasswordAuth(USERNAME, PASSWORD);
 
        // Init Connection without "guest space ID"
        Connection kintoneConnection = new Connection("ZZZZZZ.cybozu.com", kintoneAuthWithPassword);
 
        // Init Record Module
        Record kintoneRecord = new Record(kintoneConnection);
 
        // execute GET RECORD API
        Integer appID = 437;
        Integer recordID =15;
        GetRecordResponse response = kintoneRecord.getRecord(appID, recordID);
 
        // data Response of the get request
        HashMap<String, FieldValue> record = response.getRecord();
        System.out.println("record ID: " + record.get("$id").getValue());
        System.out.println("record FieldCode: " + record.get("FiledCode").getValue());
 
        /*
        output:
           record ID:   // ID of response record
           record FieldCode:   // FieldValue of response record
        */
    }
 
}