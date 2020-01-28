<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.liferay.asset.kernel.model.AssetVocabulary" %>
<%@ page import="com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.model.Layout" %>
<%@ page import="com.liferay.portal.kernel.service.LayoutLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.service.CompanyLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.service.GroupLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.asset.kernel.model.AssetCategory" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.Set" %>
<%@ page import="com.liferay.portal.kernel.language.Language" %>
<%@ page import="com.liferay.portal.kernel.util.LocaleUtil" %>
<%@ page import="com.liferay.portal.kernel.json.JSONObject" %>
<%@ page import="com.liferay.portal.kernel.json.JSONFactoryUtil" %>
<%@ page import="com.liferay.portal.kernel.json.JSONException" %>

<%@ include file="/init.jsp" %>

<%
int count = AssetVocabularyLocalServiceUtil.getAssetVocabulariesCount();
//List<AssetVocabulary> vocs = AssetVocabularyLocalServiceUtil.getCompanyVocabularies(themeDisplay.getCompanyId()); // Organisation
List<AssetVocabulary> vocs = AssetVocabularyLocalServiceUtil.getGroupVocabularies(themeDisplay.getSiteGroupId()); // Current site
//List<AssetVocabulary> vocs = AssetVocabularyLocalServiceUtil.getAssetVocabularies(0, count); // Whole portal
Set<Locale> currentUsedLocalization = LanguageUtil.getAvailableLocales(themeDisplay.getSiteGroupId());
Locale defaultLocale = LocaleUtil.getDefault();
String eventSuccessMsgVal, eventPublishMsgVal, eventAwaitingApprovalMsgVal, eventUnderReviewMsgVal, portletTitleVal;
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

try {
    JSONObject eventAwaitingApprovalMsgObj  = JSONFactoryUtil.createJSONObject(eventAwaitingApprovalMsg);
    eventAwaitingApprovalMsgVal = eventAwaitingApprovalMsgObj.getString(defaultLocale.getDisplayLanguage());
} catch (JSONException je) {
        eventAwaitingApprovalMsgVal = eventAwaitingApprovalMsg;
}

try {
    JSONObject eventUnderReviewMsgObj  = JSONFactoryUtil.createJSONObject(eventUnderReviewMsg);
    eventUnderReviewMsgVal = eventUnderReviewMsgObj.getString(defaultLocale.getDisplayLanguage());
} catch (JSONException je) {
    eventUnderReviewMsgVal = eventUnderReviewMsg;
}

try {
     JSONObject portletTitleObj  = JSONFactoryUtil.createJSONObject(portletTitle);
     portletTitleVal = portletTitleObj.getString(defaultLocale.getDisplayLanguage());
} catch (JSONException je) {
     portletTitleVal = portletTitle;
}


//System.out.println(themeDisplay.getLayouts());
List<Layout> alllayouts = LayoutLocalServiceUtil.getLayouts(themeDisplay.getSiteGroupId(), false);
String defaultEventsPagePath = themeDisplay.getPathFriendlyURLPublic() + GroupLocalServiceUtil.getGroup(themeDisplay.getSiteGroupId()).getFriendlyURL();

List<AssetCategory> assetCategories;
    if(vocabularityId == null||vocabularityId == ""){
        assetCategories = new ArrayList<AssetCategory>();
        vocabularityId = "";
    } else {
        assetCategories = AssetCategoryLocalServiceUtil.getVocabularyCategories(Long.parseLong(vocabularityId), 0, AssetCategoryLocalServiceUtil.getAssetCategoriesCount(), null);
    }

%>

<liferay-portlet:actionURL portletConfiguration="<%= true %>" var="configurationActionURL"/>
<liferay-portlet:renderURL portletConfiguration="<%= true %>" var="configurationRenderURL"/>
<div class="portlet-configuration-body-content">
<div class="container-fluid-1280">
<aui:form action="<%= configurationActionURL %>" method="post" name="fm">
    <aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>"/>
    <aui:input name="redirect" type="hidden" value="<%= configurationRenderURL %>"/>

    <aui:input id="mainCalendarPage" label="mainCalendarPage" name="mainCalendarPage" key="mainCalendarPage" type="toggle-switch" value="<%= mainCalendarPage %>"></aui:input>
    <aui:script>
        AUI.$('#<portlet:namespace />mainCalendarPage').click(checkMain);
        AUI.$('#<portlet:namespace />mainCalendarPage').change(checkMain);
        AUI.$('#<portlet:namespace />mainCalendarPage').blur(checkMain);
        function checkMain() {
            if (AUI.$('#<portlet:namespace />mainCalendarPage').prop('checked')) {
                AUI.$('#<portlet:namespace />eventsPage').val('');
                AUI.$('#<portlet:namespace />mainPagePathSelectWrapper').hide();
                AUI.$('#<portlet:namespace />form-settings').show();
            } else {
                AUI.$('#<portlet:namespace />mainPagePathSelectWrapper').show();
                AUI.$('#<portlet:namespace />form-settings').hide();
            }

        }
        checkMain();
        function getCategories(){
            var option = $('#<portlet:namespace />vocabluraryId');
            var assetCategoryOption = $('#<portlet:namespace />assetCategory');
            var assetCatContainer = $('#<portlet:namespace />category');
            var selectedValue = option.find(":selected").attr("value");
            if(selectedValue) {
                AUI().use('aui-io-request', function(A){
                    A.io.request('/o/event-rest/events/categories/' + selectedValue, {
                        method: 'get',
                            on: {
                                success: function() {
                                assetCatContainer.show();
                                var assetCatList = [];
                                assetCatList = JSON.parse(this.get('responseData'));
                                assetCategoryOption.empty();
                                assetCategoryOption.append($("<option></option>").attr("value", "").text(""));
                                for(var i=0; i < assetCatList.length ; i++) {
                                    var assetCat = assetCatList[i];
                                    assetCategoryOption.append($("<option></option>").attr("value", assetCat.categoryId).text(assetCat.name));
                                }
                            }
                        }
                    });
                });
            } else {
                option.val("");
                assetCategoryOption.empty();
                assetCategoryOption.append($('<option selected="true"></option>').attr("value", "").text(""));
                assetCatContainer.hide();
            }
        }
        $(".dropdown-menu li a").click(function(e){
            e.preventDefault();
            var languageBtn = $(this).parents('.btn-group').find('.dropdown-toggle');
            var dataLocale = languageBtn.attr('data-locale');
            var nextLang = $(this).text();
            languageBtn.attr('data-locale', nextLang);
            languageBtn.html(nextLang+' <span class="caret"></span>');
            var elmSelectedLanguage = $('#<portlet:namespace />selectedLanguage');
            //set selected Language
            elmSelectedLanguage.val(nextLang);
            setMsgValues(dataLocale,nextLang);
        });

        function setMsgValues(currentLang, nextLang) {
            //input fields
            var elmEventSuccessMsg = $('#<portlet:namespace />eventSuccessMsg');
            var elmEventPublishMsg = $('#<portlet:namespace />eventPublishMsg');
            var elmEventAwaitingApprovalMsg = $('#<portlet:namespace />eventAwaitingApprovalMsg');
            var elmEventUnderReviewMsg = $('#<portlet:namespace />eventUnderReviewMsg');
            var elmPortletTitle = $('#<portlet:namespace />portletTitle');

            //hidden Json Fields
            var elmEventSuccessMsgJson = $('#<portlet:namespace />eventSuccessMsgJson');
            var elmEventPublishMsgJson = $('#<portlet:namespace />eventPublishMsgJson');
            var elmEventAwaitingApprovalMsgJson = $('#<portlet:namespace />eventAwaitingApprovalMsgJson');
            var elmEventUnderReviewMsgJson = $('#<portlet:namespace />eventUnderReviewMsgJson');
            var elmPortletTitleJson = $('#<portlet:namespace />portletTitleJson');

            //get and store json value
            var eventSuccessMsgJson = {};
            var eventPublishMsgJson = {};
            var eventAwaitingApprovalMsgJson = {};
            var eventUnderReviewMsgJson ={};
            var portletTitleJson ={};

            var tempEventSuccessMsgJson = elmEventSuccessMsgJson.val();
            var tempEventPublishMsgJson = elmEventPublishMsgJson.val();
            var tempEventAwaitingApprovalMsgJson = elmEventAwaitingApprovalMsgJson.val();
            var tempEventUnderReviewMsgJson = elmEventUnderReviewMsgJson.val();
            var tempPortletTitleJson = elmPortletTitleJson.val();

            // trying to parse the string because, string might not be in json format
            try{
                eventSuccessMsgJson = JSON.parse(tempEventSuccessMsgJson);
            } catch (e){
                eventSuccessMsgJson[currentLang] = tempEventSuccessMsgJson;
            }

            try{
                eventPublishMsgJson = JSON.parse(tempEventPublishMsgJson);
            } catch (e){
                eventPublishMsgJson[currentLang] = tempEventPublishMsgJson;
            }

            try{
                eventAwaitingApprovalMsgJson = JSON.parse(tempEventAwaitingApprovalMsgJson);
            } catch (e) {
                eventAwaitingApprovalMsgJson[currentLang] = tempEventAwaitingApprovalMsgJson;
            }

            try{
                eventUnderReviewMsgJson = JSON.parse(tempEventUnderReviewMsgJson);
            } catch (e) {
                eventUnderReviewMsgJson[currentLang] = tempEventUnderReviewMsgJson;
            }

            try{
                portletTitleJson = JSON.parse(tempPortletTitleJson);
            } catch (e) {
                portletTitleJson[currentLang] = tempPortletTitleJson;
            }


            //store value of input field to respective key on language change
            eventSuccessMsgJson[currentLang] = elmEventSuccessMsg.val();
            eventPublishMsgJson[currentLang] = elmEventPublishMsg.val();
            eventAwaitingApprovalMsgJson[currentLang] = elmEventAwaitingApprovalMsg.val();
            eventUnderReviewMsgJson[currentLang] = elmEventUnderReviewMsg.val();
            portletTitleJson[currentLang] = elmPortletTitle.val();

            //clear input fields for next language
            elmEventSuccessMsg.val(eventSuccessMsgJson[nextLang]?eventSuccessMsgJson[nextLang]:"");
            elmEventPublishMsg.val(eventPublishMsgJson[nextLang]?eventPublishMsgJson[nextLang]:"");
            elmEventAwaitingApprovalMsg.val(eventAwaitingApprovalMsgJson[nextLang]?eventAwaitingApprovalMsgJson[nextLang]:"");
            elmEventUnderReviewMsg.val(eventUnderReviewMsgJson[nextLang]?eventUnderReviewMsgJson[nextLang]:"");
            elmPortletTitle.val(portletTitleJson[nextLang]?portletTitleJson[nextLang]:"");

            //set hidden input value
            elmEventSuccessMsgJson.val(JSON.stringify(eventSuccessMsgJson));
            elmEventPublishMsgJson.val(JSON.stringify(eventPublishMsgJson));
            elmEventAwaitingApprovalMsgJson.val(JSON.stringify(eventAwaitingApprovalMsgJson));
            elmEventUnderReviewMsgJson.val(JSON.stringify(eventUnderReviewMsgJson));
            elmPortletTitleJson.val(JSON.stringify(portletTitleJson));

        }
    </aui:script>

    <div id="<portlet:namespace />mainPagePathSelectWrapper" style="display: <%= (mainCalendarPage != null && mainCalendarPage.equals("false")) ? "" : "none" %>">
    <% eventsPage = (eventsPage == null) ? "" : eventsPage; %>
    <aui:select id="eventsPage" name="eventsPage" label="eventsPage" showEmptyOption="true">
        <% 
        Boolean selected = true;
        String value = "";
        for (Layout lay : alllayouts) {
            value = lay.getFriendlyURL();
            selected = eventsPage.equals(defaultEventsPagePath + value);
        %>
        <aui:option value="<%= defaultEventsPagePath + value %>" selected="<%= selected %>"><%= value %></aui:option>
        <% } %>
    </aui:select>
    </div>

    <aui:input label="showCalendar" name="showCalendar" key="showCalendar" type="toggle-switch" value="<%= showCalendar %>"/>

    <aui:input label="Show Event Image" name="showEventImage" key="showEventImage" type="toggle-switch"
               value="<%= showEventImage %>"/>


    <% vocabularityId = (vocabularityId == null) ? "" : vocabularityId; %>
    <aui:select name="vocabularityId" label="vocabularityId" showEmptyOption="true" onchange="getCategories()" id="vocabluraryId">
        <% 
        Boolean selected = true;
        String value = "";
        //String hostname = "";
        for (AssetVocabulary voc : vocs){ 
            //hostname = CompanyLocalServiceUtil.getCompany(voc.getCompanyId()).getVirtualHostname();
            selected = vocabularityId.equals(Long.toString(voc.getVocabularyId()));
            value = Long.toString(voc.getVocabularyId());
            if (!voc.getName().equals("Topic")) {
        %>
                <aui:option value="<%= value %>" selected="<%= selected %>"><%= voc.getName() %></aui:option><!--<%= value %>-->
        <%  }
        }
        %>
    </aui:select>

    <div id="<portlet:namespace />category" style="display: <%= (vocabularityId == null || vocabularityId=="") ? "none" : "" %>">
        <aui:select name="selectedCategory" label="selectedCategory" key="selectedCategory" showEmptyOption="true" id="assetCategory">
            <%
                Boolean selected=false;
                String value = "";
                for (AssetCategory assetCategory : assetCategories){
                    value = Long.toString(assetCategory.getCategoryId());

            %>
            <aui:option value="<%= value %>" selected="<%= String.valueOf(assetCategory.getCategoryId()).equals(selectedCategory) %>"><%= assetCategory.getTitle() %> </aui:option>
            <%
                }
            %>
        </aui:select>
    </div>
    <aui:input label="showOnlyVocabularityId" name="showOnlyVocabularityId" key="showOnlyVocabularityId" type="toggle-switch" value="<%= showOnlyVocabularityId %>"/>
    <aui:input label="maxEventsToShow" name="maxEventsToShow" key="maxEventsToShow" type="number" value="<%= maxEventsToShow %>"/>
    <aui:input label="numberOfColumn" name="numberOfColumn" key="numberOfColumn" type="number" value="<%= numberOfColumn %>"/>
    
    <span id="<portlet:namespace />form-settings">
    <h3><liferay-ui:message key="configuration-form-settings-header"/></h3>
    

    <aui:input label="showOtherInstances" name="showOtherInstances" key="showOtherInstances" type="toggle-switch" value="<%= showOtherInstances %>"/>

    <aui:input label="formDescription" name="formDescription" key="formDescription" type="text" value="<%= formDescription %>"/>

    <aui:input label="eventNotificationEmail" name="eventNotificationEmail" key="eventNotificationEmail" type="text" value="<%= eventNotificationEmail %>" helpMessage="email-info-text"/>

    <aui:input label="reviewRequired" name="reviewRequired" key="reviewRequired" type="toggle-switch" value="<%= reviewRequired %>"/>

    </span>
    <div id="<portlet:namespace />message-settings">
        <h3>
            <span><liferay-ui:message key="configuration-message-settings-header"/> </span>
            <div class="btn-group">
                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"  data-locale="<%= defaultLocale.getDisplayLanguage() %>"><%= defaultLocale.getDisplayLanguage() %> <span class="caret"></span></button>

                <ul class="dropdown-menu dropdown-menu-right">
                    <%
                        String language;
                        for (Locale usedLocale : currentUsedLocalization){
                            language = usedLocale.getDisplayLanguage();
                    %>
                    <li><a href="#"><%= language %></a></li>
                    <% } %>
                </ul>
            </div>
        </h3>

        <aui:input name="selectedLanguage" id="selectedLanguage" type="hidden" value="<%= defaultLocale.getDisplayLanguage() %>"/>
        <aui:input name="eventSuccessJson" id="eventSuccessMsgJson" type="hidden" value="<%= eventSuccessMsg %>"/>
        <aui:input label="eventSuccessMsg" name="eventSuccessMsg" key="eventSuccessMsg" id="eventSuccessMsg" type="text" value="<%= eventSuccessMsgVal %>"/>

        <aui:input name="eventPublishMsgJson" id="eventPublishMsgJson" type="hidden" value="<%= eventPublishMsg %>"/>
        <aui:input label="eventPublishMsg" name="eventPublishMsg" key="eventPublishMsg" id="eventPublishMsg" type="text" value="<%= eventPublishMsgVal %>"/>

        <aui:input name="eventAwaitingApprovalMsgJson" id="eventAwaitingApprovalMsgJson" type="hidden" value="<%= eventAwaitingApprovalMsg %>"/>
        <aui:input label="eventAwaitingApprovalMsg" name="eventAwaitingApprovalMsg" key="eventAwaitingApprovalMsg" id="eventAwaitingApprovalMsg" type="text" value="<%= eventAwaitingApprovalMsgVal %>"/>

        <aui:input name="eventUnderReviewMsgJson" id="eventUnderReviewMsgJson" type="hidden" value="<%= eventUnderReviewMsg %>"/>
        <aui:input label="eventUnderReviewMsg" name="eventUnderReviewMsg" key="eventUnderReviewMsg" id="eventUnderReviewMsg" type="text" value="<%= eventUnderReviewMsgVal %>"/>

        <aui:input name="portletTitleJson" id="portletTitleJson" type="hidden" value="<%= portletTitle %>"/>
        <aui:input label="portletTitle" name="portletTitle" key="portletTitle" id="portletTitle" type="text" value="<%= portletTitleVal %>"/>
    </div>


    <aui:button-row>
        <aui:button type="submit"></aui:button>
    </aui:button-row>
</aui:form>
</div>
</div>
