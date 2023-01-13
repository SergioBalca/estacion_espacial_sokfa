package presentacion;

import negocio.ILanzaderaInvetario;
import negocio.LanzaderaInvenarioImp;

import java.util.Scanner;

public class EstacionEspacial {
    public static void main(String[] args) {
        int opcion = -1;
        int opcion2;
        String nombre;
        String tipo;
        int peso;
        int empuje;
        String combustible;
        int potencia;
        int altura;
        Scanner consola = new Scanner(System.in);
        ILanzaderaInvetario invetario = new LanzaderaInvenarioImp(); // para acceder a los metodos implementados en esta clase
        String tipoNave;

        // se define el ciclo infinito, hasta que el usuario elige la opcion 0 para salir del programa
        while(opcion != 0){
            System.out.println("Por favor Elija la opción: \n"
                    + "1. Agregar nave espacial\n"
                    + "2. Listar naves espaciales"
                    + "3. Buscar nave espacial\n"
                    + "0. salir");

            opcion = Integer.parseInt(consola.nextLine()); // para convertir consola.nextLine a int

            switch (opcion){
                case 0:
                    System.out.println("Hasta pronto!!!");
                    break;
                case 1:
                    System.out.println("Por favor elija el tipo de nave a crear\n"
                            + "4. Lanzadera\n"
                            + "5. No tripulada\n"
                            + "6. Tripulada");
                    opcion2 = Integer.parseInt(consola.nextLine());

                    switch (opcion2){
                        case 4:
                            + "Nombre\n"
                                    + "peso\n"
                                    + "tipo\n"
                                    + "empuje\n"
                                    + "combustible\n"
                            System.out.println("Por favor ingrese las caracteristicas de la nave tipo lanzadera, separados por coma:\n"

                                    + "potencia\n"
                                    + "altura\n");

                            String[] arrStr = consola.nextLine().split(",", 0);

                            nombre = arrStr[0];
                            peso = Integer.parseInt(arrStr[1]);
                            tipo = arrStr[2];
                            empuje = Integer.parseInt(arrStr[3]);
                            combustible = arrStr[4];
                            potencia = Integer.parseInt(arrStr[5]);
                            altura = Integer.parseInt(arrStr[6]);

                            invetario.agregarLanzadera(nombre, tipo, peso, empuje, combustible, potencia, altura);
                            System.out.println("se ha creado la nave espacial " + nombre);
                            break;
                    }
            }
        }

    }
}
