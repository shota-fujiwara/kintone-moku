(function() {
    'use strict';

    kintone.events.on('app.record.detail.show', function(event) {
        var checkbox = new kintoneUIComponent.CheckBox ({
            items: [
                {
                    label: 'Orange',
                    value: 'Orange',
                    isDisabled: false
                },
                {
                    label: 'Banana',
                    value: 'Banana',
                    isDisabled: false
                },
                {
                    label: 'Lemon',
                    value: 'Lemon',
                    isDisabled: true
                },
            ],
            value: ['Orange']
        });
        kintone.app.record.getSpaceElement('component-UI').appendChild(checkbox.render());
    });
})();