<%@page import="modelos.Requerimiento"%>
<%@page import="dao.RequerimientoDAO"%>
<%@page import="dao.EncargadoDAO"%>
<%@page import="modelos.Encargado"%>
<%@page import="dao.DepartamentoDAO"%>
<%@page import="modelos.Departamento"%>
<%@page import="dao.AsignarDAO"%>
<%@page import="modelos.Asignar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.GerenciaDAO"%>
<%@page import="modelos.Gerencia"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
        <title>Ingreso Requerimiento</title>
    </head>
    <body class="Body">
            <div class="container col-lg-3">
        <form action="ControladorRequerimiento" method="post">
             <div class="form-group text-center">
                    <p><strong>Ingresar Requerimiento</strong></p>
                </div>
            
            <label>Gerencia:</label>
                        <select name="gerencia" class="form-control">
                            <option value="0">Seleccione</option>
                            <% ArrayList<Gerencia> gerencias = new GerenciaDAO().obtenerGerencias(); 
                            for(Gerencia g:gerencias){%>
                            <option value="<%= g.getId() %>"><%= g %></option>
                            <% } %>
                        </select>
                        <label>Departamento:</label>
                        <select name="departamento" class="form-control">
                            <option value="0">Seleccione</option>
                            <% ArrayList<Departamento> departamentos = new DepartamentoDAO().obtenerDepartamentos(); 
                            for(Departamento d:departamentos){%>
                            <option value="<%= d.getId() %>"><%= d %></option>
                            <% } %>
                        </select>
                        <label>Asignar:</label>
                        <select name="asigna" class="form-control">
                            <option value="0">Seleccione</option>
                            <% ArrayList<Asignar> asignados = new AsignarDAO().obtenerAsignados(); 
                            for(Asignar a:asignados){%>
                            <option value="<%= a.getId() %>"><%= a %></option>
                            <% } %>
                        </select>
                        <label>Encargado:</label>
                        <select name="encargado"  class="form-control">
                            <option value="0">Seleccione</option>
                            <% ArrayList<Encargado> encargados = new EncargadoDAO().obtenerEncargados(); 
                            for(Encargado e:encargados){%>
                            <option value="<%= e.getId() %>"><%= e %></option>
                            <% } %>
                        </select>
                                                             
                    <label>Requerimiento:</label>
                    <textarea class="form-control" cols="20" rows="5" name="requerimientoo"></textarea>
                    <br>
            
            <input class="btn btn-danger btn-block" type="submit" value="registrar">
            <input type="hidden" name="accion" value="1"/>
            <br>
            <center>
        <% if(request.getParameter("msj")!= null){%>
        <h3><%= request.getParameter("msj") %></h3>
        <%}%>
            </center>
        </form>
            <a href="menuPrincipal.jsp"><input class="btn btn-danger btn-block" type="submit" value="Volver al Menu"></a>
            </div>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>



