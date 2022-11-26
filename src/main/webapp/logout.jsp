<%@include file="header.jsp" %>
</head>
<body>
<%
String strFullName="";
HttpSession se=request.getSession();
session.setAttribute("full_name", strFullName);
response.sendRedirect(request.getContextPath()+"/WelcomePage.jsp");
%>
<%@include file="Footer.jsp" %>