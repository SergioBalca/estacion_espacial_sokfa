package negocio;

public interface ILanzaderaInvetario {
    public void agregarLanzadera(String nombre, String tipo, int peso, int empuje, String combustible, int potencia, int altura);
    public void listarLanzadera(String tipo);
}
