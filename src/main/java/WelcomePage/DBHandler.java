package WelcomePage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import oracle.jdbc.pool.OracleDataSource;
public class DBHandler {


public Connection getDbcon()
{
Connection con=null;
try {
OracleDataSource ods=new OracleDataSource();
ods.setURL("jdbc:oracle:thin:@localhost:1521:xe");

con=ods.getConnection("lovish","lovish");
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}

return con;
}


public int getMaxId(String strTable,String strColumnName)
{
	int id=0;
	Connection con=getDbcon();
	
	try {
	PreparedStatement stmt=con.prepareStatement("select max("+ strColumnName +") as id from "+strTable);
	ResultSet rset=stmt.executeQuery();
	if(rset.next())
	{
		id=rset.getInt("id");
		id++;
		System.out.println(id);
	}
	else 
	{
		return id=0;
	}
	} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	System.out.println(id);
	return id;
}


public clsUsersData getUsersData(String strUserName)
{
	clsUsersData lst =new clsUsersData();
	Connection con=getDbcon();
	try 
	{
	PreparedStatement stmt=con.prepareStatement("select fullName,email,phoneNumber from users where fullName=?");
	stmt.setString(1, strUserName);
	ResultSet rset=stmt.executeQuery();
		
	while(rset.next())
		{
		String strEmail=rset.getString("email");
		String strPhoneNumber=rset.getString("phoneNumber");
		System.out.println(strEmail+" "+strPhoneNumber);
			 lst= new clsUsersData(strUserName,strEmail,strPhoneNumber);	
		}	
		 con.close();
	} catch (SQLException e) {e.printStackTrace();}

	return lst;
}
}