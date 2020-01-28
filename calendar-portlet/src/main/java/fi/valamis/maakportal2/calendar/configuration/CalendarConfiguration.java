package fi.valamis.maakportal2.calendar.configuration;

import aQute.bnd.annotation.metatype.Meta;

@Meta.OCD(id = "fi.valamis.maakportal2.calendar.configuration.CalendarConfiguration")
public interface CalendarConfiguration {
	
	@Meta.AD(required = false)
    public String showCalendar();
	
	@Meta.AD(required = false)
    public String mainCalendarPage();
	
	@Meta.AD(required = false)
    public String eventNotificationEmail();
	
	@Meta.AD(required = false)
    public String eventsPage();
	
	@Meta.AD(required = false)
	public String vocabularityId();

	@Meta.AD(required = false)
    public String showOnlyVocabularityId();

	@Meta.AD(required = false)
    public String showOtherInstances();

	@Meta.AD(required = false)
	public String reviewRequired();

	@Meta.AD(required = false)
	public String maxEventsToShow();

	@Meta.AD(required = false)
    public String formDescription();

	@Meta.AD(required = false)
	public String showEventImage();

	@Meta.AD(required = false)
	public String eventSuccessMsg();

	@Meta.AD(required = false)
	public String eventPublishMsg();

	@Meta.AD(required = false)
	public String eventAwaitingApprovalMsg();

	@Meta.AD(required = false)
	public String eventUnderReviewMsg();

	@Meta.AD(required = false)
	public String selectedCategory();

	@Meta.AD(required = false)
	public String portletTitle();

	@Meta.AD(required = false)
	public String numberOfColumn();

    @Meta.AD(
        description = "%Instanse visible to calendar. Use Virtual hostname",
        required = false
    )
    public String[] instancesToShow();
	
}
