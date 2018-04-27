<jsp:include page="header.jsp"/>

<jsp:include page="site-navigation.jsp"/>

<jsp:include page="user-navigation.jsp"/>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item" aria-current="page">Home</li>
        <li class="breadcrumb-item active" aria-current="page">Store</li>

    </ol>
</nav>
<!-- Page Content -->
<div id="page-content-wrapper">
    <div class="container-fluid">
        <h1>These are the cubes we got.</h1>
        <p>Take 'em or leave 'em </p>
        <br>
        <br>
        <div class="container">
            <div class='row'>
                <c:forEach items="${cubes}" var="c">
                    <c:if test="${c.catalogCategory == '3x3'}">
                        <div class="col-md-4">
                            <div class="card" style="width: 20rem;">
                                <img class="card-img-top" src="img/<c:out value="${c.itemCode}"/>.jpg" alt="<c:out value="${c.name}"/>">
                                <div class="card-body">
                                    <h4 class="card-title"><c:out value="${c.name}"/></h4>
                                    <p class="card-text"><c:out value="${c.tagline}"/></p>
                                    <a href="store?itemCode=<c:out value="${c.itemCode}"/>" class="btn btn-primary">View Item</a>
                                </div>
                            </div>
                        </div>
                    </c:if>
                </c:forEach>



            </div>

            <br>
            <br>
            <div class="row">




                <c:forEach items="${cubes}" var="c">
                    <c:if test="${c.catalogCategory == '4x4'}">
                        <div class="col-md-4">
                            <div class="card" style="width: 20rem;">
                                <img class="card-img-top" src="img/<c:out value="${c.itemCode}"/>.jpg" alt="<c:out value="${c.name}"/>">
                                <div class="card-body">
                                    <h4 class="card-title"><c:out value="${c.name}"/></h4>
                                    <p class="card-text"><c:out value="${c.tagline}"/></p>
                                    <a href="store?itemCode=<c:out value="${c.itemCode}"/>" class="btn btn-primary">View Item</a>
                                </div>
                            </div>
                        </div>
                    </c:if>
                </c:forEach>

                <c:forEach items="${cubes}" var="c">
                    <c:if test="${c.catalogCategory == '5x5'}">
                            <div class="col-md-4">
                                <div class="card" style="width: 20rem;">
                                    <img class="card-img-top" src="img/<c:out value="${c.itemCode}"/>.jpg" alt="<c:out value="${c.name}"/>">
                                    <div class="card-body">
                                        <h4 class="card-title"><c:out value="${c.name}"/></h4>
                                        <p class="card-text"><c:out value="${c.tagline}"/></p>
                                        <a href="store?itemCode=<c:out value="${c.itemCode}"/>" class="btn btn-primary">View Item</a>
                                    </div>
                                </div>
                            </div>
                    </c:if>
                </c:forEach>
                <c:forEach items="${cubes}" var="c">
                    <c:if test="${c.catalogCategory == '6x6'}">
                            <div class="col-md-4">
                                <div class="card" style="width: 20rem;">
                                    <img class="card-img-top" src="img/<c:out value="${c.itemCode}"/>.jpg" alt="<c:out value="${c.name}"/>">
                                    <div class="card-body">
                                        <h4 class="card-title"><c:out value="${c.name}"/></h4>
                                        <p class="card-text"><c:out value="${c.tagline}"/></p>
                                        <a href="store?itemCode=<c:out value="${c.itemCode}"/>" class="btn btn-primary">View Item</a>
                                    </div>
                                </div>
                            </div>
                    </c:if>
                </c:forEach>
            </div>
        </div>
    </div>

</div>


<!-- /#page-content-wrapper -->


<!-- /#wrapper -->




<footer class="footer">&copy; Christopher Bare 2018</footer>


<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/customJS.js" type="text/javascript"></script>
<script src="js/bootstrap.js" type="text/javascript"></script>
<script src="js/bootstrap.bundle.js" type="text/javascript"></script>
</body>
</html>
