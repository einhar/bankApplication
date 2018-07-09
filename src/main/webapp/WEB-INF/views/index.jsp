<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Welcome to Bank Application</title>
</head>
<body>
    <div class="container">
        <%@ include file="header.jsp"%>

        <div class="row">
            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                <div class="jumbotron">
                    <h1 class="display-4">Welcome to Web Bank Application</h1>
                    <p class="lead">
                        Happiness = A Good Bank Account, A Good Cook and a Good Digestion - Jean
                    </p>

                    <a href="/user/new" class="btn btn-lg btn-success">Register Here</a>
                    <p><br />Existing Users: <a href="user/login">Login Here</a> </p>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-xl-3 col-lg-3 col-md-3 col-sm-6 col-12">
                <div class="card" style="height: 220px">
                    <div class="card-header">Online</div>
                    <img src="<spring:url value='/resource/images/stay-online.png' />"
                         class="card-img-top" alt="Online" />
                    <div class="card-body">
                        <p class="card-text">200+ Transactions via NetBanking</p>
                    </div>
                </div>
            </div>

            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                <div class="card" style="height: 220px">
                    <div class="card-header">Phone</div>
                    <img src="<spring:url value='/resource/images/stay-phone.png' />"
                         class="card-img-top" alt="Phone" />
                    <div class="card-body">
                        <p class="card-text">75+ Transactions on your smartphone</p>
                    </div>
                </div>
            </div>

            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                <div class="card" style="height: 220px">
                    <div class="card-header">Social Media</div>
                    <img src="<spring:url value='/resource/images/stay-social.png' />"
                         class="card-img-top" alt="Social" />
                    <div class="card-body">
                        <p class="card-text">Social Media- Chatting, Sharing + Banking</p>
                    </div>
                </div>
            </div>

            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">
                <div class="card" style="height: 220px">
                    <div class="card-header">Watch</div>
                    <img src="<spring:url value='/resource/images/stay-watch.png' />"
                         class="card-img-top" alt="Watch" />
                    <div class="card-body">
                        <p class="card-text">Banking at the flick of a wrist now</p>
                    </div>
                </div>
            </div>
        </div>

        <%@ include file="footer.jsp"%>
    </div>

    <a href="new">Create New Account</a>
</body>
</html>