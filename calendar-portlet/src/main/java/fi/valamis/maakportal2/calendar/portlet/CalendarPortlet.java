package fi.valamis.maakportal2.calendar.portlet;

import com.liferay.item.selector.ItemSelector;
import com.liferay.item.selector.ItemSelectorCriterion;
import com.liferay.item.selector.ItemSelectorReturnType;
import com.liferay.item.selector.criteria.FileEntryItemSelectorReturnType;
import com.liferay.item.selector.criteria.URLItemSelectorReturnType;
import com.liferay.item.selector.criteria.image.criterion.ImageItemSelectorCriterion;
import com.liferay.item.selector.criteria.url.criterion.URLItemSelectorCriterion;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.captcha.CaptchaMaxChallengesException;
import com.liferay.portal.kernel.captcha.CaptchaTextException;
import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactory;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import fi.valamis.maakportal2.calendar.configuration.CalendarConfiguration;
import fi.valamis.maakportal2.calendar.constants.CalendarPortletKeys;
import fi.valamis.maakportal2.calendar.event.model.Event;
import fi.valamis.maakportal2.calendar.event.service.EventLocalServiceUtil;
import fi.valamis.maakportal2.calendar.utils.EmailUtil;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author sakerman
 */
@Component(
        configurationPid = "fi.valamis.maakportal2.calendar.configuration.CalendarConfiguration",
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.highlighted",
                "com.liferay.portlet.instanceable=false",
                "javax.portlet.display-name=Tapahtumakalenteri Portlet",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + CalendarPortletKeys.Calendar,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user",
                "com.liferay.portlet.private-request-attributes=true",
                "com.liferay.portlet.private-session-attributes=true",
                "com.liferay.portlet.render-weight=50",
                "com.liferay.portlet.use-default-template=true",
                "com.liferay.portlet.header-portlet-javascript=/js/view.js"
        },
        service = Portlet.class
)
public class CalendarPortlet extends MVCPortlet {

    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH.mm");
    static final String NEW_LINE = System.getProperty("line.separator");

    public void cancelEvent(ActionRequest actionRequest, ActionResponse actionResponse) {
        long eventId = Long.parseLong(ParamUtil.getString(actionRequest, "eventId"));
        Event e = null;
        try {
            e = EventLocalServiceUtil.getEvent(eventId);
        } catch (PortalException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        if (e != null) {
            e.setStatus(CalendarPortletKeys.event_cancelled);
            EventLocalServiceUtil.updateEvent(e);
        }
    }

    public void checkKeyAndToken(ActionRequest actionRequest, ActionResponse actionResponse) {
        long eventId = Long.parseLong(ParamUtil.getString(actionRequest, "eventId"));
        String password = ParamUtil.getString(actionRequest, "password");
        String token = ParamUtil.getString(actionRequest, "token");
        RequestBackedPortletURLFactory requestBackedPortletURLFactory = RequestBackedPortletURLFactoryUtil.create(actionRequest);
        PortletURL itemSelectorURL = _itemSelector.getItemSelectorURL(
                requestBackedPortletURLFactory, "selectItem",
                getImageItemSelectorCriterion(), getURLItemSelectorCriterion());
        Event e = null;
        try {
            e = EventLocalServiceUtil.getEvent(eventId);
        } catch (PortalException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        if (e != null) {
            if (e.getUserGivenPassword().equals(password) && e.getAuthorizationToken().equals(token)) {
                actionResponse.setRenderParameter("mvcPath", "/createEventPopUp.jsp");
                actionResponse.setRenderParameter("token", e.getAuthorizationToken());
                actionResponse.setRenderParameter("eventId", "" + e.getEventId());
                actionResponse.setRenderParameter("itemSelectorURL", itemSelectorURL.toString());
            } else {
                SessionErrors.add(actionRequest, "wrong-password-or-token");
                actionResponse.setRenderParameter("mvcPath", "/checkKeyAndToken.jsp");
            }
        }
        return;
    }

    public void updateEvent(ActionRequest actionRequest, ActionResponse actionResponse) {
        actionResponse.setRenderParameter("vocabularityId", ParamUtil.getString(actionRequest, "vocabularyId"));
        long eventId = Long.parseLong(ParamUtil.getString(actionRequest, "eventId"));

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        String notificationEmail = ParamUtil.getString(actionRequest, "notificationEmail");
        if (notificationEmail == null || notificationEmail.isEmpty()) {
            if (themeDisplay.getLayout().getExpandoBridge().hasAttribute("event-notification-email")) {
                notificationEmail = (String) themeDisplay.getLayout().getExpandoBridge().getAttribute("event-notification-email");
            }
        }

        Event e = null;
        try {
            e = EventLocalServiceUtil.getEvent(eventId);
        } catch (PortalException e1) {
            e = EventLocalServiceUtil.createEvent();
        }
        e.setEventName(stripHTMLTags(ParamUtil.getString(actionRequest, "eventName")));
        if (e.getEventFriendlyName() == null || e.getEventFriendlyName() == "") {
            e.setEventFriendlyName(encodeFriendlyUrl(stripHTMLTags(ParamUtil.getString(actionRequest, "eventName"))));
        }
        String url = stripHTMLTags(ParamUtil.getString(actionRequest, "updateURL"));
        String startingDate = stripHTMLTags(ParamUtil.getString(actionRequest, "startingDate"));
        String startingTime = stripHTMLTags(ParamUtil.getString(actionRequest, "startingTime"));
        String endingDate = stripHTMLTags(ParamUtil.getString(actionRequest, "endingDate"));
        String endingTime = stripHTMLTags(ParamUtil.getString(actionRequest, "endingTime"));
        Date SD = null;
        Date ED = null;
        endingDate = (endingDate.equals("")) ? startingDate : endingDate;
        endingTime = (endingTime.equals("")) ? startingTime : endingTime;
        try {
            SD = sdf.parse(startingDate + " " + startingTime);
            e.setStartingDate(SD);
        } catch (Exception ex) {
            SessionErrors.add(actionRequest, "error-with-starting-date");
            actionResponse.setRenderParameter("mvcPath", "/createEventPopUp.jsp");
        }
        try {
            ED = sdf.parse(endingDate + " " + endingTime);
            e.setEndingDate(ED);
        } catch (Exception ex) {
            SessionErrors.add(actionRequest, "error-with-ending-date");
            actionResponse.setRenderParameter("mvcPath", "/createEventPopUp.jsp");
        }
        if (SD.after(ED)) {
            SessionErrors.add(actionRequest, "error-starting-date-after-ending-date");
            actionResponse.setRenderParameter("mvcPath", "/createEventPopUp.jsp");
            return;
        }

        String[] additionalCompanyIds = actionRequest.getParameterValues("checkBox");
        String additionalCompanyIdsStr = "";
        if (additionalCompanyIds != null && additionalCompanyIds.length > 0 && !additionalCompanyIds[0].equals("false")) {
            additionalCompanyIdsStr = String.join(",", additionalCompanyIds);
        }
        e.setAdditionalCompanyIds(additionalCompanyIdsStr);
        String description = ParamUtil.getString(actionRequest, "description");
        if(description.contains(NEW_LINE)) {
            description = stripHTMLTags(description).replace(NEW_LINE,"<br>");
        }
        e.setTimesAdditionalInfo(stripHTMLTags(ParamUtil.getString(actionRequest, "datesAdditionalInfo")));
        e.setLocation(stripHTMLTags(ParamUtil.getString(actionRequest, "location")));
        e.setDescription(description);
        e.setAdditionalInformation(stripHTMLTags(ParamUtil.getString(actionRequest, "additionalInformation")));
        e.setSignUpLink(stripHTMLTags(ParamUtil.getString(actionRequest, "signUpLink")));
        e.setLinkToEventWebPage(stripHTMLTags(ParamUtil.getString(actionRequest, "linkToEventWebPage")));
        e.setEventAuthorName(stripHTMLTags(ParamUtil.getString(actionRequest, "eventAuthorName")));
        e.setEventAuthorEmail(stripHTMLTags(ParamUtil.getString(actionRequest, "eventAuthorEmail")));
        e.setEventAuthorPhoneNumber(stripHTMLTags(ParamUtil.getString(actionRequest, "eventAuthorPhoneNumber")));
        e.setCompanyId(themeDisplay.getCompanyId());
        String address = "";
        if (!ParamUtil.getString(actionRequest, "address").isEmpty()) {
            address = stripHTMLTags(ParamUtil.getString(actionRequest, "address"));
            address += ", " + stripHTMLTags(ParamUtil.getString(actionRequest, "postalCode"));
            address += " " + stripHTMLTags(ParamUtil.getString(actionRequest, "city"));
        }
        e.setAddress(address);
        e.setShowMap(ParamUtil.getBoolean(actionRequest, "showMap"));
        e.setImageUrl(stripHTMLTags(ParamUtil.getString(actionRequest, "eventImage")));
        e.setGroupId(themeDisplay.getScopeGroupId());

        String[] additionalStartingDates = actionRequest.getParameterValues("recurranceDates");
        String additionalStartingDatesStr = "";
        if (additionalStartingDates != null && additionalStartingDates.length > 0 && !additionalStartingDates[0].equals("false")) {
            additionalStartingDatesStr = stripHTMLTags(String.join(",", additionalStartingDates));
        }
        e.setAdditionalStartingDates(additionalStartingDatesStr);

        e.setCreateDate(new Date());
        e.setModifiedDate(new Date());
        if(!isloggedInUser(themeDisplay)) {
            if (reviewRequired(actionRequest)) {
                // Require review / approve
                e.setStatus(CalendarPortletKeys.event_saved);
            } else {
                // Autoapprove
                e.setStatus(CalendarPortletKeys.event_approved);
            }
        }else {
            e.setStatus(CalendarPortletKeys.event_approved);
        }

        String[] catIds = actionRequest.getParameterValues("assetCategories");
        String catIdstr = "";
        if (catIds != null && catIds.length > 0 && !catIds[0].equals("false")) {
            catIdstr = String.join(",", catIds);
        }
        e.setCategoryIds(catIdstr);
        url = url.replaceAll("ReplaceEventId", "" + e.getEventId());
        e.setUpdateUrl(url);
        EventLocalServiceUtil.updateEvent(e);
        if(!isloggedInUser(themeDisplay)) {
            String emailSubject = LanguageUtil.get(themeDisplay.getLocale(), "event-updated-email-subject");
            EmailUtil.sendEventUpdatedNotification(e, emailSubject, actionRequest);
            EmailUtil.sendNotificationToAdmin(e, notificationEmail, emailSubject, actionRequest);
            SessionMessages.add(actionRequest, "event-updated-requires-approval");
        }
        actionResponse.setRenderParameter("mvcPath", "/eventUpdated.jsp");
    }

    private boolean reviewRequired(PortletRequest request) {
        PortletPreferences preferences = request.getPreferences();
        String reviewRequired = preferences.getValue("reviewRequired", _calendarConfiguration.reviewRequired());
        return "true".equals(reviewRequired);
    }

    /**
     * Checks for logged in user in the application
     *
     * @param themeDisplay
     * @return true if user is logged in
     */
    private boolean isloggedInUser(ThemeDisplay themeDisplay) {

        return themeDisplay.isSignedIn();
    }

    public void createEvent(ActionRequest actionRequest, ActionResponse actionResponse) {
        actionResponse.setRenderParameter("vocabularityId", ParamUtil.getString(actionRequest, "vocabularyId"));
        actionResponse.setRenderParameter("reviewRequired", ParamUtil.getString(actionRequest, "reviewRequired"));
        actionResponse.setRenderParameter("eventSuccessMsg", ParamUtil.getString(actionRequest, "eventSuccessMsg"));
        actionResponse.setRenderParameter("eventPublishMsg", ParamUtil.getString(actionRequest, "eventPublishMsg"));
        actionResponse.setRenderParameter("eventUnderReviewMsg", ParamUtil.getString(actionRequest, "eventUnderReviewMsg"));
        actionResponse.setRenderParameter("eventAwaitingApprovalMsg", ParamUtil.getString(actionRequest, "eventAwaitingApprovalMsg"));
        try {
            CaptchaUtil.check(actionRequest);
        } catch (CaptchaTextException e) {
            SessionErrors.add(actionRequest, "error-captcha-text");
            actionResponse.setRenderParameter("mvcPath", "/createEventPopUp.jsp");
            return;
        } catch (CaptchaMaxChallengesException e) {
            SessionErrors.add(actionRequest, "error-captcha-max-challenges");
            actionResponse.setRenderParameter("mvcPath", "/createEventPopUp.jsp");
            return;
        } catch (Exception e) {

        }
        String notificationEmail = ParamUtil.getString(actionRequest, "notificationEmail");
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        if (notificationEmail == null || notificationEmail.isEmpty()) {
            if (themeDisplay.getLayout().getExpandoBridge().hasAttribute("event-notification-email")) {
                notificationEmail = (String) themeDisplay.getLayout().getExpandoBridge().getAttribute("event-notification-email");
            }
        }
        Event e = EventLocalServiceUtil.createEvent();
        e.setEventName(stripHTMLTags(ParamUtil.getString(actionRequest, "eventName")));
        if (e.getEventFriendlyName() == null || e.getEventFriendlyName() == "") {
            e.setEventFriendlyName(encodeFriendlyUrl(stripHTMLTags(ParamUtil.getString(actionRequest, "eventName"))));
        }
        String url = stripHTMLTags(ParamUtil.getString(actionRequest, "updateURL"));
        String startingDate = stripHTMLTags(ParamUtil.getString(actionRequest, "startingDate"));
        String startingTime = stripHTMLTags(ParamUtil.getString(actionRequest, "startingTime"));
        String endingDate = stripHTMLTags(ParamUtil.getString(actionRequest, "endingDate"));
        String endingTime = stripHTMLTags(ParamUtil.getString(actionRequest, "endingTime"));
        endingDate = (endingDate.equals("")) ? startingDate : endingDate;
        endingTime = (endingTime.equals("")) ? startingTime : endingTime;
        Date SD = null;
        Date ED = null;
        try {
            SD = sdf.parse(startingDate + " " + startingTime);
            e.setStartingDate(SD);
        } catch (Exception ex) {
            SessionErrors.add(actionRequest, "error-with-starting-date");
            actionResponse.setRenderParameter("mvcPath", "/createEventPopUp.jsp");
            return;
        }
        try {
            ED = sdf.parse(endingDate + " " + endingTime);
            e.setEndingDate(ED);
        } catch (Exception ex) {
            SessionErrors.add(actionRequest, "error-with-ending-date");
            actionResponse.setRenderParameter("mvcPath", "/createEventPopUp.jsp");
            return;
        }
        if (SD.after(ED)) {
            SessionErrors.add(actionRequest, "error-starting-date-after-ending-date");
            actionResponse.setRenderParameter("mvcPath", "/createEventPopUp.jsp");
            return;
        }

        String[] additionalCompanyIds = actionRequest.getParameterValues("checkBox");
        String additionalCompanyIdsStr = "";
        if (additionalCompanyIds != null && additionalCompanyIds.length > 0 && !additionalCompanyIds[0].equals("false")) {
            additionalCompanyIdsStr = String.join(",", additionalCompanyIds);
        }
        e.setAdditionalCompanyIds(additionalCompanyIdsStr);
        String description = ParamUtil.getString(actionRequest, "description");
        if(description.contains(NEW_LINE)) {
            description = stripHTMLTags(description).replace(NEW_LINE,"<br>");
        }

        
        e.setTimesAdditionalInfo(stripHTMLTags(ParamUtil.getString(actionRequest, "datesAdditionalInfo")));
        e.setLocation(stripHTMLTags(ParamUtil.getString(actionRequest, "location")));
        e.setDescription(description);
        System.out.println("----------------- CREATE EVENT (DESCRIPTION) ------------------------ : " + e.getDescription());
        e.setAdditionalInformation(stripHTMLTags(ParamUtil.getString(actionRequest, "additionalInformation")));
        e.setSignUpLink(stripHTMLTags(ParamUtil.getString(actionRequest, "signUpLink")));
        e.setLinkToEventWebPage(stripHTMLTags(ParamUtil.getString(actionRequest, "linkToEventWebPage")));
        e.setEventAuthorName(stripHTMLTags(ParamUtil.getString(actionRequest, "eventAuthorName")));
        e.setEventAuthorEmail(stripHTMLTags(ParamUtil.getString(actionRequest, "eventAuthorEmail")));
        e.setEventAuthorPhoneNumber(stripHTMLTags(ParamUtil.getString(actionRequest, "eventAuthorPhoneNumber")));
        e.setCompanyId(themeDisplay.getCompanyId());
        e.setGroupId(themeDisplay.getScopeGroupId());

        String[] additionalStartingDates = actionRequest.getParameterValues("recurranceDates");
        String additionalStartingDatesStr = "";
        if (additionalStartingDates != null && additionalStartingDates.length > 0 && !additionalStartingDates[0].equals("false")) {
            additionalStartingDatesStr = stripHTMLTags(String.join(",", additionalStartingDates));
        }
        e.setAdditionalStartingDates(additionalStartingDatesStr);

        e.setCreateDate(new Date());
        e.setModifiedDate(new Date());
        e.setAuthorizationToken(getSaltString());
        String address = "";
        if (!ParamUtil.getString(actionRequest, "address").isEmpty()) {
            address = stripHTMLTags(ParamUtil.getString(actionRequest, "address"));
            address += ", " + stripHTMLTags(ParamUtil.getString(actionRequest, "postalCode"));
            address += ", " + stripHTMLTags(ParamUtil.getString(actionRequest, "city"));
        }
        e.setAddress(address);
        e.setShowMap(ParamUtil.getBoolean(actionRequest, "showMap"));
        e.setImageUrl(stripHTMLTags(ParamUtil.getString(actionRequest, "eventImage")));
        if(!isloggedInUser(themeDisplay)) {
            if (reviewRequired(actionRequest)) {
                // Require review / approve
                e.setStatus(CalendarPortletKeys.event_saved);
            } else {
                // Autoapprove
                e.setStatus(CalendarPortletKeys.event_approved);
            }
        } else {
            e.setStatus(CalendarPortletKeys.event_approved);
        }

        String[] catIds = actionRequest.getParameterValues("assetCategories");
        String catIdstr = "";
        if (catIds != null && catIds.length > 0 && !catIds[0].equals("false")) {
            catIdstr = String.join(",", catIds);
        }
        e.setCategoryIds(catIdstr);

        String pw = ParamUtil.getString(actionRequest, "password");
        String pwc = ParamUtil.getString(actionRequest, "passwordConfirm");
        if (!pw.equals(pwc)) {
            SessionErrors.add(actionRequest, "error-with-passwords-date");
            actionResponse.setRenderParameter("mvcPath", "/createEventPopUp.jsp");
            return;
        }
        e.setUserGivenPassword(pw);
        url = url.replaceAll("ReplaceEventId", "" + e.getEventId());
        e.setUpdateUrl(url);
        EventLocalServiceUtil.updateEvent(e);
        if(!isloggedInUser(themeDisplay)) {
            String emailSubject = LanguageUtil.get(themeDisplay.getLocale(), "event-created-email-subject");
            EmailUtil.sendEventNotification(e, emailSubject, actionRequest);
            EmailUtil.sendNotificationToAdmin(e, notificationEmail, emailSubject, actionRequest);
            SessionMessages.add(actionRequest, "event-created-requires-approval");
        }
        actionResponse.setRenderParameter("mvcPath", "/createSuccess.jsp");
    }

    public void serveResource(ResourceRequest request, ResourceResponse response) throws PortletException, IOException {
        CaptchaUtil.serveImage(request, response);
    }

    protected String getSaltString() {
        // FIXME: No-one would ever guess this :D
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 15) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        renderRequest.setAttribute(
                CalendarConfiguration.class.getName(),
                _calendarConfiguration);

        RequestBackedPortletURLFactory requestBackedPortletURLFactory = RequestBackedPortletURLFactoryUtil.create(renderRequest);
        PortletURL itemSelectorURL = _itemSelector.getItemSelectorURL(
                requestBackedPortletURLFactory, "selectItem",
                getImageItemSelectorCriterion(), getURLItemSelectorCriterion());
        renderRequest.setAttribute("itemSelectorURL", itemSelectorURL.toString());
        String defaultEventImageUrl = "";
        try {
            ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
            String siteCustomFieldName = "defaultEventImage";
            if (themeDisplay.getSiteGroup().getExpandoBridge().hasAttribute(siteCustomFieldName)) {
                String cFiledValue = (String) themeDisplay.getScopeGroup().getExpandoBridge().getAttribute(siteCustomFieldName);
                if (cFiledValue != null && !cFiledValue.isEmpty()) {
                    defaultEventImageUrl = cFiledValue;
                }
            }
        } catch (Exception err) {
            System.out.println(err);
        }
        renderRequest.setAttribute("defaultEventImageUrl", defaultEventImageUrl);
        super.doView(renderRequest, renderResponse);
    }

    public String eventNotificationEmail(Map labels) {
        return (String) labels.get(_calendarConfiguration.eventNotificationEmail());
    }

    public String showCalendar(Map labels) {
        return (String) labels.get(_calendarConfiguration.showCalendar());
    }

    public String mainCalendarPage(Map labels) {
        return (String) labels.get(_calendarConfiguration.mainCalendarPage());
    }

    @Activate
    @Modified
    protected void activate(Map<Object, Object> properties) {
        _calendarConfiguration = ConfigurableUtil.createConfigurable(
                CalendarConfiguration.class, properties);
    }

    private volatile CalendarConfiguration _calendarConfiguration;

    @Reference(unbind = "-")
    protected void setItemSelector(ItemSelector itemSelector) {
        _itemSelector = itemSelector;
    }

    private ItemSelector _itemSelector;

    protected ItemSelectorCriterion getImageItemSelectorCriterion() {
        List<ItemSelectorReturnType> desiredItemSelectorReturnTypes =
                new ArrayList<>();
        desiredItemSelectorReturnTypes.add(
                new FileEntryItemSelectorReturnType());
        desiredItemSelectorReturnTypes.add(new URLItemSelectorReturnType());
        ItemSelectorCriterion imageItemSelectorCriterion =
                new ImageItemSelectorCriterion();
        imageItemSelectorCriterion.setDesiredItemSelectorReturnTypes(
                desiredItemSelectorReturnTypes);
        return imageItemSelectorCriterion;
    }

    protected ItemSelectorCriterion getURLItemSelectorCriterion() {
        ItemSelectorCriterion urlItemSelectorCriterion =
                new URLItemSelectorCriterion();
        List<ItemSelectorReturnType> desiredItemSelectorReturnTypes =
                new ArrayList<>();
        desiredItemSelectorReturnTypes.add(new URLItemSelectorReturnType());
        urlItemSelectorCriterion.setDesiredItemSelectorReturnTypes(
                desiredItemSelectorReturnTypes);
        return urlItemSelectorCriterion;
    }

    private String stripHTMLTags(String s) {
        return s.replaceAll("<[^>]*>", "");
    }

    private static String encodeFriendlyUrl(String input) {
        String newTestName = input.toLowerCase().replaceAll("[^a-z\\s]", "").replaceAll("\\s", "-");
        List<Event> events = EventLocalServiceUtil.findEventsByFriendlyName(newTestName);
        if(events != null) {
            newTestName = newTestName + "-" + Integer.toString(events.size());
        }
        return newTestName;
    }


}