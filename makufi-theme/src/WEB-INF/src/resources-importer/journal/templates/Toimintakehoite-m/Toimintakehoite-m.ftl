<div class="makufi-template">
<div class="callToActionContainer row">
    <div class="col-xs-12 col-sm-6 col-md-8">
        <h2 class="callToActionTitle">${Otsikko.getData()}</h2>
        <div class="callToActionDescription">${Kuvaus.getData()}</div>
    </div>
    <#if NapinURLLinkki.getData()?has_content>
    <div class="callToActionButtonContainer col-xs-12 col-sm-6 col-md-4">
        <#assign blank = getterUtil.getBoolean(NapinURLLinkkiBlank.getData()) == true />
        <a class="callToActionButton" href="${NapinURLLinkki.getData()}" ${blank?string('target="_blank"', '')}>${NapinTeksti.getData()}</a>
        <p class="callToActionButtonDescription">${NapinLisateksti.getData()}</p>
    </div>
    </#if>
</div>
</div>