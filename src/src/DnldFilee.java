package src;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cjc.SqlConnectionTransfer;
/**
 * Servlet implementation class DnldFilee
 */
public class DnldFilee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DnldFilee() {
        super();
        // TODO Auto-generated constructor stub
    }
    private static final int BUFFER_SIZE = 4096;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int uploadId = Integer.parseInt(request.getParameter("id"));
    	SqlConnectionTransfer s = new SqlConnectionTransfer();
        ResultSet result;
		try {
			result = s.downloadFile(uploadId);
			if (result.next()) {
			    String fileName = result.getString("FILENAME");
			    Blob blob = result.getBlob("DATA");
			    InputStream inputStream = blob.getBinaryStream();
			    int fileLength = inputStream.available();
			     
			    System.out.println("fileLength = " + fileLength);

			               
			    //describes the datatype-in this case it signifies Binary Data 
			    response.setContentType("application/octet-stream");
			    response.setContentLength(fileLength);
			    String headerKey = "Content-Disposition";
			    //It says that don't show the file rather store the file in Machine
			    String headerValue = String.format("attachment; filename=\"%s\"", fileName);
			    response.setHeader(headerKey, headerValue);

			    
			    OutputStream outStream = response.getOutputStream();
			     
			    byte[] buffer = new byte[BUFFER_SIZE];
			    int bytesRead = -1;
			     
			    while ((bytesRead = inputStream.read(buffer)) != -1) {
			        outStream.write(buffer, 0, bytesRead);
			    }
			     
			    inputStream.close();
			    outStream.close();             
			} else {
			    
			    response.getWriter().print("File not found for the id: " + uploadId);  
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
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
		// TODO Auto-generated method stub
		
	}
}