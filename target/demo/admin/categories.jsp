<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0"/>
	<title>Managements | Categories</title>
	<link rel="icon" type="image/x-icon" href="./assets/img/favicon/favicon.ico" />
	<link href="https://fonts.googleapis.com/css2?family=Public+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap" rel="stylesheet"/>
	<link rel="stylesheet" href="./assets/vendor/fonts/boxicons.css" />
	<link rel="stylesheet" href="./assets/vendor/css/core.css" class="template-customizer-core-css" />
	<link rel="stylesheet" href="./assets/vendor/css/theme-default.css" class="template-customizer-theme-css" />
	<link rel="stylesheet" href="./assets/css/demo.css" />
	<link rel="stylesheet" href="./assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.css" />
	<link rel="stylesheet" href="./assets/vendor/libs/apex-charts/apex-charts.css" />
	<script src="./assets/vendor/js/helpers.js"></script>
	<script src="./assets/js/config.js"></script>
</head>
<body>
  <!-- Layout wrapper -->
  <div class="layout-wrapper layout-content-navbar">
    <div class="layout-container">
      <jsp:include page="./menu.jsp" />
      <!-- Layout container -->
      <div class="layout-page">
        <jsp:include page="./navbar.jsp" />
        <!-- Content wrapper -->
        <div class="content-wrapper">
          <div class="container-xxl flex-grow-1 container-p-y">
            <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Managements / </span>Categories</h4>
            <div class="card">
              <h5 class="card-header">Categories</h5>
              <div class="table-responsive text-nowrap">
                <table class="table table-hover">
                  <thead>
                    <tr>
                      <th>ID</th>
                      <th>Name</th>
                      <th>Description</th>
                      <th></th>
                      <th></th>
                    </tr>
                  </thead>
                  <tbody class="table-border-bottom-0">
                    <tr>
                      <td>category01</td>
                      <td><i class="fab fa-angular fa-lg text-danger"></i> <strong>Tops</strong></td>
                      <td>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Eligendi, saepe?</td>
                      <td><a href="./update-category.jsp">Change</a></td>
                      <td><a href="#" class="text-danger">Delete</a></td>
                    </tr>
                    <tr>
                      <td>category02</td>
                      <td><i class="fab fa-angular fa-lg text-danger"></i> <strong>Outwears</strong></td>
                      <td>Lorem ipsum dolor sit.</td>
                      <td><a href="./update-category.jsp">Change</a></td>
                      <td><a href="#" class="text-danger">Delete</a></td>
                    </tr>
                    <tr>
                      <td>category03</td>
                      <td><i class="fab fa-angular fa-lg text-danger"></i> <strong>Bottoms</strong></td>
                      <td>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Quis, eligendi nesciunt error nihil sed aliquam?</td>
                      <td><a href="./update-category.jsp">Change</a></td>
                      <td><a href="#" class="text-danger">Delete</a></td>
                    </tr>
                    <tr>
                      <td>category04</td>
                      <td><i class="fab fa-angular fa-lg text-danger"></i> <strong>Accessories</strong></td>
                      <td>Lorem ipsum dolor sit amet.</td>
                      <td><a href="./update-category.jsp">Change</a></td>
                      <td><a href="#" class="text-danger">Delete</a></td>
                    </tr>
                  </tbody>
                </table>
                <div class="d-flex justify-content-center my-3">
                  <a href="./update-category.jsp" type="submit" class="btn btn-primary">Add new</a>
                </div>
              </div>
            </div>
          </div>

          <jsp:include page="./footer.jsp" />
        </div>
        <!-- Content wrapper -->
      </div>
      <!-- / Layout page -->
    </div>

    <!-- Overlay -->
    <div class="layout-overlay layout-menu-toggle"></div>
  </div>
  <!-- / Layout wrapper -->

  <!-- Core JS -->
  <!-- build:js assets/vendor/js/core.js -->
  <script src="./assets/vendor/libs/jquery/jquery.js"></script>
  <script src="./assets/vendor/libs/popper/popper.js"></script>
  <script src="./assets/vendor/js/bootstrap.js"></script>
  <script src="./assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.js"></script>

  <script src="./assets/vendor/js/menu.js"></script>
  <!-- endbuild -->

  <!-- Vendors JS -->

  <!-- Main JS -->
  <script src="./assets/js/main.js"></script>

  <!-- Active Menu Item -->
  <script>
    document.getElementById('menu-managements').classList.add('active', 'open')
    document.getElementById('menu-managements-categories').classList.add('active')
 </script>
</body>
</html>
