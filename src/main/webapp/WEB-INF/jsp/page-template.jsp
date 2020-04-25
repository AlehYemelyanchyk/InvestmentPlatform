<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>&lt;/&gt;Investment Platform</title>
</head>
<body>
<header>
	<jsp:include page="fragment/head.jsp" />
</header>
<div class="container-fluid">
	<div class="row">
		<aside class="col-xs-12 col-sm-4 col-md-3 col-lg-2">
			<jsp:include page="fragment/aside.jsp" />
		</aside>
		<main class="col-xs-12 col-sm-8 col-md-9 col-lg-10">
			<jsp:include page="${CURRENT_PAGE}" />
		</main>
	</div>
</div>
<footer class="footer">
	<jsp:include page="fragment/footer.jsp" />
</footer>
</body>
</html>