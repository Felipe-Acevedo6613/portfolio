package Composite;

public abstract class ComponentCommande {
    protected String nombre;

    public String getNombre() {
        return nombre;
    }

    public void add(ComponentCommande componente) {
        throw new UnsupportedOperationException();
    }

    public void remove(ComponentCommande componente) {
        throw new UnsupportedOperationException();
    }
}
