import java.util.ArrayList;

public class App {

    public static void trierParSelection(int [] table){
        for(int pos = 0; pos < table.length-1; pos++){
            int indexMin = pos;
            for(int k = pos+1; k < table.length; k++){
                if(table[k] < table[indexMin]){
                    indexMin = k;
                }
            }
            if (pos != indexMin){
                int temp = table[pos];
                table[pos] = table[indexMin];
                table[indexMin] = temp;

            }
        }

    } 

    public static void trierParEnumeration(int tab[], int nbElements){
        int compteur[] = new int [nbElements];
        int tableTriee[] = new int [nbElements];  
        for(int k = 0; k < nbElements; k++){
            compteur[k] = 0;
        }
        for(int pos = 0; pos < nbElements -1; pos++){
            for(int k = pos+1; k < nbElements-1; k++){
                if(tab[pos] > tab[k]){
                    compteur[pos] = compteur[pos]+1;
                } else {
                    compteur[k] = compteur[k]+1;
                }
            }
        }
        for(int k = 0; k < nbElements-1; k++){
            int indice = compteur[k];
            tableTriee[indice] = tab[k];
        }
        for(int k = 0; k < nbElements-1; k++){
            tab[k] = tableTriee[k];
        }

    }

    public static void trierParInsertion(int table[], int nbElements){
        for(int pos = 1; pos < nbElements; pos++){
            int valeurAinserer = table[pos];
            int k = pos - 1;
            while(k >= 0 && valeurAinserer < table[k]){
                table[k+1] = table[k];
                k--;
            }
            table[k+1] = valeurAinserer;
        }

    }

    public static void trierParBulle(int []table, int nbElements){
        int fin = nbElements -1;
        boolean faitEchange = false;
        
        do{
          faitEchange = false;
          for(int k = 0; k < fin ; k ++){
            if (table[k] > table[k + 1]){
              int temp = table[k];
              table[k] = table[k + 1];
              table[k + 1] = temp;
              faitEchange = true;
            }
          }
          fin = fin - 1;
    
        }while (fin > 0 && faitEchange == true);
    }


    public static void main(String[] args) {

        //****************************************************************************************************************************************************
        //TRIER 5000 ELEMENTS PAR SELECTION
        long tempsExecution = 0;
        long moyenne = 0;
        long moyenneCalcule = 0;
        long tabtempsMoyenne[] = new long [3];
        ArrayList<Long> moyenneGeneralSelection = new ArrayList<Long>();

        long tempsIniciel = System.nanoTime();
        long tempsFin = System.nanoTime();
        tempsExecution = (tempsFin - tempsIniciel);

        for(int k = 1; k < 3; k++){
            int tab5000[] = new int [5000];
            for(int i=0; i < 5000; i++){
                tab5000[i] = 5000 -i;
            }
            tempsIniciel = System.nanoTime();
            trierParSelection(tab5000);
            tempsFin = System.nanoTime();
            tempsExecution = (tempsFin - tempsIniciel);
            tabtempsMoyenne[k] = tempsExecution;
            for(int i = 0; i < tab5000.length; i++){
                System.out.print(tab5000[i]+ ", ");
            }
            // System.out.println("temps d'execution pour trier par selection dans un array de 5000 elements est de: " + tempsExecution + " nansegunds.");
        }
        for(int i = 0; i < tabtempsMoyenne.length; i++){
           System.out.println("temps: " + tabtempsMoyenne[i] + " nanosegunds.");
           moyenne += tabtempsMoyenne[i];
           moyenneCalcule = moyenne/3;
        }
        System.out.println("moyenne pour un tableau de 5000 elements: " + moyenneCalcule + " nanosegunds.");

        moyenneGeneralSelection.add((long)(moyenneCalcule));
        //****************************************************************************************************************************************************
        // TRIER 10000 ELEMENTS PAR SELECTION
        tempsExecution = 0;
        moyenne = 0;
        moyenneCalcule = 0;
        for(int k = 0; k < 3; k++){
            int tab10000[] = new int [10000];
            for(int i=0; i < 10000; i++){
                tab10000[i] = 10000 -i;
            }
            tempsIniciel = System.nanoTime();
            trierParSelection(tab10000);
            tempsFin = System.nanoTime();
            tempsExecution = (tempsFin - tempsIniciel);
            tabtempsMoyenne[k] = tempsExecution;
            for(int i = 0; i < tab10000.length; i++){
                // System.out.print(tab10000[i]+ ", ");
            }
            System.out.println("temps d'execution pour trier par selection dans un array de 10000 elements est de: " + tempsExecution + " nansegunds.");
        }
        for(int i = 0; i < tabtempsMoyenne.length; i++){
           System.out.println("temps: " + tabtempsMoyenne[i] + " nanosegunds.");
           moyenne += tabtempsMoyenne[i];
           moyenneCalcule = moyenne/3;
        }
        System.out.println("moyenne pour un tableau de 1000 elements: " + moyenneCalcule + " nanosegunds.");
        moyenneGeneralSelection.add((long)(moyenneCalcule));

        //****************************************************************************************************************************************************
        //TRIER 15000 ELEMENTS PAR SELECTION
        tempsExecution = 0;
        moyenne = 0;
        moyenneCalcule = 0;

        for(int k = 0; k < 3; k++){
            int tab15000[] = new int [15000];
            for(int i=0; i < 15000; i++){
                tab15000[i] = 15000 -i;
            }
            tempsIniciel = System.nanoTime();
            trierParSelection(tab15000);
            tempsFin = System.nanoTime();
            tempsExecution = (tempsFin - tempsIniciel);
            tabtempsMoyenne[k] = tempsExecution;
            for(int i = 0; i < tab15000.length; i++){
                // System.out.print(tab15000[i]+ ", ");
            }
            System.out.println("temps d'execution pour trier par selection dans un array de 15000 elements est de: " + tempsExecution + " nansegunds.");
        }
        for(int i = 0; i < tabtempsMoyenne.length; i++){
           System.out.println("temps: " + tabtempsMoyenne[i] + " nanosegunds.");
           moyenne += tabtempsMoyenne[i];
           moyenneCalcule = moyenne/3;
        }
        System.out.println("moyenne pour un tableau de 15000 elements: " + moyenneCalcule + " nanosegunds.");
        moyenneGeneralSelection.add((long)(moyenneCalcule));

        //****************************************************************************************************************************************************
        //TRIER 20000 ELEMENTS PAR SELECTION
        tempsExecution = 0;
        moyenne = 0;
        moyenneCalcule = 0;

        for(int k = 0; k < 3; k++){
            int tab20000[] = new int [20000];
            for(int i=0; i < 20000; i++){
                tab20000[i] = 20000 -i;
            }
            tempsIniciel = System.nanoTime();
            trierParSelection(tab20000);
            tempsFin = System.nanoTime();
            tempsExecution = (tempsFin - tempsIniciel);
            tabtempsMoyenne[k] = tempsExecution;
            for(int i = 0; i < tab20000.length; i++){
                // System.out.print(tab20000[i]+ ", ");
            }
            System.out.println("temps d'execution pour trier par selection dans un array de 20000 elements est de: " + tempsExecution + " nansegunds.");
        }
        for(int i = 0; i < tabtempsMoyenne.length; i++){
           System.out.println("temps: " + tabtempsMoyenne[i] + " nanosegunds.");
           moyenne += tabtempsMoyenne[i];
           moyenneCalcule = moyenne/3;
        }
        System.out.println("moyenne pour un tableau de 20000 elements: " + moyenneCalcule + " nanosegunds.");
        moyenneGeneralSelection.add((long)(moyenneCalcule));

        //****************************************************************************************************************************************************
        //TRIER 25000 ELEMENTS PAR SELECTION
        tempsExecution = 0;
        moyenne = 0;
        moyenneCalcule = 0;
        for(int k = 0; k < 3; k++){
            int tab25000[] = new int [25000];
            for(int i=0; i < 25000; i++){
                tab25000[i] = 25000 -i;
            }
            tempsIniciel = System.nanoTime();
            trierParSelection(tab25000);
            tempsFin = System.nanoTime();
            tempsExecution = (tempsFin - tempsIniciel);
            tabtempsMoyenne[k] = tempsExecution;
            for(int i = 0; i < tab25000.length; i++){
                // System.out.print(tab25000[i]+ ", ");
            }
            System.out.println("temps d'execution pour trier par selection dans un array de 25000 elements est de: " + tempsExecution + " nansegunds.");
        }
        for(int i = 0; i < tabtempsMoyenne.length; i++){
           System.out.println(i+1 + " temps: " + tabtempsMoyenne[i] + " nanosegunds.");
           moyenne += tabtempsMoyenne[i];
           moyenneCalcule = moyenne/3;
        }
        // System.out.println("moyenne pour un tableau de 25000 elements: " + moyenneCalcule + " nanosegunds.");
        moyenneGeneralSelection.add((long)(moyenneCalcule));

        for(int i = 0; i < moyenneGeneralSelection.size(); i++){
            System.out.println("moyenne pour trier un tableau par selection de " + (i+1)*5000 + " elements: " + moyenneGeneralSelection.get(i) + " nanosegunds.");
        }
        //****************************************************************************************************************************************************
        //TRIER 5000 ELEMENTS PAR ENUMERATION
        ArrayList<Long> moyenneGeneralEnumeration = new ArrayList<Long>();

        tempsExecution = 0;
        moyenne = 0;
        moyenneCalcule = 0;
        for(int k = 0; k < 3; k++){
            int tab5000[] = new int [5000];
            for(int i=0; i < 5000; i++){
                tab5000[i] = 5000 -i;
            }
            tempsIniciel = System.nanoTime();
            trierParEnumeration(tab5000, 5000);
            tempsFin = System.nanoTime();
            tempsExecution = (tempsFin - tempsIniciel);
            tabtempsMoyenne[k] = tempsExecution;
            for(int i = 0; i < tab5000.length; i++){
                // System.out.print(tab5000[i]+ ", ");
            }
            System.out.println("temps d'execution pour trier par Enumeration dans un array de 5000 elements est de: " + tempsExecution + " nansegunds.");
        }
        for(int i = 0; i < tabtempsMoyenne.length; i++){
        System.out.println("temps: " + tabtempsMoyenne[i] + " nanosegunds.");
        moyenne += tabtempsMoyenne[i];
        moyenneCalcule = moyenne/3;
        }
        System.out.println("moyenne pour un tableau de 5000 elements: " + moyenneCalcule + " nanosegunds.");
        moyenneGeneralEnumeration.add((long)(moyenneCalcule));
        //****************************************************************************************************************************************************
        // TRIER 10000 ELEMENTS PAR ENUMERATION
        tempsExecution = 0;
        moyenne = 0;
        moyenneCalcule = 0;
        for(int k = 0; k < 3; k++){
            int tab10000[] = new int [10000];
            for(int i=0; i < 10000; i++){
                tab10000[i] = 10000 -i;
            }
            tempsIniciel = System.nanoTime();
            trierParEnumeration(tab10000, 10000);
            tempsFin = System.nanoTime();
            tempsExecution = (tempsFin - tempsIniciel);
            tabtempsMoyenne[k] = tempsExecution;
            for(int i = 0; i < tab10000.length; i++){
                // System.out.print(tab10000[i]+ ", ");
            }
            System.out.println("temps d'execution pour trier par Enumeration dans un array de 10000 elements est de: " + tempsExecution + " nansegunds.");
        }
        for(int i = 0; i < tabtempsMoyenne.length; i++){
        System.out.println("temps: " + tabtempsMoyenne[i] + " nanosegunds.");
        moyenne += tabtempsMoyenne[i];
        moyenneCalcule = moyenne/3;
        }
        System.out.println("moyenne pour un tableau de 1000 elements: " + moyenneCalcule + " nanosegunds.");
        moyenneGeneralEnumeration.add((long)(moyenneCalcule));

        //****************************************************************************************************************************************************
        //TRIER 15000 ELEMENTS PAR ENUMERATION
        tempsExecution = 0;
        moyenne = 0;
        moyenneCalcule = 0;

        for(int k = 0; k < 3; k++){
            int tab15000[] = new int [15000];
            for(int i=0; i < 15000; i++){
                tab15000[i] = 15000 -i;
            }
            tempsIniciel = System.nanoTime();
            trierParEnumeration(tab15000, 15000);
            tempsFin = System.nanoTime();
            tempsExecution = (tempsFin - tempsIniciel);
            tabtempsMoyenne[k] = tempsExecution;
            for(int i = 0; i < tab15000.length; i++){
                // System.out.print(tab15000[i]+ ", ");
            }
            System.out.println("temps d'execution pour trier par Enumeration dans un array de 15000 elements est de: " + tempsExecution + " nansegunds.");
        }
        for(int i = 0; i < tabtempsMoyenne.length; i++){
        System.out.println("temps: " + tabtempsMoyenne[i] + " nanosegunds.");
        moyenne += tabtempsMoyenne[i];
        moyenneCalcule = moyenne/3;
        }
        System.out.println("moyenne pour un tableau de 15000 elements: " + moyenneCalcule + " nanosegunds.");
        moyenneGeneralEnumeration.add((long)(moyenneCalcule));

        //****************************************************************************************************************************************************
        //TRIER 20000 ELEMENTS PAR ENUMERATION
        tempsExecution = 0;
        moyenne = 0;
        moyenneCalcule = 0;

        for(int k = 0; k < 3; k++){
            int tab20000[] = new int [20000];
            for(int i=0; i < 20000; i++){
                tab20000[i] = 20000 -i;
            }
            tempsIniciel = System.nanoTime();
            trierParEnumeration(tab20000, 20000);
            tempsFin = System.nanoTime();
            tempsExecution = (tempsFin - tempsIniciel);
            tabtempsMoyenne[k] = tempsExecution;
            for(int i = 0; i < tab20000.length; i++){
                // System.out.print(tab20000[i]+ ", ");
            }
            System.out.println("temps d'execution pour trier par Enumeration dans un array de 20000 elements est de: " + tempsExecution + " nansegunds.");
        }
        for(int i = 0; i < tabtempsMoyenne.length; i++){
        System.out.println("temps: " + tabtempsMoyenne[i] + " nanosegunds.");
        moyenne += tabtempsMoyenne[i];
        moyenneCalcule = moyenne/3;
        }
        System.out.println("moyenne pour un tableau de 20000 elements: " + moyenneCalcule + " nanosegunds.");
        moyenneGeneralEnumeration.add((long)(moyenneCalcule));

        //****************************************************************************************************************************************************
        //TRIER 25000 ELEMENTS PAR ENUMERATION
        tempsExecution = 0;
        moyenne = 0;
        moyenneCalcule = 0;
        for(int k = 0; k < 3; k++){
            int tab25000[] = new int [25000];
            for(int i=0; i < 25000; i++){
                tab25000[i] = 25000 -i;
            }
            tempsIniciel = System.nanoTime();
            trierParEnumeration(tab25000, 25000);
            tempsFin = System.nanoTime();
            tempsExecution = (tempsFin - tempsIniciel);
            tabtempsMoyenne[k] = tempsExecution;
            for(int i = 0; i < tab25000.length; i++){
                // System.out.print(tab25000[i]+ ", ");
            }
            System.out.println("temps d'execution pour trier par Enumeration dans un array de 25000 elements est de: " + tempsExecution + " nansegunds.");
        }
        for(int i = 0; i < tabtempsMoyenne.length; i++){
        System.out.println(i+1 + " temps: " + tabtempsMoyenne[i] + " nanosegunds.");
        moyenne += tabtempsMoyenne[i];
        moyenneCalcule = moyenne/3;
        }
        // System.out.println("moyenne pour un tableau de 25000 elements: " + moyenneCalcule + " nanosegunds.");
        moyenneGeneralEnumeration.add((long)(moyenneCalcule));

        for(int i = 0; i < moyenneGeneralEnumeration.size(); i++){
            System.out.println("moyenne pour trier un tableau par Enumeration de " + (i+1)*5000 + " elements: " + moyenneGeneralEnumeration.get(i) + " nanosegunds.");
        }
       
        //****************************************************************************************************************************************************
        //TRIER 5000 ELEMENTS PAR INSERTION

        ArrayList<Long> moyenneGeneralInsertion = new ArrayList<Long>();

        tempsExecution = 0;
        moyenne = 0;
        moyenneCalcule = 0;
        for(int k = 0; k < 3; k++){
            int tab5000[] = new int [5000];
            for(int i=0; i < 5000; i++){
                tab5000[i] = 5000 -i;
            }
            tempsIniciel = System.nanoTime();
            trierParInsertion(tab5000, 5000);
            tempsFin = System.nanoTime();
            tempsExecution = (tempsFin - tempsIniciel);
            tabtempsMoyenne[k] = tempsExecution;
            for(int i = 0; i < tab5000.length; i++){
                // System.out.print(tab5000[i]+ ", ");
            }
            System.out.println("temps d'execution pour trier par Insertion dans un array de 5000 elements est de: " + tempsExecution + " nansegunds.");
        }
        for(int i = 0; i < tabtempsMoyenne.length; i++){
        System.out.println("temps: " + tabtempsMoyenne[i] + " nanosegunds.");
        moyenne += tabtempsMoyenne[i];
        moyenneCalcule = moyenne/3;
        }
        System.out.println("moyenne pour un tableau de 5000 elements: " + moyenneCalcule + " nanosegunds.");
        moyenneGeneralInsertion.add((long)(moyenneCalcule));
        //****************************************************************************************************************************************************
        //TRIER 10000 ELEMENTS PAR INSERTION
        tempsExecution = 0;
        moyenne = 0;
        moyenneCalcule = 0;
        for(int k = 0; k < 3; k++){
            int tab10000[] = new int [10000];
            for(int i=0; i < 10000; i++){
                tab10000[i] = 10000 -i;
            }
            tempsIniciel = System.nanoTime();
            trierParInsertion(tab10000, 10000);
            tempsFin = System.nanoTime();
            tempsExecution = (tempsFin - tempsIniciel);
            tabtempsMoyenne[k] = tempsExecution;
            for(int i = 0; i < tab10000.length; i++){
                // System.out.print(tab10000[i]+ ", ");
            }
            System.out.println("temps d'execution pour trier par Insertion dans un array de 10000 elements est de: " + tempsExecution + " nansegunds.");
        }
        for(int i = 0; i < tabtempsMoyenne.length; i++){
        System.out.println("temps: " + tabtempsMoyenne[i] + " nanosegunds.");
        moyenne += tabtempsMoyenne[i];
        moyenneCalcule = moyenne/3;
        }
        System.out.println("moyenne pour un tableau de 10000 elements: " + moyenneCalcule + " nanosegunds.");
        moyenneGeneralInsertion.add((long)(moyenneCalcule));
        //****************************************************************************************************************************************************
        //TRIER 15000 ELEMENTS PAR ENUMERATION
        tempsExecution = 0;
        moyenne = 0;
        moyenneCalcule = 0;
        for(int k = 0; k < 3; k++){
            int tab15000[] = new int [15000];
            for(int i=0; i < 15000; i++){
                tab15000[i] = 15000 -i;
            }
            tempsIniciel = System.nanoTime();
            trierParInsertion(tab15000, 15000);
            tempsFin = System.nanoTime();
            tempsExecution = (tempsFin - tempsIniciel);
            tabtempsMoyenne[k] = tempsExecution;
            for(int i = 0; i < tab15000.length; i++){
                // System.out.print(tab15000[i]+ ", ");
            }
            System.out.println("temps d'execution pour trier par Insertion dans un array de 15000 elements est de: " + tempsExecution + " nansegunds.");
        }
        for(int i = 0; i < tabtempsMoyenne.length; i++){
        System.out.println("temps: " + tabtempsMoyenne[i] + " nanosegunds.");
        moyenne += tabtempsMoyenne[i];
        moyenneCalcule = moyenne/3;
        }
        System.out.println("moyenne pour un tableau de 15000 elements: " + moyenneCalcule + " nanosegunds.");
        moyenneGeneralInsertion.add((long)(moyenneCalcule));
        //****************************************************************************************************************************************************
        //TRIER 20000 ELEMENTS PAR INSERTION
        tempsExecution = 0;
        moyenne = 0;
        moyenneCalcule = 0;
        for(int k = 0; k < 3; k++){
            int tab20000[] = new int [20000];
            for(int i=0; i < 20000; i++){
                tab20000[i] = 20000 -i;
            }
            tempsIniciel = System.nanoTime();
            trierParInsertion(tab20000, 20000);
            tempsFin = System.nanoTime();
            tempsExecution = (tempsFin - tempsIniciel);
            tabtempsMoyenne[k] = tempsExecution;
            for(int i = 0; i < tab20000.length; i++){
                // System.out.print(tab20000[i]+ ", ");
            }
            System.out.println("temps d'execution pour trier par Insertion dans un array de 20000 elements est de: " + tempsExecution + " nansegunds.");
        }
        for(int i = 0; i < tabtempsMoyenne.length; i++){
        System.out.println("temps: " + tabtempsMoyenne[i] + " nanosegunds.");
        moyenne += tabtempsMoyenne[i];
        moyenneCalcule = moyenne/3;
        }
        System.out.println("moyenne pour un tableau de 20000 elements: " + moyenneCalcule + " nanosegunds.");
        moyenneGeneralInsertion.add((long)(moyenneCalcule));
        //****************************************************************************************************************************************************
        //TRIER 25000 ELEMENTS PAR INSERTION
        tempsExecution = 0;
        moyenne = 0;
        moyenneCalcule = 0;
        for(int k = 0; k < 3; k++){
            int tab25000[] = new int [25000];
            for(int i=0; i < 25000; i++){
                tab25000[i] = 25000 -i;
            }
            tempsIniciel = System.nanoTime();
            trierParInsertion(tab25000, 25000);
            tempsFin = System.nanoTime();
            tempsExecution = (tempsFin - tempsIniciel);
            tabtempsMoyenne[k] = tempsExecution;
            for(int i = 0; i < tab25000.length; i++){
                // System.out.print(tab25000[i]+ ", ");
            }
            System.out.println("temps d'execution pour trier par Insertion dans un array de 25000 elements est de: " + tempsExecution + " nansegunds.");
        }
        for(int i = 0; i < tabtempsMoyenne.length; i++){
        System.out.println("temps: " + tabtempsMoyenne[i] + " nanosegunds.");
        moyenne += tabtempsMoyenne[i];
        moyenneCalcule = moyenne/3;
        }
        System.out.println("moyenne pour un tableau de 25000 elements: " + moyenneCalcule + " nanosegunds.");
        moyenneGeneralInsertion.add((long)(moyenneCalcule));
        // ****************************************************************************************************************************************************
        // TRIER 5000 ELEMENTS PAR EchangeBulle
        ArrayList<Long> moyenneGeneralEchangeBulle = new ArrayList<Long>();

        tempsExecution = 0;
        moyenne = 0;
        moyenneCalcule = 0;
        for(int k = 0; k < 3; k++){
            int tab5000[] = new int [5000];
            for(int i=0; i < 5000; i++){
                tab5000[i] = 5000 -i;
            }
            tempsIniciel = System.nanoTime();
            trierParBulle(tab5000, 5000);
            tempsFin = System.nanoTime();
            tempsExecution = (tempsFin - tempsIniciel);
            tabtempsMoyenne[k] = tempsExecution;
            for(int i = 0; i < tab5000.length; i++){
                // System.out.print(tab5000[i]+ ", ");
            }
            System.out.println("temps d'execution pour trier par Insertion dans un array de 5000 elements est de: " + tempsExecution + " nansegunds.");
        }
        for(int i = 0; i < tabtempsMoyenne.length; i++){
        System.out.println("temps: " + tabtempsMoyenne[i] + " nanosegunds.");
        moyenne += tabtempsMoyenne[i];
        moyenneCalcule = moyenne/3;
        }
        System.out.println("moyenne pour un tableau de 5000 elements: " + moyenneCalcule + " nanosegunds.");
        moyenneGeneralEchangeBulle.add((long)(moyenneCalcule));
        // ****************************************************************************************************************************************************
        // TRIER 10000 ELEMENTS PAR EchangeBulle
        tempsExecution = 0;
        moyenne = 0;
        moyenneCalcule = 0;
        for(int k = 0; k < 3; k++){
            int tab10000[] = new int [10000];
            for(int i=0; i < 10000; i++){
                tab10000[i] = 10000 -i;
            }
            tempsIniciel = System.nanoTime();
            trierParBulle(tab10000, 10000);
            tempsFin = System.nanoTime();
            tempsExecution = (tempsFin - tempsIniciel);
            tabtempsMoyenne[k] = tempsExecution;
            for(int i = 0; i < tab10000.length; i++){
                // System.out.print(tab10000[i]+ ", ");
            }
            System.out.println("temps d'execution pour trier par Insertion dans un array de 10000 elements est de: " + tempsExecution + " nansegunds.");
        }
        for(int i = 0; i < tabtempsMoyenne.length; i++){
        System.out.println("temps: " + tabtempsMoyenne[i] + " nanosegunds.");
        moyenne += tabtempsMoyenne[i];
        moyenneCalcule = moyenne/3;
        }
        System.out.println("moyenne pour un tableau de 10000 elements: " + moyenneCalcule + " nanosegunds.");
        moyenneGeneralEchangeBulle.add((long)(moyenneCalcule));
        // ****************************************************************************************************************************************************
        // TRIER 15000 ELEMENTS PAR EchangeBulle
        tempsExecution = 0;
        moyenne = 0;
        moyenneCalcule = 0;
        for(int k = 0; k < 3; k++){
            int tab15000[] = new int [15000];
            for(int i=0; i < 15000; i++){
                tab15000[i] = 15000 -i;
            }
            tempsIniciel = System.nanoTime();
            trierParBulle(tab15000, 15000);
            tempsFin = System.nanoTime();
            tempsExecution = (tempsFin - tempsIniciel);
            tabtempsMoyenne[k] = tempsExecution;
            for(int i = 0; i < tab15000.length; i++){
                // System.out.print(tab15000[i]+ ", ");
            }
            System.out.println("temps d'execution pour trier par Insertion dans un array de 15000 elements est de: " + tempsExecution + " nansegunds.");
        }
        for(int i = 0; i < tabtempsMoyenne.length; i++){
        System.out.println("temps: " + tabtempsMoyenne[i] + " nanosegunds.");
        moyenne += tabtempsMoyenne[i];
        moyenneCalcule = moyenne/3;
        }
        System.out.println("moyenne pour un tableau de 15000 elements: " + moyenneCalcule + " nanosegunds.");
        moyenneGeneralEchangeBulle.add((long)(moyenneCalcule));
        // ****************************************************************************************************************************************************
        // TRIER 20000 ELEMENTS PAR EchangeBulle
        tempsExecution = 0;
        moyenne = 0;
        moyenneCalcule = 0;
        for(int k = 0; k < 3; k++){
            int tab20000[] = new int [20000];
            for(int i=0; i < 20000; i++){
                tab20000[i] = 20000 -i;
            }
            tempsIniciel = System.nanoTime();
            trierParBulle(tab20000, 20000);
            tempsFin = System.nanoTime();
            tempsExecution = (tempsFin - tempsIniciel);
            tabtempsMoyenne[k] = tempsExecution;
            for(int i = 0; i < tab20000.length; i++){
                // System.out.print(tab20000[i]+ ", ");
            }
            System.out.println("temps d'execution pour trier par Insertion dans un array de 20000 elements est de: " + tempsExecution + " nansegunds.");
        }
        for(int i = 0; i < tabtempsMoyenne.length; i++){
        System.out.println("temps: " + tabtempsMoyenne[i] + " nanosegunds.");
        moyenne += tabtempsMoyenne[i];
        moyenneCalcule = moyenne/3;
        }
        System.out.println("moyenne pour un tableau de 20000 elements: " + moyenneCalcule + " nanosegunds.");
        moyenneGeneralEchangeBulle.add((long)(moyenneCalcule));
        // ****************************************************************************************************************************************************
        // TRIER 25000 ELEMENTS PAR EchangeBulle
        tempsExecution = 0;
        moyenne = 0;
        moyenneCalcule = 0;
        for(int k = 0; k < 3; k++){
            int tab25000[] = new int [25000];
            for(int i=0; i < 25000; i++){
                tab25000[i] = 25000 -i;
            }
            tempsIniciel = System.nanoTime();
            trierParBulle(tab25000, 25000);
            tempsFin = System.nanoTime();
            tempsExecution = (tempsFin - tempsIniciel);
            tabtempsMoyenne[k] = tempsExecution;
            for(int i = 0; i < tab25000.length; i++){
                // System.out.print(tab25000[i]+ ", ");
            }
            System.out.println("temps d'execution pour trier par Insertion dans un array de 25000 elements est de: " + tempsExecution + " nansegunds.");
        }
        for(int i = 0; i < tabtempsMoyenne.length; i++){
        System.out.println("temps: " + tabtempsMoyenne[i] + " nanosegunds.");
        moyenne += tabtempsMoyenne[i];
        moyenneCalcule = moyenne/3;
        }
        System.out.println("moyenne pour un tableau de 25000 elements: " + moyenneCalcule + " nanosegunds.");
        moyenneGeneralEchangeBulle.add((long)(moyenneCalcule));
        // ****************************************************************************************************************************************************

        for(int i = 0; i < moyenneGeneralSelection.size(); i++){
            System.out.println("Moyenne pour trier un tableau par selection de " + (i+1)*5000 + " elements: " + moyenneGeneralSelection.get(i) + " nanosegunds.");
        }
        for(int i = 0; i < moyenneGeneralEnumeration.size(); i++){
            System.out.println("Moyenne pour trier un tableau par Enumeration de " + (i+1)*5000 + " elements: " + moyenneGeneralEnumeration.get(i) + " nanosegunds.");
        }
        for(int i = 0; i < moyenneGeneralInsertion.size(); i++){
            System.out.println("Moyenne pour trier un tableau par insertion " + (i+1)*5000 + " elements: " + moyenneGeneralInsertion.get(i) + " nanosegunds.");
        }
        for(int i = 0; i < moyenneGeneralEchangeBulle.size(); i++){
            System.out.println("Moyenne pour trier un tableau par bulle " + (i+1)*5000 + " elements: " + moyenneGeneralEchangeBulle.get(i) + " nanosegunds.");
        }
    }
}

