
<script>
function showpass() {
    var x = document.getElementById("modlgn_passwd");
    if (x.type === "password") {
        x.type = "text";
    } else {
        x.type = "password";
    }
}


function ValidateEmail(inputText)
{
var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
if(inputText.value.match(mailformat))
{
document.login.email.focus();
return true;
}
else
{
alert("You have entered an invalid Email address!");
document.login.email.focus();
return false;
}
}
</script>
<div class="login">
          	<div class="wrap">
				<div class="col_1_of_login span_1_of_login">
					<h4 class="title">New Members</h4>
					<p>Hey Buddy! It is really easy to connect with one & all when all your friends are just one click away. So, yeah, Come let's get started ASAP!</p>
					<div class="button1">
					   <a href="${baseURL}/homedesk/register"><input type="submit" name="Submit" value="Create an Account"></a>
					 </div>
					 <div class="clear"></div>
				</div>
				<div class="col_1_of_login span_1_of_login">
				<div class="login-title">
	           		<h4 class="title">Registered Members</h4>
					<div id="loginbox" class="loginbox">
						<form action="${baseURL}/member/login" method="post" name="login" id="login-form">
						  <fieldset class="input">
						    <p id="login-form-username">
						      <label for="modlgn_username">Email</label>
                                                      <input id="modlgn_username" type="email" name="email" class="inputbox" size="18" autocomplete="off" required>
						    </p>
						    <p id="login-form-password">
						      <label for="modlgn_passwd">Password</label>
                                                      <input id="modlgn_passwd" type="password" name="password" class="inputbox" size="18" autocomplete="off" required>
                                                      <i style="font-size:24px"  onclick="showpass();" class="fa">&#xf06e;</i>
						    </p>
						    <div class="remember">
							    <p id="login-form-remember">
							      <label for="modlgn_remember"><a href="#">Forget Your Password ? </a></label>
							   </p>
							    <input type="submit" name="Submit" class="button" value="Login" onclick="ValidateEmail(document.login.email)"><div class="clear"></div>
							 </div>
						  </fieldset>
						 </form>
                                            </div>
			    </div>
				</div>
				<div class="clear"></div>
			</div>
		</div>
