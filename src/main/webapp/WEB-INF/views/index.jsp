<div class="container-fluid" align="center">

	<div class="row-fluid" align="center">
			<div class="alert alert-success">
				<fmt:message key="${param.success}" bundle="${rb}" />
			</div>
	</div>
	<div class="row-fluid">
			<div class="alert alert-danger">
				<fmt:message key="${param.error}" bundle="${rb}" />
			</div>
	</div>

	<div class="row-fluid">
		<h2>
			<fmt:message key="library.greeting" bundle="${rb}" />
		</h2>
	</div>

</div>
<%@include file="WEB-INF/views/footer.jsp"%>
