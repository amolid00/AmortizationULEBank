<%@ include file="/WEB-INF/views/include.jsp"%>

<html>

<head>
<link rel="stylesheet" type="text/css" href="estilos.css" />
<title>Loan payments</title>
</head>
<body>
	<h3>Payments</h3>
	<c:forEach items="${model.payments}" var="payment">
		<table>
			<tr>
				<td><c:out value="${payment.expiration}" /></td>
				<td><c:out value="${payment.amountOfTerm}" /></td>
				<td><c:out value="${payment.amortization}" /></td>
				<td><c:out value="${payment.interests}" /></td>
				<td><c:out value="${payment.outstandingCapital}" /></td>
			<tr>
		</table>
	</c:forEach>
	<a href="<c:url value="liquidateLoan.htm"/>">Go to amortize</a>
</body>
</html>