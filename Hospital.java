/**
 * Classe Hospital: permet representar la informacio dels pacients 
 * que ocupen els llits d'un hospital.
 * 
 * @author IIP
 * @version Curs 2016/17
 */
public class Hospital {
    /** Constant que representa el numero maxim de pacients que 
     *  poden passar per qualsevol hospital. */    
    public static final int MAX_PACIENTS = 10; //5000;
    /** Constant que representa el numero maxim de llits de 
     *  qualsevol hospital. */
    public static final int MAX_LLITS = 5;//200;
    /** Atribut que permet representar tots els llits de 
     *  l'hospital actual. */     
    private Pacient[] llits;//pacient(nif,nom,edat)
    /** Atribut que representa el numero actual de llits 
     *  lliures de l'hospital actual. */
    private int lliures;
    /** Atribut que representa el numero actual de llits 
     *  ocupats per pacients critics a l'hospital actual. */
    private int critics;//critic 1,greu 2,moderat 3, lleu 4, sa 5
    /** Atribut que permet representar tots els NIF dels 
     *  pacients que han estat a l'hospital actual. */
    private String[] historic;//ultima pos paciens
    /** Atribut que representa el numero de pacients que 
     *  han estat fins ara a l'hospital actual. */
    private int pacients;
    
    /**
     * Crea un {@code Hospital} amb tots els llits lliures,
     * sense pacients critics ni historic de pacients.
     */
    public Hospital() {
        llits = new Pacient[MAX_LLITS + 1];
        lliures = MAX_LLITS;
        critics = 0;
        historic = new String[MAX_PACIENTS];
        pacients = 0;
    } 
    
    /**
     * Torna el numero de llits lliures de l'hospital. 
     * @return {@code int}, el numero de llits lliures.
     */
    public int getLliures() { return lliures; }
    
    /**
     * Torna el numero de pacients en l'historic de l'hospital. 
     * @return {@code int}, el numero de pacients en l'historic.
     */
    public int getPacientsHistoric() { return pacients; }
    
    /**
     * Torna el numero de llits ocupats per pacients critics 
     * a l'hospital.
     * @return {@code int}, el numero de llits ocupats per pacients 
     * critics.
     */
    public int getCritics() { return critics; }
    
    /**
     * Torna {@code true} si a l'hospital hi ha llits lliures i 
     * torna {@code false} en cas contrari.
     * @return {@code boolean}, {@code true} si a l'hospital hi ha 
     * llits lliures i {@code false} en cas contrari.
     */
    public boolean hiHaLliures() 
    {
        if(lliures > 0){
            return true;
        }else {
            return false;
        }
    } 
    
    /**
     * Torna el numero del primer llit lliure de l'hospital si hi ha 
     * llits lliures o torna {@code -1} si no hi ha.
     * @return {@code int}, numero del primer llit lliure de l'hospital 
     * si hi ha llits lliures o {@code -1} si no hi ha.
     */
    public int primerLliure() {
        int i = 1;
        while(i < llits.length && llits[i] != null){i++;}
        if(i == llits.length){return -1;}
        else{return i;}
    }
    
    /**
     * Donat un NIF {@code nif}, comprova si esta a l'historic de NIF 
     * de l'hospital. Si esta, torna la posicio que ocupa a l'array 
     * historic. En cas contrari, torna -1 indicant que no s'ha trobat. 
     * @param nif {@code String}, el NIF del pacient a cercar.
     * @return {@code int}, la posicio que ocupa a l'historic o 
     * {@code -1} si no esta.
     */
    private int cercar(String nif) {
        int i = 0;
        while(i < pacients && !historic[i].equals(nif)){i++;}
        if(i >= pacients){return -1;}
        else{return i;}
    }
    
    /**
     * Donat un {@link Pacient}, si el seu NIF no esta en l'historic, 
     * l'afegeix. 
     * @param p {@code Pacient}, el pacient.
     */
    private void afegirHistoric(Pacient p) {
        int pos = this.cercar(p.getNif());
        if(pos == -1){
            if(historic.length > pacients){
                historic[pacients] = p.getNif();
                pacients ++;
            }
        }
    }

    /**
     * Si hi ha llits lliures, el primer d'ells (el de numero menor) 
     * passa a estar ocupat pel pacient de nif {@code nif}, 
     * nom {@code nom} i edat {@code edat}. Si el pacient no esta a 
     * l'historic, l'afegeix. Torna {@code true} si s'ha fet l'ingres 
     * o torna {@code false} en cas contrari (si no hi ha llits lliures).
     * @param nif {@code String}, el NIF.
     * @param nom {@code String}, el nom.
     * @param edat {@code int}, l'edat.
     * @return {@code boolean}, {@code true} si s'ha fet l'ingres 
     * o {@code false} en cas contrari.
     */
    public boolean ingresarPacient(String nif, String nom, int edat) {
//         int i = 0;
//         while(i < llits.length && llits[i] != null){i++;}
        if(this.primerLliure() == -1){return false;}
        else{
            //Nessesite un Pacient
            llits[this.primerLliure()] = new Pacient(nif,nom,edat);
            lliures--;
            historic[pacients++] = nif;
            return true;
        }
    } 
   
    /**
     * Torna el {@link Pacient} que ocupa el llit {@code i} de 
     * l'hospital actual o {@code null} si el llit esta lliure. 
     * @param i {@code int}, el numero de llit.
     * @return {@code Pacient}, el pacient que ocupa el llit 
     * {@code i} o {@code null} si el llit esta lliure.
     */
    public Pacient getPacient(int i) { return llits[i]; } 
    
    /**
     * El llit {@code i} de l'hospital passa a estar lliure.
     * @param i {@code int}, el numero de llit.
     */
    private void donarAltaPacient(int i) { llits[i] = null; lliures++;} 
    
    /**
     * Es suministra el {@code tractament()} a tots els pacients 
     * de l'hospital i a aquells pacients sans (l'estat dels 
     * quals es {@code 5}) se'ls dona l'alta medica 
     * (s'invoca a {@code donarAltaPacient(int)}).
     */
    public void donarAltes() {
       //no se com accedir al pacient
       //entres en lliures[i].tractament() i en el mateix bucle q mira q siga distint de null 
       //mira si despres del tractament hi han sans i fas donarAltaPacient()
       //i si es greu antes era critic es dir q ara ja no ho es per tant el lleves de critic
       for(int i = 0; i < llits.length ; i++){
           if(llits[i] != null){
               if(llits[i].getEstat() == 1){critics--;}
               llits[i].tractament();
               if(llits[i].getEstat() >= 5){donarAltaPacient(i);}
           }
       }
    } 

    /**
     * Torna un {@code String} que descriu l'hospital, es a dir, 
     * quins pacients ocupen quins llits i quins llits estan lliures. 
     * Si no hi ha pacients a l'hospital torna 
     * {@code "Hospital buit"}.
     * @return {@code String}, el resultat.
     */
    public String toString() {
        String res = "";
        if(lliures == llits.length-1){res += "Hospital buit\n";}
        else{
            for(int i = 1; i < llits.length; i++){
                if(llits[i] != null){
                    res += i + "\t"+llits[i].toString()+"\n";
                }else{
                    res += i + "\tlliure\n";
                }
            }
        }
        return res;
    }    
         
    /**
     * Torna un array amb els numeros de llit ocupats pels pacients 
     * critics (es a dir, aquells pacients amb estat igual a {@code 1}). 
     * L'array que s'ha de tornar tindra tants elements com pacients 
     * critics hi ha a l'hospital. Si no hi ha pacients, l'array 
     * tindra longitud 0.
     * @return {@code int[]}, array amb els numeros de llit ocupats 
     * pels pacients critics.
     */
    public int[] pacientsCritics() {
        int[] ocupats;
        if(lliures == llits.length){ocupats = new int[0];}
        else{
            ocupats = new int[critics];
            int pos = 0;
            for(int i = 0; i < llits.length; i++){
                if(llits[i] != null && llits[i].getEstat() == 1){
                    if(pos < ocupats.length){
                        ocupats[pos] = i;
                        pos++;
                    }
                }
            }
        }
        return ocupats;
    }
    
} 