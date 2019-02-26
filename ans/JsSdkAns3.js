var appID = 000;
var recordID = 00;
 
var kintoneConnection = new kintoneJSSDK.Connection();
var kintoneRecord = new kintoneJSSDK.Record(kintoneConnection);

// TRY3 顧客管理アプリのレコードを２件更新する
var record3 = {
    顧客名: {
      value: 'jsテストシステムズ'
    }
  };
var record4 = {
    顧客名: {
      value: 'jsテスト建設'
    }
  };

var updateItem1 = {
  id: '1',
  record: record3,
};

var updateItem2 = {
  id: '2',
  record: record4,
};

var updateItems = [];
updateItems.push(updateItem1);
updateItems.push(updateItem2);

kintoneRecord.updateRecords(appID, updateItems).then((rsp) => {
  console.log(rsp);
}).catch((err) => {
  console.log(err.get());
});