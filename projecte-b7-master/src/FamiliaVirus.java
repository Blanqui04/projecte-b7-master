public class FamiliaVirus {
    //Atributs
    private String nom;
    private double taxa_variacio;

    //Constructor parametres
    FamiliaVirus(String a_nom, double a_taxa_variacio){
        nom=a_nom;
        taxa_variacio=a_taxa_variacio;
    }

    public String obtenirNom(){
        return nom;
    }

    public double obtenirTaxaMaxima(){
        return taxa_variacio;
    }

    public double obtenirTaxaMaximaTravesNom(String nom){
        if (nom.equals(this.nom)){
            return taxa_variacio;
        }
        else{
            return 0;
        }

    }

}
