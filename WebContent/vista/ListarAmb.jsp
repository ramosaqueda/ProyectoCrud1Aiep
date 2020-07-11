<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

 <%@ include file="../vista/Head.jsp" %>
 <%@ include file="../vista/Menu.jsp" %>
 >
<h3><c:out value="${mensaje}"></c:out></h3>


<table class="table">
  <thead class="table-info">
    <tr>
      <th scope="col">#</th>
      <th scope="col">Nombre</th>
      <th scope="col">Dirección</th>
      <th scope="col">Color</th>
      <th scope="col">Acción</th>
    </tr>
  </thead>
  <tbody>
  
     
	
			<c:forEach var="ambientes" items="${lista}">
			  
				<tr>
					<th scope="row"><c:out value="${ambientes.id}"></c:out></th>
					<td><c:out value="${ambientes.nombre}"></c:out></td>
					<td><c:out value="${ambientes.direccion}"></c:out></td>
					<td><c:out value="${ambientes.color}"></c:out></td>
					<td> 
				 
				 
				 
					<a class="btn btn-outline-warning" href="AmbienteController?opc=editar&id=<c:out value="${ambientes.id}"></c:out>"  role="button">Editar</a>
 					<a class="btn btn-outline-danger" href="AmbienteController?opc=eliminar&id=<c:out value="${ambientes.id}"></c:out>"   role="button">Eliminar</a>

					</td>
				</tr>
			 
			</c:forEach>
		
		</tbody>
		
	</table>

 