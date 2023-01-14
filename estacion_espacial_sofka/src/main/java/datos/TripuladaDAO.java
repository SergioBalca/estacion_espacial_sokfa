package datos;

import dominio.Lanzadera;
import dominio.NaveEspacial;
import dominio.NoTripulada;
import dominio.Tripulada;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TripuladaDAO implements ITripulada{
    private Connection conexionTransaccional;
    private static final String SQL_SELECT = "SELECT id_tripulada, nombre, tipo, peso, empuje, combustible, distancia_orbitacion, numero_tripulantes FROM tripulada";
    private static final String SQL_INSERT = "INSERT INTO tripulada(nombre, tipo, peso, distancia_orbitacion, numero_tripulantes) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_SELECT_ROW = "SELECT id_tripulada, nombre, tipo, peso, empuje, combustible, distancia_orbitacion, numero_tripulantes FROM tripulada WHERE nombre = ?";

    // Constructor vacio
    public TripuladaDAO() {

    }
    @Override
    public List<Tripulada> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Tripulada> naves = new ArrayList<>();

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int idTripulada = rs.getInt("id_tripulada");
                String nombre = rs.getString("nombre");
                String tipo = rs.getString("tipo");
                int peso = rs.getInt("peso");
                int distanciaOrbitacion = rs.getInt("distancia_orbitacion");
                int numeroTripulantes = rs.getInt("numero_tripulantes");
                // para convertir informacion de basea de datos a objetos de java
                NaveEspacial nave = new Tripulada(nombre, tipo, peso, idTripulada, distanciaOrbitacion, numeroTripulantes); // se aplica el concepto de polimorfismo

                naves.add((Tripulada) nave); // se agrega una nave a la lista
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
    public int insertar(Tripulada tripulada) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros; // para llevara conteo de los registros afectados

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_INSERT);
            pstmt.setString(1, tripulada.getNombre());
            pstmt.setString(2, tripulada.getTipo());
            pstmt.setInt(3, tripulada.getPeso());
            pstmt.setInt(4, tripulada.getDistanciaOrbitacion());
            pstmt.setInt(5, tripulada.getNumeroTripulantes());

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
    public List<Tripulada> buscar(String nombreNave) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        NaveEspacial naveEspacial;
        List<Tripulada> naves = new ArrayList<>();

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT_ROW);
            pstmt.setString(1, nombreNave);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                int idTripulada = rs.getInt("id_tripulada");
                String nombre = rs.getString("nombre");
                String tipo = rs.getString("tipo");
                int peso = rs.getInt("peso");
                int distanciaOrbitacion = rs.getInt("distancia_orbitacion");
                int numeroTripulantes = rs.getInt("numero_tripulantes");
                // para convertir informacion de basea de datos a objetos de java
                NaveEspacial nave = new Tripulada(nombre, tipo, peso, idTripulada, distanciaOrbitacion, numeroTripulantes);
                naves.add((Tripulada) nave);
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
