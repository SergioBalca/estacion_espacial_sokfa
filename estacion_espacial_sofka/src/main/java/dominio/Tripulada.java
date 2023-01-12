package dominio;

public class Tripulada extends NaveEspacial {
    // se definen los atributos propios de la nave tipo Tripulada
    private int idTripulada;
    private int distanciaOrbitacion;
    private int numeroTripulantes;

    // constructor vacio
    public Tripulada(){

    }


    // constructor para inicializar los atributos de la clase NaveEspacial y los propios del tipo Tripulada
    public Tripulada(String nombre, String tipo, int peso, int distancia_orbitacion, int numero_tripulantes){
        super(nombre, tipo, peso);
        this.distanciaOrbitacion = distanciaOrbitacion;
        this.numeroTripulantes = numero_tripulantes;
    }

    // getter y setter para cada atributo

    public int getDistanciaOrbitacion(){
        return this.distanciaOrbitacion;
    }

    public void setDistanciaOrbitacion(int distanciaOrbitacion){
        this.distanciaOrbitacion = distanciaOrbitacion;
    }

    public int getNumeroTripulantes(){
        return this.numeroTripulantes;
    }

    public void setNumeroTripulantes(int numeroTripulantes){
        this.numeroTripulantes = numeroTripulantes;
    }

    @Override
    public String toString(){
        return super.toString() + "id tripulada: " + this.idTripulada + ", " + "distancia orbitacion: " + this.distanciaOrbitacion + ", " +
                "numbero tripulantes: " + this.numeroTripulantes + "}";
    }


}
