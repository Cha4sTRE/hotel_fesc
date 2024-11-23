package cj.datos;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Conexion {

    private static final String JDBC="jdbc:mysql://localhost:3306/hoteldb?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USER="root";
    private static final String PASSWORD="12345";
    private static BasicDataSource dataSource;

    public static DataSource getDataSource(){
        if(dataSource==null){
            dataSource=new BasicDataSource();
            dataSource.setUrl(JDBC);
            dataSource.setUsername(USER);
            dataSource.setPassword(PASSWORD);
            dataSource.setInitialSize(10);
            dataSource.setMaxTotal(50);

        }
        return dataSource;
    }
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Error al cargar el controlador JDBC", e);
        }
        return getDataSource().getConnection();
    }



}
