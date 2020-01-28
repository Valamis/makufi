<div class="makufi-template">
<div class="bannerListMainContainer">
    <#if BanneriKuva.getSiblings()?has_content>
        <#list BanneriKuva.getSiblings() as cur_BanneriKuva>
            <div class="singleBannerContainer">
                <#if cur_BanneriKuva.getData()?? && cur_BanneriKuva.getData() != "">
                    <a href="${cur_BanneriKuva.Linkki.getData()}">
                        <div class="imageContainer">
                            <img data-fileentryid="${cur_BanneriKuva.getAttribute("fileEntryId")}" alt="${cur_BanneriKuva.getAttribute("alt")}" src="${cur_BanneriKuva.getData()}" />
                        </div>
                    </a>
                </#if>
            </div>
        </#list>
    </#if>
</div>
</div>