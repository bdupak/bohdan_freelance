<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Sign up</title>
<jsp:include page="/template/headImport.jsp" />
</head>
<body>
	<jsp:include page="/template/header.jsp" />
	<div class="container">
		<div class="row">
			<div class="header-offset"></div>
			<div
				class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
				<div class="panel panel-primary animated fadeIn cabinet-top">
					<div class="panel-heading">
						<div class="panel-title">
							<i class="fa fa-info"></i> Sign up
							<div class="pull-right">
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
										<div class="social-btn linkedin">
											<img alt="LInkedin" class="social-img"
												src="${pageContext.request.contextPath}/resources/img/social_icon/linkedin_icon.png" />
										</div>
									</div>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
										<div class="social-btn google-plus">
											<img alt="LInkedin" class="social-img"
												src="${pageContext.request.contextPath}/resources/img/social_icon/google_plus_icon.png" />
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="panel-body">
						<c:if test="${notCorrectData != null}">
							<div
								class="alert alert-message alert-message-danger animated fadeInUp">
								<a href="#" class="close"> &times; </a>
								<h4>Error</h4>
								<p>You fail while signup</p>
							</div>
						</c:if>
						<form role="form" method="post" id="registerForm"
							action="${pageContext.request.contextPath}/student/create"
							class="animated fadeInUp">
							<div class="row">
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
										<input type="text" name="first_name" id="first_name" required
											class="form-control input-sm" placeholder="First name"
											autofocus>
									</div>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
										<input type="text" name="last_name" id="last_name"
											class="form-control input-sm" placeholder="Last name">
									</div>
								</div>
							</div>

							<div class="form-group">
								<input name="email" id="email" class="form-control input-sm"
									placeholder="Email">
							</div>

							<div class="row">
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
										<input type="password" name="password" id="password"
											class="form-control input-sm" placeholder="Enter password">
									</div>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
										<input type="password" name="password_confirmation"
											id="password_confirmation" class="form-control input-sm"
											placeholder="Confirm password">
									</div>
								</div>
							</div>


							<button type="submit" class="btn btn-primary btn-block">Add
								me!</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="/template/footImport.jsp" />
</body>
</html>
