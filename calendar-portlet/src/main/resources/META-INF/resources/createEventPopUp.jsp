<%-- This view handles create and update even though it has prefix create. --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="fi.valamis.maakportal2.calendar.utils.AssetCategoryHierarchyOrderByComparator" %>
<%@ page import="java.util.*" %>
<%@ include file="init.jsp" %>

<%
    Event e = null;
    SimpleDateFormat date = null;
    SimpleDateFormat hours = null;
    String eventId = request.getParameter("eventId");
    String modifyEventRequestURL = PortalUtil.getLayoutURL(themeDisplay.getLayout(),themeDisplay) + "/-/kalenteri/ReplaceEventId/muokkaus";
    String vocid = portletPreferences.getValue("vocabularityId", "");
    String NEW_LINE = System.getProperty("line.separator");
    if (eventId != null) {
    	//System.out.println("Fetching event with id: " + eventId);
        e = EventLocalServiceUtil.getEvent(Long.parseLong(eventId));
        e.setDescription(e.getDescription().replace("<br>", NEW_LINE));
        date = new SimpleDateFormat("dd.MM.yyyy");
        hours = new SimpleDateFormat("HH.mm");
        modifyEventRequestURL = e.getUpdateUrl();
        if (!e.getCategoryIds().isEmpty() && vocid.equals("")) {
            ArrayList<String> cats = null;
            cats = new ArrayList<>(Arrays.asList(e.getCategoryIds().split(",")));
            try {
                // First category is category then its parent is VocabularityId
                AssetCategory pac = AssetCategoryLocalServiceUtil.getCategory(Long.parseLong(cats.get(0)));
                vocid = Long.toString(pac.getVocabularyId());
            }
            catch (Exception err) {
                // First category is not a category so it must be a VocabularityId :D!
                vocid = cats.get(0);
            }
        }
    }
    String reqStartingDate = (request.getParameter("startingDate") != null) ? request.getParameter("startingDate") : "";
    String reqStartingTime = (request.getParameter("startingTime") != null) ? request.getParameter("startingTime") : "";
    String reqEndingDate = (request.getParameter("endingDate") != null) ? request.getParameter("endingDate") : "";
    String reqEndingTime = (request.getParameter("endingTime") != null) ? request.getParameter("endingTime") : "";
    String itemSelectorURL = ParamUtil.getString(renderRequest, "itemSelectorURL");
    String notificationEmail = portletPreferences.getValue("eventNotificationEmail", null);
%>

<portlet:actionURL name="createEvent" var="createEventURL">
    <portlet:param name="updateURL" value="<%= modifyEventRequestURL %>"/>
    <portlet:param name="vocabularyId" value="<%= vocid %>"/>
    <portlet:param name="notificationEmail" value="<%= notificationEmail %>"/>
</portlet:actionURL>
<portlet:actionURL name="updateEvent" var="updateEventURL">
    <portlet:param name="updateURL" value="<%= modifyEventRequestURL %>"/>
    <portlet:param name="eventId" value="<%=e != null ? ""+e.getEventId() : ""%>"/>
    <portlet:param name="notificationEmail" value="<%= notificationEmail %>"/>
</portlet:actionURL>

<liferay-ui:error key="error-captcha-max-challenges" message="error-captcha-max-challenges"/>
<liferay-ui:error key="error-captcha-text" message="error-captcha-text"/>
<liferay-ui:error key="error-starting-date-after-ending-date" message="error-starting-date-after-ending-date"></liferay-ui:error>
<liferay-ui:error key="error-with-ending-date" message="error-with-ending-date"></liferay-ui:error>
<liferay-ui:error key="error-with-starting-date" message="error-with-starting-date"></liferay-ui:error>
<liferay-ui:error key="error-with-passwords-date" message="error-with-passwords-date"></liferay-ui:error>

<div class="createEventContainer">
    <%String formActionURL = e == null ? createEventURL : updateEventURL; %>
    <aui:form action="<%= formActionURL %>" method="post" name="fm">

        <% if (themeDisplay.isSignedIn() && fi.valamis.maakportal2.calendar.constants.CalendarPortletKeys.CalendarAdmin.equals(portletName)) { %>
        <div class="container-fluid adminCommentContainer">
            <div class="container-fluid card-horizontal main-content-card">
        <% } %>

        <h2 class="createEventHeader">
            <% if (e == null) { %>
                <liferay-ui:message key="event-data"/>
            <% } else { %>
                <liferay-ui:message key="event-data-modify"/>
            <% } %>
        </h2>
        
        <% if (!portletPreferences.getValue("formDescription", "").equals("")) { %>
        <p class="createEventInfoText"><%= portletPreferences.getValue("formDescription", "") %></p>
        <% } else { %>
        <p class="createEventInfoText"><liferay-ui:message key="event-create-info-nomod"/></p>
        <% } %>

        <aui:input label="eventName" name="eventName" type="text" value="<%=e != null ? e.getEventName() : ""%>">
            <aui:validator name="required"/>
            <aui:validator name="maxLength" errorMessage="maxLength">1000</aui:validator>
        </aui:input>
        <aui:input label="eventDescription" name="description" type="textarea" value="<%=e != null ? e.getDescription() : ""%>">
            <aui:validator name="required"/>
        </aui:input>
        <% if (themeDisplay.isSignedIn()) { %>
        <div class="eventImageContainer">
            <aui:input label="eventImage" name="eventImage" type="text" value="<%= e != null ? e.getImageUrl() : ""%>" />
            <button class="btn btn-default btn-primary" id="<portlet:namespace />chooseImage"
                    name="<portlet:namespace />chooseImage" type="button">
                <span class="lfr-btn-label">
                    <liferay-ui:message key="choose"/>
                </span>
            </button>
        </div>
        <% } %>
        <h3 id="event-times-header"><liferay-ui:message key="event-times-header"/></h3>
        <div class="event-timedate-container">
        <aui:fieldset >
            <aui:input class="field form-control required" inlineField="true" key="startingDate" label="startingDate" id="startingDate" name="startingDate" type="text" value="<%=e != null ? date.format(e.getStartingDate()) : reqStartingDate %>">
                <aui:validator errorMessage="" name="custom">
                    function(val, fieldNode, ruleValue) {
                        return dateRequired();
                    }
                </aui:validator>
            </aui:input>
            <i class="icon-calendar" aria-hidden="true"></i>

            <aui:input class="field form-control required" inlineField="true" key="startingTime" label="startingTime" id="startingTime" name="startingTime" type="text" value="<%=e != null ? hours.format(e.getStartingDate()) : reqStartingTime %>">
                <aui:validator errorMessage="" name="custom">
                    function(val, fieldNode, ruleValue) {
                        return dateRequired();
                    }
                </aui:validator>
            </aui:input>

            <div class="form-group" style="display: inline-block;line-height: 3em;">-</div>

            <aui:input class="field form-control" inlineField="true" key="endingDate" label="endingDate" id="endingDate" name="endingDate" type="text" value="<%=e != null ? date.format(e.getEndingDate()) : reqEndingDate %>">
                <aui:validator errorMessage="" name="custom">
                    function(val, fieldNode, ruleValue) {
                        return checkDateRange();
                    }
                </aui:validator>
            </aui:input>
            <i class="icon-calendar" aria-hidden="true"></i>

            <aui:input class="field form-control" inlineField="true" key="endingTime" label="endingTime" id="endingTime" name="endingTime" type="text" value="<%=e != null ? hours.format(e.getEndingDate()) : reqEndingTime %>">
                <aui:validator errorMessage="" name="custom">
                    function(val, fieldNode, ruleValue) {
                        return checkDateRange();
                    }
                </aui:validator>
            </aui:input>
        </aui:fieldset >
        </div>
        <div id="<portlet:namespace/>dateRequired" class="has-error" style="display: none;">
            <div class="form-validator-stack help-block">
                <div role="alert" class="required"><liferay-ui:message key="required-field"/></div>
            </div>
        </div>
        <div id="<portlet:namespace/>eventDateHelper" class="has-error" style="display: none;">
            <div class="form-validator-stack help-block">
                <div role="alert" class="required"><liferay-ui:message key="eventDatesOrder"/></div>
            </div>
        </div>

        <div class="">
            <label class="control-label"><liferay-ui:message key="event-repeats-every"/></label>
            <ul id="recurdates">
                <%
                if (e != null && !e.getAdditionalStartingDates().isEmpty()) {
                    String[] rdates = e.getAdditionalStartingDates().split(",");
                    System.out.println(rdates.length + " " + e.getAdditionalStartingDates());
                    String[] rdate = new String[3];
                    for (int i = 0; i < rdates.length; i++) {
                        rdate = rdates[i].split("-");
                    %><li class="recurdate">
                        <%= rdate[2].replaceAll("^0", "") + "." + rdate[1].replaceAll("^0", "") + "." + rdate[0] %>
                        <a class="recurdateDelete"><i class="icon icon-remove-sign" aria-hidden="true"></i></a>
                        <input name="<portlet:namespace/>recurranceDates" type="hidden" value="<%= rdates[i] %>">
                    </li><% 
                    }
                }
                %><li class="recurdateAdd"><a id="<portlet:namespace/>addRecurringDate"><liferay-ui:message key="Add-date"/><i class="icon-calendar" aria-hidden="true"></i></a></li>
            </ul>
        </div>
        <aui:input label="datesAdditionalInfo" name="datesAdditionalInfo" type="textarea" value="<%=e != null ? e.getAdditionalInformation() : ""%>"></aui:input>

        <h3 id="event-location-header"><liferay-ui:message key="event-location-header"/></h3>
        <aui:input label="location" name="location" type="text" value="<%= e != null ? e.getLocation() : ""%>">
            <aui:validator name="required"/>
            <aui:validator name="maxLength" errorMessage="maxLength">75</aui:validator>
        </aui:input>
        <%
            String address = "";
            String postalCode = "";
            String city = "";
            if (e != null) {
                if (e.getAddress().lastIndexOf(",") > -1) {
                    String[] adrList = e.getAddress().split(",");
                    if (adrList.length == 3) {
                        address = adrList[0].trim();
                        postalCode = adrList[1].trim();
                        city = adrList[2].trim();
                    } else {
                        address = adrList[0];
                        String[] lastp = adrList[adrList.length-1].trim().split(" ");
                        if (lastp.length == 2) {
                            postalCode = lastp[0];
                            city = lastp[1];
                        } else {
                            postalCode = "";
                            city = lastp[0];
                        }
                    }
                } else {
                    address = e.getAddress();
                }
            }
        %>
        <div class="addressContainer">
            <div class="addressInnerContainer">
                <aui:input label="address" name="address" type="text" value="<%=address%>">
                </aui:input>
            </div>
            <aui:input label="postalCode" name="postalCode" type="text" value="<%=postalCode%>">
                <aui:validator name="digits" />
            </aui:input>
            <aui:input label="city" name="city" type="text" value="<%=city%>"></aui:input>
            
            <div class="showMapContainer">
                <% if (e != null && e.getShowMap()) { %>
                <aui:input id="showMapToggle" checked="true" value="true" class="checkbox" key="show-map" name="showMap" type="toggle-switch"></aui:input>
                <% } else { %>
                <aui:input id="showMapToggle" class="checkbox" key="show-map" name="showMap" type="toggle-switch"></aui:input>
                <% } %>
            </div>
            <div id="eventMapContainer" style="display: <%= (e != null && e.getShowMap()) ? "" : "none" %>;">
                <% 
                String mapurl = "";
                if (e != null && e.getShowMap()) {
                    mapurl = "https://www.google.com/maps/embed/v1/place?q=" + URLEncoder.encode(e.getAddress(), "UTF-8").replace("+","%20") + "&key=";
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
        </div>
        
        <h3 id="sign-up-header"><liferay-ui:message key="sign-up-header"/></h3>
        <p id="sign-up-info"><liferay-ui:message key="sign-up-info"/></p>
        <aui:input label="signUpLink" name="signUpLink" type="text" value="<%=e != null ? e.getSignUpLink() : ""%>">
            <aui:validator name="maxLength" errorMessage="maxLength">1000</aui:validator>
        </aui:input>
        
        <aui:input label="linkToEventWebPage" name="linkToEventWebPage" type="text" value="<%=e != null ? e.getLinkToEventWebPage() : ""%>">
            <aui:validator name="maxLength" errorMessage="maxLength">1000</aui:validator>
        </aui:input>
        <aui:input label="additionalInformation" name="additionalInformation" type="textarea" value="<%=e != null ? e.getAdditionalInformation() : ""%>">
        </aui:input>

        <%
        ArrayList<String> catIds = null;
        if (e != null && e.getCategoryIds() != null && !e.getCategoryIds().isEmpty()) {
            catIds = new ArrayList<>(Arrays.asList(e.getCategoryIds().split(",")));
        }
        if(!vocid.equals("")){ 
            List<AssetCategory> vocCatsUnmodifiable = AssetCategoryLocalServiceUtil.getVocabularyCategories(Long.parseLong(vocid),
                    0, AssetCategoryLocalServiceUtil.getAssetCategoriesCount(), null);
            List<AssetCategory> vocCats = new ArrayList<>(vocCatsUnmodifiable);
            Collections.sort(vocCats, new AssetCategoryHierarchyOrderByComparator());
            if(!vocCats.isEmpty()){ 
        %>
            <div class="categoriesContainer">
                <h3><liferay-ui:message key="event-categories"/></h3>
                <fieldset class="categoryGroup">
                    <div class="categoryCheckboxContainer">
                        <aui:input name="assetCategories" type="hidden" value="<%= vocid %>" />
                        <% for (AssetCategory ac : vocCats) { %>
                            <%if (catIds != null && catIds.contains(String.valueOf(ac.getCategoryId()))) {%>
                                <div class="checkbox <%=ac.getParentCategoryId() == 0 ? "" : " childCategory"%>">
                                <aui:input checked="true" class="checkbox" id="<%=""+ac.getCategoryId() %>" type="checkbox" value="<%=ac.getCategoryId() %>" name="assetCategories" label="<%= ac.getName() %>"></aui:input>
                                </div>
                            <% } else { %>
                                <div class="checkbox <%=ac.getParentCategoryId() == 0 ? "" : " childCategory"%>">
                                <aui:input class="checkbox" id="<%=""+ac.getCategoryId() %>" type="checkbox" value="<%=ac.getCategoryId() %>" name="assetCategories" label="<%= ac.getName() %>"></aui:input>
                                </div>
                            <% } %>
                        <% } %>
                    </div>
                </fieldset>
            </div>
        <% }} %>

        <% if (showOtherInstances == null || showOtherInstances.equals("false") || isAdmin) { %>
		<div class="additionalCities">
			<fieldset class="group">
			<h3><liferay-ui:message key="additional-cities-selection"/></h3>
			    <p id="visible-to-admins"><liferay-ui:message key="additional-cities-information"/></p>
				<div class="cityCheckboxContainer">
				<% 
                for(Company c : companiesToShow){ 
                    if(c.getCompanyId() == themeDisplay.getCompanyId()){ 
                        // Current instance
				    } else if(e != null && e.getAdditionalCompanyIds() != null) {
					   if(e.getAdditionalCompanyIds().contains(String.valueOf(c.getCompanyId()))){ %>
						   <div class="checkbox">
					           <aui:input checked="true" class="checkbox" id="<%=""+c.getCompanyId() %>" type="checkbox" value="<%=c.getCompanyId() %>" name="checkBox" label="<%= c.getWebId() %>"></aui:input>
					       </div>
						<%} else { %>
						    <div class="checkbox">
						        <aui:input class="checkbox" type="checkbox" id="<%=""+c.getCompanyId() %>" value="<%=c.getCompanyId() %>" name="checkBox" label="<%= c.getWebId() %>"></aui:input>
						    </div>
						<% } %>
					<% } else { %>
						<div class="checkbox">
						    <aui:input class="checkbox" type="checkbox" id="<%=""+c.getCompanyId() %>" value="<%=c.getCompanyId() %>" name="checkBox" label="<%= c.getWebId() %>"></aui:input>
						</div>
					<% } %>
				<% } %>
				</div>
			</fieldset>
		</div>
        <% } %>

		<% if(!fi.valamis.maakportal2.calendar.constants.CalendarPortletKeys.CalendarAdmin.equals(portletName) || !themeDisplay.isSignedIn()) {%>
        <h3><liferay-ui:message key="author-data"/></h3>
        <p id="visible-to-admins"><liferay-ui:message key="data-only-visible-to-admins"/></p>
        <aui:input label="eventAuthorName" name="eventAuthorName" type="text" value="<%= e != null ? e.getEventAuthorName() : "" %>">
            <aui:validator name="required"/>
            <aui:validator name="maxLength" errorMessage="maxLength">75</aui:validator>
        </aui:input>
        <aui:input label="eventAuthorEmail" name="eventAuthorEmail" type="text" value="<%= e != null ? e.getEventAuthorEmail() : "" %>">
            <aui:validator name="required"/>
            <aui:validator name="maxLength" errorMessage="maxLength">75</aui:validator>
            <aui:validator name="email" />
        </aui:input>
        <aui:input label="eventAuthorPhoneNumber" name="eventAuthorPhoneNumber" type="text" value="<%= e != null ? e.getEventAuthorPhoneNumber() : "" %>">
            <aui:validator name="required"/>
            <aui:validator name="maxLength" errorMessage="maxLength">75</aui:validator>
        </aui:input>

        <% if (e == null) {%>
        <aui:input label="event-password" name="password" type="password" value="<%= e != null ? e.getUserGivenPassword() : request.getParameter("password") %>">
            <aui:validator name="required"/>
            <aui:validator name="maxLength" errorMessage="maxLength">75</aui:validator>
        </aui:input>
        <aui:input label="passwordConfirm" name="passwordConfirm" type="password" value="<%= e != null ? e.getUserGivenPassword() : request.getParameter("passwordConfirm") %>">
            <aui:validator name="required"/>
            <aui:validator name="maxLength" errorMessage="maxLength">75</aui:validator>
        </aui:input>

        <portlet:resourceURL var="captchaURL"/>
        <div class="captchaContainer">
            <liferay-captcha:captcha url="<%= captchaURL %>"/>
        </div>
        <% } %>

            <aui:button-row>
                <aui:button cssClass="sendButton koristeBackground koristeViiva pull-right" id="<portlet:namespace/>submitbutton" type="submit" value="submit"/>
            </aui:button-row>
		<% } else { %>

            </div><!-- container-fluid card-horizontal main-content-card -->
        </div><!-- container-fluid adminCommentContainer -->
        <aui:container cssClass="adminCommentContainer">
            <aui:button-row>
                <aui:button id="<portlet:namespace/>submitbutton" type="submit" value="submit"/>
                <aui:button onClick="javascript:history.back()" type="cancel" value="cancel" key="cancel"/>
            </aui:button-row>
        </aui:container>
        <% } %>
    </aui:form>
</div>

<aui:script>
    var fromDatePicker;
    AUI().use(
        'aui-datepicker',
        'datatype-date',
        'datatype-date-math',
        'datatype-date-parse',
        function(A) {

            // Add this only when locale is Finnish, find a reliable way to detect it
            A.Intl.add("calendar-base", "fi_FI", {
                very_short_weekdays: ["Su", "Ma", "Ti", "Ke", "To", "Pe", "La"],
                first_weekday: 1,
                weekends: [0, 6]
            });
            A.Intl.setLang("calendar-base", "fi_FI");

            fromDatePicker = new A.DatePicker({
                trigger: '#<portlet:namespace/>startingDate',
                mask: '%d.%m.%Y',
                popover: {
                    zIndex: 9000
                },
                calendar: {
                    minimumDate: new Date()
                },
                on: { selectionChange: function(e) {
                    toDatePicker.getCalendar().set('minimumDate', e.newSelection[0]);
                    recuDatePicker.getCalendar().set('minimumDate', e.newSelection[0]);
                    checkDateRange(e);
                    } 
                }
            });
        }
    );

    var toDatePicker;
    AUI().use(
        'aui-datepicker',
        'datatype-date',
        'datatype-date-math',
        'datatype-date-parse',
        function(A) {
            toDatePicker = new A.DatePicker({
                trigger: '#<portlet:namespace/>endingDate',
                mask: '%d.%m.%Y',
                popover: {
                    zIndex: 9000
                },
                calendar: {
                    minimumDate: new Date()
                },
                on: { selectionChange: checkDateRange }
            });
        }
    );

    var fromTimePicker;
    AUI().use(
        'aui-timepicker',
        function(Y) {
            fromTimePicker = new Y.TimePicker({
                trigger: '#<portlet:namespace/>startingTime',
                mask: '%H.%M',
                popover: {
                    zIndex: 9000
                },
                on: { selectionChange: checkDateRange }
            });
        }
    );

    var toTimePicker;
    AUI().use(
        'aui-timepicker',
        function(Y) {
            toTimePicker = new Y.TimePicker(
            {
                trigger: '#<portlet:namespace/>endingTime',
                mask: '%H.%M',
                popover: {
                    zIndex: 9000
                },
                on: { selectionChange: checkDateRange }
            });
        }
    );
    
    var recuDatePicker;
    AUI().use(
        'aui-datepicker',
        'datatype-date',
        'datatype-date-math',
        'datatype-date-parse',
        function(A) {
            recuDatePicker = new A.DatePicker({
                trigger: '#<portlet:namespace/>addRecurringDate',
                mask: '%d.%m.%Y',
                popover: {
                    zIndex: 9000
                },
                calendar: {
                    minimumDate: new Date()
                },
                on: { selectionChange: addRecurdate }
            });
        }
    );

    $(document).on("click", "#recurdates .recurdate .recurdateDelete", function() {
        $(this).parent().remove();
    });
    function addRecurdate(e) {
        var newDate = e.newSelection[0];
        var formatedDate = newDate.getUTCDate() + "." + (newDate.getUTCMonth()+1) + '.' + newDate.getUTCFullYear();
        var dateValue = newDate.getUTCFullYear() + '-' + ('0'+(newDate.getUTCMonth()+1)).slice(-2) + '-' + ('0'+newDate.getUTCDate()).slice(-2);
        var tag = '<li class="recurdate revealstart">'+formatedDate+'<a class="recurdateDelete"><i class="icon icon-remove-sign" aria-hidden="true"></i></a><input name="<portlet:namespace/>recurranceDates" type="hidden" value="'+dateValue+'"></li>';
        $('#recurdates .recurdateAdd').before(tag);
        $('#recurdates .recurdate').removeClass('revealstart');
    }

    /**
    * Date range validator
    */
    function checkDateRange(e) {
        var startingDate = $('#<portlet:namespace/>startingDate').val().split('.');
        var startingTime = $('#<portlet:namespace/>startingTime').val().split('.');
        var endingDate = $('#<portlet:namespace/>endingDate').val().split('.');
        var endingTime = $('#<portlet:namespace/>endingTime').val().split('.');
        startingDate = (startingDate.length == 3) ? startingDate : new Array('0000','00','00');
        startingTime = (startingTime.length == 2) ? startingTime : new Array('00','00');
        var start = new Date(startingDate[2],startingDate[1]-1,startingDate[0],startingTime[0],startingTime[1],"00");
        var end = new Date(endingDate[2],endingDate[1]-1,endingDate[0],endingTime[0],endingTime[1],"00");
        if (start <= end || $('#<portlet:namespace/>endingDate').val() == '') {
            $('#<portlet:namespace/>eventDateHelper').hide();
            return true;
        } else {
            $('#<portlet:namespace/>eventDateHelper').show();
            return false;
        }
    }

    /**
    * Date custom required
    */
    function dateRequired(e) {
        if ($('#<portlet:namespace/>startingDate').val() == '' || $('#<portlet:namespace/>startingTime').val() == '') {
            $('#<portlet:namespace/>dateRequired').show();
            return false;
        } else {
            $('#<portlet:namespace/>dateRequired').hide();
            return true;
        }
    }

    /**
    * Recurrance
    */
    $('#<portlet:namespace/>useRecurranceRulesToggle').click(
        function(event) {
            var container = $('#recurranceRulesContainer');
            if (!$('#<portlet:namespace/>useRecurranceRulesToggle').is(':checked')) {
                container.hide('fast');
            } else {
                checkDateRange();
                container.show('fast');
            }
        }
    );

    /**
    * Event Address Map
    */
    $('#<portlet:namespace/>showMapToggle').click(
        function(event) {
            var container = $('#eventMapContainer');
            if (!$('#<portlet:namespace/>showMapToggle').is(':checked')) {
                container.hide('fast');
            } else {
                container.show('fast',changeIframeUrl());
            }
        }
    );
    $('#<portlet:namespace/>address').change(changeIframeUrl);
    $('#<portlet:namespace/>postalCode').change(changeIframeUrl);
    $('#<portlet:namespace/>city').change(changeIframeUrl);
    var googleMapsApiKey = '';
    function changeIframeUrl(e) {
        var address = $('#<portlet:namespace/>address').val() +','+ $('#<portlet:namespace/>postalCode').val() +','+ $('#<portlet:namespace/>city').val() +',Finland';
        var attribSrc = $('#<portlet:namespace/>linkToEventWebPage').val();
        var iframe = $('#eventMapIframe');
        var mapurl = 'https://www.google.com/maps/embed/v1/place?q='+encodeURIComponent(address)+'&attribution_source='+attribSrc+'&key='+googleMapsApiKey;
        if ( iframe.length ) {
            iframe.attr('src',mapurl);
        }
    }

</aui:script>
<aui:script use="liferay-item-selector-dialog">
    $(document).ready(function() {
        $('#<portlet:namespace/>chooseImage').on(
            'click',
            function(event) {
                var itemSelectorDialog = new A.LiferayItemSelectorDialog({
                    eventName: 'selectItem',
                    on: {
                        selectedItemChange: function(event) {
                            var selectedItem = event.newVal;
                            if (selectedItem) {
                                var itemValue = JSON.parse(selectedItem.value);
                                itemSrc = itemValue.url;
                                document.getElementById("<portlet:namespace/>eventImage").value = itemSrc;
                            }
                        }
                    },
                    title: '<liferay-ui:message key="select-image"/>',
                    url: '<%= itemSelectorURL.toString() %>'
            });
            console.log(itemSelectorDialog);
            itemSelectorDialog.open();
        });
    });

</aui:script>
<script>
    window.onload = function () {
        jQuery(".captcha-reload").click(function (e) {
            e.preventDefault();
            jQuery(".captcha").attr("src", jQuery(".captcha").attr("src") + "&force=" + new Date().getMilliseconds());
            return false;
        });
    }
</script>
