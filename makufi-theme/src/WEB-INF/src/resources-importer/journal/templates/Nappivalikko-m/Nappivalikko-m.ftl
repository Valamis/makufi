<div class="makufi-template">
<div class="buttonNavigationContainer">
	<#list imglist.getSiblings() as curitem>
        <div class="navItemSingleContainer">
            <a href="${curitem.link.getData()}">
                <div class="navItemImageContainer">
                    <#if curitem.img.getData()?? && curitem.img.getData() != "">
                    	<img data-fileentryid="${curitem.img.getAttribute("fileEntryId")}" alt="${curitem.img.getAttribute("alt")}" src="${curitem.img.getData()}" />
                    </#if>
                </div>
                <div class="linkContainer">
                    ${curitem.LinkinTeksti.getData()}
                </div>
            </a>
        </div>
    </#list>
</div>
</div>