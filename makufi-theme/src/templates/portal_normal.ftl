<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<#include "${full_templates_path}/init_custom.ftl" />
	<#if the_title?has_content>
		<title>${the_title} - ${site_name}</title>
	<#else>
		<title>${site_name}</title>
	</#if>
	<meta content="initial-scale=1.0, width=device-width" name="viewport" />
	<!-- favicon from expando field -->
	<#if page_group.getExpandoBridge().hasAttribute("faviconpath")>
		<#assign faviconpath = page_group.getExpandoBridge().getAttribute("faviconpath")! />
		<#if faviconpath?has_content>
			<link data-senna-track="temporary" href="${faviconpath}" rel="Shortcut Icon">
		</#if>
	</#if>
	<#if page_group.getExpandoBridge().hasAttribute("extraAttributesToHead")>
		<#assign extraAttributesToHead = page_group.getExpandoBridge().getAttribute("extraAttributesToHead")! />
		<#if extraAttributesToHead?has_content>
			${extraAttributesToHead}
		</#if>
	</#if>
	<#if page_group.getExpandoBridge().hasAttribute("remain-navigation-state")>
		<#assign remainnavigationstate = page_group.getExpandoBridge().getAttribute("remain-navigation-state")! />
		<#if remainnavigationstate?has_content>
		<script>
			var rns = ${remainnavigationstate?string};
		</script>
		</#if>
	</#if>
	<@liferay_util["include"] page=top_head_include />

    <#if !canonicalUrl?contains("/asset_publisher/")>
        <meta property="og:url" content="${canonicalUrl}">
        <meta name="twitter:url" content="${canonicalUrl}">
        <meta name="twitter:card" content="summary_large_image">
        <meta name="twitter:site" content="${site_name}">
        <meta property="og:site_name" content="${site_name}">
        <#if the_title?has_content>
            <meta name="twitter:title" content="${the_title}" />
            <meta property="og:title" content="${the_title}" />
        <#else>
            <meta name="twitter:title" content="${site_name}" />
            <meta property="og:title" content="${site_name}" />
        </#if>
        <meta name="twitter:description" content="${themeDisplay.getLayout().getDescriptionCurrentValue()}" />
        <meta property="og:description" content="${themeDisplay.getLayout().getDescriptionCurrentValue()}" />
        <!-- Open Graph data -->
        <meta property="og:type" content="website" />
        <#if page.getExpandoBridge().hasAttribute("somepagespecific")>
            <#assign somePageSpecific = page.getExpandoBridge().getAttribute("somepagespecific")! />
            <#if somePageSpecific?has_content>
                <!-- somepagespecific some default image -->
                <meta property="og:image" content="${somePageSpecific}" />
                <meta name="twitter:image" content="${somePageSpecific}" />
            </#if>
        </#if>
        <#if page_group.getExpandoBridge().hasAttribute("somedefaultimage")>
            <#assign someDefaultImage = page_group.getExpandoBridge().getAttribute("somedefaultimage")! />
            <#if someDefaultImage?has_content>
                <!-- somedefaultimage some default image -->
                <meta property="og:image" content="${someDefaultImage}" />
                <meta name="twitter:image" content="${someDefaultImage}" />
            </#if>
        </#if>
    </#if>

	<!-- Chat palveluiden importtaaminen mikäli url/id esitelty sivun lisäkentissä -->
	<#attempt>
		<#if page.getExpandoBridge().hasAttribute("OCChatID")>
			<#assign chatid = page.getExpandoBridge().getAttribute("OCChatID")! />
		</#if>
		<#if chatid?has_content>
			<script>
			    define._amd = define.amd;
			    define.amd = false;
			</script>
			<script charset="utf-8" id="oc-start-up" data-oc-service="${chatid}" data-main="https://occhat.elisa.fi/chatserver/Scripts/oc-chat" src="https://occhat.elisa.fi/chatserver/Scripts/require.js" data-oc-language="fi_FI"></script>
			<script>
			    define.amd = define._amd;
			</script>
		</#if>
	<#recover>

	</#attempt>
	<#attempt>
		<#if page.getExpandoBridge().hasAttribute("ElisaChatID")>
			<#assign elisachatid = page.getExpandoBridge().getAttribute("ElisaChatID")! />
		</#if>
		<#if elisachatid?has_content>
			<script type="text/javascript">
				(function() {
			        var sc = document.createElement('script');
			        sc.type = 'text/javascript';
			        sc.async = true;
			        sc.src = ('https:' == document.location.protocol ? 'https://zefzhat-eu.appspot.com' : 'http://www.livezhat.fi') + '${elisachatid}';
			        var s = document.getElementsByTagName('script')[0];
			        s.parentNode.insertBefore(sc, s);
				})();
			</script>
		</#if>
	<#recover>

	</#attempt>
	<!-- Chat palveluiden importtaaminen päättyy -->
	<!-- inject:js -->
	<script type="text/javascript" src="${javascript_folder}/EQCSS.js"></script>
	<script type="text/javascript" src="${javascript_folder}/jquery.cookie.js"></script>
	<script type="text/javascript" src="${javascript_folder}/instafeed.min.js"></script>
	<script>
	    EQCSS.apply();
	</script>
	<!-- endinject -->
    <link href="https://fonts.googleapis.com/css?family=Raleway:600,600i,700,700i,800,800i&subset=latin-ext" rel="stylesheet">
	<#assign extraClassToBody = "" />
	<#if page.getExpandoBridge().hasAttribute("extraClassToBody")>
		<#assign extraClassToBody = page.getExpandoBridge().getAttribute("extraClassToBody")! />
	</#if>
</head>
<body class="${css_class} ${extraClassToBody}">
<nav class="quick-access-nav" id="sstj_quickAccessNav">
	<ul>
		<li>
			<a href="#main-content-actual"><@liferay.language key="quick-access" /></a>
		</li>
	</ul>
</nav>

<@liferay_util["include"] page=body_top_include />

<@liferay.control_menu />

<#if has_navigation>
	<#include "${full_templates_path}/navigation.ftl" />
    <div class="navigation-overlay hide-overlay"></div>
</#if>

<div class="container-fluid" id="wrapper">
	<header id="banner" role="banner">
		<div id="heading">
			<#include "${full_templates_path}/header.ftl" />
		</div>
	</header>

	<section id="content">
		<div id="main-content-wrapper">
			<h1 class="hide-accessible">${the_title}</h1>
			<#if selectable>
				<@liferay_util["include"] page=content_include />
			<#else>
				${portletDisplay.recycle()}

				${portletDisplay.setTitle(the_title)}

				<@liferay_theme["wrap-portlet"] page="portlet.ftl">
					<@liferay_util["include"] page=content_include />
				</@>
			</#if>
		</div>
		<#if page.getExpandoBridge().hasAttribute("somepagespecific")>
		    <#assign somePageSpecific = page.getExpandoBridge().getAttribute("somepagespecific")! />
			<input title="system" style="display: none;" id="metaSpecificImage" type="text" name="specificImage" value="${somePageSpecific}">
		</#if>
		<#if page_group.getExpandoBridge().hasAttribute("somedefaultimage")>
			<#assign someDefaultImage = page_group.getExpandoBridge().getAttribute("somedefaultimage")! />
			<input title="system" style="display: none;" id="metaDefaultImage" type="text" name="defaultImage" value="${someDefaultImage}">
		</#if>
		<#assign cookieannouncement = "" />
		<#if page_group.getExpandoBridge().hasAttribute("cookieannouncement")>
			<#assign cookieannouncement = page_group.getExpandoBridge().getAttribute("cookieannouncement")! />
		</#if>
		<div id="cookie-info" class="hidden" aria-hidden="true">
		    <div class="cookie-info-inner">
		        <div class="close"><span>&nbsp;</span></div>
		        <div class="text"><@liferay.language key="cookie-info-text"/><br>${cookieannouncement}
		        </div>
		        <div class="button">
		            <button type="button"><@liferay.language key="cookie-info-button"/></button>
		        </div>
		    </div>
		</div>
	</section>
	<footer id="footer">
		<#attempt>
			<#if page_group.getExpandoBridge().hasAttribute("FooterArticleID")>
				<#assign articleId = page_group.getExpandoBridge().getAttribute("FooterArticleID")! />
				<#assign VOID = freeMarkerPortletPreferences.setValue("articleId", "${articleId!}") />
		    <#else>
				<#assign log = objectUtil("com.liferay.portal.kernel.log.LogFactoryUtil").getLog(" free marker log")>
			  ${log.warn("No footer expando defined for site " + theme_display.getScopeGroupId())}
		    </#if>
		<#recover>
		</#attempt>
		<#assign VOID = freeMarkerPortletPreferences.setValue("portletSetupPortletDecoratorId", "borderless") />
		<#assign theme_groupID = htmlUtil.escape(theme_display.getCompanyGroupId()?string) />
		<#assign scope_groupID = htmlUtil.escape(theme_display.getScopeGroupId()?string) />
		<#assign VOID = freeMarkerPortletPreferences.setValue("groupId", "${scope_groupID}") />

		<@liferay_portlet["runtime"]
		defaultPreferences="${freeMarkerPortletPreferences}"
		portletProviderAction=portletProviderAction.VIEW
		instanceId="${articleId!}"
		portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet" />
		${freeMarkerPortletPreferences.reset()}
	</footer>
</div>

<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />
</body>

</html>
