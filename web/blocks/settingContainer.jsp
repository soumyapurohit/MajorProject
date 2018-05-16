<script src="../assets/plugins/jQuery/jquery.3.3.1.min.js" type="text/javascript"></script>
<script src="../assets/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<link href="../assets/bootstrap/bootstrap3.3.7.min.css" rel="stylesheet" type="text/css"/>
<script>
    var memberIds = [];
    var index = 0;

    function checkInvitation(memberid, counter)
    {
        network = "${network.networkId}";
        req = new XMLHttpRequest();
        url = "${baseURL}/invite/show?networkId=" + network + "&memberId=" + memberid;
        req.open("GET", url); // controller path - invitation controller        
        req.onreadystatechange = function ()
        {
            if (req.readyState == 4) {
                res = req.responseText;
                console.log(url + " : " + res);
                if (res === "true") {
                    btag = document.getElementById("c" + memberid);
                    btag.innerHTML = "Sent";
                }

                console.log("SS : " + memberIds.length + " counter : " + counter);
                if (counter < memberIds.length - 1) {
                    counter++;
                    checkInvitation(memberIds[counter], counter);
                }
            }
        }
        req.send();
    }
</script>
<div class="row">
    <div class="col-sm-1 col-lg-1 col-md-1"></div>    

    <div class="col-sm-2 col-lg-2 col-md-2">
        <br>
        <div class="text-center">          
            <form action="${baseURL}/network/networkIcon" method="post" enctype="multipart/form-data">
                <input type="hidden" value="${network.networkId}" name="networkId">
                
                <c:if test="${network.profilePic == NULL}">
                        <img src="${baseURL}/assets/images/network.png" height="100px" width="100px"/> 
                </c:if>

                <c:if test="${network.profilePic != NULL}">
                        <img src="${baseURL}/assets/upload/${network.memberId}/${network.networkId}/${network.profilePic}" height="100px" width="100px"/> 
                </c:if>
                
               <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Change</button>
          
                <div class="container">                   
                    <div class="modal fade" id="myModal" role="dialog">
                        <div class="modal-dialog">

                            <!-- Modal content-->
                            <div class="modal-content">
                                <div class="modal-header">

                                    <h4 class="modal-title">Change Network Icon</h4>
                                </div>
                                <div class="modal-body">
                                    <input type="file" name="networkPic">
                                </div>
                                <div class="modal-footer">
                                    <button type="submit" class="btn btn-default" >Upload</button>
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>


            <hr>
        </div>

        <br>










        <ul style="line-height: 40px">

            <li class="btn btn-info">

                <span>


                    <!-- Trigger the modal with a button -->
                    <form action="${baseURL}/network/addmember" method= "post">
                        <input type="hidden" value="${network.networkId}" name="networkId">
                        <button type="submit" class="btn btn-info btn-lg">Add Member</button>
                    </form>

                    <!-- Modal -->
                    <div class="modal fade" id="addmember" role="dialog" >
                        <div class="modal-dialog">

                            <!-- Modal content-->
                            <div class="modal-content"  style="height:500px;overflow:auto">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title" style="color:black">Add New Members</h4>
                                </div>
                                <form action="${baseURL}/invite/add" method= "post">
                                    <div class="modal-body" style="color:black">
                                        <section class="content">
                                            <table class="table" >
                                                <th> </th> 
                                                <th>Profile Pic</th> 
                                                <th>First Name</th> 
                                                <th>Last Name</th> 
                                                <th>&nbsp;Phone</th>
                                                <th>&nbsp;Email</th>

                                                <c:forEach items="${members}" var="member">

                                                    <tr class="info">
                                                        <td><b id="c${member.memberId}">
                                                                <input type="checkbox"   value='${member.memberId}' name="members[]">
                                                            </b></td>
                                                        <td><b>
                                                                <c:if test="${member.profilePic == NULL}">
                                                                    <img src="${baseURL}/assets/images/user.png" height="50px" width="50px"/> 
                                                                </c:if>

                                                                <c:if test="${member.profilePic != NULL}">
                                                                    <!--img src="${baseURL}/assets/upload/${member.memberId}/${member.profilePic}" style="height:50px; width:50px; border:1px solid black; border-radius:50px;"-->
                                                                </c:if>

                                                            </b></td>             
                                                        <td><b>${member.fname}</b></td>
                                                        <td><b>${member.lname}</b></td>
                                                        <td><b>${member.phone}</b></td>
                                                        <td><b>${member.email}</b></td>


                                                    </tr>
                                                    <script>
                                                        memberIds[index] = '${member.memberId}';
                                                        index++;
                                                    </script>
                                                </c:forEach>
                                            </table>
                                        </section>


                                    </div>
                                    <div class="modal-footer">

                                        <button type="submit" class="btn btn-default">Add</button>
                                        <input type="hidden" value="${network.networkId}" name="networkId">
                                        </form>

                                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>

                                    </div>
                            </div>

                        </div>
                    </div>

                </span>



            </li>

                   
        </ul>

    </div>    
    <div class="col-sm-1 col-lg-1 col-md-1"></div>    

    <div class="col-sm-7 col-lg-7 col-md-7">
        <table class="table">
            <caption><h1>${network.title}</h1></caption>
        <c:forEach items="${net_members}" var="netmember">
                <tr class="info">
                     
                    <td>
                    <c:if test="${netmember.profilePic == NULL}">
                        <img src="${baseURL}/assets/images/user.png" height="60px" width="60px"/> 
                    </c:if>

                    <c:if test="${netmember.profilePic != NULL}">
                         <img src="${baseURL}/assets/upload/${netmember.memberId}/${netmember.profilePic}" style="height:60px; width:60px; border:1px solid black; border-radius:50px;">
                    </c:if>
 
                     </td>             
                     <td><h2>${netmember.fname} &nbsp; ${netmember.lname}</h2></td>
                     
                     <td>
                         <input type='checkbox' class="admincheck" data-member="${netmember.memberId}">
                     </td>
                      
                </tr>
            </c:forEach>
</table>

    </div>    

    <div class="col-sm-1 col-lg-1 col-md-1"></div>    
</div>


<script>
    
    $(".admincheck").change(function()
    {        
        status = $(this).prop('checked');
        network = "${network.networkId}";
        member = $(this).data('member');
        
        alert(status + " : "+network +" : "+ member);
        
        if(status===true){
        req = new XMLHttpRequest();
        url = "${baseURL}/network/createAdmin?networkId=" + network + "&memberId=" + member;
        req.open("GET", url);
        req.onreadystatechange = function ()
        {
            if (req.readyState == 4) {
                                   
                 }
        }
         req.send();
        }
        else{
            
            
        }
    });
  


    
    var members = '${members}';
    if (members != '') {

        $('#addmember').modal('show');
        if (memberIds.length > 0)
        {
            checkInvitation(memberIds[0], 0);
        }
    }
</script> 