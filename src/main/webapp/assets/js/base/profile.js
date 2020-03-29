$(function(){
    //Date picker
    $('.datepicker').datepicker({
        autoclose: true,
        format: "yyyy-mm-dd"
    });
    // popover init
    $('[data-toggle="popover"]').popover()
});

var clearBirthday = function(obj) {
    console.log("clicked!");
    $(obj).prev('input').val('');
};

/**
 * 处理 ajax 请求
 * @param obj
 */
var modify = function(obj) {
    var form = $('#modify-form');
    var url = $('#url').text();
    console.log(url);
    //console.log(JSON.stringify(form.serializeArray()));
    $.post(url, $(form).serialize(), function(data) {
        console.log(data);
        if(data.status == 'success') {
            // 个人信息修改完毕后，更改form状态为锁定状态
            formStatus(true);
            showAlert('成功', data.message, 'alert-success', true);
        }
    }, 'json');
};

/**
 * 更改表单的状态，锁定状态下不能进行修改，解锁状态下可以对表单修改
 * @param lock true，转化为锁定状态，false，解锁状态
 */
var formStatus = function(lock) {
    if(lock) {
        // 进行锁定
    }
    else {
        // 解除锁定
    }
};