

public abstract class Article{
    protected int id;
    protected String nom;
    protected double prix;
    protected String marque;
    protected final double TAXTVQ = 0.05;
    protected final double TAXTPS= 0.09975;
    protected double taxtvq;
    protected double taxtps;
    protected double prixTotal;



    public Article(int id, String nom, double prix, String marque){
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.marque = marque;
    }

    
    public abstract void calculTaxes();

    public abstract void CalculPrixApAyer();

}