package cj.datos;

import cj.models.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private static final String SQL_SELECT="select * from clientes";
    private static final String SQL_INSERT="insert into clientes(nombre,apellido,tipo_identificacion,numero_identificacion,fecha_nacimiento,genero,telefono,correo_electronico,direccion,numero_habitacion) values(?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_SELECT_BY_ID="select * from clientes where id_cliente=?";
    private static final String SQL_UPDATE= "update clientes set nombre=?,apellido=?,tipo_identificacion=?,numero_identificacion=?,fecha_nacimiento=?,genero=?,telefono=?,correo_electronico=?,direccion=?,numero_habitacion=? where id_cliente=?";
    private static final String SQL_DELETE="delete from clientes where id_cliente=?";
    public List<Cliente> listarClientes(){
        List<Cliente> clientes=new ArrayList<Cliente>();
        try(Connection conexion=Conexion.getConnection()){
            PreparedStatement pstm=conexion.prepareStatement(SQL_SELECT);
            ResultSet rs=pstm.executeQuery();
            while(rs.next()){
                Cliente cliente=new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("tipo_identificacion"),
                        rs.getLong("numero_identificacion"),
                        rs.getString("fecha_nacimiento"),
                        rs.getString("genero"),
                        rs.getLong("telefono"),
                        rs.getString("correo_electronico"),
                        rs.getString("direccion"),
                        rs.getInt("numero_habitacion")
                );
                clientes.add(cliente);
            }

        }catch (Exception e){
            System.out.println("Error al listar los clientes: "+e.getMessage());
        }
        return clientes;
    }
    public int insertar(Cliente cliente){
        int rows=0;
        int idGenerado=-1;
        try(Connection conexion=Conexion.getConnection()){
            PreparedStatement ps=conexion.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getTipoIdentificacion());
            ps.setLong(4, cliente.getNumeroIdentificacion());
            ps.setString(5, cliente.getFechaNacimiento());
            ps.setString(6, cliente.getGenero());
            ps.setLong(7, cliente.getTelefono());
            ps.setString(8, cliente.getCorreoElectronico());
            ps.setString(9, cliente.getDireccion());
            ps.setInt(10,cliente.getHabitacion());
            rows=ps.executeUpdate();
            if (rows > 0) {
                // Recuperar el ID generado
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    idGenerado = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return idGenerado;
    }

    public Cliente encontrarCliente(Cliente cliente) {

        try(Connection conexion=Conexion.getConnection()){

            PreparedStatement ps=conexion.prepareStatement(SQL_SELECT_BY_ID);
            ps.setInt(1,cliente.getId_cliente());
            try(ResultSet rs=ps.executeQuery()){
                if(rs.next()){
                    cliente.setNombre(rs.getString("nombre"));
                    cliente.setApellido(rs.getString("apellido"));
                    cliente.setTipoIdentificacion(rs.getString("tipo_identificacion"));
                    cliente.setNumeroIdentificacion(rs.getLong("numero_identificacion"));
                    cliente.setFechaNacimiento(rs.getString("fecha_nacimiento"));
                    cliente.setCorreoElectronico(rs.getString("correo_electronico"));
                    cliente.setTelefono(rs.getLong("telefono"));
                    cliente.setCorreoElectronico(rs.getString("correo_electronico"));
                    cliente.setDireccion(rs.getString("direccion"));
                    cliente.setHabitacion(rs.getInt("numero_habitacion"));
                }
            }
        }catch (SQLException e){
            System.out.println("error al encontrar el cliente: "+e.getMessage());
        }
        return cliente;
    }

    public int actualizar(Cliente cliente) {

        int rows=0;
        try(Connection conexion=Conexion.getConnection()){
            PreparedStatement ps=conexion.prepareStatement(SQL_UPDATE);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setString(3, cliente.getTipoIdentificacion());
            ps.setLong(4, cliente.getNumeroIdentificacion());
            ps.setString(5, cliente.getFechaNacimiento());
            ps.setString(6, cliente.getGenero());
            ps.setLong(7, cliente.getTelefono());
            ps.setString(8, cliente.getCorreoElectronico());
            ps.setString(9, cliente.getDireccion());
            ps.setInt(10,cliente.getHabitacion());
            ps.setInt(11, cliente.getId_cliente());
            rows=ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows;

    }

    public int eliminarCliente(Cliente cliente){
        int rows=0;
        try(Connection conexion=Conexion.getConnection()){
            PreparedStatement ps=conexion.prepareStatement(SQL_DELETE);
            ps.setInt(1, cliente.getId_cliente());
            rows=ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows;
    }

}
