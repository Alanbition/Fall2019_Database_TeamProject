<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<form id="welcome" action="welcome" method="get">
    <label>Welcome! ${lastName} ${firstName} AS Admin</label> 
</form>
<c:forEach items="${users}" var="user">
    <tr>      
        <td>${user.firstName}</td>
    	<br/>
        <td>${user.lastName}</td>
        <br/>
        <td>${user.password}</td>
        <br/>
        <td>${user.email}</td>
        <br/>
        <td>${user.userDtype}</td>
        <br/>  
    </tr>
</c:forEach>
<form id="logout" action="logout" method="post"> 
    <button>logout</button>
</form>