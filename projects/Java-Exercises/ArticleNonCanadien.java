import javax.swing.JOptionPane;

public class ArticleNonCanadien extends Article{

    String message;
    protected boolean origineNonc;

    public ArticleNonCanadien(int id, String nom, double prix, String marque, boolean origineNonc){
        super(id, nom, prix, marque);
        this.origineNonc = origineNonc;

    }
    
    public void calculTaxes(){
        message = "L'article n'est pas taxable, total: $" + prix;
    }

    public void CalculPrixApAyer(){
        calculTaxes();
        message += "\nLe prix total de l'article est de : $" + String.format("%.2f", prix);
        JOptionPane.showMessageDialog(null, message);
    }
}
