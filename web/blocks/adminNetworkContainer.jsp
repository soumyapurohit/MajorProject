<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">

    </section>

    <!-- Main content -->
    <section class="content"> 
        <h1> ${member.fname}  ${member.lname}</h1>
        <table class="table" >
            <c:forEach items="${networks}" var="network">
                <tr class="info">
                    <td><b>
                    <c:if test="${member.profilePic == NULL}">
                        <img src="${baseURL}/assets/images/user.png" height="50px" width="50px"/> 
                    </c:if>

                    <c:if test="${member.profilePic != NULL}">
                         <img src="${baseURL}/assets/upload/${member.memberId}/${network.networkId}/${network.profilePic}" style="height:50px; width:50px; border:1px solid black; border-radius:50px;">
                    </c:if>
 
                     </b></td>
                    <td><b>${network.title}</b></td>
                    <td><b>${network.createDate}</b></td>
                    <td><b>${network.networkType}</b></td>

                </tr>
            </c:forEach>
        </table>
    </section><!-- /.content -->
</div><!-- /.content-wrapper -->
