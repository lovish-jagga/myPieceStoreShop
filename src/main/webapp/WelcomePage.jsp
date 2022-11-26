<%@include file="header.jsp" %>
</head>
<body>
<%@include file="navbar.jsp" %>
<div class="sale-section">
	Sale Up To 50% Biggest Discounts. <a href="Men.jsp" class="shopNow">Shop Now</a> Limited Offer!!
</div>

<%@include file="LoginModal.jsp" %>
<%@include file="SigninModal.jsp" %>
<div id="carouselExampleIndicators" class="carousel slide lineUp" data-ride="carousel">
  <ol class="carousel-indicators">
    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
  </ol>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img class="d-block w-100" src="./Image/carousel11.png" alt="First slide">
      <div class="firstCarousel">
      	<div class="firstCarousel__heading">
      		<li><h1 class="lineUp">Men's Fashion Sale</h1></li>
      		<li><h2 class="lineUp">People will stare. Make it worth their while.</h2></li>
      		<li><button class="lineUp">Shop Now</button></li>
      	</div>
      </div>
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="./Image/carousel2.png" alt="Second slide">
      <div class="secondCarousel">
      	<div class="secondCarousel__heading">
      		<li><h1 class="lineUp">Women's Fashion Sale</h1></li>
      		<li><h2 class="lineUp">Style is a way to say who you are without having to speak.</h2></li>
      		<li><button class="lineUp">Shop Now</button></li>
      	</div>
      </div>
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>   
</div>
  <div class="container lineUp">
      <div class="container__fashion">
      	<a href="Men.jsp" class="card1">
      		Men's collection
      	</a>
      	<a href="Women.jsp" class="card2">
      		Women's collection
      	</a>
      	<a href="Baby.jsp" class="card3">
      		Baby's collection      	
      	</a>
      </div>
  </div>
<%@include file="Contact.jsp" %>
<%@include file="Footer.jsp" %>









