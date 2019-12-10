<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form id="createGroup" action="createGroup" method="post">
    <label>Create Group </label>
    <br/>
    <label>Group Name: </label>
    <input type="text" name="groupName">
    <br/>
    <label>Active Points: </label>
    <input type="text" name="activePoint">
    <br/>
    <button>Submit</button>
</form>
