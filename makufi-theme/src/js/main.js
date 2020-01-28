 /**
 * Created by vekyllonen on 01/03/17.
 */

 /* function to get cookie value */


 function initPtvContentPortlet() {
	 $('.ptv-accordion:has(>.accordion-item) .accordion-heading:has(>.arrow)').click(function() {
		 var openContentClass = 'open';
		 var arrowSelector = '> .arrow';
		 var openArrowClass = 'icon-chevron-down';
		 var closeArrowClass = 'icon-chevron-up';
		 var content = $(this).next();
		 if (content.hasClass(openContentClass)) {
			 $(arrowSelector, $(this)).addClass(openArrowClass).removeClass(closeArrowClass);
			 $(this).removeClass(openContentClass);
			 content.removeClass(openContentClass);
		 } else {
			 $(arrowSelector, $(this)).addClass(closeArrowClass).removeClass(openArrowClass);
			 $(this).addClass(openContentClass);
			 content.addClass(openContentClass);
		 }
	 });

     $('.ptv-back-button').click(function () {
        history.back();
     });

     $('.ptv-show-more-container').each(function () {
         var showElements = 3;
         var showMoreContainer = $(this);
         $('.ptv-show-more', showMoreContainer).click(function (event) {
             event.preventDefault();

             var hiddenElements = $('.hide', showMoreContainer);
             if (hiddenElements.length > 0) {
                 hiddenElements.each(function (index) {
                     if (index < showElements) {
                         $(this).removeClass('hide');
                     }
                 });

             } else if (!$(this).hasClass('no-elements')) {
                 $(this).addClass('no-elements');
             }

             if (hiddenElements.length - showElements <= 0) {
                 $(this).addClass('no-elements');
             }
         });
     });
 }
function handleSideNavigationClick() {
	var sideNav = $('#side-navigation');
	var currentLi = $(sideNav).find('.current');
	currentLi.siblings().toggleClass('current-sibling');
	currentLi.siblings().toggleClass('hidden');
	currentLi.children('ul').children('li').toggleClass('hidden');
}

function registerChildNavigationClickHandler() {
    $('#navigation .child-toggle').click(function (e) {
        handleChildNavigationClick(this);
    });
}

function handleChildNavigationClick(button) {
    var listItem = $(button).parent();
    if (listItem.children('ul').length == 0) {
        $.getJSON("/o/layout-rest/layout/children/" + $(button).data('layout-id'), function (result) {
            buildNavigationItems(result, listItem);
        });
    }
    $(button).parent().toggleClass('open');
    $(button).toggleClass('open');
    if($(button).attr("aria-expanded") === "true"){
        $(button).attr("aria-expanded","false");
    } else {
        $(button).attr("aria-expanded","true");
    }
    $(button).next().toggleClass('hidden');
    $(button).siblings("a").toggleClass('open');
    $(button).focus();
}

function buildNavigationItems(data, listItem) {
 if (data.length > 0) {
     var ul = $('<ul>');
     $.each(data, function (index, item) {
         var li = $('<li>').attr('role', 'presentation').attr('class', 'menu-item').append(
             $('<a '+item.target+'>').attr('href', item.href)
                 .attr('class', 'menu-item-link hyphenate')
                 .attr('aria-label', item.name)
                 .text(item.name));
         if (item.hasChildren == true) {
             var button = $('<button>').attr('class', 'child-toggle').data('layout-id', item.plid).attr("aria-expanded","false");
             button.click(function () {
                 handleChildNavigationClick(this);
             });
             li.append(button);
         }
         ul.append(li);
     });
     listItem.append(ul);
 }
}

function createCookie(name,value,days) {
    if (days) {
        var date = new Date();
        date.setTime(date.getTime() + (days * 24 * 60 * 60 *1000));
        var expires = "; expires=" + date.toGMTString();
    } else {
        var expires = "";
    }
    document.cookie = name + "=" + value + expires + "; path=/";
}

function eraseCookie(name) {
    createCookie(name,"",-1);
}

function getCookie(name) {
    var value = "; " + document.cookie;
    var parts = value.split("; " + name + "=");
    if (parts.length == 2) return parts.pop().split(";").shift();
}

function createOrUpdateCookie(name, value, expires) {
    if (getCookie(name) == undefined) {
        createCookie(name, value, expires);
    } else {
    	eraseCookie(name);
    	createCookie(name, value, expires);
    }
}

function toggleCookieInfo() {
    var cookieInfoCookieValue = getCookie("cookieInfo");
    if (cookieInfoCookieValue == undefined) {
        $('#cookie-info').toggleClass('hidden');
        $('#cookie-info button, #cookie-info .close span').click(function() {
            $('#cookie-info').toggleClass('hidden');
            createOrUpdateCookie("cookieInfo", '1', 14);
        });
    }
}

$(document).ready(function() {
	if(window.self == window.top){
		if(typeof rns !== 'undefined'){
			if(rns === true){
				if($(window).width() > 768){
				    if(getCookie("navigation")) {
				        $('.side-navigation').addClass('nav-open');
				        if($("#navigation-toggle").attr("aria-expanded") === "true"){
				       	 $("#navigation-toggle").attr("aria-expanded","false");
				       	 $("#navigation").attr("aria-hidden", "true");
				        } else {
				       	 $("#navigation-toggle").attr("aria-expanded","true");
				       	 $("#navigation").attr("aria-hidden", "false");
				        }
				        $('.side-navigation').addClass('nav-open-start');
				        $('.navigation-overlay').addClass('show-overlay');
				        $('#wrapper').addClass('nav-open');
				        if ($('.sidenav-fixed').hasClass("open")) {
				            $('.side-navigation').addClass('sidenav-open');
				        }
				        if(getCookie("navPos")){
				        	$('#navigation').scrollTop(getCookie("navPos"));
				        }
				    }
				}
			}
		}
		else{
			if($(window).width() > 768){
			    if(getCookie("navigation")) {
			        $('.side-navigation').addClass('nav-open');
			        if($("#navigation-toggle").attr("aria-expanded") === "true"){
			       	 $("#navigation-toggle").attr("aria-expanded","false");
			       	 $("#navigation").attr("aria-hidden", "true");
			        } else {
			       	 $("#navigation-toggle").attr("aria-expanded","true");
			       	 $("#navigation").attr("aria-hidden", "false");
			        }
			        $('.side-navigation').addClass('nav-open-start');
			        $('.navigation-overlay').addClass('show-overlay');
			        $('#wrapper').addClass('nav-open');
			        if ($('.sidenav-fixed').hasClass("open")) {
			            $('.side-navigation').addClass('sidenav-open');
			        }
			        if(getCookie("navPos")){
			        	$('#navigation').scrollTop(getCookie("navPos"));
			        }
			    }
			}
		}
	    $('#navigation').click(function(e) {
	    	var navPos = $('#navigation').scrollTop();
	    	document.cookie = "navPos="+navPos+";";
	    });
	    
	    /* toggle side navigation */
	    $('.sites-control-group .sidenav-toggler, .sites-control-group .sidenav-close').click(function(e) {
	        if ($('.sidenav-fixed').hasClass("open")) {
	            $('.side-navigation').removeClass('sidenav-open');
	        } else {
	            $('.side-navigation').addClass('sidenav-open');
	        }
	    });
	    
	    $("#_com_liferay_product_navigation_control_menu_web_portlet_ProductNavigationControlMenuPortlet_addToggleId").click(function(){
	    	$('.side-navigation').removeClass('nav-open').removeClass('nav-open-start');
	    	$('.side-navigation').removeClass('sidenav-open').removeClass('nav-open-start');
	    	$("#navigation").attr("aria-hidden", "true");
	    	$('#_com_liferay_product_navigation_control_menu_web_portlet_ProductNavigationControlMenuPortlet_addPanelId').show();
	        $('.navigation-overlay').removeClass('show-overlay');
	        $('#wrapper').removeClass('nav-open');
	        if(getCookie("navigation")) {
	            document.cookie = "navigation=";
	        }
	    });
	    
	    $("#_com_liferay_product_navigation_simulation_web_portlet_SimulationPortlet_simulationToggleId").click(function(){
	    	$('.side-navigation').removeClass('nav-open').removeClass('nav-open-start');
	    	$('.side-navigation').removeClass('sidenav-open').removeClass('nav-open-start');
	    	$("#navigation").attr("aria-hidden", "true");
	        $('.navigation-overlay').removeClass('show-overlay');
	        $('#wrapper').removeClass('nav-open');
	        if(getCookie("navigation")) {
	            document.cookie = "navigation=";
	        }
	    });
	
	    $('.navigation-toggler').click(function(e) {
	    	if($('.side-navigation').hasClass('nav-open')){
	    		$('.side-navigation').removeClass('nav-open').removeClass('nav-open-start');
	    		if($("#navigation-toggle").attr("aria-expanded") === "true"){
			       	$("#navigation-toggle").attr("aria-expanded","false");
			       	$("#navigation").attr("aria-hidden", "true");
			    } else {
			        $("#navigation-toggle").attr("aria-expanded","true");
			        $("#navigation").attr("aria-hidden", "false");
			    }
	            $('.navigation-overlay').removeClass('show-overlay');
	            $('#wrapper').removeClass('nav-open');
	            if(getCookie("navigation")) {
	                document.cookie = "navigation=";
	            }
	    	}
	    	else {
		        $('.side-navigation').addClass('nav-open');
		        if($("#navigation-toggle").attr("aria-expanded") === "true"){
			       	$("#navigation-toggle").attr("aria-expanded","false");
			       	$("#navigation").attr("aria-hidden", "true");
			    } else {
			    	$("#navigation-toggle").attr("aria-expanded","true");
			    	$("#navigation").attr("aria-hidden", "false");
			    }
		        $('.navigation-overlay').addClass('show-overlay');
		        $('#wrapper').addClass('nav-open');
		        $('#_com_liferay_product_navigation_control_menu_web_portlet_ProductNavigationControlMenuPortlet_addPanelId').hide();
		        $('body').removeClass('open-admin-panel');
		        if ($('.sidenav-fixed').hasClass("open")) {
		            $('.side-navigation').addClass('sidenav-open');
		            $("#navigation").attr("aria-hidden", "false");
		        }
		        if(!getCookie("navigation")) {
		            document.cookie = "navigation=1";
		        }
	    	}
	    });
	
	    $('.close-navigation').click(function(e) {
	        $('.side-navigation').removeClass('nav-open').removeClass('nav-open-start');
	        $("#navigation").attr("aria-hidden", "true");
	        $('.navigation-overlay').removeClass('show-overlay');
	        $('#wrapper').removeClass('nav-open');
	        if(getCookie("navigation")) {
	            document.cookie = "navigation=";
	        }
	    });
	
	    $('.navigation-overlay').click(function(e) {
	        $('.side-navigation').removeClass('nav-open').removeClass('nav-open-start');
	        $('.navigation-overlay').removeClass('show-overlay');
	        $("#navigation").attr("aria-hidden", "true");
	        $('#wrapper').removeClass('nav-open');
	        if(getCookie("navigation")) {
	            document.cookie = "navigation=";
	        }
	    });
	
	    /* check if staging publish bar is present */
	    if($('.staging-bar').length) {
	        $('.signed-in-navigation-helper').addClass('staging-bar-open');
	    }
	
	    /* header search button toggler */
	
	    $('.header-search-submit-mobile').click(function(e) {
	        $('.header-search-container').css("display","block");
	        $('.header-search-submit-mobile').css("display","none");
	        $('#header-search-field').focus();
	        $("#header-search-field").blur(function(){
	        	if(document.getElementById('header-search-field').value.trim()){
	        		doSearch();
	        	}
	        	$('.header-search-container').css("display","");
	            $('.header-search-submit-mobile').css("display","");
	        });
	    });
	}
    initPtvContentPortlet();
    handleSideNavigationClick();
    registerChildNavigationClickHandler();
    EQCSS.apply();
    toggleCookieInfo();
});
