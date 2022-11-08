<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
   <meta charset="utf-8" />
   <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0"/>
   <title>Managements | Products</title>
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
            <!-- Content -->

            <div class="container-xxl flex-grow-1 container-p-y">
              <h4 class="fw-bold py-3 mb-4"><span class="text-muted fw-light">Managements/Products/</span> Details</h4>

              <!-- Basic Layout & Basic with Icons -->
              <div class="row">
                <!-- Basic Layout -->
                <div class="col-xxl">
                  <div class="card">
                    <div class="card-header d-flex align-items-center justify-content-between">
                      <h5 class="mb-0"><strong>MaleFashion Hoodie Details</strong> Details</h5>
                      <a href="./products.jsp" class="btn btn-outline-primary">Back</a>
                    </div>
                    <h5 class="card-header"></h5>
                    <div class="table-responsive text-nowrap">
                      <table class="table table-hover">
                        <thead>
                          <tr>
                            <th>SKU</th>
                            <th>Image</th>
                            <th>Size</th>
                            <th>Color</th>
                            <th>Price</th>
                            <th>Sale Price</th>
                            <th>Details</th>
                            <th></th>
                          </tr>
                        </thead>
                        <tbody class="table-border-bottom-0">
                          <tr>
                            <td>product01Sblack</td>
                            <td>blank</td>
                            <td>S</td>
                            <td>Black</td>
                            <td><i class="fab fa-angular fa-lg text-danger"></i> <strong>450.000</strong></td>
                            <td><i class="fab fa-angular fa-lg text-danger"></i> <strong>390.000</strong></td>
                            <td><a href="./update-product-details.jsp">Change</a></td>
                            <td><a href="#" class="text-danger">Delete</a></td>
                          </tr>
                          <tr>
                            <td>product01Mblack</td>
                            <td>blank</td>
                            <td>M</td>
                            <td>Black</td>
                            <td><i class="fab fa-angular fa-lg text-danger"></i> <strong>450.000</strong></td>
                            <td><i class="fab fa-angular fa-lg text-danger"></i> <strong>390.000</strong></td>
                            <td><a href="./update-product-details.jsp">Change</a></td>
                            <td><a href="#" class="text-danger">Delete</a></td>
                          </tr>
                          <tr>
                            <td>product01Lblack</td>
                            <td>blank</td>
                            <td>L</td>
                            <td>Black</td>
                            <td><i class="fab fa-angular fa-lg text-danger"></i> <strong>450.000</strong></td>
                            <td><i class="fab fa-angular fa-lg text-danger"></i> <strong>390.000</strong></td>
                            <td><a href="./update-product-details.jsp">Change</a></td>
                            <td><a href="#" class="text-danger">Delete</a></td>
                          </tr>
                          <tr>
                            <td>product01XLblack</td>
                            <td>blank</td>
                            <td>XL</td>
                            <td>Black</td>
                            <td><i class="fab fa-angular fa-lg text-danger"></i> <strong>450.000</strong></td>
                            <td><i class="fab fa-angular fa-lg text-danger"></i> <strong>390.000</strong></td>
                            <td><a href="./update-product-details.jsp">Change</a></td>
                            <td><a href="#" class="text-danger">Delete</a></td>
                          </tr>
                        </tbody>
                      </table>
                      <div class="d-flex justify-content-center my-3">
                        <a href="./update-product-details.jsp" type="submit" class="btn btn-primary">Add new</a>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <!-- / Content -->

            <jsp:include page="./footer.jsp" />

            <div class="content-backdrop fade"></div>
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
      document.getElementById('menu-managements-products').classList.add('active')
   </script>
  </body>
</html>
