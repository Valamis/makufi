<#if BackgroundImage.getData()?? && BackgroundImage.getData() != "">
    <div class="makufi-template ">
    <div style="background-image: url('${BackgroundImage.getData()}');" class="subPageHeroContainer hero-wrapper" role="img" aria-label="${BackgroundImage.getAttribute("alt")}">
        <#if PageTitle.getData()?has_content>
        	<div class="subHeroTitleContainer"><h1 class="subheroHeader">${PageTitle.getData()}</h1></div>
        </#if>
    </div>
    </div>
</#if>
