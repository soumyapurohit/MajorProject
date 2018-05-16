<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="parentHorizontalTab" >
    <!------ style class for navigation bar   -->  
    <style>
        .navbar {

            font-family: Arial, Helvetica, sans-serif;
        }

        .navbar a {
            float: left;
            font-size: 16px;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        .dropdown {
            float: left;

            width: 50px;
        }

        .dropdown .dropbtn {
            cursor: pointer;
            font-size: 16px;    
            border: none;
            outline: none;
            color: white;
            padding: 14px 16px;
            background-color: inherit;
            font-family: inherit;
            margin: 0;
        }

        .navbar a:hover, .dropdown:hover .dropbtn, .dropbtn:focus {

        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f9f9f9;
            min-width: 160px;
            box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
            z-index: 1;
        }

        .dropdown-content a {
            float: none;
            color: black;
            padding: 12px 16px;
            text-decoration: none;
            display: block;
            text-align: left;
        }

        .dropdown-content a:hover {
            background-color: #ddd;
        }

        .show {
            display: block;
        }
        /*   propertie4sw for browsing*/
        label {
            cursor: pointer;
            /* Style as you please, it will become the visible UI component. */
        }

        #upload_media {
            opacity: 0;
            position: absolute;
            z-index: -1;
        }




    </style>


    <script>
        /* When the user clicks on the button, 
         toggle between hiding and showing the dropdown content */
        function myFunction() {
            document.getElementById("myDropdown").classList.toggle("show");
        }

// Close the dropdown if the user clicks outside of it
        window.onclick = function(e) {
            if (!e.target.matches('.dropbtn')) {
                var myDropdown = document.getElementById("myDropdown");
                if (myDropdown.classList.contains('show')) {
                    myDropdown.classList.remove('show');
                }
            }
        }
    </script>


    <ul class="resp-tabs-list hor_1 libc" >
        <li>My Networks </li>
        <li>Joined Networks </li>
        <li>Invitation  </li>
        <li> <div><a href="${baseURL}/member/createNw"><img src="${baseURL}/assets/images/plusicon.png" alt=""/></a></div></li>

    </ul>
    <div class="resp-tabs-container hor_1 ">
        <div>
            <div id="ChildVerticalTab_1">
                <ul class="resp-tabs-list ver_1 libc">                   

                    <c:forEach items="${networks}" var="network">

                        <li>${network.title}</li>

                    </c:forEach>

                </ul>
                <div class="resp-tabs-container ver_1">
                    <input type="hidden" value="${networkMemId}" name="networkMemId">
                    <c:forEach items="${networks}" var="network">
                        <div class="networkbox">                            

                            <div class="nlogo">
                                <c:if test="${network.profilePic == NULL}">
                                    <img src="${baseURL}/assets/images/network.png" height="100px" width="100px"/> <br>
                                </c:if>

                                <c:if test="${network.profilePic != NULL}">
                                    <img src="${baseURL}/assets/upload/${network.memberId}/${network.networkId}/${network.profilePic}" height="100px" width="100px" style="border-radius:50%;"/> 
                                </c:if>
                            </div>                            
                            <div class="ntitle">
                                <h1>${network.title}</h1>
                            </div>  
                            <div class="nnav">
                                <div> <a href="${baseURL}/postController/viewpost?networkId=${network.networkId}"> 
                                        <img src="../assets/images/postDekho.png" alt="post"/></a> </div>

                                <div><a href="${baseURL}/postController/post?networkId=${network.networkId}">
                                        <img src="../assets/images/attachpin.jpeg" alt="attachpin" /> </a>
                                </div>
                                <div class="chat"><a href="${baseURL}/member/chat">
                                        <img src="../assets/images/newchaticon.png" alt="ChatIcon"/>
                                        <div class="text">1234</div>
                                    </a>                                       
                                </div>
                                <div></div>
                                <div><a href="${baseURL}/network/setting?networkID=${network.networkId}">
                                        <img src="../assets/images/setting.png" alt="SettingIcon"/></a>
                                </div>
                            </div> 
                        </div>
                    </c:forEach>
                </div>
            </div>	
        </div>

        <div>
            <div id="ChildVerticalTab_2">
                <ul class="resp-tabs-list ver_2 libc">

                    <c:forEach items="${joined}" var="join">

                        <li>${join.title}</li>

                    </c:forEach>

                </ul>
                <div class="resp-tabs-container ver_2">
                    <c:forEach items="${joined}" var="join">
                        <div class="networkbox">                            

                            <div class="nlogo">
                                <c:if test="${join.profilePic == NULL}">
                                    <img src="${baseURL}/assets/images/network.png" height="100px" width="100px"/> <br>
                                </c:if>

                                <c:if test="${join.profilePic != NULL}">
                                    <img src="${baseURL}/assets/upload/${join.memberId}/${join.networkId}/${join.profilePic}" height="100px" width="100px" style="border-radius:50%;"/> <br>
                                </c:if>
                            </div>                            
                            <div class="ntitle">
                                <h1>${join.title}</h1>
                            </div>  
                            <div class="nnav">
                                <div> <a href="${baseURL}/postController/viewpost?networkId=${join.networkId}"> 
                                        <img src="../assets/images/postDekho.png" alt="post"/></a> </div>

                                <div><a href="${baseURL}/postController/post?networkId=${join.networkId}">
                                        <img src="../assets/images/attachpin.jpeg" alt="attachpin" /> </a>
                                </div>
                                <div class="chat"><a href="${baseURL}/member/chat">
                                        <img src="../assets/images/newchaticon.png" alt="ChatIcon"/>
                                        <div class="text">1234</div>
                                    </a>                                       
                                </div>
                                <div></div>
                                <div><a href="${baseURL}/network/joinedSetting?networkID=${join.networkId}">
                                        <img src="../assets/images/setting.png" alt="SettingIcon"/></a>
                                </div>
                            </div> 
                    </div>
                </c:forEach>
            </div>
        </div> 
    </div> 

    <div>
        <div id="ChildVerticalTab_3">
            <ul class="resp-tabs-list ver_3 libc">    
                <c:forEach items="${details}" var="inv">
                    <li style="font-size: 30px;">
                        <img src="${baseURL}/assets/images/network.png" height="50px" width="50px"/>

                        ${inv.title}
                    </li>
                </c:forEach>
            </ul>
            <div class="resp-tabs-container ver_3">
                <c:forEach items="${details}" var="detail">
                    <div class="networkbox">                            
                        <div class="nlogo">

                            <div>
                                <div class="req" >
                                    <c:if test="${detail.profilePicMember == NULL}">
                                        <img src="${baseURL}/assets/images/user.png" height="100px" width="100px"/> <br>
                                    </c:if>

                                    <c:if test="${detail.profilePicMember != NULL}">
                                        <img src="${baseURL}/assets/upload/${detail.memberId}/${detail.profilePicMember}" height="100px" width="100px"/> 
                                    </c:if>

                                </div>
                                <h3 style="float:right; margin-right: 270px;"><b> &nbsp; &nbsp; ${detail.fname} ${detail.lname}</b></h3>
                            </div>
                            <div class="text-center">
                                <h3 style="margin-top: 120px">You have been invited by <b> ${detail.fname} ${detail.lname} </b> to join <b> ${detail.title} </b>. <br>So,What do you want to do ?</h3>
                                <div class="col-md-4 col-sm-4 col-lg-4"></div>

                                <a href="${baseURL}/invite/accept?inviteId=${detail.inviteId}" class="btn btn-success">Accept</a>


                                <a href="${baseURL}/invite/reject?inviteId=${detail.inviteId} " class="btn btn-danger">Reject</a>

                                <div class="col-md-4 col-sm-4 col-lg-4"></div>
                            </div>   


                        </div>                            

                    </div>
                </c:forEach>

            </div>
        </div>
    </div>
    <script src="../assets/js/jquery-1.11.3.min.js" type="text/javascript"></script>

    <script src="${baseURL}/assets/js/jquery.easyResponsiveTabs.js"></script>
    <script type="text/javascript">
        $(document).ready(function()
        {

            $('#parentHorizontalTab').easyResponsiveTabs({
                type: 'default', //Types: default, vertical, accordion
                width: 'auto', //auto or any width like 600px
                fit: true, // 100% fit in a container
                closed: 'accordion', // Start closed if in accordion view
                tabidentify: 'hor_1', // The tab groups identifier

                activate: function(event) { // Callback function if tab is switched
                    var $tab = $(this);
                    var $info = $('#nested-tabInfo');
                    var $name = $('span', $info);
                    $name.text($tab.text());
                    $info.show();
                }
            });

            $('#ChildVerticalTab_1').easyResponsiveTabs({
                type: 'vertical',
                width: 'auto',
                fit: true,
                tabidentify: 'ver_1', // The tab groups identifier
                activetab_bg: '#fff', // background color for active tabs in this group
                inactive_bg: '#F5F5F5', // background color for inactive tabs in this group
                active_border_color: '#c1c1c1', // border color for active tabs heads in this group
                active_content_border_color: '#5AB1D0' // border color for active tabs contect in this group so that it matches the tab head border
            });

            $('#ChildVerticalTab_2').easyResponsiveTabs({
                type: 'vertical',
                width: 'auto',
                fit: true,
                tabidentify: 'ver_2', // The tab groups identifier
                activetab_bg: '#fff', // background color for active tabs in this group
                inactive_bg: '#F5F5F5', // background color for inactive tabs in this group
                active_border_color: '#c1c1c1', // border color for active tabs heads in this group
                active_content_border_color: '#5AB1D0' // border color for active tabs contect in this group so that it matches the tab head border
            });

            $('#ChildVerticalTab_3').easyResponsiveTabs({
                type: 'vertical',
                width: 'auto',
                fit: true,
                tabidentify: 'ver_3', // The tab groups identifier
                activetab_bg: '#fff', // background color for active tabs in this group
                inactive_bg: '#F5F5F5', // background color for inactive tabs in this group
                active_border_color: '#c1c1c1', // border color for active tabs heads in this group
                active_content_border_color: '#5AB1D0' // border color for active tabs contect in this group so that it matches the tab head border
            });

        });
    </script>
</div>
<script type="text/javascript">

    var _gaq = _gaq || [];
    _gaq.push(['_setAccount', 'UA-36251023-1']);
    _gaq.push(['_setDomainName', 'jqueryscript.net']);
    _gaq.push(['_trackPageview']);

    (function() {
        var ga = document.createElement('script');
        ga.type = 'text/javascript';
        ga.async = true;
        ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
        var s = document.getElementsByTagName('script')[0];
        s.parentNode.insertBefore(ga, s);
    })();

</script>
