var appID = 000;
var recordID = 00;
 
var kintoneConnection = new kintoneJSSDK.Connection();
var kintoneRecord = new kintoneJSSDK.Record(kintoneConnection);

// TRY1 顧客管理アプリのレコードを全て取得する
kintoneRecord.getRecords(appID, null, null, true).then((rsp) => {
  console.log(rsp);
}).catch((err) => {
  console.log(err.get());
});
