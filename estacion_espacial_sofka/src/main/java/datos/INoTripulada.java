package datos;

import dominio.Lanzadera;
import dominio.NoTripulada;

import java.sql.SQLException;
import java.util.List;

public interface INoTripulada {
    List<NoTripulada> seleccionar() throws SQLException;
    int insertar(NoTripulada noTripulada) throws SQLException;
    List<NoTripulada> buscar(String nombre);
}
