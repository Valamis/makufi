<div class="makufi-template">
<div class="hatatiedote-container row">
    <div class="hatatiedote-title col-xs-12 col-md-2"><h1>${HatOtsikko.getData()}</h1></div>
    <#if HatKuvaus.getData()?has_content>
    <div class="hatatiedote-description col-xs-12 col-md-10">
        ${HatKuvaus.getData()}
    </div>
    </#if>
</div>
</div>
