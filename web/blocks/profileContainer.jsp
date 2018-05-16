   

<script>
    $(function () {
        $(".datepicker").datepicker();
    });



</script>
<style>
    form{
        opacity:0.9;
    }
</style>
<div style="background-Image:url(${baseURL}/assets/images/22.jpg);background-repeat:no-repeat;background-size:cover;color: white;opacity:0.9; ">
    <h3 class="text-center"> <b>Member Personal Details </b></h3>
    <div class="register_account">
        <form action="${baseURL}/member/profilesave" method="post" enctype="multipart/form-data">
            <input type="hidden" value="${member.memberId}" name="memberId">
            <div class="row">
                <div class="col-md-1 col-sm-1 col-lg-1"></div>
                <div class="col-md-2 col-sm-2 col-lg-2">

                    <c:if test="${member.profilePic == NULL}">
                        <img src="${baseURL}/assets/images/user.png" height="100px" width="100px"/> 
                    </c:if>

                    <c:if test="${member.profilePic != NULL}">
                        <img src="${baseURL}/assets/upload/${member.memberId}/${member.profilePic}" height="100px" width="100px"/> 
                    </c:if>

                    <br>                    
                    <input type="file" name="profileImage">                 
                </div>
                <div class="col-md-4 col-sm-4 col-lg-4">
                    <input type="text"  placeholder="First Name" name="fname" value="${member.fname}">
                    <br>
                    <input type="text"  placeholder="Phone number" name="phone" value="${member.phone}">
                    <br>
                    <input type="text"  placeholder="Home City" name="city" value="${member.city}">
                    <br>
                    <label>Gender :</label>
                    <input type="radio" name="gender" value="male" ><label>Male</label>
                    <input type="radio" name="gender" value="female"><label>Female</label>
                    <br><br>
                    
                    
                    
                </div>
                <div class="col-md-4 col-sm-4 col-lg-4">
                    <input type="text"  placeholder="Last Name" name="lname" value="${member.lname}">
                    <br>
                    <input type="text"  placeholder="Email address" name="email" value="${member.email}">
                    <br>
                    <input type="text" class="datepicker" placeholder="Date of Birth" name="dateOfBirth" value="${member.dateOfBirth}">
                    <br>
                    
                    <input type="submit" class="btn btn-info right" Value="Update" id="flip2">
                    <br><br>
                    
                </div>
                    
                <div class="col-md-1 col-sm-1 col-lg-1"></div>
            </div>
        </form>
    </div>

                    
                    
                    
                    
    <div class="register_account">
        <form action="${baseURL}/member/passSave" method="post" enctype="multipart/form-data">
            <input type="hidden" value="${member.memberId}" name="memberId">
            
            <div class="row">
                <div class="col-md-1 col-sm-1 col-lg-1"></div>
                <div class="col-md-2 col-sm-2 col-lg-2">
                </div>
                <div class="col-md-4 col-sm-4 col-lg-4">
                    
                    <h4>  <label>Change your password :</label></h4>
                    <input type="password"  placeholder="Old Password" name="oldPass">
                    <br>
                    <input type="password"  placeholder="New Password" name="newPass">
                    <br>
                </div>
                <div class="col-md-4 col-sm-4 col-lg-4">
                   
                    <br><br><br>
                     <input type="submit" class="btn btn-info right" Value="Update" id="flip2">
                </div>
                <div class="col-md-1 col-sm-1 col-lg-1"></div>
            </div>
        </form>
    </div>

                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
    <h3 class="text-center"> <b>Member Qualification Details</b></h3>

    <div class="register_account">
        <form action="${baseURL}/Qualification/profilesave" method="post" enctype="multipart/form-data">
            <input type="hidden" value="${member.memberId}" name="memberId">
            <input type="hidden" value="${qualification.qualification_id}" name="qualification_id">
            <div class="row">
                <div class="col-md-1 col-sm-1 col-lg-1"></div>
                <div class="col-md-2 col-sm-2 col-lg-2">
                </div>
                <div class="col-md-4 col-sm-4 col-lg-4">
                    <input type="text"  placeholder="Title:Student/Employee" name="title" value="${qualification.title}">
                    <br>
                    <input type="text"  placeholder="Stream:BSc/BE/MCA" name="stream" value="${qualification.stream}">
                    <br>
                    <input type="text"  placeholder="College Name" name="college" value="${qualification.college}">
                    <br>

                </div>
                <div class="col-md-4 col-sm-4 col-lg-4">
                    <select name="type">
                        <option value="${qualification.type}">Type</option>
                        <option>Master's Degree</option>
                        <option>Bachelor's Degree</option>
                        <option>Diploma</option>
                        <option>12th</option>
                        <option>10th</option>
                    </select>
                    <br>
                    <input type="text"  placeholder="Year of passing out:2018" name="year" value="${qualification.year}">
                    <br>
                    <input type="text"  placeholder="Percentage" name="percentage" value="${qualification.percentage}">
                    <br>
                    <input type="submit" class="btn btn-info right" Value="Update" id="flip2">
                </div>
                <div class="col-md-1 col-sm-1 col-lg-1"></div>
            </div>
        </form>
    </div>

                    <h3  class="text-center"> <b> Member Professional Details</b></h3>

    <div class="register_account">
        <form action="${baseURL}/Profession/profilesave" method="post" enctype="multipart/form-data">
            <input type="hidden" value="${member.memberId}" name="memberId">
            <input type="hidden" value="${profession.professionId}" name="professionId">
            <div class="row">
                <div class="col-md-1 col-sm-1 col-lg-1"></div>
                <div class="col-md-2 col-sm-2 col-lg-2">
                </div>
                <div class="col-md-4 col-sm-4 col-lg-4">
                    <input type="text"  placeholder="Title:Associate Engineer" name="title" value="${profession.title}">
                    <br>
                    <input type="text"  placeholder="Designation" name="designation" value="${profession.designation}">
                    <br>
                    <input type="text" class="datepicker" placeholder="Date of Joining" name="joinDate" value="${profession.joinDate}">
                    <br>
                    <input type="text"  placeholder="Current City" name="city" value="${profession.city}">
                </div>
                <div class="col-md-4 col-sm-4 col-lg-4">
                    <input type="text"  placeholder="Company Name" name="companyName" value="${profession.companyName}">
                    <br>
                    <input type="text"  placeholder="Package" name="pack" value="${profession.pack}">
                    <br>
                    <input type="text" class="datepicker" placeholder="Date of Resigning" name="endDate" value="${profession.endDate}">
                    <br>
                    <input type="submit" class="btn btn-info right" Value="Update" id="flip2">
                </div>
                <div class="col-md-1 col-sm-1 col-lg-1"></div>
            </div>
        </form>
    </div>
</div>           
</body>
</html>
