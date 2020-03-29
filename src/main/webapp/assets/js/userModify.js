$(function () {
    var message = $('#message').text();
    if (message != '') {
        var title = message.split('|')[0];
        var msg = message.split('|')[1];
        console.log(title + ' | ' + msg);
        showAlert(title, msg, 'alert-info', false);
    }

    $('#modify-button').click(function(){
        var password = $('#modify-form').find('input[name="password"]');
        password.val($.md5(password.val()));
        //register_form.submit();
    });
});

$(document).ready(function() {
    $('#modify-form').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            employee_num: {
                message: 'The username is not valid',
                validators: {
                    notEmpty: {
                        message: '员工工号不能为空'
                    },
                    stringLength: {
                        min: 3,
                        max: 6,
                        message: '员工工号大于3位小于6位'
                    },
                    numeric: {
                        message: '员工工号只能输入数字'
                    },
                    different: {
                        field: 'password',
                        message: '员工工号不能与密码一致'
                    }
                }
            },
            employee_name: {
                validators: {
                    notEmpty: {
                        message: '员工姓名不能为空'
                    }
                }
            },
            password: {
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    },
                    different: {
                        field: 'employee_num',
                        message: '密码与员工工号不能一致'
                    }
                }
            },
            retypePassword: {
                validators: {
                    notEmpty: {
                        message: '密码不能为空'
                    },
                    identical: {
                        field: 'password',
                        message: '与输入密码不一致'
                    }
                }
            }
        }
    });

    // Validate the form manually
    $('#validateBtn').click(function() {
        $('#defaultForm').bootstrapValidator('validate');
    });

    // $('#reset').click(function() {
    //     $('#modify-form').data('bootstrapValidator').resetForm(true);
    // });
});