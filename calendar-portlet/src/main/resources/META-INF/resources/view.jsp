<%@ page import="com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil" %>
<%@ page import="java.util.Locale" %>
<%@ page import="com.liferay.portal.kernel.util.LocaleUtil" %>
<%@ page import="com.liferay.portal.kernel.json.JSONObject" %>
<%@ page import="com.liferay.portal.kernel.json.JSONFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.json.JSONException" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/init.jsp" %>
<%
    String itemSelectorURL = (String) renderRequest.getAttribute("itemSelectorURL");
    String defaultEventImageUrl = (String) renderRequest.getAttribute("defaultEventImageUrl");
    renderRequest.setAttribute("showCalendar", showCalendar);
    renderRequest.setAttribute("showEventImage", showEventImage);
    renderRequest.setAttribute("mainCalendarPage", mainCalendarPage);
    renderRequest.setAttribute("maxEventsToShow", maxEventsToShow);
    renderRequest.setAttribute("vocabularityId", vocabularityId);
    renderRequest.setAttribute("defaultEventImageUrl", defaultEventImageUrl);
    renderRequest.setAttribute("showOnlyVocabularityId", showOnlyVocabularityId);
    renderRequest.setAttribute("selectedCategory", selectedCategory);
    if (mainCalendarPage != null && mainCalendarPage.equals("true")) {
        renderRequest.setAttribute("eventsPage", PortalUtil.getLayoutFriendlyURL(themeDisplay.getLayout(), themeDisplay));
    } else {
        renderRequest.setAttribute("eventsPage", eventsPage);
    }
    if(vocabularityId == null||vocabularityId == ""){
    	renderRequest.setAttribute("assetCategories", "");
    	vocabularityId = "";
    } else {
    	renderRequest.setAttribute("assetCategories", AssetCategoryLocalServiceUtil.getVocabularyCategories(Long.parseLong(vocabularityId), 0, AssetCategoryLocalServiceUtil.getAssetCategoriesCount(), null));
    }

    Locale defaultLocale = LocaleUtil.getDefault();
    String portletTitleVal;

    // trying to parse the json and getting value of active language
    try {
        JSONObject eventSuccessMsgObj  = JSONFactoryUtil.createJSONObject(portletTitle);
        portletTitleVal = eventSuccessMsgObj.getString(defaultLocale.getDisplayLanguage());
    } catch (JSONException je) {
        portletTitleVal = portletTitle;
    }

    int mdCol = 12;
    if("true".equalsIgnoreCase(mainCalendarPage) || "true".equalsIgnoreCase(showCalendar)) {
        if(!numberOfColumn.isEmpty()) {
            int columnsSettings = (Integer.parseInt(numberOfColumn)!=0)?Integer.parseInt(numberOfColumn) : 1;
            if(columnsSettings<=0 || columnsSettings>12) {
                columnsSettings = 1;
            }
            mdCol = 12 / columnsSettings;
        }
    }
%>

<portlet:renderURL var="addEventPopUpURL" copyCurrentRenderParameters="true">
    <portlet:param name="notificationEmail" value="<%= eventNotificationEmail %>"/>
    <portlet:param name="itemSelectorURL" value="<%= itemSelectorURL %>"/>
    <portlet:param name="vocabularityId" value="<%= vocabularityId %>"/>
    <portlet:param name="mvcRenderCommandName" value="/new-event" />
    <portlet:param name="mvcPath" value="/createEventPopUp.jsp"/>
</portlet:renderURL>

<c:choose>
    <c:when test="${'true' eq mainCalendarPage}">
        <div class="calendarContainer main-calendar-page">
            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12">
                    <div class="calendarHeaderContainer">
                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <h1 class="eventCalendarTitle "><%= portletTitleVal %></h1>
                            </div>
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="buttonContainer koristeBackground">
                                    <a id="createEventLink" href="<%=addEventPopUpURL %>"><liferay-ui:message key="create-event"/></a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <% if(mdCol==12) { %>
                <div class="col-md-<%= mdCol %> col-sm-12 col-xs-12 <%= vocabularityId.isEmpty()? "margin-bottom-15": "" %>">
                    <div id="demo" class="yui3-skin-sam yui3-g">
                        <div class="calendarInnerContainer">
                            <div id="eventCalendar"></div>
                        </div>

                    </div>

                    <c:if test="${not empty vocabularityId && 'false' eq showOnlyVocabularityId}">
                        <label class="selectCategory"><liferay-ui:message key="select-event-category"/></label>
                        <div class="assetCategorySelector">
                            <select id="assetCategorySelector">
                                <option selected="selected" value="null"><liferay-ui:message key="select-event-category-all"/></option>
                                <c:forEach var="ac" items="${assetCategories}">
                                    <option value="${ac.categoryId}">${ac.getTitle()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </c:if>
                </div>
                <% } %>
                <div class="col-md-<%= 12-mdCol %> col-sm-12 col-xs-12">
                    <div id="eventsList">
                        <div class="loading-animation"></div>
                    </div>
                    <div class="col-md-12 paginationBtnContainer">
                        <nav>
                            <ul>
                                <li class="buttonContainer koristeBackground hidden"><a class="nextEvent" href="#"><liferay-ui:message key="nextBtn"/></a></li>
                                <li class="buttonContainer koristeBackground hidden btn-margin-15"><a class="previousEvent" href="#"><liferay-ui:message key="previousBtn"/></a></li>
                            </ul>
                        </nav>
                    </div>
                </div>
                <% if(mdCol!=12) { %>
                <div class="col-md-<%= mdCol %> col-sm-12 col-xs-12">
                    <div id="demo" class="yui3-skin-sam yui3-g">
                        <div class="calendarInnerContainer">
                            <div id="eventCalendar"></div>
                        </div>

                    </div>

                    <c:if test="${not empty vocabularityId && 'false' eq showOnlyVocabularityId}">
                        <label class="selectCategory"><liferay-ui:message key="select-event-category"/></label>
                        <div class="assetCategorySelector">
                            <select id="assetCategorySelector">
                                <option selected="selected" value="null"><liferay-ui:message key="select-event-category-all"/></option>
                                <c:forEach var="ac" items="${assetCategories}">
                                    <option value="${ac.categoryId}">${ac.getTitle()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </c:if>
                </div>
                <% } %>

            </div>

        </div>

        <div class="clear"></div>
    </c:when>

    <c:otherwise>
        <div class="calendarContainer">
            <div class="calendarHeaderContainer <%= portletTitleVal.isEmpty()? "hidden": "" %>">
                <h2 class="eventCalendarTitle koristeViiva"> <%= portletTitleVal %></h2>
            </div>
            <div class="row">
                <% if(mdCol==12) { %>

                <div class="col-md-<%= mdCol %> col-sm-12 col-xs-12">
                    <div id="demo" class="yui3-skin-sam yui3-g">
                        <div class="calendarInnerContainer">
                            <div id="eventCalendar" class="<%= "true".equalsIgnoreCase(showCalendar)?"": "invisible" %>"></div>
                        </div>
                    </div>
                </div>

                <% } %>
                <div class="col-md-<%= 12-mdCol %> col-sm-12 col-xs-12">
                    <div id="eventsList" class="eventContainer">
                        <div class="loading-animation"></div>
                    </div>
                    <div class="col-md-12 paginationBtnContainer">
                        <nav>
                            <ul id="buttons">
                                <li class="buttonContainer koristeBackground hidden"><a class="nextEvent" href="#"><liferay-ui:message key="nextBtn"/></a></li>
                                <li class="buttonContainer koristeBackground hidden btn-margin-15"><a class="previousEvent" href="#"><liferay-ui:message key="previousBtn"/></a></li>
                            </ul>
                        </nav>
                    </div>
                </div>
                <% if(mdCol!=12) { %>
                <div class="col-md-<%= mdCol %> col-sm-12 col-xs-12 padding-left-0">
                    <div id="demo" class="yui3-skin-sam yui3-g">
                        <div class="calendarInnerContainer">
                            <div id="eventCalendar" class="<%= "true".equalsIgnoreCase(showCalendar)?"": "invisible" %>"></div>
                        </div>
                    </div>
                </div>
                <% } %>
            </div>


            <div class="allEventsContainer">
                <% if(eventsPage != null && mainCalendarPage.equals("false")){ %>
                	<a href="<%= eventsPage %>"><liferay-ui:message key="all-events"/></a>
                <% } %>
            </div>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>
    </c:otherwise>
</c:choose>

<script>
    init_events_view({
        'showCalendar':${'true' eq showCalendar ? 'true' : 'false'},
        'showEventImage':${'true' eq showEventImage ? 'true' : 'false'},
        'mainCalendarPage':${'true' eq mainCalendarPage ? 'true' : 'false'},
        'ns':'<portlet:namespace/>',
        'defaultImageUrl': '<%= defaultEventImageUrl %>',
        'numberOfColumn': '<%= numberOfColumn %>',
        'timestring':'<liferay-ui:message key="time"/>',
        'maxEventsToShow':'${maxEventsToShow}',
        'selectedCategory':'${selectedCategory}',
        'vocabularityId':'${vocabularityId}',
        'showOnlyVocabularityId':${'true' eq showOnlyVocabularityId ? 'true' : 'false'},
        'eventFriendlyUrl':'${eventsPage}/-/kalenteri/'});
</script>
