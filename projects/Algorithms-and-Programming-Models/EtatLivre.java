package EtatCommandes;


public class EtatLivre implements EtatCommande {
    @Override
    public void executer() {
        System.out.println("Commande livre");
    }
}

