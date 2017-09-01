<%@ include file="/init.jsp" %>
<c:choose>
	
	<c:when test="${tipDayPortletMode != 'renderArticle'}">
		<portlet:renderURL var="contentURL" windowState="<%=LiferayWindowState.EXCLUSIVE.toString() %>">
			<portlet:param name="tipDayPortletMode" value="renderArticle"/>
		</portlet:renderURL>
		<!-- set object only if it is not in article render mode  -->
		<script>
			window.TIPDAY = window.TIPDAY || {};
			window.TIPDAY = {
				portletNamespace: '<portlet:namespace/>',
				contentURL: '<%=contentURL %>'
			};
		</script>
	</c:when>

	<c:otherwise>
		<c:choose>
			<c:when test="${not empty article}">
				<liferay-ui:asset-display className="<%= JournalArticle.class.getName() %>" classPK="31431"></liferay-ui:asset-display>
				<!-- template = resource prim key -->
			</c:when>
			<c:otherwise>
				<div class="portlet-msg-info">
					<liferay-ui:message key="no-tips-to-display"/>
				</div>
			</c:otherwise>
		</c:choose>
	</c:otherwise>

</c:choose>





<liferay-ui:asset-display className="<%= JournalArticle.class.getName() %>" classPK="31431"></liferay-ui:asset-display>