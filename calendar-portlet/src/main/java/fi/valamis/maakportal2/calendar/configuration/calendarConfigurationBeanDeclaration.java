package fi.valamis.maakportal2.calendar.configuration;

import org.osgi.service.component.annotations.Component;
import fi.valamis.maakportal2.calendar.configuration.CalendarConfiguration;
import com.liferay.portal.kernel.settings.definition.ConfigurationBeanDeclaration;

@Component
public class calendarConfigurationBeanDeclaration implements ConfigurationBeanDeclaration {

    @Override
    public Class getConfigurationBeanClass() {
        return CalendarConfiguration.class;
    }

}