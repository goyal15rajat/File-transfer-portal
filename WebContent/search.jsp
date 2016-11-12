<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
 
<html>
  <head>
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
		   <form method="doGet" name="frm" action="Search">
      
   
         <input  type="text" name="pid" id="pid" placeholder="search for your friends">
         <Button class="buttonsearch" style="vertical-align:middle" name = "submit">Search</Button>
     
    </form>
    </div>
    
  </body>
</html>