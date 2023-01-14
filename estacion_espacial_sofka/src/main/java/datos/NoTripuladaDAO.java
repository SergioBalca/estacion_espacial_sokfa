package datos;

import dominio.Lanzadera;
import dominio.NaveEspacial;
import dominio.NoTripulada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NoTripuladaDAO implements INoTripulada{
    private Connection conexionTransaccional;
    private static final String SQL_SELECT = "SELECT id_no_tripulada, nombre, tipo, peso, empuje, combustible, velocidad FROM no_tripulada";
    private static final String SQL_INSERT = "INSERT INTO no_tripulada(nombre, tipo, peso, empuje, combustible, velocidad) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_SELECT_ROW = "SELECT id_no_tripulada, nombre, tipo, peso, empuje, combustible, velocidad FROM no_tripulada WHERE nombre = ?";

    // Constructor vacio
    public NoTripuladaDAO() {

    }
    @Override
    public List<NoTripulada> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<NoTripulada> naves = new ArrayList<>();

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int idNoTripulada = rs.getInt("id_no_tripulada");
                String nombre = rs.getString("nombre");
                String tipo = rs.getString("tipo");
                int peso = rs.getInt("peso");
                int empuje = rs.getInt("empuje");
                String combustible = rs.getString("combustible");
                int velocidad = rs.getInt("velocidad");
                // para convertir informacion de basea de datos a objetos de java
                NaveEspacial nave = new NoTripulada(nombre, tipo, peso, empuje, combustible, idNoTripulada, velocidad); // se aplica el concepto de polimorfismo

                naves.add((NoTripulada) nave); // se agrega una nave a la lista
            }

        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(pstmt);
                if (this.conexionTransaccional == null)
                    Conexion.close(conn);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return naves;
    }

    @Override
    public int insertar(NoTripulada noTripulada) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros; // para llevara conteo de los registros afectados

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_INSERT);
            pstmt.setString(1, noTripulada.getNombre());
            pstmt.setString(2, noTripulada.getTipo());
            pstmt.setInt(3, noTripulada.getPeso());
            pstmt.setInt(4, noTripulada.getEmpuje());
            pstmt.setString(5, noTripulada.getCombustible());
            pstmt.setInt(6, noTripulada.getVelocidad());

            registros = pstmt.executeUpdate(); // se altera el estado de la base de datos
        } finally {
            try {
                Conexion.close(pstmt);
                if (this.conexionTransaccional == null)
                    Conexion.close(conn);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return registros;
    }

    @Override
    public List<NoTripulada> buscar(String nombreNave) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        NaveEspacial naveEspacial;
        List<NoTripulada> naves = new ArrayList<>();

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT_ROW);
            pstmt.setString(1, nombreNave);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                int idNoTripulada = rs.getInt("id_no_tripulada");
                String nombre = rs.getString("nombre");
                String tipo = rs.getString("tipo");
                int peso = rs.getInt("peso");
                int empuje = rs.getInt("empuje");
                String combustible = rs.getString("combustible");
                int velocidad = rs.getInt("velocidad");
                // para convertir informacion de basea de datos a objetos de java
                NaveEspacial nave = new Lanzadera(nombre, tipo, peso, empuje, combustible, idNoTripulada, velocidad);
                naves.add((NoTripulada) nave);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(pstmt);
                if (this.conexionTransaccional == null)
                    Conexion.close(conn);
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            }
        }
        return naves;
    }
}
