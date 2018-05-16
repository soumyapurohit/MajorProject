<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    <c:set var="req" value="${pageContext.request}" />
    <c:set var="baseURL" value="${req.scheme}://${req.serverName}:${req.serverPort}${req.contextPath}" />

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">

    </section>

    <!-- Main content -->
    <section class="content">
        <table class="table" >
            <c:forEach items="${members}" var="member">
                <tr class="info">
                     <td><b>${member.memberId}</b></td>
                    <td><b>
                    <c:if test="${member.profilePic == NULL}">
                        <img src="${baseURL}/assets/images/user.png" height="50px" width="50px"/> 
                    </c:if>

                    <c:if test="${member.profilePic != NULL}">
                         <img src="${baseURL}/assets/upload/${member.memberId}/${member.profilePic}" style="height:50px; width:50px; border:1px solid black; border-radius:50px;">
                    </c:if>
 
                     </b></td>             
                     <td><b>${member.fname}</b></td>
                     <td><b>${member.lname}</b></td>
                      <td><b>${member.phone}</b></td>
                       <td><b>${member.email}</b></td>
                       <td><b><a href="${baseURL}/admin/mynetwork?memberId=${member.memberId}">View Networks</a></b></td>
                       
                </tr>
            </c:forEach>
        </table>
    </section><!-- /.content -->
</div><!-- /.content-wrapper -->
