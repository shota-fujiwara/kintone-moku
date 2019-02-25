/* global kintone */

(function() {
    "use strict";   
    /******************************************************************************
    レコード詳細画面表示時
    ******************************************************************************/
    kintone.events.on('app.record.detail.show', function(event) {
        // TRY1 create text box component
        const textValue = {value: 'default text'};
        const textBox = new kintoneUIComponent.Text(textValue);
        kintone.app.record.getSpaceElement('TEXT_BOX_SPACE').appendChild(textBox.render());
        
        // TRY1 create dropdown component
        const dropdownItems = {
            items: [
                {
                    label: '---',
                    value: '---',
                    isDisabled: false
                },
                {
                    label: 'Orange',
                    value: 'Orange',
                    isDisabled: false
                },
                {
                    label: 'Banana',
                    value: 'Banana',
                    isDisabled: false
                }
            ],
            value: '---'
        };
        const dropdown = new kintoneUIComponent.Dropdown(dropdownItems);
        kintone.app.record.getSpaceElement('DROP_DOWN_SPACE').appendChild(dropdown.render());
        
        // TRY2 create table component
        const tableContents = {
            rowTemplate: [dropdown, textBox],
            header: ['Fruit', 'Discription']
        };
        const table = new kintoneUIComponent.Table(tableContents);
        kintone.app.record.getSpaceElement('TABLE_SPACE').appendChild(table.render());

        // TRY3 create rowAdd event
        table.on('rowAdd', function(data) {
            const tableItems = data.tableValue; // テーブル内のデータを取得
            const lastItem = tableItems.slice(-2)[0]; // テーブル内の最新の一つ前の行を取得
            tableItems[tableItems.length - 1] = lastItem; // 新規作成した行に一つ前の行の値をセット
        });
        return event;
    });
})();
