package fi.valamis.maakportal2.events.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.osgi.service.component.annotations.Component;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;

import fi.valamis.maakportal2.calendar.event.model.Event;
import fi.valamis.maakportal2.calendar.event.service.EventLocalServiceUtil;
import fi.valamis.maakportal2.events.application.CorsFilter;

/**
 * @author sakerman
 */
@ApplicationPath("/events")
@Component(immediate = true, service = Application.class)
public class EventRestApplication extends Application {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    @Override
    public Set<Object> getSingletons() {
        final Set<Object> singletons = new HashSet<>();
    	singletons.add(this);
        // Giving cors filter object to the application/resource config
    	singletons.add(new CorsFilter());
    	return singletons;
    }

	@GET
    @Path("/withStatus/{companyId}/{status}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getEventsByStatusAndCompanyId(@PathParam("companyId") long companyId,@PathParam("status") String status) {
        List<Event> entries = EventLocalServiceUtil.getEventsByCompanyIdAndStatus(companyId, status, -1, -1);
        List<Event> toReturn = new ArrayList<Event>();
        for (Event e : entries) {
            toReturn.add(mapEvent(e));
        }
        return JSONFactoryUtil.looseSerialize(toReturn);
    }

	@GET
    @Path("/withDate/{companyId}/{date}/{categoryId}/{filter}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getEventsByDateAndCompanyId(@PathParam("companyId") long companyId,@PathParam("date") String date,@PathParam("categoryId") String categoryId,@PathParam("filter") String filter) {
		Date d = null;
		try {
			d = sdf.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(categoryId.equals("null") && filter.equals("null")) {
			return JSONFactoryUtil.looseSerialize(EventLocalServiceUtil.filterFutureEvents(companyId, d, "Approved", -1, -1));
        } else {
			return filterByCategory(categoryId, filter, EventLocalServiceUtil.filterFutureEvents(companyId, d, "Approved", -1, -1));
		}
    }
	
	@GET
    @Path("/withMonth/{companyId}/{startDate}/{endDate}/{categoryId}/{filter}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getEventsByMonthAndCompanyId(@PathParam("companyId") long companyId,@PathParam("startDate") String startDate,@PathParam("endDate") String endDate,@PathParam("categoryId") String categoryId,@PathParam("filter") String filter) {
		Date sd = null;
		Date ed = null;
		try {
			sd = sdf.parse(startDate);
			ed = sdf.parse(endDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(categoryId.equals("null") && filter.equals("null")) {
			return JSONFactoryUtil.looseSerialize(EventLocalServiceUtil.filterByEndingDate(companyId, sd, ed, "Approved", -1, -1));
        } else {
			return filterByCategory(categoryId, filter, EventLocalServiceUtil.filterByEndingDate(companyId, sd, ed, "Approved", -1, -1));
		}
    }

	private static String filterByCategory(String categoryId, String filter, List<Event> events) {

        List<Event> toReturn = new ArrayList<Event>();

        for(Event e : events) {
            if (!filter.equals("null")) {
                // Get all possible categories within "filter"
                try {
                    List<AssetCategory> ac = AssetCategoryLocalServiceUtil.getVocabularyCategories(Long.parseLong(filter), 0, 9999, null);
                    for(AssetCategory acs : ac) {
                        if(e.getCategoryIds().contains(Long.toString(acs.getCategoryId()))) {
                            toReturn.add(e);
                            break;
                        }
                    }
                    if (e.getCategoryIds().equals(filter)) {
                        toReturn.add(e);
                    }
                } catch (Exception err) {
                    //DO NOTHING
                }
            } else {
                // Get only selected category
                if(e.getCategoryIds().contains(categoryId)) {
                    toReturn.add(e);
                }
            }
        }
        return JSONFactoryUtil.looseSerialize(toReturn);
	}
	
	@GET
    @Path("/eventCategories/{eventId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getEventCategories(@PathParam("eventId") long eventId) {
        Event e = null;
		try {
			e = EventLocalServiceUtil.getEvent(eventId);
		} catch (PortalException e1) {
			return "";
		}
        ArrayList<String> categories = new ArrayList<String>();
        String name = "";
        if(e != null) {
            String[] catIds = e.getCategoryIds().split(",");
    		if(catIds != null && catIds.length > 0 && !catIds[0].equals("false") && !catIds[0].isEmpty()){
	    		for(int i = 0; i<catIds.length; i++){
	    			try {
                        name = AssetCategoryLocalServiceUtil.getAssetCategory(Long.parseLong(catIds[i])).getName();
                        if (!name.equals("")) {
                            categories.add(name);
                        }
                    } catch (Exception e1) {
                        //DO NOTHING
					} 
	    		}
            }
        }
        return JSONFactoryUtil.looseSerialize(categories);
    }

    @GET
    @Path("/categories/{vocabluraryId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCategoriesByVocabluraryId(@PathParam("vocabluraryId") long vocabluraryId) {
        List<AssetCategory> assetCategories = new ArrayList<>();
        try {
            assetCategories = AssetCategoryLocalServiceUtil.getVocabularyCategories(vocabluraryId, 0, AssetCategoryLocalServiceUtil.getAssetCategoriesCount(), null);

        }catch (Exception e) {
            //Do Nothing
        }
        return JSONFactoryUtil.looseSerialize(assetCategories);
    }

    /**
     * Api end point to get a event by event friendly name
     * @param eventFriendlyName
     * @return new @link{Event}
     *
     */
    @GET
    @Path("/withName/{eventFriendlyName}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getEventByEventFriendlyName(@PathParam("eventFriendlyName") String eventFriendlyName) {
        Event event;
        Event toReturn = EventLocalServiceUtil.createEvent();
        try{
             event =  EventLocalServiceUtil.findEventByFriendlyName(eventFriendlyName);
             toReturn = mapEvent(event);

        }catch (Exception e) {
            //Do Nothing
        }
        return JSONFactoryUtil.looseSerialize(toReturn);
    }

    /**
     * This function maps values of event to new event object
     * @param eventToBeMapped
     * @return new @link{Event}
     */
    private static Event mapEvent(Event eventToBeMapped) {
        Event eo = EventLocalServiceUtil.createEvent();
        eo.setEventId(eventToBeMapped.getEventId());
        eo.setEventName(eventToBeMapped.getEventName());
        eo.setStartingDate(eventToBeMapped.getStartingDate());
        eo.setEndingDate(eventToBeMapped.getEndingDate());
        eo.setCategoryIds(eventToBeMapped.getCategoryIds());
        eo.setEventFriendlyName(eventToBeMapped.getEventFriendlyName());
        eo.setAdditionalStartingDates(eventToBeMapped.getAdditionalStartingDates());
        eo.setLocation(eventToBeMapped.getLocation());
        eo.setAddress(eventToBeMapped.getAddress());
        eo.setImageUrl(eventToBeMapped.getImageUrl());
        eo.setLinkToEventWebPage(eventToBeMapped.getLinkToEventWebPage());
        eo.setDescription(eventToBeMapped.getDescription());
        eo.setAdditionalInformation(eventToBeMapped.getAdditionalInformation());
        eo.setSignUpLink(eventToBeMapped.getSignUpLink());
        eo.setTimesAdditionalInfo(eventToBeMapped.getTimesAdditionalInfo());
        eo.setCompanyId(eventToBeMapped.getCompanyId());
        return eo;
    }
	
}