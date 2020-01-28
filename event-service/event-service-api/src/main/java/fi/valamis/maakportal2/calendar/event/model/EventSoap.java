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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link fi.valamis.maakportal2.calendar.event.service.http.EventServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see fi.valamis.maakportal2.calendar.event.service.http.EventServiceSoap
 * @generated
 */
@ProviderType
public class EventSoap implements Serializable {
	public static EventSoap toSoapModel(Event model) {
		EventSoap soapModel = new EventSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEventId(model.getEventId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEventName(model.getEventName());
		soapModel.setStartingDate(model.getStartingDate());
		soapModel.setEndingDate(model.getEndingDate());
		soapModel.setTimesAdditionalInfo(model.getTimesAdditionalInfo());
		soapModel.setLocation(model.getLocation());
		soapModel.setAddress(model.getAddress());
		soapModel.setImageUrl(model.getImageUrl());
		soapModel.setDescription(model.getDescription());
		soapModel.setAdditionalInformation(model.getAdditionalInformation());
		soapModel.setSignUpLink(model.getSignUpLink());
		soapModel.setLinkToEventWebPage(model.getLinkToEventWebPage());
		soapModel.setCategoryIds(model.getCategoryIds());
		soapModel.setEventAuthorName(model.getEventAuthorName());
		soapModel.setEventAuthorEmail(model.getEventAuthorEmail());
		soapModel.setEventAuthorPhoneNumber(model.getEventAuthorPhoneNumber());
		soapModel.setAdditionalCompanyIds(model.getAdditionalCompanyIds());
		soapModel.setStatus(model.getStatus());
		soapModel.setAuthorizationToken(model.getAuthorizationToken());
		soapModel.setUserGivenPassword(model.getUserGivenPassword());
		soapModel.setAdminComment(model.getAdminComment());
		soapModel.setShowMap(model.getShowMap());
		soapModel.setUpdateUrl(model.getUpdateUrl());
		soapModel.setEventFriendlyName(model.getEventFriendlyName());
		soapModel.setAdditionalStartingDates(model.getAdditionalStartingDates());
		soapModel.setAdditionalStartingDatesRule(model.getAdditionalStartingDatesRule());

		return soapModel;
	}

	public static EventSoap[] toSoapModels(Event[] models) {
		EventSoap[] soapModels = new EventSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EventSoap[][] toSoapModels(Event[][] models) {
		EventSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EventSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EventSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EventSoap[] toSoapModels(List<Event> models) {
		List<EventSoap> soapModels = new ArrayList<EventSoap>(models.size());

		for (Event model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EventSoap[soapModels.size()]);
	}

	public EventSoap() {
	}

	public long getPrimaryKey() {
		return _eventId;
	}

	public void setPrimaryKey(long pk) {
		setEventId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEventId() {
		return _eventId;
	}

	public void setEventId(long eventId) {
		_eventId = eventId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getEventName() {
		return _eventName;
	}

	public void setEventName(String eventName) {
		_eventName = eventName;
	}

	public Date getStartingDate() {
		return _startingDate;
	}

	public void setStartingDate(Date startingDate) {
		_startingDate = startingDate;
	}

	public Date getEndingDate() {
		return _endingDate;
	}

	public void setEndingDate(Date endingDate) {
		_endingDate = endingDate;
	}

	public String getTimesAdditionalInfo() {
		return _timesAdditionalInfo;
	}

	public void setTimesAdditionalInfo(String timesAdditionalInfo) {
		_timesAdditionalInfo = timesAdditionalInfo;
	}

	public String getLocation() {
		return _location;
	}

	public void setLocation(String location) {
		_location = location;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public String getImageUrl() {
		return _imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		_imageUrl = imageUrl;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getAdditionalInformation() {
		return _additionalInformation;
	}

	public void setAdditionalInformation(String additionalInformation) {
		_additionalInformation = additionalInformation;
	}

	public String getSignUpLink() {
		return _signUpLink;
	}

	public void setSignUpLink(String signUpLink) {
		_signUpLink = signUpLink;
	}

	public String getLinkToEventWebPage() {
		return _linkToEventWebPage;
	}

	public void setLinkToEventWebPage(String linkToEventWebPage) {
		_linkToEventWebPage = linkToEventWebPage;
	}

	public String getCategoryIds() {
		return _categoryIds;
	}

	public void setCategoryIds(String categoryIds) {
		_categoryIds = categoryIds;
	}

	public String getEventAuthorName() {
		return _eventAuthorName;
	}

	public void setEventAuthorName(String eventAuthorName) {
		_eventAuthorName = eventAuthorName;
	}

	public String getEventAuthorEmail() {
		return _eventAuthorEmail;
	}

	public void setEventAuthorEmail(String eventAuthorEmail) {
		_eventAuthorEmail = eventAuthorEmail;
	}

	public String getEventAuthorPhoneNumber() {
		return _eventAuthorPhoneNumber;
	}

	public void setEventAuthorPhoneNumber(String eventAuthorPhoneNumber) {
		_eventAuthorPhoneNumber = eventAuthorPhoneNumber;
	}

	public String getAdditionalCompanyIds() {
		return _additionalCompanyIds;
	}

	public void setAdditionalCompanyIds(String additionalCompanyIds) {
		_additionalCompanyIds = additionalCompanyIds;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public String getAuthorizationToken() {
		return _authorizationToken;
	}

	public void setAuthorizationToken(String authorizationToken) {
		_authorizationToken = authorizationToken;
	}

	public String getUserGivenPassword() {
		return _userGivenPassword;
	}

	public void setUserGivenPassword(String userGivenPassword) {
		_userGivenPassword = userGivenPassword;
	}

	public String getAdminComment() {
		return _adminComment;
	}

	public void setAdminComment(String adminComment) {
		_adminComment = adminComment;
	}

	public boolean getShowMap() {
		return _showMap;
	}

	public boolean isShowMap() {
		return _showMap;
	}

	public void setShowMap(boolean showMap) {
		_showMap = showMap;
	}

	public String getUpdateUrl() {
		return _updateUrl;
	}

	public void setUpdateUrl(String updateUrl) {
		_updateUrl = updateUrl;
	}

	public String getEventFriendlyName() {
		return _eventFriendlyName;
	}

	public void setEventFriendlyName(String eventFriendlyName) {
		_eventFriendlyName = eventFriendlyName;
	}

	public String getAdditionalStartingDates() {
		return _additionalStartingDates;
	}

	public void setAdditionalStartingDates(String additionalStartingDates) {
		_additionalStartingDates = additionalStartingDates;
	}

	public String getAdditionalStartingDatesRule() {
		return _additionalStartingDatesRule;
	}

	public void setAdditionalStartingDatesRule(
		String additionalStartingDatesRule) {
		_additionalStartingDatesRule = additionalStartingDatesRule;
	}

	private String _uuid;
	private long _eventId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _eventName;
	private Date _startingDate;
	private Date _endingDate;
	private String _timesAdditionalInfo;
	private String _location;
	private String _address;
	private String _imageUrl;
	private String _description;
	private String _additionalInformation;
	private String _signUpLink;
	private String _linkToEventWebPage;
	private String _categoryIds;
	private String _eventAuthorName;
	private String _eventAuthorEmail;
	private String _eventAuthorPhoneNumber;
	private String _additionalCompanyIds;
	private String _status;
	private String _authorizationToken;
	private String _userGivenPassword;
	private String _adminComment;
	private boolean _showMap;
	private String _updateUrl;
	private String _eventFriendlyName;
	private String _additionalStartingDates;
	private String _additionalStartingDatesRule;
}