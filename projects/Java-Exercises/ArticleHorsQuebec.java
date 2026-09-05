import javax.swing.JOptionPane;

public class ArticleHorsQuebec extends Article{
    String message;
    protected boolean origineHorsQuebec;

    public ArticleHorsQuebec(int id, String nom, double prix, String marque, boolean origineHorsQuebec){
        super(id, nom, prix, marque);
        this.origineHorsQuebec = origineHorsQuebec;

    }
    
    public void calculTaxes(){
        taxtps = (this.prix * TAXTPS);
        message = "Le montant des taxes pour la TPS est de : $" + String.format("%.2f", taxtps);
    }

    public void CalculPrixApAyer(){
        calculTaxes();
        prixTotal = this.prix + taxtps;
        message+="\nLe prix total de l'article est de : $" + String.format("%.2f", prixTotal);
        JOptionPane.showMessageDialog(null, message);
    }
}
