import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Laboratoire3 {
  static BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));

  public static int menu() throws Exception {
    int choix;
    System.out.println("\n*** LABORATOIRE 3 ***");
    System.out.println("1-Exercice 1");
    System.out.println("2-Exercice 2");
    System.out.println("3-Exercice 3");
    System.out.println("4- Quitter");
    System.out.print("Entrez votre choix : ");
    choix = Integer.parseInt(clavier.readLine());
    return choix;
  }
  public static void main(String[] args) throws Exception {

    int choix;
    do {
      choix = menu();
      // clrscr();
      switch (choix) {
        case 1:
          Exercice1.exercice1();
          break;
        case 2:
          Exercice2.exercice2();
          break;
        case 3:
          Exercice3.exercice3();
          break;
        case 4:
          System.out.println("Merci d'avoir utiliser notre programme");
          break;
        default:
          System.out.println("Choix invalide");
          break;
      }
    } while (choix != 4);
  }
}
