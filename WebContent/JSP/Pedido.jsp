<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
                       
                         <form action="<%=request.getContextPath()%>/RegistrarPedido" method="get">
                        <fieldset class="form-group">
     
                            <label>Fecha</label> <input type="text" " class="form-control" name="fecha" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Cliente</label> <input type="text"  class="form-control" name="nombre" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Total</label> <input type="text" class="form-control" name="total" required="required" value="0">
                        </fieldset>
                         <fieldset class="form-group">
                            <label>Observaciones</label> <input type="text" class="form-control" name="observaciones" required="required">
                        </fieldset>
                        

                        <button type="submit" class="btn btn-success">SiguienteRegistrarComidas</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>

        </html>