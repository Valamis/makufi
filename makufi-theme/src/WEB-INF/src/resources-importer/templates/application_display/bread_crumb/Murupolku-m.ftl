<#if entries?has_content>
    <ul class="breadcrumb breadcrumb-horizontal">
        <li class="breadcrumb-list-item">
            <a class="breadcrumb-link" href="/">
                <@liferay.language key="frontpage" />
            </a>
        </li>
        <#list entries as entry>
            <li class="breadcrumb-list-item breadcrumb-arrow">
                <a class="breadcrumb-link"
                    <#if entry.isBrowsable()>
                        href="${entry.getURL()!""}"
                    </#if>
                >${htmlUtil.escape(entry.getTitle())}</a>
            </li>
        </#list>
    </ul>
</#if>