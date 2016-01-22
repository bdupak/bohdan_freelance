<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="google-signin-client_id"
          content="535548665233-q580bffq5d59n7guobvg0smqf61vk98s.apps.googleusercontent.com">
<title>Sign in</title>
    <script src="https://apis.google.com/js/platform.js" async defer></script>
<jsp:include page="/template/headImport.jsp" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/lib/hover.min.css">
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
							<i class="fa fa-user"></i> Sign in
							<div class="pull-right animated bounceIn">
								<div class="col-xs-6 col-sm-6 col-md-6">
									<div class="form-group">
										<div class="social-btn linkedin">
											<img alt="LInkedin" class="social-img hvr-grow"
												src="${pageContext.request.contextPath}/resources/img/social_icon/linkedin_icon.png" />
										</div>
									</div>
								</div>
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <div class="g-signin2" data-onsuccess="onSignIn">
                                            <img alt="Google"
                                                 src="${pageContext.request.contextPath}/resources/img/social_icon/google_plus_icon.png"/>
                                        </div>
                                    </div>
                                </div>
							</div>
						</div>
					</div>
					<div class="panel-body margin-top-sm">
						<c:if test="${notCorrectData != null}">
							<div
								class="alert alert-message alert-message-danger animated fadeInUp">
								<a href="#" class="close"> &times; </a>
								<h4>Error</h4>

                                <p>${requestScope.notCorrectData}</p>
							</div>
						</c:if>
						<form id="loginform" class="form-horizontal animated fadeInUp"
							role="form" method="post"
                              action="${pageContext.request.contextPath}/user/signin">
							<div class="input-group padding-bottom">
								<span class="input-group-addon">
									<i class="glyphicon glyphicon-user"></i>
								</span>
								<input class="form-control" name="email"
									placeholder="Email"
									autofocus="autofocus">
							</div>

							<div class="input-group padding-bottom">
								<span class="input-group-addon">
									<i class="glyphicon glyphicon-lock"></i>
								</span>
								<input type="password" class="form-control" name="password"
									placeholder="Password">
							</div>

							<div class="row text-center">
								<div class="col-xs-6 col-sm-6 col-md-6">
									<input class="btn btn-warning btn-block"
                                           value="Login" id="login" type="submit">
								</div>
								<div class="col-xs-6 col-sm-6 col-md-6">
									<label for="default" class="btn btn-default">
										<span class="hidden-xs">
											Remember me
										</span>
										<input type="checkbox" id="default" class="badgebox"
											name="remember">
										<span class="badge">
											&check;
										</span>
									</label>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
    <script>
        function onSignIn(googleUser) {
            var profile = googleUser.getBasicProfile();
            console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
            console.log('Name: ' + profile.getName());
            console.log('Image URL: ' + profile.getImageUrl());
            console.log('Email: ' + profile.getEmail());

            var email = profile.getEmail();
            var name = profile.getName();
            var img = profile.getImageUrl();

            $.ajax
            (
                    {
                        url: 'user/signinByGoogle',
                        data: {email: email, name: name, img: img},
                        type: 'post',
                        cache: false,
                        success: function (data) {
                            alert('success');
                        },
                        error: function () {
                            alert('error');
                        }
                    }
            );
        }

        function signOut() {
            var auth2 = gapi.auth2.getAuthInstance();
            auth2.signOut().then(function () {
                console.log('User signed out.');
            });
        }
    </script>

    <jsp:include page="/template/footImport.jsp" />
</body>
</html>
