<div class="makufi-template">
<div class="footerContainer container-fluid">
    <div class="footerLogoWrapper row">
        <div class="footerLogoContainer col-xs-4 col-sm-6">
            <#if FooterLogo.getData()?? && FooterLogo.getData() != "">
                <a href="/"><img class="footerIcon" alt="${FooterLogo.getAttribute("alt")}" src="${FooterLogo.getData()}" /></a>
            </#if>
        </div>
        <div class="someContainer col-xs-8 col-sm-6">
            <p class="someTitle hidden-xs"><@liferay.language key="footer-social-title" /></p>

            <#if Facebook.getData()?has_content>
                <a href="${Facebook.getData()}" aria-label="<@liferay.language key="facebook-link" />" title="<@liferay.language key="facebook-link" />"><div class="iconContainer"><i class="icon-facebook footerSomeIcon"></i><span class="sr-only"><@liferay.language key="facebook-link" /></span></div></a>
            </#if>

            <#if LinkedIn.getData()?has_content>
                <a href="${LinkedIn.getData()}" aria-label="<@liferay.language key="linkedin-link" />" title="<@liferay.language key="linkedin-link" />"><div class="iconContainer"><i class="icon-linkedin footerSomeIcon"></i><span class="sr-only"><@liferay.language key="linkedin-link" /></span></div></a>
            </#if>

            <#if Twitter.getData()?has_content>
                <a href="${Twitter.getData()}" aria-label="<@liferay.language key="twitter-link" />" title="<@liferay.language key="twitter-link" />"><div class="iconContainer"><i class="icon-twitter footerSomeIcon"></i><span class="sr-only"><@liferay.language key="twitter-link" /></span></div></a>
            </#if>

            <#if Youtube.getData()?has_content>
                <a href="${Youtube.getData()}" aria-label="<@liferay.language key="youtube-link" />" title="<@liferay.language key="youtube-link" />"><div class="iconContainer"><i class="icon-youtube footerSomeIcon"></i><span class="sr-only"><@liferay.language key="youtube-link" /></span></div></a>
            </#if>

            <#if Instagram.getData()?has_content>
                <a href="${Instagram.getData()}" aria-label="<@liferay.language key="instagram-link" />" title="<@liferay.language key="instagram-link" />"><div class="iconContainer"><i class="icon-instagram footerSomeIcon"></i><span class="sr-only"><@liferay.language key="instagram-link" /></span></div></a>
            </#if>
            <div class="clear"></div>
        </div>
    </div>
    <#if Feedbacklink.getData()?has_content>
    <div class="footerWrapper row footerFeedbackLinkContainer">
        <a class="footerFeedbackLink" href="${Feedbacklink.getData()!}"><i class="icon icon-long-arrow-right"></i>${Feedbacklink.getSiblings()[0].FeedbacklinkText.getData()!}</a>
    </div>
    </#if>
    <div class="footerWrapper row">
        <div class="additionalInforContainer col-md-6 col-xs-12">

            <h3>${Column1Links.getData()}</h3>

            <#if Address.getData()?has_content>
                <div class="footerColumn col-md-6 col-xs-12">
                    <ul>
                        <li class="additionalInformation"><div class="iconContainer"><i class="icon-map-marker footerAdditionalIcon"></i></div><div class="footerAdditionalInfoContainer"><span>${Address.getData()}</span></div><div class="clear"></div></li>
                    </ul>
                </div>
            </#if>

            <#if Email.getData()?has_content || Phone.getData()?has_content>
            <div class="footerColumn col-md-6 col-xs-12">
                <ul>
                    <#if Email.getData()?has_content>
                        <li class="additionalInformation"><div class="iconContainer"><i class="icon-envelope-alt footerAdditionalIcon"></i></div><div class="footerAdditionalInfoContainer"><span>${Email.getData()}</span></div><div class="clear"></div></li>
                    </#if>
                    <#if Phone.getData()?has_content>
                        <li class="additionalInformation"><div class="iconContainer"><i class="icon-phone footerAdditionalIcon"></i></div><div class="footerAdditionalInfoContainer"><span>${Phone.getData()}</span></div><div class="clear"></div></li>
                    </#if>
                </ul>
            </div>
            </#if>

        </div>

        <div class="footerLinkContainer col-md-6 col-xs-12">

            <h3>${Column2Links.getData()}</h3>

            <#if Column2Links.getSiblings()?has_content>
                <div class="footerColumn">
                    <ul>
                    <#list Column2Links.LinkURL1.getSiblings() as cur_LinkURL1>
                        <#if cur_LinkURL1.getData()?has_content>
                        <li><a class="footerItem" href="${cur_LinkURL1.getData()}">${cur_LinkURL1.LinkText1.getData()}</a></li>
                        </#if>
                    </#list>
                    </ul>
                </div>
            </#if>

        </div>
        
    </div>
    <#if Author.getData()?has_content>
    <div class="footerAuthorContainer row">
        <span class="footerAuthor">© ${Author.getData()}</span>
    </div>
    </#if>
</div>
</div>