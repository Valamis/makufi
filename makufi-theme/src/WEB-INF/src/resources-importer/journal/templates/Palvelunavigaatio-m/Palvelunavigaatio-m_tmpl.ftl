<div class="makufi-template">
<div class="palContainer"><!-- col-lg-12 col-md-12 col-sm-12 col-xs-12 -->
    <#if OsionOtsikko.getData()?has_content>
        <div class="palTitleContainer">
            <h1 class="palTitle">${OsionOtsikko.getData()}</h1>
            <p class="palDescription">${OsionKuvaus.getData()}</p>
        </div>
    </#if>
    <#if Otsikko.LinkinTeksti.getSiblings()?has_content>

	    <#list Otsikko.getSiblings() as cur_Otsikko>
            <#if getterUtil.getBoolean(cur_Otsikko.KorostaKokopalstanLeveydelle.getData()) == true || (cur_Otsikko.LinkinTeksti.getSiblings()?size >= getterUtil.getInteger(maxRowsBeforeCols.getData())!6)>
            <div class="palseBigContainer">
            <#else>
            <div class="palseContainer">
            </#if>
	    	    <div class="palseImgContainer" style="background-image: url('${cur_Otsikko.Kuva.getData()!}');">
                    <h3 class="palseTitle">${cur_Otsikko.getData()}</h3>
                    <p class="palseDesc">${cur_Otsikko.kuvausNumerot.getData()!}</p>
	    	    </div>
                
                <ul class="palLinksContainer" style="height: auto">
                <#list cur_Otsikko.LinkinTeksti.getSiblings() as cur_Link>
                    <#if getterUtil.getBoolean(cur_Link.valilehti.getData()) == true>
                        <li><a class="palseLink" target="_blank" href="${cur_Link.LinkkiSivulle.getData()!}">${cur_Link.getData()!}</a></li>
                    <#else>
                        <li><a class="palseLink" href="${cur_Link.LinkkiSivulle.getData()!}">${cur_Link.getData()!}</a></li>
                    </#if>
                </#list>
                </ul>
	    	</div>
	    </#list>
        
        <script>
            $(document).ready(function() {
                var maxHeight = 0;
                $('.palContainer .palLinksContainer').each(function(e) {
                    if ($(this).height() > maxHeight) {
                        maxHeight = $(this).height();
                    }
                });
                $('.palContainer .palLinksContainer').height(maxHeight);
            });
        </script>

    </#if>
</div>
</div>