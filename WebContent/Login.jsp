<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form  id="loginUser" name="UserLogon" action="UserAuthServlet" method="post">
	 <input type="hidden" name="insertUser" value="login"/> 
	<label>Username:</label>
	<input type="text" id="username" name="username" placeholder="Enter User Name"/>
	<p class=".status">${message }</p>
	<br/>
	<label>Password:</label>
	<input type="password" id="password" name="password" placeholder="Enter a password"/>
	<br/>
	<input value="Sign in" type="submit" />
</form>
<a href="UserCredentials.jsp">Create New Account</a>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js">
$(document).ready(function(){  
    $("#username").keyup(function(){  
        var uname = $(this).val();  
        if(uname.length >= 3){  
            $(".status").html(' Checking availability...');  
             $.ajax({  
                type: "POST",  
                url: "UserAuthServlet?action=usernameCheck",  
                data: "uname="+ uname,  
                success: function(msg){  

                   $('.status').html(msg);
                }  
            });   
        }  
        else{  
               
            $(".status").html("<font color=red>Username should be <b>3</b> character long.</font>");  
        }  
          
    });  
});  
if(document.getElementById('username').value==""){
		document.getElementById("username").focus(); 
	}
</script>
</body>
</html>