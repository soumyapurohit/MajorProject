<script>
    var memberIds = [];
    var index = 0;

    function showMemberName(memberid, counter)
    {
        req = new XMLHttpRequest();
        url = "${baseURL}/member/getName?memberId="+ memberid;
        req.open("GET", url); // controller path - invitation controller        
        req.onreadystatechange = function ()
        {
            if (req.readyState == 4) 
            {
                res = req.responseText;
                console.log(url + " : " + res);
                btag = document.getElementById("m" + memberid);
                btag.innerHTML = res;
                if (counter < memberIds.length - 1) {
                    counter++;
                    showMemberName(memberIds[counter], counter);
                }
            }
        }
        req.send();
    }
</script>


<div style="background:#4cb1ca; height: 150px;">
    <div>
        <center>
        <span class="nlogo reponsive" style="float: left; margin-left: 370px;">
            <c:if test="${network.profilePic == NULL}">
                <img src="${baseURL}/assets/images/network.png" height="100px" width="100px"/> <br>
            </c:if>

            <c:if test="${network.profilePic != NULL}">
                <img src="${baseURL}/assets/upload/${network.memberId}/${network.networkId}/${network.profilePic}" height="150px" width="150px" style="border-radius: 50%;"/> 
            </c:if>
        </span>
        <span class="ntitle responsive"  style="color: whitesmoke; float: left; margin-left: 70px; margin-top: 35px;">
            <h1 style="font-variant: all-petite-caps; font-style: italic;">${network.title}</h1>
        </span>
    </center>
        </div>
        </div>
    <div class="col-sm-3 col-lg-3 col-md-3"></div> 

    <div class="col-sm-6 col-lg-6 col-md-6 responsive">
        <table class="table" style="background-color: white;">
            <c:forEach items="${posts}" var="post">
                <tr>
                    <td>
                        <span><h3 style="color: #4cb1ca;" id="m${post.postBy}"></h3></span>
                        <h4 style="color: black;">${post.textData}</h4>
                    </td>
                    <td>
                        <img src="${baseURL}/assets/upload/${post.postBy}/${post.networkId}/${post.mediaPath}" height="200px" width="200px"/>
                    </td>
                </tr>
                
                <script>
                  memberIds[index] = '${post.postBy}';
                  index++;
                </script>
            </c:forEach>          
        </table>
    </div>
<div class="col-sm-3 col-lg-3 col-md-3"></div>
<script>
    $(document).ready(function(){
       if (memberIds.length > 0)
        {
            showMemberName(memberIds[0], 0);
        }
    });
    </script>