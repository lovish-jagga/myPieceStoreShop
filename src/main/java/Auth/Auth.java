package Auth;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.print.attribute.standard.RequestingUserName;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import WelcomePage.DBHandler;
import oracle.jdbc.pool.OracleDataSource;
@WebServlet("/Auth")
public class Auth extends HttpServlet {
	PreparedStatement stmt=null;
	Connection con;
	ResultSet rset=null;
    DBHandler db=new DBHandler();
    public Auth() {
    }
    public void init(ServletConfig config)throws ServletException
    {
    	super.init(config);
//		ServletContext context=getServletContext();
//		con=(Connection) context.getAttribute("gCon");
    	ServletContext context=getServletContext();
    	con=db.getDbcon();
    	context.setAttribute("gCon", con);

		db.getDbcon();
    	try {
			stmt=con.prepareStatement("Select * from users where fullName=? and createPassword =?");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
      public void destroy()
    {
    	try
    	{
	    	if(con!=null)
	    	{
	    		con.close();
	    	}
	    	if(stmt!=null)
	    	{
	    		stmt.close();
	    	}
	    	if(rset!=null)
	    	{
	    		rset.close();
	    	}
    	}
    	catch(SQLException se)
    	{
    		System.out.println(se.getMessage());
    	}
    } 

    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String strFullName,strPwd;
		strFullName=request.getParameter("login__fullName");
		strPwd=request.getParameter("login__password");
		db.getDbcon();
		try 
		{
			stmt.setString(1, strFullName);
			stmt.setString(2, strPwd);
			System.out.println(strFullName);
			rset=stmt.executeQuery();
			if(rset.next())
			{
				HttpSession session=request.getSession();
				session.setAttribute("full_name", strFullName);
				response.sendRedirect(request.getContextPath()+"/WelcomePage.jsp");
			}
			else
			{
				response.sendRedirect(request.getContextPath()+"/ErrorPage");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}