function f1()
{
    var flag = true;

    var nm = document.getElementById("nm").value;
    if (nm.length == 0)
    {
        document.getElementById("s1").innerHTML = "*Please Enter Name";
        s1.style.color = "red";
        flag = false;
    } else {
        document.getElementById("s1").innerHTML = "";
    }


    var nm1 = document.getElementById("nm1").value;
    if (nm1.length == 0)
    {
        document.getElementById("s5").innerHTML = "*Please Enter Last Name";
        s5.style.color = "red";
        flag = false;
    } else {
        document.getElementById("s5").innerHTML = "";
    }


    var email = document.getElementById("email").value;
    if (email.length == 0)
    {
        document.getElementById("s2").innerHTML = "Please Enter E-mail";
        s2.style.color = "red";
        flag = false;
    }
    else {
        document.getElementById("s2").innerHTML = "";
    }





    var pwd = document.getElementById("password").value;
    if (pwd.length == 0)
    {
        document.getElementById("s3").innerHTML = "Please Enter Password";
        s3.style.color = "red";
        flag = false;
    } else if (pwd.length < 5 || pwd.length > 10)
    {
        document.getElementById("s3").innerHTML = "*Password Must be 5-10 Charcters long";
        s3.style.color = "red";
        flag = false;
    } else
    {
        document.getElementById("s3").innerHTML = "";
    }






    var phone = document.getElementById("phone").value;
    s4 = document.getElementById("s4");
    if (phone.length == 0)
    {
        s4.innerHTML = "*Please Enter contact number";
        s4.style.color = "red";
        flag = false;
    } else if (isNaN(phone))
    {
        s4.innerHTML = "*Contact Number must be numeric";
        s4.style.color = "red";
        flag = false;
    } else if (phone.length != 10)
    {
        s4.innerHTML = "*Contact Number must be 10 digit";
        s4.style.color = "red";
        flag = false;
    } else
    {
        s4.innerHTML = "";
    }






    return flag;
    // alert("Hello World...............");
}

function chkmail(baseURL)
{
    var email = document.getElementById("email").value;


    pattern = /^[a-zA-Z0-9_.]+@[a-zA-Z]+\.[a-zA-Z]+$/;
    b = pattern.test(email);
    if (!b)
    {
        document.getElementById("s2").innerHTML = "enter correct email";
    }
    else
    {
        document.getElementById("s2").innerHTML = "";
        var url = baseURL + "/member/checkemail?email=" + email;
        req = new XMLHttpRequest();
        req.open("GET", url);
        req.onreadystatechange = function () {
            if (req.readyState == 4) {
                response = req.responseText;
                if (response === 'true')
                {
                    document.getElementById("s2").innerHTML = "Already Exist !";
                }
            }
        }
        req.send()
    }
}



function chekpass()
{


    var pwd1 = document.getElementById("cpassword").value;
    var pwd = document.getElementById("password").value;
    if (pwd1 != pwd)
    {
        document.getElementById("s6").innerHTML = "*Password not Match";
        s6.style.color = "red";
        flag = false;
    } else
    {
        document.getElementById("s6").innerHTML = "";
    }
}




function clearfields(x)
{
    x.innerHTML = "";
}






