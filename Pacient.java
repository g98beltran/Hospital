/**
 * Classe {@code Pacient}: permet representar un pacient 
 * amb la informacio següent: nif, nom, edat i 
 * estat (enter entre 1 -critic- i 4 -lleu- o 5 -pacient sa-). 
 * 
 * @author IIP 
 * @version Curs 2016/17
 */
public class Pacient {
    /** Constant que representa l'estat critic. */
    public static final int CRITIC = 1;
    /** Constant que representa l'estat greu. */
    public static final int GREU = 2;
    /** Constant que representa l'estat moderat. */
    public static final int MODERAT = 3;
    /** Constant que representa l'estat lleu. */
    public static final int LLEU = 4;
    /** Constant que representa l'estat sa. */
    public static final int SA = 5;
    
    /** Atribut que representa el NIF del pacient */
    private String nif;
    /** Atribut que representa el nom del pacient */
    private String nom;
    /** Atribut que representa l'edat del pacient */
    private int edat;
    /** Atribut que representa l'estat del pacient
     *  (enter entre 1 -critic- i 4 -lleu- o 5 -pacient sa-)
     */
    private int estat; 
    
    
    /**
     * Crea un {@code Pacient} amb NIF {@code nif}, 
     * de nom {@code nom}, de {@code edat} anys i 
     * {@code estat} es un valor aleatori en l'interval 
     * <code>[CRITIC,LLEU]</code>.
     * @param nf {@code String}, el NIF.
     * @param n {@code String}, el nom.
     * @param e {@code int}, l'edat.
     */
    public Pacient(String nf, String n, int e) {
        nif = nf;
        nom = n;
        edat = e;
        estat = (int) (Math.random() * (LLEU - CRITIC + 1) + CRITIC);
    }
    
    /**
     * Torna el NIF del pacient. 
     * @return {@code String}, el NIF.
     */
    public String getNif() { return nif; }
    
    /**
     * Torna el nom del pacient.
     * @return {@code String}, el nom.
     */
    public String getNom() { return nom; }
    
    /**
     * Torna l'edat del pacient.
     * @return {@code int}, l'edat.
     */
    public int getEdat() { return edat; }
    
    /**
     * Torna l'estat del pacient.
     * @return {@code int}, l'estat.
     */
    public int getEstat() { return estat; } 
    
    /**
     * Millora l'estat del pacient, incrementant-lo en 1.
     */
    public void tractament() { estat += 1; }
    
    /**
     * Torna un {@code String} amb la informacio del pacient  
     * en el seguent format: 
     * <code>"nom nif edat est"</code> on est es 
     * <code>"CRITIC", "GREU", "MODERAT", "LLEU" o "SA"</code> 
     * en funcio de l'estat del pacient (per exemple,
     * <code>"Pepe Perez Santarosa 74747474I  46 LLEU"</code>).
     * @return {@code String}, el resultat.
     */
    public String toString() { 
        String est = "";
        switch (estat) {
            case CRITIC: 
                est = "CRITIC"; break;
            case GREU: 
                est = "GREU"; break;
            case MODERAT: 
                est = "MODERAT"; break;
            case LLEU: 
                est = "LLEU"; break;
            default: 
                est = "SA"; break;
        }
        return String.format("%-25s %-10s %2d  %s", nom, nif, edat, est); 
    }    
}