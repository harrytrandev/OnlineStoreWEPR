<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
   <meta charset="UTF-8">
   <meta name="description" content="Male_Fashion Template">
   <meta name="keywords" content="Male_Fashion, unica, creative, html">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <meta http-equiv="X-UA-Compatible" content="ie=edge">
   <title>Male-Fashion | Template</title>

   <!-- Google Font -->
   <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;400;600;700;800;900&display=swap"
         rel="stylesheet">

   <!-- Css Styles -->
   <link rel="stylesheet" href="./assets/css/bootstrap.min.css" type="text/css">
   <link rel="stylesheet" href="./assets/css/font-awesome.min.css" type="text/css">
   <link rel="stylesheet" href="./assets/css/elegant-icons.css" type="text/css">
   <link rel="stylesheet" href="./assets/css/magnific-popup.css" type="text/css">
   <link rel="stylesheet" href="./assets/css/nice-select.css" type="text/css">
   <link rel="stylesheet" href="./assets/css/owl.carousel.min.css" type="text/css">
   <link rel="stylesheet" href="./assets/css/slicknav.min.css" type="text/css">
   <link rel="stylesheet" href="./assets/css/style.css" type="text/css">
</head>

<body>
<!-- Header Section Begin-->
<jsp:include page="header.jsp" />
<c:set var="p" value="${product}"/>
<!-- Header Section End -->

<!-- Shop Details Section Begin -->
<section class="shop-details">
   <div class="product__details__pic">
      <div class="container">
         <div class="row">
            <div class="col-lg-12">
               <div class="product__details__breadcrumb">
                  <a href="./index.html">Home</a>
                  <a href="shop.jsp">Shop</a>
                  <span>Product Details</span>
               </div>
            </div>
         </div>
         <div class="row" style="justify-content: center;">
            <div class="col-lg-6 col-md-9">
               <div class="tab-content">
                  <div class="tab-pane active" id="tabs-1" role="tabpanel">
                     <div class="product__details__pic__item">
                        <img src="${p.image}" alt="">
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </div>
   <div class="product__details__content">
      <div class="container">
         <div class="row d-flex justify-content-center">
            <div class="col-lg-8">
               <form action="${pageContext.request.contextPath}/web/buy" method="post">
                  <div class="product__details__text">
                     <input name="ProductId" value="${p.id}" hidden>
                     <h4>${p.name}</h4>
                     <h3>${p.price-p.discount} <span>${p.price}</span></h3>
                     <div class="product__details__option">
                        <div class="product__details__option__size">
                           <span>Size:</span>
                           <label for="${p.size}">${p.size}
                              <input type="radio" id="${p.size}">
                           </label>

                        </div>
                        <div class="product__details__option__color">
                           <span>Color: ${p.color}</span>
                        </div>
                     </div>
                     <div class="product__details__cart__option">
                        <div class="quantity">
                           <div class="pro-qty">
                              <input name="quantity" type="text" value="1">
                           </div>
                        </div>
                        <button type="submit" class="primary-btn">add to cart</button>
                     </div>
                  </div>
               </form>
            </div>
         </div>
         <div class="row">
            <div class="col-lg-12">
               <div class="product__details__tab">
                  <ul class="nav nav-tabs" role="tablist">
                     <li class="nav-item">
                        <a class="nav-link active" data-toggle="tab" href="#tabs-5"
                           role="tab">Description</a>
                     </li>
                  </ul>
                  <div class="tab-content">
                     <div class="tab-pane active" id="tabs-5" role="tabpanel">
                        ${p.description}
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </div>
</section>
<!-- Shop Details Section End -->

<!-- Related Section Begin -->
<section class="related spad">
   <div class="container">
      <div class="row">
         <div class="col-lg-12">
            <h3 class="related-title">Related Product</h3>
         </div>
      </div>
      <div class="row">
         <c:forEach items="${products}" var="p">
            <div class="col-lg-3 col-md-6 col-sm-6 col-sm-6">
               <div class="product__item">
                  <div class="product__item__pic set-bg" <%--data-setbg="${l.image}"--%>>
                     <a href="shop-details?id=${p.id}&CategoryID=${p.category.id}">
                        <img src="${p.image}" alt="">
                     </a>
                  </div>
                  <div class="product__item__text">
                     <h6>${p.name}</h6>
                     <a href="shop-details?id=${p.id}&CategoryID=${p.category.id}" class="add-cart">View Product Detail</a>
                     <h5>${p.price}</h5>
                  </div>
               </div>
            </div>
         </c:forEach>
      </div>
   </div>
</section>
<!-- Related Section End -->

<!-- Footer Section Begin -->
<jsp:include page="footer.jsp" />
<!-- Footer Section End -->

<!-- Search Begin -->
<div class="search-model">
   <div class="h-100 d-flex align-items-center justify-content-center">
      <div class="search-close-switch">+</div>
      <form class="search-model-form">
         <input type="text" id="search-input" placeholder="Search here.....">
      </form>
   </div>
</div>
<!-- Search End -->

<!-- Active menu -->
<script>
    document.getElementById('menu-shop').classList.add('active')
</script>

<!-- Js Plugins -->
<script src="./assets/js/jquery-3.3.1.min.js"></script>
<script src="./assets/js/bootstrap.min.js"></script>
<script src="./assets/js/jquery.nice-select.min.js"></script>
<script src="./assets/js/jquery.nicescroll.min.js"></script>
<script src="./assets/js/jquery.magnific-popup.min.js"></script>
<script src="./assets/js/jquery.countdown.min.js"></script>
<script src="./assets/js/jquery.slicknav.js"></script>
<script src="./assets/js/mixitup.min.js"></script>
<script src="./assets/js/owl.carousel.min.js"></script>
<script src="./assets/js/main.js"></script>
</body>

</html>