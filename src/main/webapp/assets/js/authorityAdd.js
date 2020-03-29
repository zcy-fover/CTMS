/**
 * Created by Chirs on 2016/11/16.
 */
$(document).ready(function() {
    $('#authority-form').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            user_id: {
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
                    }
                }
            },
            approval_state: {
                validators: {
                    notEmpty: {
                        message: '审批状态码不能为空'
                    },
                stringLength: {
                    max: 4,
                    message: '员工工号小于4位'
                },
                    numeric: {
                        message: '审批状态码只能输入数字'
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