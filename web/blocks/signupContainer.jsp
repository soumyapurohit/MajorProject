
<script>
    function showpass() {
        var x = document.getElementById("password");
        if (x.type === "password") {
            x.type = "text";
        } else {
            x.type = "password";
        }
    } 
</script>
<div class="register_account">
    
    <script src="../assets/js/valid.js" type="text/javascript"></script>
    <div class="wrap">
        <h4 class="title">Create an Account</h4>
    
        <form name="form1" action="${baseURL}/member/save" method="post">
            <div class="col_1_of_2 span_1_of_2">              

                <input type="text" placeholder="First Name" id="nm" name="fname">
                <span  id="s1"></span>
                
                <input type="text" placeholder="Last Name" id="nm1" name="lname">
                <span  id="s5"></span>

                <input type="text" id="phone" name="phone" value="" placeholder="Phone Number"/>
                <span  id="s4"></span>	 
                
                <div><input type="text" placeholder="E-mail" name='email' id="email" onkeyup="chkmail('${baseURL}')"></div>
                <span id="s2"></span>
                
                <div><input type="password" id="password" name="password"   placeholder="password">
                    
                    <span id="s3"></span>
                </div>
                
                <div><input type="password" id="cpassword" name="cpassword"   placeholder="Confirm password" onkeyup="chekpass()">
                    <i style="font-size:24px"  onclick="showpass();" class="fa">&#xf06e;</i>
                    <span id="s6"></span>
                </div>

                <button class="grey"  type="submit" onclick="return f1()">Submit</button>
                <p class="terms">By clicking 'Create Account' you agree to the <a href="#">Terms &amp; Conditions</a>.</p>



            </div>
            <div class="clear"></div>
        </form>
    </div>
</div>