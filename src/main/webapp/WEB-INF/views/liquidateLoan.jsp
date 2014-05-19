<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title>Liquidate loan</title>
</head>
<body>
	<h1>Liquidate loan</h1>
	<form:form method="post" commandName="liquidateQuantity">
		<table width="95%" bgcolor="f8f8ff" border="0" cellspacing="0"
			cellpadding="5">
			
			<tr>
				<td align="right" width="20%">Number of fees:</td>
				<td width="20%"><form:input path="numberFees" /></td>
			</tr>
			
			<tr>
				<td align="right" width="20%">Quantity to pay:</td>
				<td width="20%"><form:input path="quantity" /></td>
			</tr>
			
		</table>
		<br>
		<input type="submit" value="Execute">
	</form:form>
	<a href="<c:url value="payments.htm"/>">Go to payments</a>
</body>
</html>