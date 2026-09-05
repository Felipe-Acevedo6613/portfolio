package EtatCommandes;

public class EtatAttente implements EtatCommande {
    @Override
    public void executer() {
        System.out.println("Commande en attente");
    }
}
