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

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public interface EventFinder {
	public java.util.List<fi.valamis.maakportal2.calendar.event.model.Event> findEventsBetweenDates(
		long companyId, java.lang.String status, java.util.Date startingDate,
		java.util.Date endingDate, int startr, int endr);

	public java.util.List<fi.valamis.maakportal2.calendar.event.model.Event> findEventsFromDates(
		long companyId, java.lang.String status, java.util.Date startingDate,
		int start, int end);

	public java.util.List<fi.valamis.maakportal2.calendar.event.model.Event> findEventsByFriendlyName(
		java.lang.String eventFriendlyName);

	public fi.valamis.maakportal2.calendar.event.model.Event findEventByFriendlyName(
		java.lang.String eventFriendlyName);
}