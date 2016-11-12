package src;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cjc.UserName;

/**
 * Servlet implementation class Tabs
 */
public class Tabs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tabs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("friend")!=null){
			if(UserName.USERNAME == null || UserName.USERNAME.isEmpty())
				request.getRequestDispatcher("index.jsp").forward(request, response);
			else
				request.getRequestDispatcher("search.jsp").forward(request, response);
		}
		else if (request.getParameter("send")!=null){
			if(UserName.USERNAME == null || UserName.USERNAME.isEmpty())
				request.getRequestDispatcher("index.jsp").forward(request, response);
			else
				request.getRequestDispatcher("upload.jsp").forward(request, response);
		}
		else if (request.getParameter("sent_message")!=null){
			if(UserName.USERNAME == null || UserName.USERNAME.isEmpty())
				request.getRequestDispatcher("index.jsp").forward(request, response);
			else{
				UserName.MESSAGE="Send";
				request.getRequestDispatcher("dnld.jsp").forward(request, response);
			}
		}
		else if(request.getParameter("recieve_message")!=null){
			if(UserName.USERNAME == null || UserName.USERNAME.isEmpty())
				request.getRequestDispatcher("index.jsp").forward(request, response);
			else{
				request.getRequestDispatcher("recievefile.jsp").forward(request, response);
			}
		}
		else if(request.getParameter("send_message")!=null){
			if(UserName.USERNAME == null || UserName.USERNAME.isEmpty())
				request.getRequestDispatcher("index.jsp").forward(request, response);
			else{
				request.getRequestDispatcher("dnld.jsp").forward(request, response);
			}
		}
		else if(request.getParameter("logout")!=null){
			UserName.USERNAME = "";
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else{
			if(UserName.USERNAME == null || UserName.USERNAME.isEmpty())
				request.getRequestDispatcher("index.jsp").forward(request, response);
			else
				request.getRequestDispatcher("dashboard.jsp").forward(request, response);
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
