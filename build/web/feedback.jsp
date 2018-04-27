<jsp:include page="header.jsp"/>

<jsp:include page="site-navigation.jsp"/>

<jsp:include page="user-navigation.jsp"/>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix= "fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item" aria-current="page">Home</li>
        <li class="breadcrumb-item" aria-current="page">Store</li>
        <li class="breadcrumb-item" aria-current="page">Item</li>
        <li class="breadcrumb-item active" aria-current="page">Feedback</li>
    </ol>
</nav>

<!-- Page Content -->
<div id="page-content-wrapper">
    <div class="container">

        <h1>${item.name}</h1>
        <br>
        <br>
        <div class="row">
            <div class="col-md-4">
                <div class="card" style="width: 20rem;">
                    <img class="card-img-top" src="img/<c:out value="${item.itemCode}"/>.jpg" alt="<c:out value="${item.name}"/>">
                    <div class="card-body">
                        <h4 class="card-title">$<c:out value="${item.price}"/></h4>
                        <p class="card-text"><jsp:include page="displayRating.jsp"/></p>
                    </div>
                </div>
            </div>
            <div class="col-lg-8">
                <p>Please submit your feedback:</p>
                <br>
                <form action="ProfileController">
                <select class="form-control" name="userRating">
                    <option value="1" ${userRating == 1.0 ? 'selected="selected"' : ''}>1</option>
                    <option value="2" ${userRating == 2.0 ? 'selected="selected"' : ''}>2</option>
                    <option value="3" ${userRating == 3.0 ? 'selected="selected"' : ''}>3</option>
                    <option value="4" ${userRating == 4.0 ? 'selected="selected"' : ''}>4</option>
                    <option value="5" ${userRating == 5.0 ? 'selected="selected"' : ''}>5</option>
                </select>
                <br>
                <br>
                <div>
                    <input type="hidden" name="action" value="toRate"/>
                    <input type="hidden" name="itemCode" value="<c:out value="${item.itemCode}"/>"/>
                    <input type="submit" value="Submit Rating" class="btn btn-success btn-lg"/>
                </div>
                </form>
            </div>

        </div>
    </div>
</div>
</div>
<!-- /#page-content-wrapper -->

<jsp:include page="footer.jsp"/>