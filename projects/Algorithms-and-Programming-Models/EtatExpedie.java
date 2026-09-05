package EtatCommandes;


public class EtatExpedie implements EtatCommande {
    @Override
    public void executer() {
        System.out.println("Commande expediee");
    }
}