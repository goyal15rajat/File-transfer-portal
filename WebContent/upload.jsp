<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Send a File</title>
</head>
<link rel="stylesheet" href="CSS/tablestyle.css">
<body>
<form name="checkTab" action="Tabs" method="doGet" >
<button class="buttonLogout" name = "logout">Log Out</button>
<h1><span class="yellow">Welcome to File Sharing Portal</pan></h1>
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
		<div id="send">
	<form name="uploadfile" action="SendFile" method="doGet" >
	<input type="file" name="file" size="50" placeholder="select the file to be uploaded"/>
	<br>
	<div class="labeldiv">
	<label > Friend name </label>
	<input type="text" name = "friendName" required placeholder="select friend"/>
	</div>
	<br>
	<h3>${error}</h3>
	<Button class="buttonsearch" style="vertical-align:middle" name = "uploadbutton">Upload</Button>
	</form>
	</div>
	</body>
</html>