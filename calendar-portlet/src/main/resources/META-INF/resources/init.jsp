<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/captcha" prefix="liferay-captcha" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="com.liferay.portal.kernel.captcha.CaptchaUtil" %>
<%@ page import="com.liferay.portal.kernel.captcha.CaptchaTextException" %>
<%@ page import="com.liferay.portal.kernel.captcha.CaptchaMaxChallengesException" %>
<%@ page import="fi.valamis.maakportal2.calendar.event.model.Event" %>
<%@ page import="fi.valamis.maakportal2.calendar.event.service.EventLocalServiceUtil" %>
<%@ page import="fi.valamis.maakportal2.calendar.constants.CalendarPortletKeys" %>
<%@ page import="com.liferay.portal.kernel.security.permission.PermissionChecker" %>
<%@ page import="com.liferay.portal.kernel.security.permission.PermissionThreadLocal" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil" %>
<%@ page import="fi.valamis.maakportal2.calendar.configuration.CalendarConfiguration" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil" %>
<%@ page import="com.liferay.asset.kernel.model.AssetCategory" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="java.net.URI" %>
<%@ page import="java.net.URISyntaxException" %>
<%@ page import="java.net.URL" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="org.apache.commons.lang3.exception.ContextedRuntimeException" %>
<%@ page import="com.liferay.portal.kernel.service.PortletPreferencesLocalServiceUtil" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="javax.portlet.PortletPreferences" %>
<%@ page import="org.apache.commons.lang3.StringUtils" %>
<%@ page import="com.liferay.portal.kernel.model.Company" %>
<%@ page import="com.liferay.portal.kernel.service.CompanyLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.model.Layout" %>
<%@ page import="com.liferay.portal.kernel.service.LayoutLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.service.PortletPreferencesLocalService" %>
<liferay-theme:defineObjects/>

<portlet:defineObjects/>

<%
    CalendarConfiguration calendarConfiguration = portletDisplay.getPortletInstanceConfiguration(CalendarConfiguration.class);
    
    if(portletPreferences == null) {
        throw new IllegalStateException("Cannot find calendar preferencies.");
    }

    String showCalendar = StringPool.BLANK;

    if (Validator.isNotNull(calendarConfiguration)) {
        showCalendar =
                portletPreferences.getValue(
                        "showCalendar", calendarConfiguration.showCalendar());
    }

    String showEventImage = StringPool.BLANK;
    if (Validator.isNotNull(calendarConfiguration)) {
        showEventImage =
                portletPreferences.getValue(
                        "showEventImage", calendarConfiguration.showEventImage());
    }

    String mainCalendarPage = StringPool.BLANK;

    if (Validator.isNotNull(calendarConfiguration)) {
        mainCalendarPage =
                portletPreferences.getValue(
                        "mainCalendarPage", calendarConfiguration.mainCalendarPage());
    }

    String eventNotificationEmail = StringPool.BLANK;

    if (Validator.isNotNull(calendarConfiguration)) {
        eventNotificationEmail =
                portletPreferences.getValue(
                        "eventNotificationEmail", calendarConfiguration.eventNotificationEmail());
    }

    String vocabularityId = StringPool.BLANK;

    if (Validator.isNotNull(calendarConfiguration)) {
        vocabularityId =
                portletPreferences.getValue(
                        "vocabularityId", calendarConfiguration.vocabularityId());
    }

    String selectedCategory = StringPool.BLANK;

    if (Validator.isNotNull(calendarConfiguration)) {
        selectedCategory =
                portletPreferences.getValue(
                        "selectedCategory", calendarConfiguration.selectedCategory());
    }

    String showOnlyVocabularityId = StringPool.BLANK;

    if (Validator.isNotNull(calendarConfiguration)) {
        showOnlyVocabularityId =
                portletPreferences.getValue(
                        "showOnlyVocabularityId", calendarConfiguration.showOnlyVocabularityId());
    }

    String showOtherInstances = StringPool.BLANK;

    if (Validator.isNotNull(calendarConfiguration)) {
        showOtherInstances =
                portletPreferences.getValue(
                        "showOtherInstances", calendarConfiguration.showOtherInstances());
    }

    String eventsPage = StringPool.BLANK;

    if (Validator.isNotNull(calendarConfiguration)) {
        eventsPage =
                portletPreferences.getValue(
                        "eventsPage", calendarConfiguration.eventsPage());
    }

    String reviewRequired = StringPool.BLANK;
    if (Validator.isNotNull(calendarConfiguration)) {
        reviewRequired =
                portletPreferences.getValue(
                        "reviewRequired", calendarConfiguration.reviewRequired());
    }

    String formDescription = StringPool.BLANK;
    if (Validator.isNotNull(calendarConfiguration)) {
        formDescription =
                portletPreferences.getValue(
                        "formDescription", calendarConfiguration.formDescription());
    }
    
    List<Company> companiesToShow = new ArrayList<Company>();
    if (Validator.isNotNull(calendarConfiguration)) {
        String[] instancesToShow = portletPreferences.getValues("instancesToShow", calendarConfiguration.instancesToShow());
        for(Company c : CompanyLocalServiceUtil.getCompanies(false)){ 
            for(String s: instancesToShow) {
                if(s.equals(c.getWebId()) || s.equals(Long.toString(c.getCompanyId())) || s.equals(c.getVirtualHostname())) {
                    companiesToShow.add(c);
                }
            }
        }
    }

    String eventSuccessMsg = StringPool.BLANK;

    if (Validator.isNotNull(calendarConfiguration)) {
        eventSuccessMsg =
                portletPreferences.getValue(
                        "eventSuccessMsg", calendarConfiguration.eventSuccessMsg());
    }

    String eventPublishMsg = StringPool.BLANK;

    if (Validator.isNotNull(calendarConfiguration)) {
        eventPublishMsg =
                portletPreferences.getValue(
                        "eventPublishMsg", calendarConfiguration.eventPublishMsg());
    }

    String eventAwaitingApprovalMsg = StringPool.BLANK;

    if (Validator.isNotNull(calendarConfiguration)) {
        eventAwaitingApprovalMsg =
                portletPreferences.getValue(
                        "eventAwaitingApprovalMsg", calendarConfiguration.eventAwaitingApprovalMsg());
    }

    String eventUnderReviewMsg = StringPool.BLANK;

    if (Validator.isNotNull(calendarConfiguration)) {
        eventUnderReviewMsg =
                portletPreferences.getValue(
                        "eventUnderReviewMsg", calendarConfiguration.eventUnderReviewMsg());
    }

    String portletTitle = StringPool.BLANK;

    if (Validator.isNotNull(calendarConfiguration)) {
        portletTitle =
                portletPreferences.getValue(
                        "portletTitle", calendarConfiguration.portletTitle());
    }

    String maxEventsToShow = StringPool.BLANK;

    if (Validator.isNotNull(calendarConfiguration)) {
        maxEventsToShow =
                portletPreferences.getValue(
                        "maxEventsToShow", calendarConfiguration.maxEventsToShow());
    }

    String numberOfColumn = StringPool.BLANK;

    if (Validator.isNotNull(calendarConfiguration)) {
        numberOfColumn =
                portletPreferences.getValue(
                        "numberOfColumn", calendarConfiguration.numberOfColumn());
    }

    // Check admin
    boolean isAdmin = (permissionChecker.isSignedIn() && fi.valamis.maakportal2.calendar.constants.CalendarPortletKeys.CalendarAdmin.equals(portletName));
    boolean isLoggedInuser = themeDisplay.isSignedIn();

%>