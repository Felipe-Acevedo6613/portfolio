// Felipe Acevedo

//Exercice 1 Labo 1
//Faire le programme Exercice1 (le nom du programme) qui permet
// De lire les informations suivantes pour un client :
// Le nom du client
// Le nombre de jours de location d’un categorie_outil
// La catégorie d’outil loué
//Catégorie Tarif par jour
//A pour categorie_outil léger 15$ par jour
//W pour categorie_outil lourd 42$ par jour
//P pour categorie_outil professionnel 50$ par jour
// De calculer et d’afficher le nom du client et le montant total à payer sachant que si quelqu’un loue pour
//plus de 3 jours un categorie_outil professionnel ou lourd, on lui accorde un rabais de 20% du prix de location. Si le
//montant total de la location dépasse 200$ (après le rabais de 20%, si applicable), on offre un rabais de 5%.

// Exercice1 labo 2
// Reprendre votre Exercice1 du labo1 (le nom du programme) qui permet de lire les information d’un seul client et
// vous allez lui ajouter une boucle « do-while » pour pouvoir lire un nombre quelconque de clients. La boucle va
// s’arrêter lorsque l’usager va taper « N » à la question suivante : « Voulez-vous continuer (O/N) : ». Regarder les
// exemples des notes de cours dont vous avez des exemples. Lorsque l’utilisateur taper « N » et qu’on sort de la boucle
// vous allez afficher « TOTAL DES VENTES : XXX.XX$» XXX.XX$-signifie qu’on veut afficher avec 2 décimales suivi d’un
// $) qui correspond au total de toutes les vents faites après avoir l’enlever les rabais.

import java.io.*;

public class Exercice1 {
    static BufferedReader clavier;
    static final int MAX = 99;
  public static void exercice1() throws Exception{
    String nom_du_client;
    char categorie_outil = ' ', reponse = ' ';
    int nombre_client, jours_location, tarife_jour = 0, montant_payer, montant_payer_final, rabais, total_ventes = 0, i = 0, nbElems;
    int tabTotalPayer[] = new int[MAX];
    String tabNoms[] = new String[MAX];


    clavier = new BufferedReader(new InputStreamReader(System.in));
    do{
      System.out.print("Entrez votre nom: ");
      nom_du_client=(clavier.readLine());

      System.out.println("Entrez le nombre du client: ");
      nombre_client = Integer.parseInt(clavier.readLine());

      System.out.print("Entrez le nombre de jours de location: ");
      jours_location=Integer.parseInt(clavier.readLine());


      System.out.print("Entrez la categorie de l'categorie_outil (A, W ou P): ");
      categorie_outil = clavier.readLine().toUpperCase().charAt(0);
      if (categorie_outil == ('A')){
        tarife_jour = 15;
      } else if (categorie_outil == ('W')){
        tarife_jour = 42;
      } else if (categorie_outil == ('P')){
        tarife_jour = 50;
      }

      montant_payer = jours_location * tarife_jour;

      if (categorie_outil != 'A' && jours_location > 3 && montant_payer <= 200) {
        rabais = (montant_payer / 100 * 20 ) ;
        System.out.println("Vous avez une rabais de 20% parce que vous avez loue l'outil pendant plus de 3 jours.");
      } else if (categorie_outil != 'A' && jours_location > 3 && montant_payer > 200 ){
        rabais = (montant_payer/ 100 * 25 ) ;
        System.out.println("Vous avez une rabais de 20% parce que vous avez loue l'outil pendant plus de 3 jours + une autre rabais de 5% aditionel parce que votre montant a payer depasse les $200.");
      } else {
        rabais = 0;
      }

      montant_payer_final = montant_payer - rabais;
      System.out.println("Nom de client: " + nom_du_client + "." + "\nNombre du client " + nombre_client + "\nMontant á payer: " + String.format("%.2f",(float)montant_payer_final) + "$.");

      System.out.println("Voulez-vous continuer (O/N) :");
      reponse = clavier.readLine().toUpperCase().charAt(0);
      total_ventes += montant_payer_final;
      tabNoms[i] = nom_du_client;
      tabTotalPayer[i] = montant_payer_final;
      i++;
    } while (reponse == 'O');
    nbElems =  i;

    System.out.println("\nTotal de ventes acumules: " + String.format("%.2f",(float)total_ventes) + "$.");

    System.out.println("\n" + "Nom de client\tTotal Payee ");


    for (i = 0; i < nbElems; i++) {
      System.out.println(tabNoms[i] + "\t\t" + tabTotalPayer[i]);
    }

  }
  public static void main (String[] args) throws Exception {

    exercice1();

  }
}
