<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
  <%@ include file="Head.jsp" %>
 <%@ include file="Menu.jsp" %>
<c:set var="ambientes" value="${ambiente}"> </c:set>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="well well-sm">
                <form class="form-horizontal" action="AmbienteController" method="post">
                	<input type="hidden" name="opcion" value="editar">
                	<input type="hidden" name ="id" value="${ambientes.id}">	
                    <fieldset>
                        <legend class="text-center header">Editar Ambientes</legend>

                        <div class="form-group">
                            <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>
                            <div class="col-md-8">
                               <label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
                                <input name="nombre" type="text" value="${ambientes.nombre}" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>
                            <div class="col-md-8">
                              <label for="direecion" class="col-sm-2 col-form-label">Dirección</label>
                                <input id="dir" name="direccion" type="text"  value="${ambientes.direccion}"  class="form-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-envelope-o bigicon"></i></span>
                            <div class="col-md-8">
                              <label for="color" class="col-sm-2 col-form-label">Color</label>
                                <input id="color" name="color" type="text"  value="${ambientes.color}" class="form-control">
                            </div>
                        </div>
 

                        <div class="form-group">
                            <div class="col-md-12 text-center">
                                <button type="submit" class="btn btn-primary btn-lg">Actualizar datos</button>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</div>
 