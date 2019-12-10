<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form id="createuser" action="createuser" method="post">
    <label>Create User </label>
    <br/>
    <label>UserRole: </label>
    <input type="text" name="userRole">
    <br/>
    <label>First Name: </label>
    <input type="text" name="firstName">
    <br/>
    <label>Last Name: </label>
    <input type="text" name="lastName">
    <br/>
    <label>Email: </label>
    <input type="text" name="email">
    <br/>
    <label>Password: </label>
    <input type="text" name="password">
    <br/>
    <button>Submit</button>
</form>
