<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Sign up</title>
    <jsp:include page="/template/headImport.jsp"/>
    <link rel="stylesheet" href="../resources/css/choose.css"/>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/lib/hover.min.css">
</head>
<body>
<jsp:include page="/template/header.jsp"/>

<div class="container cabinet-top">
    <div class="row">
        <div class="head col-xs-12">
            <p>

            <h3>Get started!</h3>
            </p>
            <p>

            <h3>What are you looking for ?!</h3>
            </p>
        </div>
    </div>
    <div class="row">
        <div class="col-xs-12 col-md-6 block-left">
            <h3>Developer</h3>
            <img src="../resources/img/choose/developer.png" alt="Developer"/>
            <h5>
                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Commodi, nobis!
            </h5>
            <a href="signup?role=customer" class="btn btn-block btn-warning work"><span
                    class="glyphicon glyphicon-th"></span> Work</a>
        </div>
        <div class="col-xs-12 col-md-6 block-right">
            <h3>Customer</h3>
            <img src="../resources/img/choose/customer.png" alt="Customer">
            <h5>
                Lorem ipsum dolor sit amet, consectetur adipisicing elit. Architecto, soluta.
            </h5>
            <a href="signup?role=developer" class="btn btn-block btn-primary hire"><span
                    class="glyphicon glyphicon-th"></span> Hire</a>
        </div>
    </div>
</div>
d
<jsp:include page="/template/footImport.jsp"/>
</body>
</html>
