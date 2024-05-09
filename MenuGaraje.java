
import java.util.Scanner;

public class MenuGaraje {

    public static void main(String[] args) {
        Garaje garaje = new Garaje();
        try (Scanner scanner = new Scanner(System.in)) {
            int opcion;

            do {
                System.out.println("Menú de gestión del Garaje:");
                System.out.println("1. Alquilar un espacio");
                System.out.println("2. Retirar vehículo");
                System.out.println("3. Consulta de ingresos mensuales");
                System.out.println("4. Consulta proporción autos / motos");
                System.out.println("5. Listado de matrículas y cuota mensual y tipo de vehículo");
                System.out.println("6. Cantidad de camionetas en el garaje");
                System.out.println("7. Salir");
                System.out.print("Ingrese la opción deseada: ");

                opcion = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcion) {

                    case 1 -> {
                        //Alquilar un espacio
                        System.out.println("Para alquilar un espacio, ingrese los siguientes datos:");
                        System.out.print("Placa del vehículo (6 caracteres): ");
                        String placa = scanner.nextLine();
                        System.out.print("Marca del vehículo: ");
                        String marca = scanner.nextLine();
                        System.out.print("Precio del vehículo: ");
                        double precio = scanner.nextDouble();
                        System.out.print("Cilindraje del vehículo: ");
                        int cilindraje = scanner.nextInt();
                        scanner.nextLine(); 

                        System.out.println("Seleccione el tipo de vehículo:");
                        System.out.println("1. Auto");
                        System.out.println("2. Moto");
                        System.out.println("3. Camioneta");
                        int tipoVehiculo = scanner.nextInt();
                        scanner.nextLine(); 

                        if (tipoVehiculo == 1) {
                            System.out.print("¿Tiene radio? (true/false): ");
                            boolean tieneRadio = scanner.nextBoolean();
                            System.out.print("¿Tiene navegador? (true/false): ");
                            boolean tieneNavegador = scanner.nextBoolean();

                            Auto auto = new Auto(placa, marca, precio, cilindraje, tieneRadio, tieneNavegador);
                            garaje.agregarVehiculo(auto);
                            System.out.println("Espacio alquilado correctamente.");

                        } else if (tipoVehiculo == 2) {
                            System.out.print("¿Tiene sidecar? (true/false): ");
                            boolean tieneSidecar = scanner.nextBoolean();

                            Moto moto = new Moto(placa, marca, precio, cilindraje, tieneSidecar);
                            garaje.agregarVehiculo(moto);
                            System.out.println("Espacio alquilado correctamente.");
                            
                         } else if (tipoVehiculo ==3) {
                            System.out.print("Indique el tipo de Camioneta: ");
                            System.out.print("¿Es una SUV? (true/false): ");
                            boolean suv = scanner.nextBoolean();
                            System.out.print("¿Es una pickup? (true/false): ");
                            boolean pickup = scanner.nextBoolean();
                            System.out.print("¿Es de carga? (true/false): ");
                            boolean carga = scanner.nextBoolean();
                            System.out.print("¿Otro? (true/false): ");
                            boolean otro = scanner.nextBoolean();
                            
        
                            System.out.print("Indique la catidad de pasajeros: ");
                            int pasajeros = scanner.nextint();
                            if (pasajeros > 2){
                            System.out.print("su vehiculo es diferente de pickup y carga");
                            }   
                            
                            System.out.print("¿Tiene dos ejes? (true/false): ");
                            boolean tieneDosEjes = scanner.nextBoolean();
                            System.out.print("¿Tiene menos de dos ejes? (true/false): ");
                            double cuotaBase = getcuotaMesGaraje();                            
                            System.out.print("¿Tiene mas de dos ejes? (true/false): ");                            
                            
                            System.out.print("Indique la catidad de ejes: ");
                            System.out.print("¿Tiene dos ejes? (true/false): ");
                            boolean tieneDosEjes = scanner.nextBoolean();
                            System.out.print("¿Tiene menos de dos ejes? (true/false): ");
                            double cuotaBase = getcuotaMesGaraje();                            
                            System.out.print("¿Tiene mas de dos ejes? (true/false): ");
                            boolean mayorDosEjes = scanner.nextBoolean();
                            
                            Auto Camioneta = new Auto (String placa, String marca, double precio, int cilindraje, boolean suv, boolean pickup, boolean carga, boolean otro, int numeroPasajeros, boolean tieneDosEjes, boolean mayorDosEjes,int pasajeros);
                            garaje.agregarVehiculo(Camioneta);
                            System.out.println("Espacio alquilado correctamente.");                            
                         }
                        }
                    }

                    case 2 -> {
                        // Retirar vehículo
                        System.out.println("Ingrese la placa del vehículo a retirar:");
                        String placaRetirar = scanner.nextLine();

                        boolean vehiculoRetirado = false;

                        // Buscar y retirar el vehículo con la placa ingresada
                        for (int i = 0; i < garaje.espacios.length; i++) {
                            Vehiculo vehiculo = garaje.espacios[i];
                            if (vehiculo != null && vehiculo.getPlaca().equals(placaRetirar)) {
                                garaje.espacios[i] = null; // Liberar el vehiculo del espacio

                                // Actualizar contadores 
                                if (vehiculo instanceof Auto) {
                                    garaje.contadorAutos--;
                                } else if (vehiculo instanceof Moto) {
                                    garaje.contadorMotos--;
                                } else {
                                    garaje.contadorCamioneta--;
                                }

                                vehiculoRetirado = true;
                                System.out.println("Vehículo retirado correctamente.");
                                break;
                            }
                        }

                        if (!vehiculoRetirado) {
                            System.out.println("No se encontró ningún vehículo con esa placa en el garaje.");
                        }
                    }

                    case 3 -> {
                        // Consulta de ingresos mensuales
                        double ingresosMensuales = garaje.calcularIngresos();
                        System.out.println("Los ingresos mensuales del garaje son: $" + ingresosMensuales);
                    }

                    case 4 -> {
                        // Consulta proporción autos / motos / camioneta
                        int totalAutos = garaje.calcularOcupacionPorTipoVehiculo(new Auto(null, null, 0, 0, false, false));
                        int totalMotos = garaje.calcularOcupacionPorTipoVehiculo(new Moto(null, null, 0, 0, false));
                        int totalCamionetas = garaje.calcularOcupacionPorTipoVehiculo(new Camioneta(null, null, 0, 0, false));
                        
                        if (totalAutos == 0 && totalMotos == 0 && totalCamionetas) {
                            System.out.println("No hay vehículos en el garaje.");
                        } else {
                            int proporcion;
                            if (totalMotos != 0) {
                                proporcion = totalAutos / totalMotos/ totalCamioneta; 
                            } else if (totalAutos != 0) {
                                proporcion = totalAutos;
                            }else{
                                proporcion = totalAutos / totalMotos/ totalCamioneta; 
                             }
                            System.out.println("Proporción de Autos / Motos / Camionetas en el garaje: " + proporcion);
                        }
                    }

                    case 5 -> {
                        // Listado de matrículas y cuota mensual y tipo de vehículo
                        System.out.println("Listado de matrículas y cuota mensual y tipo vehículo:");
                        boolean vehiculosEncontrados = false;
                        for (Vehiculo vehiculo : garaje.espacios) {
                            if (vehiculo != null) {
                                vehiculosEncontrados = true;
                                String tipoVehiculo;
                                if (vehiculo instanceof Auto) {
                                    tipoVehiculo = "Auto";
                                }else {
                                    tipoVehiculo = "Moto";
                                }
                                System.out.println("Placa: " + vehiculo.getPlaca() + " - Cuota mensual: $" + vehiculo.getcuotaMesGaraje() + " - Tipo: " + tipoVehiculo);
                            }
                        }
                        if (!vehiculosEncontrados) {
                            System.out.println("No hay vehículos en el garaje.");
                        }
                    }
                    
                    case 6 -> // Cantidad de camionetas en el garaje
                         if (totalAutos == 0 && totalMotos == 0 && totalCamionetas != null) {
                            int espaciosCamioneta = 0.1 * NUMERO_ESPACIOS;
                                if (espaciosCamioneta < contadorCamioneta) {
                                      System.out.println("Tiene un lugar en el garaje");
                                }else{
                                     System.out.println("No hay lugar para su camioneta");
                                }
            
                            System.out.println("El numero de camionetas en el garaje es: ");
                    
                    case 7 -> // Salir del programa
                        System.out.println("Saliendo del programa...");

                    default -> 
                        System.out.println("Digito incorrecto. Por favor, digite un número válido.");
                }

            } while (opcion != 6);
        }
}

    private static double getcuotaMesGaraje() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
