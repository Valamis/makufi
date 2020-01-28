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

package fi.valamis.maakportal2.calendar.event.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Event}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Event
 * @generated
 */
@ProviderType
public class EventWrapper implements Event, ModelWrapper<Event> {
	public EventWrapper(Event event) {
		_event = event;
	}

	@Override
	public Class<?> getModelClass() {
		return Event.class;
	}

	@Override
	public String getModelClassName() {
		return Event.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("eventId", getEventId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("eventName", getEventName());
		attributes.put("startingDate", getStartingDate());
		attributes.put("endingDate", getEndingDate());
		attributes.put("timesAdditionalInfo", getTimesAdditionalInfo());
		attributes.put("location", getLocation());
		attributes.put("address", getAddress());
		attributes.put("imageUrl", getImageUrl());
		attributes.put("description", getDescription());
		attributes.put("additionalInformation", getAdditionalInformation());
		attributes.put("signUpLink", getSignUpLink());
		attributes.put("linkToEventWebPage", getLinkToEventWebPage());
		attributes.put("categoryIds", getCategoryIds());
		attributes.put("eventAuthorName", getEventAuthorName());
		attributes.put("eventAuthorEmail", getEventAuthorEmail());
		attributes.put("eventAuthorPhoneNumber", getEventAuthorPhoneNumber());
		attributes.put("additionalCompanyIds", getAdditionalCompanyIds());
		attributes.put("status", getStatus());
		attributes.put("authorizationToken", getAuthorizationToken());
		attributes.put("userGivenPassword", getUserGivenPassword());
		attributes.put("adminComment", getAdminComment());
		attributes.put("showMap", getShowMap());
		attributes.put("updateUrl", getUpdateUrl());
		attributes.put("eventFriendlyName", getEventFriendlyName());
		attributes.put("additionalStartingDates", getAdditionalStartingDates());
		attributes.put("additionalStartingDatesRule",
			getAdditionalStartingDatesRule());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long eventId = (Long)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String eventName = (String)attributes.get("eventName");

		if (eventName != null) {
			setEventName(eventName);
		}

		Date startingDate = (Date)attributes.get("startingDate");

		if (startingDate != null) {
			setStartingDate(startingDate);
		}

		Date endingDate = (Date)attributes.get("endingDate");

		if (endingDate != null) {
			setEndingDate(endingDate);
		}

		String timesAdditionalInfo = (String)attributes.get(
				"timesAdditionalInfo");

		if (timesAdditionalInfo != null) {
			setTimesAdditionalInfo(timesAdditionalInfo);
		}

		String location = (String)attributes.get("location");

		if (location != null) {
			setLocation(location);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String imageUrl = (String)attributes.get("imageUrl");

		if (imageUrl != null) {
			setImageUrl(imageUrl);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String additionalInformation = (String)attributes.get(
				"additionalInformation");

		if (additionalInformation != null) {
			setAdditionalInformation(additionalInformation);
		}

		String signUpLink = (String)attributes.get("signUpLink");

		if (signUpLink != null) {
			setSignUpLink(signUpLink);
		}

		String linkToEventWebPage = (String)attributes.get("linkToEventWebPage");

		if (linkToEventWebPage != null) {
			setLinkToEventWebPage(linkToEventWebPage);
		}

		String categoryIds = (String)attributes.get("categoryIds");

		if (categoryIds != null) {
			setCategoryIds(categoryIds);
		}

		String eventAuthorName = (String)attributes.get("eventAuthorName");

		if (eventAuthorName != null) {
			setEventAuthorName(eventAuthorName);
		}

		String eventAuthorEmail = (String)attributes.get("eventAuthorEmail");

		if (eventAuthorEmail != null) {
			setEventAuthorEmail(eventAuthorEmail);
		}

		String eventAuthorPhoneNumber = (String)attributes.get(
				"eventAuthorPhoneNumber");

		if (eventAuthorPhoneNumber != null) {
			setEventAuthorPhoneNumber(eventAuthorPhoneNumber);
		}

		String additionalCompanyIds = (String)attributes.get(
				"additionalCompanyIds");

		if (additionalCompanyIds != null) {
			setAdditionalCompanyIds(additionalCompanyIds);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String authorizationToken = (String)attributes.get("authorizationToken");

		if (authorizationToken != null) {
			setAuthorizationToken(authorizationToken);
		}

		String userGivenPassword = (String)attributes.get("userGivenPassword");

		if (userGivenPassword != null) {
			setUserGivenPassword(userGivenPassword);
		}

		String adminComment = (String)attributes.get("adminComment");

		if (adminComment != null) {
			setAdminComment(adminComment);
		}

		Boolean showMap = (Boolean)attributes.get("showMap");

		if (showMap != null) {
			setShowMap(showMap);
		}

		String updateUrl = (String)attributes.get("updateUrl");

		if (updateUrl != null) {
			setUpdateUrl(updateUrl);
		}

		String eventFriendlyName = (String)attributes.get("eventFriendlyName");

		if (eventFriendlyName != null) {
			setEventFriendlyName(eventFriendlyName);
		}

		String additionalStartingDates = (String)attributes.get(
				"additionalStartingDates");

		if (additionalStartingDates != null) {
			setAdditionalStartingDates(additionalStartingDates);
		}

		String additionalStartingDatesRule = (String)attributes.get(
				"additionalStartingDatesRule");

		if (additionalStartingDatesRule != null) {
			setAdditionalStartingDatesRule(additionalStartingDatesRule);
		}
	}

	/**
	* Returns the show map of this event.
	*
	* @return the show map of this event
	*/
	@Override
	public boolean getShowMap() {
		return _event.getShowMap();
	}

	@Override
	public boolean isCachedModel() {
		return _event.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _event.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _event.isNew();
	}

	/**
	* Returns <code>true</code> if this event is show map.
	*
	* @return <code>true</code> if this event is show map; <code>false</code> otherwise
	*/
	@Override
	public boolean isShowMap() {
		return _event.isShowMap();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _event.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<fi.valamis.maakportal2.calendar.event.model.Event> toCacheModel() {
		return _event.toCacheModel();
	}

	@Override
	public fi.valamis.maakportal2.calendar.event.model.Event toEscapedModel() {
		return new EventWrapper(_event.toEscapedModel());
	}

	@Override
	public fi.valamis.maakportal2.calendar.event.model.Event toUnescapedModel() {
		return new EventWrapper(_event.toUnescapedModel());
	}

	@Override
	public int compareTo(
		fi.valamis.maakportal2.calendar.event.model.Event event) {
		return _event.compareTo(event);
	}

	@Override
	public int hashCode() {
		return _event.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _event.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new EventWrapper((Event)_event.clone());
	}

	/**
	* Returns the additional company IDs of this event.
	*
	* @return the additional company IDs of this event
	*/
	@Override
	public java.lang.String getAdditionalCompanyIds() {
		return _event.getAdditionalCompanyIds();
	}

	/**
	* Returns the additional information of this event.
	*
	* @return the additional information of this event
	*/
	@Override
	public java.lang.String getAdditionalInformation() {
		return _event.getAdditionalInformation();
	}

	/**
	* Returns the additional starting dates of this event.
	*
	* @return the additional starting dates of this event
	*/
	@Override
	public java.lang.String getAdditionalStartingDates() {
		return _event.getAdditionalStartingDates();
	}

	/**
	* Returns the additional starting dates rule of this event.
	*
	* @return the additional starting dates rule of this event
	*/
	@Override
	public java.lang.String getAdditionalStartingDatesRule() {
		return _event.getAdditionalStartingDatesRule();
	}

	/**
	* Returns the address of this event.
	*
	* @return the address of this event
	*/
	@Override
	public java.lang.String getAddress() {
		return _event.getAddress();
	}

	/**
	* Returns the admin comment of this event.
	*
	* @return the admin comment of this event
	*/
	@Override
	public java.lang.String getAdminComment() {
		return _event.getAdminComment();
	}

	/**
	* Returns the authorization token of this event.
	*
	* @return the authorization token of this event
	*/
	@Override
	public java.lang.String getAuthorizationToken() {
		return _event.getAuthorizationToken();
	}

	/**
	* Returns the category IDs of this event.
	*
	* @return the category IDs of this event
	*/
	@Override
	public java.lang.String getCategoryIds() {
		return _event.getCategoryIds();
	}

	/**
	* Returns the description of this event.
	*
	* @return the description of this event
	*/
	@Override
	public java.lang.String getDescription() {
		return _event.getDescription();
	}

	/**
	* Returns the event author email of this event.
	*
	* @return the event author email of this event
	*/
	@Override
	public java.lang.String getEventAuthorEmail() {
		return _event.getEventAuthorEmail();
	}

	/**
	* Returns the event author name of this event.
	*
	* @return the event author name of this event
	*/
	@Override
	public java.lang.String getEventAuthorName() {
		return _event.getEventAuthorName();
	}

	/**
	* Returns the event author phone number of this event.
	*
	* @return the event author phone number of this event
	*/
	@Override
	public java.lang.String getEventAuthorPhoneNumber() {
		return _event.getEventAuthorPhoneNumber();
	}

	/**
	* Returns the event friendly name of this event.
	*
	* @return the event friendly name of this event
	*/
	@Override
	public java.lang.String getEventFriendlyName() {
		return _event.getEventFriendlyName();
	}

	/**
	* Returns the event name of this event.
	*
	* @return the event name of this event
	*/
	@Override
	public java.lang.String getEventName() {
		return _event.getEventName();
	}

	/**
	* Returns the image url of this event.
	*
	* @return the image url of this event
	*/
	@Override
	public java.lang.String getImageUrl() {
		return _event.getImageUrl();
	}

	/**
	* Returns the link to event web page of this event.
	*
	* @return the link to event web page of this event
	*/
	@Override
	public java.lang.String getLinkToEventWebPage() {
		return _event.getLinkToEventWebPage();
	}

	/**
	* Returns the location of this event.
	*
	* @return the location of this event
	*/
	@Override
	public java.lang.String getLocation() {
		return _event.getLocation();
	}

	/**
	* Returns the sign up link of this event.
	*
	* @return the sign up link of this event
	*/
	@Override
	public java.lang.String getSignUpLink() {
		return _event.getSignUpLink();
	}

	/**
	* Returns the status of this event.
	*
	* @return the status of this event
	*/
	@Override
	public java.lang.String getStatus() {
		return _event.getStatus();
	}

	/**
	* Returns the times additional info of this event.
	*
	* @return the times additional info of this event
	*/
	@Override
	public java.lang.String getTimesAdditionalInfo() {
		return _event.getTimesAdditionalInfo();
	}

	/**
	* Returns the update url of this event.
	*
	* @return the update url of this event
	*/
	@Override
	public java.lang.String getUpdateUrl() {
		return _event.getUpdateUrl();
	}

	/**
	* Returns the user given password of this event.
	*
	* @return the user given password of this event
	*/
	@Override
	public java.lang.String getUserGivenPassword() {
		return _event.getUserGivenPassword();
	}

	/**
	* Returns the uuid of this event.
	*
	* @return the uuid of this event
	*/
	@Override
	public java.lang.String getUuid() {
		return _event.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _event.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _event.toXmlString();
	}

	/**
	* Returns the create date of this event.
	*
	* @return the create date of this event
	*/
	@Override
	public Date getCreateDate() {
		return _event.getCreateDate();
	}

	/**
	* Returns the ending date of this event.
	*
	* @return the ending date of this event
	*/
	@Override
	public Date getEndingDate() {
		return _event.getEndingDate();
	}

	/**
	* Returns the modified date of this event.
	*
	* @return the modified date of this event
	*/
	@Override
	public Date getModifiedDate() {
		return _event.getModifiedDate();
	}

	/**
	* Returns the starting date of this event.
	*
	* @return the starting date of this event
	*/
	@Override
	public Date getStartingDate() {
		return _event.getStartingDate();
	}

	/**
	* Returns the company ID of this event.
	*
	* @return the company ID of this event
	*/
	@Override
	public long getCompanyId() {
		return _event.getCompanyId();
	}

	/**
	* Returns the event ID of this event.
	*
	* @return the event ID of this event
	*/
	@Override
	public long getEventId() {
		return _event.getEventId();
	}

	/**
	* Returns the group ID of this event.
	*
	* @return the group ID of this event
	*/
	@Override
	public long getGroupId() {
		return _event.getGroupId();
	}

	/**
	* Returns the primary key of this event.
	*
	* @return the primary key of this event
	*/
	@Override
	public long getPrimaryKey() {
		return _event.getPrimaryKey();
	}

	@Override
	public void persist() {
		_event.persist();
	}

	/**
	* Sets the additional company IDs of this event.
	*
	* @param additionalCompanyIds the additional company IDs of this event
	*/
	@Override
	public void setAdditionalCompanyIds(java.lang.String additionalCompanyIds) {
		_event.setAdditionalCompanyIds(additionalCompanyIds);
	}

	/**
	* Sets the additional information of this event.
	*
	* @param additionalInformation the additional information of this event
	*/
	@Override
	public void setAdditionalInformation(java.lang.String additionalInformation) {
		_event.setAdditionalInformation(additionalInformation);
	}

	/**
	* Sets the additional starting dates of this event.
	*
	* @param additionalStartingDates the additional starting dates of this event
	*/
	@Override
	public void setAdditionalStartingDates(
		java.lang.String additionalStartingDates) {
		_event.setAdditionalStartingDates(additionalStartingDates);
	}

	/**
	* Sets the additional starting dates rule of this event.
	*
	* @param additionalStartingDatesRule the additional starting dates rule of this event
	*/
	@Override
	public void setAdditionalStartingDatesRule(
		java.lang.String additionalStartingDatesRule) {
		_event.setAdditionalStartingDatesRule(additionalStartingDatesRule);
	}

	/**
	* Sets the address of this event.
	*
	* @param address the address of this event
	*/
	@Override
	public void setAddress(java.lang.String address) {
		_event.setAddress(address);
	}

	/**
	* Sets the admin comment of this event.
	*
	* @param adminComment the admin comment of this event
	*/
	@Override
	public void setAdminComment(java.lang.String adminComment) {
		_event.setAdminComment(adminComment);
	}

	/**
	* Sets the authorization token of this event.
	*
	* @param authorizationToken the authorization token of this event
	*/
	@Override
	public void setAuthorizationToken(java.lang.String authorizationToken) {
		_event.setAuthorizationToken(authorizationToken);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_event.setCachedModel(cachedModel);
	}

	/**
	* Sets the category IDs of this event.
	*
	* @param categoryIds the category IDs of this event
	*/
	@Override
	public void setCategoryIds(java.lang.String categoryIds) {
		_event.setCategoryIds(categoryIds);
	}

	/**
	* Sets the company ID of this event.
	*
	* @param companyId the company ID of this event
	*/
	@Override
	public void setCompanyId(long companyId) {
		_event.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this event.
	*
	* @param createDate the create date of this event
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_event.setCreateDate(createDate);
	}

	/**
	* Sets the description of this event.
	*
	* @param description the description of this event
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_event.setDescription(description);
	}

	/**
	* Sets the ending date of this event.
	*
	* @param endingDate the ending date of this event
	*/
	@Override
	public void setEndingDate(Date endingDate) {
		_event.setEndingDate(endingDate);
	}

	/**
	* Sets the event author email of this event.
	*
	* @param eventAuthorEmail the event author email of this event
	*/
	@Override
	public void setEventAuthorEmail(java.lang.String eventAuthorEmail) {
		_event.setEventAuthorEmail(eventAuthorEmail);
	}

	/**
	* Sets the event author name of this event.
	*
	* @param eventAuthorName the event author name of this event
	*/
	@Override
	public void setEventAuthorName(java.lang.String eventAuthorName) {
		_event.setEventAuthorName(eventAuthorName);
	}

	/**
	* Sets the event author phone number of this event.
	*
	* @param eventAuthorPhoneNumber the event author phone number of this event
	*/
	@Override
	public void setEventAuthorPhoneNumber(
		java.lang.String eventAuthorPhoneNumber) {
		_event.setEventAuthorPhoneNumber(eventAuthorPhoneNumber);
	}

	/**
	* Sets the event friendly name of this event.
	*
	* @param eventFriendlyName the event friendly name of this event
	*/
	@Override
	public void setEventFriendlyName(java.lang.String eventFriendlyName) {
		_event.setEventFriendlyName(eventFriendlyName);
	}

	/**
	* Sets the event ID of this event.
	*
	* @param eventId the event ID of this event
	*/
	@Override
	public void setEventId(long eventId) {
		_event.setEventId(eventId);
	}

	/**
	* Sets the event name of this event.
	*
	* @param eventName the event name of this event
	*/
	@Override
	public void setEventName(java.lang.String eventName) {
		_event.setEventName(eventName);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_event.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_event.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_event.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this event.
	*
	* @param groupId the group ID of this event
	*/
	@Override
	public void setGroupId(long groupId) {
		_event.setGroupId(groupId);
	}

	/**
	* Sets the image url of this event.
	*
	* @param imageUrl the image url of this event
	*/
	@Override
	public void setImageUrl(java.lang.String imageUrl) {
		_event.setImageUrl(imageUrl);
	}

	/**
	* Sets the link to event web page of this event.
	*
	* @param linkToEventWebPage the link to event web page of this event
	*/
	@Override
	public void setLinkToEventWebPage(java.lang.String linkToEventWebPage) {
		_event.setLinkToEventWebPage(linkToEventWebPage);
	}

	/**
	* Sets the location of this event.
	*
	* @param location the location of this event
	*/
	@Override
	public void setLocation(java.lang.String location) {
		_event.setLocation(location);
	}

	/**
	* Sets the modified date of this event.
	*
	* @param modifiedDate the modified date of this event
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_event.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_event.setNew(n);
	}

	/**
	* Sets the primary key of this event.
	*
	* @param primaryKey the primary key of this event
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_event.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_event.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets whether this event is show map.
	*
	* @param showMap the show map of this event
	*/
	@Override
	public void setShowMap(boolean showMap) {
		_event.setShowMap(showMap);
	}

	/**
	* Sets the sign up link of this event.
	*
	* @param signUpLink the sign up link of this event
	*/
	@Override
	public void setSignUpLink(java.lang.String signUpLink) {
		_event.setSignUpLink(signUpLink);
	}

	/**
	* Sets the starting date of this event.
	*
	* @param startingDate the starting date of this event
	*/
	@Override
	public void setStartingDate(Date startingDate) {
		_event.setStartingDate(startingDate);
	}

	/**
	* Sets the status of this event.
	*
	* @param status the status of this event
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_event.setStatus(status);
	}

	/**
	* Sets the times additional info of this event.
	*
	* @param timesAdditionalInfo the times additional info of this event
	*/
	@Override
	public void setTimesAdditionalInfo(java.lang.String timesAdditionalInfo) {
		_event.setTimesAdditionalInfo(timesAdditionalInfo);
	}

	/**
	* Sets the update url of this event.
	*
	* @param updateUrl the update url of this event
	*/
	@Override
	public void setUpdateUrl(java.lang.String updateUrl) {
		_event.setUpdateUrl(updateUrl);
	}

	/**
	* Sets the user given password of this event.
	*
	* @param userGivenPassword the user given password of this event
	*/
	@Override
	public void setUserGivenPassword(java.lang.String userGivenPassword) {
		_event.setUserGivenPassword(userGivenPassword);
	}

	/**
	* Sets the uuid of this event.
	*
	* @param uuid the uuid of this event
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_event.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EventWrapper)) {
			return false;
		}

		EventWrapper eventWrapper = (EventWrapper)obj;

		if (Objects.equals(_event, eventWrapper._event)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _event.getStagedModelType();
	}

	@Override
	public Event getWrappedModel() {
		return _event;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _event.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _event.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_event.resetOriginalValues();
	}

	private final Event _event;
}