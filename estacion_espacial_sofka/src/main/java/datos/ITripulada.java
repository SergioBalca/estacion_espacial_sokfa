package datos;

import dominio.Tripulada;

import java.sql.SQLException;
import java.util.List;

public interface ITripulada {
    List<Tripulada> seleccionar() throws SQLException;
    int insertar(Tripulada tripulada) throws SQLException;
    List<Tripulada> buscar(String nombre);
}
