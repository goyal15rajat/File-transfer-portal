package src;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cjc.User;

/**
 * Servlet implementation class Search_1
 */
public class Search_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search_1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		User u = new User();
		
		HashMap<String,String> up  = new HashMap <String,String>();
		up= u.ret_hash();
		
		if(request.getParameter("search")!=null){
			String searchPara;
			searchPara=request.getParameter("searchbox");
			//request.getRequestDispatcher("index3.jsp").forward(request, response);
			request.setAttribute("user", up.get(2));
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index3.jsp");
            requestDispatcher.forward(request, response);
			
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
