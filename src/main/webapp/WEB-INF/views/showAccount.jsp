<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>P<spring:message code="NO_1.title"/></title>
</head>
<body>
    <h2>PS: Bank Account Details </h2>

    <p><spring:message code="NO_1.account"/>: ${param.accountNo} </p>
    <p><spring:message code="NO_1.accountHolderName"/>: ${param.accountHolderName} </p>
    <p><spring:message code="NO_1.balance"/>: ${param.balance} </p>
    <p><spring:message code="NO_1.accountType" />: ${account.accountType} </p>
    <p><spring:message code="NO_1.dob" />: ${account.dateOfBirth} </p>
    <p><spring:message code="NO_1.psCode" />: ${account.psCode} </p>
</body>
</html>
