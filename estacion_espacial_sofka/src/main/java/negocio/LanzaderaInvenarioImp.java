package negocio;

import datos.ILanzadera;
import datos.LanzaderaDAO;
import dominio.Lanzadera;

import java.sql.SQLException;
import java.util.List;

public class LanzaderaInvenarioImp implements ILanzaderaInvetario{

    private final ILanzadera datos;

    public LanzaderaInvenarioImp() {
        this.datos = new LanzaderaDAO();
    }

    @Override
    public void agregarLanzadera(String nombre, String tipo, int peso, int empuje, String combustible, int potencia, int altura) {
        Lanzadera lanzadera = new Lanzadera(nombre, tipo, peso, empuje, combustible, potencia, altura);

        try {
            this.datos.insertar(lanzadera);
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void listarLanzadera(String tipo) {
        try {
            List<Lanzadera> lanzaderas = this.datos.seleccionar(tipo);
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
    }
}
