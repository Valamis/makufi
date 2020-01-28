package fi.valamis.maakportal2.calendar.configuration.action;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import fi.valamis.maakportal2.calendar.configuration.CalendarConfiguration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

@Component(
	    configurationPid = "fi.valamis.maakportal2.calendar.configuration.CalendarConfiguration",
	    configurationPolicy = ConfigurationPolicy.OPTIONAL,
	    immediate = true,
	    property = {
	        "javax.portlet.name=Calendar"
	    },
	    service = ConfigurationAction.class
	)

public class CalendarConfigurationAction extends DefaultConfigurationAction {

	@Override
	public void processAction(
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse)
		throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Set<Locale> currentUsedLocalization = LanguageUtil.getAvailableLocales(themeDisplay.getSiteGroupId());

		String eventSuccessJson = ParamUtil.getString(actionRequest, "eventSuccessJson");
		String eventPublishMsgJson = ParamUtil.getString(actionRequest, "eventPublishMsgJson");
		String eventAwaitingApprovalMsgJson = ParamUtil.getString(actionRequest, "eventAwaitingApprovalMsgJson");
		String eventUnderReviewMsgJson = ParamUtil.getString(actionRequest, "eventUnderReviewMsgJson");
		String portletTitleJson = ParamUtil.getString(actionRequest, "portletTitleJson");
		String selectedLanguage = ParamUtil.getString(actionRequest, "selectedLanguage");
		//if empty get new json string in correct format
        eventSuccessJson = eventSuccessJson.trim().isEmpty() ? getNewJsonString(currentUsedLocalization) : eventSuccessJson;
        eventPublishMsgJson = eventPublishMsgJson.trim().isEmpty() ? getNewJsonString(currentUsedLocalization) : eventPublishMsgJson;
		eventAwaitingApprovalMsgJson = eventAwaitingApprovalMsgJson.trim().isEmpty() ? getNewJsonString(currentUsedLocalization) : eventAwaitingApprovalMsgJson;
		eventUnderReviewMsgJson = eventUnderReviewMsgJson.trim().isEmpty() ? getNewJsonString(currentUsedLocalization) : eventUnderReviewMsgJson;
		portletTitleJson = portletTitleJson.trim().isEmpty() ? getNewJsonString(currentUsedLocalization) : portletTitleJson;

		String showCalendar = ParamUtil.getString(actionRequest, "showCalendar");
		setPreference(actionRequest, "showCalendar", showCalendar);

		String mainCalendarPage = ParamUtil.getString(actionRequest, "mainCalendarPage");
		setPreference(actionRequest, "mainCalendarPage", mainCalendarPage);
		
		String eventsPage = ParamUtil.getString(actionRequest, "eventsPage");
		setPreference(actionRequest, "eventsPage", eventsPage);
		
		String vocabularityId = ParamUtil.getString(actionRequest, "vocabularityId");
		setPreference(actionRequest, "vocabularityId", vocabularityId);

		String selectedCategory = ParamUtil.getString(actionRequest, "selectedCategory");
		setPreference(actionRequest, "selectedCategory", selectedCategory);

		String eventNotificationEmail = ParamUtil.getString(actionRequest, "eventNotificationEmail");
		setPreference(actionRequest, "eventNotificationEmail", eventNotificationEmail);

		String reviewRequired = ParamUtil.getString(actionRequest, "reviewRequired");
		setPreference(actionRequest, "reviewRequired", reviewRequired);

		String maxEventsToShow = ParamUtil.getString(actionRequest, "maxEventsToShow");
		setPreference(actionRequest, "maxEventsToShow", maxEventsToShow);

		String numberOfColumn = ParamUtil.getString(actionRequest, "numberOfColumn");
		setPreference(actionRequest, "numberOfColumn", numberOfColumn);

        String formDescription = ParamUtil.getString(actionRequest, "formDescription");
        setPreference(actionRequest, "formDescription", formDescription);

        String showOnlyVocabularityId = ParamUtil.getString(actionRequest, "showOnlyVocabularityId");
        setPreference(actionRequest, "showOnlyVocabularityId", showOnlyVocabularityId);

        String showOtherInstances = ParamUtil.getString(actionRequest, "showOtherInstances");
        setPreference(actionRequest, "showOtherInstances", showOtherInstances);

        String showEventImage = ParamUtil.getString(actionRequest, "showEventImage");
        setPreference(actionRequest, "showEventImage", showEventImage);

		String eventSuccessMsg = ParamUtil.getString(actionRequest, "eventSuccessMsg");
		eventSuccessMsg = updateJsonValue(selectedLanguage, eventSuccessMsg, eventSuccessJson);
		setPreference(actionRequest, "eventSuccessMsg", eventSuccessMsg);

		String eventPublishMsg = ParamUtil.getString(actionRequest, "eventPublishMsg");
		eventPublishMsg = updateJsonValue(selectedLanguage, eventPublishMsg, eventPublishMsgJson);
		setPreference(actionRequest, "eventPublishMsg", eventPublishMsg);

		String eventAwaitingApprovalMsg = ParamUtil.getString(actionRequest, "eventAwaitingApprovalMsg");
		eventAwaitingApprovalMsg = updateJsonValue(selectedLanguage, eventAwaitingApprovalMsg, eventAwaitingApprovalMsgJson);
		setPreference(actionRequest, "eventAwaitingApprovalMsg", eventAwaitingApprovalMsg);

		String eventUnderReviewMsg = ParamUtil.getString(actionRequest, "eventUnderReviewMsg");
		eventUnderReviewMsg = updateJsonValue(selectedLanguage, eventUnderReviewMsg, eventUnderReviewMsgJson);
		setPreference(actionRequest, "eventUnderReviewMsg", eventUnderReviewMsg);

		String portletTitle = ParamUtil.getString(actionRequest, "portletTitle");
		portletTitle = updateJsonValue(selectedLanguage, portletTitle, portletTitleJson);
		setPreference(actionRequest, "portletTitle", portletTitle);

		super.processAction(portletConfig, actionRequest, actionResponse);
	}

	/***
	 * Creates new json string in correct format with active languages as key
	 * @param currentUsedLocalization
	 * @return new json string
	 */
	private String getNewJsonString (Set<Locale> currentUsedLocalization) {
		Map<String, String> newJsonMap = new HashMap<>();

		for (Locale locale: currentUsedLocalization) {
			newJsonMap.put(locale.getDisplayLanguage(),"");
		}
		return JSONFactoryUtil.looseSerialize(newJsonMap);
	}

	/**
	 * Update json value for any available key in json string
	 * @param key language (eg.: English, Finnish etc)
	 * @param value desired message value
	 * @param jsonString original json string where update is required
	 * @return updates the value and returns the json string
	 */
	private String updateJsonValue (String key, String value, String jsonString) {
		String updatedJsonString;
		try {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject(jsonString);
			jsonObject.put(key,value);
			updatedJsonString = JSONFactoryUtil.looseSerialize(jsonObject);
		} catch (JSONException e) {
			e.printStackTrace();
			return jsonString;
		}
		return updatedJsonString;
	}

	@Override
	public void include(
		PortletConfig portletConfig, HttpServletRequest httpServletRequest,
		HttpServletResponse httpServletResponse) throws Exception {

		httpServletRequest.setAttribute(
				CalendarConfiguration.class.getName(),
				_calendarConfiguration);
		
		super.include(portletConfig, httpServletRequest, httpServletResponse);
	}

	@Activate
	@Modified
	protected void activate(Map<Object, Object> properties) {
		_calendarConfiguration = ConfigurableUtil.createConfigurable(
				CalendarConfiguration.class, properties);
	}

	private volatile CalendarConfiguration _calendarConfiguration;

}
