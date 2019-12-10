<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<label>All Groups</label>
<c:forEach items="${groups}" var="group">
    <tr>
        <td>${group.id}</td>    
        <td>${group.name}</td>
        <td>${group.activePoint}</td>
    </tr>
</c:forEach>
<form id="addGroup" action="addGroup" method="post">
    <label>Group ID: </label>
    <input type="text" name="groupId">
    <br/>
    <button>Join</button>  
</form>
