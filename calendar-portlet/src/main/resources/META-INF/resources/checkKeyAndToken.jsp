<%@ page import="java.util.Locale" %>
<%@ page import="com.liferay.portal.kernel.util.*" %>
<%@ page import="com.liferay.portal.kernel.json.JSONObject" %>
<%@ page import="com.liferay.portal.kernel.json.JSONFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.json.JSONException" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="init.jsp" %>
<%
    String eventUrlTitle = request.getParameter("eventUrlTitle");
    String eventId = request.getParameter("eventId");
    Event e = null;
    if (eventUrlTitle != null) {
        if (!request.getParameter("eventUrlTitle").matches("-?\\d+?")) {
            e = EventLocalServiceUtil.findEventByFriendlyName(eventUrlTitle);
        } else {
            e = EventLocalServiceUtil.getEvent(Long.parseLong(eventUrlTitle));
        }
        eventId = Long.toString(e.getEventId());
    } else {
        e = EventLocalServiceUtil.getEvent(Long.parseLong(eventId));
    }

    Locale defaultLocale = LocaleUtil.getDefault();
    String eventAwaitingApprovalMsgVal;
    // trying to parse the json and getting value of active language
    try {
        JSONObject eventAwaitingApprovalMsgObj  = JSONFactoryUtil.createJSONObject(eventAwaitingApprovalMsg);
        eventAwaitingApprovalMsgVal = eventAwaitingApprovalMsgObj.getString(defaultLocale.getDisplayLanguage());
    } catch (JSONException je) {
        eventAwaitingApprovalMsgVal = eventAwaitingApprovalMsg;
    }

%>
<portlet:actionURL name="checkKeyAndToken" var="checkKeyAndTokenURL">
    <portlet:param name="eventId" value="<%= eventId %>"/>
</portlet:actionURL>

<div class="checkKeyAndTokenContainer">
<liferay-ui:error key="wrong-password-or-token" message="wrong-password-or-token"></liferay-ui:error>
<% if (e != null && e.getStatus().equals("Saved")) { %>
    <h2 class="createEventHeader"><liferay-ui:message key="event-in-review-title"/></h2>
    <%
        if(!"".equals(eventAwaitingApprovalMsgVal)) {

    %>
    <div class="alert alert-info"><strong> <%=eventAwaitingApprovalMsgVal%> </strong></div>
    <%
    } else {

    %>

    <div class="alert alert-info"><strong><liferay-ui:message key="event-in-review-info" /></strong></div>

    <%}%>
<%-- <p class="createEventInfoText"><liferay-ui:message key="event-in-review-info"/></p>--%>
<% } else { %>
 <h2 class="createEventHeader"><liferay-ui:message key="event-password-check-title"/></h2>
 <p class="createEventInfoText"><liferay-ui:message key="event-password-check-info"/></p>
 <aui:form action="<%= checkKeyAndTokenURL %>" method="post" name="fm">
     <aui:input label="event-password" name="password" type="password">
         <aui:validator name="required"/>
     </aui:input>
     <aui:input label="event-token" name="token" type="password">
         <aui:validator name="required"/>
     </aui:input>
     <aui:button-row>
         <aui:button cssClass="sendButton koristeBackground koristeViiva" type="submit" value="submit"/>
     </aui:button-row>
 </aui:form>
<% } %>
</div>