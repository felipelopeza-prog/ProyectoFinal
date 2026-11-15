import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
public class Aplicacion {
    private static Empleado empleadoActual = null;

    public static void main (String [] args){

        Cine cine = new Cine("CINEMAUQ", "900.123.456-1");
        //Peliculas que hay

        Pelicula p1 = new Pelicula(cine, "P1", "Interestelar", GeneroPelicula.CIENCIA_FICCION, 169, Clasificacion.ADOLESCENTES, EstadoPelicula.DISPONIBLE);
        Pelicula p2 = new Pelicula(cine, "P2", "Coco", GeneroPelicula.MUSICAL, 105, Clasificacion.NINIOS, EstadoPelicula.DISPONIBLE);
        Pelicula p3 = new Pelicula(cine, "P3", "El Conjuro", GeneroPelicula.TERROR, 112, Clasificacion.ADULTOS, EstadoPelicula.DISPONIBLE);
        Pelicula p4 = new Pelicula(cine, "P4", "Toy Story", GeneroPelicula.COMEDIA, 81, Clasificacion.NINIOS, EstadoPelicula.NO_DISPONIBLE);
        cine.registrarPelicula(p1);
        cine.registrarPelicula(p2);
        cine.registrarPelicula(p3);
        cine.registrarPelicula(p4);

        //Salas que hay
        Sala s1 = new Sala(cine, "S1", 1, 4, 5);
        Sala s2 = new Sala(cine, "S2", 2, 5, 6);
        Sala s3 = new Sala(cine, "S3", 3, 3, 4);
        cine.registrarSala(s1);
        cine.registrarSala(s2);
        cine.registrarSala(s3);
        cine.deshabilitarSala("S3");





        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\n======        MENU        ======");
            System.out.println("     ======= CINEMAUQ =======     ");


            System.out.println("\n--- Escoja una de las siguientes opciones:  ---");

            System.out.println("1.  Venta de entrada");
            System.out.println("2.  Cancelar venta");
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
                    System.out.println("\n--- MÓDULO DE VENTA DE ENTRADAS ---");

                    if (empleadoActual == null) {
                        System.out.print("Ingrese la identificación del empleado actual: ");
                        String idEmp = sc.nextLine();
                        empleadoActual = cine.buscarEmpleado(idEmp);

                        if (empleadoActual == null) {
                            System.out.println("Error: Empleado no encontrado en el sistema.");
                            break;
                        }
                    }

                    System.out.print("Ingrese identificación del cliente: ");
                    String identificacionCliente = sc.nextLine();

                    System.out.print("Ingrese nombre del cliente: ");
                    String nombreCliente = sc.nextLine();

                    System.out.println("Seleccione Tipo Cliente (1. GENERAL, 2. ESTUDIANTE, 3. NINO, 4. ADULTO_MAYOR): ");
                    int tipoOpcion = Integer.parseInt(sc.nextLine());

                    TipoCliente tipoCliente = TipoCliente.GENERAL;
                    if (tipoOpcion == 2) tipoCliente = TipoCliente.ESTUDIANTE;
                    else if (tipoOpcion == 3) tipoCliente = TipoCliente.NINO;
                    else if (tipoOpcion == 4) tipoCliente = TipoCliente.ADULTO_MAYOR;

                    System.out.print("Ingrese el código de la función: ");
                    String codigoFuncion = sc.nextLine();

                    System.out.print("Ingrese el código del asiento (ej. A1): ");
                    String codigoAsiento = sc.nextLine();

                    String codVenta = "V-" + System.currentTimeMillis();

                    Venta nuevaVenta = cine.venderEntrada(codVenta, identificacionCliente, nombreCliente, tipoCliente,
                            codigoFuncion, codigoAsiento, empleadoActual
                    );

                    System.out.println("\n¡Venta realizada con éxito!");
                    System.out.println("Código de Venta: " + nuevaVenta.getCodigo());
                    System.out.println("Valor Pagado: $" + nuevaVenta.getValorPagado());
                    break;
                case 2:
                    System.out.println("\n--- MÓDULO DE CANCELACIÓN DE VENTA ---");
                    System.out.print("Ingrese el código de la venta que desea cancelar: ");
                    String codigoVentaCancelar = sc.nextLine();

                    cine.cancelarVenta(codigoVentaCancelar);
                    break;
                case 3:
                    System.out.println("\n--- MÓDULO DE CONSULTA DE PELÍCULAS ---");
                    System.out.println("1. Ver películas disponibles");
                    System.out.println("2. Buscar película por código");
                    System.out.print("Seleccione una opción: ");

                    int opcionPelicula = Integer.parseInt(sc.nextLine());

                    if (opcionPelicula == 1) {
                        System.out.println("\n--- LISTADO DE PELÍCULAS DISPONIBLES ---");
                        cine.consultarPeliculasDisponibles();

                    } else if (opcionPelicula == 2) {
                        System.out.print("Ingrese el código de la película: ");
                        String codigoPeli = sc.nextLine();

                        Pelicula peliculaEncontrada = cine.buscarPelicula(codigoPeli);
                        if (peliculaEncontrada != null) {
                            System.out.println("\n¡Película encontrada!");
                            System.out.println(peliculaEncontrada.toString());
                        } else {
                            System.out.println("No se encontró ninguna película con el código ingresado.");
                        }
                    } else {
                        System.out.println("Opción inválida.");
                    }
                    break;
                case 4:
                    break;
                case 5:
                    break;

                case 6: {
                    //Administrar peliculas
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
                                for (int i = 0; i < GeneroPelicula.values().length; i++) {
                                    System.out.println((i + 1) + ". " + GeneroPelicula.values()[i]);
                                }
                                System.out.print("Opción: ");
                                GeneroPelicula generoReg = GeneroPelicula.values()[sc.nextInt() - 1];

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
                                for (int i = 0; i < GeneroPelicula.values().length; i++) {
                                    System.out.println((i + 1) + ". " + GeneroPelicula.values()[i]);
                                }
                                System.out.print("Opción: ");
                                GeneroPelicula generoMod = GeneroPelicula.values()[sc.nextInt() - 1];

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
                                System.out.println("Opción no válida");
                                break;
                        }
                    } while (opPeliculas != 0);
                    break;
                }
                case 7: {
                    int opFunciones;
                    do {
                        System.out.println("\n--- ADMINISTRAR FUNCIONES ---");
                        System.out.println("1. Programar función");
                        System.out.println("2. Modificar función");
                        System.out.println("3. Cancelar función");
                        System.out.println("0. Volver");
                        System.out.print("Opción: ");
                        opFunciones = sc.nextInt();
                        sc.nextLine();

                        switch (opFunciones) {
                            case 1:
                                System.out.print("Código de la función: ");
                                String codigoProg = sc.nextLine();
                                if (cine.verificarFuncion(codigoProg)) {
                                    System.out.println("Ya existe una función con ese código");
                                    break;
                                }

                                System.out.print("Código de la película: ");
                                String codigoPelProg = sc.nextLine();
                                if (!cine.verificarPelicula(codigoPelProg)) {
                                    System.out.println("No existe una película con ese código");
                                    break;
                                }
                                Pelicula peliculaProg = cine.buscarPelicula(codigoPelProg);
                                if (!peliculaProg.verificarDisponibilidad()) {
                                    System.out.println("La película no está disponible");
                                    break;
                                }

                                System.out.print("Código de la sala: ");
                                String codigoSalaProg = sc.nextLine();
                                if (!cine.verificarSala(codigoSalaProg)) {
                                    System.out.println("No existe una sala con ese código");
                                    break;
                                }
                                Sala salaProg = cine.buscarSala(codigoSalaProg);
                                if (salaProg.getEstadoSala() != EstadoSala.DISPONIBLE) {
                                    System.out.println("La sala está fuera de servicio");
                                    break;
                                }
                                if (salaProg.getColeccionAsientos().isEmpty()) {
                                    System.out.println("La sala no tiene asientos registrados");
                                    break;
                                }
                                Asiento asientoProg = salaProg.getColeccionAsientos().get(0);

                                System.out.print("Año: ");
                                int anioProg = sc.nextInt();
                                System.out.print("Mes (1-12): ");
                                int mesProg = sc.nextInt();
                                System.out.print("Día: ");
                                int diaProg = sc.nextInt();
                                System.out.print("Hora (0-23): ");
                                int horaNumProg = sc.nextInt();
                                System.out.print("Minutos: ");
                                int minutosProg = sc.nextInt();
                                System.out.print("Valor base: ");
                                double valorProg = sc.nextDouble();
                                sc.nextLine();

                                LocalDate fechaProg = LocalDate.of(anioProg, mesProg, diaProg);
                                LocalTime horaProg = LocalTime.of(horaNumProg, minutosProg);

                                Funcion nuevaFuncion = new Funcion(asientoProg, cine, peliculaProg, salaProg,
                                        codigoProg, fechaProg, horaProg, valorProg, EstadoFuncion.PROGRAMADA);
                                if (cine.registrarFuncion(nuevaFuncion)) {
                                    System.out.println("Función programada");
                                }
                                break;

                            case 2:
                                System.out.print("Código de la función a modificar: ");
                                String codigoModF = sc.nextLine();
                                if (!cine.verificarFuncion(codigoModF)) {
                                    System.out.println("No existe una función con ese código");
                                    break;
                                }
                                Funcion funcionModF = cine.buscarFuncion(codigoModF);
                                if (funcionModF.getEstadoFuncion() != EstadoFuncion.PROGRAMADA) {
                                    System.out.println("Solo se pueden modificar funciones programadas");
                                    break;
                                }

                                System.out.print("Código de la nueva película: ");
                                String codigoPelModF = sc.nextLine();
                                if (!cine.verificarPelicula(codigoPelModF)) {
                                    System.out.println("No existe una película con ese código");
                                    break;
                                }
                                Pelicula peliculaModF = cine.buscarPelicula(codigoPelModF);
                                if (!peliculaModF.verificarDisponibilidad()) {
                                    System.out.println("La película no está disponible");
                                    break;
                                }

                                System.out.print("Nuevo año: ");
                                int anioModF = sc.nextInt();
                                System.out.print("Nuevo mes (1-12): ");
                                int mesModF = sc.nextInt();
                                System.out.print("Nuevo día: ");
                                int diaModF = sc.nextInt();
                                System.out.print("Nueva hora (0-23): ");
                                int horaNumModF = sc.nextInt();
                                System.out.print("Nuevos minutos: ");
                                int minutosModF = sc.nextInt();
                                System.out.print("Nuevo valor base: ");
                                double valorModF = sc.nextDouble();
                                sc.nextLine();

                                LocalDate fechaModF = LocalDate.of(anioModF, mesModF, diaModF);
                                LocalTime horaModF = LocalTime.of(horaNumModF, minutosModF);

                                cine.modificarFuncion(codigoModF, peliculaModF, fechaModF, horaModF, valorModF);
                                System.out.println("Función modificada");
                                break;

                            case 3:
                                System.out.print("Código de la función a cancelar: ");
                                String codigoCanF = sc.nextLine();
                                if (!cine.verificarFuncion(codigoCanF)) {
                                    System.out.println("No existe una función con ese código");
                                    break;
                                }
                                Funcion funcionCanF = cine.buscarFuncion(codigoCanF);
                                if (funcionCanF.getEstadoFuncion() == EstadoFuncion.CANCELADA) {
                                    System.out.println("La función ya está cancelada");
                                    break;
                                }

                                cine.cancelarFuncion(codigoCanF);
                                break;

                            case 0:
                                System.out.println("Volviendo al menú principal...");
                                break;

                            default:
                                System.out.println("Opción no válida");
                                break;
                        }
                    } while (opFunciones != 0);
                    break;
                }
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
