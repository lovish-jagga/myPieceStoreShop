<%@page import="WelcomePage.clsUsersData"%>
<%@page import="WelcomePage.DBHandler"%>
<%@include file="header.jsp" %>
<link rel="stylesheet" href="./css/dashboard.css">
</head>
<body>
<%@include file="navbar.jsp" %>
<%@include file="LoginModal.jsp" %>
<%@include file="SigninModal.jsp" %>

<%
String strUserName=session.getAttribute("full_name").toString();
DBHandler db=new DBHandler();
clsUsersData obj=new clsUsersData();
obj=db.getUsersData(strUserName);
System.out.println(obj.getFullName());
String strEmail=obj.getEmail();
String strPhoneNumber=obj.getPhoneNumber();
%>

    <nav aria-label="breadcrumb">
        <ol class="breadcrumb py-2 sale-section lineUp">
            <li class="breadcrumb-item">
                <a href="WelcomePage.jsp">Home</a>
            </li>
            <li class="breadcrumb-item active" aria-current="page">
                Dashboard
            </li>
        </ol>
    </nav>

    <div class="my-profile page-container lineUp">
        <h1>My Profile</h1>
        <div class="row lineUp">
            <div class="col-md-3 profile-img-container">
                <i class="fa fa-user profile-img" style="font-size:150px; text-align:center;" aria-hidden="true"></i>
            </div class="lineUp">
            <div class="col-md-9">
                <div>
                    <div class="profile">
                        <div class="name"><%=session.getAttribute("full_name")%></div>
                        <div class="name"><%=strEmail%></div>
                        <div class="name"><%=strPhoneNumber%></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
<%@include file="Contact.jsp" %>
<%@include file="Footer.jsp" %>
    
