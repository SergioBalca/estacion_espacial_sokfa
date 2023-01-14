package negocio;

public interface INoTripuladaInventario {
    public void agregarNoTripulada(String nombre, String tipo, int peso, int empuje, String combustible, int velocidad);
    public void listarNoTripulada();
    public void buscarNoTripulada(String nombre);
}
