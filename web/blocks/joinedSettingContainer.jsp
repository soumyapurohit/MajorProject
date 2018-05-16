<script src="../assets/plugins/jQuery/jquery.3.3.1.min.js" type="text/javascript"></script>
<script src="../assets/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<link href="../assets/bootstrap/bootstrap3.3.7.min.css" rel="stylesheet" type="text/css"/>


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

              
                     
                        <input type="hidden" value="${network.networkId}" name="networkId">
                         <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#delete">Leave Network</button>
                    
                        
                                           
                    <div class="modal fade" id="delete" role="dialog">
                        <div class="modal-dialog">

                            <!-- Modal content-->
                            <div class="modal-content">
                                <div class="modal-header">

                                    <h4 class="modal-title">Leave Network</h4>
                                </div>
                                <div class="modal-body" style="color:black">
                                    <h4>Are you sure you want to delete network?</h4>
                                </div>
                                <div class="modal-footer">
                                    
                                    <form action="${baseURL}/network/delete" method= "post">
                                     <input type="hidden" value="${network.networkId}" name="networkId">
                                    <button type="submit" class="btn btn-default" >Yes</button>
                                    
                                    
                                    <button type="button" class="btn btn-default" data-dismiss="modal">No</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                
                        
                        
              
                  
                        
                        

            </li>
        </ul>

    </div>    
                                        <div class="col-sm-1 col-lg-1 col-md-1" >
                                            
                                        </div>    

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
                      
                </tr>
            </c:forEach>
</table>
    </div>    

    <div class="col-sm-1 col-lg-1 col-md-1"></div>    
</div>


