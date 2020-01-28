package fi.valamis.maakportal2.calendar.portlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.time.*;
import java.util.Calendar;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;
import javax.portlet.PortletContext;
import javax.portlet.PortletException;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.*;

import com.liferay.item.selector.ItemSelector;
import com.liferay.item.selector.ItemSelectorCriterion;
import com.liferay.item.selector.ItemSelectorReturnType;
import com.liferay.item.selector.criteria.FileEntryItemSelectorReturnType;
import com.liferay.item.selector.criteria.URLItemSelectorReturnType;
import com.liferay.item.selector.criteria.image.criterion.ImageItemSelectorCriterion;
import com.liferay.item.selector.criteria.url.criterion.URLItemSelectorCriterion;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PortletApp;
import com.liferay.portal.kernel.portlet.LiferayPortletConfig;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.ServletContextPool;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactory;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactoryUtil;
import com.liferay.portal.kernel.language.LanguageUtil;

import fi.valamis.maakportal2.calendar.configuration.CalendarConfiguration;
import fi.valamis.maakportal2.calendar.constants.CalendarPortletKeys;
import fi.valamis.maakportal2.calendar.event.model.Event;
import fi.valamis.maakportal2.calendar.event.service.EventLocalServiceUtil;
import fi.valamis.maakportal2.calendar.utils.EmailUtil;
import static fi.valamis.maakportal2.calendar.portlet.CalendarPortlet.NEW_LINE;

@Component(
		immediate = true,
		property = {
				"com.liferay.portlet.add-default-resource=true",
				"com.liferay.portlet.layout-cacheable=true",
				"com.liferay.portlet.private-request-attributes=false",
				"com.liferay.portlet.private-session-attributes=false",
				"com.liferay.portlet.render-weight=50",
				"com.liferay.portlet.use-default-template=true",
				"com.liferay.portlet.system=true",
				"javax.portlet.display-name=Tapahtumahallinta",
				"javax.portlet.init-param.template-path=/",
				"javax.portlet.init-param.view-template=/admin/view.jsp",
				"javax.portlet.name=" + CalendarPortletKeys.CalendarAdmin,
				"javax.portlet.resource-bundle=content.Language",
				"javax.portlet.security-role-ref=power-user,user",
                "com.liferay.portlet.header-portlet-javascript=/js/view.js",
                "com.liferay.portlet.footer-portlet-css=/css/admin.css"
		},
		service = Portlet.class
	)
public class CalendarAdminPortlet extends MVCPortlet {
	SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH.mm");
	public void approveEvent(ActionRequest actionRequest, ActionResponse actionResponse) {
		long eventId = Long.parseLong(ParamUtil.getString(actionRequest, "eventId"));
		Event e = null;
		try {
			e = EventLocalServiceUtil.getEvent(eventId);
		} catch (PortalException ex) {
			ex.printStackTrace();
		}
		if(e != null) {
			e.setStatus(CalendarPortletKeys.event_approved);
            EventLocalServiceUtil.updateEvent(e);
            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
            String emailSubject = LanguageUtil.get(themeDisplay.getLocale(), "event-approved-email-subject");
            EmailUtil.sendEventNotification(e, emailSubject, actionRequest);
			return;
		}
	}

	public void removeEvent(ActionRequest actionRequest, ActionResponse actionResponse) {
		final long eventId = Long.parseLong(ParamUtil.getString(actionRequest, "eventId"));
		try {
			EventLocalServiceUtil.deleteEvent(eventId);
		} catch(PortalException e) {
			throw new RuntimeException("Could not remove event. Unknown reason. eventId: " + eventId, e);
		}
	}
	
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

	public void askMoreDetailsEvent(ActionRequest actionRequest, ActionResponse actionResponse) {
		long eventId = Long.parseLong(ParamUtil.getString(actionRequest, "eventId"));
		Event e = null;
		try {
			e = EventLocalServiceUtil.getEvent(eventId);
		} catch (PortalException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String adminComment = ParamUtil.getString(actionRequest, "adminComment");
		if(e != null) {
			e.setAdminComment(adminComment);
			e.setStatus(CalendarPortletKeys.event_returned);
            EventLocalServiceUtil.updateEvent(e);
            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
            String emailSubject = LanguageUtil.get(themeDisplay.getLocale(), "event-requestinfo-email-subject");
			EmailUtil.sendEventInfoRequestNotification(e, emailSubject, actionRequest);
		}
	}
	
	public void updateEvent(ActionRequest actionRequest, ActionResponse actionResponse) {
        long eventId = Long.parseLong(ParamUtil.getString(actionRequest, "eventId"));
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        Event e = null;
        try {
            e = EventLocalServiceUtil.getEvent(eventId);
        } catch (PortalException e1) {
           
        }
        if(e == null) {
        	return; 
        }
		e.setEventName(stripHTMLTags(ParamUtil.getString(actionRequest, "eventName")));
        if (e.getEventFriendlyName() == null || e.getEventFriendlyName() == "") {
            e.setEventFriendlyName(encodeForUrl(stripHTMLTags(ParamUtil.getString(actionRequest, "eventName"))));
        }
		String url = stripHTMLTags(ParamUtil.getString(actionRequest, "updateURL"));
        String startingDate = ParamUtil.getString(actionRequest, "startingDate");
        String startingTime = ParamUtil.getString(actionRequest, "startingTime");
        String endingDate = ParamUtil.getString(actionRequest, "endingDate");
        String endingTime = ParamUtil.getString(actionRequest, "endingTime");

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

        String[] catIds = actionRequest.getParameterValues("assetCategories");
        String catIdstr = "";
        if (catIds != null && catIds.length > 0 && !catIds[0].equals("false")) {
            catIdstr = String.join(",", catIds);
        }
        e.setCategoryIds(catIdstr);

        e.setTimesAdditionalInfo(stripHTMLTags(ParamUtil.getString(actionRequest, "datesAdditionalInfo")));
        e.setLocation(stripHTMLTags(ParamUtil.getString(actionRequest, "location")));
        String description = ParamUtil.getString(actionRequest, "description");
        if(description.contains(NEW_LINE)) {
            description = stripHTMLTags(description).replace(NEW_LINE,"<br>");
        }
        e.setDescription(description);
        e.setAdditionalInformation(stripHTMLTags(ParamUtil.getString(actionRequest, "additionalInformation")));
        e.setSignUpLink(stripHTMLTags(ParamUtil.getString(actionRequest, "signUpLink")));
        e.setLinkToEventWebPage(stripHTMLTags(ParamUtil.getString(actionRequest, "linkToEventWebPage")));
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

        e.setModifiedDate(new Date());

        e.setStatus(CalendarPortletKeys.event_approved);

		EventLocalServiceUtil.updateEvent(e);
        url = url.replaceAll("ReplaceEventId", "" + e.getEventId());
        if(!isloggedInUser(themeDisplay)) {
            String emailSubject = LanguageUtil.get(themeDisplay.getLocale(), "event-approved-email-subject");
            EmailUtil.sendEventUpdatedNotification(e, emailSubject, actionRequest);
        }
        actionResponse.setRenderParameter("mvcPath", "/admin/view.jsp");
	}
	
	private String stripHTMLTags(String s) {
        return s.replaceAll("<[^>]*>", "");
    }

	@Override
	public void destroy() {
		PortletContext portletContext = getPortletContext();

		ServletContextPool.remove(portletContext.getPortletContextName());

		super.destroy();
	}

	@Override
	public void init(PortletConfig portletConfig) throws PortletException {
		super.init(portletConfig);

		LiferayPortletConfig liferayPortletConfig =
			(LiferayPortletConfig)portletConfig;

		com.liferay.portal.kernel.model.Portlet portlet =
			liferayPortletConfig.getPortlet();

		PortletApp portletApp = portlet.getPortletApp();

		ServletContextPool.put(
			portletApp.getServletContextName(), portletApp.getServletContext());
	}

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        RequestBackedPortletURLFactory requestBackedPortletURLFactory = RequestBackedPortletURLFactoryUtil.create(renderRequest);
        PortletURL itemSelectorURL = _itemSelector.getItemSelectorURL(
                requestBackedPortletURLFactory, "selectItem",
                getImageItemSelectorCriterion(), getURLItemSelectorCriterion());
        renderRequest.setAttribute("itemSelectorURL", itemSelectorURL.toString());
        super.doView(renderRequest, renderResponse);
    }

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

    private static String encodeForUrl(String input) {
        String newTestName = input.toLowerCase().replaceAll("[^a-z\\s]", "").replaceAll("\\s", "-");
        List<Event> events = EventLocalServiceUtil.findEventsByFriendlyName(newTestName);
        if(events != null) {
            newTestName = newTestName + "-" + Integer.toString(events.size());
        }
        System.out.println("-- New friendly rul name: " + newTestName);
        return newTestName;
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



}