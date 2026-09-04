//Felipe Acevedo

// Exercice 3
// Faire le programme Exercice3 qui permet
//  De lire les informations suivantes pour un citoyen lors d’un excès de vitesse :
//  Le type de route (M pour municipale, A pour autoroute)
//  La limite de vitesse permise en km/h
//  La vitesse du contrevenant en km/h
//  De calculer et d’afficher le montant de l’amende à payer si :
//  Des frais de cour de 25$ sont toujours exigibles ;
//  Des frais sont à payer selon le nombre de km/h excédant la limite autorisée : ils sont de 15$ par km/h
// excédentaire sur une route municipale, mais de 20$ sur une autoroute ou si le dépassement de vitesse
// est de 25 km/h ou plus ;
//  L’amende minimum est de 100$, sauf si l’excès de vitesse est de moins de 5 km/h dans une zone où la
// limite est moins que 50 km/h

// Exercise 3 Labo2
// Reprendre le programme Exercice3 de votre labo 1 et lui ajouter au départ le message « Combien de limites de vitesse
// voulez-vous traiter ? : » et placer cette valeur dans un variable nbLimites. Vous allez utiliser une boucle « for » pour traiter
// nbLimites de vitesse selon l’énoncé suivant



import java.io.*;

public class Exercice3 {
  static BufferedReader clavier;

  public static void exercice3() throws Exception{
    int vitesse_contrevenant, vitesse_permise, frais_amande=0, total_payer=0, vitesse_amandee=0, i;
    final int FRAIS_COUR = 25, AMANDE_MINIMUM = 100, NBLIMTES;
    char type_route = ' ';

    int tabMunicipale[] = {0},tabAutoroute[]= {0};



    clavier = new BufferedReader(new InputStreamReader(System.in));

    System.out.print("Combien de limites de vitesse voulez-vous traiter?: ");
    NBLIMTES = Integer.parseInt(clavier.readLine());

    for (i = 1; i <= NBLIMTES; i++){
      System.out.print("Entrez un type  de route (M pour Municipale, A pour Autoroute): ");
      type_route= clavier.readLine().toUpperCase().charAt(0);


      System.out.print("Entrez la vitesse permise en km/h: ");
      vitesse_permise=Integer.parseInt(clavier.readLine());

      System.out.print("Entrez la vitesse contrevenant en km/h: ");
      vitesse_contrevenant=Integer.parseInt(clavier.readLine());

      if (type_route==('A')  || vitesse_contrevenant - vitesse_permise >= 25){
        frais_amande = 20;
      } else if (type_route==('M') ){
        frais_amande = 15;
      }

      vitesse_amandee = vitesse_contrevenant - vitesse_permise;
      total_payer = FRAIS_COUR + vitesse_amandee * frais_amande;

      if (vitesse_permise >= vitesse_contrevenant){
        total_payer = 0;
        System.out.println("Vouz n'avez pas des amandes.");
      }else if (total_payer < 100 && vitesse_permise < 50 && vitesse_amandee < 5 ){
        total_payer = (frais_amande * vitesse_amandee) + FRAIS_COUR;
      } else if (total_payer < 100){
        total_payer = AMANDE_MINIMUM;
      }

      if (total_payer >0)
      System.out.println("Total à payer est: " + total_payer + "$");

      if (type_route == 'A'){
        tabAutoroute[0] += total_payer;
      }else if (type_route == 'M'){
        tabMunicipale[0] += total_payer;
      }
    }
    System.out.println("\n" + "TOTAL DES CONTRAVENTIONS POUR UNE ROUTE MUNICIPALE: " + String.format("%.2f",(float)tabMunicipale[0]) + "$");
    System.out.println("TOTAL DES CONTRAVENTIONS POUR UNE AUTOROUTE: " + String.format("%.2f",(float)tabAutoroute[0]) + "$");
  }

  public static void main(String[] args) throws Exception{

    exercice3();
  }
}
