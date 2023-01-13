package datos;

import dominio.Lanzadera;
import dominio.NaveEspacial;

import java.sql.SQLException;
import java.util.List;

public interface ILanzadera {
    //boolean existe(String nombre);
    List<Lanzadera> seleccionar() throws SQLException;
    int insertar(Lanzadera lanzadera) throws SQLException;
    List<Lanzadera> buscar(String nombre);

}
