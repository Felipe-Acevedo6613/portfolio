import Singleton.CommandeSingleton;
import EtatCommandes.*;
import ObserverComande.*;
import Composite.*;
public class App {
    public static void main(String[] args) throws Exception {

        CommandeSingleton commande = CommandeSingleton.getInstance();
        commande.montrer();

        CommandeEtatContext context = new CommandeEtatContext();
        EtatCommande etatLivre = new EtatLivre();
        EtatCommande etatExpedie = new EtatExpedie();
        context.setEtat(etatLivre);
        context.executerEtat();
        context.setEtat(etatExpedie);
        context.executerEtat();

        CommandeCompose plusieursCommandes = new CommandeCompose("Plusieurs commandes");
        
        CommandeComposse commandeComposse = new CommandeComposse();
        commandeComposse.add(plusieursCommandes);

        CommandeObserve commandeObserve = new CommandeObserve();
        UtilizateurOservateur usuarioObservateur = new UtilizateurOservateur();
        
        commandeObserve.addObserver(usuarioObservateur);
        commandeObserve.changerEtat("En attente");
        commandeObserve.changerEtat("Expedie");

    }
}
