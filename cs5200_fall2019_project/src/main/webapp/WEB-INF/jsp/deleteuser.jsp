<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form id="deleteuser" action="deleteuser" method="post">
    <label>Delete User </label>
    <br/>
    <label>ID: </label>
    <input type="text" name="id">
    <br/>
    <button>Submit</button>
</form>