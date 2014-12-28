<%--
  Created by IntelliJ IDEA.
  User: Iaroslav
  Date: 22.12.2014
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Users Page</title>
  <style type="text/css">
    .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
    .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
    .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
    .tg .tg-4eph{background-color:#f9f9f9}
  </style>
</head>
<body>
<h1>
  Add a User
</h1>

<c:url var="addAction" value="/" > </c:url>

<form:form action="${addAction}" commandName="person">
  <table>
    <c:if test="${!empty person.name}">
      <tr>
        <td>
          <form:label path="id">
            <spring:message text="ID"/>
          </form:label>
        </td>
        <td>
          <form:input path="id" readonly="true" size="8"  disabled="true" />
          <form:hidden path="id" />
        </td>
      </tr>
    </c:if>
    <tr>
      <td>
        <form:label path="name">
          <spring:message text="Name"/>
        </form:label>
      </td>
      <td>
        <form:input path="name" />
      </td>
    </tr>
    <tr>
      <td>
        <form:label path="country">
          <spring:message text="Country"/>
        </form:label>
      </td>
      <td>
        <form:input path="country" />
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <c:if test="${!empty person.name}">
          <input type="submit"
                 value="Edit User"/>
        </c:if>
        <c:if test="${empty person.name}">
          <input type="submit"
                 value="Add User"/>
        </c:if>
      </td>
    </tr>
  </table>
</form:form>
<br>
<h3>User List</h3>
<c:if test="${!empty users}">
  <table class="tg">
    <tr>
      <th width="80">ID</th>
      <th width="120">Name</th>
      <th width="80">Age</th>
      <th width="80">Admin</th>
      <th width="120">Created Date</th>
      <th width="60">Edit</th>
      <th width="60">Delete</th>
    </tr>
    <c:forEach items="${listPersons}" var="person">
      <tr>
        <td>${user.id}</td>
        <td>${user.name}</td>
        <td>${user.age}</td>
        <td>${user.isAdmin}</td>
        <td>${user.createdDate}</td>
        <td><a href="<c:url value='/edit/${person.id}' />" >Edit</a></td>
        <td><a href="<c:url value='/remove/${person.id}' />" >Delete</a></td>
      </tr>
    </c:forEach>
  </table>
</c:if>
</body>
</html>
