package org.java.esercitazione;

import java.math.BigDecimal;
import java.util.Scanner;

public class Biglietteria {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.println("Inserisci la tua età, per favore");
                int age = Integer.parseInt(scan.nextLine());
                System.out.println("Inserisci i km che devi percorrere");
                int km = Integer.parseInt(scan.nextLine());
                Biglietto biglietto = new Biglietto(age, km);

                BigDecimal prezzo = biglietto.calcolaPrezzo().setScale(2, BigDecimal.ROUND_HALF_UP);
                System.out.println("Il prezzo del biglietto è " + prezzo);
                isValid = true;
            } catch (RuntimeException e) {
                System.out.println("Errore i km inseriti sono invalidi");
            }

        }

    }
}