package fi.valamis.maakportal2.calendar.utils;

import java.io.StringWriter;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.template.TemplateConstants;
import com.liferay.portal.kernel.template.TemplateException;
import com.liferay.portal.kernel.template.TemplateManagerUtil;
import com.liferay.portal.kernel.template.TemplateResource;
import com.liferay.portal.kernel.template.URLTemplateResource;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.exception.PortalException;

import fi.valamis.maakportal2.calendar.event.model.Event;

public class EmailUtil {
	
	public static void sendEventNotification(Event e, String subject, ActionRequest actionRequest){
		InternetAddress fromAddress = null;
		InternetAddress toAddress = null;
        String body = "";
		
		try {
            TemplateResource templateResource = new URLTemplateResource("0",EmailUtil.class.getClassLoader().getResource("eventCreated.ftl"));
            if (e.getStatus().equals("Approved")) {
                templateResource = new URLTemplateResource("0",EmailUtil.class.getClassLoader().getResource("eventApproved.ftl"));
            }
			Template template = TemplateManagerUtil.getTemplate(
			TemplateConstants.LANG_TYPE_FTL, templateResource, false);

	        template.put("event", e);
	        	StringWriter out = new StringWriter();
	        
	        	template.processTemplate(out);
	        	body = out.toString();
		} catch (TemplateException e1) {
			e1.printStackTrace();
		}

		try {
			fromAddress = getSenderEmail(actionRequest);
			toAddress = new InternetAddress(e.getEventAuthorEmail());
			MailMessage mailMessage = new MailMessage();
			mailMessage.setTo(toAddress);
			mailMessage.setFrom(fromAddress);
			mailMessage.setSubject(subject + " - " + e.getEventName());
			mailMessage.setBody(body);
			mailMessage.setHTMLFormat(false);
			MailServiceUtil.sendEmail(mailMessage);
		}
		catch (AddressException ex) {
			ex.printStackTrace(); 
		}
	}
	
	public static void sendEventUpdatedNotification(Event e, String subject, ActionRequest actionRequest){
		InternetAddress fromAddress = null;
		InternetAddress toAddress = null;
		String body = "";
		
		try {
			TemplateResource templateResource = new URLTemplateResource("0",EmailUtil.class.getClassLoader().getResource("eventUpdated.ftl"));
			Template template = TemplateManagerUtil.getTemplate(
			TemplateConstants.LANG_TYPE_FTL, templateResource, false);

			template.put("event", e);
	        
	        	StringWriter out = new StringWriter();
	        
	        	template.processTemplate(out);
	        	body = out.toString();
		} catch (TemplateException e1) {
			e1.printStackTrace();
		}

		try {
			fromAddress = getSenderEmail(actionRequest);
			toAddress = new InternetAddress(e.getEventAuthorEmail());
			MailMessage mailMessage = new MailMessage();
			mailMessage.setTo(toAddress);
			mailMessage.setFrom(fromAddress);
			mailMessage.setSubject(subject + " - " + e.getEventName());
			mailMessage.setBody(body);
			mailMessage.setHTMLFormat(false);
			MailServiceUtil.sendEmail(mailMessage);
		}
		catch (AddressException ex) {
			ex.printStackTrace(); 
		}
	}
	
	public static void sendEventInfoRequestNotification(Event e, String subject, ActionRequest actionRequest){
		InternetAddress fromAddress = null;
		InternetAddress toAddress = null;
		String body = "";
		
		try {
			TemplateResource templateResource = new URLTemplateResource("0",EmailUtil.class.getClassLoader().getResource("eventMoreInfo.ftl"));
			Template template = TemplateManagerUtil.getTemplate(
			TemplateConstants.LANG_TYPE_FTL, templateResource, false);

	        template.put("event", e);
	        
	        	StringWriter out = new StringWriter();
	        
	        	template.processTemplate(out);
	        	body = out.toString();		        
		} catch (TemplateException e1) {
			e1.printStackTrace();
		}

		try {
			fromAddress = getSenderEmail(actionRequest);
			toAddress = new InternetAddress(e.getEventAuthorEmail());
			MailMessage mailMessage = new MailMessage();
			mailMessage.setTo(toAddress);
			mailMessage.setFrom(fromAddress);
			mailMessage.setSubject(subject + " - " + e.getEventName());
			mailMessage.setBody(body);
			mailMessage.setHTMLFormat(false);
			MailServiceUtil.sendEmail(mailMessage);
		}
		catch (AddressException ex) {
			ex.printStackTrace(); 
		}
	}
	
	public static void sendNotificationToAdmin(Event e, String notificationEmail, String subject, ActionRequest actionRequest){
		InternetAddress fromAddress = null;
		String body = "";
		
		try {
            TemplateResource templateResource = new URLTemplateResource("0",EmailUtil.class.getClassLoader().getResource("eventNotification.ftl"));
			Template template = TemplateManagerUtil.getTemplate(
			TemplateConstants.LANG_TYPE_FTL, templateResource, false);

            template.put("event", e);
	        
	        	StringWriter out = new StringWriter();
	        
	        	template.processTemplate(out);
	        	body = out.toString();
		} catch (TemplateException e1) {
			e1.printStackTrace();
		}

		try {
			fromAddress = getSenderEmail(actionRequest);
			InternetAddress[] toAddress = InternetAddress.parse(notificationEmail , true);
			MailMessage mailMessage = new MailMessage();
			mailMessage.setTo(toAddress);
			mailMessage.setFrom(fromAddress);
			mailMessage.setSubject(subject + " - " + e.getEventName());
			mailMessage.setBody(body);
			mailMessage.setHTMLFormat(false);
			MailServiceUtil.sendEmail(mailMessage);
		}
		catch (AddressException ex) {
			ex.printStackTrace(); 
		}
	}

	public static boolean isValidEmailAddress(String email) {
		boolean result = true;
		try {
			InternetAddress emailAddr = new InternetAddress(email);
			emailAddr.validate();
		} catch (AddressException ex) {
			result = false;
		}
		return result;
    }
    
    public static InternetAddress getSenderEmail(ActionRequest actionRequest) {

        String portalSenderAddress = PortalUtil.getPortalProperties().getProperty("admin.email.from.address");
        System.out.println("Send email as " + portalSenderAddress);

        try {
            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
            String siteCustomFieldName = "Event-calendar-from-email";
            if(themeDisplay.getScopeGroup().getExpandoBridge().hasAttribute(siteCustomFieldName)){
                String cFiledValue = (String) themeDisplay.getScopeGroup().getExpandoBridge().getAttribute(siteCustomFieldName);
                if (cFiledValue != null && !cFiledValue.isEmpty()) {
                    portalSenderAddress = cFiledValue;
                }
            }
        } catch (Exception err) {
            System.out.println(err);
        }

        InternetAddress senderAddress = new InternetAddress();
        try {
            senderAddress = new InternetAddress(portalSenderAddress);
        } catch (AddressException ex) {
            System.out.println(ex);
            // DO NOTHING
        }
        return senderAddress;
    }
}