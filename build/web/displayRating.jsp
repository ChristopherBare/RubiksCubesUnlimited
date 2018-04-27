<%-- 
    Document   : rating
    Created on : Feb 18, 2018, 5:51:34 PM
    Author     : christopher1
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix= "fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<c:choose>
    <c:when test="${not empty currentProfile.ratedItems}">
        <c:forEach items="${currentProfile.ratedItems}" var="i">
            <c:if test="${i.item.itemCode == item.itemCode}">
                <div class="rating-block">
                    <p class="ratings-type">Your Rating: <span><h4><c:out value="${i.rating}"/></h4></span></p>
                </div>
            </c:if>
        </c:forEach>
    </c:when>
</c:choose>






<!--    <div class="rating-block-rating" data-rating>
        <div class="star selected">
            <svg xmlns="http://www.w3.org/2000/svg" width="40" height="37" viewBox="0 0 40 37">
                <polygon fill="none" points="272 30 260.244 36.18 262.489 23.09 252.979 13.82 266.122 11.91 272 0 277.878 11.91 291.021 13.82 281.511 23.09 283.756 36.18" transform="translate(-252)"/>
            </svg>
        </div>
        <div class="star selected">
            <svg xmlns="http://www.w3.org/2000/svg" width="40" height="37" viewBox="0 0 40 37">
                <polygon fill="none" points="272 30 260.244 36.18 262.489 23.09 252.979 13.82 266.122 11.91 272 0 277.878 11.91 291.021 13.82 281.511 23.09 283.756 36.18" transform="translate(-252)"/>
            </svg>
        </div>
        <div class="star selected">
            <svg xmlns="http://www.w3.org/2000/svg" width="40" height="37" viewBox="0 0 40 37">
                <polygon fill="none" points="272 30 260.244 36.18 262.489 23.09 252.979 13.82 266.122 11.91 272 0 277.878 11.91 291.021 13.82 281.511 23.09 283.756 36.18" transform="translate(-252)"/>
            </svg>
        </div>
        <div class="star">
            <svg xmlns="http://www.w3.org/2000/svg" width="40" height="37" viewBox="0 0 40 37">
                <polygon fill="none" points="272 30 260.244 36.18 262.489 23.09 252.979 13.82 266.122 11.91 272 0 277.878 11.91 291.021 13.82 281.511 23.09 283.756 36.18" transform="translate(-252)"/>
            </svg>
        </div>
        <div class="star">
            <svg xmlns="http://www.w3.org/2000/svg" width="40" height="37" viewBox="0 0 40 37">
                <polygon fill="none" points="272 30 260.244 36.18 262.489 23.09 252.979 13.82 266.122 11.91 272 0 277.878 11.91 291.021 13.82 281.511 23.09 283.756 36.18" transform="translate(-252)"/>
            </svg>
        </div>
    </div>-->