<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@include file="../common/common.jsp"%>

	<ul class="pagination">
		<c:if test="${page.pages != '0'}">
			<li><a>共${page.pages}页</a></li>
		</c:if>

		<c:if test="${page.hasPreviousPage }">
			<li>
				<a href="javascript:toPage('${page.prePage}')" aria-label="Previous">
					<span aria-hidden="true">&lt;&lt;上一页</span>
				</a>
			</li>
		</c:if>

		<c:forEach items="${page.navigatepageNums}" var="nav">
			<c:if test="${nav == page.pageNum}">
				<li><a href="javascript:toPage('${nav}')">${nav}</a></li>
			</c:if>
			<c:if test="${nav != page.pageNum}">
				<li><a href="javascript:toPage('${nav}')">${nav}</a></li>
			</c:if>
		</c:forEach>

		<c:if test="${page.hasNextPage}">
			<li>
				<a href="javascript:toPage('${page.nextPage}')" aria-label="Next">
					<span aria-hidden="true">下一页>>
					</span>
				</a>
			</li>
		</c:if>
	</ul>
		<%--<div>--%>
			<%--<span>转到</span>--%>
			<%--<input type="text" id="toPageNum" style="width:50px">                                            --%>
			<%--<span>页</span>--%>
			<%--<button class="btn btn-primary" onClick="goToPage()">确定</button>--%>
		<%--</div>--%>
	<script>
		function toPage(pageNum){
			$('#pageNum').val(pageNum);
			$('#pageSize').val(8);
			$('#query-form').submit();
		}
	</script>