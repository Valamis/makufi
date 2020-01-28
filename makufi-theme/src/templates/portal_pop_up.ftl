<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<#include "${full_templates_path}/init_custom.ftl" />
	<title>${the_title}</title>
	<script type="text/javascript" src="${javascript_folder}/EQCSS.js"></script>
	<script>
	    EQCSS.apply();
	</script>
	<@liferay_util["include"] page=top_head_include />
</head>

<body class="portal-popup ${css_class}">

<@liferay_util["include"] page=content_include />

<@liferay_util["include"] page=bottom_ext_include />

</body>

</html>
