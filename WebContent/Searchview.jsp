<%@ page import="java.util.*" %>
 <%@ page import="src.AddFriend" %>
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
		<table class="containerfriends">
		<%
			if(request.getAttribute("friendList")!=null){
				ArrayList<String> friends = (ArrayList<String>)request.getAttribute("friendList");
				Iterator it = friends.iterator();
				while(it.hasNext()){
					String name = (String)it.next();
					%><tr><td><h4><%=name %></h4></td></tr>
					<% 
				}
			}
		%>
		</table>
		<div id="send"> 
    		<form name="srch" action="AddFriend" method="doGet">
           <b>You can Add Friend by Clicking on Usernames</b><br>
               
            <%
                int count = 0;
                
                if (request.getAttribute("piList") != null) {
                	ArrayList<String> list = (ArrayList<String>) request.getAttribute("piList");
                    Iterator itr = list.iterator();
                    while (itr.hasNext()) {
                        count++;
                        String pList = (String) itr.next();
            %>
                <p><input name = "frnd" type = "submit" value = "<%=pList%>"/ ></p>
                
			  	              
            <%
                    }
                }
                if (count == 0) {
            %>
            
                <b>No User with this name..</b><br>
            <%            }
            %>
</form>
</div>
    </body>
</html>