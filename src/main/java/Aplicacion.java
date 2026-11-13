import java.util.Scanner;
public class Aplicacion {
    private static Empleado empleadoActual = null;

    public static void main (String [] args){

        Cine cine = new Cine("CINEMAUQ", "900.123.456-1");

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


            switch (opcion){
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
                    String idCliente = sc.nextLine();

                    System.out.print("Ingrese nombre del cliente: ");
                    String nombreCliente = sc.nextLine();

                    System.out.println("Seleccione Tipo Cliente (1. GENERAL, 2. ESTUDIANTE, 3. NINO, 4. ADULTO_MAYOR): ");
                    int tipoOp = Integer.parseInt(sc.nextLine());

                    TipoCliente tipoCliente = TipoCliente.GENERAL;
                    if (tipoOp == 2) tipoCliente = TipoCliente.ESTUDIANTE;
                    else if (tipoOp == 3) tipoCliente = TipoCliente.NINO;
                    else if (tipoOp == 4) tipoCliente = TipoCliente.ADULTO_MAYOR;

                    System.out.print("Ingrese el código de la función: ");
                    String codFunc = sc.nextLine();

                    System.out.print("Ingrese el código del asiento (ej. A1): ");
                    String codAsiento = sc.nextLine();

                    String codVenta = "V-" + System.currentTimeMillis();

                    Venta nuevaVenta = cine.venderEntrada(codVenta, idCliente, nombreCliente, tipoCliente,
                            codFunc, codAsiento, empleadoActual
                    );

                    System.out.println("\n¡Venta realizada con éxito!");
                    System.out.println("Código de Venta: " + nuevaVenta.getCodigo());
                    System.out.println("Valor Pagado: $" + nuevaVenta.getValorPagado());
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
