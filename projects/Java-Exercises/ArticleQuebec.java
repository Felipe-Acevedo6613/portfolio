import javax.swing.JOptionPane;
public class ArticleQuebec extends Article{

    String message;
    protected String origineQebec;

    public ArticleQuebec(int id, String nom, double prix, String marque, String origineQuebec){
        super(id, nom, prix, marque);
        this.origineQebec = origineQuebec;
    }

    public void calculTaxes(){
        taxtvq = (this.prix * TAXTVQ);
        taxtps = (this.prix * TAXTPS);
        message = "Le montant des taxes pour la TVQ est de : $" + String.format("%.2f", taxtvq) + "\n" +
                  "Le montant des taxes pour la TPS est de : $" + String.format("%.2f", taxtps);
    }

    public void CalculPrixApAyer(){
        calculTaxes();
        prixTotal = this.prix + taxtvq + taxtps;
        message +="\nLe prix avant taxes est: $" + this.prix + "\nLe prix total de l'article est de : $" + String.format("%.2f", prixTotal);
        JOptionPane.showMessageDialog(null, message);
    }

    
}
