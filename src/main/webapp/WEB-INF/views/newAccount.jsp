<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title><spring:message code="NO_1.title" /></title>
	<style>
		.error{
			color: red;
		}
        .error2{
			color: white;
            background-color: black;
		}
	</style>
</head>
<body>
	<h2>Create New Account</h2>
	<form:form method="POST" action="saveAccount" modelAttribute="account">
        <form:errors path="*" cssClass="error2" />
		<table>
			<tr>
				<td><spring:message code="NO_1.account" />: </td>
				<td><form:input path="accountNo" size="30" /><form:errors path="accountNo" cssClass="error" /></td>
			</tr>
			<tr>
				<td><spring:message code="NO_1.accountHolderName" />: </td>
				<td><form:input path="accountHolderName" size="30" /><form:errors path="accountHolderName" cssClass="error" /></td>
			</tr>
			<tr>
				<td><spring:message code="NO_1.balance" />: </td>
				<td><form:input path="balance" size="30" /><form:errors path="balance" cssClass="error" /></td>
			</tr>
			<tr>
                <td><spring:message code="NO_1.accountType" />: </td>
                <td><form:select path="accountType">
                        <form:option value="">Select Account Type</form:option>
                        <form:option value="SAVINGS">Savings </form:option>
                        <form:option value="CURRENT">Current</form:option>
                    </form:select>
                    <form:errors path="accountType" cssClass="error" />
                </td>
			</tr>
			<tr>
				<td><spring:message code="NO_1.dob" />: </td>
				<td><form:input path="dateOfBirth" size="30" /><form:errors path="dateOfBirth" cssClass="error" /></td>
			</tr>
			<tr>
				<td><spring:message code="NO_1.psCode" />: </td>
				<td><form:input path="psCode" size="30" /><form:errors path="psCode" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="Create Account" name="btnSubmit" /> </td>
			</tr>
		</table>
	</form:form>
</body>
</html>

<%--<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>PS Bank: Create New Account</title>
</head>
<body>
<h2>Create New Account</h2>
<form name="accountForm" action="saveAccount" method="post" >
	<table>
		<tr>
			<td>Account #: </td>
			<td><input type="text" name="accountNo" /> </td>
		</tr>
		<tr>
			<td>Account Holder Name: </td>
			<td><input type="text" name="accountHolderName" /> </td>
		</tr>
		<tr>
			<td>Account Balance: </td>
			<td><input type="text" name="balance" />
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="Create Account" name="btnSubmit" />
		</tr>
	</table>
</form>
</body>
</html>--%>
