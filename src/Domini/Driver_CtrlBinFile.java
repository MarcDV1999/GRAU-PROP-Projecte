package Domini;
//
//  Driver_CtrlBinFileLZ78.java
//  PROP Compressor Descompressor
//
//  Created by Marc Domènech.
//  Copyright © 2019 Marc Domènech. All rights reserved.
//


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Driver_CtrlBinFile {
    public static void main (String [] args) throws IOException {
        int estado = 0, fin = 1000;
        String nomFitxer, nom;
        Scanner sc = new Scanner(System.in);
        Ctrl_BinFile binFile;

        while (estado != fin) {
            System.out.println("Driver Ctrl_BinFile:");
            System.out.println("\t1. Llegir Fitxer Binari");
            System.out.println("\t2. Escriure en Fitxer Binari");
            System.out.println("\t3. Exit");
            System.out.println("Introdueixi un numero: ");
            estado = sc.nextInt();

            switch (estado) {
                case 1:
                    System.out.println("----> Introdueixi el nom del Fitxer Binari(Exemple: Fitxer.bin): ");
                    nomFitxer = sc.next();
                    nom = nomFitxer.substring(0, nomFitxer.length() - 4);
                    binFile = new Ctrl_BinFile(nom);

                    List<String> l = binFile.readBinFile();
                    System.out.println("Lectura del Binari: " + l);
                    break;
                case 2:
                    try {
                        System.out.println("----> Introdueixi el nom del Fitxer Binari(Exemple: Fitxer.bin): ");
                        nomFitxer = sc.next();
                        nom = nomFitxer.substring(0, nomFitxer.length() - 4);
                        binFile = new Ctrl_BinFile(nom);

                        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                        System.out.println("----> Introdueixi un text codificat (exemple: 0,A,0,b,1,b): ");
                        // Leyendo datos usando readLine
                        String name = reader.readLine();
                        List<String> list = Arrays.asList(name.split("\\s*,\\s*"));
                        binFile.writeBinFile(list, 2);
                        System.out.println("Abra el Binario para ver el resultado: ");
                    }catch (Exception e){
                        System.out.println("Error. Torni a introduir les dades ");
                    }
                    break;
                case 3:
                    fin = 3;
                    System.out.println("Gràcies. Passi-ho bé.");
                    break;
            }
        }
    }
}
