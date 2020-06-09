<%@page import="javafx.scene.control.Alert"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
        <html>

        <head>
            <title>Registrar Pedido</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        </head>
        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: black">
                    <div>
                        <a href="https://www.javaguides.net" class="navbar-brand">Restaurante </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="/Practica01/Html/index.html" class="nav-link">Home</a></li>
                    </ul>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                    
                      <form action="<%=request.getContextPath()%>/Sumar" method="get">
                        Seleccione sus comidas : <br>
                        
                        
                        	<input type="checkbox" name="nombres" value="Seco de pollo"><input type="checkbox" name="comidas" value="2.25" > Seco de pollo $ 2.25 </>
							
							<p> </p>
							
							<input type="checkbox" name="nombres" value="Seco de carne"><input type="checkbox" name="comidas" value="2.50" > Seco de carne $ 2.50 </>
							
							<p> </p>
							<input type="checkbox" name="nombres" value="Churasco"><input type="checkbox" name="comidas" value="2" > Churasco $ 2.00 </>
							
							<p> </p>
							<input type="checkbox" name="nombres" value="Costilla"><input type="checkbox" name="comidas" value="3.50" > Costilla $ 3.50 </>
							
							<p> </p>
							<input type="checkbox" name="nombres" value="Camarones"><input type="checkbox" name="comidas" value="5.50" > Camarones $ 5.50 </>
							
							<p> </p>
							<input type="checkbox" name="nombres" value="Salchipapa"><input type="checkbox" name="comidas" value="1.50" > Salchipapa $ 1.50 </>
							
							<p> </p>
							
							<input type="submit" value="calcular total">
                         </form>
                     
         
                         <form action="<%=request.getContextPath()%>/RegistrarPedido" method="get">
                        <fieldset class="form-group">
     
                            <label>Fecha</label> <input type="text" " class="form-control" name="fecha" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Cliente</label> <input type="text"  class="form-control" name="nombre" required="required">
                        </fieldset>
                        
                           <c:forEach var="comida" items="${comidas}">
                           
                           <input type="checkbox" name="frutas" value="pina">Piña
							
                            </c:forEach>
                            
                        <fieldset class="form-group">
                            <label>Total</label> <input type="text" class="form-control" name="total" required="required" value="${total}">
                        </fieldset>
                         <fieldset class="form-group">
                            <label>Observaciones</label> <input type="text" class="form-control" name="observaciones" required="required">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Numero Tarjeta</label> <input type="text" class="form-control" name="tarjeta" required="required">
                        </fieldset>
                        
                        

                      
                        
                        

                        <button type="submit" class="btn btn-success">Registrarpedido</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>

        </html>