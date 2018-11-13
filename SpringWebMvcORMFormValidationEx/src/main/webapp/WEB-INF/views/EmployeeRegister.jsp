<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.errors {
	color: red;
}
</style>
</head>
<body>
<h2>Welcome to Employee Register Page!!</h2>
<form:form action="insert" method="post" modelAttribute="employee">
<pre>
NAME     : <form:input path="empName"/>
<form:errors path="empName" cssClass="errors"/>
PASSWORD : <form:password path="empPwd"/>
<form:errors path="empPwd" cssClass="errors"/>
GENDER   : <form:radiobutton path="empGen" value="Male"/> Male <form:radiobutton path="empGen" value="Female"/> Female
<form:errors path="empGen" cssClass="errors"/>
ADDRESS  : <form:textarea path="empAddr"/>
<form:errors path="empAddr" cssClass="errors"/>
COUNTRY  : <form:select path="empCntry">
			<form:option value="">-SELECT-</form:option>
			<form:option value="IND">IND</form:option>
			<form:option value="AUS">AUS</form:option>
			<form:option value="DNR">DNR</form:option>
		   </form:select>
<form:errors path="empCntry" cssClass="errors"/>		   
LANGUAGES: 
	<form:checkbox path="empLang" value="ENG"/> ENG		   
	<form:checkbox path="empLang" value="HIN"/> HIN		   
	<form:checkbox path="empLang" value="TEL"/> TEL		   
	<form:checkbox path="empLang" value="TAM"/> TAM
<form:errors path="empLang" cssClass="errors"/>	
<input type="submit" value="Register"/>			   
</pre>
</form:form>
${message}
</body>
</html>

