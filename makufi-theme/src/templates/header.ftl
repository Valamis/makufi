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
            <#assign nav_item_current = "current" />
            <#assign nav_link_current = "nav-link-color"/>
        </#if>

        <li ${nav_item_attr_selected} class="menu-item ${nav_item_css_class} ${nav_item_current} ${toggle_css_class}" role="presentation">
            <a class="menu-item-link ${nav_link_current} ${toggle_css_class}" aria-label="${layoutName}" ${nav_item.getTarget()} href="${link_url}">${layoutName}</a>
            <#if nav_item.hasBrowsableChildren()>
                <#if nav_item.getLayout().isRootLayout() >
                <div id="${nav_item.getLayoutId()}_layouts" class="top-children-container">
                    <a class="navigation-heading" aria-label="${layoutName}" href="${link_url}">${layoutName}</a>
                <#else>
                <button class="${toggle_css_class} child-toggle" aria-expanded="false" title="<@liferay.language key='toggle-sub-pages' />"><i class='icon-plus'></i></button>
                <div style="display: none;" id="${nav_item.getLayoutId()}_layouts" class="layout-children-container">
                </#if>
                    <div class="direct-child-container col-xs-4">
                        <ul class="menu-item-sub-menu">
                            <@buildNavItem nav_item.getChildren() />
                        </ul>
                    </div>
                </div>
            </#if>
        </li>
    </#list>
</#macro>
<script>
    $(document).ready(function() {
        var fadespeed = 100;
        var headingHeight = $(".top-children-container .navigation-heading").outerHeight();
        var initHeight = headingHeight + $(".top-children-container > .direct-child-container > .menu-item-sub-menu").children().length * 50;
        function fixHeight() {
            var newMinHeight = 0;
            $(".direct-child-container").each(function(){
                headingHeight = $(".top-children-container .navigation-heading").outerHeight();
                var colHeight = $(this).children().first().outerHeight() + headingHeight;
                if ($(this).is(":visible") && colHeight > newMinHeight) {
                    newMinHeight = colHeight;
                }
            });
            $(".direct-child-container").height(newMinHeight-headingHeight);
        }
        fixHeight();
        $(".direct-child-container").height(initHeight-headingHeight);

        $('button.child-toggle').click(function(e) {
            var currentLevel = $(e.currentTarget).parent().parent().children();
            currentLevel.each(function(){
                $(this).find('button.child-toggle').html('<i class="icon-plus"></i>');
                $(this).find('button.child-toggle').next().fadeOut(fadespeed);
            });
            $(e.currentTarget).html('<i class="icon-minus"></i>');
            $(e.currentTarget).next().fadeIn(fadespeed);
            fixHeight();
        });
    });
</script>
<div class="header-wrapper">
    <div class="header-content container-fluid">

        <div class="col-xs-4 header-item language-links">
        	<button id="navigation-toggle" class="navigation-toggler mobile-nav-toggle" aria-expanded="false" title="<@liferay.language key='main-menu' />" tabindex="2"><i class="icon-reorder"></i><@liferay.language key='main-menu' /></button>
            <div class="header-language-links">
                <#attempt>
                    <#if page_group.getExpandoBridge().hasAttribute("extraHTMLToHeader")>
                        <#assign extraAttributesToHead = page_group.getExpandoBridge().getAttribute("extraHTMLToHeader")! />
                        <#if extraHTMLToHeader?has_content>${extraHTMLToHeader}</#if>
                    </#if>
                <#recover>
                </#attempt>
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
        </div>

        <div class="col-xs-4 header-item site-title">
            <a class="${logo_css_class}" href="${site_default_url}" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
                <img alt="${logo_description}Sivuston logo" height="${site_logo_height}" src="${site_logo}" width="${site_logo_width}" />
            </a>
        </div>

        <div class="col-xs-4 header-item header-search">
            <div id="header-search-submit-mobile" class="header-search-submit-mobile"><i class="icon-search"></i></div>
            <div class="header-search-container">
                <input id="header-search-field" onFocus="" title="<@liferay.language key='search-from-page' />" type="text" placeholder="<@liferay.language key='search-from-page' />"></input><a id="header-search-submit" onClick="doSearch();"><i class="icon-search"></i></a>
            </div>
        </div>
        <div class="clear"></div>
    </div>
    <div class="header-content-nav container-fluid hide-xs">
        <div class="header-nav-wrapper">
            <ul>
                <@buildNavItem nav_items/>
            </ul>
        </div>
    </div>
</div>
<script>
function doSearch() {
	var currentUrl = window.location.href;
	var redirect = getParameterByName('redirectUrl');
	if(!redirect){
		redirect = currentUrl;
	}
    var scope = searchScopeFilter();
    console.log('scope in search form ' + scope);
	var searchBaseUrl = $(".logo").attr('href') + "/haku?redirectUrl="+ redirect +"&p_p_id=com_liferay_portal_search_web_portlet_SearchPortlet&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&_com_liferay_portal_search_web_portlet_SearchPortlet_mvcPath=%2Fsearch.jsp&_com_liferay_portal_search_web_portlet_SearchPortlet_scope="+scope+"&&_com_liferay_portal_search_web_portlet_SearchPortlet_groupId=0&_com_liferay_portal_search_web_portlet_SearchPortlet_keywords=";
	var keywords = document.getElementById('header-search-field').value.trim();
	var contentToSearch = "";
	if(currentUrl.indexOf("&_com_liferay_portal_search_web_portlet_SearchPortlet_entryClassName=com.liferay.journal.model.JournalArticle,com.liferay.blogs.kernel.model.BlogsEntry,fi.arcusys.maak2.portlet.ptv_display.search.index.ServiceIndex,fi.arcusys.maak2.portlet.ptv_display.search.index.ServiceLocationChannelIndex") !== -1){
		contentToSearch = "&_com_liferay_portal_search_web_portlet_SearchPortlet_entryClassName=com.liferay.journal.model.JournalArticle,com.liferay.blogs.kernel.model.BlogsEntry,fi.arcusys.maak2.portlet.ptv_display.search.index.ServiceIndex,fi.arcusys.maak2.portlet.ptv_display.search.index.ServiceLocationChannelIndex";
	}
	if(currentUrl.indexOf("&_com_liferay_portal_search_web_portlet_SearchPortlet_entryClassName=fi.arcusys.maak2.helpnet.contacts.model.HelpnetContact") !== -1){
		contentToSearch = "&_com_liferay_portal_search_web_portlet_SearchPortlet_entryClassName=fi.arcusys.maak2.helpnet.contacts.model.HelpnetContact";
	}
	if(currentUrl.indexOf("&_com_liferay_portal_search_web_portlet_SearchPortlet_entryClassName=com.liferay.document.library.kernel.model.DLFileEntry") !== -1){
		contentToSearch = "&_com_liferay_portal_search_web_portlet_SearchPortlet_entryClassName=com.liferay.document.library.kernel.model.DLFileEntry";
	}
	if(keywords){
		window.location=searchBaseUrl + keywords + contentToSearch;
	}
}
function searchScopeFilter() {
    var scope = '${searchScope}'; // from expando Search-Scope-Everything
    if (window.location.href.indexOf("fi.arcusys.maak2.helpnet.contacts.model.HelpnetContact") !== -1) {
        return 'everything';
    } else {
        return scope;
    };
}
function querySt(ji) {

    hu = window.location.search.substring(1);
    gy = hu.split("&");

    for (i=0;i<gy.length;i++) {
        ft = gy[i].split("=");
        if (ft[0] == ji) {
            return ft[1];
        }
    }
}
function getParameterByName(name, url) {
    if (!url) url = window.location.href;
    name = name.replace(/[\[\]]/g, "\\$&");
    var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
        results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, " "));
}

var keywords = querySt("_com_liferay_portal_search_web_portlet_SearchPortlet_keywords");
if(keywords){
	document.getElementById('header-search-field').value = decodeURIComponent(keywords);
}

document.getElementById("header-search-field")
    .addEventListener("keyup", function(event) {
    event.preventDefault();
    if (event.keyCode == 13) {
        document.getElementById("header-search-submit").click();
    }
});

$('.header-search-container > *')
    .focus(function() {
        $('.header-search-container').addClass('focused');
        $('#header-search-submit').addClass('hoverEffect');
    })
    .blur(function() {
        $('.header-search-container').removeClass('focused');
        $('#header-search-submit').removeClass('hoverEffect');
    });
</script>
