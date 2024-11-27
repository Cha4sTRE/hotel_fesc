package cj.datos;

import cj.models.Cliente;
import cj.models.Habitaciones;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HabitacionesDAO {

    private static final String SQL_SELECT="select * from habitaciones";
    private static final String ASIGNAR_HABITACION="insert into reservashabitaciones (id_cliente,id_habitacion,habitacion) values (?,?,?)";
    private static final String SQL_INSERT="insert into habitaciones(numero_habitacion,tipo,estado,descripcion,capacidad_maxima) values(?,?,?,?,?)";
    private static final String SQL_SELECT_BY_ID="select * from habitaciones where id_habitacion=?";
    private static final String SQL_DELETE_RESERVA="delete from reservashabitaciones where id_reserva=?";
    private static final String SQL_DELETE="delete from habitaciones where id_habitacion=?";
    public List<Habitaciones> listarHabitaciones(){
        List<Habitaciones> habitaciones=new ArrayList<>();
        try(Connection conexion=Conexion.getConnection()){
            PreparedStatement pstm=conexion.prepareStatement(SQL_SELECT);
            ResultSet rs=pstm.executeQuery();
            while(rs.next()){
                Habitaciones habitacion=new Habitaciones(
                        rs.getInt("id_habitacion"),
                        rs.getInt("numero_habitacion"),
                        rs.getString("tipo"),
                        rs.getString("estado"),
                        rs.getString("descripcion"),
                        rs.getInt("capacidad_maxima")
                );
                habitaciones.add(habitacion);
            }

        }catch (Exception e){
            System.out.println("Error al listar los clientes: "+e.getMessage());
        }
        return habitaciones;
    }

    public boolean asignarHabitacion(int idCliente,int idHabitacion,int habitacion){

        try(Connection conexion=Conexion.getConnection()){
            PreparedStatement pstm=conexion.prepareStatement(ASIGNAR_HABITACION);
            pstm.setInt(1, idCliente);
            pstm.setInt(2, idHabitacion);
            pstm.setInt(3, habitacion);

            int filasInsertadas = pstm.executeUpdate();
            if (filasInsertadas > 0) {
                // Actualizar el estado de la habitación
                String updateSql = "UPDATE habitaciones SET estado = 'Ocupada' WHERE id = ?";
                try (PreparedStatement updatePstm = conexion.prepareStatement(updateSql)) {
                    updatePstm.setInt(1, idHabitacion);
                    updatePstm.executeUpdate();
                }
                return true;
            }
        }catch (Exception e){
            System.out.println("Error al Asignar Habitacion: "+e.getMessage());
        }
        return false;

    }
   public int insertar(Habitaciones habitacion){
        int rows=0;
        try(Connection conexion=Conexion.getConnection()){
            PreparedStatement ps=conexion.prepareStatement(SQL_INSERT);
            ps.setInt(1, habitacion.getNumeroHabitacion());
            ps.setString(2, habitacion.getTipo());
            ps.setString(3, habitacion.getEstado());
            ps.setString(4, habitacion.getDescripcion());
            ps.setInt(5,habitacion.getCapacidadMax());
            rows=ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows;
    }

    public Habitaciones encontrarHabitacion(Habitaciones habitacion) {

        try(Connection conexion=Conexion.getConnection()){

            PreparedStatement ps=conexion.prepareStatement(SQL_SELECT_BY_ID);
            ps.setInt(1,habitacion.getId_habitacion());
            try(ResultSet rs=ps.executeQuery()){
                if(rs.next()){
                    //cliente.setNombre(rs.getString("nombre"));
                    habitacion.setNumeroHabitacion(rs.getInt("numero_habitacion"));
                    habitacion.setTipo(rs.getString("tipo"));
                    habitacion.setEstado(rs.getString("estado"));
                    habitacion.setDescripcion(rs.getString("descripcion"));
                    habitacion.setCapacidadMax(rs.getInt("capacidad_maxima"));
                }
            }
        }catch (SQLException e){
            System.out.println("error al encontrar el cliente: "+e.getMessage());
        }
        return habitacion;
    }


    public int obtenerIdReserva(int idCliente) {
        String sql = "SELECT id_reserva FROM reservashabitaciones WHERE id_cliente = ?";
        try (Connection conexion = Conexion.getConnection();
             PreparedStatement pstm = conexion.prepareStatement(sql)) {
            pstm.setInt(1, idCliente);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                return rs.getInt("id_reserva");
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener ID de reserva: " + e.getMessage());
        }
        return -1; // Retornar -1 si no se encuentra
    }
    public int obtenerHabitacionReserva(int idCliente) {
        String sql = "SELECT habitacion FROM reservashabitaciones WHERE id_cliente = ?";
        try (Connection conexion = Conexion.getConnection();
             PreparedStatement pstm = conexion.prepareStatement(sql)) {
            pstm.setInt(1, idCliente);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                return rs.getInt("habitacion");
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener ID de reserva: " + e.getMessage());
        }
        return -1; // Retornar -1 si no se encuentra
    }
    public int eliminarReserva(int idReserva){
        int rows=0;
        try(Connection conexion=Conexion.getConnection()){
            PreparedStatement ps=conexion.prepareStatement(SQL_DELETE_RESERVA);
            ps.setInt(1, idReserva);
            rows=ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows;
    }

    public int eliminarHabitacion(Habitaciones habitacion){

        int rows=0;
        try(Connection conexion=Conexion.getConnection()){
            PreparedStatement ps=conexion.prepareStatement(SQL_DELETE);
            ps.setInt(1, habitacion.getId_habitacion());
            rows=ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rows;
    }

}
