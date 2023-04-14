import java.util.Scanner;

public class Virusland{

    /*
    Main del projecte
    Funcio per començar --> main
    Funcio per fer passos -->ferPassos
    Funcio per quan acaba passsos --> MENU per poder afegir vacuna, mes passos, situacio malaltia, evolucio malaltia, confinaments
    Tenim un territori
    Falta inicialtizar territori, es fa a l'hora de llegir els fitxers
    Mirar bé com llegir coses que t'entren per teclat al terminal
    Falta acabar les funcions:
        - mostrarMalaltia();
        - aplicarConfinament();
        - mostrarEvolucio();
        - mostrarDades();
        - llegirFitxers();
     */

    public static void main(String[] args){
        Territori territori;
        llegirFitxers(territori);
        System.out.println("Quants passos vols executar?");
        Scanner llegir=new Scanner(System.in);
        int passos=llegir.nextInt();
        ferPassos(passos,territori);

    }

    private static void ferPassos(int passos, Territori territori) {

        int inici=1;
        while(inici<=passos){
            ferPas(territori);
            inici++;
        }
        Scanner llegir=new Scanner(System.in);
        System.out.println("Vols fer més passos? (s/n)");
        String mesPassos=llegir.nextLine();
        if(mesPassos.equals("s") || mesPassos.equals("S")){
            menu(territori);
        }
        else {
            mostraDades();
        }

    }

    private static void menu(Territori territori){
        //Mostra el menu
        Scanner llegir=new Scanner(System.in);
        System.out.println("Quants passos més vols fer?");
        int mesPassos=llegir.nextInt();
        System.out.println("Vols aplicar una vacuna? (s/n)");
        String vacuna=llegir.nextLine();
        System.out.println("Vols aplicar un confinament? (s/n)");
        String confinament=llegir.nextLine();
        System.out.println("Vols veure la situacio de la malaltia? (s/n)");
        String situacioMalaltia=llegir.nextLine();
        System.out.print("Vols veure l'evolucio de la malaltia? (s/n)");
        String evolucioMalaltia=llegir.nextLine();

        if(vacuna.equals("s")|| vacuna.equals("S")){
            afegirVacuna(territori);
        }

        if(confinament.equals("s")|| confinament.equals("S")){
            //Aplicar confinament
            //Passar taxamobilitat interna i externa, tipus confinament i a quina regio es fa
            aplicarConfinament(territori);
        }

        if(situacioMalaltia.equals("s")||situacioMalaltia.equals("S")){
            //Mostrar situacio malaltia
            mostrarMalaltia(territori);
        }

        if(evolucioMalaltia.equals("s")||evolucioMalaltia.equals("S")){
            //Mostrar evolució malaltia
            mostrarEvolucio(territori);
        }

        ferPassos(mesPassos, territori);
    }

    private static void mostraDades(){
        //Mostra totes les dades finals i acaba el programa
    }

    private static void ferPas(Territori territori){
        //Fa un pas, és a dir actualitza contagis, morts, mutacions....
        territori.actualitzarRegions();

    }

    private static void llegirFitxers(Territori territori){

        //Legeix tots els fitxers, els 4 que es proporcionen
        //Falta mirar com es llegeixen, si per paràmetres o per interfície gràfica--> per fer interficie gràfica mirar javafx

    }

    private static void afegirVacuna(Territori territori){      //passar vacuna i % de poblacio a la que se li aplica
        //Afegeix una vacuna a la regio que volem
        Scanner llegir=new Scanner(System.in);
        System.out.println("A quina regio vols aplicar la vacuna?");
        String regio=llegir.next();
        Regio r;
        if(territori.existeixRegio(regio,r)){
            territori.mostrarNomVacunes();
            System.out.println("Quina vacuna vols aplicar?");
            String vacuna=llegir.next();
            Vacuna v;
            if(territori.existeixVacuna(vacuna,v)){
                System.out.println("Quin percentatge de la població de la regio s'aplica la vacuna? (introdueix nomes el numero NO%)");
                int percentatge=llegir.nextInt();
                r.aplicarVacuna(v,percentatge);
            }
            else{
                System.out.println("La vacuna no existeix");
                menu(territori);
            }
        }
        else{
            System.out.println("La regio no existeix");
            menu(territori);
        }
    }

    private static void aplicarConfinament(Territori territori){
        //Aplica un confinament a la regio que volem

        Scanner llegir=new Scanner(System.in);
        System.out.println("A quina regio vols aplicar el confinament?");
        String regio=llegir.next();
        Regio r;
        if(territori.existeixRegio(regio, r)){
            //Aplicar el confinament a la regio
            //Demanar a en Joan com fer-ho, com ho te fet
        }
        else{
            System.out.println("La regio no existeix");
            menu(territori);
        }
    }

    private static void mostrarMalaltia(Territori territori){
        //Mostra les dades de la malaltia en el moment que es demana
    }

    private static void mostrarEvolucio(Territori territori){
        //Mostra l'evolucio de la malaltia
        //Dalguna manera s'ha de guardar com evoluciona la malaltia
    }
}