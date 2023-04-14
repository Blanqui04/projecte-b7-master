import java.util.Random;
//@ErnestCeballos

public class Virus {
    //Atributs
    private String nom;
    private String nomFamilia;
    private String tipusVirus;
    private double taxaContagi;
    private double taxaMortalitat;
    private double probabilitatMalaltia;
    private double duradaMitjanaMalaltia;
    private double duradaMitjanaContagi;
    private double duradaMitjanaImmunitat;
    private double frequenciaMutacioCopia;
    private double frequenciaMutacioCoincidencia;
    private double tempsIncubacio;
    private double tempsDeLatencia;
    
    //Constructor
    Virus (String a_nom, String a_nomFamilia,String a_tipusVirus, double a_taxaContagi, double a_taxaMortalitat, double a_probabilitatMalaltia, double a_duradaMitjanaMalaltia, double a_duradaMitjanaContagi, double a_duradaMitjanaImmunitat, double a_frequenciaMutacioCopia,double a_frequenciaMutacioCoincidencia, double a_tempsIncubacio, double a_tempsDeLatencia) {
        nom = a_nom;
        nomFamilia = a_nomFamilia;
        taxaContagi = a_taxaContagi;
        taxaMortalitat = a_taxaMortalitat;
        probabilitatMalaltia = a_probabilitatMalaltia;
        duradaMitjanaMalaltia = a_duradaMitjanaMalaltia;
        duradaMitjanaContagi = a_duradaMitjanaContagi;
        duradaMitjanaImmunitat = a_duradaMitjanaImmunitat;
        frequenciaMutacioCopia = a_frequenciaMutacioCopia;
        frequenciaMutacioCoincidencia=a_frequenciaMutacioCoincidencia;
        tempsIncubacio = a_tempsIncubacio;
        tempsDeLatencia = a_tempsDeLatencia;
        tipusVirus=a_tipusVirus;
    }
    String nom() {
        //Retorna el nom del virus
        return nom;
    }
    boolean sonFamilia(Virus virus) {
        //Ens diu si 2 virus son o no familia
        // Ens servira per a el tipus de mutacio
        return nomFamilia.equals(virus.nomFamilia);
    }


    double probabilitatMalaltia () {

        //Ens retornarà el tant percent de probabilitat de malaltia que tindrà la persona afectada amb el virus.
        //Aquesta probabilitat variarà en funció del virus que sigui
        return probabilitatMalaltia;
    }

    double tempsIncubacio (){
        //Retornarà el període de temps mig transcorregut entre la infecció virica i l'inici dels simptomes
        return tempsIncubacio;
    }

    double tempsDeLatència(){
        //Retornarà el període de temps mig transcorregut entre una infecció vírica i el moment en què la
        //persona infectada pot contagiar el virus
        return tempsDeLatencia;
    }

    double duradaMitjanaMalaltia(){
        //Retornarà el període de temps mig transcorregut des de l'inici dels símptomes fins a la seva finalització total
        //s'ha de tenir en compte que la persona malalta no mori
        return duradaMitjanaMalaltia;
    }

    double taxaMortalitat (){
        //Retornarà la taxa de Mortalitat, és a dir, la probabilitat que una persona malalta per efecte del virus mori a causa d'aquest.
        return taxaMortalitat;
    }

    double duradaMitjanaContagi (){
        //Retornarà el periode de temps mig durant el qual la persona infectada pot contagiar el virus
        return duradaMitjanaContagi;
    }

    double taxaContagi (){
		return taxaContagi;
        //Retornarà la probabilitat que una persona infectada, en un periode de contagi li passi el virus a una altre.
    }

    double duradaMitjanaImmunitat (){
        //Ens retornarà la durada mitjana del període d'immunitat al virus que ens proporciona després d'haver-lo tingut
        return duradaMitjanaImmunitat;
    }

    double frequenciaMutacioCopia () {
        //Ens retornarà la frequencia de Mutacio del virus per copia.
        return frequenciaMutacioCopia;
    }
    double frequenciaMutacioCoincidencia(){
        //Ens retornarà la frequencia de Mutacio del virus per coincidencia.
        return frequenciaMutacioCoincidencia;
    }

    void llegirFitxer (String nomFitxer) {
        //Llegirà el fitxer corresponent i creara el virus amb els seus paràmetres
    }


    public void setFamilia(String a_nom_familia) {
        //Afegeix el nom de la familia al virus
        nomFamilia = a_nom_familia;
    }


    public String getFamilia() {
        //Retorna el nom de la familia del virus
        return nomFamilia;
    }

    public void afegirNom(String nom_e) {
        //Afegeix el nom del virus
        nom = nom_e;
    }

    private void mutacio_error(Virus v_mutat){
        //Mira si hi ha mutacio per error
        //S'ha de fer lo de mirar la aleatoriatat amb la taxa màxima
        String nom_act = this.nom();
        if (Character.isDigit(nom_act.charAt(nom_act.length() - 1))) {
            int ultim_digit = Character.getNumericValue(nom_act.charAt(nom_act.length() - 1)) + 1;
            char nou_digit = (char) (ultim_digit + '0');
            String nou_nom = nom_act.substring(0, nom_act.length() - 1) + nou_digit;

            }               
            
            else {

                nom_act=this.nom().concat("1");
                
            }
        
        v_mutat.nomFamilia=this.nomFamilia;
        v_mutat.taxaContagi=this.taxaContagi;
        v_mutat.taxaMortalitat=this.taxaMortalitat;
        v_mutat.probabilitatMalaltia=this.probabilitatMalaltia;
        v_mutat.duradaMitjanaMalaltia = this.duradaMitjanaMalaltia;
        v_mutat.duradaMitjanaContagi = this.duradaMitjanaContagi;
        v_mutat.duradaMitjanaImmunitat = this.duradaMitjanaImmunitat;
        v_mutat.frequenciaMutacioCopia = this.frequenciaMutacioCopia;
        v_mutat.frequenciaMutacioCoincidencia=this.frequenciaMutacioCoincidencia;
        v_mutat.tempsIncubacio = this.tempsIncubacio;
        v_mutat.tempsDeLatencia = this.tempsDeLatencia;
        v_mutat.tipusVirus=this.tipusVirus;
        
    }
        
    

    
    public static double generarNumeroAleatorio() {
        Random rand = new Random();
        return rand.nextDouble() * (1.0 - 0.0) + 0.0;
    }

    private void mutacio_coincidencia(Virus virus, Virus v_mutat){ 
        //valor_paràmetre_virus_mutat = p*valor_paràmetre_virus_A + (1-p)* valor_paràmetre_virus_B
        //Mirar aixo, no es una solucio maca
        double p=generarNumeroAleatorio();
        v_mutat.nom = this.nom +"_"+ virus.nom;
        v_mutat.nomFamilia = this.nomFamilia;
        v_mutat.taxaContagi = p*this.taxaContagi + (1-p)*virus.taxaContagi;
        v_mutat.taxaMortalitat = p*this.taxaMortalitat + (1-p)*virus.taxaMortalitat;
        v_mutat.probabilitatMalaltia = p*this.probabilitatMalaltia + (1-p)*virus.probabilitatMalaltia;
        v_mutat.duradaMitjanaMalaltia = p*this.duradaMitjanaMalaltia + (1-p)*virus.duradaMitjanaMalaltia;
        v_mutat.duradaMitjanaContagi = p*this.duradaMitjanaContagi + (1-p)*virus.duradaMitjanaContagi;
        v_mutat.duradaMitjanaImmunitat = p*this.duradaMitjanaImmunitat + (1-p)*virus.duradaMitjanaImmunitat;
        v_mutat.frequenciaMutacioCopia = p*this.frequenciaMutacioCopia + (1-p)*virus.frequenciaMutacioCopia;
        v_mutat.frequenciaMutacioCoincidencia=p*this.frequenciaMutacioCoincidencia+(1-p)*virus.frequenciaMutacioCoincidencia;
        v_mutat.tempsIncubacio = p*this.tempsIncubacio + (1-p)*virus.tempsIncubacio;
        v_mutat.tempsDeLatencia = p*this.tempsDeLatencia + (1-p)*virus.tempsDeLatencia;
        v_mutat.tipusVirus=this.tipusVirus;
    }
    public Virus mutacio (Virus virus) {
        // Mira si hi ha noves mutacions si n'hi ha crea 
        // el nou virus i afegeix el virus a la familia corresponent
        Virus v_mutat=this;
      if(this.sonFamilia(virus)){
              this.mutacio_coincidencia(virus,v_mutat);
         }
       else{
           this.mutacio_error(v_mutat);
        }
        return v_mutat;
    }
     
}
        