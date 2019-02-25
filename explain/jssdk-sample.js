let appID = 434;
let recordID = 1;
 
var kintoneConnection = new kintoneJSSDK.Connection();
var kintoneRecord = new kintoneJSSDK.Record(kintoneConnection);
kintoneRecord.getRecord(appID, recordID).then((rsp) => {
  console.log(rsp);
}).catch((err) => {
  console.log(err.get());
});