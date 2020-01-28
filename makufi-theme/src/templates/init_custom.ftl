<#--
This file allows you to override and define new FreeMarker variables.
-->
<style type="text/css">

<#if theme_settings["site-background-color"]??>
    #wrapper {
        background-color: ${getterUtil.getString(theme_settings["site-background-color"]!"", "")};
    }
</#if>

<#if theme_settings["header-tekstit"]??>
    #wrapper .footerContainer,
    #wrapper .footerContainer a,
    #wrapper .footerContainer a:link,
    #wrapper .footerContainer a:active,
    #wrapper .footerContainer .footerLogoWrapper
    {
        color: ${getterUtil.getString(theme_settings["header-tekstit"]!"", "")};
    }
</#if>

<#if theme_settings["header-icons"]??>
    
    #wrapper .ptv-content-display .heading-icon
    {
        color: ${getterUtil.getString(theme_settings["header-icons"]!"", "")} !important;
    }
</#if>

<#if theme_settings["header-background"]??>
    #wrapper .header-wrapper .header-content,
    #wrapper .header-wrapper .header-content-nav {
        background-color: ${getterUtil.getString(theme_settings["header-background"]!"", "")} !important;
    }
    #wrapper .footerContainer .footerLogoWrapper {
        background-color: ${getterUtil.getString(theme_settings["header-background"]!"", "")} !important;
    }
</#if>

<#if theme_settings["footer-text"]??>
    #wrapper .footerContainer .footerWrapper .additionalInforContainer,
    #wrapper .footerContainer .footerWrapper .additionalInforContainer H3,
    #wrapper .footerContainer .footerWrapper .footerLinkContainer,
    #wrapper .footerContainer .footerWrapper .footerLinkContainer H3,
    #wrapper .footerContainer,
    #wrapper .footerContainer a,
    #wrapper .footerContainer a:link,
    #wrapper .footerContainer a:active,
    #wrapper .footerContainer .footerWrapper,
    #wrapper .footerContainer .footerAuthorContainer .footerAuthor 
    {
        color: ${getterUtil.getString(theme_settings["footer-text"]!"", "")} !important;
        border-color: ${getterUtil.getString(theme_settings["footer-text"]!"", "")} !important;
    }
    #wrapper .footerContainer a:hover,
    #wrapper .footerContainer a:focus {
        -webkit-filter: invert(0.8);
        filter: invert(0.8);
    }
</#if>

<#if theme_settings["footer-icons"]??>
    #wrapper .footerContainer .footerLogoWrapper .someContainer .iconContainer .footerSomeIcon
    {
        color: ${getterUtil.getString(theme_settings["footer-icons"]!"", "")} !important;
    }
</#if>

<#if theme_settings["footer-background"]??>
    #wrapper .palListContainer ul.palList li.palListItem .palListseImgContainer {
        background-color: ${getterUtil.getString(theme_settings["footer-background"]!"", "")} !important;
    }
</#if>

<#if theme_settings["link"]??>
    #wrapper .main-main-content a, 
    #wrapper .main-main-content a:link,
    #wrapper .main-main-content a:visited,
    #wrapper .searchContainer .searchResultTitle
    #wrapper .searchContainer .searchResultTitle a.downloadItem
    {
        color: ${getterUtil.getString(theme_settings["link"]!"", "")};
    }
    #wrapper.icon-long-arrow-right {
        border-color: ${getterUtil.getString(theme_settings["link"]!"", "")};
    }
    #wrapper div.subscribe a.taglib-icon span {
        color: ${getterUtil.getString(theme_settings["link"]!"", "")};
    }
    #wrapper div.subscribe a.taglib-icon svg {
        fill: ${getterUtil.getString(theme_settings["link"]!"", "")};
    }
    #wrapper .flockler-buttons .flockler-button {
        background-color: ${getterUtil.getString(theme_settings["link"]!"", "")};
    }
</#if>

<#if theme_settings["link-active"]??>
    #wrapper .main-main-content a:active,
    #wrapper .main-main-content a:focus {
        color: ${getterUtil.getString(theme_settings["link-active"]!"", "")};
    } 
</#if>

<#if theme_settings["link-hover"]??>
    #wrapper .main-main-content a:hover,
    #wrapper .main-main-content .breadcrumb li a:hover,
    #wrapper .header-wrapper .header-content .icon-reorder:hover:before
    {
        color: ${getterUtil.getString(theme_settings["link-hover"]!"", "")};
    }
    #wrapper .flockler-buttons .flockler-button:hover,
    #wrapper .flockler-buttons .flockler-button.auki {
        background-color: ${getterUtil.getString(theme_settings["link-hover"]!"", "")};
    }
</#if>

<#if theme_settings["hero-text"]??>
    #subSiteHeroContainer .portlet-journal-content .portlet-content
    {
        color: ${getterUtil.getString(theme_settings["hero-text"]!"", "")};
    }
    #subSiteHeroContainer .portlet-journal-content .portlet-content {
        border-color: ${getterUtil.getString(theme_settings["hero-text"]!"", "")};
    }
    #subSiteHeroContainer .portlet-journal-content .portlet-content a:hover .hero-link-container,
    #subSiteHeroContainer .portlet-journal-content .portlet-content a:focus .hero-link-container
    {
        -webkit-filter: invert(0.8);
        filter: invert(0.8);
    }
</#if>

<#if theme_settings["main-content-icons"]??>
    #wrapper .calendarContainer #eventCalendar .yui3-calendar-day-selected,
    #wrapper .calendarContainer #eventCalendar .yui3-calendar-day:hover
    {
        background-color: ${getterUtil.getString(theme_settings["main-content-icons"]!"", "")} !important;
    }
</#if>

<#if theme_settings["main-content-header-text"]??>
    #wrapper,
    #wrapper .main-main-content h1,
    #wrapper h2,
    #wrapper h3, 
    #wrapper h4, 
    #wrapper h5, 
    #wrapper h6,
    #wrapper .icon-long-arrow-right.dark,
    #wrapper .portlet-title-text,
    #wrapper #portlet_com_liferay_blogs_web_portlet_BlogsPortlet .entry-title .blog-entry-date,
    #wrapper .footerContainer .footerLogoWrapper .someContainer .someTitle,
    #wrapper .nostotNewstitle,
    #wrapper .nostotTime
    #wrapper .searchResultsLabel,
    #wrapper .document-container .display-style-descriptive .list-group-item .list-group-item-field .documentFolderContainer .documentNameLink .folderName i,
    #wrapper .palContainer .palTitleContainer .palTitle,
    #wrapper .palContainer .palTitleContainer .palDescription,
    #wrapper .calendarContainer .eventCalendarTitle,
    #wrapper .calendarContainer .eventCalendar .yui3-calendar-day,
    #wrapper .calendarContainer #eventCalendar .yui3-calendar-day.highlight,
    #wrapper .calendarContainer .selectCategory,
    #wrapper #helpnet-search-wrapper #searcher .searchLabel,
    #wrapper #helpnet-search-wrapper #searcher .orgLabel label,
    #wrapper #helpnet-search-wrapper #searcher .orgInput button,
    #wrapper #helpnet-search-wrapper #searcher .orgInput .dropdown-menu a,
    #subSiteHeroContainer .portlet-content .journal-content-article > div:not(.hero-wrapper),
    #subSiteHeroContainer .portlet-content :not(.hero-wrapper) .uutisnostot,
    #subSiteHeroContainer .portlet-content :not(.hero-wrapper) .uutisnostot a
    #subSiteHeroContainer .portlet-content :not(.hero-wrapper) .uutisnostot a:link
    {
        color: ${getterUtil.getString(theme_settings["main-content-header-text"]!"", "")};
    }
</#if>

<#if theme_settings["main-content-text"]??>
    #wrapper .st-btn svg {
        fill: ${getterUtil.getString(theme_settings["main-content-text"]!"", "")} !important;
    }
    #subSiteHeroContainer .portlet-content .journal-content-article > div:not(.hero-wrapper) {
        color: ${getterUtil.getString(theme_settings["main-content-text"]!"", "")}
    }
</#if>

<#if theme_settings["main-content-text-dimmed"]??>
    #wrapper .relatedAssetsMainContainer .relatedAsset .relatedAssetDate {
        
    }
</#if>

<#if theme_settings["main-content-background"]??>
    #wrapper #main-content-wrapper,
    {
        background-color: ${getterUtil.getString(theme_settings["main-content-background"]!"", "")} !important;
    }
    #wrapper a.flockler-btn-load-more,
    #wrapper a.flockler-btn-load-more:link,
    #wrapper .flockler-buttons .flockler-button,
    #wrapper .flockler-buttons .flockler-button:hover {
        color: ${getterUtil.getString(theme_settings["main-content-background"]!"", "")};
    }
</#if>

<#if theme_settings["main-content-box-divider-color"]??>
    #wrapper #main-content .portlet-layout.row {
        border-bottom-color: ${getterUtil.getString(theme_settings["main-content-box-divider-color"]!"", "")} !important;
    }
    #wrapper .createEventContainer .form-group .form-control,
    #wrapper #helpnet-search-wrapper #searcher .searchInput,
    #wrapper #helpnet-search-wrapper #searcher .orgInput {
        border-color: ${getterUtil.getString(theme_settings["main-content-box-divider-color"]!"", "")} !important;
    }
    #wrapper #main-content .portlet-layout.row .portlet-column-first:before,
    #wrapper #main-content .portlet-layout.row .portlet-column-first:after,
    #wrapper #main-content .portlet-layout.row .portlet-column-last:before,
    #wrapper #main-content .portlet-layout.row .portlet-column-last:after,
    #wrapper #main-content .portlet-layout.row .subSiteHeroContainer .subPageHeroContainer,
    #wrapper .buttonNavigationContainer .navItemSingleContainer .navItemImageContainer,
    #wrapper .article-container .article-header-container
    #wrapper .palListContainer .palList .palListItem a.palListItemLink,
    #wrapper .eventContainer .eventAdditionalInformation,
    #wrapper #helpnet-search-wrapper #helpnet-search-nextpage,
    #wrapper #helpnet-search-wrapper #searcher,
    #wrapper .relatedAssetsMainContainer .relatedAsset,
    #wrapper .taglib-asset-categories-navigation .panel-default > .panel-heading
    {
        background-color: ${getterUtil.getString(theme_settings["main-content-box-divider-color"]!"", "")} !important;
    }
    #wrapper .calendarContainer #eventsList .singleEventContainer .eventCategories,
    #wrapper .calendarContainer #eventsList .singleEventContainer .eventCategories .cat
    {
        color: ${getterUtil.getString(theme_settings["main-content-box-divider-color"]!"", "")} !important;
    }
</#if>

<#if theme_settings["main-content-box-background"]??>
    #wrapper .createEventContainer .recurdates .recurdate,
    #wrapper .createEventContainer .recurdates .recurdateAdd,
    #wrapper .relatedAssetsMainContainer .relatedAsset,
    #wrapper .palContainer .palLinksContainer,
    #wrapper .calendarContainer #eventCalendar .highlight,
    #wrapper .callToActionContainer,
    #wrapper .calendarContainer #eventCalendar .yui3-calendar-day:hover
    {
        background-color: ${getterUtil.getString(theme_settings["main-content-box-background"]!"", "")} !important;
    }
</#if>

<#if theme_settings["main-content-box-text-over-image"]??>
    #wrapper .searchContainer .tabContainer a:active span,
    #wrapper .palContainer .palseImgContainer .palseDesc,
    #wrapper .palContainer .palseImgContainer .palseTitle,
    #wrapper .calendarContainer #eventCalendar .yui3-calendar-day-selected,
    #wrapper .calendarContainer #eventCalendar .yui3-calendar-day:hover
    {
        color: ${getterUtil.getString(theme_settings["main-content-box-text-over-image"]!"", "")} !important;
    }
</#if>

<#if theme_settings["main-content-box-text"]??>
    #wrapper .palListContainer .palList .palListItem .palListItemContentsContainer,
    #wrapper .taglib-asset-categories-navigation .panel-default > .panel-heading
    {
        color: ${getterUtil.getString(theme_settings["main-content-box-text"]!"", "")} !important;
    }
</#if>

<#if theme_settings["cookie-text"]??>
    #wrapper #cookie-info,
    #wrapper #cookie-info .cookie-info-inner .text a,
    #wrapper #cookie-info .cookie-info-inner .text a:link,
    #wrapper #cookie-info .cookie-info-inner .text a:active,
    #wrapper #cookie-info .cookie-info-inner .text a:visited
    {
        color: ${getterUtil.getString(theme_settings["cookie-text"]!"", "")} !important;
    }
</#if>

<#if theme_settings["cookie-background"]??>
    #wrapper #cookie-info .cookie-info-inner 
    {
        background-color: ${getterUtil.getString(theme_settings["cookie-background"]!"", "")} !important;
    }
</#if>

<#if theme_settings["alert-background"]??>
    #wrapper .createEventContainer .error,
    #wrapper .pageCommentingMainContainer .commentFormContainer .error,
    #wrapper .feedbackFormContainer .error .hatatiedote-container
    {
        background-color: ${getterUtil.getString(theme_settings["alert-background"]!"", "")} !important;
    }
</#if>

<#if theme_settings["alert-text"]??>
    #wrapper .focused,
    #wrapper .hatatiedote-container .hatatiedote-title 
    #wrapper .hatatiedote-container .hatatiedote-description
    {
        color: ${getterUtil.getString(theme_settings["alert-text"]!"", "")} !important;
    }
</#if>

</style>