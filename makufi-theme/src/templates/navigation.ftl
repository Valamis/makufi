<#macro buildNavItem nav_items>
    <#list nav_items as nav_item>
        <#assign nav_item_attr_selected = "" />
        <#assign nav_item_css_class = "" />
        <#assign nav_item_add_css_class = "hidden" />
        <#assign toggle_css_class = "" />
        <#if nav_item.isSelected() || nav_item.isChildSelected()>
            <#assign nav_item_css_class = "selected" />
            <#assign nav_item_add_css_class = "" />
            <#if nav_item.hasBrowsableChildren()>
                <#assign toggle_css_class = "open" />
            </#if>
        </#if>
        <#assign layoutName = nav_item.getName()/>
        <#assign link_url = nav_item.getURL()/>
        <#assign nav_item_current = ""/>
        <#assign nav_link_current = ""/>
        <#if themeDisplay.getLayout().equals(nav_item.getLayout())>
            <#assign nav_item_current = "current koristeViiva" />
            <#assign nav_link_current = "nav-link-color"/>
        </#if>

    <li ${nav_item_attr_selected} class="menu-item hyphenate ${nav_item_css_class} ${nav_item_current} ${toggle_css_class}" role="presentation">
        <a class="menu-item-link hyphenate ${nav_link_current} ${toggle_css_class}" aria-label="${layoutName}" ${nav_item.getTarget()} href="${link_url}">${layoutName}</a>
        <#if nav_item.hasBrowsableChildren()>
            <button class="${toggle_css_class} child-toggle" aria-expanded="false" title="<@liferay.language key='toggle-sub-pages' />" data-layout-id="${nav_item.getLayout().getPlid()}"><span class="line"></span></button>
            <#if nav_item.isSelected() || nav_item.isChildSelected()>
            <ul class="menu-item-sub-menu ${nav_item_add_css_class}">
                <@buildNavItem nav_item.getChildren() />
            </ul>
            </#if>
        </#if>
    </li>
    </#list>
</#macro>
<nav id="navigation" class="side-navigation" aria-hidden="true" aria-label="main-navigation" data-language-id="${languageUtil.getLanguageId(locale)}">
    <#if is_signed_in>
        <div class="signed-in-navigation-helper"></div>
    </#if>
    <div class="close-navigation">
    	<span class="close-icon"></span>
        <button class="close-navigation-button" aria-label="<@liferay.language key="close-navigation" />"></button>
    </div>
    <div class="language-links">
        <ul>
        <#assign lan=locale.getLanguage()>
        <#attempt>
            <#if page_group.getExpandoBridge().hasAttribute("finSite")>
                <#assign siteUrl = page_group.getExpandoBridge().getAttribute("finSite")! />
                <#if siteUrl?has_content>
                    <li class="<#if lan = "fi"> selected-language</#if>"><a class="language-link" href="${siteUrl}"><@liferay.language key='Suomeksi' /></a></li>
                </#if>
            </#if>
        <#recover>
        </#attempt>
        <#attempt>
            <#if page_group.getExpandoBridge().hasAttribute("enSite")>
                <#assign siteUrl = page_group.getExpandoBridge().getAttribute("enSite")! />
                <#if siteUrl?has_content>
                    <li class="<#if lan = "en"> selected-language</#if>"><a class="language-link" href="${siteUrl}"><@liferay.language key='In-English' /></a></li>
                </#if>
            </#if>
        <#recover>
        </#attempt>
        <#attempt>
            <#if page_group.getExpandoBridge().hasAttribute("svSite")>
                <#assign siteUrl = page_group.getExpandoBridge().getAttribute("svSite")! />
                <#if siteUrl?has_content>
                    <li class="<#if lan = "sv"> selected-language</#if>"><a class="language-link" href="${siteUrl}"><@liferay.language key='Pa-Svenska' /></a></li>
                </#if>
            </#if>
        <#recover>
        </#attempt>
        <#attempt>
            <#if page_group.getExpandoBridge().hasAttribute("ruSite")>
                <#assign siteUrl = page_group.getExpandoBridge().getAttribute("ruSite")! />
                <#if siteUrl?has_content>
                    <li class="<#if lan = "ru"> selected-language</#if>"><a class="language-link" href="${siteUrl}"><@liferay.language key='In-Russian' /></a></li>
                </#if>
            </#if>
        <#recover>
        </#attempt>
        </ul>
    </div>
    <ul aria-label="<@liferay.language key="site-pages" />" class="navigation-main-menu" role="menubar">
        <@buildNavItem nav_items/>
    </ul>
    <div class="bottom-links">
        <#attempt>
            <#if page_group.getExpandoBridge().hasAttribute("feedBackLink")>
                <#assign feedback_link = page_group.getExpandoBridge().getAttribute("feedBackLink")! />
            </#if>
        <#recover>
        </#attempt>

        <#attempt>
            <#if page_group.getExpandoBridge().hasAttribute("contactInfoLink")>
                <#assign contactinfo_link = page_group.getExpandoBridge().getAttribute("contactInfoLink")! />
            </#if>
        <#recover>
        </#attempt>

        <#if feedback_link?has_content>
            <a href="${feedback_link}" class="bottom-link"><@liferay.language key="give-feedback" /><div class="icon-chevron-right"></div></a>
        </#if>
        <#if contactinfo_link?has_content>
            <a href="${contactinfo_link}" class="bottom-link"><@liferay.language key="contacts-info" /><div class="icon-chevron-right"></div></a>
        </#if>
    </div>
</nav>
