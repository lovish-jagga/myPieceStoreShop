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
@WebServlet("/WelcomePage")
public class WelcomePage extends HttpServlet {
    PreparedStatement stmt=null;
    Connection con=null;
    ResultSet rset=null;
	public WelcomePage() {
    }
	public void init(ServletConfig config)throws ServletException
	{
		super.init(config);
		ServletContext context=getServletContext();
		con=(Connection) context.getAttribute("gCon");
		try {
			stmt=con.prepareStatement("Select * from category");
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		try {
			AuthSupport.CheckAuthenticity(request);
			out.println("<html><head><title>LJROCKS Messages</title></head><body>");
			HttpSession session=request.getSession(false);
			String strUnm=(String) session.getAttribute("unm");
			out.println("Welcome page<b>"+strUnm+"</b>");
			out.println("<br><table border='1'>");
			out.println("<tr>");
			out.println("<th>catid</th>");
			out.println("<th>catname</th>");
			out.println("<th>catdesc</th>");
			out.println("<th>catimgurl</th>");
			out.println("<th>catimgurl</th>");
			out.println("</tr>");
			rset=stmt.executeQuery();
			while(rset.next())
			{
//				Name           Null     Type         
//				-------------- -------- ------------ 
//				CATAGORYID     NOT NULL VARCHAR2(20) 
//				CATAGORYNAME            VARCHAR2(20) 
//				CATAGORYDESC            VARCHAR2(50) 
//				CATOGORYIMGURL          VARCHAR2(50) 

				String strCatid=rset.getString("CATAGORYID");
				String strCatname=rset.getString("CATAGORYNAME");
				String strCatdesc=rset.getString("CATAGORYDESC");
				String strCatImgurl=rset.getString("CATOGORYIMGURL");
				out.println("<tr>");
				out.println("<td>"+strCatid+"</td>");
				out.println("<td><a href='Products?categoryid="+strCatid+"'>"+strCatname+"</a></td>");
				out.println("<td>"+strCatdesc+"</td>");
				out.println("<th>"+strCatImgurl+"</th>");
				out.println("<th><img src='Image/"+strCatImgurl+"'width=200px; height=200px;/></th>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</body></html>");
		}
		catch (AuthException e) 
		{
		out.println("<html><head><title>Error page </title></head><body>");
		out.println("<a href=NewFile.html>"+e.getMessage()+"</a>");
		out.println("</body></html>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			out.println("<html><head><title>Error page </title></head><body>");
			out.println("<a href=NewFile.html>"+"something went wrong plzz try again later"+"</a>");
			out.println("</body></html>");
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	}
}
