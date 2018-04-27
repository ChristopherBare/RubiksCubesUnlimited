<%-- 
    Document   : user-navigation
    Created on : Feb 18, 2018, 5:10:08 PM
    Author     : christopher1
--%>


<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix= "fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<!--            Navbar-->
<nav class="navbar navbar-dark bg-dark navbar-toggleable-md">
    <button class='navbar-toggler btn btn-outline-secondary' type='button' id='menu-toggle'><span class="navbar-toggler-icon"></span></button>
    <div class="justify-content-center align-items-center">
        <img src="img/Rubiks_cube.png" width="70" height="70" alt="Coob"/>
        <a class="navbar-brand" href="store"><h1>Rubik's Cubes Unlimited</h1></a>
    </div>
    <div class="justify-content-end">
        <ul class="nav nav-pills fix-color">
            <c:choose>
                <c:when test="${currentProfile != null}">
                    <li class="nav-item "><a href="" data-toggle="modal" data-target="#SignOut" class="nav-link "><c:out value="${currentProfile.userID.firstName}"/> <c:out value="${currentProfile.userID.lastName}"/> 
                            <c:if test="${currentProfile.userID.isAdmin == true}"> [Admin]</c:if></a></li>
                    </c:when>
                    <c:otherwise>
                    <li class="nav-item "><a href="" data-toggle="modal" data-target="#SignIn" class="nav-link ">Sign In</a></li>
                    </c:otherwise>
                </c:choose>
            <li class="nav-item">
                <a class="nav-link" href="wishlist.jsp">Wishlist</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="cart.jsp">Cart</a>
            </li>
        </ul>
    </div>

</nav>
<!--End Navbar-->


<!-- Modal Signin-->
<div class="modal fade" id="SignIn" tabindex="-1" role="dialog" aria-labelledby="SignIn" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">Login</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form action="login" method="post">
                <input type="hidden" name="action" value="signin"/>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="exampleInputEmail1">Email</label>
                        <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Username">
                        <small id="emailHelp" class="form-text text-muted">We'll never share your information with anyone else.</small>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Password</label>
                        <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                    </div>
                    <div class="form-check">
                        <input type="checkbox" class="form-check-input" id="exampleCheck1">
                        <label class="form-check-label" for="exampleCheck1">Remember Me</label>
                    </div>
                    <br>
                    <p>Don't have an account? <span><a href="" data-toggle="modal" data-target="#CreateAccount" data-dismiss="modal">Create one</a></span></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Login</button>
                </div>
            </form>
        </div>
    </div>
</div>
<!--End Modal-->

<!-- Modal Signout -->
<div class="modal fade" id="SignOut" tabindex="-1" role="dialog" aria-labelledby="SignOut" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">Sign Out</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form action="login" method="post">
                <div class="modal-body">
                    <input type="hidden" name="action" value="signout"/>
                    <h4>Hello, <c:out value="${currentProfile.userID.firstName}"/>!</h4>
                    <br>
                </div>
                <div class="modal-footer">
                    <button href="userProfile.jsp" class="btn btn-success">View/Edit Profile</button>
                    <button type="submit" class="btn btn-primary">Sign Out</button>
                </div>
            </form>
        </div>
    </div>
</div>
<!--End Modal SignOut-->


<!-- Modal CreateAccount -->
<div class="modal fade" id="CreateAccount" tabindex="-1" role="dialog" aria-labelledby="CreateAccount" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">Create Account</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form action="login" method="post" data-toggle="validator" role="form">
                <div class="modal-body">
                    <input type="hidden" name="action" value="signup"/>
                    <div class="container">
                        <div class="row main">
                            <div class="main-login main-center">
                                <div class="form-group">
                                    <label for="name" class="cols-sm-2 control-label">First Name</label>
                                    <div class="cols-sm-10">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                            <input type="text" class="form-control" name="firstName" id="name"  placeholder="First Name" required/>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="name" class="cols-sm-2 control-label">Last Name</label>
                                    <div class="cols-sm-10">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
                                            <input type="text" class="form-control" name="lastName" id="name"  placeholder="Last Name" required/>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="email" class="cols-sm-2 control-label">Email</label>
                                    <div class="cols-sm-10">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
                                            <input type="text" class="form-control" name="email" id="email"  placeholder="Email" required/>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="password" class="cols-sm-2 control-label">Password</label>
                                    <div class="cols-sm-10">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                            <input type="password" class="form-control" name="password" id="password"  placeholder="Enter your Password" required/>
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="confirm" class="cols-sm-2 control-label">Confirm Password</label>
                                    <div class="cols-sm-10">
                                        <div class="input-group">
                                            <span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
                                            <input type="password" class="form-control" name="confirm" id="confirm"  placeholder="Confirm your Password" required/>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Login</button>
                    <button type="submit" class="btn btn-primary">Create Account</button>
                </div>
            </form>
        </div>
    </div>
</div>
<!--End Modal Create-->