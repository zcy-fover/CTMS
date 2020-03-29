<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" id="message-modal" aria-labelledby="mySmallModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content" style="border-radius: 6px; width: 300px;">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="mySmallModalLabel">系统提示</h4>
            </div>
            <div class="modal-body" id="modal-body-id">
                <h4 id="message" style="text-align: center">${result.message}</h4>
            </div>
        </div>
    </div>
</div>

<%--控制函数--%>
<script>
    $(function () {
        var message = $('#message').text();
        if (message != '') {
            $('#message-modal').modal('show');
        }
    });
</script>