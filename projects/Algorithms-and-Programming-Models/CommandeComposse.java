package Composite;

import java.util.ArrayList;
import java.util.List;

public class CommandeComposse extends ComponentCommande {
    private List<ComponentCommande> partes = new ArrayList<>();

    @Override
    public void add(ComponentCommande componente) {
        partes.add(componente);
    }

    @Override
    public void remove(ComponentCommande componente) {
        partes.remove(componente);
    }

    @Override
    public String getNombre() {
        StringBuilder nombreCompuesto = new StringBuilder();
        for (ComponentCommande parte : partes) {
            nombreCompuesto.append(parte.getNombre()).append(" ");
        }
        return nombreCompuesto.toString();
    }
}

