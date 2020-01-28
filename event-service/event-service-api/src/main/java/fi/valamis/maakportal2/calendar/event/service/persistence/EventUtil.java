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

package fi.valamis.maakportal2.calendar.event.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import fi.valamis.maakportal2.calendar.event.model.Event;

import org.osgi.util.tracker.ServiceTracker;

import java.util.Date;
import java.util.List;

/**
 * The persistence utility for the event service. This utility wraps {@link fi.valamis.maakportal2.calendar.event.service.persistence.impl.EventPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventPersistence
 * @see fi.valamis.maakportal2.calendar.event.service.persistence.impl.EventPersistenceImpl
 * @generated
 */
@ProviderType
public class EventUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Event event) {
		getPersistence().clearCache(event);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Event> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Event> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Event> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Event> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Event update(Event event) {
		return getPersistence().update(event);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Event update(Event event, ServiceContext serviceContext) {
		return getPersistence().update(event, serviceContext);
	}

	/**
	* Returns all the events where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching events
	*/
	public static List<Event> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the events where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of events
	* @param end the upper bound of the range of events (not inclusive)
	* @return the range of matching events
	*/
	public static List<Event> findByUuid(java.lang.String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the events where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of events
	* @param end the upper bound of the range of events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching events
	*/
	public static List<Event> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Event> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the events where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of events
	* @param end the upper bound of the range of events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching events
	*/
	public static List<Event> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Event> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first event in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event
	* @throws NoSuchEventException if a matching event could not be found
	*/
	public static Event findByUuid_First(java.lang.String uuid,
		OrderByComparator<Event> orderByComparator)
		throws fi.valamis.maakportal2.calendar.event.exception.NoSuchEventException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first event in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event, or <code>null</code> if a matching event could not be found
	*/
	public static Event fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<Event> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last event in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event
	* @throws NoSuchEventException if a matching event could not be found
	*/
	public static Event findByUuid_Last(java.lang.String uuid,
		OrderByComparator<Event> orderByComparator)
		throws fi.valamis.maakportal2.calendar.event.exception.NoSuchEventException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last event in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event, or <code>null</code> if a matching event could not be found
	*/
	public static Event fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<Event> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the events before and after the current event in the ordered set where uuid = &#63;.
	*
	* @param eventId the primary key of the current event
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next event
	* @throws NoSuchEventException if a event with the primary key could not be found
	*/
	public static Event[] findByUuid_PrevAndNext(long eventId,
		java.lang.String uuid, OrderByComparator<Event> orderByComparator)
		throws fi.valamis.maakportal2.calendar.event.exception.NoSuchEventException {
		return getPersistence()
				   .findByUuid_PrevAndNext(eventId, uuid, orderByComparator);
	}

	/**
	* Removes all the events where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of events where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching events
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the event where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchEventException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching event
	* @throws NoSuchEventException if a matching event could not be found
	*/
	public static Event findByUUID_G(java.lang.String uuid, long groupId)
		throws fi.valamis.maakportal2.calendar.event.exception.NoSuchEventException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the event where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching event, or <code>null</code> if a matching event could not be found
	*/
	public static Event fetchByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the event where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching event, or <code>null</code> if a matching event could not be found
	*/
	public static Event fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the event where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the event that was removed
	*/
	public static Event removeByUUID_G(java.lang.String uuid, long groupId)
		throws fi.valamis.maakportal2.calendar.event.exception.NoSuchEventException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of events where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching events
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the events where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching events
	*/
	public static List<Event> findByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the events where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of events
	* @param end the upper bound of the range of events (not inclusive)
	* @return the range of matching events
	*/
	public static List<Event> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the events where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of events
	* @param end the upper bound of the range of events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching events
	*/
	public static List<Event> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Event> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the events where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of events
	* @param end the upper bound of the range of events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching events
	*/
	public static List<Event> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Event> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first event in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event
	* @throws NoSuchEventException if a matching event could not be found
	*/
	public static Event findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Event> orderByComparator)
		throws fi.valamis.maakportal2.calendar.event.exception.NoSuchEventException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first event in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event, or <code>null</code> if a matching event could not be found
	*/
	public static Event fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Event> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last event in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event
	* @throws NoSuchEventException if a matching event could not be found
	*/
	public static Event findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<Event> orderByComparator)
		throws fi.valamis.maakportal2.calendar.event.exception.NoSuchEventException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last event in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event, or <code>null</code> if a matching event could not be found
	*/
	public static Event fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<Event> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the events before and after the current event in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param eventId the primary key of the current event
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next event
	* @throws NoSuchEventException if a event with the primary key could not be found
	*/
	public static Event[] findByUuid_C_PrevAndNext(long eventId,
		java.lang.String uuid, long companyId,
		OrderByComparator<Event> orderByComparator)
		throws fi.valamis.maakportal2.calendar.event.exception.NoSuchEventException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(eventId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the events where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of events where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching events
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the events where startingDate &gt; &#63; and companyId = &#63;.
	*
	* @param startingDate the starting date
	* @param companyId the company ID
	* @return the matching events
	*/
	public static List<Event> findBystartingDate(Date startingDate,
		long companyId) {
		return getPersistence().findBystartingDate(startingDate, companyId);
	}

	/**
	* Returns a range of all the events where startingDate &gt; &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param startingDate the starting date
	* @param companyId the company ID
	* @param start the lower bound of the range of events
	* @param end the upper bound of the range of events (not inclusive)
	* @return the range of matching events
	*/
	public static List<Event> findBystartingDate(Date startingDate,
		long companyId, int start, int end) {
		return getPersistence()
				   .findBystartingDate(startingDate, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the events where startingDate &gt; &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param startingDate the starting date
	* @param companyId the company ID
	* @param start the lower bound of the range of events
	* @param end the upper bound of the range of events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching events
	*/
	public static List<Event> findBystartingDate(Date startingDate,
		long companyId, int start, int end,
		OrderByComparator<Event> orderByComparator) {
		return getPersistence()
				   .findBystartingDate(startingDate, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the events where startingDate &gt; &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param startingDate the starting date
	* @param companyId the company ID
	* @param start the lower bound of the range of events
	* @param end the upper bound of the range of events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching events
	*/
	public static List<Event> findBystartingDate(Date startingDate,
		long companyId, int start, int end,
		OrderByComparator<Event> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findBystartingDate(startingDate, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first event in the ordered set where startingDate &gt; &#63; and companyId = &#63;.
	*
	* @param startingDate the starting date
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event
	* @throws NoSuchEventException if a matching event could not be found
	*/
	public static Event findBystartingDate_First(Date startingDate,
		long companyId, OrderByComparator<Event> orderByComparator)
		throws fi.valamis.maakportal2.calendar.event.exception.NoSuchEventException {
		return getPersistence()
				   .findBystartingDate_First(startingDate, companyId,
			orderByComparator);
	}

	/**
	* Returns the first event in the ordered set where startingDate &gt; &#63; and companyId = &#63;.
	*
	* @param startingDate the starting date
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event, or <code>null</code> if a matching event could not be found
	*/
	public static Event fetchBystartingDate_First(Date startingDate,
		long companyId, OrderByComparator<Event> orderByComparator) {
		return getPersistence()
				   .fetchBystartingDate_First(startingDate, companyId,
			orderByComparator);
	}

	/**
	* Returns the last event in the ordered set where startingDate &gt; &#63; and companyId = &#63;.
	*
	* @param startingDate the starting date
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event
	* @throws NoSuchEventException if a matching event could not be found
	*/
	public static Event findBystartingDate_Last(Date startingDate,
		long companyId, OrderByComparator<Event> orderByComparator)
		throws fi.valamis.maakportal2.calendar.event.exception.NoSuchEventException {
		return getPersistence()
				   .findBystartingDate_Last(startingDate, companyId,
			orderByComparator);
	}

	/**
	* Returns the last event in the ordered set where startingDate &gt; &#63; and companyId = &#63;.
	*
	* @param startingDate the starting date
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event, or <code>null</code> if a matching event could not be found
	*/
	public static Event fetchBystartingDate_Last(Date startingDate,
		long companyId, OrderByComparator<Event> orderByComparator) {
		return getPersistence()
				   .fetchBystartingDate_Last(startingDate, companyId,
			orderByComparator);
	}

	/**
	* Returns the events before and after the current event in the ordered set where startingDate &gt; &#63; and companyId = &#63;.
	*
	* @param eventId the primary key of the current event
	* @param startingDate the starting date
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next event
	* @throws NoSuchEventException if a event with the primary key could not be found
	*/
	public static Event[] findBystartingDate_PrevAndNext(long eventId,
		Date startingDate, long companyId,
		OrderByComparator<Event> orderByComparator)
		throws fi.valamis.maakportal2.calendar.event.exception.NoSuchEventException {
		return getPersistence()
				   .findBystartingDate_PrevAndNext(eventId, startingDate,
			companyId, orderByComparator);
	}

	/**
	* Removes all the events where startingDate &gt; &#63; and companyId = &#63; from the database.
	*
	* @param startingDate the starting date
	* @param companyId the company ID
	*/
	public static void removeBystartingDate(Date startingDate, long companyId) {
		getPersistence().removeBystartingDate(startingDate, companyId);
	}

	/**
	* Returns the number of events where startingDate &gt; &#63; and companyId = &#63;.
	*
	* @param startingDate the starting date
	* @param companyId the company ID
	* @return the number of matching events
	*/
	public static int countBystartingDate(Date startingDate, long companyId) {
		return getPersistence().countBystartingDate(startingDate, companyId);
	}

	/**
	* Returns all the events where status = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param companyId the company ID
	* @return the matching events
	*/
	public static List<Event> findBystatusAndCompanyId(
		java.lang.String status, long companyId) {
		return getPersistence().findBystatusAndCompanyId(status, companyId);
	}

	/**
	* Returns a range of all the events where status = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param companyId the company ID
	* @param start the lower bound of the range of events
	* @param end the upper bound of the range of events (not inclusive)
	* @return the range of matching events
	*/
	public static List<Event> findBystatusAndCompanyId(
		java.lang.String status, long companyId, int start, int end) {
		return getPersistence()
				   .findBystatusAndCompanyId(status, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the events where status = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param companyId the company ID
	* @param start the lower bound of the range of events
	* @param end the upper bound of the range of events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching events
	*/
	public static List<Event> findBystatusAndCompanyId(
		java.lang.String status, long companyId, int start, int end,
		OrderByComparator<Event> orderByComparator) {
		return getPersistence()
				   .findBystatusAndCompanyId(status, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the events where status = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param companyId the company ID
	* @param start the lower bound of the range of events
	* @param end the upper bound of the range of events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching events
	*/
	public static List<Event> findBystatusAndCompanyId(
		java.lang.String status, long companyId, int start, int end,
		OrderByComparator<Event> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findBystatusAndCompanyId(status, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first event in the ordered set where status = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event
	* @throws NoSuchEventException if a matching event could not be found
	*/
	public static Event findBystatusAndCompanyId_First(
		java.lang.String status, long companyId,
		OrderByComparator<Event> orderByComparator)
		throws fi.valamis.maakportal2.calendar.event.exception.NoSuchEventException {
		return getPersistence()
				   .findBystatusAndCompanyId_First(status, companyId,
			orderByComparator);
	}

	/**
	* Returns the first event in the ordered set where status = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event, or <code>null</code> if a matching event could not be found
	*/
	public static Event fetchBystatusAndCompanyId_First(
		java.lang.String status, long companyId,
		OrderByComparator<Event> orderByComparator) {
		return getPersistence()
				   .fetchBystatusAndCompanyId_First(status, companyId,
			orderByComparator);
	}

	/**
	* Returns the last event in the ordered set where status = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event
	* @throws NoSuchEventException if a matching event could not be found
	*/
	public static Event findBystatusAndCompanyId_Last(java.lang.String status,
		long companyId, OrderByComparator<Event> orderByComparator)
		throws fi.valamis.maakportal2.calendar.event.exception.NoSuchEventException {
		return getPersistence()
				   .findBystatusAndCompanyId_Last(status, companyId,
			orderByComparator);
	}

	/**
	* Returns the last event in the ordered set where status = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event, or <code>null</code> if a matching event could not be found
	*/
	public static Event fetchBystatusAndCompanyId_Last(
		java.lang.String status, long companyId,
		OrderByComparator<Event> orderByComparator) {
		return getPersistence()
				   .fetchBystatusAndCompanyId_Last(status, companyId,
			orderByComparator);
	}

	/**
	* Returns the events before and after the current event in the ordered set where status = &#63; and companyId = &#63;.
	*
	* @param eventId the primary key of the current event
	* @param status the status
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next event
	* @throws NoSuchEventException if a event with the primary key could not be found
	*/
	public static Event[] findBystatusAndCompanyId_PrevAndNext(long eventId,
		java.lang.String status, long companyId,
		OrderByComparator<Event> orderByComparator)
		throws fi.valamis.maakportal2.calendar.event.exception.NoSuchEventException {
		return getPersistence()
				   .findBystatusAndCompanyId_PrevAndNext(eventId, status,
			companyId, orderByComparator);
	}

	/**
	* Removes all the events where status = &#63; and companyId = &#63; from the database.
	*
	* @param status the status
	* @param companyId the company ID
	*/
	public static void removeBystatusAndCompanyId(java.lang.String status,
		long companyId) {
		getPersistence().removeBystatusAndCompanyId(status, companyId);
	}

	/**
	* Returns the number of events where status = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param companyId the company ID
	* @return the number of matching events
	*/
	public static int countBystatusAndCompanyId(java.lang.String status,
		long companyId) {
		return getPersistence().countBystatusAndCompanyId(status, companyId);
	}

	/**
	* Returns all the events where status = &#63; and startingDate &gt; &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param startingDate the starting date
	* @param companyId the company ID
	* @return the matching events
	*/
	public static List<Event> findBystatusDateAndCompanyId(
		java.lang.String status, Date startingDate, long companyId) {
		return getPersistence()
				   .findBystatusDateAndCompanyId(status, startingDate, companyId);
	}

	/**
	* Returns a range of all the events where status = &#63; and startingDate &gt; &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param startingDate the starting date
	* @param companyId the company ID
	* @param start the lower bound of the range of events
	* @param end the upper bound of the range of events (not inclusive)
	* @return the range of matching events
	*/
	public static List<Event> findBystatusDateAndCompanyId(
		java.lang.String status, Date startingDate, long companyId, int start,
		int end) {
		return getPersistence()
				   .findBystatusDateAndCompanyId(status, startingDate,
			companyId, start, end);
	}

	/**
	* Returns an ordered range of all the events where status = &#63; and startingDate &gt; &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param startingDate the starting date
	* @param companyId the company ID
	* @param start the lower bound of the range of events
	* @param end the upper bound of the range of events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching events
	*/
	public static List<Event> findBystatusDateAndCompanyId(
		java.lang.String status, Date startingDate, long companyId, int start,
		int end, OrderByComparator<Event> orderByComparator) {
		return getPersistence()
				   .findBystatusDateAndCompanyId(status, startingDate,
			companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the events where status = &#63; and startingDate &gt; &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param startingDate the starting date
	* @param companyId the company ID
	* @param start the lower bound of the range of events
	* @param end the upper bound of the range of events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching events
	*/
	public static List<Event> findBystatusDateAndCompanyId(
		java.lang.String status, Date startingDate, long companyId, int start,
		int end, OrderByComparator<Event> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBystatusDateAndCompanyId(status, startingDate,
			companyId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first event in the ordered set where status = &#63; and startingDate &gt; &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param startingDate the starting date
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event
	* @throws NoSuchEventException if a matching event could not be found
	*/
	public static Event findBystatusDateAndCompanyId_First(
		java.lang.String status, Date startingDate, long companyId,
		OrderByComparator<Event> orderByComparator)
		throws fi.valamis.maakportal2.calendar.event.exception.NoSuchEventException {
		return getPersistence()
				   .findBystatusDateAndCompanyId_First(status, startingDate,
			companyId, orderByComparator);
	}

	/**
	* Returns the first event in the ordered set where status = &#63; and startingDate &gt; &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param startingDate the starting date
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event, or <code>null</code> if a matching event could not be found
	*/
	public static Event fetchBystatusDateAndCompanyId_First(
		java.lang.String status, Date startingDate, long companyId,
		OrderByComparator<Event> orderByComparator) {
		return getPersistence()
				   .fetchBystatusDateAndCompanyId_First(status, startingDate,
			companyId, orderByComparator);
	}

	/**
	* Returns the last event in the ordered set where status = &#63; and startingDate &gt; &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param startingDate the starting date
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event
	* @throws NoSuchEventException if a matching event could not be found
	*/
	public static Event findBystatusDateAndCompanyId_Last(
		java.lang.String status, Date startingDate, long companyId,
		OrderByComparator<Event> orderByComparator)
		throws fi.valamis.maakportal2.calendar.event.exception.NoSuchEventException {
		return getPersistence()
				   .findBystatusDateAndCompanyId_Last(status, startingDate,
			companyId, orderByComparator);
	}

	/**
	* Returns the last event in the ordered set where status = &#63; and startingDate &gt; &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param startingDate the starting date
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event, or <code>null</code> if a matching event could not be found
	*/
	public static Event fetchBystatusDateAndCompanyId_Last(
		java.lang.String status, Date startingDate, long companyId,
		OrderByComparator<Event> orderByComparator) {
		return getPersistence()
				   .fetchBystatusDateAndCompanyId_Last(status, startingDate,
			companyId, orderByComparator);
	}

	/**
	* Returns the events before and after the current event in the ordered set where status = &#63; and startingDate &gt; &#63; and companyId = &#63;.
	*
	* @param eventId the primary key of the current event
	* @param status the status
	* @param startingDate the starting date
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next event
	* @throws NoSuchEventException if a event with the primary key could not be found
	*/
	public static Event[] findBystatusDateAndCompanyId_PrevAndNext(
		long eventId, java.lang.String status, Date startingDate,
		long companyId, OrderByComparator<Event> orderByComparator)
		throws fi.valamis.maakportal2.calendar.event.exception.NoSuchEventException {
		return getPersistence()
				   .findBystatusDateAndCompanyId_PrevAndNext(eventId, status,
			startingDate, companyId, orderByComparator);
	}

	/**
	* Removes all the events where status = &#63; and startingDate &gt; &#63; and companyId = &#63; from the database.
	*
	* @param status the status
	* @param startingDate the starting date
	* @param companyId the company ID
	*/
	public static void removeBystatusDateAndCompanyId(java.lang.String status,
		Date startingDate, long companyId) {
		getPersistence()
			.removeBystatusDateAndCompanyId(status, startingDate, companyId);
	}

	/**
	* Returns the number of events where status = &#63; and startingDate &gt; &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param startingDate the starting date
	* @param companyId the company ID
	* @return the number of matching events
	*/
	public static int countBystatusDateAndCompanyId(java.lang.String status,
		Date startingDate, long companyId) {
		return getPersistence()
				   .countBystatusDateAndCompanyId(status, startingDate,
			companyId);
	}

	/**
	* Returns all the events where status = &#63; and endingDate &gt; &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param endingDate the ending date
	* @param companyId the company ID
	* @return the matching events
	*/
	public static List<Event> findBystatusEndingDateAndCompanyId(
		java.lang.String status, Date endingDate, long companyId) {
		return getPersistence()
				   .findBystatusEndingDateAndCompanyId(status, endingDate,
			companyId);
	}

	/**
	* Returns a range of all the events where status = &#63; and endingDate &gt; &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param endingDate the ending date
	* @param companyId the company ID
	* @param start the lower bound of the range of events
	* @param end the upper bound of the range of events (not inclusive)
	* @return the range of matching events
	*/
	public static List<Event> findBystatusEndingDateAndCompanyId(
		java.lang.String status, Date endingDate, long companyId, int start,
		int end) {
		return getPersistence()
				   .findBystatusEndingDateAndCompanyId(status, endingDate,
			companyId, start, end);
	}

	/**
	* Returns an ordered range of all the events where status = &#63; and endingDate &gt; &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param endingDate the ending date
	* @param companyId the company ID
	* @param start the lower bound of the range of events
	* @param end the upper bound of the range of events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching events
	*/
	public static List<Event> findBystatusEndingDateAndCompanyId(
		java.lang.String status, Date endingDate, long companyId, int start,
		int end, OrderByComparator<Event> orderByComparator) {
		return getPersistence()
				   .findBystatusEndingDateAndCompanyId(status, endingDate,
			companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the events where status = &#63; and endingDate &gt; &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param endingDate the ending date
	* @param companyId the company ID
	* @param start the lower bound of the range of events
	* @param end the upper bound of the range of events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching events
	*/
	public static List<Event> findBystatusEndingDateAndCompanyId(
		java.lang.String status, Date endingDate, long companyId, int start,
		int end, OrderByComparator<Event> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findBystatusEndingDateAndCompanyId(status, endingDate,
			companyId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first event in the ordered set where status = &#63; and endingDate &gt; &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param endingDate the ending date
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event
	* @throws NoSuchEventException if a matching event could not be found
	*/
	public static Event findBystatusEndingDateAndCompanyId_First(
		java.lang.String status, Date endingDate, long companyId,
		OrderByComparator<Event> orderByComparator)
		throws fi.valamis.maakportal2.calendar.event.exception.NoSuchEventException {
		return getPersistence()
				   .findBystatusEndingDateAndCompanyId_First(status,
			endingDate, companyId, orderByComparator);
	}

	/**
	* Returns the first event in the ordered set where status = &#63; and endingDate &gt; &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param endingDate the ending date
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event, or <code>null</code> if a matching event could not be found
	*/
	public static Event fetchBystatusEndingDateAndCompanyId_First(
		java.lang.String status, Date endingDate, long companyId,
		OrderByComparator<Event> orderByComparator) {
		return getPersistence()
				   .fetchBystatusEndingDateAndCompanyId_First(status,
			endingDate, companyId, orderByComparator);
	}

	/**
	* Returns the last event in the ordered set where status = &#63; and endingDate &gt; &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param endingDate the ending date
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event
	* @throws NoSuchEventException if a matching event could not be found
	*/
	public static Event findBystatusEndingDateAndCompanyId_Last(
		java.lang.String status, Date endingDate, long companyId,
		OrderByComparator<Event> orderByComparator)
		throws fi.valamis.maakportal2.calendar.event.exception.NoSuchEventException {
		return getPersistence()
				   .findBystatusEndingDateAndCompanyId_Last(status, endingDate,
			companyId, orderByComparator);
	}

	/**
	* Returns the last event in the ordered set where status = &#63; and endingDate &gt; &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param endingDate the ending date
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event, or <code>null</code> if a matching event could not be found
	*/
	public static Event fetchBystatusEndingDateAndCompanyId_Last(
		java.lang.String status, Date endingDate, long companyId,
		OrderByComparator<Event> orderByComparator) {
		return getPersistence()
				   .fetchBystatusEndingDateAndCompanyId_Last(status,
			endingDate, companyId, orderByComparator);
	}

	/**
	* Returns the events before and after the current event in the ordered set where status = &#63; and endingDate &gt; &#63; and companyId = &#63;.
	*
	* @param eventId the primary key of the current event
	* @param status the status
	* @param endingDate the ending date
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next event
	* @throws NoSuchEventException if a event with the primary key could not be found
	*/
	public static Event[] findBystatusEndingDateAndCompanyId_PrevAndNext(
		long eventId, java.lang.String status, Date endingDate, long companyId,
		OrderByComparator<Event> orderByComparator)
		throws fi.valamis.maakportal2.calendar.event.exception.NoSuchEventException {
		return getPersistence()
				   .findBystatusEndingDateAndCompanyId_PrevAndNext(eventId,
			status, endingDate, companyId, orderByComparator);
	}

	/**
	* Removes all the events where status = &#63; and endingDate &gt; &#63; and companyId = &#63; from the database.
	*
	* @param status the status
	* @param endingDate the ending date
	* @param companyId the company ID
	*/
	public static void removeBystatusEndingDateAndCompanyId(
		java.lang.String status, Date endingDate, long companyId) {
		getPersistence()
			.removeBystatusEndingDateAndCompanyId(status, endingDate, companyId);
	}

	/**
	* Returns the number of events where status = &#63; and endingDate &gt; &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param endingDate the ending date
	* @param companyId the company ID
	* @return the number of matching events
	*/
	public static int countBystatusEndingDateAndCompanyId(
		java.lang.String status, Date endingDate, long companyId) {
		return getPersistence()
				   .countBystatusEndingDateAndCompanyId(status, endingDate,
			companyId);
	}

	/**
	* Returns all the events where eventFriendlyName = &#63;.
	*
	* @param eventFriendlyName the event friendly name
	* @return the matching events
	*/
	public static List<Event> findByeventFriendlyName(
		java.lang.String eventFriendlyName) {
		return getPersistence().findByeventFriendlyName(eventFriendlyName);
	}

	/**
	* Returns a range of all the events where eventFriendlyName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventFriendlyName the event friendly name
	* @param start the lower bound of the range of events
	* @param end the upper bound of the range of events (not inclusive)
	* @return the range of matching events
	*/
	public static List<Event> findByeventFriendlyName(
		java.lang.String eventFriendlyName, int start, int end) {
		return getPersistence()
				   .findByeventFriendlyName(eventFriendlyName, start, end);
	}

	/**
	* Returns an ordered range of all the events where eventFriendlyName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventFriendlyName the event friendly name
	* @param start the lower bound of the range of events
	* @param end the upper bound of the range of events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching events
	*/
	public static List<Event> findByeventFriendlyName(
		java.lang.String eventFriendlyName, int start, int end,
		OrderByComparator<Event> orderByComparator) {
		return getPersistence()
				   .findByeventFriendlyName(eventFriendlyName, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the events where eventFriendlyName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventFriendlyName the event friendly name
	* @param start the lower bound of the range of events
	* @param end the upper bound of the range of events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching events
	*/
	public static List<Event> findByeventFriendlyName(
		java.lang.String eventFriendlyName, int start, int end,
		OrderByComparator<Event> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByeventFriendlyName(eventFriendlyName, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first event in the ordered set where eventFriendlyName = &#63;.
	*
	* @param eventFriendlyName the event friendly name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event
	* @throws NoSuchEventException if a matching event could not be found
	*/
	public static Event findByeventFriendlyName_First(
		java.lang.String eventFriendlyName,
		OrderByComparator<Event> orderByComparator)
		throws fi.valamis.maakportal2.calendar.event.exception.NoSuchEventException {
		return getPersistence()
				   .findByeventFriendlyName_First(eventFriendlyName,
			orderByComparator);
	}

	/**
	* Returns the first event in the ordered set where eventFriendlyName = &#63;.
	*
	* @param eventFriendlyName the event friendly name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event, or <code>null</code> if a matching event could not be found
	*/
	public static Event fetchByeventFriendlyName_First(
		java.lang.String eventFriendlyName,
		OrderByComparator<Event> orderByComparator) {
		return getPersistence()
				   .fetchByeventFriendlyName_First(eventFriendlyName,
			orderByComparator);
	}

	/**
	* Returns the last event in the ordered set where eventFriendlyName = &#63;.
	*
	* @param eventFriendlyName the event friendly name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event
	* @throws NoSuchEventException if a matching event could not be found
	*/
	public static Event findByeventFriendlyName_Last(
		java.lang.String eventFriendlyName,
		OrderByComparator<Event> orderByComparator)
		throws fi.valamis.maakportal2.calendar.event.exception.NoSuchEventException {
		return getPersistence()
				   .findByeventFriendlyName_Last(eventFriendlyName,
			orderByComparator);
	}

	/**
	* Returns the last event in the ordered set where eventFriendlyName = &#63;.
	*
	* @param eventFriendlyName the event friendly name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event, or <code>null</code> if a matching event could not be found
	*/
	public static Event fetchByeventFriendlyName_Last(
		java.lang.String eventFriendlyName,
		OrderByComparator<Event> orderByComparator) {
		return getPersistence()
				   .fetchByeventFriendlyName_Last(eventFriendlyName,
			orderByComparator);
	}

	/**
	* Returns the events before and after the current event in the ordered set where eventFriendlyName = &#63;.
	*
	* @param eventId the primary key of the current event
	* @param eventFriendlyName the event friendly name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next event
	* @throws NoSuchEventException if a event with the primary key could not be found
	*/
	public static Event[] findByeventFriendlyName_PrevAndNext(long eventId,
		java.lang.String eventFriendlyName,
		OrderByComparator<Event> orderByComparator)
		throws fi.valamis.maakportal2.calendar.event.exception.NoSuchEventException {
		return getPersistence()
				   .findByeventFriendlyName_PrevAndNext(eventId,
			eventFriendlyName, orderByComparator);
	}

	/**
	* Removes all the events where eventFriendlyName = &#63; from the database.
	*
	* @param eventFriendlyName the event friendly name
	*/
	public static void removeByeventFriendlyName(
		java.lang.String eventFriendlyName) {
		getPersistence().removeByeventFriendlyName(eventFriendlyName);
	}

	/**
	* Returns the number of events where eventFriendlyName = &#63;.
	*
	* @param eventFriendlyName the event friendly name
	* @return the number of matching events
	*/
	public static int countByeventFriendlyName(
		java.lang.String eventFriendlyName) {
		return getPersistence().countByeventFriendlyName(eventFriendlyName);
	}

	/**
	* Caches the event in the entity cache if it is enabled.
	*
	* @param event the event
	*/
	public static void cacheResult(Event event) {
		getPersistence().cacheResult(event);
	}

	/**
	* Caches the events in the entity cache if it is enabled.
	*
	* @param events the events
	*/
	public static void cacheResult(List<Event> events) {
		getPersistence().cacheResult(events);
	}

	/**
	* Creates a new event with the primary key. Does not add the event to the database.
	*
	* @param eventId the primary key for the new event
	* @return the new event
	*/
	public static Event create(long eventId) {
		return getPersistence().create(eventId);
	}

	/**
	* Removes the event with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventId the primary key of the event
	* @return the event that was removed
	* @throws NoSuchEventException if a event with the primary key could not be found
	*/
	public static Event remove(long eventId)
		throws fi.valamis.maakportal2.calendar.event.exception.NoSuchEventException {
		return getPersistence().remove(eventId);
	}

	public static Event updateImpl(Event event) {
		return getPersistence().updateImpl(event);
	}

	/**
	* Returns the event with the primary key or throws a {@link NoSuchEventException} if it could not be found.
	*
	* @param eventId the primary key of the event
	* @return the event
	* @throws NoSuchEventException if a event with the primary key could not be found
	*/
	public static Event findByPrimaryKey(long eventId)
		throws fi.valamis.maakportal2.calendar.event.exception.NoSuchEventException {
		return getPersistence().findByPrimaryKey(eventId);
	}

	/**
	* Returns the event with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eventId the primary key of the event
	* @return the event, or <code>null</code> if a event with the primary key could not be found
	*/
	public static Event fetchByPrimaryKey(long eventId) {
		return getPersistence().fetchByPrimaryKey(eventId);
	}

	public static java.util.Map<java.io.Serializable, Event> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the events.
	*
	* @return the events
	*/
	public static List<Event> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the events.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of events
	* @param end the upper bound of the range of events (not inclusive)
	* @return the range of events
	*/
	public static List<Event> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the events.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of events
	* @param end the upper bound of the range of events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of events
	*/
	public static List<Event> findAll(int start, int end,
		OrderByComparator<Event> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the events.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of events
	* @param end the upper bound of the range of events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of events
	*/
	public static List<Event> findAll(int start, int end,
		OrderByComparator<Event> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the events from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of events.
	*
	* @return the number of events
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static EventPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<EventPersistence, EventPersistence> _serviceTracker =
		ServiceTrackerFactory.open(EventPersistence.class);
}