package EtatCommandes;

public class CommandeEtatContext {

    private EtatCommande etat;

    public void setEtat(EtatCommande etat) {
        this.etat = etat;
    }

    public void executerEtat() {
        etat.executer();
    }
}

