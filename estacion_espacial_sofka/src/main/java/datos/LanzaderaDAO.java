package datos;

import dominio.Lanzadera;
import dominio.NaveEspacial;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LanzaderaDAO implements ILanzadera {
    private Connection conexionTransaccional;
    private static final String SQL_SELECT = "SELECT id_lanzadera, nombre, tipo, peso, empuje, combustible, potencia, altura FROM estacion_espacial.lanzadera";
    private static final String SQL_INSERT = "INSERT INTO lanzadera(nombre, tipo, peso, empuje, combustible, potencia, altura) VALUES(?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_SELECT_ROW = "SELECT id_lanzadera, nombre, tipo, peso, empuje, combustible, potencia, altura FROM lanzadera WHERE nombre = ?";

    // Constructor vacio
    public LanzaderaDAO() {

    }

    // constructor que recibe objeto tipo Connection para generar conexion con base de datos
    public LanzaderaDAO(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    @Override
    public List<Lanzadera> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Lanzadera> naves = new ArrayList<>();

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int idLanzadera = rs.getInt("id_lanzadera");
                String nombre = rs.getString("nombre");
                String tipo = rs.getString("tipo");
                int peso = rs.getInt("peso");
                int empuje = rs.getInt("empuje");
                String combustible = rs.getString("combustible");
                int potencia = rs.getInt("potencia");
                int altura = rs.getInt("altura");
                // para convertir informacion de basea de datos a objetos de java
                NaveEspacial nave = new Lanzadera(nombre, tipo, peso, empuje, combustible, idLanzadera, potencia, altura); // se aplica el concepto de polimorfismo

                naves.add((Lanzadera) nave); // se agrega una nave a la lista
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
    public int insertar(Lanzadera lanzadera) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int registros; // para llevara conteo de los registros afectados

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_INSERT);
            pstmt.setString(1, lanzadera.getNombre());
            pstmt.setString(2, lanzadera.getTipo());
            pstmt.setInt(3, lanzadera.getPeso());
            pstmt.setInt(4, lanzadera.getEmpuje());
            pstmt.setString(5, lanzadera.getCombustible());
            pstmt.setInt(6, lanzadera.getPotencia());
            pstmt.setInt(7, lanzadera.getAltura());

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
    public List<Lanzadera> buscar(String nombreNave) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        NaveEspacial naveEspacial;
        List<Lanzadera> naves = new ArrayList<>();

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            pstmt = conn.prepareStatement(SQL_SELECT_ROW);
            pstmt.setString(1, nombreNave);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                int idLanzadera = rs.getInt("id_lanzadera");
                String nombre = rs.getString("nombre");
                String tipo = rs.getString("tipo");
                int peso = rs.getInt("peso");
                int empuje = rs.getInt("empuje");
                String combustible = rs.getString("combustible");
                int potencia = rs.getInt("potencia");
                int altura = rs.getInt("altura");
                // para convertir informacion de basea de datos a objetos de java
                NaveEspacial nave = new Lanzadera(nombre, tipo, peso, empuje, combustible, idLanzadera, potencia, altura);
                naves.add((Lanzadera) nave);
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
