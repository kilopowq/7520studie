<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
        <nav class="navbar navbar-expand-sm bg-dark navbar-dark sticky-top">
            <a class="navbar-brand" href="/">
                <img src="/images/Logo.png" class="img-thumbnail" width="30px" height="30px" alt="logo">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="collapsibleNavbar">
                <ul class="navbar-nav">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" data-toggle="dropdown">
                            Products
                        </a>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="/add">Add</a>
                            <a class="dropdown-item" href="/search">Search</a>
                        </div>
                    </li>
                </ul>
            </div>
            <form class="form-inline my-2 my-lg-0">
                <a href="#" class="btn btn-info" role="button"><i class="fa fa-sign-in-alt" aria-hidden="true"></i> Log in</a>
            </form>
        </nav>
</body>
</html>
