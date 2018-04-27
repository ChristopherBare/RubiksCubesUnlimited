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
        <h1>Cart</h1>
        <br>

        <c:choose>
            <c:when test="${not empty currentProfile.cart}">
                <div class="justify-content-center col-lg-10">
                    <table class="table table-bordered table-responsive">
                        <thead>
                            <tr>
                                <th>Item</th>
                                <th>Price</th>
                                <th>Rating</th>
                                <th>Quantity</th>
                                <th></th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${currentProfile.cart}" var="i">
                                <tr>
                                    <td><a href="CatalogController?itemCode=<c:out value="${i.item.itemCode}"/>"><c:out value="${i.item.name}"/></a></td>
                                    <td>$<c:out value="${i.item.price}"/></td>
                                    <td><c:out value="${i.rating}"/></td>
                                    <td>
                                        <button onclick="window.location.href = 'ProfileController?action=removeFromCart&itemCode=<c:out value="${i.item.itemCode}"/>'" class="btn btn-outline-info"> - </button>
                                        <c:out value="${currentProfile.cartHash[i.item.itemCode]}"/>
                                        <button onclick="window.location.href = 'ProfileController?action=cart&itemCode=<c:out value="${i.item.itemCode}"/>'" class="btn btn-outline-info"> + </button>
                                    </td>
                                    <td><button onclick="window.location.href = 'ProfileController?action=moveToWishlist&itemCode=<c:out value="${i.item.itemCode}"/>'" class="btn btn-primary">Move To Wishlist</button></td>
                                    <td><button onclick="window.location.href = 'ProfileController?action=deleteFromCart&itemCode=<c:out value="${i.item.itemCode}"/>'" class="btn btn-primary">Remove</button></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:when>
            <c:otherwise>
                <p>There's nothing here yet.</p>
            </c:otherwise>
        </c:choose>
    </div>
    <br>
    <br>

    <div class="container">
        <a href="http://www.paypal.com" class="btn btn-lg btn-success">Checkout</a>
    </div>
</div>
<!-- /#page-content-wrapper -->

<jsp:include page="footer.jsp"/>