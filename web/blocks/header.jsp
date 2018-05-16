<!DOCTYPE HTML>
<html>

    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    <c:set var="req" value="${pageContext.request}" />
    <c:set var="baseURL" value="${req.scheme}://${req.serverName}:${req.serverPort}${req.contextPath}" />

    <head>
        <title>Pocket Desk</title>

        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

        <link href="${baseURL}/assets/css/style.css" rel="stylesheet" type="text/css" media="all" />
        <link href="${baseURL}/assets/css/form.css" rel="stylesheet" type="text/css" media="all" />
        <link href="${baseURL}/assets/css/font-face.css" rel="stylesheet" type="text/css"/>
        <!-- chat -->
        <link rel="shortcut icon" href="facivon.ico">
        <link href="../assets/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link href="${baseURL}/assets/css/chat.css" rel="stylesheet" type="text/css"/>
        <script src="../assets/plugins/jQuery/jquery-1.10.1.min.js" type="text/javascript"></script>
        
        <script src="${baseURL}/assets/js/chat.js" type="text/javascript"></script>

        
        <script type="text/javascript" src="${baseURL}/assets/js/jquery1.min.js"></script>
        <!-- start menu -->
        <link href="${baseURL}/assets/css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
        <script type="text/javascript" src="${baseURL}/assets/js/megamenu.js"></script>
        <script>$(document).ready(function () {
                $(".megamenu").megamenu();
            });</script>
        <!--start slider -->
        <link rel="stylesheet" href="${baseURL}/assets/css/fwslider.css" media="all">
        <script src="${baseURL}/assets/js/jquery-ui.min.js"></script>
        <script src="${baseURL}/assets/js/css3-mediaqueries.js"></script>
        <script src="${baseURL}/assets/js/fwslider.js"></script>
        <!--end slider -->
        <script src="${baseURL}/assets/js/jquery.easydropdown.js"></script>
        <link href="../assets/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="header-top">
            <div class="wrap"> 
                <div class="header-top-left">
                    <div class="clear"></div>
                </div>
                <div class="cssmenu">
                    <ul>					
                        <li></li>   
                    </ul>
                </div>
                <div class="clear"></div>
            </div>
        </div>
        <div class="header-bottom">
            <div class="wrap">
                <div class="header-bottom-left">
                    <div class="logo">
                        <a href="${baseURL}/homedesk/home"><img src="${baseURL}/assets/images/logo.png" alt=""/></a>
                    </div>
                    <div class="menu">
                        <ul class="megamenu skyblue">
                            <li class="active grid"><a href="${baseURL}/homedesk/home">Home</a></li>
                            <li><a class="color4" href="#about_us">About Us</a></li>
                            <li><a class="color4" href="${baseURL}/homedesk/login">Log In</a></li> 
                            <li><a class="color4" href="${baseURL}/homedesk/register">Sign Up</a></li>                 
                            <li><a class="color5" href="#footer_div">Contact Us</a></li>

                        </ul>
                    </div>
                </div>
                <div class="header-bottom-right">


                </div>
                <div class="clear"></div>
            </div>
        </div>
