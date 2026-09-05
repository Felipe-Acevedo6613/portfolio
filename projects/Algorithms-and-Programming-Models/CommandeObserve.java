package ObserverComande;

public class CommandeObserve extends Sujet {
    private String etat;

    public void changerEtat(String etat) {
        this.etat = etat;
        notifier(etat);
    }

    public String getEtat() {
        return etat;
    }
}

