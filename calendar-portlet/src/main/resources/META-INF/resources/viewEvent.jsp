<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/init.jsp" %>
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

    String itemSelectorURL = (String) request.getParameter("itemSelectorURL");

    if (isAdmin) { 
        String redirect = ParamUtil.getString(request, "redirect" ,"");
        portletDisplay.setShowBackIcon(true);
        portletDisplay.setURLBack(redirect);
%>
<div class="container-fluid adminCommentContainer">
    <div class="container-fluid card-horizontal main-content-card">
<%}%>
<% if (e == null) { %>
<div class="calendarContainer eventContainer"><liferay-ui:message key="event-not-found"/></div>
<% } else { %> 
<div class="calendarContainer eventContainer">

    <liferay-util:html-top outputKey="shareimage">
        <!-- some image from asset dynamic list content -->
        <meta property="og:title" content="<%= e.getEventName() %>" />
        <meta property="og:description" content="<%= e.getDescription() %>" />
        <meta name="twitter:title" content="<%= e.getEventName() %>" />
        <meta name="twitter:description" content="<%= e.getDescription() %>" />
        <c:if test="<%= e.getImageUrl() != "" %>">
            <meta property="og:image" content="<%= e.getImageUrl() %>"/>
            <meta name="twitter:image" content="<%= e.getImageUrl() %>"/>
        </c:if>
    </liferay-util:html-top>

    <% if (!isAdmin) { %>
    <div class="eventBackToAllEvents"><a href="<%= PortalUtil.getLayoutFriendlyURL(themeDisplay.getLayout(), themeDisplay) %>"><liferay-ui:message key="all-events"/></a></div>
    <% } %>
    <h1 class="eventTitle"><%= e.getEventName() %>
    </h1>
    <div>

    <%
        String fromTo = "";
        Date d1 = e.getStartingDate();
        Date d2 = e.getEndingDate();
        if ((d1.getYear() + 1900) == (d2.getYear() + 1900)) {
            fromTo = "." + (d1.getYear() + 1900);
            if (String.format("%02d", d1.getMonth() + 1).equals(String.format("%02d", d2.getMonth() + 1))) {
                fromTo = "." + String.format("%02d", d1.getMonth() + 1) + fromTo;
                if (String.format("%02d", d1.getDate()).equals(String.format("%02d", d2.getDate()))) {
                    fromTo = String.format("%02d", d1.getDate()) + fromTo;
                    fromTo = fromTo + " " + String.format("%02d", d1.getHours()) + "." + String.format("%02d", d1.getMinutes()) + " - " + String.format("%02d", d2.getHours()) + "." + String.format("%02d", d2.getMinutes());
                } else {
                    fromTo = String.format("%02d", d1.getDate()) + " - " + String.format("%02d", d2.getDate()) + fromTo + " " + String.format("%02d", d1.getHours()) + "." + String.format("%02d", d1.getMinutes()) + " - " + String.format("%02d", d2.getHours()) + "." + String.format("%02d", d2.getMinutes());
                }
            } else {
                fromTo = String.format("%02d", d1.getDate()) + "." + String.format("%02d", d1.getMonth() + 1) + "." + (d1.getYear() + 1900) + " " + String.format("%02d", d1.getHours()) + "." + String.format("%02d", d1.getMinutes()) + " - " + String.format("%02d", d2.getDate()) + "." + String.format("%02d", d2.getMonth() + 1) + "." + (d2.getYear() + 1900) + " " + String.format("%02d", d2.getHours()) + "." + String.format("%02d", d2.getMinutes());
            }
        } else {
            fromTo = String.format("%02d", d1.getDate()) + "." + String.format("%02d", d1.getMonth() + 1) + "." + (d1.getYear() + 1900) + " " + String.format("%02d", d1.getHours()) + "." + String.format("%02d", d1.getMinutes()) + " - " + String.format("%02d", d2.getDate()) + "." + String.format("%02d", d2.getMonth() + 1) + "." + (d2.getYear() + 1900) + " " + String.format("%02d", d2.getHours()) + "." + String.format("%02d", d2.getMinutes());
        }
    %>
    <span class="eventDate"><%= fromTo %></span><span class="spacer"> - </span><span class="eventLocation"><%= e.getLocation() %></span>
    </div>
    <% if (e.getImageUrl() != null && e.getImageUrl() != "") { %>
	    <div class="eventImageContainer">
	        <img src="<%= e.getImageUrl() %>" alt="<liferay-ui:message key='event-image'/>">
	    </div>
    <%} %>
    <p><%= e.getDescription() %></p>
    <div class="eventDates">
        <label><liferay-ui:message key="event-time"/></label>
        <span class="startingDate"><%= fromTo %></span>
        <span class="recurranceLabel">
            <% if (e != null && !e.getAdditionalStartingDates().isEmpty()) { 
                String[] times = e.getAdditionalStartingDates().split(",");
                %>
                <liferay-ui:message key="event-repeats-times" arguments="<%= times.length %>"/>
            <% } %>
        </span>
        <% if (e.getTimesAdditionalInfo() != null && !e.getTimesAdditionalInfo().isEmpty()) { %>
        <p>
            <%= e.getTimesAdditionalInfo() %>
        </p>
        <% } %>
    </div>
    <% if (e.getLocation() != null && !e.getLocation().trim().isEmpty()) { %>
    <div class="locationContainer">
        <label><liferay-ui:message key="event-location"/></label>
        <span><%= e.getLocation() %></span>
    </div>
    <% } %>
    <% if (e.getAddress() != null && !e.getAddress().trim().isEmpty()) { %>
    <div class="eventAddressContainer">
        <label><liferay-ui:message key="event-address"/></label>
        <span><%= e.getAddress() %></span>
    </div>
    <div id="eventMapContainer" style="display: <%= (e != null && e.getShowMap()) ? "" : "none" %>;">
        <% 
        String mapurl = "";
        if (e != null && e.getShowMap()) {
            mapurl = "https://www.google.com/maps/embed/v1/place?q=" + URLEncoder.encode(e.getAddress(), "UTF-8").replace("+","%20") + "&key=AIzaSyDHcFbnjUftOXsR5YL1VPEksE1DDVviBE8";
        } 
        %>
        <iframe 
        id="eventMapIframe"
        width="100%" 
        height="220" 
        frameborder="0" 
        style="border:0"
        src="<%= mapurl %>" 
        allowfullscreen></iframe>
    </div>
    <% } %>
    <% if (e.getLinkToEventWebPage() != null && !e.getLinkToEventWebPage().trim().isEmpty()) { %>
    <div class="eventWebsiteContainer">
        <label><liferay-ui:message key="event-website"/></label>
        <span><a href="<%= e.getLinkToEventWebPage() %>" target="_blank"><%= e.getLinkToEventWebPage() %></a></span>
    </div>
    <% } %>
    <% if (e.getSignUpLink() != null && !e.getSignUpLink().trim().isEmpty()) { %>
    <div class="eventSignUpLinkContainer">
        <label><liferay-ui:message key="event-signup-link"/></label>
        <span><a href="<%= e.getSignUpLink() %>" target="_blank"><%= e.getSignUpLink() %></a></span>
    </div>
    <% } %>
    <% if (e.getCategoryIds() != null && !e.getCategoryIds().trim().isEmpty()) { %>
    <div class="categoryContainer">
        <label><liferay-ui:message key="event-category"/></label><br>
        <% String[] catIds = e.getCategoryIds().split(",");
        if (catIds != null && catIds.length > 0 && !catIds[0].equals("false")) {
            String name = "";
            for (int i = 0; i < catIds.length; i++) { 
                try {
                    name = AssetCategoryLocalServiceUtil.getAssetCategory(Long.parseLong(catIds[i])).getName();
                    if (!name.equals("")) {
                        %><span class="category"><%= name %></span> <% 
                    } 
                } catch (Exception e1) {
                    //DO NOTHING
                } 
            }
        } %>
    </div>
    <% } %>
    <div class="authorContainer">
        <label><liferay-ui:message key="event-author"/></label><br>
        <p><span><%= e.getEventAuthorName() %></span></p>
    </div>
    <% if (e.getAdditionalInformation() != null && !e.getAdditionalInformation().trim().isEmpty()) { %>
    <div class="eventAdditionalInformation">
        <label><liferay-ui:message key="event-additionalInformation"/></label>
        <p>
            <%= e.getAdditionalInformation() %>
        </p>
    </div>
    <% } %>
    <% if (isAdmin) { %>
    <div class="eventAdminAuthorContainer">
        <span class="adminlabel"><liferay-ui:message key="only-admin-can-see"/></span>
        <label><liferay-ui:message key="event-author"/>:</label> <%= e.getEventAuthorName() %><br/>
        <label><liferay-ui:message key="email"/>:</label> <a href="mailto:<%= e.getEventAuthorEmail() %>"><%= e.getEventAuthorEmail() %></a><br/>
        <label><liferay-ui:message key="phone"/>:</label> <%= e.getEventAuthorPhoneNumber() %><br/>
        <a onclick="document.getElementById('userkeypass').style.display = 'block';" style="cursor:pointer;"><liferay-ui:message key="show-event-access-codes"/></a><br/>
        <span id="userkeypass" style="display: none;cursor: pointer;">
            <label><liferay-ui:message key="password"/>:</label> <%= e.getUserGivenPassword() %><br/>
            <label><liferay-ui:message key="event-access-code"/>:</label> <%= e.getAuthorizationToken() %><br/>
            <label><liferay-ui:message key="event-update-url"/>:</label> <a href="<%= e.getUpdateUrl() %>" target="_blank"><%= e.getUpdateUrl() %></a><br/>
        </span>
    </div>
    <% } %>
</div>
<% } %>

<% if (e != null && isAdmin) { %>
<portlet:actionURL name="removeEvent" var="removeEventURL">
    <portlet:param name="eventId" value="<%= ""+e.getEventId() %>"/>
</portlet:actionURL>
<portlet:actionURL name="approveEvent" var="approveEventURL">
    <portlet:param name="eventId" value="<%= ""+e.getEventId() %>"/>
</portlet:actionURL>
<portlet:actionURL name="cancelEvent" var="cancelEventURL">
    <portlet:param name="eventId" value="<%= ""+e.getEventId() %>"/>
</portlet:actionURL>
<portlet:actionURL name="askMoreDetailsEvent" var="askMoreDetailsEventURL">
    <portlet:param name="eventId" value="<%= ""+e.getEventId() %>"/>
</portlet:actionURL>
<portlet:renderURL var="editEventURL">
    <portlet:param name="itemSelectorURL" value="<%= itemSelectorURL %>"/>
    <portlet:param name="eventId" value="<%= ""+e.getEventId() %>"/>
    <portlet:param name="mvcPath" value="/createEventPopUp.jsp"/>
</portlet:renderURL>

    </div><!-- container-fluid card-horizontal main-content-card -->

<% if (e != null && e.getStatus().equals("Saved")) { %>
<aui:container cssClass="card-horizontal main-content-card">
    <h2><liferay-ui:message key="event-admin-comment"/></h2>
    <p>
    <aui:form action="<%= askMoreDetailsEventURL %>" method="post" name="fm">
        <aui:input label="event-admin-comment" name="adminComment" type="textarea" resizable="true" value="<%= e.getAdminComment() %>">
            <aui:validator name="required"/>
        </aui:input>
        <aui:button type="submit" value="request-more-details-event" key="request-more-details-event"/>
    </aui:form>
    </p>
</aui:container>
<% }%>

</div><!-- container-fluid adminCommentContainer -->
<aui:container cssClass="adminCommentContainer">
    <aui:button-row>
        <% if (e != null && !e.getStatus().equals("Approved")) { %>
        <aui:button href="<%= approveEventURL %>" primary="true" value="approve-event" key="approve-event"/>
        <% }%>
        <aui:button href="<%= editEventURL %>" primary="true" value="edit-approve-event" key="edit-approve-event"/>
        <aui:button href="<%= removeEventURL %>" value="remove-event" key="remove-event"/>
        
        <%--<aui:button href="<%= cancelEventURL.toString() %>" value="cancel-event" key="cancel-event"/>--%>
    </aui:button-row>
</aui:container>

<% }%>
