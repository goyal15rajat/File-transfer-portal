	<link rel="stylesheet" href="CSS/tablestyle.css">
	<%@page import="java.sql.DriverManager"%>
	<%@page import="java.sql.ResultSet"%>
	<%@page import="java.sql.Statement"%>
	<%@page import="java.sql.Connection"%>
	<%@page import="cjc.SqlConnectionTransfer"%>
	<%@page import="cjc.UserName"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	
	<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Messages</title>
</head>
<link rel="stylesheet" href="CSS/tablestyle.css">
<body>
<form name="checkTab" action="Tabs" method="doGet" >
<button class="buttonLogout" name = "logout">Log Out</button>
<h1 style="margin-top:30px;"><span class="yellow" >Welcome to File Sharing Portal</span></h1>


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
	<%
	SqlConnectionTransfer c = new SqlConnectionTransfer();
	System.out.println("SQLCONNECTION SUCCESS");
		%>


<h1><span class="blue">&lt;</span>Table<span class="blue">&gt;</span> <span class="yellow">Messages</pan></h1>
<form name="getdata" action="DnldFilee" method="doGet">
<table class="container">
	<thead>
		<tr>
			<th><h1>Sent to</h1></th>
			<th><h1>File Name</h1></th>
			<th><h1>Format</h1></th>
			<th><h1>Click here to Download</h1></th>
		</tr>
	</thead>
	<tbody>
	<tr>
	<%	
	ResultSet resultSet = null;
	resultSet = c.getSentMessages(UserName.USERNAME);
	while(resultSet.next()){
	%>

	<td><%=resultSet.getString("RECIEVERS") %></td>
	<td><%=resultSet.getString("FILENAME") %></td>
	<td><%=resultSet.getString("FORMAT") %></td>
	<td><button name = "id" value= "<%=resultSet.getInt("ID")%>">DOWNLOAD</button></td>
	</tr>
<%} %>

</tbody>
</table>
</form>
</body>
</html>