package negocio;

import datos.INoTripulada;
import datos.NoTripuladaDAO;
import dominio.NoTripulada;

import java.sql.SQLException;
import java.util.List;

public class NoTripuladaInventarioImp implements INoTripuladaInventario{

    private final INoTripulada datos;

    public NoTripuladaInventarioImp() {
        this.datos = new NoTripuladaDAO();
    }

    @Override
    public void agregarNoTripulada(String nombre, String tipo, int peso, int empuje, String combustible, int velocidad) {
        NoTripulada noTripulada = new NoTripulada(nombre, tipo, peso, empuje, combustible, velocidad);

        try {
            this.datos.insertar(noTripulada);
        } catch (SQLException e){
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void listarNoTripulada() {

        try {
            List<NoTripulada> noTripuladas = this.datos.seleccionar();
            noTripuladas.forEach(element -> {
                System.out.println(element);
            });
        } catch (SQLException e){
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarNoTripulada(String nombre) {

        List<NoTripulada> noTripuladas = this.datos.buscar(nombre);
        noTripuladas.forEach(element -> {
            System.out.println(element);
        });
    }
}
