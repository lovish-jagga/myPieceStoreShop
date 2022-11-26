package Auth;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import WelcomePage.DBHandler;

@WebServlet("/newUser")
public class newUser extends HttpServlet {
    DBHandler db=new DBHandler();
	PreparedStatement stmt=null;
	Connection con;
	ResultSet rset=null;
    public newUser() {
    }
    public void init(ServletConfig config)throws ServletException
    {
    	super.init(config);
    	ServletContext context=getServletContext();
    	con=db.getDbcon();
    	context.setAttribute("gCon", con);
    	try {
			stmt=con.prepareStatement("Insert into users values(?,?,?,?,?)");
		} catch (Exception e) {

			e.printStackTrace();
		}
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int strUserId;
		String strFullName,strEmail,strPhoneNumber,strCreatePassword;
		String strtable="users",strusersid="usersid";
		strUserId=db.getMaxId(strtable,strusersid);
		if(strUserId==0)
		{
			response.sendRedirect(request.getContextPath()+"/ErrorPage");
		}
		strFullName=request.getParameter("full_name");
		strEmail=request.getParameter("email");
		strPhoneNumber=request.getParameter("phoneNumber");
		strCreatePassword=request.getParameter("createPassword");
		con=db.getDbcon();
		try 
		{
			stmt.setInt(1, strUserId);
			stmt.setString(2, strFullName);
			stmt.setString(3, strEmail);
			stmt.setString(4, strPhoneNumber);
			stmt.setString(5, strCreatePassword);
			rset=stmt.executeQuery();
			if(rset.next())
			{
				HttpSession session=request.getSession();
				session.setAttribute("name", strFullName);
				response.sendRedirect(request.getContextPath()+"/WelcomePage.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
