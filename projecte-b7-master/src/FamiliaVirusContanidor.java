
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//@ErnestCeballos

//Arreglar la classe

public class FamiliaVirusContanidor{
    //Atributs
    private Map<FamiliaVirus, List<Virus>> familiaVirus;
    

    FamiliaVirusContanidor( FamiliaVirus nom_familia, Virus virus){       //Treure per l'entrega final
        //Crea una taula amb els noms d'una familia especifica
        familiaVirus = new HashMap<FamiliaVirus, List<Virus>>();
        if(familiaVirus.containsKey(nom_familia)){
            familiaVirus.get(nom_familia).add(virus);
        }
        else{
            List<Virus> novaList = new ArrayList<Virus>();
            novaList.add(virus);
            familiaVirus.put(nom_familia, novaList);
        }
        
    }

    public Map retornaFamilia(){

        return familiaVirus;
        //Retorna la familia de virus
 
    }


    public void afegir(Virus virus){ //MIrar
        //Afegim a la llista de la familia un nou virus
        if(familiaVirus.containsKey(virus.getFamilia())){
            familiaVirus.get(virus.getFamilia()).add(virus);
        }
        else{
            List<Virus> novaList = new ArrayList<Virus>();
            novaList.add(virus);
            familiaVirus.put(, novaList);
            virus.setFamilia(virus.getFamilia());
        }
        
        
    }

    public void eliminar(Virus virus){
        //Elimina un virus de la llista de la familia
        if(familiaVirus.containsKey(virus.getFamilia())){
            familiaVirus.get(virus.getFamilia()).remove(virus);
        }
    }

    public boolean mateixaFamilia(Virus virus1, Virus virus2){ //es pot canviar ja que el virus tidra el nom de familia nomes caldra recorra la llista de virus i mirar si el nom de familia es igual
        //Comprova si dos virus son de la mateixa familia
        if(virus1.getFamilia().equals(virus2.getFamilia())){
            return true;
        }
        else{
            return false;
        }
    }

}