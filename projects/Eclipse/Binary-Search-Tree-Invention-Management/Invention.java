public class Invention {
    private String nom;
    private String inventeur;
    private int annee;

    public Invention(String nom, String inventeur, int annee) {
        this.nom = nom;
        this.inventeur = inventeur;
        this.annee = annee;
    }

    public String getNom() {
        return nom;
    }

    public String getInventeur() {
        return inventeur;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    @Override
    public String toString() {
        return nom + " (Inventeur: " + inventeur + ", Année: " + annee + ")";
    }
}
