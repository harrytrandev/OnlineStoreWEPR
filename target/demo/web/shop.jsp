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
<!-- Header Section End -->

<!-- Breadcrumb Section Begin -->
<section class="breadcrumb-option">
   <div class="container">
      <div class="row">
         <div class="col-lg-12">
            <div class="breadcrumb__text">
               <h4>Shop</h4>
               <div class="breadcrumb__links">
                  <a href="./index.html">Home</a>
                  <span>Shop</span>
               </div>
            </div>
         </div>
      </div>
   </div>
</section>
<!-- Breadcrumb Section End -->

<!-- Shop Section Begin -->
<section class="shop spad">
   <div class="container">
      <div class="row">
         <%--<div class="col-lg-3">
            <div class="shop__sidebar">
               <div class="shop__sidebar__search">
                  <form action="" method="get">
                     <input name="txtSearch" type="text" placeholder="Search...">
                     <button type="submit"><span class="icon_search"></span></button>
                  </form>
               </div>
               <div class="shop__sidebar__accordion">
                  <div class="accordion" id="accordionExample">
                     <div class="card">
                        <div class="card-heading">
                           <a data-toggle="collapse" data-target="#collapseOne">Categories</a>
                        </div>
                        <div id="collapseOne" class="collapse show" data-parent="#accordionExample">
                           <div class="card-body">
                              <div class="shop__sidebar__categories">
                                 <ul class="nice-scroll">
                                    <c:forEach items="${categories}" var="c">
                                       <li><a href="?CategoryID=${c.id}">${c.name}</a></li>
                                    </c:forEach>
                                 </ul>
                              </div>
                           </div>
                        </div>
                     </div>
                     <div class="card">
                        <div class="card-heading">
                           <a data-toggle="collapse" data-target="#collapseTwo">Branding</a>
                        </div>
                        <div id="collapseTwo" class="collapse show" data-parent="#accordionExample">
                           <div class="card-body">
                              <div class="shop__sidebar__brand">
                                 <ul>
                                    <c:forEach items="${brands}" var="b">
                                       <li><a href="?brand=${b}">${b}</a></li>
                                    </c:forEach>
                                 </ul>
                              </div>
                           </div>
                        </div>
                     </div>
                     <div class="card">
                        <div class="card-heading">
                           <a data-toggle="collapse" data-target="#collapseThree">Filter Price</a>
                        </div>
                        <div id="collapseThree" class="collapse show" data-parent="#accordionExample">
                           <div class="card-body">
                              <div class="shop__sidebar__price">
                                 <ul>
                                    <li><a href="#">$0.00 - $50.00</a></li>
                                    <li><a href="#">$50.00 - $100.00</a></li>
                                    <li><a href="#">$100.00 - $150.00</a></li>
                                    <li><a href="#">$150.00 - $200.00</a></li>
                                    <li><a href="#">$200.00 - $250.00</a></li>
                                    <li><a href="#">250.00+</a></li>
                                 </ul>
                              </div>
                           </div>
                        </div>
                     </div>
                     <div class="card">
                        <div class="card-heading">
                           <a data-toggle="collapse" data-target="#collapseFour">Size</a>
                        </div>
                        <div id="collapseFour" class="collapse show" data-parent="#accordionExample">
                           <div class="card-body">
                              <div class="shop__sidebar__size">
                                 <c:forEach items="${sizes}" var="s">
                                    <label for="${s}">${s}
                                       <input type="radio" id="${s}">
                                    </label>
                                 </c:forEach>
                              </div>
                           </div>
                        </div>
                     </div>
                     <div class="card">
                        <div class="card-heading">
                           <a data-toggle="collapse" data-target="#collapseFive">Colors</a>
                        </div>
                        <div id="collapseFive" class="collapse show" data-parent="#accordionExample">
                           <div class="card-body">
                              <div class="shop__sidebar__color">
                                 <label class="c-1" for="sp-1">
                                    <input type="radio" id="sp-1">
                                 </label>
                                 <label class="c-2" for="sp-2">
                                    <input type="radio" id="sp-2">
                                 </label>
                                 <label class="c-3" for="sp-3">
                                    <input type="radio" id="sp-3">
                                 </label>
                                 <label class="c-4" for="sp-4">
                                    <input type="radio" id="sp-4">
                                 </label>
                                 <label class="c-5" for="sp-5">
                                    <input type="radio" id="sp-5">
                                 </label>
                                 <label class="c-6" for="sp-6">
                                    <input type="radio" id="sp-6">
                                 </label>
                                 <label class="c-7" for="sp-7">
                                    <input type="radio" id="sp-7">
                                 </label>
                                 <label class="c-8" for="sp-8">
                                    <input type="radio" id="sp-8">
                                 </label>
                                 <label class="c-9" for="sp-9">
                                    <input type="radio" id="sp-9">
                                 </label>
                              </div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </div>--%>
         <div class="col-lg-3">
               <div class="shop__sidebar">
                  <div class="shop__sidebar__search">
                     <form action="" method="get">
                        <input name="txtSearch" type="text" placeholder="Search...">
                        <button type="submit"><span class="icon_search"></span></button>
                     </form>
                  </div>
                  <div class="shop__sidebar__accordion">
                     <div class="accordion" id="accordionExample">
                        <form action="">
                           <div class="card">
                              <div class="card-heading">
                                 <a data-toggle="collapse" data-target="#collapseThree">Filter Price</a>
                              </div>
                              <div id="collapsezero" class="collapse show" data-parent="#accordionExample">
                                 <div class="card-body">
                                    <div class="shop__sidebar__price">
                                       <ul>
                                          <input type="radio" id="Sprice1" name="sortPrice" value="1">
                                          <label for="Sprice1">Thấp đến cao</label><br>
                                          <input type="radio" id="Sprice2" name="sortPrice" value="2">
                                          <label for="Sprice2">Cao đến thấp</label><br>

                                       </ul>
                                    </div>
                                 </div>
                              </div>
                           </div>
                           <div class="card">
                              <div class="card-heading">
                                 <a data-toggle="collapse" data-target="#collapseOne">Categories</a>
                              </div>
                              <div id="collapseOne" class="collapse show" data-parent="#accordionExample">
                                 <div class="card-body">
                                    <div class="shop__sidebar__categories">
                                       <ul class="nice-scroll">
                                          <c:forEach items="${categories}" var="c">
                                             <input type="radio" id="category" name="CategoryID" value="${c.id}">
                                             <label for="category"> ${c.name}</label><br>
                                             <%--<li><a href="?CategoryID=${c.id}">${c.name}</a></li>--%>
                                          </c:forEach>
                                       </ul>
                                    </div>
                                 </div>
                              </div>
                           </div>
                           <div class="card">
                              <div class="card-heading">
                                 <a data-toggle="collapse" data-target="#collapseTwo">Branding</a>
                              </div>
                              <div id="collapseTwo" class="collapse show" data-parent="#accordionExample">
                                 <div class="card-body">
                                    <div class="shop__sidebar__brand">
                                       <ul>
                                          <c:forEach items="${brands}" var="b">
                                             <input type="radio" id="brand" name="brand" value="${b}">
                                             <label for="brand"> ${b}</label><br>
                                          </c:forEach>
                                       </ul>
                                    </div>
                                 </div>
                              </div>
                           </div>
                           <div class="card">
                              <div class="card-heading">
                                 <a data-toggle="collapse" data-target="#collapseThree">Filter Price</a>
                              </div>
                              <div id="collapseThree" class="collapse show" data-parent="#accordionExample">
                                 <div class="card-body">
                                    <div class="shop__sidebar__price">
                                       <ul>
                                          <input type="radio" id="price1" name="price" value="1">
                                          <label for="price1">$0.00 - $100.00</label><br>
                                          <input type="radio" id="price2" name="price" value="2">
                                          <label for="price2">$100.00 - $200.00</label><br>
                                          <input type="radio" id="price3" name="price" value="3">
                                          <label for="price3">$200.00 - ...</label><br>
                                       </ul>
                                    </div>
                                 </div>
                              </div>
                           </div>
                           <div class="card">
                              <div class="card-heading">
                                 <a data-toggle="collapse" data-target="#collapseFour">Size</a>
                              </div>
                              <div id="collapseFour" class="collapse show" data-parent="#accordionExample">
                                 <div class="card-body">
                                    <div class="shop__sidebar__size">
                                       <c:forEach items="${sizes}" var="s">
                                          <label for="${s}">${s}
                                             <input type="radio" id="${s}" name="size" value="${s}">
                                          </label>
                                       </c:forEach>
                                    </div>
                                 </div>
                              </div>
                           </div>
                           <div class="card">
                              <div class="card-heading">
                                 <a data-toggle="collapse" data-target="#collapseFive">Colors</a>
                              </div>
                              <div id="collapseFive" class="collapse show" data-parent="#accordionExample">
                                 <div class="card-body">
                                    <div class="shop__sidebar__color">
                                       <c:forEach items="${colors}" var="c">
                                          <label class="${c}">
                                             <input type="radio" name="colors" value="${c}">
                                          </label>
                                       </c:forEach>
                                       <%--<label class="c-1" for="sp-1">
                                          <input type="radio" id="sp-1">
                                       </label>
                                       <label class="c-2" for="sp-2">
                                          <input type="radio" id="sp-2">
                                       </label>
                                       <label class="c-3" for="sp-3">
                                          <input type="radio" id="sp-3">
                                       </label>
                                       <label class="c-4" for="sp-4">
                                          <input type="radio" id="sp-4">
                                       </label>
                                       <label class="c-5" for="sp-5">
                                          <input type="radio" id="sp-5">
                                       </label>
                                       <label class="c-6" for="sp-6">
                                          <input type="radio" id="sp-6">
                                       </label>
                                       <label class="c-7" for="sp-7">
                                          <input type="radio" id="sp-7">
                                       </label>
                                       <label class="c-8" for="sp-8">
                                          <input type="radio" id="sp-8">
                                       </label>
                                       <label class="c-9" for="sp-9">
                                          <input type="radio" id="sp-9">
                                       </label>--%>
                                    </div>
                                 </div>
                              </div>
                           </div>
                           <input type="submit" value="Submit">
                        </form>
                     </div>
                  </div>
               </div>
            </div>
         <div class="col-lg-9">
            <div class="shop__product__option">
               <div class="row">
                  <div class="col-lg-6 col-md-6 col-sm-6">
                     <div class="shop__product__option__left">
                        <p>Showing 1–12 of 126 results</p>
                     </div>
                  </div>
                  <%--<div class="col-lg-6 col-md-6 col-sm-6">
                     <div class="shop__product__option__right">
                        <p>Sort by Price:</p>
                        <select>
                           <option value="">Low To High</option>
                           <option value="">$0 - $55</option>
                           <option value="">$55 - $100</option>
                        </select>
                     </div>
                  </div>--%>
               </div>
            </div>
            <div class="row">
               <c:forEach items="${products}" var="l">
                  <div class="col-lg-4 col-md-6 col-sm-6">
                     <div class="product__item">
                        <div class="product__item__pic set-bg" <%--data-setbg="${l.image}"--%>>
                            <a href="shop-details?id=${l.id}&CategoryID=${l.category.id}">
                                <img src="${l.image}" alt="">
                            </a>
                           <%--<ul class="product__hover">
                              <li><a href="#"><img src="./assets/img/icon/heart.png" alt=""></a></li>
                              <li><a href="#"><img src="./assets/img/icon/compare.png" alt=""> <span>Compare</span></a>
                              </li>
                              <li><a href="#"><img src="./assets/img/icon/search.png" alt=""></a></li>
                           </ul>--%>
                        </div>
                        <div class="product__item__text">
                           <h6>${l.name}</h6>
                           <a href="#" class="add-cart">+ Add To Cart</a>
                           <div class="rating">
                              <i class="fa fa-star-o"></i>
                              <i class="fa fa-star-o"></i>
                              <i class="fa fa-star-o"></i>
                              <i class="fa fa-star-o"></i>
                              <i class="fa fa-star-o"></i>
                           </div>
                           <h5>${l.price}</h5>
                        </div>
                     </div>
                  </div>
               </c:forEach>

            </div>
            <div class="row">
               <div class="col-lg-12">
                  <div class="product__pagination">
                     <c:forEach begin="${1}" end="${numberPage}" var="i">
                        <a ${i == page?'class="active"':""} href="<%=request.getContextPath()%>/ViewProductController?price=${1}&txtSearch=${txtSearch}&categoryID=${categoryID}&sort=${sort}&page=${i}">${i}</a>
                     </c:forEach>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </div>
</section>
<!-- Shop Section End -->

<!-- Footer Section Begin -->
<jsp:include page="footer.jsp" />
<!-- Footer Section End -->

<!-- Search Begin -->
<div class="search-model">
   <div class="h-100 d-flex align-items-center justify-content-center">
      <div class="search-close-switch">+</div>
      <form class="search-model-form">
         <input type="text" name="txtSearch" id="search-input" placeholder="Search here.....">
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