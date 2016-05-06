<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="pageTitle" value="Please Login" scope="request"/>
<jsp:include page="./includes/header.jsp"/>

<!-- a acao do formulario deve estar de acordo com o especificado no arquivo de configuracao -->
<!-- no caso /login -->
<!-- usa apenas post method -->
<c:url value="/login" var="loginUrl"/>
<form action="${loginUrl}" method="post">

	<!-- verificando se houve algum erro -->
    <c:if test="${param.error != null}">
        <div class="alert alert-error">
            Failed to login.
            
            <!-- verificando e apresentando qual foi a ultima mensagem de erro -->
            <c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
              Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
            </c:if>
        </div>
    </c:if>
    
    <c:if test="${param.logout != null}">
        <div class="alert alert-success">
            You have been logged out.
        </div>
    </c:if>
    
    <!-- name=username - indica o nome no qual indicamos no arquivo de configuracao -->
    <label for="username">Username</label>
    <input type="text" id="username" name="username"/>
    
    <!-- name=password - indica o nome no qual indicamos no arquivo de configuracao -->
    <label for="password">Password</label>
    <input type="password" id="password" name="password"/>
    
    <div class="form-actions">
        <input id="submit" class="btn" name="submit" type="submit" value="Login"/>
    </div>
    
</form>
<jsp:include page="./includes/footer.jsp"/>