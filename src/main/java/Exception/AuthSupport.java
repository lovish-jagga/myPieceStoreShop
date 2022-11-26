package Exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AuthSupport 
{
	public static HttpSession CheckAuthenticity(HttpServletRequest request)throws AuthException
	{
		HttpSession session=request.getSession(false);
		if(session==null)
		{
			//invalid user
			throw new AuthException("PLZZZ LOGIN FIRST !!!!!!!!!!!");
		}
		return session;
	}
}
