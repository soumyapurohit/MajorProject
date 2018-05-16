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


        <!-- n/w  -->

        <link href="${baseURL}/assets/src/easy-responsive-tabs.css" rel="stylesheet" type="text/css">
        <link href="../assets/css/jquerysctipttop.css" rel="stylesheet" type="text/css"/>
        <link href="../assets/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="${baseURL}/assets/css/easy-responsive-tabs.css" rel="stylesheet" type="text/css">
        <link href="../assets/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <!-- n/w -->


        <!-- chat -->
        <script type="text/javascript" src="${baseURL}/assets/js/jquery1.min.js"></script>
        <!-- start menu -->
        <link href="${baseURL}/assets/css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
        <script type="text/javascript" src="${baseURL}/assets/js/megamenu.js"></script>
        <script>$(document).ready(function() {
                $(".megamenu").megamenu();
            });</script>
        <!--start slider -->
        <link rel="stylesheet" href="${baseURL}/assets/css/fwslider.css" media="all">
        <script src="${baseURL}/assets/js/jquery-ui.min.js"></script>
        <script src="${baseURL}/assets/js/css3-mediaqueries.js"></script>
        <script src="${baseURL}/assets/js/fwslider.js"></script>
        <!--end slider -->
        <script src="${baseURL}/assets/js/jquery.easydropdown.js"></script>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

        <link href="${baseURL}/assets/css/pocket.css" rel="stylesheet" type="text/css" media="all" />

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
                        <a href=""><img src="${baseURL}/assets/images/logo.png" alt=""/></a>
                    </div>
                    <div class="menu">
                        <ul class="megamenu skyblue">
                            <li class="active grid"><a href="${baseURL}/member/home">Home</a></li>                            
                            <li><a class="color4" href="${baseURL}/member/profile">Profile</a></li> 
                            <li><a class="color4" href="${baseURL}/member/logout">LogOut</a></li> 
                            <li><a class="color5" href="${baseURL}/admin/member">Admin</a></li>
                        </ul>
                    </div>
                </div>
                <div class="header-bottom-right">
                    <div class="col-md-3 col-sm-3 col-lg-3">
                        <c:if test="${member.profilePic == NULL}">
                            <img src="${baseURL}/assets/images/user.png" height="65px" width="65px"/> 
                        </c:if>

                        <c:if test="${member.profilePic != NULL}">
                            <img src="${baseURL}/assets/upload/${member.memberId}/${member.profilePic}" style="height:50px; width:50px; border-radius:50px; border: 1px solid #4cb1ca;">
                        </c:if>
                    </div>
                    <div class="col-md-9 col-sm-9 col-lg-9">
                        <h3 class="text-info">Hello ${member.fname}</h3>
                    </div>

                </div>
                <div class="clear"></div>
            </div>
        </div>
