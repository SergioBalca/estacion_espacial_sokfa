package presentacion;

import negocio.*;

import java.util.Scanner;

public class EstacionEspacial {
    public static void main(String[] args) {
        int opcion = -1;
        int opcion2;
        int opcion3;
        int opcion4;
        String nombre;
        String tipo;
        int peso;
        int empuje;
        String combustible;
        int potencia;
        int altura;
        int velocidad;
        int distanciaOrbitacion;
        int numeroTripulantes;

        Scanner consola = new Scanner(System.in);
        ILanzaderaInvetario invetario = new LanzaderaInventarioImp(); // para acceder a los metodos para crear y listar las naves
        INoTripuladaInventario inventario2 = new NoTripuladaInventarioImp();
        ITripuladaInventario inventario3 = new TripuladaInventarioImp();
        String tipoNave;

        // se define el ciclo infinito, hasta que el usuario elige la opcion 0 para salir del programa
        while(opcion != 0){
            System.out.println("Por favor Elija la opción: \n"
                    + "1. Agregar nave espacial\n"
                    + "2. Listar naves espaciales\n"
                    + "3. Buscar nave espacial\n"
                    + "0. salir");

            opcion = Integer.parseInt(consola.nextLine()); // para convertir consola.nextLine a int

            switch (opcion){
                case 0:
                    System.out.println("Hasta pronto!!!");
                    break;
                case 1:
                    System.out.println("Por favor elija el tipo de nave a crear\n"
                            + "1. Lanzadera\n"
                            + "2. No tripulada\n"
                            + "3. Tripulada");
                    opcion2 = Integer.parseInt(consola.nextLine());

                    switch (opcion2){
                        case 1:
                            System.out.println("Por favor ingrese las caracteristicas de la nave tipo lanzadera, separados por coma:\n"

                                    + "Nombre\n"
                                    + "peso\n"
                                    + "tipo\n"
                                    + "empuje\n"
                                    + "combustible\n"
                                    + "potencia\n"
                                    + "altura\n");

                            String[] arrStr = consola.nextLine().split(",", 0); // para tomar cada atributo de la linea de comandos

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
                        case 2:
                            System.out.println("Por favor ingrese las caracteristicas de la nave tipo No Tripulada, separdas por coma:\n"
                                    + "Nombre\n"
                                    + "peso\n"
                                    + "tipo\n"
                                    + "empuje\n"
                                    + "combustible\n"
                                    + "velocidad\n");
                            String[] arrStr2 = consola.nextLine().split(",", 0);

                            nombre = arrStr2[0];
                            peso = Integer.parseInt(arrStr2[1]);
                            tipo = arrStr2[2];
                            empuje = Integer.parseInt(arrStr2[3]);
                            combustible = arrStr2[4];
                            velocidad = Integer.parseInt(arrStr2[5]);

                            inventario2.agregarNoTripulada(nombre, tipo, peso, empuje, combustible, velocidad);
                            System.out.println("Se ha creado la nave " + nombre);
                            break;
                        case 3:
                            System.out.println("Por favor ingrese las caracteristicas de la nave tipo Tripulada, separadas por coma\n"
                                    + "nombre\n"
                                    + "peso\n"
                                    + "tipo\n"
                                    + "distancia orbitacion\n"
                                    + "numero tripulantes\n");
                            String[] arrStr3 = consola.nextLine().split(",", 0);

                            nombre = arrStr3[0];
                            peso = Integer.parseInt(arrStr3[1]);
                            tipo = arrStr3[2];
                            distanciaOrbitacion = Integer.parseInt(arrStr3[3]);
                            numeroTripulantes = Integer.parseInt(arrStr3[4]);

                            inventario3.agregarTripulada(nombre, tipo, peso, distanciaOrbitacion, numeroTripulantes);
                            System.out.println("Se ha creado la nava " + nombre);
                            break;

                    }
                    break;
                case 2:
                    System.out.println("Por favor elija el tipo de nave a listar\n"
                            + "1. Lanzadera\n"
                            + "2. No tripulada\n"
                            + "3. Tripulada");
                    opcion3 = Integer.parseInt(consola.nextLine());

                    switch (opcion3) {
                        case 1:
                            invetario.listarLanzadera();
                            break;
                        case 2:
                            inventario2.listarNoTripulada();
                            break;
                        case 3:
                            inventario3.listarTripulada();
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Por favor seleccione el tipo de la nave a buscar\n"
                            + "1. Lanzadera\n"
                            + "2. No tripulada\n"
                            + "3. Tripulada\n");
                    opcion4 = Integer.parseInt(consola.nextLine());
                    switch (opcion4){
                        case 1:
                            System.out.println("Por favor ingrese el nombre de la nave");
                            String nombreNave = consola.nextLine();
                            invetario.buscarLanzadera(nombreNave);
                            break;
                        case 2:
                            System.out.println("Por favor ingrese el nombre de la nave");
                            String nombreNavent = consola.nextLine();
                            inventario2.buscarNoTripulada(nombreNavent);
                            break;
                        case 3:
                            System.out.println("Por favor ingrese el nombre de la nave");
                            String nombreNavet = consola.nextLine();
                            inventario3.buscarTripulada(nombreNavet);
                            break;
                    }
                    break;

            }
        }

    }
}
