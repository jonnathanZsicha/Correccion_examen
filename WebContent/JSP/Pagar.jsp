<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
        <html>

        <head>
            <title>Finalizar Pedido</title>
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


                
                       
                         <form action="<%=request.getContextPath()%>/RegistrarComida" method="get">
                        <fieldset class="form-group">
     
                            <label>Totalpagar</label> <input type="text" class="form-control" name="total" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Observaciones</label> <input type="text"  class="form-control" name="observaciones" required="required">
                        </fieldset>
                        
                          <fieldset class="form-group">
     
                            <label>Tarjeta</label> <input type="text" class="form-control" name="tarjeta" required="required">
                        </fieldset>

 
                        <button type="submit" class="btn btn-success">GuardarPedido</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>

        </html>