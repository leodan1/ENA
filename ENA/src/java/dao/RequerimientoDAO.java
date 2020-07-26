package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelos.Gerencia;
import modelos.Requerimiento;


public class RequerimientoDAO extends Conexion {
    public int registrar(Requerimiento requerimiento) throws SQLException{
        try{
            String sentencia ="Insert into requerimiento values (DEFAULT,?,?,?,?,?,0)";
         
            Conexion();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setInt(1, requerimiento.getGerencia());
            ps.setInt(2, requerimiento.getDepartamento());
            ps.setInt(3, requerimiento.getAsigna());
            ps.setInt(4, requerimiento.getEncargado());
            ps.setString(5, requerimiento.getRequerimientoo());
            return ps.executeUpdate();
        }catch(Exception e){
            return -1;
        }finally{
            desconectar();
        }
    }
    
    public Requerimiento obtenerRequerimiento(int id) throws SQLException{
        try{
            String sentencia = "select * from requerimiento where id = ?";
            Conexion();
            PreparedStatement ps = obtenerPS(sentencia);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Requerimiento po = null;
            if(rs.next()){
                po = new Requerimiento(rs.getInt("id"),rs.getInt("gerencia"),rs.getInt("departamento"),
                        rs.getInt("asigna"),rs.getInt("encargado"),rs.getString("requerimientoo"));
            }
            
            return po;
        }catch(Exception e){
            return null;
        }finally{
            desconectar();
        }
    }
    
    public ArrayList<Requerimiento> obtenerRequerimientos() throws SQLException{
        try{
            String sentencia = "select * from requerimiento";
            Conexion();
            PreparedStatement ps = obtenerPS(sentencia);
            ResultSet rs = ps.executeQuery();
            ArrayList<Requerimiento> requerimientos = new ArrayList();
            while(rs.next()){
                requerimientos.add(new Requerimiento(rs.getInt("id"),rs.getInt("gerencia"),rs.getInt("departamento"),
                        rs.getInt("asigna"),rs.getInt("encargado"),rs.getString("requerimientoo")));
            }
            return requerimientos;
        }catch(Exception e){
            return new ArrayList();
        }finally{
            desconectar();
        }
    }
}
