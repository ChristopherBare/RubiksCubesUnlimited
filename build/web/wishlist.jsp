<jsp:include page="header.jsp"/>

<jsp:include page="site-navigation.jsp"/>

<jsp:include page="user-navigation.jsp"/>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix= "fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item" aria-current="page">Home</li>
        <li class="breadcrumb-item active" aria-current="page">Wishlist</li>

    </ol>
</nav>

<!-- Page Content -->
<div id="page-content-wrapper">
    <div class="container">
        <h1>My Wishlist</h1>
        <br>

        <c:choose>
            <c:when test="${not empty currentProfile.itemRatings}">
                <div class="justify-content-center col-lg-6">
                    <table class="table table-bordered table-responsive">
                        <thead>
                            <tr>
                                <th>Item</th>
                                <th>Price</th>
                                <th>Rating</th>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${currentProfile.itemRatings}" var="i">
                                  
                                    <tr>
                                        <td><a href="CatalogController?itemCode=<c:out value="${i.item.itemCode}"/>"><c:out value="${i.item.name}"/></a></td>
                                        <td>$<c:out value="${i.item.price}"/></td>
                                        <td>${i.rating}</td>
                                        <td><button onclick="window.location.href = 'ProfileController?action=moveToCart&itemCode=<c:out value="${i.item.itemCode}"/>'" class="btn btn-primary">Move To Cart</button></td>
                                        <td><button onclick="window.location.href = 'ProfileController?action=delete&itemCode=<c:out value="${i.item.itemCode}"/>'" class="btn btn-primary">Remove</button></td>
                                    </tr>


                                
                            </c:forEach>


                        </tbody>
                    </table>
                </div>
            </c:when>
            <c:otherwise>
                <p>There's nothing here yet.</p>
                <a class="btn btn-success" href="store">Check out Our Store</a>
            </c:otherwise>
        </c:choose>
    </div>
</div>
<!-- /#page-content-wrapper -->

<jsp:include page="footer.jsp"/>