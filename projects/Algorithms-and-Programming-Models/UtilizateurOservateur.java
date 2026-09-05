package ObserverComande;


    public class UtilizateurOservateur implements Observateur {
        @Override
        public void actualicer(String etat) {
            System.out.println("Le commande est maintenant: " + etat);
        }
    }
    
