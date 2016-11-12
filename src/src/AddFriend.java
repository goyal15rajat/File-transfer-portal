package src;



import java.io.*;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cjc.SqlConnectionFriends;
import cjc.UserName;

import java.sql.*;

/**
 * Servlet implementation class AddFriend
 */
public class AddFriend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFriend() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SqlConnectionFriends s = new SqlConnectionFriends();
		String followed = request.getParameter("frnd");
		try {
			int result = s.addFriend(followed);
			if(result == 1){
				System.out.println("ENTERED");
			}
			RequestDispatcher view = request.getRequestDispatcher("/search.jsp");
			view.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
		try {
			s.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				    
			
		
	}

}
