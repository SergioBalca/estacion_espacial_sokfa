package dominio;

public abstract class NaveEspacial {
    // se definen los atributos que comparten todos los tipos de naves o, por los menos, dos de ellas
    private String nombre;
    private String tipo;
    private int peso;
    private int empuje;
    private String combustible;

    // se definen los constructores, utilizando el concepto de sobrecarga de constructores

    public NaveEspacial(){

    }
    public NaveEspacial(String nombre, String tipo, int peso){
        this.nombre = nombre;
        this.tipo = tipo;
        this.peso = peso;
    }

    public NaveEspacial(String nombre, String tipo, int peso, int empuje, String combustible){
        this.nombre = nombre;
        this.tipo = tipo;
        this.peso = peso;
        this.empuje = empuje;
        this.combustible = combustible;
    }

    // se definen los métodos get y set para cada atributo
    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getTipo(){
        return this.tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public int getPeso(){
        return this.peso;
    }

    public void setPeso(int peso){
        this.peso = peso;
    }

    public int getEmpuje(){
        return this.empuje;
    }

    public void setEmpuje(int empuje){
        this.empuje = empuje;
    }

    public String getCombustible(){
        return this.combustible;
    }

    public void setCombustible(String combustible){
        this.combustible = combustible;
    }


    // se define el metodo toString para imprimir los atributos de la nave espacial
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("NaveEspacial{").append("Nombre: ").append(this.nombre).append(", ").
                append("Tipo: ").append(this.tipo).append(", ").append("peso: ").append(this.peso).
                append(", ").append("empuje: ").append(this.empuje).append(", ").append("combustible: ").
                append(this.combustible).append(", ");
        return sb.toString();
    }


}
