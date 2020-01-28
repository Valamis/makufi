<%@ page import="java.util.Locale" %>
<%@ page import="com.liferay.portal.kernel.util.*" %>
<%@ page import="com.liferay.portal.kernel.json.JSONObject" %>
<%@ page import="com.liferay.portal.kernel.json.JSONFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.json.JSONException" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="init.jsp" %>
<%
    renderRequest.setAttribute("isUserLoggedIn", isLoggedInuser);
    Locale defaultLocale = LocaleUtil.getDefault();
    String eventUnderReviewMsgVal;
    // trying to parse the json and getting value of active language
    try {
        JSONObject eventUnderReviewMsgObj  = JSONFactoryUtil.createJSONObject(eventUnderReviewMsg);
        eventUnderReviewMsgVal = eventUnderReviewMsgObj.getString(defaultLocale.getDisplayLanguage());
    } catch (JSONException je) {
        eventUnderReviewMsgVal = eventUnderReviewMsg;
    }
%>
<div id="create-event-success-container">
    <h1><liferay-ui:message key="event-success"/></h1>
    <c:choose>
        <c:when test="${'false' eq isUserLoggedIn}">
            <%
                if(!"".equals(eventUnderReviewMsgVal)) {

            %>
            <div class="alert alert-info"><strong> <%=eventUnderReviewMsgVal%> </strong></div>
            <%
            } else {

            %>

            <div class="alert alert-info"><strong><liferay-ui:message key="event-success-requires-approval" /></strong></div>

            <%}%>
        </c:when>
        <c:otherwise>
            <div class="alert alert-info"><strong><liferay-ui:message key="event-update-success" /></strong></div>
        </c:otherwise>
    </c:choose>
</div>