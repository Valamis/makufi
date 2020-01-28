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

package fi.valamis.maakportal2.calendar.event.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import fi.valamis.maakportal2.calendar.event.model.Event;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Event in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Event
 * @generated
 */
@ProviderType
public class EventCacheModel implements CacheModel<Event>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EventCacheModel)) {
			return false;
		}

		EventCacheModel eventCacheModel = (EventCacheModel)obj;

		if (eventId == eventCacheModel.eventId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, eventId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(63);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", eventId=");
		sb.append(eventId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", eventName=");
		sb.append(eventName);
		sb.append(", startingDate=");
		sb.append(startingDate);
		sb.append(", endingDate=");
		sb.append(endingDate);
		sb.append(", timesAdditionalInfo=");
		sb.append(timesAdditionalInfo);
		sb.append(", location=");
		sb.append(location);
		sb.append(", address=");
		sb.append(address);
		sb.append(", imageUrl=");
		sb.append(imageUrl);
		sb.append(", description=");
		sb.append(description);
		sb.append(", additionalInformation=");
		sb.append(additionalInformation);
		sb.append(", signUpLink=");
		sb.append(signUpLink);
		sb.append(", linkToEventWebPage=");
		sb.append(linkToEventWebPage);
		sb.append(", categoryIds=");
		sb.append(categoryIds);
		sb.append(", eventAuthorName=");
		sb.append(eventAuthorName);
		sb.append(", eventAuthorEmail=");
		sb.append(eventAuthorEmail);
		sb.append(", eventAuthorPhoneNumber=");
		sb.append(eventAuthorPhoneNumber);
		sb.append(", additionalCompanyIds=");
		sb.append(additionalCompanyIds);
		sb.append(", status=");
		sb.append(status);
		sb.append(", authorizationToken=");
		sb.append(authorizationToken);
		sb.append(", userGivenPassword=");
		sb.append(userGivenPassword);
		sb.append(", adminComment=");
		sb.append(adminComment);
		sb.append(", showMap=");
		sb.append(showMap);
		sb.append(", updateUrl=");
		sb.append(updateUrl);
		sb.append(", eventFriendlyName=");
		sb.append(eventFriendlyName);
		sb.append(", additionalStartingDates=");
		sb.append(additionalStartingDates);
		sb.append(", additionalStartingDatesRule=");
		sb.append(additionalStartingDatesRule);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Event toEntityModel() {
		EventImpl eventImpl = new EventImpl();

		if (uuid == null) {
			eventImpl.setUuid(StringPool.BLANK);
		}
		else {
			eventImpl.setUuid(uuid);
		}

		eventImpl.setEventId(eventId);
		eventImpl.setGroupId(groupId);
		eventImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			eventImpl.setCreateDate(null);
		}
		else {
			eventImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			eventImpl.setModifiedDate(null);
		}
		else {
			eventImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (eventName == null) {
			eventImpl.setEventName(StringPool.BLANK);
		}
		else {
			eventImpl.setEventName(eventName);
		}

		if (startingDate == Long.MIN_VALUE) {
			eventImpl.setStartingDate(null);
		}
		else {
			eventImpl.setStartingDate(new Date(startingDate));
		}

		if (endingDate == Long.MIN_VALUE) {
			eventImpl.setEndingDate(null);
		}
		else {
			eventImpl.setEndingDate(new Date(endingDate));
		}

		if (timesAdditionalInfo == null) {
			eventImpl.setTimesAdditionalInfo(StringPool.BLANK);
		}
		else {
			eventImpl.setTimesAdditionalInfo(timesAdditionalInfo);
		}

		if (location == null) {
			eventImpl.setLocation(StringPool.BLANK);
		}
		else {
			eventImpl.setLocation(location);
		}

		if (address == null) {
			eventImpl.setAddress(StringPool.BLANK);
		}
		else {
			eventImpl.setAddress(address);
		}

		if (imageUrl == null) {
			eventImpl.setImageUrl(StringPool.BLANK);
		}
		else {
			eventImpl.setImageUrl(imageUrl);
		}

		if (description == null) {
			eventImpl.setDescription(StringPool.BLANK);
		}
		else {
			eventImpl.setDescription(description);
		}

		if (additionalInformation == null) {
			eventImpl.setAdditionalInformation(StringPool.BLANK);
		}
		else {
			eventImpl.setAdditionalInformation(additionalInformation);
		}

		if (signUpLink == null) {
			eventImpl.setSignUpLink(StringPool.BLANK);
		}
		else {
			eventImpl.setSignUpLink(signUpLink);
		}

		if (linkToEventWebPage == null) {
			eventImpl.setLinkToEventWebPage(StringPool.BLANK);
		}
		else {
			eventImpl.setLinkToEventWebPage(linkToEventWebPage);
		}

		if (categoryIds == null) {
			eventImpl.setCategoryIds(StringPool.BLANK);
		}
		else {
			eventImpl.setCategoryIds(categoryIds);
		}

		if (eventAuthorName == null) {
			eventImpl.setEventAuthorName(StringPool.BLANK);
		}
		else {
			eventImpl.setEventAuthorName(eventAuthorName);
		}

		if (eventAuthorEmail == null) {
			eventImpl.setEventAuthorEmail(StringPool.BLANK);
		}
		else {
			eventImpl.setEventAuthorEmail(eventAuthorEmail);
		}

		if (eventAuthorPhoneNumber == null) {
			eventImpl.setEventAuthorPhoneNumber(StringPool.BLANK);
		}
		else {
			eventImpl.setEventAuthorPhoneNumber(eventAuthorPhoneNumber);
		}

		if (additionalCompanyIds == null) {
			eventImpl.setAdditionalCompanyIds(StringPool.BLANK);
		}
		else {
			eventImpl.setAdditionalCompanyIds(additionalCompanyIds);
		}

		if (status == null) {
			eventImpl.setStatus(StringPool.BLANK);
		}
		else {
			eventImpl.setStatus(status);
		}

		if (authorizationToken == null) {
			eventImpl.setAuthorizationToken(StringPool.BLANK);
		}
		else {
			eventImpl.setAuthorizationToken(authorizationToken);
		}

		if (userGivenPassword == null) {
			eventImpl.setUserGivenPassword(StringPool.BLANK);
		}
		else {
			eventImpl.setUserGivenPassword(userGivenPassword);
		}

		if (adminComment == null) {
			eventImpl.setAdminComment(StringPool.BLANK);
		}
		else {
			eventImpl.setAdminComment(adminComment);
		}

		eventImpl.setShowMap(showMap);

		if (updateUrl == null) {
			eventImpl.setUpdateUrl(StringPool.BLANK);
		}
		else {
			eventImpl.setUpdateUrl(updateUrl);
		}

		if (eventFriendlyName == null) {
			eventImpl.setEventFriendlyName(StringPool.BLANK);
		}
		else {
			eventImpl.setEventFriendlyName(eventFriendlyName);
		}

		if (additionalStartingDates == null) {
			eventImpl.setAdditionalStartingDates(StringPool.BLANK);
		}
		else {
			eventImpl.setAdditionalStartingDates(additionalStartingDates);
		}

		if (additionalStartingDatesRule == null) {
			eventImpl.setAdditionalStartingDatesRule(StringPool.BLANK);
		}
		else {
			eventImpl.setAdditionalStartingDatesRule(additionalStartingDatesRule);
		}

		eventImpl.resetOriginalValues();

		return eventImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		eventId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		eventName = objectInput.readUTF();
		startingDate = objectInput.readLong();
		endingDate = objectInput.readLong();
		timesAdditionalInfo = objectInput.readUTF();
		location = objectInput.readUTF();
		address = objectInput.readUTF();
		imageUrl = objectInput.readUTF();
		description = objectInput.readUTF();
		additionalInformation = objectInput.readUTF();
		signUpLink = objectInput.readUTF();
		linkToEventWebPage = objectInput.readUTF();
		categoryIds = objectInput.readUTF();
		eventAuthorName = objectInput.readUTF();
		eventAuthorEmail = objectInput.readUTF();
		eventAuthorPhoneNumber = objectInput.readUTF();
		additionalCompanyIds = objectInput.readUTF();
		status = objectInput.readUTF();
		authorizationToken = objectInput.readUTF();
		userGivenPassword = objectInput.readUTF();
		adminComment = objectInput.readUTF();

		showMap = objectInput.readBoolean();
		updateUrl = objectInput.readUTF();
		eventFriendlyName = objectInput.readUTF();
		additionalStartingDates = objectInput.readUTF();
		additionalStartingDatesRule = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(eventId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (eventName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventName);
		}

		objectOutput.writeLong(startingDate);
		objectOutput.writeLong(endingDate);

		if (timesAdditionalInfo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(timesAdditionalInfo);
		}

		if (location == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(location);
		}

		if (address == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (imageUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(imageUrl);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (additionalInformation == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(additionalInformation);
		}

		if (signUpLink == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(signUpLink);
		}

		if (linkToEventWebPage == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(linkToEventWebPage);
		}

		if (categoryIds == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(categoryIds);
		}

		if (eventAuthorName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventAuthorName);
		}

		if (eventAuthorEmail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventAuthorEmail);
		}

		if (eventAuthorPhoneNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventAuthorPhoneNumber);
		}

		if (additionalCompanyIds == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(additionalCompanyIds);
		}

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}

		if (authorizationToken == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(authorizationToken);
		}

		if (userGivenPassword == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userGivenPassword);
		}

		if (adminComment == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(adminComment);
		}

		objectOutput.writeBoolean(showMap);

		if (updateUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(updateUrl);
		}

		if (eventFriendlyName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventFriendlyName);
		}

		if (additionalStartingDates == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(additionalStartingDates);
		}

		if (additionalStartingDatesRule == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(additionalStartingDatesRule);
		}
	}

	public String uuid;
	public long eventId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public String eventName;
	public long startingDate;
	public long endingDate;
	public String timesAdditionalInfo;
	public String location;
	public String address;
	public String imageUrl;
	public String description;
	public String additionalInformation;
	public String signUpLink;
	public String linkToEventWebPage;
	public String categoryIds;
	public String eventAuthorName;
	public String eventAuthorEmail;
	public String eventAuthorPhoneNumber;
	public String additionalCompanyIds;
	public String status;
	public String authorizationToken;
	public String userGivenPassword;
	public String adminComment;
	public boolean showMap;
	public String updateUrl;
	public String eventFriendlyName;
	public String additionalStartingDates;
	public String additionalStartingDatesRule;
}