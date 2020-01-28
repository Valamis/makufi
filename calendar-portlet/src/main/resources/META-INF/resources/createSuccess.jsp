<%@ page import="java.util.Locale" %>
<%@ page import="com.liferay.portal.kernel.util.*" %>
<%@ page import="com.liferay.portal.kernel.json.JSONObject" %>
<%@ page import="com.liferay.portal.kernel.json.JSONFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.json.JSONException" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="init.jsp" %>
<%
    renderRequest.setAttribute("reviewRequired", reviewRequired);
    renderRequest.setAttribute("isUserLoggedIn", isLoggedInuser);
    Locale defaultLocale = LocaleUtil.getDefault();
    String eventSuccessMsgVal, eventPublishMsgVal;

    // trying to parse the json and getting value of active language
    try {
        JSONObject eventSuccessMsgObj  = JSONFactoryUtil.createJSONObject(eventSuccessMsg);
        eventSuccessMsgVal = eventSuccessMsgObj.getString(defaultLocale.getDisplayLanguage());
    } catch (JSONException je) {
        eventSuccessMsgVal = eventSuccessMsg;
    }

    try {
        JSONObject eventPublishMsgObj  = JSONFactoryUtil.createJSONObject(eventPublishMsg);
        eventPublishMsgVal = eventPublishMsgObj.getString(defaultLocale.getDisplayLanguage());
    } catch (JSONException je) {
        eventPublishMsgVal = eventPublishMsg;
    }


%>
<div id="create-event-success-container">
    <h1><liferay-ui:message key="create-event-success" /></h1>
    <c:choose>
        <c:when test="${not empty reviewRequired && 'true' eq reviewRequired && 'false' eq isUserLoggedIn}">
            <%
                if(!"".equals(eventSuccessMsgVal)) {

            %>
            <div class="alert alert-info"><strong> <%=eventSuccessMsgVal%> </strong></div>
            <%
                } else {

            %>

            <div class="alert alert-info"><strong><liferay-ui:message key="create-event-success-info" /></strong></div>

            <%}%>
        </c:when>
        <c:otherwise>
            <%
                if(!"".equals(eventPublishMsgVal)) {

            %>
            <div class="alert alert-info"> <strong><%=eventPublishMsgVal%></strong></div>
            <%
            } else {

            %>

            <div class="alert alert-info"><strong><liferay-ui:message key="create-event-publish-msg" /></strong></div>

            <%}%>
        </c:otherwise>
    </c:choose>


    <%-- event-created-requires-approval --%>
</div>