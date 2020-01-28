package fi.valamis.maakportal2.calendar.application.list;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;

import fi.valamis.maakportal2.calendar.constants.CalendarPortletKeys;

@Component(
		immediate = true,
		property = {
			"panel.app.order:Integer=100",
			"panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_CONTENT
		},
		service = PanelApp.class
	)
public class CalendarAdminPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return CalendarPortletKeys.CalendarAdmin;
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + CalendarPortletKeys.CalendarAdmin + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}
}
