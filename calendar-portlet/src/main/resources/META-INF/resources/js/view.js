var init_events_view = function(settings) {
    var defaultImgUrl = settings.defaultImageUrl ? settings.defaultImageUrl : "";
    var selectedMonth = getCurrentMonth();
    var selectedYear = getCurrentYear();
    var selectedDate= new Date();
    selectedDate = setTimeToZero(selectedDate);
    var eventDataArr = [];
    var pageNumber = 0;
    var eventTitleDate=null;
    var numOfColms = calculateTotalColumns();
    var INIT_ACTION ="INIT_ACTION";
    var MONTH_CHANGE_ACTION="MONTH_CHANGE_ACTION";
    var DAY_CHANGE_ACTION="DAY_CHANGE_ACTION";
    var activeAction = INIT_ACTION;
    var companyId= themeDisplay.getCompanyId();
    //function to get active month
    function getCurrentMonth() {
        var today = new Date();
        return today.getMonth() + 1;
    }

    function getCurrentYear() {
        var today = new Date();
        return parseInt(today.getFullYear().toString());
    }
    function getMonthFromDate(date) {
        var givenDate = new Date(date);
        return givenDate.getMonth() + 1;
    }

    function getYearFromDate(date) {
        var givenDate = new Date(date);
        return parseInt(givenDate.getFullYear().toString());
    }

    function eventURL(eventId, eventFriendlyName) {
        var url = settings.eventFriendlyUrl + eventId + '/' + 'view';
        if (eventFriendlyName != '') {
            url = settings.eventFriendlyUrl + eventFriendlyName;
        }
        return url;
    }

    function maxEventsToShow() {
        var value = settings.maxEventsToShow;
        var isValueAnInteger = Number.isInteger = Number.isInteger || function(anyValue) {
            return typeof anyValue === "number" &&
                isFinite(anyValue) &&
                Math.floor(anyValue) === anyValue;
        };
        if (value.length > 0 && isValueAnInteger) {
            return value * 1;
        } else {
            return Number.MAX_VALUE;
        }
    }

    function loadEventsWithDate(date, action) {
        var dateToDisplay = date;
        var filter = "null";
        if (settings.showOnlyVocabularityId && settings.vocabularityId !== '' && getSelectedCategory() === "null") {
            filter = settings.vocabularityId;
        }
        $.getJSON('/o/event-rest/events/withDate/' + companyId + '/' + formatDateForRest(date) + '/' + getSelectedCategory() + '/' + filter, function (data) {
            data = preProcessData(data, action);
            eventDataArr = data;
            displayEvents(data, dateToDisplay);
        });
    }

    //function to print html content for events
    function displayEvents(data, date) {
        eventTitleDate = date;
        document.getElementById("eventsList").innerHTML =  "";
        var loopIndex = 0;
        for (var key in data) {
            if (loopIndex >= maxEventsToShow()) {
                break;
            }
            if (data.hasOwnProperty(key)) {
                var calEvent = data[key];
                    if (settings.mainCalendarPage) {
                        getEventCategories(calEvent.eventId, formatDate(calEvent.startingDate));
                    }
                    var content = prepareCalendarContent(calEvent, calEvent.startingDate);
                    document.getElementById("eventsList").innerHTML = document.getElementById("eventsList").innerHTML + content;
                loopIndex++;
            }
        }
        document.getElementById("eventsList").innerHTML = '<h2>' + formatDate(date) + ' - </h2> <div class="row">' + document.getElementById("eventsList").innerHTML + "</div>";
    }

    function loadDayEvents(date, action) {
        var sod = new Date(date);
        var eod = new Date(date);
        eod.setHours(23);
        eod.setMinutes(59);
        var filter = "null";
        if (settings.showOnlyVocabularityId && settings.vocabularityId != '' && getSelectedCategory() == "null") {
            filter = settings.vocabularityId;
        }
        $.getJSON('/o/event-rest/events/withMonth/' + companyId + '/' + formatDateForRest(sod) + '/' + formatDateForRest(eod) + '/' + getSelectedCategory() + '/' + filter, function (data) {
           data = preProcessData(data, action);
           eventDataArr = data;
           togglePageBtn();
           displayEvents(data, sod);
        });
    }

    function formatDate(date) {
        var date = new Date(date);
        return ('0' + date.getUTCDate()).slice(-2) + '.'
            + ('0' + (date.getUTCMonth() + 1)).slice(-2) + '.'
            + date.getUTCFullYear();
    }

    function formatTime(date) {
        var date = new Date(date);
        var pad = (date.getUTCMinutes().toString().length == 1) ? '0' : '';
        return date.getUTCHours() + '.' + pad + date.getUTCMinutes();
    }

    function formatDateForRest(date) {
        var d = date.getUTCDate();
        var m = date.getUTCMonth() + 1;
        var y = date.getUTCFullYear();
        return '' + y + "-" + m + "-" + d;
    }

    function initCalendar(resetDate) {
        var date = new Date();
        document.getElementById("eventsList").innerHTML = "";
        if (!resetDate) {
            if (cal._getSelectedDatesList()[0]) {
                loadDayEvents(cal._getSelectedDatesList()[0]);
                return;
            }
        }
        loadEventsWithDate(date);
    }

    function getSelectedCategory() {
        var selectedCategory = "null";
        //if showOnlyVocabularyId is enabled in portlet setting
        if(settings.showOnlyVocabularityId===true) {
            selectedCategory = settings.selectedCategory? settings.selectedCategory: "null";
        } else {
            if ($("#assetCategorySelector").val()) {
                selectedCategory = $("#assetCategorySelector").val();
            }
        }

        return selectedCategory;
    }

    function getEventCategories(eventId, startingDate) {
        $.getJSON("/o/event-rest/events/eventCategories/" + eventId, function (data) {
            var html = '<span class="cat">' + data.join('</span><span class="cat">') + '</span>';
            var elm = document.getElementById("eventCats_" + eventId + startingDate);
            elm.innerHTML = html;
        });
    }

    function isSameDate(dateToCompate, dateToCompareWith) {
        return (dateToCompate.getFullYear() === dateToCompareWith.getFullYear()
            && dateToCompate.getMonth() === dateToCompareWith.getMonth()
            && dateToCompate.getDate() === dateToCompareWith.getDate());
    }

    function setTimeToZero(date) {
        date.setHours(0);
        date.setMinutes(0);
        date.setSeconds(0);
        return date;
    }

    function preProcessData(data, action) {
        var newDataList = [];
        for (var key in data) {
            if (data.hasOwnProperty(key)) {
                var calEvent = data[key];
                var startDate = new Date(calEvent.startingDate);
                var endingDate = new Date(calEvent.endingDate);
                switch (action) {
                    case DAY_CHANGE_ACTION:
                        //if start date is same as selected date
                        if (isSameDate(startDate, selectedDate)) {
                            newDataList.push(calEvent);
                        }
                        //Event goes to the list, if the selected date falls in between of start and end of the event.
                        if (selectedDate.getTime() >= startDate.getTime() && selectedDate.getTime() <= endingDate.getTime()) {
                            //var newCalEvent = Object.assign({}, calEvent);
                            var newCalEvent = $.extend({}, calEvent);
                            var tempDate = new Date(selectedDate);
                            tempDate.setHours(startDate.getHours());
                            tempDate.setMinutes(startDate.getMinutes());
                            tempDate.setSeconds(startDate.getSeconds());
                            newCalEvent.startingDate = tempDate;
                            newDataList.push(newCalEvent);
                        }
                        break;
                    case MONTH_CHANGE_ACTION:
                    case INIT_ACTION:
                    default:
                        //condition for future events
                        if (startDate.getTime() >= selectedDate.getTime()) {
                            newDataList.push(calEvent);
                        }
                        newDataList = addEventsBeforeEndingDate(newDataList, calEvent);
                }

                if (calEvent.additionalStartingDates) {
                    newDataList = (getAdditionalDateEvents(calEvent, newDataList, action));
                }
            }
        }
        // sorting the events according to starting date (ascending)
        newDataList.sort(function(a,b){
            return ((new Date(a.startingDate).getTime()>=new Date(b.startingDate).getTime())?1:-1);
        });
        // removing duplicate records, if any
        newDataList = newDataList.filter(function (nextObj, index, self) {
            var newIndex;
            for (var i = 0; i < self.length; ++i) {
                if (new Date(self[i].startingDate).getTime() === new Date(nextObj.startingDate).getTime() && self[i].eventName === nextObj.eventName) {
                    newIndex = i;
                    break;
                }
            }
            return (newIndex === index);
        });
        return newDataList;
    }

    function getAdditionalDateEvents(calEvent, newDataList, action) {
        var additionalDatesArr = calEvent.additionalStartingDates.split(",");
        var startingDate = new Date(calEvent.startingDate);
        for (var i = 0; i < additionalDatesArr.length; i++) {
            var additionalDateToCompate = new Date(additionalDatesArr[i]);
            additionalDateToCompate.setHours(startingDate.getHours());
            additionalDateToCompate.setMinutes(startingDate.getMinutes());
            additionalDateToCompate.setSeconds(startingDate.getSeconds());
            switch (action) {
                case DAY_CHANGE_ACTION:
                    if(isSameDate(additionalDateToCompate,selectedDate)) {
                        newDataList = addToNewDataList(newDataList, calEvent, additionalDatesArr[i]);
                    }
                    break;
                case MONTH_CHANGE_ACTION:
                    if(additionalDateToCompate.getMonth()===selectedDate.getMonth() && additionalDateToCompate.getFullYear()===selectedYear)
                        newDataList = addToNewDataList(newDataList, calEvent, additionalDatesArr[i]);
                    break;
                case INIT_ACTION:
                default:
                    if (additionalDateToCompate.getTime() >= selectedDate.getTime()) {
                        newDataList = addToNewDataList(newDataList, calEvent, additionalDatesArr[i]);
                    }
            }

        }
        return newDataList;
    }

    function addToNewDataList(newDataList, calEvent, additionalDate) {
        //var newCalEvent = Object.assign({}, calEvent);
        var newCalEvent = $.extend({}, calEvent);
        var startDate = new Date(newCalEvent.startingDate);
        var addedDate = new Date(additionalDate);
        addedDate.setHours(startDate.getHours());
        addedDate.setMinutes(startDate.getMinutes());
        addedDate.setSeconds(startDate.getSeconds());
        newCalEvent.startingDate = addedDate;
        newDataList.push(newCalEvent);
        return newDataList;
    }
    // Suppose an event is created having start date Jan 1st 2019 with end date Jan 19th 2019.
    // Thus, calendar should mark and show same event from Jan 1st to Jan 19th with respective date.
    // Therefore, this function creates new events in between of those dates, because when fetching
    // the event from API, it only brings back sing record for this kind of event.
    function addEventsBeforeEndingDate(newDataList, calEvent) {
        var startDate = new Date(calEvent.startingDate);
        var endingDate = new Date(calEvent.endingDate);
        if (selectedDate.getTime() <= endingDate.getTime()) {
            for (var d = startDate; d < endingDate; d.setDate(d.getDate() + 1)) {
                newDataList.push(createNewCalEvent(d, startDate, calEvent));
            }
        }
        newDataList = newDataList.filter(function (obj) {
           var startDate = new Date(obj.startingDate);
           return !(startDate.getTime()<selectedDate.getTime());
        });
        return newDataList;
    }
    // create a new event object from old event.
    function createNewCalEvent(newStartDate, oldStartDate, calEvent) {
        //var newCalEvent = Object.assign({}, calEvent);
        var newCalEvent = $.extend({}, calEvent);
        var tempDate = new Date(newStartDate);
        tempDate.setHours(oldStartDate.getHours());
        tempDate.setMinutes(oldStartDate.getMinutes());
        tempDate.setSeconds(oldStartDate.getSeconds());
        newCalEvent.startingDate = tempDate;
        return newCalEvent;
    }
    // This is used in href
    function loadCalendarEvents(date, action) {
        var filter = "null";
        if (settings.showOnlyVocabularityId && settings.vocabularityId != '' && getSelectedCategory() == "null") {
            filter = settings.vocabularityId;
        }
        var searchEndDate = new Date(date);
        switch (action) {
            case MONTH_CHANGE_ACTION:
                searchEndDate.setMonth(searchEndDate.getUTCMonth() + 1); // advance 1 month
                searchEndDate.setDate(searchEndDate.getUTCDate() - 1); // go back 1 day so we get last day of the month
                break;
            case INIT_ACTION:
            default:
                searchEndDate.setMonth(11); // setting month to december when calendar is initialized
                searchEndDate.setDate(31); // to get event till last day of december
        }
        var defer = jQuery.Deferred();
        $.getJSON('/o/event-rest/events/withMonth/' + companyId + '/' + formatDateForRest(date) + '/' + formatDateForRest(searchEndDate) + "/" + getSelectedCategory() + '/' + filter, function (data) {
            data = preProcessData(data, action);
            eventDataArr = data;
            initPageBtn();
            displayEvents(data, date);
            var rules = {};
            var monthlastday = new Date(searchEndDate.getUTCFullYear(), searchEndDate.getUTCMonth() + 1, 1);
            for (var i = 0; i < data.length; i++) {
                // blah blah
                var start = new Date(data[i].startingDate);
                var end = new Date(data[i].endingDate);
                if (monthlastday < end) {
                    // if the end date is gt month last day use trim it
                    end = monthlastday;
                }
                rules = addEnabledDateRule(start, rules);
                for (var d = start; d < end; d.setUTCDate(d.getUTCDate() + 1)) {
                    rules = addEnabledDateRule(new Date(d), rules);
                }
                var addiDates = data[i].additionalStartingDates.split(',');
                for (var c = 0; c < addiDates.length; c++) {
                    var cd = new Date(addiDates[c]);
                    if (cd.getUTCMonth() == searchEndDate.getUTCMonth() && cd.getUTCFullYear() == searchEndDate.getUTCFullYear()) { 
                        rules = addEnabledDateRule(new Date(addiDates[c]), rules);
                    }
                }
            }

            function addEnabledDateRule(date, rules) {
                var year = date.getUTCFullYear(),
                    month = date.getUTCMonth(),
                    day = date.getUTCDate();
                if (rules[year] === undefined) {
                    rules[year] = {};
                }
                if (rules[year][month] === undefined) {
                    rules[year][month] = {};
                }
                rules[year][month][day] = "Event";
                return rules;
            }

            defer.resolve(rules);
        });

        return defer;
    }

    var cal = null;
    function initCalendarDefer() {
        var defer = jQuery.Deferred();
        if(settings.showCalendar || settings.mainCalendarPage) {
            // { lang: "fi" }
            YUI().use('calendar', 'datatype-date', 'cssbutton', function (Y) {
                
                // Add this only when locale is Finnish, find a reliable way to detect it
                Y.Intl.add("calendar-base", "fi_FI", {
                    very_short_weekdays: ["Su", "Ma", "Ti", "Ke", "To", "Pe", "La"],
                    first_weekday: 1,
                    weekends: [0, 6]
                });
                Y.Intl.setLang("calendar-base", "fi_FI");
                
                cal = new Y.Calendar({
                    contentBox: "#eventCalendar",
                    width: '100%',
                    showPrevMonth: true,
                    showNextMonth: true,
                    date: new Date(),
                    tabIndex: 0
                });

                cal.on("selectionChange", function (ev) {
                    var newDate = ev.newSelection[0];
                    if (newDate) {
                        pageNumber = 0;
                        togglePageBtn();
                        loadDayEvents(Y.DataType.Date.format(newDate), DAY_CHANGE_ACTION);
                        activeAction = DAY_CHANGE_ACTION;
                        selectedDate = new Date(newDate);
                        selectedDate = setTimeToZero(selectedDate)
                    }
                });

                // Month changed.
                cal.after("dateChange", function (e) {
                    pageNumber = 0;
                    togglePageBtn();
                    if (cal.getAttrs().selectedDates) {
                        cal.deselectDates();
                    }
                    selectedDate = new Date(e.newVal);
                    selectedDate = setTimeToZero(selectedDate);
                    selectedMonth = selectedDate.getMonth() + 1;
                    selectedYear = parseInt(selectedDate.getFullYear().toString());
                    loadCalendarEvents(new Date(e.newVal), MONTH_CHANGE_ACTION).done(loadCalendarEventsDone);
                    activeAction = MONTH_CHANGE_ACTION;
                });
                defer.resolve();
            });
        }
        return defer;
    }

    function loadCalendarEventsDone(rules) {
        cal.set("customRenderer", {
            rules: rules,
            filterFunction: function (_date, node, _rules) {
                node.addClass("highlight");
            }
        });
        cal.render();
        window.cal = cal;
        // tune up the header
        $(".yui3-calendar-header-label")
        .attr('tabindex', '0')
        .attr('aria-role', 'button')
        .html('<a tab>' + $(".yui3-calendar-header-label").html() +'</a>')
        .on('click', function () {
            cal.deselectDates();
            loadCalendarEvents(cal.getAttrs().date).done(loadCalendarEventsDone);
        });

    }

    function prepareCalendarContent(calEvent, startingDate) {
        var imageUrl = calEvent.imageUrl ? calEvent.imageUrl : defaultImgUrl;
        var content = '<div class="col-md-'+numOfColms +' col-sm-12 col-xs-12 margin-bottom-15 padding-left-0">';
        content += '<a class="eventLink" href="' + eventURL(calEvent.eventId, calEvent.eventFriendlyName) + '">';
        if (settings.showEventImage && imageUrl) {
            content += '<div class="eventImgContainer" style="background-image: url(\'' + imageUrl + '\');"></div>';
        }
        content += '<h3 class="fphlseTitle"><font style="vertical-align: inherit;">';
        content += '<font style="vertical-align: inherit;">' + formatDate(startingDate) + ' ' + settings.timestring + ' ' + formatTime(calEvent.startingDate) + '</font></font></h3></a>';
        content += '<a class="eventLink" href="' + eventURL(calEvent.eventId, calEvent.eventFriendlyName) + '">';
        content += '<font style="vertical-align: inherit;">';
        content += '<font style="vertical-align: inherit;">' + calEvent.eventName + '</font></font></a>';
        content += '<span class="eventCategories" id="eventCats_' + calEvent.eventId + formatDate(startingDate) + '"></span>';
        content += '</div>';
        return content;
    }

    function calculateTotalColumns() {
        var col = 1; //default column  in bootstrap grid format
        if(settings.numberOfColumn)  {
            col = (parseInt(settings.numberOfColumn) !=0) ?parseInt(settings.numberOfColumn) : 1;
            if(col<=0 || col>12) {
                col = 1;
            }
        }

        if(settings.showCalendar || settings.mainCalendarPage) {
            col-=1
        }

        return Math.floor((12/col));

    }

    /**
     * Calulate pagination data from original array
     * @returns {*[]} array to data to display
     */
    function paginateEventList() {
        return eventDataArr.slice(pageNumber * parseInt(settings.maxEventsToShow), (pageNumber + 1) * parseInt(settings.maxEventsToShow));
    }

    function getTotalPage() {
        var totalPage = Math.ceil(eventDataArr.length / parseInt(settings.maxEventsToShow));
        return totalPage;

    }


    function togglePageBtn() {
          if(eventDataArr.length == parseInt(settings.maxEventsToShow) || eventDataArr.length==0) {
            $(".previousEvent").parent().hide();
            $(".nextEvent").parent().hide();

        } else {
             if((pageNumber+1)>=getTotalPage()) {
                $(".nextEvent").parent().hide();
            } else {
                $(".nextEvent").parent().show();
            }

             if((pageNumber-1)>=0) {
                 $(".previousEvent").parent().removeClass("hidden");
                 $(".previousEvent").parent().show();
             } else {
                 $(".previousEvent").parent().hide();
             }
        }

    }

    function initPageBtn () {
        if(eventDataArr.length> parseInt(settings.maxEventsToShow)) {
            $(".nextEvent").parent().removeClass("hidden");
        } else {
            $(".nextEvent").parent().addClass("hidden");
        }

        if(eventDataArr.length<=0) {
            $(".previousEvent").parent().removeClass("hidden");
            $(".previousEvent").parent().addClass("hidden");
        }
        togglePageBtn();
    }

    function initPaginationBtnListner() {
        $(".nextEvent").on('click', function(e) {
            e.preventDefault();
            pageNumber+=1;
            if(pageNumber< getTotalPage()) {
                var eventList = paginateEventList();
                displayEvents(eventList, eventTitleDate);
            }
            togglePageBtn();
        });

        $(".previousEvent").on('click', function(e) {
            e.preventDefault();
            pageNumber-=1;
            if(pageNumber>=0) {
                var eventList = paginateEventList();
                displayEvents(eventList, eventTitleDate);
            }
            togglePageBtn();

        });
    }

    if(settings.showCalendar || settings.mainCalendarPage) {
        Liferay.on('allPortletsReady', function () {
            initCalendarDefer().done(function() {
                //loadCalendarEvents(cal.getAttrs().date).done(loadCalendarEventsDone);
                loadCalendarEvents(new Date(), INIT_ACTION).done(loadCalendarEventsDone);
                $(".resetCalendarLink").on('click', function() {
                    $('#assetCategorySelector').val('null');
                    cal.deselectDates();
                    loadCalendarEvents(new Date(), activeAction).done(loadCalendarEventsDone);
                    togglePageBtn();
                });

                $("#assetCategorySelector").on("change", function() {
                    cal.deselectDates();
                    //for the active month selecting from the current day
                    loadCalendarEvents((selectedMonth == getCurrentMonth())? new Date(): cal.getAttrs().date, activeAction).done(loadCalendarEventsDone);
                    togglePageBtn();
                });
                initPaginationBtnListner();
            });
        });
    } else {
        Liferay.on('allPortletsReady', function () {
            loadCalendarEvents(new Date(), INIT_ACTION);
            initPaginationBtnListner();
        });
    }
};