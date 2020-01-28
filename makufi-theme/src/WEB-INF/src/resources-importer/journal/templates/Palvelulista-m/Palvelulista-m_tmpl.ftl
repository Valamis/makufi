<div class="makufi-template">
<div class="palListContainer"><!-- col-lg-12 col-md-12 col-sm-12 col-xs-12 -->
    <#if OsionOtsikko.getData()?has_content>
        <div class="palListTitleContainer">
            <h1 class="palListTitle">${OsionOtsikko.getData()}</h1>
        </div>
    </#if>
    <ul class="palList">
    <#list Otsikko.getSiblings() as cur_Otsikko>
        <#assign target = "">
        <#if getterUtil.getBoolean(cur_Otsikko.valilehti.getData())>
            <#assign target = "target=\"_blank\"">
        </#if>
        <li class="palListItem">
            <a class="palListItemLink" ${target} href="${cur_Otsikko.LinkkiSivulle.getData()!}">
            <div class="palListseImgContainer" style="background-image: url('${cur_Otsikko.Kuva.getData()!}');">
            </div>
            <div class="palListItemContentsContainer">
                <h3 class="palListItemTitle">${cur_Otsikko.getData()}</h3>
                <p class="palListItemContent">${cur_Otsikko.kuvaus.getData()}</p>
            </div>
            </a>
        </li>
    </#list>
    </ul>
</div>
</div>