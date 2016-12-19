import java.util.Scanner;
/**
 * Clase GestorHospital: permet provar el comportament de les classes
 * {@link Hospital} i {@link Pacient}. 
 * 
 * @author IIP
 * @version Curs 2016/17
 */
public class GestorHospital {    
    /**
     * Metode estatic que mostra per pantalla un menu amb les operacions que
     * es poden realitzar en un hospital.
     * @param t {@code Scanner}.
     * @return {@code int}, l'opcio triada.
     */
    private static int menu(Scanner t) {
        int opc;
        do {
            System.out.println("\n********* HOSPITAL **********");
            System.out.println(" 1. Ingresos");
            System.out.println(" 2. Altes");
            System.out.println(" 3. Visualitzacio");
            System.out.println(" 4. Pacients critics");
            System.out.println(" 0. Acabar");
            System.out.println("*****************************");
            System.out.print("Tria una opcio: ");
            opc = t.nextInt();
            t.nextLine();
            if (opc < 0 || opc > 4) {
                System.out.println("\nOpcio incorrecta.\n");
            }
        } while (opc < 0 || opc > 4);
        return opc;
    }
    
    /**
     * Metode {@code main()} pel qual comença l'execucio de 
     * les proves sobre la classe {@link Hospital}.
     * @param args {@code String[]}.
     */
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        // Crear un hospital
        Hospital hosp = new Hospital();
        int opcio;
        do {
            opcio = menu(tec);
            switch (opcio) {
                case 1: 
                    ingresos(hosp, tec);                        
                    break;                        
                case 2: 
                    hosp.donarAltes();                       
                    break;                        
                case 3: 
                    System.out.println("\n" + hosp.toString());        
                    break;                                               
                case 4: 
                    pacientsCritics(hosp);
                    break;                        
                default: 
                    System.out.println("\n*** Fi Gestor ***");
            }
        } while (opcio != 0);        
    } // de main
    
    /**
     * Metode que fa l'ingres d'un pacient a l'hospital donat.
     * @param h {@code Hospital}, l'hospital.
	 * @param t {@code Scanner}.
     */ 
    private static void ingresos(Hospital h, Scanner t) {
        System.out.print("\nNIF? ");
        String nif = t.nextLine();
        System.out.print("Nom? ");
        String nom = t.nextLine();
        int e;
        do {
            System.out.print("Edat? ");
            e = t.nextInt();
            t.nextLine();
        } while (e < 0);
        if (h.ingresarPacient(nif, nom, e)) {
            System.out.println("Pacient ingresat");
        }
        else { System.out.println("No s'ha pogut fer l'ingres"); }
    }
        
    /**
     * Metode que mostra per pantalla les dades dels pacients critics 
     * d'un hospital donat.
     * @param h {@code Hospital}, l'hospital.
     */ 
    private static void pacientsCritics(Hospital h) {
        int[] aux = h.pacientsCritics();
        if (aux.length != 0) {
            System.out.println("\nPacients critics:");
            for (int i = 0; i < aux.length; i++) {
                System.out.println(h.getPacient(aux[i]));
            }
        }
        else { 
            System.out.println("\nNo hi ha pacients critics a l'hospital");
        }
    }
}
