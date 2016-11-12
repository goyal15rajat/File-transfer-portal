package src;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cjc.AttachFile;
import cjc.SqlConnectionFriends;
import cjc.UserName;

/**
 * Servlet implementation class SendFile
 */
public class SendFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if(request.getParameter("uploadbutton")!=null){
			String filepath = request.getParameter("file");
			String friendName = request.getParameter("friendName");
			SqlConnectionFriends connect = new SqlConnectionFriends();
			try {
				ResultSet s = connect.getFriendlist();
				ArrayList<String> friends = new ArrayList<String>();
				while(s.next()){
					  friends.add(s.getString("FRIEND"));
					   }
				if(friends.contains(friendName)){
					System.out.println("SendFile--doGet--FilePath : "+ filepath + " \nFriendName: "+ friendName);
					AttachFile file  = new AttachFile();
					if(UserName.USERNAME == null || UserName.USERNAME.isEmpty()){
						request.getSession().setAttribute("unameLog","");
						request.getRequestDispatcher("index.jsp").forward(request, response);
					}
					file.insertFile(filepath, friendName,UserName.USERNAME);
					request.getRequestDispatcher("dashboard.jsp").forward(request, response);
				}else{
					request.setAttribute("error", "Please Enter your Friends Username");
					request.getRequestDispatcher("upload.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
		else{
			System.out.println("SendFile--doGet--File not Uploaded");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
