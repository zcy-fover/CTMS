/**
 * 该 JS 用于处理用户登录后的基本信息的显示
 */
$(function (){
    var newUserId = $('#new-user').text();
    if(newUserId != '') {
        showAlert('欢迎进入', '你的职工号：' + newUserId, 'alert-info', false);
    }
    // 显示登录信息
    loginInfo();
});

var loginInfo = function() {
    var loginTime = $('#login-time').text();
    var loginStatus = $('#login-status').text();
    var target = $('.status');
    var info = getPointClass(loginStatus);
    // 如果是离开状态，则不显示
    if(loginStatus == 0) {
        target.html('<i class="'+ info.icon +'"></i> ' + info.describe);
    }
    else {
        var now = new Date();
        var hour = now.getHours();
        var minute = now.getMinutes();
        var loginHour = parseInt(loginTime.substr(11, 2));
        var loginMinute = parseInt(loginTime.substr(14, 2));
        // 登录信息，包括登录时长和登录状态
        var differ = dateDiffer(hour, minute, loginHour, loginMinute);
        target.html('<i class="' + info.icon + '"></i> ' + info.describe + ' ' + differ);
        setTimeout(loginInfo, 1000 * 60);
    }
};

/**
 * 计算登录时长
 * @param nowHour 当前 hours
 * @param nowMinute 当前 minutes
 * @param loginHour 登录 hours
 * @param loginMinute 登录 minutes
 * @returns {*}
 */
var dateDiffer = function(nowHour, nowMinute, loginHour, loginMinute) {
    var nowAllMinutes = nowHour * 60 + nowMinute;
    var loginAllMinutes = loginHour * 60 + loginMinute;
    var differ = nowAllMinutes - loginAllMinutes;
    if(differ < 0)
        return 'error';
    if(differ < 1)
        return '少于 1 分钟';
    else if(differ < 60)
        return differ + ' 分钟';
    else if(differ < (60 * 24))
        return parseInt(differ / 60) + ' 小时 ' + (differ % 60) + ' 分钟';
};

/**
 * 通过 status 获得在线信息
 * @param status
 * @returns {*}
 */
var getPointClass = function(status) {
    if(status == -1)
        return {icon: 'fa fa-times-circle-o' +
        ' text-gray', describe: '离线'};
    else if(status == 0)
        return {icon: 'fa fa-clock-o', describe: '离开'};
    else if(status == 1)
        return {icon: 'fa fa-check-circle text-success', describe: '在线'};
    else if(status == 2)
        return {icon: 'fa fa-minus-circle text-danger', describe: '忙碌'};
    else if(status == 3)
        return {icon: 'fa fa-ban text-danger', describe: '勿扰'};
    else
        return {icon: 'fa fa-circle', describe: '未知'};
};

/**
 * 时间对象的格式化;
 */
Date.prototype.format = function(format) {
    /*
     * eg:format="yyyy-MM-dd hh:mm:ss";
     */
    var o = {
        "M+" : this.getMonth() + 1, // month
        "d+" : this.getDate(), // day
        "h+" : this.getHours(), // hour
        "m+" : this.getMinutes(), // minute
        "s+" : this.getSeconds(), // second
        "q+" : Math.floor((this.getMonth() + 3) / 3), // quarter
        "S" : this.getMilliseconds()
        // millisecond
    };

    if (/(y+)/.test(format)) {
        format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4
            - RegExp.$1.length));
    }

    for (var k in o) {
        if (new RegExp("(" + k + ")").test(format)) {
            format = format.replace(RegExp.$1, RegExp.$1.length == 1
                ? o[k]
                : ("00" + o[k]).substr(("" + o[k]).length));
        }
    }
    return format;
}