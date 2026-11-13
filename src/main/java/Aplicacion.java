import java.util.Scanner;
public class Aplicacion {
    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n======        MENU        ======");
            System.out.println("     ======= CINEMAUQ =======     ");


            System.out.println("\n--- Escoja una de las siguientes opciones:  ---");

            System.out.println("1.  Venta de entrada");
            System.out.println("2. Cancelar venta ");
            System.out.println("3.  Consultar películas");
            System.out.println("4.  Consultar funciones");
            System.out.println("5.  Consultar disponibilidad");
            System.out.println("6.  Administrar películas");
            System.out.println("7.  Administrar funciones");
            System.out.println("8.  Administrar salas");
            System.out.println("9.  Generar reportes");
            System.out.println("10. Salir");



            System.out.print("\nSeleccione la opción: ");
            opcion = sc.nextInt();
            sc.nextLine();


            switch (opcion) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;

                case 6:
                    int opPeliculas;
                    do {
                        System.out.println("\n--- ADMINISTRAR PELÍCULAS ---");
                        System.out.println("1. Registrar película");
                        System.out.println("2. Buscar película");
                        System.out.println("3. Modificar película");
                        System.out.println("4. Deshabilitar película");
                        System.out.println("0. Volver");
                        System.out.print("Opción: ");
                        opPeliculas = sc.nextInt();
                        sc.nextLine();

                        switch (opPeliculas) {
                            case 1:
                                System.out.print("Código: ");
                                String codigoReg = sc.nextLine();

                                if (cine.verificarPelicula(codigoReg)) {
                                    System.out.println("Ya existe una película con ese código");
                                    break;
                                }

                                System.out.print("Nombre: ");
                                String nombreReg = sc.nextLine();

                                System.out.println("Género:");
                                for (int i = 0; i < Genero.values().length; i++) {
                                    System.out.println((i + 1) + ". " + Genero.values()[i]);
                                }
                                System.out.print("Opción: ");
                                Genero generoReg = Genero.values()[sc.nextInt() - 1];

                                System.out.print("Duración en minutos: ");
                                int duracionReg = sc.nextInt();
                                sc.nextLine();

                                System.out.println("Clasificación:");
                                for (int i = 0; i < Clasificacion.values().length; i++) {
                                    System.out.println((i + 1) + ". " + Clasificacion.values()[i]);
                                }
                                System.out.print("Opción: ");
                                Clasificacion clasificacionReg = Clasificacion.values()[sc.nextInt() - 1];
                                sc.nextLine();

                                Pelicula nueva = new Pelicula(cine, codigoReg, nombreReg, generoReg, duracionReg,
                                        clasificacionReg, EstadoPelicula.DISPONIBLE);
                                cine.registrarPelicula(nueva);
                                System.out.println("Película registrada");
                                break;

                            case 2:
                                System.out.println("1. Buscar por código");
                                System.out.println("2. Ver todas las películas");
                                System.out.print("Opción: ");
                                int opBuscar = sc.nextInt();
                                sc.nextLine();

                                switch (opBuscar) {
                                    case 1:
                                        System.out.print("Código: ");
                                        String codigoBus = sc.nextLine();
                                        if (cine.verificarPelicula(codigoBus)) {
                                            System.out.println(cine.buscarPelicula(codigoBus));
                                        } else {
                                            System.out.println("No existe una película con ese código");
                                        }
                                        break;
                                    case 2:
                                        cine.consultarPeliculasDisponibles();
                                        break;
                                    default:
                                        System.out.println("Opción inválida");
                                        break;
                                }
                                break;

                            case 3:
                                System.out.print("Código de la película a modificar: ");
                                String codigoMod = sc.nextLine();

                                if (!cine.verificarPelicula(codigoMod)) {
                                    System.out.println("No existe una película con ese código");
                                    break;
                                }

                                System.out.print("Nuevo nombre: ");
                                String nombreMod = sc.nextLine();

                                System.out.println("Nuevo género:");
                                for (int i = 0; i < Genero.values().length; i++) {
                                    System.out.println((i + 1) + ". " + Genero.values()[i]);
                                }
                                System.out.print("Opción: ");
                                Genero generoMod = Genero.values()[sc.nextInt() - 1];

                                System.out.print("Nueva duración en minutos: ");
                                int duracionMod = sc.nextInt();
                                sc.nextLine();

                                System.out.println("Nueva clasificación:");
                                for (int i = 0; i < Clasificacion.values().length; i++) {
                                    System.out.println((i + 1) + ". " + Clasificacion.values()[i]);
                                }
                                System.out.print("Opción: ");
                                Clasificacion clasificacionMod = Clasificacion.values()[sc.nextInt() - 1];
                                sc.nextLine();

                                cine.modificarPelicula(codigoMod, nombreMod, generoMod, duracionMod, clasificacionMod);
                                System.out.println("Película modificada");
                                break;

                            case 4:
                                System.out.print("Código de la película a deshabilitar: ");
                                String codigoDes = sc.nextLine();

                                if (!cine.verificarPelicula(codigoDes)) {
                                    System.out.println("No existe una película con ese código");
                                    break;
                                }

                                cine.deshabilitarPelicula(codigoDes);
                                System.out.println("Película deshabilitada");
                                break;

                            case 0:
                                System.out.println("Volviendo al menú principal...");
                                break;

                            default:
                                System.out.println("Opción inválida");
                                break;
                        }
                    } while (opPeliculas != 0);
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:

                    System.out.println("Programa finalizado.....");
                    break;
                default:
                    System.out.println( "\u001B[31m Opción no válida.\u001B[0m");
                    break;




            }



        }while(opcion != 0);



        }
}
