<jsp:include page="header.jsp"/>

<jsp:include page="site-navigation.jsp"/>

<jsp:include page="user-navigation.jsp"/>

<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item" aria-current="page">Home</li>
        <li class="breadcrumb-item active" aria-current="page">Contact</li>

    </ol>
</nav>

<!-- Page Content -->
<div id="page-content-wrapper">
    <div class="container">
        <h1>Contact Us</h1>



        <div class="container justify-content-center">
            <div class="row">
                <div class="col-md-6 col-sm-6 col-xs-12">
                    <form method="post">
                        <div class="form-group ">
                            <label class="control-label " for="name">
                                Name
                            </label>
                            <input class="form-control" id="name" name="name" type="text"/>
                        </div>
                        <div class="form-group ">
                            <label class="control-label requiredField" for="email">
                                Email
                                <span class="asteriskField">
                                    *
                                </span>
                            </label>
                            <input class="form-control" id="email" name="email" type="text"/>
                        </div>
                        <div class="form-group ">
                            <label class="control-label " for="tel">
                                Telephone #
                            </label>
                            <input class="form-control" id="tel" name="tel" type="text"/>
                        </div>
                        <div class="form-group ">
                            <label class="control-label " for="subject">
                                Subject
                            </label>
                            <input class="form-control" id="subject" name="subject" type="text"/>
                        </div>
                        <div class="form-group ">
                            <label class="control-label " for="message">
                                Message
                            </label>
                            <textarea class="form-control" cols="40" id="message" name="message" rows="5"></textarea>
                        </div>
                        <div class="form-group">
                            <div>
                                <button class="btn btn-success " name="submit" type="submit">
                                    Submit
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>





    </div>
</div>
<!-- /#page-content-wrapper -->

<jsp:include page="footer.jsp"/>