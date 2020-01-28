<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ include file="/init.jsp" %>
<%
    String itemSelectorURL = (String) renderRequest.getAttribute("itemSelectorURL");
    String tab = (String) ParamUtil.getString(renderRequest, "tab", "1");
    String searchKey = "";
    if (tab.equals("2")) {
        searchKey = CalendarPortletKeys.event_approved;
    } else if (tab.equals("3")) {
        searchKey = CalendarPortletKeys.event_returned;
    } else {
        searchKey = CalendarPortletKeys.event_saved;
    }
%>
<div class="navbar navbar-default collapse-basic-search" id="kiti">
    <div class="container-fluid-1280">
        <div class="navbar-header visible-xs">
        <button class="collapsed navbar-toggle navbar-toggle-left navbar-toggle-page-name" data-target="#_com_liferay_plugins_admin_web_portlet_PluginsAdminPortlet_navTagNavbarCollapse" data-toggle="collapse" id="_com_liferay_plugins_admin_web_portlet_PluginsAdminPortlet_NavbarBtn" type="button">
        <span class="sr-only">Vaihda siirtymistä</span>
        <span class="page-name"><liferay-ui:message key="events-admin"/></span>
        <span class="caret"></span>
        </button>
        </div>
        <div class="collapse navbar-collapse" id="_com_liferay_plugins_admin_web_portlet_PluginsAdminPortlet_navTagNavbarCollapse">
            <aui:nav cssClass="navbar-nav" aria-label="Tapahtumat">
                <portlet:renderURL var="tabURL1"><portlet:param name="tab" value="1"/></portlet:renderURL>
                <aui:nav-item selected="<%= tab.equals("1") ? true : false %>" href="<%= tabURL1 %>" role="menuitem" title="saved-events" label="saved-events"/>
                <portlet:renderURL var="tabURL2"><portlet:param name="tab" value="2"/></portlet:renderURL>
                <aui:nav-item selected="<%= tab.equals("2") ? true : false %>" href="<%= tabURL2 %>" role="menuitem" title="accepted-events" label="accepted-events"/>
                <portlet:renderURL var="tabURL3"><portlet:param name="tab" value="3"/></portlet:renderURL>
                <aui:nav-item selected="<%= tab.equals("3") ? true : false %>" href="<%= tabURL3 %>" role="menuitem" title="returned-events" label="returned-events"/>            
            </aui:nav>
        </div>
    </div>
</div>
<aui:container cssClass="container-fluid-1280 card main-content-card">
    <liferay-ui:search-container cssClass="table table-striped table-condensed" emptyResultsMessage="no-events" compactEmptyResultsMessage="true">
        <liferay-ui:search-container-results results="<%= EventLocalServiceUtil.getEventsByCompanyIdAndStatus(themeDisplay.getCompanyId(), searchKey, 0, 5000) %>" />
        <liferay-ui:search-container-row cssClass="table-row" className="fi.valamis.maakportal2.calendar.event.model.Event" modelVar="ev" keyProperty="eventId">

            <portlet:renderURL var="viewEventURL" windowState="<%= LiferayWindowState.MAXIMIZED.toString() %>">
                <portlet:param name="redirect" value="<%=themeDisplay.getURLCurrent()%>"/>
                <portlet:param name="itemSelectorURL" value="<%= itemSelectorURL %>"/>
                <portlet:param name="eventId" value="<%= ""+ev.getEventId() %>"/>
                <portlet:param name="mvcPath" value="/viewEvent.jsp"/>
            </portlet:renderURL>

            <%
                String fromTo = "";
                Date d1 = ev.getStartingDate();
                Date d2 = ev.getEndingDate();
                if ((d1.getYear() + 1900) == (d2.getYear() + 1900)) {
                    fromTo = "." + (d1.getYear() + 1900);
                    final String d1Month = String.format("%02d", d1.getMonth() + 1);
                    final String d2Month = String.format("%02d", d2.getMonth() + 1);
                    if (d1Month.equals(d2Month)) {
                        fromTo = "." + String.format("%02d", d1.getMonth() + 1) + fromTo;
                        final String d1Str = String.format("%02d", d1.getDate());
                        final String d2Str = String.format("%02d", d2.getDate());
                        if (d1Str.equals(d2Str)) {
                            fromTo = String.format("%02d", d1.getDate()) + fromTo;
                            fromTo = fromTo + " " + String.format("%02d", d1.getHours()) + ":" + String.format("%02d", d1.getMinutes()) + " - " + String.format("%02d", d2.getHours()) + ":" + String.format("%02d", d2.getMinutes());
                        } else {
                            fromTo = String.format("%02d", d1.getDate()) + " - " + String.format("%02d", d2.getDate()) + fromTo;
                        }
                    } else {
                        fromTo = String.format("%02d", d1.getDate()) + "." + String.format("%02d", d1.getMonth() + 1) + "." + (d1.getYear() + 1900) + " " + String.format("%02d", d1.getHours()) + ":" + String.format("%02d", d1.getMinutes()) + " - " + String.format("%02d", d2.getDate()) + "." + String.format("%02d", d2.getMonth() + 1) + "." + (d2.getYear() + 1900) + " " + String.format("%02d", d2.getHours()) + ":" + String.format("%02d", d2.getMinutes());
                    }
                } else {
                    fromTo = String.format("%02d", d1.getDate()) + "." + String.format("%02d", d1.getMonth() + 1) + "." + (d1.getYear() + 1900) + " " + String.format("%02d", d1.getHours()) + ":" + String.format("%02d", d1.getMinutes()) + " - " + String.format("%02d", d2.getDate()) + "." + String.format("%02d", d2.getMonth() + 1) + "." + (d2.getYear() + 1900) + " " + String.format("%02d", d2.getHours()) + ":" + String.format("%02d", d2.getMinutes());
                }

                int recurrance = 0;
                if (ev.getAdditionalStartingDates() != "") {
                    String[] adt = ev.getAdditionalStartingDates().split(",");
                    recurrance = adt.length;
                }
            %>

            <liferay-ui:search-container-column-text property="eventName" href="<%= viewEventURL %>"/>
            <liferay-ui:search-container-column-date property="modifiedDate" name="modified"></liferay-ui:search-container-column-date>
            <liferay-ui:search-container-column-text name="event-time" title="event-date" ><%= fromTo %></liferay-ui:search-container-column-text>
            <liferay-ui:search-container-column-text name="event-recurrance" title="event-recurrance" ><%= recurrance %></liferay-ui:search-container-column-text>

        </liferay-ui:search-container-row>
        <liferay-ui:search-iterator searchContainer="<%=searchContainer%>" />
        <liferay-ui:search-paginator searchContainer="<%=searchContainer%>" />
    </liferay-ui:search-container>

    <portlet:renderURL var="addEventPopUpURL" windowState="<%= LiferayWindowState.MAXIMIZED.toString() %>">
        <portlet:param name="itemSelectorURL" value="<%= itemSelectorURL %>"/>
        <portlet:param name="vocabularityId" value="<%= vocabularityId %>"/>
        <portlet:param name="mvcPath" value="/createEventPopUp.jsp"/>
    </portlet:renderURL>
    </a>
    <!--
    <%-- New event button if we need it --%>
    <a id="createEventLink" href="<%=addEventPopUpURL %>" class="btn btn-action btn-bottom-right btn-primary">
    <span id="jrxp__null__null">
        <svg class="lexicon-icon lexicon-icon-plus" focusable="false" role="img" title="" viewBox="0 0 512 512">
        <title>plus</title>
        <path class="lexicon-icon-outline" d="M479.82 224.002h-192.41v-191.91c0-17.6-14.4-32-32-32v0c-17.6 0-32 14.4-32 32v191.91h-191.41c-17.6 0-32 14.4-32 32v0c0 17.6 14.4 32 32 32h191.41v191.91c0 17.6 14.4 32 32 32v0c17.6 0 32-14.4 32-32v-191.909h192.41c17.6 0 32-14.4 32-32v0c0-17.6-14.4-32-32-32z"></path>
    </svg></span>
    </a>
    -->
</aui:container>