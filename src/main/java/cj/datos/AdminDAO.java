package cj.datos;

import cj.models.Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class AdminDAO {

    public Admin adminSesion(Admin admin){
        try(Connection conexion=Conexion.getConnection()){
            PreparedStatement pstm=conexion.prepareStatement("SELECT * FROM administrador WHERE username = ? AND password = ?");
            pstm.setString(1, admin.getUsername());
            pstm.setString(2, admin.getPassword());
            ResultSet rs=pstm.executeQuery();
            if(rs.next()){
                Admin sesionAdmin= new Admin();
                sesionAdmin.setUsername(rs.getString("username"));
                sesionAdmin.setPassword(rs.getString("password"));
                return sesionAdmin;
            }
        }catch (Exception e){
            System.out.println("Error al listar los clientes: "+e.getMessage());
        }
        return null;
    }


}
