import javax.swing.JOptionPane;

public class gestionArticles{
  public Article article;


  public static void calculerPrixSelonOrigine(){
    int origine = Integer.parseInt(JOptionPane.showInputDialog("Entrez l'origine de l'article (1: Quebec, 2: Hors Quebec, 3: Non Canadien): "));
    double prix = Double.parseDouble(JOptionPane.showInputDialog("Entrez le prix de l'article: "));
    if (origine == 1){
      ArticleQuebec article = new ArticleQuebec(1, "", prix, "", "Quebec");
      article.CalculPrixApAyer();
    }else if (origine == 2){
      ArticleHorsQuebec article = new ArticleHorsQuebec(1, "", prix, "", true);
      article.CalculPrixApAyer();
    }else if (origine == 3){
      ArticleNonCanadien article = new ArticleNonCanadien(1, "", prix, "", true);
      article.CalculPrixApAyer();
    }

  }
  public static void main(String[] args) throws Exception {
    // ArticleQuebec article1 = new ArticleQuebec(1, "Pomme", 1.50, "Fruit", true);
    // System.out.println("Le prix de l'article avant taxes est : $" + article1.prix);
    // article1.CalculPrixApAyer();

    // ArticleHorsQuebec article2 = new ArticleHorsQuebec(2, "Banane", 2.50, "Fruit");
    // System.out.println("Le prix de l'article avant taxes est : $" + article2.prix);
    // article2.CalculPrixApAyer();

    // ArticleNonCanadien article3 = new ArticleNonCanadien(3, "Ananas", 3.50, "Fruit");
    // System.out.println("Le prix de l'article avant taxes est : $" + article3.prix);
    // article3.CalculPrixApAyer();
    calculerPrixSelonOrigine();
  }

}