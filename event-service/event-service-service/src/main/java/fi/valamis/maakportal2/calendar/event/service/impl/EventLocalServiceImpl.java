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

package fi.valamis.maakportal2.calendar.event.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;

import aQute.bnd.annotation.ProviderType;
import fi.valamis.maakportal2.calendar.event.model.Event;
import fi.valamis.maakportal2.calendar.event.service.base.EventLocalServiceBaseImpl;
import fi.valamis.maakportal2.calendar.event.service.persistence.EventFinder;

/**
 * The implementation of the event local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link fi.valamis.maakportal2.calendar.event.service.EventLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventLocalServiceBaseImpl
 * @see fi.valamis.maakportal2.calendar.event.service.EventLocalServiceUtil
 */
@ProviderType
public class EventLocalServiceImpl extends EventLocalServiceBaseImpl {
public Event createEvent(){
		return createEvent(CounterLocalServiceUtil.increment(Event.class.getName()));
	}
	
	public List<Event> getEventsByCompanyIdAndStatus(long companyId, String status, int start, int end){
		return getEventPersistence().findBystatusAndCompanyId(status, companyId, start, end);
	}
	
	public List<Event> getEventsByStatusAndCompanyId(long companyId, Date d){
		return getEventPersistence().findBystartingDate(d, companyId);
	}
	
	public List<Event> getEventsByStatusDateAndCompanyId(long companyId, Date d, String status){
		return getEventPersistence().findBystatusDateAndCompanyId(status, d, companyId);
	}
	
	public List<Event> filterByEndingDate(long companyId, Date sd, Date ed, String status, int start, int end){
		List<Event> events = eventFinder.findEventsBetweenDates(companyId, status, sd, ed, start, end);
		return events;
	}
	
	public List<Event> filterFutureEvents(long companyId, Date startingDate, String status, int start, int end){
		return eventFinder.findEventsFromDates(companyId, status, startingDate, start, end);
    }

    public List<Event> findEventsByFriendlyName(String eventFriendlyName){
        return eventFinder.findEventsByFriendlyName(eventFriendlyName);
    }
    
    public Event findEventByFriendlyName(String eventFriendlyName){
        return eventFinder.findEventByFriendlyName(eventFriendlyName);
	}

	@Override
	public List<Event> getBetweenDates(long companyId, Date sd, Date ed) {
		// TODO Auto-generated method stub
		return null;
	}

}
