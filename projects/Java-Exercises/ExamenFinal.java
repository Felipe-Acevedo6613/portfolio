import java.io.*;

public class ExamenFinal {
    static BufferedReader clavier;
    public static final int NB_EMP = 11;
    static int tabNumEmploye[] = new int[NB_EMP];
    static int tabSexe[] = new int[NB_EMP];
    static int tabStatut[] = new int[NB_EMP];
    static int tabAge[] = new int[NB_EMP];

    public static void chargerDonnees() throws IOException {
      clavier = new BufferedReader(new InputStreamReader(System.in));
    
     for (int i = 0; i < NB_EMP; i++ ){

      System.out.print("Entrez votre Numero demploye, entrez -1 pour terminer: ");
      tabNumEmploye[i]=Integer.parseInt(clavier.readLine());
      if (tabNumEmploye[i] == -1) {
        break;
      }
      System.out.print("Entrez votre Sexe 1 pour femme, 2 pour homme: ");
      tabSexe[i]=Integer.parseInt(clavier.readLine());
      System.out.print("Entrez votre Statut 1 pour marie, 2 pour celibataire: ");
      tabStatut[i]=Integer.parseInt(clavier.readLine());
      System.out.print("Entrez votre age: ");
      tabAge[i]=Integer.parseInt(clavier.readLine());
      //System.out.println(tabNumEmploye[i]);
      //System.out.println(tabSexe[i]);
      //System.out.println(tabStatut[i]);
      //System.out.println(tabAge[i]);
      }

      System.out.println("\n" + "Numemp\tSexe\tStatut\tAge ");
      for (int i = 0; i < NB_EMP; i++) {
          if (tabNumEmploye[i] != -1 && tabNumEmploye[i] != 0){
              System.out.println(tabNumEmploye[i] + "\t" + tabSexe[i] + "\t" + tabStatut[i] + "\t" + tabAge[i]);
            }
        }    
    }    

    public static int femmesBas30Mariees() {
        int compteur = 0;
        for (int i = 0; i < NB_EMP; i++) {
            if (tabSexe[i] == 1 && tabStatut[i] == 2 && tabAge[i] < 30) {
                compteur++;
            }
        }
        System.out.println("Le nombre de femmes de moins de 30 ans qui sont mariées est: " + compteur);

        return compteur;
    }
    public static int femmesCelibataires() {
        int compteur = 0;
        for (int i = 0; i < NB_EMP; i++) {
            if (tabSexe[i] == 1 && tabStatut[i] == 2) {
                compteur++;
            }
        }
        System.out.println("Le nombre de femmes célibataires est:" + compteur);

        return compteur;
    }

    public static int personnesCelibataires() {
        int compteur = 0;
        for (int i = 0; i < NB_EMP; i++) {
            if (tabStatut[i] == 2) {
                compteur++;
            }
        }
        System.out.println("Le nombre de personnes (hommes ou femmes) célibataires : " + compteur);

        return compteur;
    }

    public static double moyenneAgeFemmesCelibataires() {
        int compteur = 0;
        int sommeAge = 0;
        int moyenne = 0;
        
        for (int i = 0; i < NB_EMP; i++) {
            if (tabSexe[i] == 1 && tabStatut[i] == 2) {
                sommeAge += tabAge[i];
                compteur++;
            }
        }
        moyenne = sommeAge / compteur;
        //return (moyenne > 0) ? ((double) sommeAge / compteur) : 0;
        System.out.println("La moyenne d’âge des femmes célibataires : " + moyenne);
        return moyenne;
    }

    


    public static void stats() {
        femmesBas30Mariees();
        femmesCelibataires();
        personnesCelibataires();
        moyenneAgeFemmesCelibataires();

    }
    

    public static void main(String[] args) throws Exception {

    chargerDonnees();
    stats();

    }
}
