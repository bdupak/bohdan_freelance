<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="navigation.css">
    <link rel="stylesheet" href="jquery.fullpage.min.css">
    
</head>
<body>
    
    <div id="wrapper">
  <div class="overlay"></div>

  <!-- Sidebar -->
  <nav class="navbar navbar-inverse navbar-fixed-top" id="sidebar-wrapper" role="navigation">
    <ul class="nav sidebar-nav">
      <li class="sidebar-brand">
        <a href="#">
          Brand
        </a>
      </li>
      <li>
        <a href="#">Home</a>
      </li>
      <li>
        <a href="#">About</a>
      </li>
      <li>
        <a href="#">Events</a>
      </li>
      <li>
        <a href="#">Team</a>
      </li>
      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Works <span class="caret"></span></a>
        <ul class="dropdown-menu" role="menu">
          <li class="dropdown-header">Dropdown heading</li>
          <li><a href="#">Action</a></li>
          <li><a href="#">Another action</a></li>
          <li><a href="#">Something else here</a></li>
          <li><a href="#">Separated link</a></li>
          <li><a href="#">One more separated link</a></li>
        </ul>
      </li>
      <li>
        <a href="#">Services</a>
      </li>
      <li>
        <a href="#">Contact</a>
      </li>
      <li>
        <a href="https://twitter.com/maridlcrmn">Follow me</a>
      </li>
    </ul>
  </nav>
  <!-- /#sidebar-wrapper -->

  <!-- Page Content -->
  <div id="page-content-wrapper">
    <button type="button" class="hamburger is-closed cabinet-top" data-toggle="offcanvas">
      <span class="hamb-top"></span>
      <span class="hamb-middle"></span>
      <span class="hamb-bottom"></span>
    </button>
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-lg-offset-2">

        </div>
      </div>
    </div>
  </div>
  <!-- /#page-content-wrapper -->

</div>
<!-- /#wrapper -->


   <script src="navigation.js"></script>
   <script src="jquery2.2.0.min.js"></script>
   <script src="jquery2.2.0.min.js"></script>
    
</body>
</html>