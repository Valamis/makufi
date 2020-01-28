<div class = "nostotServices">
    <div class = "nostot">
    <#if !entries?has_content>
	<#if !themeDisplay.isSignedIn()>
		${renderRequest.setAttribute("PORTLET_CONFIGURATOR_VISIBILITY", true)}
	</#if>

	<div class="alert alert-info">
		<@liferay_ui["message"]
			key="there-are-no-results"
		/>
	</div>
    </#if>
    <#if entries?has_content>
	<#assign columns = 0>        
	<#list entries as entry>
	    <#assign columns = columns + 1>
            <#assign assetRenderer = entry.getAssetRenderer() />
            <#assign className = assetRenderer.getClassName() />
            <#assign journalArticle = assetRenderer.getArticle() />
            <#assign document = saxReaderUtil.read(journalArticle.getContentByLocale(locale.toString())) />
            <#assign img = document.valueOf("//dynamic-element[@name='articleThumbnail']/dynamic-content/text()")!"" />
            <#assign alt = document.valueOf("//dynamic-element[@name='articleThumbnail']/dynamic-content/@alt")!"" />
            <#assign title = document.valueOf("//dynamic-element[@name='articleTitle']/dynamic-content/text()")!"" />
            <#assign content = document.valueOf("//dynamic-element[@name='articleIngress']/dynamic-content/text()")!"" />
            <#assign viewURL = assetPublisherHelper.getAssetViewURL(renderRequest, renderResponse, entry) />
            <#if assetLinkBehavior != "showFullContent">
                <#assign viewURL = assetRenderer.getURLViewInContext(renderRequest, renderResponse, viewURL) />
            </#if>
	    <#if columns%2 = 1>
		<div class="row">
	    </#if>
            <div class="singleNewsContainer col-lg-6 col-md-6 col-sm-6 col-xs-12">
            	<div class="pull-right">
	            	<#if assetRenderer.hasEditPermission(themeDisplay.getPermissionChecker())>
						<#assign redirectURL = renderResponse.createRenderURL() />
						${redirectURL.setParameter("mvcPath", "/add_asset_redirect.jsp")}
						${redirectURL.setWindowState("pop_up")}
						<#assign editPortletURL = assetRenderer.getURLEdit(renderRequest, renderResponse, windowStateFactory.getWindowState("pop_up"), redirectURL)!"" />
						<#if validator.isNotNull(editPortletURL)>
							<#assign titleEdit = document.valueOf("//dynamic-element[@name='articleTitle']/dynamic-content/text()")!"" />
							<#assign url="javascript:Liferay.Util.openWindow({id:'" + renderResponse.getNamespace() + "editAsset', title: '" + titleEdit + "', uri:'" + htmlUtil.escapeURL(editPortletURL.toString()) + "'});" />
							<a class="icon-monospaced visible-interaction" href="${url}"><i class="icon-pencil"></i></a>
						</#if>
					</#if>
				</div>
                <a href="${viewURL}" style="text-decoration: none;">
	                <div class = "nostotNews">
	                    	<#if img?has_content >
	                        <div class = "nostotImg" role="img" style="background-image: url('${img}')" aria-label="${alt}">
							<#else>
								<#if themeDisplay.getScopeGroup().getExpandoBridge().hasAttribute("somedefaultimage")>
									<#assign someDefaultImage = themeDisplay.getScopeGroup().getExpandoBridge().getAttribute("somedefaultimage")! />
									<#if someDefaultImage?has_content>
	                                    <div class = "nostotImg" role="img" style="background-image: url('${someDefaultImage}')" aria-label="${title}">
									<#else>
										<div class = "nostotImg" role="img">
									</#if>
								<#else>
									<div class = "nostotImg" role="img">
										<img src="" alt="Image not defined, define default image to site settings"></img>
									</div>
								</#if>
							</#if>
	                    </div>
	                    <div class ="nostotTime">
	                    ${entry.getPublishDate()?string('dd.MM.yyyy')}
	                    </div>
	
	                    <div class = "nostotNewstitle">
	                    ${title}
	                    </div>
	
	                    <div class = "nostotContent">
                        ${content}
	                        <a href="${viewURL}" class="nostotReadmore">
                            <i class="icon icon-long-arrow-right"></i>
                            <@liferay.language key="read-more" />
                            </a>
                        </div>
	                </div>
                	<div class="clear"></div>
                </a>
            </div>
	    <#if columns%2 = 0>
		</div>
	    </#if>
        </#list>
    </#if>

    </div>
	<div class="clear"></div>
</div>
