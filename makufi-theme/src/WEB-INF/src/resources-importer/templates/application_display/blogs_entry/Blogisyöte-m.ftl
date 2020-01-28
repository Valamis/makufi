<#if entries?has_content>
	<div class="blogsADTContainer">
		<#list entries as entry>
			<div class="entry">
				<#assign viewURL = renderResponse.createRenderURL() />

				${viewURL.setParameter("mvcRenderCommandName", "/blogs/view_entry")}
				${viewURL.setParameter("redirect", currentURL)}
				${viewURL.setParameter("urlTitle", entry.getUrlTitle())}
		
			<#assign summary = entry.getDescription() />

					<#if validator.isNull(summary)>
						<#assign summary = entry.getContent() />
					</#if>
				<#assign UserLocalService = serviceLocator.findService("com.liferay.portal.kernel.service.UserLocalService")>
				<#assign user = UserLocalService.getUser(entry.userId) />
			<div class="blog-info-container clear">
			    <div class="blog-writer-info col-lg-2 col-md-2 col-sm-2 col-xs-2">
				<img src="${user.getPortraitURL(themeDisplay)}" alt="<@liferay.language key='avatar' />">
				<div class="blog-writer-name">${htmlUtil.escape(portalUtil.getUserName(entry.getUserId(), entry.getUserName()))}</div>
				<div class="blog-writer-title">${htmlUtil.escape(user.getJobTitle())}</div>
			    </div>
			    <div class="blog-content-info col-lg-10 col-md-10 col-sm-10 col-xs-10">
				<div class="blog-date">${dateUtil.getDate(entry.getCreateDate(), "dd MMM yyyy - HH:mm:ss", locale)}</div>
				<h3 class="blog-title">${htmlUtil.escape(entry.getTitle())}</h3>
				<div class="blog-subtitle">${stringUtil.shorten(htmlUtil.stripHtml(summary), 250)}</div>
				<a class="blog-link"href="${viewURL}"><@liferay.language key="read-more" /></a>
			    </div>
			    <div class="clear"></div>
			</div>
			<div class="clear"></div>
		</#list>
	</div>
</#if>
