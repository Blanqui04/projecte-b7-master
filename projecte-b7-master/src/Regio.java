import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public class Regio{


    private String nomRegio;
    private Map <Regio,Double> regionsVeines;
    private int nombreHab;
    private double superficie;
    private double tMobilitatInterna;
    private double tMobilitatExterna;
    private double tNovaMobInt;//taxa de mobilitat nova pel confinament
    private double tNovaMobExt;
    private Map <Virus,Integer> infoVir; //Per cada virus guardarem el nombre de contagis en la regió
    private boolean regioConfinada;


    
    Regio(String nomRegio, String[] regionsVeines, int nombreHab, double superficie, double tMobilitatInterna, double tMobilitatExterna){   //Treure per entregar

        //Constructor de Regio que guardarà les dades que ens entrin al menu en els atributs de classe que tinguem.
        
        this.nomRegio=nomRegio;
        this.regionsVeines=regionsVeines;
        this.nombreHab=nombreHab;
        this.superficie=superficie;
        this.tMobilitatExterna=tMobilitatInterna;
        this.tMobilitatExterna=tMobilitatExterna;
        infoVir=new HashMap<Virus,Integer>();
    }

    Regio (String nomRegio, int nombreHab, int mobInterna){ //Constructor per a les dades inicials de cada regió entrades

        this.nomRegio=nomRegio;
        this.nombreHab=nombreHab;
        this.tMobilitatExterna=mobInterna; //contactes mitjans per persona i unitat de temps 
        
    }

    public void actualitzarNombreHab(int nGentMarxa, int nGentEntra, int nGentMor){ 

     //Actualitza la poblacio segons:
            // - Gent que marxa
            // - Gent que entra
            // - Gent que mor per algun virus
        this.nombreHab=((this.nombreHab-(nGentMarxa+nGentMor))+nGentEntra);
   
            
    }

    public void afegirVeina (Regio r, double nHabTemps){

        //Afegeix una regio veina

         this.regionsVeines.put(r,nHabTemps);


    }

    public void eliminarVeina(Regio r){

        regionsVeines.remove(r); //no crec que es necessiti, pero si confinen ho fem borrant directament la regió o baixant el percentatge?

    }

    public String nomRegio() { 

        //Retorna nom de la regio

        return nomRegio;
    }

    public Set<Map.Entry<Regio, Double>> obtenirRegionsVeines() {

        return regionsVeines.entrySet(); //Llavors desde territori itera les regions veines i mira percentatges de mobilitat 
    }

    public int nombreHab (){

        return nombreHab;

    }

    public double superficie (){

        return superficie;
    }
    public double tMobilitatInterna (){

        return tMobilitatInterna;

    }
    
    public double tMobilitatExterna (){

        return tMobilitatExterna;
    }

    public void aplicarVacuna(Vacuna v1,double tantPercentPoblacio){    //A PARTIR DEL NOM DEL VIRUS CREAR UN VIRUS NOU AMB ELS PARAMETRES

        //Quan tu apliques una vacuna, segons del tipus que sigui actuara d'una determinada manera en la poblacio reduint percentatges
        //Aplica una vacuna a tota la regio

        if (v1.tipusVacuna()=="inhibidora") { 

           if (v1.evitaMalaltia())
           
           this.nombreHab=((this.nombreHab*tantPercentPoblacio)/100);

        }

        //ACTUALITZAR LA TAXA EN LA REGIÓ 

        else if (v1.tipusVacuna()=="atenuadora") { //ACTUALITZARA LES TAXES D'AQUEST VIRUS EN LA REGIÓ EN CONCRET.
           
            this.infoVir.get(v1.nomVirus()).duradaMalaltia=vir.duradaMitjanaMalaltia()-v1.rDuradaMalaltia(); //Actualitza la duradaMalaltia
            this.infoVir.get(v1.nomVirus()).taxaContagi= vir.taxaContagi()-v1.rTaxaContagi();
            this.infoVir.get(v1.nomVirus()).taxaMortalitat=vir.taxaMortalitat()-v1.rTaxaMortalitatMalalts();
            this.infoVir.get(v1.nomVirus()).probabilitatDesenv=vir.probabilitatMalaltia()-v1.rProbabilitatDesenv(); 

        }
    }



    public boolean esVeina (Regio r){ //Ens dira si una regió és veina d'una altre

        return r.regionsVeines.contains(r);

    }

    public void actualitzarMobilitatInterna(double percentatgeMobInt){

        //Actualitzarem la taxa de Mobilitat degut a un confinament tenint en conta els viatjes anteriors, per si ha de tornar gent.

        tNovaMobInt=percentatgeMobInt;
    }

    public void actualitzarMobilitatExterna(double percentatgeMobExt){

        //Actualitzarem la taxa de Mobilitat degut a un confinament tenint en conta els viatjes anteriors, per si ha de tornar gent.

        tNovaMobExt=percentatgeMobExt;
    }

    public void desferConfinament(){

        //Es desfarà el confinament de la regió actual

        this.regioConfinada=false;

    }

    public boolean habitantsMorts(){


    }

    public void nouVirusMut (Virus vir,boolean errorCopia, boolean coincidenciaVir) {

        //crearem els virus mutats
        Virus nouV;
        String nom_act = vir.nom();
        if(errorCopia=true){

            if (Character.isDigit(nom_act.charAt(nom_act.length() - 1))) {
                int ultim_digit = Character.getNumericValue(nom_act.charAt(nom_act.length() - 1)) + 1;
                char nou_digit = (char) (ultim_digit + '0');
                String nou_nom = nom_act.substring(0, nom_act.length() - 1) + nou_digit;

                }               
                
                else {

                    nom_act=  vir.nom().concat("1");
                    
                }
            }

            else { 

                if (coincidenciaVir=true){

                        
                    nom_act= vir.nom()+ "_" + vir2; //AQYESTA SERIA LA MANERA DE CONCATENAR PERO HAIG DE REVISAR QUAN EM PASSEN EL SEGON VIRUS O SI L'HAIG DE BUSCAR

                }

            }
            //Falta acabar de mirar si canvien o no els paràmetres després  de la mutació
            nouV(nom_act, vir.getFamilia(),vir.tipus(),a_taxaContagi, a_taxaMortalitat,a_probabilitatMalaltia, a_duradaMitjanaMalaltia, a_duradaMitjanaContagi, a_duradaMitjanaImmunitat, a_frequenciaMutacio, a_tempsIncubacio,a_tempsDeLatencia)



        }


    

    public void mirarVirusMutables(){



    }

    public void confinament (String conf, double tMobilitatExterna, double tMobilitatInterna){     
        // Cada regió pot tenir un confinament específic depenen de les 
        // regions delimitades i la situació d'aquestes.

        if (r1.esVeina(r2) and (r1.virusRegio[vir]!=NULL or r2.virusRegio[vir]!=NULL)){ //NO ÉS DEFINITIU, ÉS UN ESQUEMA

               if (r1.virusRegio[vir]!=NULL) r1.regioConfinada=true;
               else r2.regioConfinada=true;
        }
        
        //*Si es confinen ho entren pel teclat? Llavors seria diferent ja que es miraria si és tancament o dur.

        if (conf=="tancament"){

                r1.actualitzarMobilitatExterna();//Aqui miraria viatjes, ja que aquestes podrien tornar al seu domicili
        }
        else if (conf=="dur") {

                 r1.actualitzarMobilitatInterna();
                 r1.actualitzarMobilitatExterna();

        }
    }

}




