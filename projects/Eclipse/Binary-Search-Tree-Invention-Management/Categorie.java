import java.util.ArrayList;
import java.util.List;

public class Categorie {

    private String nom;
    private List<Invention> inventions;

    public Categorie(String nom) {
        this.nom = nom;
        this.inventions = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public List<Invention> getInventions() {
        return inventions;
    }

    public void ajouterInvention(Invention invention) {
        inventions.add(invention);
    }

    public Invention trouverInvention(String nomInvention) {
        for (Invention invention : inventions) {
            if (invention.getNom().equalsIgnoreCase(nomInvention)) {
                return invention;
            }
        }
        return null;
    }

    public List<Invention> trouverInventionsParInventeur(String nomInventeur) {
        List<Invention> result = new ArrayList<>();
        for (Invention invention : inventions) {
            if (invention.getInventeur().equalsIgnoreCase(nomInventeur)) {
                result.add(invention);
            }
        }
        return result;
    }
}
