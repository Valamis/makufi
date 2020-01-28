<div class = "uutisnostot">
    <div class = "uutisnostoContent uutisnostoMain">
    <#if entries?has_content>
        <#list entries as curEntry>
            <#assign assetRenderer = curEntry.getAssetRenderer() />
            <#assign viewURL = assetPublisherHelper.getAssetViewURL
            (renderRequest, renderResponse, curEntry) />

            <#if assetLinkBehavior != "showFullContent">
                <#assign viewURL = assetRenderer.getURLViewInContext
                (renderRequest, renderResponse, viewURL) />
            </#if>
            <div class="uutisnostoItem">
            	<div class="pull-right">
		           	<#if assetRenderer.hasEditPermission(themeDisplay.getPermissionChecker())>
						<#assign redirectURL = renderResponse.createRenderURL() />
						${redirectURL.setParameter("mvcPath", "/add_asset_redirect.jsp")}
						${redirectURL.setWindowState("pop_up")}
						<#assign editPortletURL = assetRenderer.getURLEdit(renderRequest, renderResponse, windowStateFactory.getWindowState("pop_up"), redirectURL)!"" />
						<#if validator.isNotNull(editPortletURL)>
							<#assign titleEdit = curEntry.getTitle(locale) />
							<#assign url="javascript:Liferay.Util.openWindow({id:'" + renderResponse.getNamespace() + "editAsset', title: '" + titleEdit + "', uri:'" + htmlUtil.escapeURL(editPortletURL.toString()) + "'});" />
							<a class="icon-monospaced visible-interaction" href="${url}"><i class="icon-pencil"></i></a>
						</#if>
					</#if>
				</div>
                <div class ="uutisnostoLinks">
                    <a href="${viewURL}">${curEntry.getTitle(locale)}</a>
                </div>
                <div class ="uutisnostoTime">
                    ${curEntry.getPublishDate()?string('dd.MM.yyyy')}
                </div>
            </div>
        </#list>
    </#if>
    </div>
</div>
