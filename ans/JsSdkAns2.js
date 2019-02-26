var appID = 000;
var recordID = 00;
 
var kintoneConnection = new kintoneJSSDK.Connection();
var kintoneRecord = new kintoneJSSDK.Record(kintoneConnection);

// TRY2 顧客管理アプリにレコードを２件追加する
var record1 = {
    顧客名: {
      value: 'jsテストシステムズ'
    }
  };
var record2 = {
    顧客名: {
      value: 'jsテスト建設'
    }
  };
var records = [];
records.push(record1);
records.push(record2);
kintoneRecord.addRecords(appID, records).then((rsp) => {
  console.log(rsp);
}).catch((err) => {
  console.log(err.get());
});