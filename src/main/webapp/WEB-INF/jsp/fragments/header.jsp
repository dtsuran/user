<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<head>
    <title>Spring MVC Form Handling Example</title>
    <spring:url value="/core/css/hello.css" var="coreCss" />
    <spring:url value="/core/css/bootstrap.min.css" var="bootstrapCss" />
    <link href="${coreCss}" rel="stylesheet"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>
</head>

<spring:url value="/" var="homeUrl" />
<spring:url value="/user/add" var="userAddUrl" />

<nav class="navbar navbar-inverse ">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="${homeUrl}">Spring MVC Form</a>
        </div>
        <div id="navbar">
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="${userAddUrl}">Add User</a></li>
            </ul>
        </div>
    </div>
</nav>
