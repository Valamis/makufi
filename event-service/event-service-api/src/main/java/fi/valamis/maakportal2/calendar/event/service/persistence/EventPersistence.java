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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import fi.valamis.maakportal2.calendar.event.exception.NoSuchEventException;
import fi.valamis.maakportal2.calendar.event.model.Event;

import java.util.Date;

/**
 * The persistence interface for the event service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see fi.valamis.maakportal2.calendar.event.service.persistence.impl.EventPersistenceImpl
 * @see EventUtil
 * @generated
 */
@ProviderType
public interface EventPersistence extends BasePersistence<Event> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EventUtil} to access the event persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the events where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching events
	*/
	public java.util.List<Event> findByUuid(java.lang.String uuid);

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
	public java.util.List<Event> findByUuid(java.lang.String uuid, int start,
		int end);

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
	public java.util.List<Event> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator);

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
	public java.util.List<Event> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first event in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event
	* @throws NoSuchEventException if a matching event could not be found
	*/
	public Event findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator)
		throws NoSuchEventException;

	/**
	* Returns the first event in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event, or <code>null</code> if a matching event could not be found
	*/
	public Event fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator);

	/**
	* Returns the last event in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event
	* @throws NoSuchEventException if a matching event could not be found
	*/
	public Event findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator)
		throws NoSuchEventException;

	/**
	* Returns the last event in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event, or <code>null</code> if a matching event could not be found
	*/
	public Event fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator);

	/**
	* Returns the events before and after the current event in the ordered set where uuid = &#63;.
	*
	* @param eventId the primary key of the current event
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next event
	* @throws NoSuchEventException if a event with the primary key could not be found
	*/
	public Event[] findByUuid_PrevAndNext(long eventId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator)
		throws NoSuchEventException;

	/**
	* Removes all the events where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of events where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching events
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the event where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchEventException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching event
	* @throws NoSuchEventException if a matching event could not be found
	*/
	public Event findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchEventException;

	/**
	* Returns the event where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching event, or <code>null</code> if a matching event could not be found
	*/
	public Event fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the event where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching event, or <code>null</code> if a matching event could not be found
	*/
	public Event fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the event where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the event that was removed
	*/
	public Event removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchEventException;

	/**
	* Returns the number of events where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching events
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the events where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching events
	*/
	public java.util.List<Event> findByUuid_C(java.lang.String uuid,
		long companyId);

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
	public java.util.List<Event> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

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
	public java.util.List<Event> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator);

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
	public java.util.List<Event> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first event in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event
	* @throws NoSuchEventException if a matching event could not be found
	*/
	public Event findByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator)
		throws NoSuchEventException;

	/**
	* Returns the first event in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event, or <code>null</code> if a matching event could not be found
	*/
	public Event fetchByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator);

	/**
	* Returns the last event in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event
	* @throws NoSuchEventException if a matching event could not be found
	*/
	public Event findByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator)
		throws NoSuchEventException;

	/**
	* Returns the last event in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event, or <code>null</code> if a matching event could not be found
	*/
	public Event fetchByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator);

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
	public Event[] findByUuid_C_PrevAndNext(long eventId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator)
		throws NoSuchEventException;

	/**
	* Removes all the events where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of events where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching events
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the events where startingDate &gt; &#63; and companyId = &#63;.
	*
	* @param startingDate the starting date
	* @param companyId the company ID
	* @return the matching events
	*/
	public java.util.List<Event> findBystartingDate(Date startingDate,
		long companyId);

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
	public java.util.List<Event> findBystartingDate(Date startingDate,
		long companyId, int start, int end);

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
	public java.util.List<Event> findBystartingDate(Date startingDate,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator);

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
	public java.util.List<Event> findBystartingDate(Date startingDate,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first event in the ordered set where startingDate &gt; &#63; and companyId = &#63;.
	*
	* @param startingDate the starting date
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event
	* @throws NoSuchEventException if a matching event could not be found
	*/
	public Event findBystartingDate_First(Date startingDate, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator)
		throws NoSuchEventException;

	/**
	* Returns the first event in the ordered set where startingDate &gt; &#63; and companyId = &#63;.
	*
	* @param startingDate the starting date
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event, or <code>null</code> if a matching event could not be found
	*/
	public Event fetchBystartingDate_First(Date startingDate, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator);

	/**
	* Returns the last event in the ordered set where startingDate &gt; &#63; and companyId = &#63;.
	*
	* @param startingDate the starting date
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event
	* @throws NoSuchEventException if a matching event could not be found
	*/
	public Event findBystartingDate_Last(Date startingDate, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator)
		throws NoSuchEventException;

	/**
	* Returns the last event in the ordered set where startingDate &gt; &#63; and companyId = &#63;.
	*
	* @param startingDate the starting date
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event, or <code>null</code> if a matching event could not be found
	*/
	public Event fetchBystartingDate_Last(Date startingDate, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator);

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
	public Event[] findBystartingDate_PrevAndNext(long eventId,
		Date startingDate, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator)
		throws NoSuchEventException;

	/**
	* Removes all the events where startingDate &gt; &#63; and companyId = &#63; from the database.
	*
	* @param startingDate the starting date
	* @param companyId the company ID
	*/
	public void removeBystartingDate(Date startingDate, long companyId);

	/**
	* Returns the number of events where startingDate &gt; &#63; and companyId = &#63;.
	*
	* @param startingDate the starting date
	* @param companyId the company ID
	* @return the number of matching events
	*/
	public int countBystartingDate(Date startingDate, long companyId);

	/**
	* Returns all the events where status = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param companyId the company ID
	* @return the matching events
	*/
	public java.util.List<Event> findBystatusAndCompanyId(
		java.lang.String status, long companyId);

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
	public java.util.List<Event> findBystatusAndCompanyId(
		java.lang.String status, long companyId, int start, int end);

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
	public java.util.List<Event> findBystatusAndCompanyId(
		java.lang.String status, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator);

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
	public java.util.List<Event> findBystatusAndCompanyId(
		java.lang.String status, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first event in the ordered set where status = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event
	* @throws NoSuchEventException if a matching event could not be found
	*/
	public Event findBystatusAndCompanyId_First(java.lang.String status,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator)
		throws NoSuchEventException;

	/**
	* Returns the first event in the ordered set where status = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event, or <code>null</code> if a matching event could not be found
	*/
	public Event fetchBystatusAndCompanyId_First(java.lang.String status,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator);

	/**
	* Returns the last event in the ordered set where status = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event
	* @throws NoSuchEventException if a matching event could not be found
	*/
	public Event findBystatusAndCompanyId_Last(java.lang.String status,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator)
		throws NoSuchEventException;

	/**
	* Returns the last event in the ordered set where status = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event, or <code>null</code> if a matching event could not be found
	*/
	public Event fetchBystatusAndCompanyId_Last(java.lang.String status,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator);

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
	public Event[] findBystatusAndCompanyId_PrevAndNext(long eventId,
		java.lang.String status, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator)
		throws NoSuchEventException;

	/**
	* Removes all the events where status = &#63; and companyId = &#63; from the database.
	*
	* @param status the status
	* @param companyId the company ID
	*/
	public void removeBystatusAndCompanyId(java.lang.String status,
		long companyId);

	/**
	* Returns the number of events where status = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param companyId the company ID
	* @return the number of matching events
	*/
	public int countBystatusAndCompanyId(java.lang.String status, long companyId);

	/**
	* Returns all the events where status = &#63; and startingDate &gt; &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param startingDate the starting date
	* @param companyId the company ID
	* @return the matching events
	*/
	public java.util.List<Event> findBystatusDateAndCompanyId(
		java.lang.String status, Date startingDate, long companyId);

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
	public java.util.List<Event> findBystatusDateAndCompanyId(
		java.lang.String status, Date startingDate, long companyId, int start,
		int end);

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
	public java.util.List<Event> findBystatusDateAndCompanyId(
		java.lang.String status, Date startingDate, long companyId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator);

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
	public java.util.List<Event> findBystatusDateAndCompanyId(
		java.lang.String status, Date startingDate, long companyId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator,
		boolean retrieveFromCache);

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
	public Event findBystatusDateAndCompanyId_First(java.lang.String status,
		Date startingDate, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator)
		throws NoSuchEventException;

	/**
	* Returns the first event in the ordered set where status = &#63; and startingDate &gt; &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param startingDate the starting date
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event, or <code>null</code> if a matching event could not be found
	*/
	public Event fetchBystatusDateAndCompanyId_First(java.lang.String status,
		Date startingDate, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator);

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
	public Event findBystatusDateAndCompanyId_Last(java.lang.String status,
		Date startingDate, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator)
		throws NoSuchEventException;

	/**
	* Returns the last event in the ordered set where status = &#63; and startingDate &gt; &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param startingDate the starting date
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event, or <code>null</code> if a matching event could not be found
	*/
	public Event fetchBystatusDateAndCompanyId_Last(java.lang.String status,
		Date startingDate, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator);

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
	public Event[] findBystatusDateAndCompanyId_PrevAndNext(long eventId,
		java.lang.String status, Date startingDate, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator)
		throws NoSuchEventException;

	/**
	* Removes all the events where status = &#63; and startingDate &gt; &#63; and companyId = &#63; from the database.
	*
	* @param status the status
	* @param startingDate the starting date
	* @param companyId the company ID
	*/
	public void removeBystatusDateAndCompanyId(java.lang.String status,
		Date startingDate, long companyId);

	/**
	* Returns the number of events where status = &#63; and startingDate &gt; &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param startingDate the starting date
	* @param companyId the company ID
	* @return the number of matching events
	*/
	public int countBystatusDateAndCompanyId(java.lang.String status,
		Date startingDate, long companyId);

	/**
	* Returns all the events where status = &#63; and endingDate &gt; &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param endingDate the ending date
	* @param companyId the company ID
	* @return the matching events
	*/
	public java.util.List<Event> findBystatusEndingDateAndCompanyId(
		java.lang.String status, Date endingDate, long companyId);

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
	public java.util.List<Event> findBystatusEndingDateAndCompanyId(
		java.lang.String status, Date endingDate, long companyId, int start,
		int end);

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
	public java.util.List<Event> findBystatusEndingDateAndCompanyId(
		java.lang.String status, Date endingDate, long companyId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator);

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
	public java.util.List<Event> findBystatusEndingDateAndCompanyId(
		java.lang.String status, Date endingDate, long companyId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator,
		boolean retrieveFromCache);

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
	public Event findBystatusEndingDateAndCompanyId_First(
		java.lang.String status, Date endingDate, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator)
		throws NoSuchEventException;

	/**
	* Returns the first event in the ordered set where status = &#63; and endingDate &gt; &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param endingDate the ending date
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event, or <code>null</code> if a matching event could not be found
	*/
	public Event fetchBystatusEndingDateAndCompanyId_First(
		java.lang.String status, Date endingDate, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator);

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
	public Event findBystatusEndingDateAndCompanyId_Last(
		java.lang.String status, Date endingDate, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator)
		throws NoSuchEventException;

	/**
	* Returns the last event in the ordered set where status = &#63; and endingDate &gt; &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param endingDate the ending date
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event, or <code>null</code> if a matching event could not be found
	*/
	public Event fetchBystatusEndingDateAndCompanyId_Last(
		java.lang.String status, Date endingDate, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator);

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
	public Event[] findBystatusEndingDateAndCompanyId_PrevAndNext(
		long eventId, java.lang.String status, Date endingDate, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator)
		throws NoSuchEventException;

	/**
	* Removes all the events where status = &#63; and endingDate &gt; &#63; and companyId = &#63; from the database.
	*
	* @param status the status
	* @param endingDate the ending date
	* @param companyId the company ID
	*/
	public void removeBystatusEndingDateAndCompanyId(java.lang.String status,
		Date endingDate, long companyId);

	/**
	* Returns the number of events where status = &#63; and endingDate &gt; &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param endingDate the ending date
	* @param companyId the company ID
	* @return the number of matching events
	*/
	public int countBystatusEndingDateAndCompanyId(java.lang.String status,
		Date endingDate, long companyId);

	/**
	* Returns all the events where eventFriendlyName = &#63;.
	*
	* @param eventFriendlyName the event friendly name
	* @return the matching events
	*/
	public java.util.List<Event> findByeventFriendlyName(
		java.lang.String eventFriendlyName);

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
	public java.util.List<Event> findByeventFriendlyName(
		java.lang.String eventFriendlyName, int start, int end);

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
	public java.util.List<Event> findByeventFriendlyName(
		java.lang.String eventFriendlyName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator);

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
	public java.util.List<Event> findByeventFriendlyName(
		java.lang.String eventFriendlyName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first event in the ordered set where eventFriendlyName = &#63;.
	*
	* @param eventFriendlyName the event friendly name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event
	* @throws NoSuchEventException if a matching event could not be found
	*/
	public Event findByeventFriendlyName_First(
		java.lang.String eventFriendlyName,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator)
		throws NoSuchEventException;

	/**
	* Returns the first event in the ordered set where eventFriendlyName = &#63;.
	*
	* @param eventFriendlyName the event friendly name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching event, or <code>null</code> if a matching event could not be found
	*/
	public Event fetchByeventFriendlyName_First(
		java.lang.String eventFriendlyName,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator);

	/**
	* Returns the last event in the ordered set where eventFriendlyName = &#63;.
	*
	* @param eventFriendlyName the event friendly name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event
	* @throws NoSuchEventException if a matching event could not be found
	*/
	public Event findByeventFriendlyName_Last(
		java.lang.String eventFriendlyName,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator)
		throws NoSuchEventException;

	/**
	* Returns the last event in the ordered set where eventFriendlyName = &#63;.
	*
	* @param eventFriendlyName the event friendly name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching event, or <code>null</code> if a matching event could not be found
	*/
	public Event fetchByeventFriendlyName_Last(
		java.lang.String eventFriendlyName,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator);

	/**
	* Returns the events before and after the current event in the ordered set where eventFriendlyName = &#63;.
	*
	* @param eventId the primary key of the current event
	* @param eventFriendlyName the event friendly name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next event
	* @throws NoSuchEventException if a event with the primary key could not be found
	*/
	public Event[] findByeventFriendlyName_PrevAndNext(long eventId,
		java.lang.String eventFriendlyName,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator)
		throws NoSuchEventException;

	/**
	* Removes all the events where eventFriendlyName = &#63; from the database.
	*
	* @param eventFriendlyName the event friendly name
	*/
	public void removeByeventFriendlyName(java.lang.String eventFriendlyName);

	/**
	* Returns the number of events where eventFriendlyName = &#63;.
	*
	* @param eventFriendlyName the event friendly name
	* @return the number of matching events
	*/
	public int countByeventFriendlyName(java.lang.String eventFriendlyName);

	/**
	* Caches the event in the entity cache if it is enabled.
	*
	* @param event the event
	*/
	public void cacheResult(Event event);

	/**
	* Caches the events in the entity cache if it is enabled.
	*
	* @param events the events
	*/
	public void cacheResult(java.util.List<Event> events);

	/**
	* Creates a new event with the primary key. Does not add the event to the database.
	*
	* @param eventId the primary key for the new event
	* @return the new event
	*/
	public Event create(long eventId);

	/**
	* Removes the event with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventId the primary key of the event
	* @return the event that was removed
	* @throws NoSuchEventException if a event with the primary key could not be found
	*/
	public Event remove(long eventId) throws NoSuchEventException;

	public Event updateImpl(Event event);

	/**
	* Returns the event with the primary key or throws a {@link NoSuchEventException} if it could not be found.
	*
	* @param eventId the primary key of the event
	* @return the event
	* @throws NoSuchEventException if a event with the primary key could not be found
	*/
	public Event findByPrimaryKey(long eventId) throws NoSuchEventException;

	/**
	* Returns the event with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eventId the primary key of the event
	* @return the event, or <code>null</code> if a event with the primary key could not be found
	*/
	public Event fetchByPrimaryKey(long eventId);

	@Override
	public java.util.Map<java.io.Serializable, Event> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the events.
	*
	* @return the events
	*/
	public java.util.List<Event> findAll();

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
	public java.util.List<Event> findAll(int start, int end);

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
	public java.util.List<Event> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator);

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
	public java.util.List<Event> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Event> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the events from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of events.
	*
	* @return the number of events
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}