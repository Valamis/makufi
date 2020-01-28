/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package fi.valamis.maakportal2.calendar.event.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EventLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see EventLocalService
 * @generated
 */
@ProviderType
public class EventLocalServiceWrapper implements EventLocalService,
	ServiceWrapper<EventLocalService> {
	public EventLocalServiceWrapper(EventLocalService eventLocalService) {
		_eventLocalService = eventLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _eventLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _eventLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _eventLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _eventLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _eventLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _eventLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the event to the database. Also notifies the appropriate model listeners.
	*
	* @param event the event
	* @return the event that was added
	*/
	@Override
	public fi.valamis.maakportal2.calendar.event.model.Event addEvent(
		fi.valamis.maakportal2.calendar.event.model.Event event) {
		return _eventLocalService.addEvent(event);
	}

	@Override
	public fi.valamis.maakportal2.calendar.event.model.Event createEvent() {
		return _eventLocalService.createEvent();
	}

	/**
	* Creates a new event with the primary key. Does not add the event to the database.
	*
	* @param eventId the primary key for the new event
	* @return the new event
	*/
	@Override
	public fi.valamis.maakportal2.calendar.event.model.Event createEvent(
		long eventId) {
		return _eventLocalService.createEvent(eventId);
	}

	/**
	* Deletes the event from the database. Also notifies the appropriate model listeners.
	*
	* @param event the event
	* @return the event that was removed
	*/
	@Override
	public fi.valamis.maakportal2.calendar.event.model.Event deleteEvent(
		fi.valamis.maakportal2.calendar.event.model.Event event) {
		return _eventLocalService.deleteEvent(event);
	}

	/**
	* Deletes the event with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventId the primary key of the event
	* @return the event that was removed
	* @throws PortalException if a event with the primary key could not be found
	*/
	@Override
	public fi.valamis.maakportal2.calendar.event.model.Event deleteEvent(
		long eventId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _eventLocalService.deleteEvent(eventId);
	}

	@Override
	public fi.valamis.maakportal2.calendar.event.model.Event fetchEvent(
		long eventId) {
		return _eventLocalService.fetchEvent(eventId);
	}

	/**
	* Returns the event matching the UUID and group.
	*
	* @param uuid the event's UUID
	* @param groupId the primary key of the group
	* @return the matching event, or <code>null</code> if a matching event could not be found
	*/
	@Override
	public fi.valamis.maakportal2.calendar.event.model.Event fetchEventByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _eventLocalService.fetchEventByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public fi.valamis.maakportal2.calendar.event.model.Event findEventByFriendlyName(
		java.lang.String eventFriendlyName) {
		return _eventLocalService.findEventByFriendlyName(eventFriendlyName);
	}

	/**
	* Returns the event with the primary key.
	*
	* @param eventId the primary key of the event
	* @return the event
	* @throws PortalException if a event with the primary key could not be found
	*/
	@Override
	public fi.valamis.maakportal2.calendar.event.model.Event getEvent(
		long eventId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _eventLocalService.getEvent(eventId);
	}

	/**
	* Returns the event matching the UUID and group.
	*
	* @param uuid the event's UUID
	* @param groupId the primary key of the group
	* @return the matching event
	* @throws PortalException if a matching event could not be found
	*/
	@Override
	public fi.valamis.maakportal2.calendar.event.model.Event getEventByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _eventLocalService.getEventByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Updates the event in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param event the event
	* @return the event that was updated
	*/
	@Override
	public fi.valamis.maakportal2.calendar.event.model.Event updateEvent(
		fi.valamis.maakportal2.calendar.event.model.Event event) {
		return _eventLocalService.updateEvent(event);
	}

	/**
	* Returns the number of events.
	*
	* @return the number of events
	*/
	@Override
	public int getEventsCount() {
		return _eventLocalService.getEventsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _eventLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _eventLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.valamis.maakportal2.calendar.event.model.impl.EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _eventLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.valamis.maakportal2.calendar.event.model.impl.EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _eventLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<fi.valamis.maakportal2.calendar.event.model.Event> filterByEndingDate(
		long companyId, java.util.Date sd, java.util.Date ed,
		java.lang.String status, int start, int end) {
		return _eventLocalService.filterByEndingDate(companyId, sd, ed, status,
			start, end);
	}

	@Override
	public java.util.List<fi.valamis.maakportal2.calendar.event.model.Event> filterFutureEvents(
		long companyId, java.util.Date startingDate, java.lang.String status,
		int start, int end) {
		return _eventLocalService.filterFutureEvents(companyId, startingDate,
			status, start, end);
	}

	@Override
	public java.util.List<fi.valamis.maakportal2.calendar.event.model.Event> findEventsByFriendlyName(
		java.lang.String eventFriendlyName) {
		return _eventLocalService.findEventsByFriendlyName(eventFriendlyName);
	}

	@Override
	public java.util.List<fi.valamis.maakportal2.calendar.event.model.Event> getBetweenDates(
		long companyId, java.util.Date sd, java.util.Date ed) {
		return _eventLocalService.getBetweenDates(companyId, sd, ed);
	}

	/**
	* Returns a range of all the events.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link fi.valamis.maakportal2.calendar.event.model.impl.EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of events
	* @param end the upper bound of the range of events (not inclusive)
	* @return the range of events
	*/
	@Override
	public java.util.List<fi.valamis.maakportal2.calendar.event.model.Event> getEvents(
		int start, int end) {
		return _eventLocalService.getEvents(start, end);
	}

	@Override
	public java.util.List<fi.valamis.maakportal2.calendar.event.model.Event> getEventsByCompanyIdAndStatus(
		long companyId, java.lang.String status, int start, int end) {
		return _eventLocalService.getEventsByCompanyIdAndStatus(companyId,
			status, start, end);
	}

	@Override
	public java.util.List<fi.valamis.maakportal2.calendar.event.model.Event> getEventsByStatusAndCompanyId(
		long companyId, java.util.Date d) {
		return _eventLocalService.getEventsByStatusAndCompanyId(companyId, d);
	}

	@Override
	public java.util.List<fi.valamis.maakportal2.calendar.event.model.Event> getEventsByStatusDateAndCompanyId(
		long companyId, java.util.Date d, java.lang.String status) {
		return _eventLocalService.getEventsByStatusDateAndCompanyId(companyId,
			d, status);
	}

	/**
	* Returns all the events matching the UUID and company.
	*
	* @param uuid the UUID of the events
	* @param companyId the primary key of the company
	* @return the matching events, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<fi.valamis.maakportal2.calendar.event.model.Event> getEventsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _eventLocalService.getEventsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of events matching the UUID and company.
	*
	* @param uuid the UUID of the events
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of events
	* @param end the upper bound of the range of events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching events, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<fi.valamis.maakportal2.calendar.event.model.Event> getEventsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<fi.valamis.maakportal2.calendar.event.model.Event> orderByComparator) {
		return _eventLocalService.getEventsByUuidAndCompanyId(uuid, companyId,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _eventLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _eventLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public EventLocalService getWrappedService() {
		return _eventLocalService;
	}

	@Override
	public void setWrappedService(EventLocalService eventLocalService) {
		_eventLocalService = eventLocalService;
	}

	private EventLocalService _eventLocalService;
}