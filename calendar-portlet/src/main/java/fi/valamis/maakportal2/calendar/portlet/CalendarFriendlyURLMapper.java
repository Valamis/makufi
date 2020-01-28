package fi.valamis.maakportal2.calendar.portlet;

import fi.valamis.maakportal2.calendar.constants.CalendarPortletKeys;
import org.osgi.service.component.annotations.Component;
import com.liferay.portal.kernel.portlet.*;

@Component(
        property = {
                "com.liferay.portlet.friendly-url-routes=META-INF/friendly-url-routes/routes.xml",
                "javax.portlet.name=" + CalendarPortletKeys.Calendar
        },
        service = FriendlyURLMapper.class
)

public class CalendarFriendlyURLMapper extends DefaultFriendlyURLMapper {

    @Override
    public String getMapping() {
        return _MAPPING;
    }

    private static final String _MAPPING = "kalenteri";

}