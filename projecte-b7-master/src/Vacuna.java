public class Vacuna {

    private String nomVacuna;
    private String tipusVacuna;
    private String nomVirus;
    private double tantPercentEfectivitat;
    private double tempsMitja;
    private double duradaEfecte;
    private double rTaxaMortalitatMalalts;
    private double rDuradaMalaltia;
    private double rProbabilitatDesenv;
    private double rTaxaContagi;


    
    Vacuna(String nVac, String tipus, String nomVir, double efectivitat, double tempsMit, double durEf,double tempsAct,double durada, double reduccioMort, double reduccioDurada, double reduccioMalaltia, double reduccioContagi){ 

        //Constructor de Vacuna que guardarà les dades que ens entrin al menu en els atributs de classe que tinguem.

        nomVacuna=nVac;
        tipusVacuna=tipus;
        nomVirus=nomVir;
       
        if (tipus=="inhibidora") {

            tantPercentEfectivitat=efectivitat;
            tempsMitja=tempsMit;
            duradaEfecte=durEf;
            

        }

        else if (tipus=="atenuadora"){ //les taxes dels altres les inicialitzo a 0?

            tempsMitja=tempsAct;
            duradaEfecte=durada;
            rTaxaMortalitatMalalts=reduccioMort;
            rDuradaMalaltia=reduccioDurada;
            rProbabilitatDesenv=reduccioMalaltia;
            rTaxaContagi=reduccioContagi;

        }
    }





    public boolean evitaMalaltia (Virus v1) {
        //ES PODRIA FER SENSE PARÀMETRES? EL DOUBLE EFECTIVITAT.

        //comprovara si la Vacuna evita o no la malaltia segons el tant percent d'efectivitat
        //per a aplicar aquesta ha de ser una vacuna del tipus1(eviten contreure malaltia).
        boolean evitaMalalt=false;
        if(tipusVacuna=="tipus1"){ //Depen de com entrem els tipus

            if (this.tantPercentEfectivitat == 100){   //COM PODRIEM SABER SI UNA AMB MENYS PERCENTATJE D'EFECTIVITAT LA POT EVITAR O NO?

                evitaMalalt=true;
            }

        }

        return evitaMalalt;

    }

    public String nomVacuna() {

        //Retornarà el nom de la vacuna amb la qual tractem

        return nomVacuna;

    }

    public String tipusVacuna() {

        //Retornarà el tipus de vacuna que és i segons el tipus del que es tracti farem una cosa o una altre
    
        return tipusVacuna;
    }

    public String nomVirus() {

        //Retornarà el nom del virus al qual ataca la seguent vacuna

        return nomVirus;
    }   

    public double tantPercentEfectivitat() {

        //Ens retornarà el tant percent d'efectivitat de la vacuna, ha de ser del tipus 1

        return tantPercentEfectivitat;

    }

    public double tempsMitjaNecessari() {

        //Ens retornara el temps mitjà necessari per tal de que la vacuna faci efecte.

        return tempsMitja;

    }

    public double duradaEfecte() {

        //Ens retorna la durada de l'efecte de la vacuna.

        return duradaEfecte;

    }

    public double rTaxaMortalitatMalalts() {

            //Retornarà la reduccio de la taxa de mortalitat que produeix la vacuna de tipus 2

            return rTaxaMortalitatMalalts;

    }


    public double rDuradaMalaltia() {

            //Retornarà la reduccio de la taxa de la durada de la malatia que produeix la vacuna de tipus 2


            return rDuradaMalaltia;
    }
    public double rProbabilitatDesenv() {

            //Retornarà la reduccio de la taxa de la probabilitat de desenvolupament de la malaltia que produeix la vacuna de tipus 2

            return rProbabilitatDesenv;
    }

    public double rTaxaContagi() {

            //Retornarà la reduccio de la taxa de contagi que produeix la vacuna de tipus 2
            
            return rTaxaContagi;
    }


}

