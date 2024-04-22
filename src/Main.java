import org.w3c.dom.ls.LSException;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[]args) throws FileNotFoundException {
        List<Integer> valeurs = new ArrayList<>();
        lire("src/in/data.txt", valeurs);
        printVal(valeurs);
        trier(valeurs);
        /** Supprimer les doublons */
        valeurs = valeurs.stream().distinct().collect(Collectors.toList());
        printVal(valeurs);
        /** Test 1 */
        String filePath = "src/out/output.txt";
        /** Test 2 */
        String filePath2 = "src/out/output2.txt";
        /** Test 3 */
        String filePath3 = "src/out/output3.txt";
        ecrire(filePath3,valeurs);


    }
    public static void trier(List<Integer> valeurs){
        /** Trier dans l'ordre décroissant */
        Collections.sort(valeurs, Collections.reverseOrder());
    }
    public static void lire(String nomFichier, List<Integer> valeurs) throws FileNotFoundException {
        Scanner fichier =new Scanner(new FileInputStream(nomFichier));
        while(fichier.hasNextInt()){
            Scanner ligne = new Scanner(fichier.nextLine());
            valeurs.add(ligne.nextInt());
            ligne.close();
        }
        fichier.close();
    }
    public static void ecrire(String filePath, List<Integer> valeurs){
        // Écriture des valeurs dans le fichier
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Écrire les valeurs dans le fichier avec un espace entre chaque valeur
            for (Integer valeur : valeurs) {
                writer.write(valeur + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void printVal(List<Integer> val){
        for(int i = 0; i < 10; ++i){
            System.out.println(val.get(i));
        }
    }
}
