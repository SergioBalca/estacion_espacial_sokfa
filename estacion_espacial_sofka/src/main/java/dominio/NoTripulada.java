package dominio;

public class NoTripulada extends NaveEspacial {
    // se definen los atributos propios de la nave tipo NoTripulada
    private int idNoTripulada;
    private int velocidad;

    // constructor vacio
    public NoTripulada(){

    }

    // constructor para inicializar los atributos de la clase NaveEspacial y velocidad
    public NoTripulada(String nombre, String tipo, int peso, int empuje, String combustible, int velocidad){
        super(nombre, tipo, peso, empuje, combustible);
        this.velocidad = velocidad;
    }

    // getter y setter para atributo velocidad
    public int getVelocidad(){
        return this.velocidad;
    }

    public void setVelocidad(int velocidad){
        this.velocidad = velocidad;
    }

    // metodo toString para imprimir atributos de la nave tipo NoTripulada
    @Override
    public String toString(){
        return super.toString() + "velocidad: " + this.velocidad + "}";
    }
}
