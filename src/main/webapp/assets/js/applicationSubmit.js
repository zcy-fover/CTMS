/**
 * Created by Chirs on 2016/11/16.
 */
$(document).ready(function() {
    $('#application-form').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            reason: {
                validators: {
                    notEmpty: {
                        message: '出差事由不能为空'
                    }
                }
            },
            startDate: {
                validators: {
                    notEmpty: {
                        message: '开始时间不能为空'
                    }
                }
            },
            endDate: {
                validators: {
                    notEmpty: {
                        message: '结束时间不能为空'
                    }
                }
            },
            destination: {
                validators: {
                    notEmpty: {
                        message: '出差地点不能为空'
                    }
                }
            },
            vehicle: {
                validators: {
                    notEmpty: {
                        message: '交通工具不能为空'
                    }
                }
            },
            trafficFee: {
                validators: {
                    notEmpty: {
                        message: '交通费不能为空'
                    },
                    numeric: {
                        message: '交通费只能输入数字'
                    }
                }
            },
            accomodation: {
                validators: {
                    notEmpty: {
                        message: '住宿费不能为空'
                    },
                    numeric: {
                        message: '住宿费只能输入数字'
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
$('#startDateId').datetimepicker({
    autoclose:true,
    todayHighlight : true,
    startView : 3,
    minView : 2
}).on('hide',function(e) {
    $('#application-form').data('bootstrapValidator')
        .updateStatus('startDate', 'NOT_VALIDATED',null)
        .validateField('startDate');
});
$('#endDateId').datetimepicker({
    autoclose:true,
    todayHighlight : true,
    startView : 3,
    minView : 2
}).on('hide',function(e) {
    $('#application-form').data('bootstrapValidator')
        .updateStatus('endDate', 'NOT_VALIDATED',null)
        .validateField('endDate');
});
