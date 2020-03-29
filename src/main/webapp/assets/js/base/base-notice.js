/**
 * 该 JS 实现了两个功能：showAlert 和 showTip
 * @type {*|jQuery|HTMLElement}
 */
var alert = $('#alert');
// alert 默认弹出的速度
var animation_speed = 'normal';
// alert 默认消失时间
var dismiss_time = 2000;
// alert 默认样式
var reset_style = {
    'margin': '0 auto',
    'display': 'table',
    'z-index': '2000'
};

$(function (){
    // 绑定关闭事件
    $(alert).find('button').click(function (){
        $(alert).closest('div').hide();
    });
    // 设定样式
    $(alert).find('h4').css({display: 'inherit', color: 'blue'});
    $(alert).find('p').css({'display': 'table', 'margin': '0 auto'});
    $(alert).css(reset_style).closest('div').hide();
});

/**
 * 显示 alert
 * @param title 信息标题
 * @param message 信息体
 * @param level 显示一个提示框，提示框有四种等级：.alert-success、.alert-info、.alert-warning、.alert-danger
 */
var showAlert = function(title, message, level, push) {
    var icon;
    if(title != '' && message != '' && level != '') {
        // 设置 icon 的样式，检验 level 是否在规定的四个等级内
        if(level == 'alert-success')
            icon = 'fa-check';
        else if(level == 'alert-info')
            icon = 'fa-info';
        else if(level == 'alert-warning')
            icon = 'fa-warning';
        else if(level == 'alert-danger')
            icon = 'fa-ban';
        else
            return;
        // 格式化数据
        level = 'alert alert-dismissible ' + level;
        icon = 'icon fa ' + icon;
        // 写入数据到标签上
        $(alert).attr('class', level);
        $(alert).find('h4').html('<i class="' + icon + '"></i>'+' ' + title);
        $(alert).find('p').text(message);
        if(!push)
            $(alert).closest().css({'height': '0'});
        // 显示
        $(alert).closest('div').slideDown(animation_speed);
        //hideAlert(dismiss_time);
    }
};

// 隐藏 Alert
var hideAlert = function(time) {
    $(alert).fadeOut(time);
};
// 设置 CSS 样式
var setCSS = function(new_style) {
    $(alert).css(new_style);
};
// 重置 CSS 样式
var resetCSS = function() {
    $(alert).css(reset_style);
};

var setPopover = function(popover, width) {
    $(popover).find('div[class="arrow"]').css({top: '50%'});
    $(popover).find('div[class="popover-content"]').css({
        width: width,
        height: '38px'
    });
};

/**
 * 显示 tip
 * @param target
 * @param opts
 */
var showTip = function(target, msg) {
    $(target).data('content', msg);
    target.popover('show');
};
/**
 * 隐藏 tip
 * @param target
 */
var hideTip = function(target) {
    target.popover('hide');
};

var setTipOptions = function(target, key, value) {
    if(typeof(target) != 'undefined') {
        $(target).data(key, value);
    }
};