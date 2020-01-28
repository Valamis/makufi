<#assign pns = request["portlet-namespace"]!>
<div class="makufi-template">
<div class="panel-group accordion-m" id="${pns}${randomNamespace}_accordion">
    <#if otsikko.getSiblings()?has_content>
        <#list otsikko.getSiblings() as cur_otsikko>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h2 class="panel-title">
                        <a data-toggle="collapse" class="collapsed" data-parent="#${pns}${randomNamespace}_accordion" href="#${pns}${randomNamespace}-${cur_otsikko?index}">
                            ${cur_otsikko.getData()}
                        </a>
                    </h2>
                </div>
                <div id="${pns}${randomNamespace}-${cur_otsikko?index}" class="panel-collapse collapse">
                    <div class="panel-body">
                        ${cur_otsikko.content.getData()}
                    </div>
                </div>
            </div>
        </#list>
    </#if>
</div>
</div>