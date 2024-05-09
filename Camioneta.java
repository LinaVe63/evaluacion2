
public class Camioneta extends Vehiculo {
    
    private boolean suv;
    private boolean pickup;
    private boolean carga;
    private boolean otro; 
    int numeroPasajeros;
    boolean tieneDosEjes;
    boolean mayorDosEjes;
    int pasajeros; 

    public Camioneta(String placa, String marca, double precio, int cilindraje, boolean suv, boolean pickup, boolean carga, boolean otro, int numeroPasajeros, boolean tieneDosEjes, boolean mayorDosEjes,int pasajeros) {
        super(placa, marca, precio, cilindraje); // Llama al constructor de la clase base Vehiculo
        this.suv = suv;
        this.pickup = pickup;
        this.carga = carga; 
        this.otro = otro;
        this.numeroPasajeros = numeroPasajeros;
        this.tieneDosEjes = tieneDosEjes;
        this.mayorDosEjes = mayorDosEjes;
        this.pasajeros = pasajeros;
                
    }

    // Sobrescribe el método calcularImpuestoCirculacion de la clase Vehiculo
    @Override
    public void calcularImpuestoCirculacion() {
        double impuestoBase = getPrecio() * 0.02; // Cálculo del 2% del precio del auto
        double impuestoCamioneta = getPrecio() * 0.03; // Cálculo del 3% adicional para completar el 5%
            setImpuestoCirculacion(impuestoBase + impuestoCamioneta); // Total impuesto circulacion Camioneta

        }
    }

    // Método cuota mes garaje según numero de ejes de la Camioneta
    public void cuotaMesGaraje() {
         double cuotaBase = getcuotaMesGaraje(); // Obtiene la cuota actual
         
         if (tieneDosEjes) {
             double cuotaTieneDosEjes = cuotaBase * 0.75; // Cálculo del 75% de la cuota base
             setcuotaMesGaraje(cuotaBase + cuotaTieneDosEjes ); // Total coutaMesGaraje -CON dos ejes
         } else if (mayorDosEjes) {
            double cuotaMayorDosEjes = cuotaBase * 1.0; // Cálculo del 100% de la cuota base
            setcuotaMesGaraje(cuotaBase + cuotaMayorDosEjes ); // Total coutaMesGaraje -CON mas de dos ejes
         } else {
             setcuotaMesGaraje(cuotaBase); // Total coutaMesGaraje menos de dos ejes
         }
     }
}

