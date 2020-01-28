<#if Imagealxf.getData()?? && Imagealxf.getData() != "">
    <div class="makufi-template">
        <div class="hero-wrapper">
            <img class="hero-background" src="${Imagealxf.getData()})" alt="${Imagealxf.getAttribute("alt")}">
            <#if Heading.getData()?has_content>
                <div class="hero-inner-wrapper">
                    <h1 class="hero-link-title">
                        <#if linkAddress.getData()?has_content><a href="${linkAddress.getData()}"
                                                                  class="hero-link-item"></#if>
                            ${Heading.getData()}
                            <#if linkAddress.getData()?has_content></a></#if>
                    </h1>
                    <p class="hero-link-description">
                        <#if linkAddress.getData()?has_content><a href="${linkAddress.getData()}"
                                                                  class="hero-link-item"></#if>
                            ${Description.getData()}
                            <#if linkAddress.getData()?has_content></a></#if>
                    </p>
                    <div class="hero-link-container">
                        <#if linkAddress.getData()?has_content>
                            <a href="${linkAddress.getData()}" class="hero-link-item">
                                <i class="icon icon-long-arrow-right"></i>
                                <@liferay.language key="read-more" />
                            </a>
                        </#if>
                    </div>
                </div>
            </#if>
        </div>
    </div>
</#if>
