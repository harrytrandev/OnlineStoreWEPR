<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zxx">

<head>
   <style>
   .quantity-style{
   text-align: center;
   min-width: 38px;
   max-width: 38px;
   }

   .quantity-wrapper{
   width: 38px;
   }
   </style>
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
   <link rel="stylesheet" href="${pageContext.request.contextPath}/web/assets/css/bootstrap.min.css" type="text/css">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/web/assets/css/font-awesome.min.css" type="text/css">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/web/assets/css/elegant-icons.css" type="text/css">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/web/assets/css/magnific-popup.css" type="text/css">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/web/assets/css/nice-select.css" type="text/css">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/web/assets/css/owl.carousel.min.css" type="text/css">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/web/assets/css/slicknav.min.css" type="text/css">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/web/assets/css/style.css" type="text/css">

   <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
   <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
   <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
   <link rel="stylesheet"
         href="https://cdnjs.cloudflare.com/ajax/libs/fontawesome/4.7.0/css/font-awesome.min.css">

</head>

<body>
<!-- Header Section Begin-->
<jsp:include page="header.jsp" />
<!-- Header Section End -->

<!-- Breadcrumb Section Begin -->
<section class="breadcrumb-option">
   <div class="container">
      <div class="row">
         <div class="col-lg-12">
            <div class="breadcrumb__text">
               <h4>Shopping Cart</h4>
               <div class="breadcrumb__links">
                  <a href="${pageContext.request.contextPath}/index.html">Home</a>
                  <a href="shop.jsp">Shop</a>
                  <span>Shopping Cart</span>
               </div>
            </div>
         </div>
      </div>
   </div>
</section>
<!-- Breadcrumb Section End -->

<!-- Shopping Cart Section Begin -->
<%--<div class="container">--%>
<div class="col-lg-8" style="    margin-left: auto;
    margin-right: auto; margin-top: 2rem;">
<c:if test="${not empty message}">
   <div class="alert alert-warning alert-dismissible fade show" role="alert">
      <strong>${message}</strong>
      <button type="button" class="close" data-dismiss="alert" aria-label="Close">
         <span aria-hidden="true">&times;</span>
      </button>
   </div>
</c:if>
</div>
<section class="shopping-cart spad">
   <div class="container">
      <div class="row">
         <div class="col-lg-8">
            <div class="shopping__cart__table">
               <table>
                  <thead>
                  <tr>
                     <th></th>
                     <th>Product</th>
                     <th>Quantity</th>
                     <th>Total</th>
                     <th></th>
                  </tr>
                  </thead>
                  <tbody>
                  <c:forEach items="${cartItems}" var="cartItems">
                     <tr data-cartitem-id="${cartItems.id}" data-product-id="${cartItems.product.id}" data-max-quantity="${cartItems.product.quantity}" data-price="${cartItems.product.price}" data-discount="${cartItems.product.discount}" data-quantity="${cartItems.quantity}">
                     <td><input type="checkbox" class="line-choose" id=""></td>
                     <td class="product__cart__item">
                        <div class="product__cart__item__pic">
                           <img width="105px" src="${cartItem.product.image}" alt="cartItemPicture">
                        </div>
                        <div class="product__cart__item__text">
                           <h6>${cartItems.product.name}</h6>
                           <h6>${cartItems.product.color} ${cartItems.product.size}</h6>
                           <c:if test="${cartItems.product.discount != 0}">
                              <span style="font-size: 18px; font-weight: 700;">${cartItems.product.discount}đ</span>
                              <span style="text-decoration: line-through; color: gray;">${cartItems.product.price}đ</span>
                           </c:if>
                           <c:if test="${cartItems.product.discount == 0}">
                              <h5>${cartItems.product.price}đ</h5>
                           </c:if>
<%--                           <h5>${cartItems.product.price}</h5>--%>
                        </div>
                     </td>

                     <td class="quantity__item">
                        <div class="quantity">
                           <div > <%--pro-qty-2--%>
                              <span  class="fa fa-angle-left dec qtybtn" onclick="decrement(${cartItems.id},${cartItems.quantity})" ></span>
                              <input class="line-quantity" value="${cartItems.quantity}" name="quantity" readonly style="width: 50px;border: none;text-align: center;color: #111111;font-size: 16px;">
                              <span class="fa fa-angle-right inc qtybtn" onclick="increment(${cartItems.id},${cartItems.quantity})"></span>
                           </div>
                        </div>
                     </td>
                     <td class="cart__price">${cartItems.product.discount == 0 ? cartItems.product.price * cartItems.quantity : cartItems.product.discount * cartItems.quantity} đ</td>
                     <td class="cart__close "><a onclick="deleteBtns(${cartItems.id})"><i class="fa fa-close"></i></a></td>
                  </tr>
                  </c:forEach>
                  </tbody>
               </table>
            </div>
            <div class="row">
               <div class="col-lg-6 col-md-6 col-sm-6">
                  <div class="continue__btn">
                     <a href="${pageContext.request.contextPath}/shop">Continue Shopping</a>
                  </div>
               </div>
            </div>
         </div>
         <div class="col-lg-4">
            <div class="cart__total h-100">
               <h6 class="font-weight-bold text-decoration-underline">Cart total</h6>
               <ul>
                  <li id="provisional">Provisional <span style="font-size: 16px;">0</span></li>
                  <li id="discount">Discount <span style="font-size: 14px; font-weight: 600; color: gray; text-decoration: line-through;">0</span></li>
                  <li id="total">Total <span>0</span></li>
               </ul>
               <form id="checkout" action="${pageContext.request.contextPath}/checkout" method="post">
                  <%--            <input type="hidden" name="data">--%>
                  <input type="submit" value="Proceed to checkout" class="primary-btn w-100">
               </form>
            </div>
         </div>
      </div>
   </div>
</section>
<!-- Shopping Cart Section End -->

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

<!-- Js Plugins -->
<script src="${pageContext.request.contextPath}/web/assets/js/jquery-3.3.1.min.js"></script>
<script src="${pageContext.request.contextPath}/web/assets/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/web/assets/js/jquery.nice-select.min.js"></script>
<script src="${pageContext.request.contextPath}/web/assets/js/jquery.nicescroll.min.js"></script>
<script src="${pageContext.request.contextPath}/web/assets/js/jquery.magnific-popup.min.js"></script>
<script src="${pageContext.request.contextPath}/web/assets/js/jquery.countdown.min.js"></script>
<script src="${pageContext.request.contextPath}/web/assets/js/jquery.slicknav.js"></script>
<script src="${pageContext.request.contextPath}/web/assets/js/mixitup.min.js"></script>
<script src="${pageContext.request.contextPath}/web/assets/js/owl.carousel.min.js"></script>
<script src="${pageContext.request.contextPath}/web/assets/js/main.js"></script>
<script src="${pageContext.request.contextPath}/web/assets/js/shopping-cart.js"></script>

<script>
<%--   <c:url value="${pageContext.request.contextPath}/cart/update?id=${cartItems.id}&quantity=${cartItems.quantity}" var="urlchange"/>--%>
<%--   <c:url value="${pageContext.request.contextPath}/cart/delete?id=${cartItems.id}" var="urlDelete"/>--%>
   function increment(id, quantity) {
      window.location.href = "${pageContext.request.contextPath}/cart/update?id="+id+"&quantity="+quantity+""+"&action=inc";
   }
   function decrement(id,quantity) {
      window.location.href = "${pageContext.request.contextPath}/cart/update?id="+id+"&quantity="+quantity+""+"&action=dec";
   }

   function  deleteBtns(id){
      if(confirm("Are you sure!") == true) {
         window.location.href = "${pageContext.request.contextPath}/cart/delete?id="+id;
      }
   }

   <%--const deleteBtns = document.querySelectorAll(".cart__close a")--%>
   <%--deleteBtns.forEach((button, id) => {--%>
   <%--   button.addEventListener('click', (ev) => {--%>
   <%--      ev.preventDefault()--%>
   <%--      if(confirm("Are you sure!") == true){--%>
   <%--         window.location.href = "${urlDelete}";--%>
   <%--      }--%>
   <%--   })--%>
   <%--})--%>
</script>
</body>

</html>
