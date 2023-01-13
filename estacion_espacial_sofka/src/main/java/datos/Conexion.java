package datos;

import java.sql.*;

public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/estacion_espacial?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER ="root";
    private static final String JDBC_PASSWORD = "Tech2022camp";

    // metodo para generar la conexion a la base de datos usando JDBC. El metodo getConnection genera una SQLException
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    // metodos para cerrar objetos tipo ResultSet, Statement, PreparedStatement y Connection
    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void close(Statement smtm) throws SQLException{
        smtm.close();
    }

    public static void close(PreparedStatement psmtm) throws SQLException{
        psmtm.close();
    }

    public static void close(Connection con) throws SQLException{
        con.close();
    }
}
