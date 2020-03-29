/**
 * 该 JS 用于处理聊天模块
 */
var BASE_ADDRESS = window.location.host + '/ProjectSpring';
//var ws;
// 必须以“/”开头，例如：“/myHandler”
var root_websocket_addr = 'ws://' + BASE_ADDRESS + '/websocket';
var root_http_addr = 'http://' + BASE_ADDRESS + '/message';
var modal = $('#message-modal');
var chat_messages_div = modal.find('div.direct-chat-messages');
var friend_group_div = $('#friend-group');
var chat_content = $('#chat-content');
var user = {
    id: $('#user-id').text(),
    name: $('span.hidden-xs').text(),
    img: $('img.user-image').attr('src')
};
var user_panel = $(modal).find('div.user-panel');

$(function () {
    // 获取并在前端添加好友列表
    getFriendGroup(user.id);

    if (!'WebSocket' in window) {
        showAlert('警告', '您的浏览器尚未支持 WebSocket，好友系统暂时无法使用', 'alert-danger', 'false');
    }
    else if (typeof(ws) == 'undefined' || ws.readyState != WebSocket.OPEN) {
        console.log(root_websocket_addr + '/' + user.id + '/text');
        ws = new WebSocket(root_websocket_addr + '/' + user.id + '/text');
        ws.onopen = doOpen;
        ws.onmessage = doMessage;
        ws.onclose = doClose;
        ws.onerror = doError;
    }
});

/* 关于聊天系统的动态样式 */
var dynamicCSS = function() {
    // 完成好友列表的下拉样式
    var collapse = $(friend_group_div).find('div.panel-collapse.collapse');
    collapse.on('shown.bs.collapse', function(even){
        $(even.target).prev().find('i').attr('class', 'fa fa-angle-down pull-right');
    });
    collapse.on('hidden.bs.collapse', function(even){
        $(even.target).prev().find('i').attr('class', 'fa fa-angle-left pull-right');
    });
};

var sendMsg = function (msg) {
    var json = JSON.stringify(msg);
    console.log("send message: " + json);
    ws.send(json);
};

/**
 * 定义 Message 类
 * @param fromId
 * @param toId
 * @param message
 * @param level
 * @constructor
 */
var Message = function (fromId, toId, message) {
    // 消息等级（-2：二进制，-1：垃圾消息，0：普通消息，1：重要消息，2：紧急消息，10：用户登录消息，11：用户登出消息，12：在线状态改变）
    var NORMAL = 0;
    var IMPORTANT = 1;
    var EMERGENCY = 2;
    var SPAM = -1;
    var BINARY = -2;
    var ONLINE = 10;
    var OFFLINE = 11;
    this.fromId = fromId;
    this.toId = toId;
    this.fromName = '';
    this.toName = '';
    this.message = message;
    this.level = 0;
    this.createTime = new Date().format('yyyy-MM-dd hh:mm:ss');
    // 用户读取的标识位，-1：未接收的信息，0：未读信息，1：已读信息
    this.readStatus = -1;
    this.type = 'text';
};

/**
 * Ajax 获得好友列表
 */
var getFriendGroup = function (user_id) {
    $.get(root_http_addr + '/groups?userId=' + user_id, function (data) {
        setFriendGroup(data);
        // 为好友列表设定 css 样式
        dynamicCSS();
    }, 'json');
};

var setFriendGroup = function (data) {
    var group_name;
    var groups = '';
    for (var i = 0; i < data.length; i++) {
        var head_id = 'head' + i;
        var collapse_id = 'collapse' + i;
        var friends = '';
        for (var k = 0; k < data[i].friends.length; k++) {
            var to_name = data[i].friends[k].subUsername;
            var alias = data[i].friends[k].alias;
            var name = alias == null ? to_name : alias;
            var unread_message_number = data[i].friends[k].unreadMessageNumber > 0? '<small class="label pull-right bg-green unread-number">' + data[i].friends[k].unreadMessageNumber + '</small>' : '';
            console.log(data[i].friends[k].subUserId +" unread message number: " + data[i].friends[k].unreadMessageNumber);
            //console.log('alias: ' + alias + ', username: ' + to_name + ', name: ' + name);
            var to_img = 'http://' + BASE_ADDRESS + data[i].friends[k].subUserHeadPath;
            var img_style = data[i].friends[k].subUserStatus == -1 ? '-webkit-filter: grayscale(100%);' : '';
            friends += '' +
                '<button class="btn btn-default" href="#"><i class="fa fa-user fa-fw"></i> User</button>' +
                '<a href="javascript:void(0)"' +
                'data-content="" data-from_id="' + data[i].friends[k].priUserId + '"' +
                'data-to_id="' + data[i].friends[k].subUserId + '" data-from_img="' + user.img + '"' +
                'data-to_img="' + to_img + '" data-from_name="' + user.name + '"' +
                'data-to_name="' + name + '" data-to_status="' + data[i].friends[k].subUserStatus + '"' +
                'onclick="showMessageModal(this)"> ' +
                '<li class="list-group-item"> ' +
                '<img src="' + to_img + '" class="img-circle" alt="User Image" style="' + img_style + '">' + name + ' ' +
                '<span class="pull-right-container">' +
                unread_message_number +
                '</span>' +
                //'<div class="btn-group">' +
                //'<a class="btn btn-primary dropdown-toggle" data-toggle="dropdown" href="#"><span class="fa fa-caret-down" title="Toggle dropdown menu"></span></a>' +
                //'<ul class="dropdown-menu">' +
                //'<li><a href="#"><i class="fa fa-pencil fa-fw"></i> Edit</a></li>' +
                //'<li><a href="#"><i class="fa fa-trash-o fa-fw"></i> Delete</a></li>' +
                //'<li><a href="#"><i class="fa fa-ban fa-fw"></i> Ban</a></li><li class="divider"></li>' +
                //'<li><a href="#"><i class="fa fa-unlock"></i> Make admin</a></li>' +
                //'</ul>' +
                //'</div>' +
                '</li>' +
                '</a>';
        }
        groups += '' +
            '<div class="panel panel-default"> ' +
            '<a role="button" data-toggle="collapse" data-parent="#friend-group"' +
            'href="#' + collapse_id + '"' +
            'aria-expanded="false" aria-controls="' + collapse_id + '">' +
            data[i].name +
            ' <i class="fa fa-angle-left pull-right"></i> ' +
            '</a> ' +
            '<div id="' + collapse_id + '" class="panel-collapse collapse"' +
            'role="tabpanel"' +
            'aria-labelledby="' + head_id + '"> ' +
            '<ul class="list-group"> ' +
            friends +
            '</ul> ' +
            '</div> ' +
            '</div>';
    }
    friend_group_div.html(groups);
};

/**
 * 创建连接
 * @uri 必须以“/”开头，例如：“/myHandler”
 */
var connect = function (uri) {
    if (!'WebSocket' in window) {
        showAlert('警告', '您的浏览器尚未支持 WebSocket，好友系统暂时无法使用', 'alert-danger', 'false');
        return;
    }
    console.log(root_websocket_addr + uri);
    ws = new WebSocket(root_websocket_addr + uri);
    ws.onopen = doOpen;
    ws.onmessage = doMessage;
    ws.onclose = doClose;
    ws.onerror = doError;
};

var doOpen = function () {
    console.log('doOpen');
};
var doMessage = function (event) {
    console.log("get message: " + event.data);
    var msg = JSON.parse(event.data);
    messageManager(msg);
};
var doClose = function () {
    console.log('close');
};
var doError = function (event) {
    console.log('error');
};
/**
 * 用于处理接收的消息
 * @param msg
 */
var messageManager = function (msg) {
    var user = friend_group_div.find('a[data-to_id="' + msg.fromId + '"]');
    if (msg.level == 10) {
        $(user).data('to_status', '1');
        console.log(user.html());
        $(user).find('img').css('-webkit-filter', 'grayscale(0%)');
        return;
    }
    if (msg.level == 11) {
        $(user).data('to_status', '-1');
        $(user).find('img').css('-webkit-filter', 'grayscale(100%)');
        return;
    }
    if (msg.level >=0 && msg.level < 10) {
        // 情景 1：实时聊天
        if($(modal).hasClass('in')) {
            console.log('[实时] 收到消息：' + msg.message);
            var init_data = {
                from_id: user.id,
                from_img: user.img,
                to_img: $(user_panel).find('img').attr('src')
            };
            setChatRecord([msg], init_data, true);
        }
        // 情景 2：一方打开了聊天窗口，另外一方在线但是未打开
        else {
            console.log('[非实时] 收到消息：' + msg.message);
            var container = $(friend_group_div).find('a[data-to_id="' + msg.fromId + '"] span');
            var small = $(container).find('small');
            var unread_message_number = Number($(small).text());
            if(unread_message_number < 1) {
                unread_message_number = 1;
            }
            else {
                ++unread_message_number;
            }
            $(container).html('<small class="label pull-right bg-green unread-number">' + unread_message_number + '</small>');
        }
    }
};


var sendMessage = function (obj) {
    var msg = $(chat_content).val();
    if (typeof(msg) == 'undefined' || msg.length < 1) {
        $(chat_content).data('content', '内容不能为空');
        $(chat_content).data('trigger', 'manual');
        $(chat_content).data('placement', 'top');
        $(chat_content).popover('show');
        setTimeout(function(){
            $(chat_content).popover('hide');
        }, 1000);
        return;
    }
    var init_data = {
        from_id: user.id,
        from_img: user.img,
        to_img: $(user_panel).find('img').attr('src')
    };
    var from = user.id;
    var to = $(chat_content).data('to_id');
    var message = new Message(from, to, msg);
    message.fromName = user.name;
    message.toName = $(user_panel).find('p').text();
    if (ws.readyState == WebSocket.OPEN) {
        console.log('send message[length=' + [message].length + ']: ' + JSON.stringify(message));
        ws.send(JSON.stringify(message));
        setChatRecord([message], init_data, true);
        $(chat_content).val('');
    }
    else {
        alert("ws's state is not OPEN");
    }
};

/**
 *
 * @param obj
 * {
 *  from_id: ...,
 *  to_id: ...,
 *  from_img: ...,
 *  to_img: ...,
 *  from_name: ...,
 *  to_name: ...,
 *  to_status: ...
 *  }
 */
var showMessageModal = function (obj) {
    // 对 modal 初始化
    var content = $(obj).data('content');
    var init_data = {
        from_id: $(obj).data('from_id'),
        to_id: $(obj).data('to_id'),
        from_img: $(obj).data('from_img'),
        to_img: $(obj).data('to_img'),
        from_name: $(obj).data('from_name'),
        to_name: $(obj).data('to_name'),
        to_status: $(obj).data('to_status')
    };
    initChatModal(init_data, content);
    // 加载好友信息与聊天记录
    var param = '?from=' + init_data.from_id + '&to=' + init_data.to_id;
    $.get(root_http_addr + '/records' + param, function (result) {
        //console.log("messages: " + result);
        setChatRecord(result, init_data);
        modal.modal('show');
        // 删除“未读消息数目”小方框
        $(obj).find('span').html('');
    }, 'json');
};

var closeConnection = function () {
    if (ws.readyState != WebSocket.CLOSING && ws.readyState != WebSocket.CLOSED)
        ws.close();
};

/**
 * 加载聊天窗口中的好友信息
 * @param init_data
 * @param content 聊天窗口中缓存的内容
 */
var initChatModal = function (init_data, content) {
    // 设置 img 路径
    var img = modal.find('img');
    $(img).attr('src', init_data.to_img);
    // 设置 img 灰度
    if(init_data.to_status == -1)
        $(img).css({'-webkit-filter': 'grayscale(100%)'});
    else
        $(img).css({'-webkit-filter': 'grayscale(0%)'});
    var info = modal.find('div.pull-left.info');
    info.find('p').text(init_data.to_name);
    var statusResult = getPointClass(init_data.to_status);
    info.find('span').html('<i class="' + statusResult.icon + '"></i> ' + statusResult.describe);
    $(chat_content).data('to_id', init_data.to_id);
    // 如果上次输入的内容没有发送，则保存
    if (typeof(content) != 'undefined' && content.length > 0)
        chat_content.val(content);
};

/**
 * 为聊天窗口添加聊天记录
 * @param messages
 * @param init_data
 */
var setChatRecord = function (messages, init_data, append) {
    var chatMsg = '';
    for (var i = 0; i < messages.length; i++) {
        // 判断该 message 是‘我’对好友说的，还是好友对‘我’说的
        var isFriendSaid = init_data.from_id != messages[i].fromId;
        if (isFriendSaid) {
            //console.log(messages[i].fromName);
            chatMsg += '' +
                '<div class="direct-chat-msg">' +
                '<div class="direct-chat-info clearfix">' +
                '<span class="direct-chat-name pull-left">' + messages[i].fromName + '</span>' +
                '<span class="direct-chat-timestamp pull-right">' + messages[i].createTime + '</span>' +
                '</div>' +
                '<img class="direct-chat-img" src="' + init_data.to_img + '" alt="Message User Image"/>' +
                '<div class="direct-chat-text">' +
                messages[i].message +
                '</div>' +
                '</div>';
        }
        else {
            //console.log(messages[i].toName);
            chatMsg += '' +
                '<div class="direct-chat-msg right">' +
                '<div class="direct-chat-info clearfix">' +
                '<span class="direct-chat-name pull-right">' + messages[i].fromName + '</span>' +
                '<span class="direct-chat-timestamp pull-left">' + messages[i].createTime + '</span>' +
                '</div>' +
                '<img class="direct-chat-img" src="' + init_data.from_img + '" alt="Message User Image"/>' +
                '<div class="direct-chat-text">' +
                messages[i].message +
                '</div>' +
                '</div>';
        }
    }

    if(append == true)
        $(chat_messages_div).append(chatMsg);
    else
        $(chat_messages_div).html(chatMsg);
    $(chat_messages_div)[0].scrollTop = $(chat_messages_div)[0].scrollHeight;
};