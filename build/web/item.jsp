<jsp:include page="header.jsp"/>

<jsp:include page="site-navigation.jsp"/>

<jsp:include page="user-navigation.jsp"/>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix= "fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item" aria-current="page">Home</li>
        <li class="breadcrumb-item" aria-current="page">Store</li>
        <li class="breadcrumb-item active" aria-current="page">Item</li>
    </ol>
</nav>

<!-- Page Content -->
<div id="page-content-wrapper">
    <div class="container">

        <h1><c:out value="${item.name}"/></h1>
        <br>
        <br>
        <div class="row">
            <div class="col-md-4">
                <div class="card" style="width: 20rem;">
                    <img class="card-img-top" src="img/<c:out value="${item.itemCode}"/>.jpg" alt="${item.name}">
                    <div class="card-body">
                        <h4 class="card-title">$<c:out value="${item.price}"/></h4>
                        <p class="card-text"><jsp:include page="displayRating.jsp"/></p>
                        
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">
                            <a class="card-link btn btn-outline-info btn-block" href="ProfileController?action=rate&itemCode=<c:out value="${item.itemCode}"/>">Rate This Item</a>
                        </li>
                    </ul>
                    <div class="card-body">
                        <a href="ProfileController?action=cart&itemCode=<c:out value="${item.itemCode}"/>" class="btn btn-outline-success card-link">Add to Cart</a>
                        <a class="btn btn-outline-success card-link" href="ProfileController?action=save&itemCode=<c:out value="${item.itemCode}"/>">Add to Wishlist</a>
                    </div>
                </div>
            </div>
            <div class="col-lg-8">
                <p><c:out value="${item.description}"/></p>

            </div>
        </div>
    </div>
</div>
<!-- /#page-content-wrapper -->

<jsp:include page="footer.jsp"/>