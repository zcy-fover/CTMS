var login_form = $('#login-form');
var register_form = $('#register-form');

$(function () {
    //var message = $('#message').text();
    //if(message != '') {
    //    var title = message.split('|')[0];
    //    var msg = message.split('|')[1];
    //    console.log(title + ' | ' + msg);
    //    showAlert(title, msg, 'alert-info', false);
    //}

    // 登录
    $('#login-button').click(function(){
        var password = login_form.find('input[name="password"]');
        password.val($.md5(password.val()));
        //login_form.submit();
    });
    // 注册
    $('#register-button').click(function(){
        var password = register_form.find('input[name="password"]');
        password.val($.md5(password.val()));
        //register_form.submit();
    });
});

/**
 * 切换注册视图
 */
var registerView = function(){
    $('.login-box-body').hide();
    $('.register-box-body').slideDown('slow');
    $('title').text('用户注册');
};
var loginView = function(){
    $('.register-box-body').hide();
    $('.login-box-body').slideDown('slow');
    $('title').text('用户登录');
};
