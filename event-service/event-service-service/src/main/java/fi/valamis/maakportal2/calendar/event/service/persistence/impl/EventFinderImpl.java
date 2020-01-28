package fi.valamis.maakportal2.calendar.event.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.exception.SystemException;
import fi.valamis.maakportal2.calendar.event.model.Event;
import fi.valamis.maakportal2.calendar.event.service.EventLocalServiceUtil;
import fi.valamis.maakportal2.calendar.event.service.persistence.EventFinder;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EventFinderImpl extends EventFinderBaseImpl implements EventFinder{
	
	public List<Event> findEventsBetweenDates(long companyId, String status, Date startingDate, Date endingDate, int startr, int endr){
		Session session = null;
	    try {
	        session = openSession();
	        Class<?> clazz = getClass();
	        
	        Order order = OrderFactoryUtil.asc("startingDate");
	        Criterion comp1 = RestrictionsFactoryUtil.eq("companyId", companyId);
	        Criterion comp2 = RestrictionsFactoryUtil.like("additionalCompanyIds", "%"+companyId+"%");
	        Criterion company = RestrictionsFactoryUtil.or(comp1, comp2);

	        DynamicQuery query = DynamicQueryFactoryUtil.forClass(Event.class, clazz.getClassLoader())
	            .add(RestrictionsFactoryUtil.eq("status", status))
	            .add(company)
	            .addOrder(order);
	        startingDate.setHours(23);
	        startingDate.setMinutes(59);
	        startingDate.setSeconds(59);
	        Criterion start = RestrictionsFactoryUtil.lt("startingDate", startingDate);
	        
	        endingDate.setHours(0);
	        endingDate.setMinutes(0);
	        endingDate.setSeconds(0);
	        Criterion end = RestrictionsFactoryUtil.gt("endingDate", endingDate);
	        endingDate.setHours(23);
	        endingDate.setMinutes(59);
	        endingDate.setSeconds(59);
	        startingDate.setHours(0);
	        startingDate.setMinutes(0);
	        startingDate.setSeconds(0);
	        Criterion oob = RestrictionsFactoryUtil.and(start, end);
	        Criterion c1 = RestrictionsFactoryUtil.between("startingDate", startingDate, endingDate);
	        Criterion c2 = RestrictionsFactoryUtil.between("endingDate", startingDate, endingDate);
	        Criterion soe = RestrictionsFactoryUtil.or(c1, c2);
	        
            Criterion soFar = RestrictionsFactoryUtil.or(oob, soe);

            // Or in additionaldates
            SimpleDateFormat lformat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sformat = new SimpleDateFormat("yyyy-MM");
            String likeMonth = sformat.format(startingDate);
            if (lformat.format(startingDate).equals(lformat.format(endingDate))) {
                // just one day
                likeMonth = lformat.format(startingDate);
            }
            Criterion addDates = RestrictionsFactoryUtil.like("additionalStartingDates", "%"+likeMonth+"%");
	        query.add(RestrictionsFactoryUtil.or(soFar, addDates));
            
            ProjectionList projectionList = ProjectionFactoryUtil.projectionList();
            projectionList.add(ProjectionFactoryUtil.property("eventId"));
            projectionList.add(ProjectionFactoryUtil.property("eventName"));
			projectionList.add(ProjectionFactoryUtil.property("startingDate"));
			projectionList.add(ProjectionFactoryUtil.property("endingDate"));
			projectionList.add(ProjectionFactoryUtil.property("categoryIds"));
            projectionList.add(ProjectionFactoryUtil.property("eventFriendlyName"));
            projectionList.add(ProjectionFactoryUtil.property("additionalStartingDates"));
            projectionList.add(ProjectionFactoryUtil.property("imageUrl"));
            projectionList.add(ProjectionFactoryUtil.property("location"));
            projectionList.add(ProjectionFactoryUtil.property("address"));
            projectionList.add(ProjectionFactoryUtil.property("linkToEventWebPage"));
            projectionList.add(ProjectionFactoryUtil.property("description"));
            projectionList.add(ProjectionFactoryUtil.property("additionalInformation"));
            projectionList.add(ProjectionFactoryUtil.property("signUpLink"));
            projectionList.add(ProjectionFactoryUtil.property("timesAdditionalInfo"));
            projectionList.add(ProjectionFactoryUtil.property("companyId"));
            query.setProjection(projectionList);
            
            List<Object[]> entries = EventLocalServiceUtil.dynamicQuery(query, startr, endr);

            List<Event> toReturn = new ArrayList<Event>();
            for (Object[] e : entries) {
                Event eo = EventLocalServiceUtil.createEvent();
                eo.setEventId((Long) e[0]);
                eo.setEventName((String) e[1]);
				eo.setStartingDate((Date) e[2]);
				eo.setEndingDate((Date) e[3]);
				eo.setCategoryIds((String) e[4]);
                eo.setEventFriendlyName((String) e[5]);
                eo.setAdditionalStartingDates((String) e[6]);
                eo.setImageUrl((String) e[7]);
                eo.setLocation((String) e[8]);
                eo.setAddress((String) e[9]);
                eo.setLinkToEventWebPage((String)e[10]);
                eo.setDescription((String)e[11]);
                eo.setAdditionalInformation((String)e[12]);
                eo.setSignUpLink((String)e[13]);
                eo.setTimesAdditionalInfo((String)e[14]);
                eo.setCompanyId((long)e[15]);
                toReturn.add(eo);
            }

	        return toReturn;
	    }
	    catch (Exception e) {
	        try {
	            throw new SystemException(e);
	        }
	        catch (SystemException se) {
	            se.printStackTrace();
	        }
	    }
	    finally {
	        closeSession(session);
	    }
		return null;
	}
	
	public List<Event> findEventsFromDates(long companyId, String status, Date startingDate, int start, int end){
		Session session = null;
	    try {
	        session = openSession();
	        Class<?> clazz = getClass();
	        
	        Order order = OrderFactoryUtil.asc("startingDate");
	        Criterion comp1 = RestrictionsFactoryUtil.eq("companyId", companyId);
	        Criterion comp2 = RestrictionsFactoryUtil.like("additionalCompanyIds", "%"+companyId+"%");
	        Criterion company = RestrictionsFactoryUtil.or(comp1, comp2);

	        DynamicQuery query = DynamicQueryFactoryUtil.forClass(Event.class, clazz.getClassLoader())
	            .add(RestrictionsFactoryUtil.eq("status", status))
	            .add(company)
	            .addOrder(order);
	        startingDate.setHours(0);
	        startingDate.setMinutes(0);
	        startingDate.setSeconds(0);
	        
	        Criterion c1 = RestrictionsFactoryUtil.lt("startingDate", startingDate);
	        Criterion c2 = RestrictionsFactoryUtil.gt("endingDate", startingDate);
	        Criterion soe = RestrictionsFactoryUtil.and(c1, c2);
	        
	        Criterion c3 = RestrictionsFactoryUtil.gt("startingDate", startingDate);
	        Criterion c4 = RestrictionsFactoryUtil.eq("startingDate", startingDate);
	        Criterion oob = RestrictionsFactoryUtil.or(c3, c4);
	        
            Criterion soFar = RestrictionsFactoryUtil.or(oob, soe);

            // Or in additionaldates
            SimpleDateFormat lformat = new SimpleDateFormat("yyyy-MM-dd");
            String likeMonth = lformat.format(startingDate);
            System.out.println(likeMonth);
            Criterion addDates = RestrictionsFactoryUtil.like("additionalStartingDates", "%"+likeMonth+"%");
	        query.add(RestrictionsFactoryUtil.or(soFar, addDates));

            ProjectionList projectionList = ProjectionFactoryUtil.projectionList();
            projectionList.add(ProjectionFactoryUtil.property("eventId"));
            projectionList.add(ProjectionFactoryUtil.property("eventName"));
			projectionList.add(ProjectionFactoryUtil.property("startingDate"));
			projectionList.add(ProjectionFactoryUtil.property("endingDate"));
			projectionList.add(ProjectionFactoryUtil.property("categoryIds"));
            projectionList.add(ProjectionFactoryUtil.property("eventFriendlyName"));
            projectionList.add(ProjectionFactoryUtil.property("additionalStartingDates"));
            projectionList.add(ProjectionFactoryUtil.property("imageUrl"));
			projectionList.add(ProjectionFactoryUtil.property("location"));
			projectionList.add(ProjectionFactoryUtil.property("address"));
            projectionList.add(ProjectionFactoryUtil.property("linkToEventWebPage"));
            projectionList.add(ProjectionFactoryUtil.property("description"));
            projectionList.add(ProjectionFactoryUtil.property("additionalInformation"));
            projectionList.add(ProjectionFactoryUtil.property("signUpLink"));
            projectionList.add(ProjectionFactoryUtil.property("timesAdditionalInfo"));
            projectionList.add(ProjectionFactoryUtil.property("companyId"));
            query.setProjection(projectionList);

            List<Object[]> entries = EventLocalServiceUtil.dynamicQuery(query, start, end);

            List<Event> toReturn = new ArrayList<Event>();
            for (Object[] e : entries) {
                Event eo = EventLocalServiceUtil.createEvent();
                eo.setEventId((Long) e[0]);
                eo.setEventName((String) e[1]);
				eo.setStartingDate((Date) e[2]);
				eo.setEndingDate((Date) e[3]);
				eo.setCategoryIds((String) e[4]);
                eo.setEventFriendlyName((String) e[5]);
                eo.setAdditionalStartingDates((String) e[6]);
                eo.setImageUrl((String) e[7]);
				eo.setLocation((String) e[8]);
				eo.setAddress((String) e[9]);
                eo.setLinkToEventWebPage((String)e[10]);
                eo.setDescription((String)e[11]);
                eo.setAdditionalInformation((String)e[12]);
                eo.setSignUpLink((String)e[13]);
                eo.setTimesAdditionalInfo((String)e[14]);
                eo.setCompanyId((long)e[15]);
                toReturn.add(eo);
            }

	        return toReturn;
	    }
	    catch (Exception e) {
	        try {
	            throw new SystemException(e);
	        }
	        catch (SystemException se) {
	            se.printStackTrace();
	        }
	    }
	    finally {
	        closeSession(session);
	    }
		return null;
	}

	public List<Event> findEventsByFriendlyName(String eventFriendlyName){
		Session session = null;
	    try {
	        session = openSession();
	        Class<?> clazz = getClass();
	        
	        Criterion friendlyName = RestrictionsFactoryUtil.like("eventFriendlyName", eventFriendlyName + "%");
	        DynamicQuery query = DynamicQueryFactoryUtil.forClass(Event.class, clazz.getClassLoader())
	            .add(friendlyName);
	        
            List<Event> entries = EventLocalServiceUtil.dynamicQuery(query);
	        return entries;
	    }
	    catch (Exception e) {
	        try {
	            throw new SystemException(e);
	        }
	        catch (SystemException se) {
	            se.printStackTrace();
	        }
	    }
	    finally {
	        closeSession(session);
	    }
		return null;
    }
    
	public Event findEventByFriendlyName(String eventFriendlyName){
		Session session = null;
	    try {
	        session = openSession();
	        Class<?> clazz = getClass();
	        
	        Criterion friendlyName = RestrictionsFactoryUtil.eq("eventFriendlyName", eventFriendlyName);
	        
	        DynamicQuery query = DynamicQueryFactoryUtil.forClass(Event.class, clazz.getClassLoader())
	            .add(friendlyName);
	        
            List<Event> entries = EventLocalServiceUtil.dynamicQuery(query);

            Event e = null;
            if (!entries.isEmpty()) {
                e = entries.get(0);
            }
	        return e;
	    }
	    catch (Exception e) {
	        try {
	            throw new SystemException(e);
	        }
	        catch (SystemException se) {
	            se.printStackTrace();
	        }
	    }
	    finally {
	        closeSession(session);
	    }
		return null;
	}
}
