package WelcomePage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Exception.AuthException;
import Exception.AuthSupport;

/**
 * Servlet implementation class Contact
 */
@WebServlet("/Contact")
public class Contact extends HttpServlet 
{
	PreparedStatement stmt=null;
    Connection con=null;
    ResultSet rset=null;
	
    public Contact() {
    	
    }
    public void init(ServletConfig config)throws ServletException
	{
		super.init(config);
		ServletContext context=getServletContext();
		con=(Connection) context.getAttribute("gCon");
		try {
			stmt=con.prepareStatement("Insert into contact values(?,?,?)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
    	
    	public void destroy()
    	{
    		try {
    			if(stmt!=null)
    			{
    				stmt.close();
    			}
    			if(rset!=null)
    			{
    				rset.close();
    			}
    		} catch (Exception e) {
    			// TODO: handle exception
    			System.out.println(e.getMessage());
    		}
    	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String strName=request.getParameter("Name");
		String strEmail=request.getParameter("Email");
		String strMessage=request.getParameter("Message");
		DBHandler db=new DBHandler();
		con=db.getDbcon();
		try 
		{
			stmt.setString(1, strName);
			stmt.setString(2, strEmail);
			stmt.setString(3, strMessage);
			rset=stmt.executeQuery();
			if(rset.next())
			{
				response.sendRedirect(request.getContextPath()+"/WelcomePage.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
