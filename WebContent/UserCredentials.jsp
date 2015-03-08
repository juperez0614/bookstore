<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/Partial/Header.jsp"></jsp:include>
	<div class="container theme-showcase">
		<form id="insertUser" name="insertUser" action="UserAuthServlet"
			method="post" class="form-inline">
			<input type="hidden" name="insertUser" value="usercred" />
			<div class="form-group">
				<label for="newusernew">Username:</label> <input type="text"
					id="username" class="uname form-control" name="username"
					placeholder="Enter User Name" />
				<div class="status">${message }</div>
			</div>
			<br>
			<div class="form-group">
			<label for="newuserpassword">Password:</label> <input type="password" id="password"
				name="password" placeholder="Enter a password" class="form-control" /> 
				</div>
				<br /> 
				<div class="form-group">
				<label>Confirm
				Password:</label> <input type="password" id="passwordConfirm" name="passc"
				placeholder="Confirm password" class="form-control" /> 
			<div id="warning" class="feedback" style="color:red"></div>
			</div>
			<br />
			<button type="submit" class="btn btn-default" id="submit">Create Account</button>
		</form>
	</div>
	<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							$(".uname")
									.keyup(
											function() {
												console.log("in key up");
												var uname = $(this).val();
												if (uname.length >= 3) {
													$(".status")
															.html(
																	' Checking availability...');
													$
															.ajax({
																type : "POST",
																url : "UserAuthServlet?insertUser=usernameCheck&username="
																		+ uname,
																data : uname,
																success : function(
																		msg) {
																	$('.status')
																			.html(
																					msg);
																}
															});

												} else {

													$(".status")
															.html(
																	"<font color=red>Username should be <b>3</b> character long.</font>");
												}

											});
							if (document.getElementById('username').value == "") {
								document.getElementById('username').focus();
							}
							var elMsg = document.getElementById('warning');

							function loginCheck() {
								if (document.getElementById('username').value == "") {
									elMsg.textContent = "Pleaes enter your username";
									document.getElementById('username').focus();
									return false;
								}
								if (document.getElementById('password').value == "") {
									elMsg.textContent = "Please enter your password";
									document.getElementById('password').focus();
									return false;
								}
								if (document.getElementById('passwordConfirm').value == "") {
									elMsg.textContent = "Please confirm your password";
									document.getElementById('passwordConfirm')
											.focus();
									return false;
								}
								if (document.getElementById('password').value != document
										.getElementById('passwordConfirm').value) {
									elMsg.textContent = "The new password and confirmation password do not match.";
									document.getElementById('password').focus();
									return false;
								}
							}

							var elSubmit = document.getElementById('submit');
							elSubmit.onclick = loginCheck;
						});
	</script>
</body>
</html>