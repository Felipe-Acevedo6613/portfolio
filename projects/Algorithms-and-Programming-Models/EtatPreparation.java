package EtatCommandes;


public class EtatPreparation implements EtatCommande {
    @Override
    public void executer() {
        System.out.println("Commande en cours de preparation");
    }
}

