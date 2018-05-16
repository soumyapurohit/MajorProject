<div class="col-md-4 col-lg-4 col-sm-4"></div> 
<div class="login col-md-4 col-lg-4 col-sm-4">
          	<div class="wrap">
				
				<div class="col_1_of_login span_1_of_login">
				<div class="login-title">
                                    <h4 class="title text-center">Congratulations....!!!</h4><br>
                                    <h4> Wow! You have almost done registering. You are just a step away.</h4>
                                    <br><h2>Let us confirm that it's you. We have sent you an OTP on your email address.</h2> 
                                    <br><br>
                                
					<div id="loginbox" class="loginbox">
						<form action="${baseURL}/user/otpVerify" method="post" name="login" id="login-form">
                                                    
                                                    <input type='hidden' name="userId" value="${uid}"/>
                                                    <input type='hidden' name="memberId" value="${mid}"/>
                                                    <fieldset class="input">
						    
                                                        <input type="text" name="otp" class="inputbox" size="10" autocomplete="off" placeholder="Enter Your One Time Password" required>
						   
						   
                                                           <div class="remember">
							    
                                                             <input type="submit" name="Submit" class="button" value="Submit"><div class="clear"></div><br>
                                                           
                                                            
							 </div>
						  </fieldset>
						 </form>
                                                     <div class="remember">
                                                    <input type="button" name="Resend" class="button" value="Resend" onclick="resend()" ><div class="clear"></div>
                                                     </div>
					</div>
			    </div>
				</div>
				<div class="clear"></div>
			</div>
		</div>
<div class="col-md-4 col-lg-4 col-sm-4"></div>

<script>
    
    function resend(){
         mid = "${mid}";
         uid = "${uid}";
        req = new XMLHttpRequest();
        url = "${baseURL}/user/resend?memberId=" + mid + "&userId=" + uid;
        req.open("GET", url); // controller path - invitation controller        
        req.onreadystatechange = function ()
        {
            if (req.readyState == 4) {
                res = req.responseText;
                console.log(url + " : " + res);
                if (res === "true") {
                    
                }

               
            }
        }
        req.send();
    }
    </script>