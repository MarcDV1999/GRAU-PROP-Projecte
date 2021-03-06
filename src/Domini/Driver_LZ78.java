package Domini;

//
//  Driver_LZ78.java
//  PROP Compressor Descompressor
//
//  Created by Marc Domènech.
//  Copyright © 2019 Marc Domènech. All rights reserved.
//


import java.util.Scanner;

public class Driver_LZ78 {

    public static void main (String [] args) throws Exception {
        int estado = 0;
        int fin = 1000; //por poner algo...
        String nomFitxer, nom;
        LZ78 lz78;
        File textfile;
        BinFile binFile;
        Scanner sc = new Scanner(System.in);

        while (estado != fin) {
            System.out.println("Driver LZ78:");
            System.out.println("\t1. Codificar Arxiu");

            System.out.println("\t2. Decodificar Arxiu");
            System.out.println("\t3. Exit");

            System.out.println("Introdueixi un numero: ");
            estado = sc.nextInt();
            switch (estado) {
                case 1:
                    System.out.println("----> Introdueixi el nom del Fitxer a comprimir (Exemple: Fitxer.txt): ");
                    try {
                        nomFitxer = sc.next();
                        textfile = new File(nomFitxer);
                        lz78 = new LZ78();
                        lz78.compress(textfile);
                        System.out.println("Obre el Fitxer " + textfile.getAbsName() + ".bin per veure els canvis.");
                    }catch (Exception e){
                        System.out.println("Nom de fitxer erroni, torni a intentar-ho");
                    }
                    break;
                case 2:
                    System.out.println("----> Introdueixi el nom del Fitxer a descomprimir (Exemple: Fitxer.bin2): ");
                    try {
                        nomFitxer = sc.next();
                        nom = nomFitxer.substring(0, nomFitxer.length() - 4);
                        binFile = new BinFile(nom);
                        lz78 = new LZ78();
                        lz78.discompress(binFile);
                        System.out.println("Obre el Fitxer " + binFile.getAbsName() + ".txt per veure els canvis.");
                    }catch (Exception e){
                        System.out.println("Nom de fitxer erroni, torni a intentar-ho");
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
