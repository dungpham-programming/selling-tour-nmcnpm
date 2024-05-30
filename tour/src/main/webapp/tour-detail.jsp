<%--
  Created by IntelliJ IDEA.
  User: Dũng Phạm
  Date: 29/05/2024
  Time: 10:16 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>GoTravel - Chi tiết tour</title>
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
        <h3 class="text-white display-3 mb-4 title">Chi tiết Tour</h3>
    </div>
</div>
<!-- Header End -->

<!-- Tour Detail Start -->
<div class="container-fluid contact bg-light py-5">
    <div class="container py-5">
        <div class="mx-auto text-center mb-5 detail" style="max-width: 900px;">
            <h5 class="section-title px-3">Chi tiết Tour</h5>
        </div>
        <hr>
        <div class="row g-5 align-items-center">
            <div class="row-info">
                <%-- Render bằng JavaScript --%>
            </div>
            <div class="booking-btn mb-3">
                <a href="#" class="btn btn-primary book rounded-pill py-2 px-4 ms-lg-4 w-100">Đặt tour ngay!</a>
            </div>
        </div>
        <div class="row-description mb-2">
            <%-- Render bằng JavaScript --%>
        </div>
        <div class="row image-box mb-4">
            <%-- Render bằng JavaScript --%>
        </div>
        <hr>
        <h1 class="text-strong-color-black w-100 text-center">Timeline của chuyến du lịch</h1>
        <div class="timeline col-12 mb-4">
            <%-- Render bằng JavaScript --%>
        </div>
        <div class="booking-btn mb-3">
            <a href="http://localhost:8080/tour" class="btn btn-primary book rounded-pill py-2 px-4 ms-lg-4 w-100">Quay về Tour</a>
        </div>
    </div>
</div>
<!-- Tour Detail End -->

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
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="<c:url value="template/tour/ajax-render/tour-detail-render.js"/>"></script>
</body>
</html>
