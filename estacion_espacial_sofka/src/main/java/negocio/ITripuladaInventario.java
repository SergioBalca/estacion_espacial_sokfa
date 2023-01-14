package negocio;

public interface ITripuladaInventario {
    public void agregarTripulada(String nombre, String tipo, int peso, int distanciaOrbitacion, int numeroTripulantes);
    public void listarTripulada();
    public void buscarTripulada(String nombre);
}
