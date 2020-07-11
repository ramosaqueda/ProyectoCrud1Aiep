<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 
<body>
 <%@ include file="Head.jsp" %>
 <%@ include file="Menu.jsp" %>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="well well-sm">
                <form class="form-horizontal" action="AmbienteController" method="post">
                	<input type="hidden" name="opcion" value="guardar">
                
                    <fieldset>
                        <legend class="text-center header">Crear Ambientes</legend>

                        <div class="form-group">
                            <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>
                            <div class="col-md-8">
                               <label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
                                <input name="nombre" type="text" placeholder="Ingrese el nombre del Ambiente(sala)"  value="${ambientes.nombre}" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-user bigicon"></i></span>
                            <div class="col-md-8">
                              <label for="direecion" class="col-sm-2 col-form-label">Dirección</label>
                                <input id="lname" name="direccion" placeholder="Direeción" type="text"  value="${ambientes.direccion}"  class="form-control">
                            </div>
                        </div>

                        <div class="form-group">
                            <span class="col-md-1 col-md-offset-2 text-center"><i class="fa fa-envelope-o bigicon"></i></span>
                            <div class="col-md-8">
                              <label for="color" class="col-sm-2 col-form-label">Color</label>
                                <input id="color" placeholder="Color" name="color" type="text"    class="form-control">
                            </div>
                        </div>
 

                        <div class="form-group">
                            <div class="col-md-12 text-center">
                                <button type="submit" class="btn btn-primary btn-lg">Grabar</button>
                            </div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</div>
  