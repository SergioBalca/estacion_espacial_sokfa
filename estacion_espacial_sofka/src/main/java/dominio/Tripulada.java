package dominio;

public class Tripulada extends NaveEspacial {
    // se definen los atributos propios de la nave tipo Tripulada
    private int distancia_orbitacion;
    private int numero_tripulantes;

    // constructor vacio
    public Tripulada(){

    }


    // constructor para inicializar los atributos de la clase NaveEspacial y los propios del tipo Tripulada
    public Tripulada(String nombre, String tipo, int peso, int distancia_orbitacion, int numero_tripulantes){
        super(nombre, tipo, peso);
        this.distancia_orbitacion = distancia_orbitacion;
        this.numero_tripulantes = numero_tripulantes;
    }

    // getter y setter para cada atributo

    public int getDistancia_orbitacion(){
        return this.distancia_orbitacion;
    }

    public void setDistancia_orbitacion(int distanciaOrbitacion){
        this.distancia_orbitacion = distanciaOrbitacion;
    }

    public int getNumero_tripulantes(){
        return this.numero_tripulantes;
    }

    public void setNumero_tripulantes(int numero_tripulantes){
        this.numero_tripulantes = numero_tripulantes;
    }

    @Override
    public String toString(){
        return super.toString() + "distancia orbitacion: " + this.distancia_orbitacion + ", " + "numbero tripulantes: " +
                this.numero_tripulantes + "}";
    }


}
