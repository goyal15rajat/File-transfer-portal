package src;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cjc.User;
import cjc.UserDetails;

/**
 * Servlet implementation class DashBoard
 */
public class DashBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashBoard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User u = new User();
		String uname = (String) request.getAttribute("USERNAME");
		System.out.println("DASHBOARD " + uname );
		UserDetails log_user  = u.getDetails(uname);
		if(log_user != null){
			System.out.println("DASHBOARD : LOG_USER " +log_user.getEmailId()+log_user.getUsername());
			request.getSession().setAttribute("firstname",log_user.getFirstname());
			request.getSession().setAttribute("lastname",log_user.getLastname());
			request.getSession().setAttribute("emailid",log_user.getEmailId());
			request.getSession().setAttribute("username",log_user.getUsername());
			request.getSession().setAttribute("gender",log_user.getG());
			request.getSession().setAttribute("dob",log_user.getDob());
			request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		}
		else{
			System.out.println("DASHBOARD - LOGIN HO GYA BUT DATA NH MIL RHA");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
