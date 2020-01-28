<#assign displaydate = .vars['reserved-article-display-date'].data>
<#assign originalLocale = .locale>
<#setting locale = localeUtil.getDefault()>
<#assign displaydate = displaydate?datetime("EEE, d MMM yyyy HH:mm:ss Z")>
<#assign locale = originalLocale>
<div class="article-container clear">
    <div class="article-header-container">
        <div class="article-header">
            <h1>${articleTitle.getData()}</h1>
            <div class="article-header-additional-information">
                <a href="javascript: history.back()"><@liferay.language key="news-label" /></a><span class="separator-news">&bull;</span><@liferay.language key="news" /><span class="separator-news">&bull;</span>${displaydate?string["dd.MM.yyyy"]}
            </div>
        </div>
    </div>

    <div class="article-main-image">
        <#if articleThumbnail.getData()?? && articleThumbnail.getData() != "" && getterUtil.getBoolean(articleThumbnail.useAsMainImage.getData()) == true>
            <img data-fileentryid="${articleThumbnail.getAttribute("fileEntryId")}" alt="${articleThumbnail.getAttribute("alt")}" src="${articleThumbnail.getData()}" />
        <#else>
            <#if layout.getGroup().getExpandoBridge().hasAttribute("somedefaultimage")>
                <#assign someDefaultImage = layout.getGroup().getExpandoBridge().getAttribute("somedefaultimage")! />
                <#if someDefaultImage?has_content>
                    <img style="display:none;" alt="SomeShare" src="${someDefaultImage}" />
                </#if>
            </#if>
        </#if>
    </div>

    <div class="article-content">
        <p class="article-content-ingress">${articleContentIngress.getData()}</p>
        ${articleContent.getData()}
    </div>

    <script type="text/javascript" src="//platform-api.sharethis.com/js/sharethis.js#property=58d1270071bde70012c0dfd8&product=inline-share-buttons"></script>
    <div class="row share-button-container">
        <div class="share-title col-xs-1">
            <@liferay.language key="share" />
        </div>
        <div class="share-icons col-xs-11">
            <div class="sharethis-inline-share-buttons share-buttons"></div>
        </div>
    </div>
    <div class="clear"></div>
    <script>
      $( window ).on( "load", function() {
        __sharethis__.initialize();
      });
    </script>
</div>
<style>
    div.h2 {
        display:none !important;
    }
</style>

<#assign journalArticleLocalService = serviceLocator.findService("com.liferay.journal.service.JournalArticleLocalService") />
<#assign assetLinkLocalService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetLinkLocalService") />
<#assign assetEntryLocalService = serviceLocator.findService("com.liferay.asset.kernel.service.AssetEntryLocalService") />

<#assign currentArticle = journalArticleLocalService.getArticle(groupId, .vars['reserved-article-id'].data) />
<#assign currentArticleResourcePrimKey = currentArticle.getResourcePrimKey() />
<#assign currentArticleAssetEntry = assetEntryLocalService.getEntry("com.liferay.journal.model.JournalArticle", currentArticleResourcePrimKey) />
<#assign currentArticleAssetEntryId = currentArticleAssetEntry.getEntryId() />
<#assign currentArticleRelatedLinks = assetLinkLocalService.getDirectLinks(currentArticleAssetEntryId) />

<#if currentArticleRelatedLinks?size != 0>
    <#assign currentUrl = themeDisplay.getPortalURL() + themeDisplay.getURLCurrent() />
    <#assign baseUrl = currentUrl?split(.vars['reserved-article-url-title'].data)[0] />
    <div class="relatedAssetsMainContainer col-lg-12 col-md-12 col-sm-12 col-xs-12">
        <div class="relatedAssetMainHeader">
            <h2><@liferay.language key="related-assets" /></h2>
        </div>
        <#assign displaying = 0 />
        <#list currentArticleRelatedLinks as related_entry>
            <#assign displaying = displaying + 1 />
            <#if displaying < 4 >
                <#assign relatedAssetEntryId = related_entry.getEntryId2() />
                <#assign relatedAssetEntry = assetEntryLocalService.getEntry(relatedAssetEntryId) />
                <#assign relatedAssetEntryPrimKey = relatedAssetEntry.getClassPK() />
                <#assign relatedArticle = journalArticleLocalService.getLatestArticle(relatedAssetEntryPrimKey) />
                <#assign assetRenderer = relatedAssetEntry.getAssetRenderer() />
                <#assign className = assetRenderer.getClassName() />
                <#assign journalArticle = assetRenderer.getArticle() />
                <#assign document = saxReaderUtil.read(journalArticle.getContent()) />
                <#assign title = document.valueOf("//dynamic-element[@name='articleTitle']/dynamic-content/text()")!"" />
                <#assign content = document.valueOf("//dynamic-element[@name='articleIngress']/dynamic-content/text()")!"" />
                <#assign viewURL = baseUrl+ relatedArticle.getUrlTitle() />
                <div class="relatedAsset">
                    <span class="relatedAssetDate">${relatedAssetEntry.getPublishDate()?string('dd.MM.yyyy')}</span>
                    <h3 class="relatedAssetTitle"><a href="${viewURL}">${title}</a></h3>
                    <p class="relatedAssetContent">${content[0..*150]}</p>
                    <div class="clear"></div>
                </div>
            </#if>
        </#list>
        <div class="clear"></div>
    </div>
</#if>
<div class="clear"></div>