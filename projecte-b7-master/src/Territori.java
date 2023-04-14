import java.util.ArrayList;
import java.util.List;

public class Territori{

    // Conjunt de regions, tenim varies regions
    /*
    Acabar les funcions:
        - llegirFitxers();
        - actualitzarRegions();
        - mostrarNomVacunes();
    */

    private List<Regio> llistaRegions= new ArrayList<Regio>();
    private List<Vacuna> llistaVacunes=new ArrayList<Vacuna>();

    public void llegirFitxer(){

        //Legieix el fitxer de partida i el de vacunes

    }

    public void afegirRegio (Regio r){

        //Afegeix una nova regio
        llistaRegions.add(r);

    }

    public Regio getRegio(Regio r){       

        //Retorna la regio que volem
        int index=llistaRegions.indexOf(r);
        Regio regio=r;
        if(index!=-1){
            regio=llistaRegions.get(index);
        }
        else {
            System.out.println("No existeix la regio");
        }
        return regio;

    }

    public boolean existeixRegio(String regio, Regio r){

        //Mirem si existeix o no la regió que ens passen
        boolean trobat=false;
        int ultim=llistaRegions.size();
        int i=0;
        while(!trobat && i<=ultim){
            if(llistaRegions.get(i).nomRegio().equals(regio)){
                trobat=true;
            }
            else i++;
        }
        r=llistaRegions.get(i);
        return trobat;
    }

    public void actualitzarRegions(){

        //Actualitza totes les regions, fa un recoregut per la llista i les va actualitzant totes
    }

    public void mostrarNomVacunes(){
        //Ha mostrat el nom de totes les vacunes disponibles i el virus pel que serveix cada vacuna

        for(Vacuna v:llistaVacunes){
            System.out.println(v + " ");
        }
    }

    public boolean existeixVacuna(String vacuna, Vacuna v){
        //Diu si existeix una vacuna donat un nom d'aquesta
        boolean trobat=false;
        int ultim=llistaVacunes.size();
        int i=0;
        while(!trobat && i<=ultim){
            if(llistaVacunes.get(i).nomVacuna().equals(vacuna)){
                trobat=true;
            }
            else i++;
            
        }
        v=llistaVacunes.get(i);
        return trobat;

    }

}