<%--
  Created by IntelliJ IDEA.
  User: Dũng Phạm
  Date: 27/05/2024
  Time: 6:54 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>GoTravel - Tour du lịch</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <jsp:include page="/common/tour/header-resource.jsp"/>
</head>

<body>
<!-- Spinner Start -->
<div id="spinner"
     class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
    <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
        <span class="sr-only">Loading...</span>
    </div>
</div>
<!-- Spinner End -->

<jsp:include page="/common/tour/navigation.jsp"/>

<!-- Header Start -->
<div class="container-fluid bg-breadcrumb">
    <div class="container text-center py-5" style="max-width: 900px;">
        <h3 class="text-white display-3 mb-4">Tour du lịch</h3>
    </div>
</div>
<!-- Header End -->

<!-- Packages Start -->
<div class="container-fluid packages py-5">
    <div class="container py-5">
        <div class="mx-auto text-center mb-5" style="max-width: 900px;">
            <h5 class="section-title px-3">Tour du lịch</h5>
            <h1 class="mb-0">Các tour du lịch hấp dẫn</h1>
        </div>
        <div class="tour-container row">
            <%-- Render bằng JavaScript --%>
        </div>
    </div>
</div>
<!-- Packages End -->

<!-- Subscribe Start -->
<jsp:include page="/common/tour/common-subcribe.jsp"/>
<!-- Subscribe End -->

<%-- Start Footer --%>
<jsp:include page="/common/tour/footer.jsp"/>
<%-- End Footer --%>

<script>
    const contextPath = "<%=request.getContextPath()%>";
</script>

<jsp:include page="/common/tour/price-format-js.jsp"/>
<jsp:include page="/common/tour/footer-resource.jsp"/>
<script src="<c:url value="template/tour/ajax-render/tour-render.js"/>"></script>
</body>
</html>