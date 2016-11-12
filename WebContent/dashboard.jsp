<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="cjc.UserName"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DashBoard</title>
</head>
<link rel="stylesheet" href="CSS/tablestyle.css">
<body>
<form name="checkTab" action="Tabs" method="doGet" >
<button class="buttonLogout" name = "logout">Log Out</button>
<h1><span class="yellow">Welcome to File Sharing Portal</span></h1>


<table>
<tr>
<td>
			<Button class="button" style="vertical-align:middle" name = "home">Home</Button>
		</td>
		<td>
			<Button class="button" style="vertical-align:middle" name = "friend">Add a Friend</Button>
		</td>
		<td>
			<Button class="button" style="vertical-align:middle" name = "send" >Send a File</Button>
		</td>
		<td>
			<Button class="button" style="vertical-align:middle" name = "recieve_message"> Received Messages</Button>
		</td>
		<td>
			<Button class="button" style="vertical-align:middle" name = "sent_message">Sent Messages</Button>
		</td>
		</tr>
		</table>
		</form>
<table class="container">
	<thead>
		<tr>
			<th colspan = "2" ><h1>Basic Information</h1></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>FIRSTNAME</td><td> ${firstname}</td>
		</tr>
		<tr>
			<td>LASTNAME</td><td> ${lastname}</td>
			</tr>
			<tr>
			<td>EMAIL-ID</td><td> ${emailid}</td>
			</tr>
			<tr>
			<td>USERNAME</td><td> ${username}</td>
			</tr>
			<tr>
			<td>GENDER</td><td> ${gender}</td>
			</tr>
			<tr>
			<td>DOB</td><td> ${dob}</td>
		</tr>
		
</tbody>
               
             
</form>
</body>
</html>