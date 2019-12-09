<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form id="login" action="login" method="post">
    <label>Login </label>
    <br/>
    <label>Email: </label>
    <input type="text" name="email">
    <br/>
    <label>Password: </label>
    <input type="text" name="password">
    <br/>
    <button>Login</button>
    <br/>
    <label>Login </label>  
    <br/>  
    <button>back</button>   
</form>