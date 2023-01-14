package negocio;

import datos.INoTripulada;
import datos.ITripulada;
import datos.NoTripuladaDAO;
import datos.TripuladaDAO;
import dominio.NoTripulada;
import dominio.Tripulada;

import java.sql.SQLException;
import java.util.List;

public class TripuladaInventarioImp implements ITripuladaInventario{
    private final ITripulada datos;

    public TripuladaInventarioImp() {
        this.datos = new TripuladaDAO();
    }
    @Override
    public void agregarTripulada(String nombre, String tipo, int peso, int distanciaOrbitacion, int numeroTripulantes) {
        Tripulada tripulada = new Tripulada(nombre, tipo, peso, distanciaOrbitacion, numeroTripulantes);

        try {
            this.datos.insertar(tripulada);
        } catch (SQLException e){
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void listarTripulada() {
        try {
            List<Tripulada> tripuladas = this.datos.seleccionar();
            tripuladas.forEach(element -> {
                System.out.println(element);
            });
        } catch (SQLException e){
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void buscarTripulada(String nombre) {
        List<Tripulada> tripuladas = this.datos.buscar(nombre);
        tripuladas.forEach(element -> {
            System.out.println(element);
        });
    }
}
