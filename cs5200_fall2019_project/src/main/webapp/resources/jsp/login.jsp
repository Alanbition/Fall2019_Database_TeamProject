<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <div class = "panel panel-primary">
  <div class="panel-heading">
     <h3 class="panel-title">Employee</h3>
  </div>
  <div class="panel-body">
     <span th:text="${singlePerson.name}"></span>
  </div>
</div>
 <title>Employee List</title>
 <link href="../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../webjars/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
 <script src="../webjars/jquery/3.0.0/js/jquery.min.js" ></script>
</head>
<body>
 <div class= "container">
  <h2>Employee List</h2>
  <table class="table table-striped">
   <thead>
    <tr>
     <th scope="row">Id	</th>
     <th scope="row">FirstName	</th>
     <th scope="row">LastName	</th>
     <th scope="row">Email	</th>
     <th scope="row">Password	</th>
     <th scope="row">Phone	</th>
     <th scope="row">JobTitle	</th>
     <th scope="row">BankAccount	</th>
     <th scope="row">Company	</th>
     <th scope="row">Edit	</th>
     <th scope="row">Delete	</th>
    </tr>
   </thead>
   <tbody>
    <c:forEach items="${employee_list }" var="employee" >
     <tr>
      <td> </td>
      <td> </td>
      <td> </td>
      <td> </td>
      <td> </td>
      <td> </td>
      <td>
       <spring:url value="/employee/update/${employee.employeeId }" var="updateURL" />
       <a class="btn btn-primary" href="${updateURL }" role="button">Update</a>
      </td>
      <td>
       <spring:url value="/employee/delete/${employee.employeeId }" var="deleteURL" />
       <a class="btn btn-primary" href="${deleteURL }" role="button">Delete</a>
      </td>
     </tr>
    </c:forEach>
   </tbody>
  </table>
  <spring:url value="/employee/add" var="addURL" />
  <a class="btn btn-primary" href="${addURL }" role="button">Add New Employee</a>
 </div>


<<<<<<< HEAD:cs5200_fall2019_project/src/main/resources/static/index.html
</body>
</html>
  <body>

    <div class="container">
      <form method="POST" action="${contextPath}/login" class="form-signin">
        <h2 class="form-heading">Log in</h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <input name="username" type="text" class="form-control" placeholder="Username"
                   autofocus="true"/>
            <input name="password" type="password" class="form-control" placeholder="Password"/>
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
            <h4 class="text-center"><a href="${contextPath}/registration">Create an account</a></h4>
        </div>
      </form>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
  </body>
</html>

