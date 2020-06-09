<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
        <html>

        <head>
            <title>ingresar comidas</title>
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
            
            <form  name='sesion' action='<%=request.getContextPath()%>/Busqueda' method='get'>
             
                      <fieldset>
                       
                        <input type="text" name="busqueda"  alt=""/><br />
                        <input  name="comida" type="submit"  value="comida"/>
                        <input name="tarjeta" type="submit" value="tarjeta"/>
                        </fieldset>
            </form>
                        
                    

            <div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                    <h3 class="text-center">Lista de Pedidos</h3>
                    <hr>
                    <div class="container text-left">


                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                            
                                <th>Cliente</th>
                                <th>Fecha</th>
                                <th>Observaciones</th>
                                <th>Total</th>
                                	
                                
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                            
                             <c:forEach var="pedido" items="${pedidos}">

                                <tr>
                                    <td>
                                        <c:out value="${pedido.cliente}" />
                                    </td>
                                    <td>
                                        <c:out value="${pedido.fecha}" />
                                    </td>
                                      <td>
                                        <c:out value="${pedido.observaciones}" />
                                    </td>
                                                                          <td>
                                        <c:out value="${pedido.total}" />
                                    </td>
                                </tr>
                                
                            </c:forEach>
                
                			
                            <c:forEach var="comida" items="${comidas}">

                                <tr>
                                    <td>
                                        <c:out value="${comida.nombre}" />
                                    </td>
                                    <td>
                                        <c:out value="${comida.preciounitario}" />
                                    </td>
                                    <td><a  class="btn btn-success" href="<%=request.getContextPath()%>/RegistrarComida?id=<c:out value='${comida.numero}' />">Agregar</a> &nbsp;&nbsp;&nbsp;&nbsp;</td>
                                </tr>
                                
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                </div>
                
            </div>
            <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Pagar</a>

        </html>