package dominio;

public class Lanzadera extends NaveEspacial {
    private int idLanzadera;
    private int potencia;
    private int altura;

    public Lanzadera(){

    }

    // constructor para inicializar los atributos de la clase NaveEspacial y los propios de la tipo Lanzadera

    public Lanzadera(String nombre, String tipo, int peso, int empuje, String combustible, int potencia, int altura){
        super(nombre, tipo, peso, empuje, combustible); // con super se inicializan los atributos de la clase NaveEspacial
        this.potencia = potencia;
        this.altura = altura;
    }

    // se definen los getter y setter para los atributos

    public int getIdLanzadera(){
        return this.idLanzadera;
    }

    public void setIdLanzadera(int idLanzadera){
        this.idLanzadera = idLanzadera;
    }
     public int getPotencia(){
        return this.potencia;
     }

     public void setPotencia(int potencia){
        this.potencia = potencia;
     }

     public int getAltura(){
        return this.altura;
     }

     public void setAltura(int altura){
        this.altura = altura;
     }

     // metodo toString para imprimir atributos nave tipo Lanzadera

     @Override
     public String toString(){
        return super.toString() + "id nave: " + this.idLanzadera + ", " + "potencia: " + this.potencia + ", " + "altura: " + this.altura + "}";
     }
}
