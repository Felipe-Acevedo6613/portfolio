
//Felipe Acevedo

//Exercice 2 Labo 1
//Écrire le programme Exercice2 qui permet
// De lire les informations suivantes pour un employé :
// Le nombre d’heures travaillées dans l’année par l’employé
// La catégorie d’employé (C pour cadre, P pour professeur, S pour secrétaire, A pour tout autre)
// De calculer et d’afficher le boni donné à Noël à l’employé sachant qu’on donne un boni de 100$ à tous les
//employés travaillant normalement 40 heures ou plus par semaine, ainsi qu’à tous les employés ayant
//accumulé plus de 50 heures de temps supplémentaire dans l’année. Voici les heures normales de travail par
//semaine selon la catégorie d’employés :
//Catégorie Nb heures semaine normale
//cadre 35
//professeur 45
//secrétaire 37.5
//tout autre 32.5
// Si l’employé n’a pas droit au boni, faire afficher un message indiquant qu’il n’a pas droit au boni.

// Exercice 2 Labo 2
// Reprendre votre Exercice2 du labo 1 et lui ajouter une boucle « while » que va s’arrêter lorsque l’usager tapera -1 (valeur
// sentinelle) comme nombre d’heures travaillées.


import java.io.*;
// import java.util.concurrent.Semaphore;

public class Exercice2 {
    static BufferedReader clavier;

  public static void exercice2() throws Exception{
    Double heures_anne = 0.0, heures_semaine = 0.0;
    char categorie_employe = ' ';
    final int SEMAINES_ANNE = 52;
    final int HEURES_ANNE_C = 1820, HEURES_ANNE_P = 2340, HEURES_ANNE_S = 1950, HEURES_ANNE_A = 1690, SENTINELLE = -1;
    int bonis_donnes = 0;
    int tabBonis[] = {0};

    clavier = new BufferedReader(new InputStreamReader(System.in));


    while (heures_anne != SENTINELLE){
      System.out.print("Entrez le nombre d'heures travailles tout au long de l'anne  (Tapez -1 pour finalizer): ");
      heures_anne=Double.parseDouble(clavier.readLine());

      if (heures_anne != SENTINELLE){
        // while (categorie_employe != 'C' && categorie_employe != 'P' && categorie_employe != 'S' && categorie_employe != 'A'){
        // System.out.print("Entrez la categorie de l'categorie de l'employe (C pour Cadre, P pour Professeur, S pour Secrétaire, A pour Autre): ");
        // categorie_employe= clavier.readLine().toUpperCase().charAt(0);
        // }

        System.out.print("Entrez la catecgorie de l'employe: ");
        categorie_employe = clavier.readLine().toUpperCase().charAt(0);

        heures_semaine = heures_anne / SEMAINES_ANNE;

        if (categorie_employe == 'C'  && (heures_semaine >= 40 || heures_anne > HEURES_ANNE_C + 50  )){
          System.out.println("L’employé a droit au boni!");
          bonis_donnes++;
        } else if (categorie_employe == 'P' && (heures_semaine >= 40 || heures_anne > HEURES_ANNE_P + 50  )){
        System.out.println("L’employé a droit au boni!");
          bonis_donnes++;
        } else if (categorie_employe == 'S' && (heures_semaine >= 40 || heures_anne > HEURES_ANNE_S + 50  )){
        System.out.println("L’employé a droit au boni!");
          bonis_donnes ++;
        } else if (categorie_employe == 'A' && (heures_semaine >= 40 || heures_anne > HEURES_ANNE_A + 50  )){
        System.out.println("L’employé a droit au boni!");
          bonis_donnes ++;
        } else {
          System.out.println("L’employé n'a pas droit au boni!");
        }
      }
      tabBonis[0] = bonis_donnes;
    }
    System.out.println("\nTOTAL DES BONIS: " + tabBonis[0]);
  }
  public static void main(String[] args) throws Exception {

    exercice2();

  }
}
