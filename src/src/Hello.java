package src;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cjc.User;
import cjc.UserDetails;
import cjc.UserName;

/**
 * Servlet implementation class Hello
 */

public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hello() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User u = new User();
		System.out.println("Helloo");
			System.out.println("inside2");
			if(request.getParameter("login")!=null){
				System.out.println("LOGIN");
				String userId , password ;
				userId=request.getParameter("unameLog");
		        password=request.getParameter("pass");
		        boolean result ;
				result = u.login_hash(userId, password);
				if(result){
					System.out.println("Successfull Login!!");
					u.getDetails(userId);
					request.setAttribute("USERNAME", userId);
					UserName.USERNAME = userId ;
					RequestDispatcher rd = request.getRequestDispatcher("DashBoard");
					rd.forward(request,response);
				}
				else{
					System.out.println("Login Failed");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			}
			else if (request.getParameter("signup") != null){
				System.out.println("SIGNUP");
				UserDetails user_d = new UserDetails();
				SimpleDateFormat k = new SimpleDateFormat("yyyy-MM-dd");
				String firstName , lastName , username , password , emailId , d ;
				Date dob  = null;
				String gender ;
				firstName = request.getParameter("fname");
				lastName = request.getParameter("lname");
				username = request.getParameter("uname");
				password = request.getParameter("pass");
				emailId = request.getParameter("email");
				gender = request.getParameter("gender");
				d = request.getParameter("dob");
				try {
					dob = k.parse(d);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				user_d.setFirstname(firstName);
				user_d.setLastname(lastName);
				user_d.setPassword(password);
				user_d.setUsername(username);
				user_d.setEmailId(emailId);
				user_d.setDob(dob);
				user_d.setG(gender);
				System.out.println(user_d.getFirstname()+user_d.getLastname()+user_d.getEmailId()+user_d.getDob()+user_d.getG()+user_d.getUsername());
				boolean result = false ;
				result = u.signup(user_d);
				//System.out.println("Firstname : "+firstName  + "\nLastName : " + lastName + "\nUsername : " + username + "\nPassword : "+ password + "\nEmail ID : " + emailId + "\nGender : " + gender + "\nDOB : " + dob );
				//System.out.println("RESULT :: " + result);
				if(result){
					//System.out.println("Result " + result );
					//OPEN DASHBOARD
					request.getRequestDispatcher("index.jsp").forward(request, response);
					
				}
				else{
					if(u.getCheck() == 1){
						System.out.println("Username already exists");
						String error = "Username already exists";
						request.getSession().setAttribute("error", error);
						request.getRequestDispatcher("index.jsp").forward(request, response);
						//print error message in jsp that username already taken
					}
					else{
						//any other problem
						System.out.println("Problem while signing up");
						String error = "Problem While Signing Up . Please Try Again Later...";
						request.getSession().setAttribute("error", error);
						request.getRequestDispatcher("index.jsp").forward(request, response);
						
					}
				}
			}
			else{
				request.getRequestDispatcher("index.jsp").forward(request, response);
				System.out.println("Something bad happen");
			}
		
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
