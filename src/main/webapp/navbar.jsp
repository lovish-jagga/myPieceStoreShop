
<%@page import="java.sql.Connection"%>
<%@page import="java.io.PrintWriter"%>
<nav class="navbar justify-content-between lineUp">
  <img class="logo-icon" src="./Image/brand__MyPieceStore.jpg" alt="logo">
  <a href="WelcomePage.jsp" class="logo-text">Home</a>
  <a href="Men.jsp" class="logo-text">Men</a>
  <a href="Women.jsp" class="logo-text">Women</a>
  <a href="Baby.jsp" class="logo-text">Baby's Collection</a>
  <a class="logo-text" href="#contacter">Contact</a>
<!--   <button><i style="font-size:24px" class="fa logo-text">&#xf002;</i></button> -->
<%
if (session.getAttribute("full_name") == null || session.getAttribute("full_name").equals(""))
{
%>
		<div>
   	<button type="button" id="signUp" class="logo-btn signUp" >
   	<i class="fa fa-user logo-text" aria-hidden="true"></i>
   	</button>
   	Signup
   	<span> | </span>
	<button type="button" id="logIn" class="logo-btn logIn">
	<i class="fa fa-sign-in logo-text"></i></button>
   	Login
   	</div>

<%	
} 
else
{
	String strUserName=session.getAttribute("full_name").toString();
	PrintWriter o=response.getWriter();
	out.println("hi,"+" "+strUserName);
	%>
		<div>
   	<button type="button" class="logo-btn" >
	<a href="Dashboard.jsp">   	<i class="fa fa-user logo-text" aria-hidden="true"></i></a>
   	</button>
	Dashboard
<!-- 	<button type="button" class="logo-btn "> -->
<!-- 	<i style='font-size:24px' class='fas'>&#xf2f6;</i></button> -->
<!-- 	Logout -->
	<button type="button" class="logo-btn">
	<a href="logout.jsp"><i class="fa fa-sign-in logo-text"></i></a></button>
   	Logout
   	</div>
	
	
	<%
}
%>
</nav>