<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="zxx">

<head>
  <meta charset="UTF-8">
  <meta name="description" content="Male_Fashion Template">
  <meta name="keywords" content="Male_Fashion, unica, creative, html">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Information</title>

  <!-- Google Font -->
  <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;400;600;700;800;900&display=swap" rel="stylesheet">

  <!-- Css Styles -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/web/assets/css/bootstrap.min.css"
        type="text/css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/web/assets/css/font-awesome.min.css"
        type="text/css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/web/assets/css/elegant-icons.css"
        type="text/css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/web/assets/css/magnific-popup.css"
        type="text/css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/web/assets/css/nice-select.css"
        type="text/css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/web/assets/css/owl.carousel.min.css"
        type="text/css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/web/assets/css/slicknav.min.css"
        type="text/css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/web/assets/css/style.css" type="text/css">

  <link rel="stylesheet" href="${pageContext.request.contextPath}/web/assets/css/core.css" type="text/css">
  <style>
     .linkA:hover {
        color: red;
     }

     .details {
        display: none;
     }

     .btn-arrow:hover {
        cursor: pointer;
        color: blue;
     }
  </style>
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
          <h4>Personal information, orders</h4>
          <div class="breadcrumb__links">
            <a href="index.jsp">Home</a>
            <span>Personal information, orders</span>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
<!-- Breadcrumb Section End -->

<!-- Contact Section Begin -->
<div class="container">
<<<<<<< HEAD
<<<<<<< HEAD
        <div class="spad">
            <div class="row">
                <div class="col-md-4 mb-3">
                    <div class="card">
                        <div class="card-body">
                            <div class="d-flex flex-column align-items-center text-center" id="profile-head">
                                <c:choose>
                                    <c:when test="${userLogged.image!=null}"><img alt="Image Profile" src="./${userLogged.image}" class="rounded-circle" width="150"></c:when>
                                    <c:otherwise><img src="assets/img/profile/no-avartar.png" alt="Admin" class="rounded-circle" width="150"></c:otherwise>
                                </c:choose>
                                <div class="mt-3">
                                    <h4>${userLogged.name}</h4>
                                    <p class="text-muted font-size-sm">${userLogged.address}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-8">
                    <div class="card mb-3 user-profile">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Full name</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">${userLogged.name}</div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Phone number</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    ${userLogged.phone}
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Email</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    ${userLogged.email}
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Gender</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    ${userLogged.gender}
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-sm-3">
                                    <h6 class="mb-0">Address</h6>
                                </div>
                                <div class="col-sm-9 text-secondary">
                                    ${userLogged.address}
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <div class="col-sm-6">
                                    <a class="btn btn-info" target="" href="${pageContext.request.contextPath}/web/update-profile">Edit Profile</a>
                                </div>
                                <div class="col-sm-6">
                                    <a class="btn btn-info" target="" href="${pageContext.request.contextPath}/web/change-password">Change password</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!--  Hi???n th??? ????n h??ng ???? mua -->
            <div class="row">
                <div class="container mt-5">
                    <div class="d-flex justify-content-center row">
                        <div class="col-md-10">
                            <div class="card">
                                <h5 class="card-header">T???t c??? ????n h??ng</h5>
                                <div class="table-responsive table-borderless">
                                    <table class="table">
                                        <thead>
                                        <tr>
                                            <th>T??n ng?????i nh???n</th>
                                            <th>?????a ch???</th>
                                            <th>Tr???ng th??i</th>
                                            <th>Th??nh ti???n</th>
                                            <th>Ng??y ?????t h??ng</th>
                                            <th></th>
                                            <th></th>
                                            <th></th>
                                        </tr>
                                        </thead>
                                        <tbody class="table-body">
                                        <c:forEach var="order"
                                                   items="${orderDAO.getOrderByUser(userLogged)}">
                                        <tr class="cell-1">
                                            <td>${order.name}</td>
                                            <td>${order.address}</td>
                                            <td><c:choose>
                                                <c:when
                                                        test="${order.status =='???? h???y ????n'}">
																<span class="badge bg-label-success me-1"
                                                                      style="color: #ed1c24 !important;">???? h???y ????n</span>
                                                </c:when>
                                                <c:when
                                                        test="${order.status =='???? x??c nh???n'}">
																<span class="badge bg-label-success me-1"
                                                                      style="color: orange !important;"> ???? giao cho ????n
																	v??? v???n chuy???n </span>
                                                </c:when>
                                                <c:when
                                                        test="${order.status =='??ang giao h??ng'}">
																<span class="badge bg-label-success me-1"
                                                                      style="color: sandybrown !important;">??ang giao h??ng</span>
                                                </c:when>
                                                <c:when test="${order.status =='Giao h??ng th??nh c??ng'}">
                                                    <span class="badge bg-label-success me-1">???? nh???n h??ng</span>
                                                </c:when>
                                                <c:when test="${order.status =='Giao h??ng kh??ng th??nh c??ng'}">
																<span class="badge bg-label-success me-1"
                                                                      style="color: red !important;text-decoration-line: line-through;">Giao h??ng kh??ng th??nh c??ng</span>
                                                </c:when>
                                                <c:otherwise>
																<span class="badge bg-label-success me-1"
                                                                      style="color: orange !important;">Ch??? x??c nh???n</span>
                                                </c:otherwise>
                                            </c:choose></td>
                                            <c:choose>
                                                <c:when test="${order.total == 0}">
                                                    <td>Ch??a thanh to??n!</td>
                                                </c:when>
                                                <c:otherwise>
                                                    <td>${order.total}</td>
                                                </c:otherwise>
                                            </c:choose>
                                            <td>${order.created}</td>
                                            <td><c:choose>
                                                <c:when test="${order.status ==''}">
                                                <a href="${pageContext.request.contextPath}/web/cancelOrder?orderId=${order.id}"
                                                   class="linkA">H???y ????n h??ng</a></td>
                                            </c:when>  </c:choose>
                                            <td><i class="btn-arrow arrow_triangle-down_alt2"
                                                   onclick="show(${order.id})" style="font-size: 20px;"></i></td>
                                            <td><i class="btn-arrow arrow_triangle-up_alt2"
                                                   onclick="hide(${order.id})" style="font-size: 20px;"></i></td>
                                        </tr>

                                            <%--											<div type="table" class="table" id="${order.id}">--%>
                                            <%--												<table class="table details" ">--%>
                                        <tr >
                                        <thead id="${order.id}" class="details">
                                        <tr>
                                            <th></th>
                                            <th>S???n ph???m</th>
                                            <th>Gi??</th>
                                            <th>S??? l?????ng</th>
                                            <th>T???ng ti???n</th>
                                        </tr>
                                        </thead>

                                        <tbody class="table-body details" id="body-${order.id}">
                                        <c:forEach items="${ItemDAO.getAllItemsByOrderId(order)}"
                                                   var="item">
                                            <tr>
                                                <c:set var="product" scope="session"
                                                       value="${productDAO.getProductsByOrderItem(item.product)}" />
                                                <td><img alt=""
                                                         src="<c:out value="${product.image}"/>"
                                                         style="width: 50px;"></td>
                                                <td style="width: 210px"><c:out
                                                        value="${product.name}" /></td>
                                                <td><c:out value="${product.price}" /></td>
                                                <td>${item.quantity}</td>
                                                <td>${item.price*item.quantity}</td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                            <%--												</table>--%>
                                            <%--												</div>--%>
                                        </tr>
                                        </c:forEach>
                                        </tbody>

                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
=======
=======
>>>>>>> c00c268839d42f556c7ca13dc9fbabaf8d2a42f7
  <div class="spad">
    <div class="row">
      <div class="col-md-4 mb-3">
        <div class="card">
          <div class="card-body">
            <div class="d-flex flex-column align-items-center text-center" id="profile-head">
              <c:choose>
                <c:when test="${user.image != null}">
                  <img alt="Image Profile" src="${pageContext.request.contextPath}/${user.image}" class="rounded-circle" style="width: 150px; height: 150px;">
                </c:when>
                <c:otherwise><img src="${pageContext.request.contextPath}/web/assets/img/profile/no-avartar.png" alt="Admin" class="rounded-circle" width="150"></c:otherwise>
              </c:choose>
              <div class="mt-3">
                <h4>${userLogged.name}</h4>
                <p class="text-muted font-size-sm">${userLogged.address}</p>
              </div>
<<<<<<< HEAD
>>>>>>> c00c268839d42f556c7ca13dc9fbabaf8d2a42f7
=======
>>>>>>> c00c268839d42f556c7ca13dc9fbabaf8d2a42f7
            </div>
          </div>
        </div>
      </div>
      <div class="col-md-8">
        <div class="card mb-3 user-profile">
          <div class="card-body">
            <div class="row">
              <div class="col-sm-3">
                <h6 class="mb-0">Full name</h6>
              </div>
              <div class="col-sm-9 text-secondary">${userLogged.name}</div>
            </div>
            <hr>
            <div class="row">
              <div class="col-sm-3">
                <h6 class="mb-0">Phone number</h6>
              </div>
              <div class="col-sm-9 text-secondary">
                ${userLogged.phone}
              </div>
            </div>
            <hr>
            <div class="row">
              <div class="col-sm-3">
                <h6 class="mb-0">Email</h6>
              </div>
              <div class="col-sm-9 text-secondary">
                ${userLogged.email}
              </div>
            </div>
            <hr>
            <div class="row">
              <div class="col-sm-3">
                <h6 class="mb-0">Gender</h6>
              </div>
              <div class="col-sm-9 text-secondary">
                ${userLogged.gender}
              </div>
            </div>
            <hr>
            <div class="row">
              <div class="col-sm-3">
                <h6 class="mb-0">Address</h6>
              </div>
              <div class="col-sm-9 text-secondary">
                ${userLogged.address}
              </div>
            </div>
            <hr>
            <div class="row">
              <div class="col-sm-6">
                <a class="btn btn-info" target="" href="update-profile">Edit Profile</a>
              </div>
              <div class="col-sm-6">
                <a class="btn btn-info" target="" href="change-password">Change password</a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!--  Hi???n th??? ????n h??ng ???? mua -->
    <div class="row">
      <div class="container mt-5">
        <div class="d-flex justify-content-center row">
          <div class="col-md-10">
            <div class="card">
              <h5 class="card-header">T???t c??? ????n h??ng</h5>
              <div class="table-responsive table-borderless">
                <table class="table">
                  <thead>
                  <tr>
                    <th>T??n ng?????i nh???n</th>
                    <th>?????a ch???</th>
                    <th>Tr???ng th??i</th>
                    <th>Th??nh ti???n</th>
                    <th>Ng??y ?????t h??ng</th>
                    <th></th>
                    <th></th>
                    <th></th>
                  </tr>
                  </thead>
                  <tbody class="table-body">
                  <c:forEach var="order"
                             items="${orderDAO.getOrderByUser(userLogged)}">
                  <tr class="cell-1">
                    <td>${order.name}</td>
                    <td>${order.address}</td>
                    <td><c:choose>
                      <c:when
                          test="${order.status =='???? h???y ????n'}">
																<span class="badge bg-label-success me-1"
                                      style="color: #ed1c24 !important;">???? h???y ????n</span>
                      </c:when>
                      <c:when
                          test="${order.status =='???? x??c nh???n'}">
																<span class="badge bg-label-success me-1"
                                      style="color: orange !important;"> ???? giao cho ????n
																	v??? v???n chuy???n </span>
                      </c:when>
                      <c:when
                          test="${order.status =='??ang giao h??ng'}">
																<span class="badge bg-label-success me-1"
                                      style="color: sandybrown !important;">??ang giao h??ng</span>
                      </c:when>
                      <c:when test="${order.status =='Giao h??ng th??nh c??ng'}">
                        <span class="badge bg-label-success me-1">???? nh???n h??ng</span>
                      </c:when>
                      <c:when test="${order.status =='Giao h??ng kh??ng th??nh c??ng'}">
																<span class="badge bg-label-success me-1"
                                      style="color: red !important;text-decoration-line: line-through;">Giao h??ng kh??ng th??nh c??ng</span>
                      </c:when>
                      <c:otherwise>
																<span class="badge bg-label-success me-1"
                                      style="color: orange !important;">Ch??? x??c nh???n</span>
                      </c:otherwise>
                    </c:choose></td>
                    <c:choose>
                      <c:when test="${order.total == 0}">
                        <td>Ch??a thanh to??n!</td>
                      </c:when>
                      <c:otherwise>
                        <td>${order.total}</td>
                      </c:otherwise>
                    </c:choose>
                    <td>${order.created}</td>
                    <td><c:choose>
                      <c:when test="${order.status ==''}">
                      <a href="${pageContext.request.contextPath}/web/cancelOrder?orderId=${order.id}"
                         class="linkA">H???y ????n h??ng</a></td>
                    </c:when>  </c:choose>
                    <td><i class="btn-arrow arrow_triangle-down_alt2"
                           onclick="show(${order.id})" style="font-size: 20px;"></i></td>
                    <td><i class="btn-arrow arrow_triangle-up_alt2"
                           onclick="hide(${order.id})" style="font-size: 20px;"></i></td>
                  </tr>

                    <%--											<div type="table" class="table" id="${order.id}">--%>
                    <%--												<table class="table details" ">--%>
                  <tr >
                  <thead id="${order.id}" class="details">
                  <tr>
                    <th></th>
                    <th>S???n ph???m</th>
                    <th>Gi??</th>
                    <th>S??? l?????ng</th>
                    <th>T???ng ti???n</th>
                  </tr>
                  </thead>

                  <tbody class="table-body details" id="body-${order.id}">
                  <c:forEach items="${ItemDAO.getAllItemsByOrderId(order)}"
                             var="item">
                    <tr>
                      <c:set var="product" scope="session"
                             value="${productDAO.getProductsByOrderItem(item.product)}" />
                      <td><img alt=""
                               src="<c:out value="${product.image}"/>"
                               style="width: 50px;"></td>
                      <td style="width: 210px"><c:out
                          value="${product.name}" /></td>
                      <td><c:out value="${product.price}" /></td>
                      <td>${item.quantity}</td>
                      <td>${item.price*item.quantity}</td>
                    </tr>
                  </c:forEach>
                  </tbody>
                    <%--												</table>--%>
                    <%--												</div>--%>
                  </tr>
                  </c:forEach>
                  </tbody>

                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<!-- Contact Section End -->

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
  document.getElementById('menu-contact').classList.add('active')
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