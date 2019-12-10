<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<form id="welcome" action="welcome" method="get">
    <label>Welcome! ${lastName} ${firstName} AS Admin!</label> 
</form>
<c:forEach items="${users}" var="user">
    <tr> 
		<td>${user.id}</td>     
        <td>${user.firstName}</td>
        <td>${user.lastName}</td>
        <td>${user.password}</td>
        <td>${user.email}</td>
        <td>${user.userDtype}</td>
    <br/> 
    </tr>
</c:forEach>
<form id="deleteuser" action="deleteuser" method="post"> 
    <button>Delete</button>
</form>
<form id="updateuser" action="updateuser" method="post"> 
    <button>Update</button>
</form>
<form id="createuser" action="createuser" method="post"> 
    <button>Create</button>
</form>
<form id="logout" action="logout" method="post"> 
    <button>logout</button>
</form>
