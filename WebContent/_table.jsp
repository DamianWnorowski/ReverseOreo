<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table class="table table-striped">
		<thead>
	       <tr>
	       <c:forEach items="${colNames}" var="col">
	       		<th>${col}</th>
	       </c:forEach>
	       </tr>
		</thead>
		<tbody>
	       <c:forEach items="${rowVal}" var="val" >
	          <tr>
	          <c:forEach items="${val.list}" var="attr">
	          	<td>${attr}</td>
	          </c:forEach>
	          </tr>
	       </c:forEach>
		</tbody>
	</table>