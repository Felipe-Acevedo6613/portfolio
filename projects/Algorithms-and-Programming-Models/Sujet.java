package ObserverComande;

import java.util.ArrayList;
import java.util.List;

public class Sujet {
    private List<Observateur> observateures = new ArrayList<>();

    public void addObserver(Observateur observateur) {
        observateures.add(observateur);
    }

    public void removeObserver(Observateur observateur) {
        observateures.remove(observateur);
    }

    public void notifier(String etat) {
        for (Observateur observateur : observateures) {
            observateur.actualicer(etat);
        }
    }
}

