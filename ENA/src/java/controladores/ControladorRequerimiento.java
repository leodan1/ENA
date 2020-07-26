package controladores;

import dao.GerenciaDAO;
import dao.RequerimientoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.Requerimiento;

/**
 *
 * @author leo
 */
@WebServlet(name = "ControladorRequerimiento", urlPatterns = {"/ControladorRequerimiento"})
public class ControladorRequerimiento extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         if(request.getParameter("accion")!=null){
        String accion = request.getParameter("accion");
        switch(accion){
            case "1": registrar(request,response);
                 break;
        }
         }else{
             response.sendRedirect("ingresarRequerimiento.jsp?msj=Acceso Denegado");
         }
    }
    
    private void registrar(HttpServletRequest request, HttpServletResponse response) throws IOException{
          try{
            //int id = Integer.parseInt(request.getParameter("id").trim());
            int id = 10;
            int gerencia = Integer.parseInt(request.getParameter("gerencia"));
            int departamento = Integer.parseInt(request.getParameter("departamento"));
            int asigna = Integer.parseInt(request.getParameter("asigna"));
            int encargado = Integer.parseInt(request.getParameter("encargado"));
            String requerimientoo = request.getParameter("requerimientoo");
            
            if(gerencia<1||departamento<1||asigna<1||encargado<1||requerimientoo.equals(""))
            {
                response.sendRedirect("ingresarRequerimiento.jsp?msj=datos incorrectos");
            }else{
                GerenciaDAO gd = new GerenciaDAO();
                Requerimiento nuevoRequerimiento = new Requerimiento (id,gerencia,departamento,asigna,encargado,
                        requerimientoo);
                
                RequerimientoDAO rd = new RequerimientoDAO();
                
                //if(rd.obtenerRequerimiento(nuevoRequerimiento.getId())==null){
                    int respuesta = rd.registrar(nuevoRequerimiento);
                    if(respuesta==1){
                    response.sendRedirect("ingresarRequerimiento.jsp?msj=Requerimiento Registrado Correctamente");
                    }else{
                    response.sendRedirect("ingresarRequerimiento.jsp?msj=La requerimiento no se pudo ingresar"); // For input String: ""
                    }
                //}else{
                   // response.sendRedirect("ingresarRequerimiento.jsp?msj=El Codigo ya existe");
                //}
            
            }
           }catch(IOException e){
               response.sendRedirect("ingresarRequerimiento.jsp?msj="+e.getMessage());
           } catch (NumberFormatException e) {
               response.sendRedirect("ingresarRequerimiento.jsp?msj="+e.getMessage());
        } catch (SQLException e) {
            response.sendRedirect("ingresarRequerimiento.jsp?msj="+e.getMessage());
        }
      
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
