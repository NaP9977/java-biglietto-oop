package org.java.esercitazione;

import java.math.BigDecimal;

//MILESTONE 1
//Consegna: creare una classe Biglietto con due attributi interi:
// km e età del passeggero.
//Nel costruttore vanno valorizzati entrambi gli attributi, assicurandosi
// che abbiano valori validi (creare due metodi isValidKm e isValidEta che implementano questa logica).
// In caso anche solo uno non sia valido, sollevare un’eccezione. Aggiungere tre costanti:
//il costo chilometrico di 21 centesimi di €/km (BigDecimal),
//lo sconto over 65 del 40 % (BigDecimal)
//lo sconto minorenni del 20% (BigDecimal).
//Implementare il metodo public che calcola il prezzo del biglietto comprensivo di
// eventuale sconto (calcolaPrezzo). Per eseguire il calcolo dello sconto aggiungere un
// metodo private calcolaSconto,
// da chiamare dentro al metodo calcolaPrezzo.
public class Biglietto {
    private int age;
    private int km;

    public Biglietto(int age, int km) {
        isValidAge(age);
        this.age = age;
        isValidKm(km);
        this.km = km;
    }
public void calcolaPrezzo(){
        final double costoKm = 0.21;
 BigDecimal prezzoBase = new BigDecimal(costoKm);
 BigDecimal prezzoFinale = prezzoBase.multiply(BigDecimal.valueOf(km));
 calcolaSconto(prezzoFinale);
    }

private void calcolaSconto(BigDecimal prezzoFinale){

        if (age > 65){
            BigDecimal sconto = new BigDecimal(0.40);
            prezzoFinale.subtract(sconto.multiply(prezzoFinale));
        } else if(age < 18){
            BigDecimal sconto = new BigDecimal(0.20);
            prezzoFinale.subtract(sconto.multiply(prezzoFinale));
        }
}






    private void isValidAge( int age) {
        if (age < 0) {
            throw new RuntimeException();
        }
    }


    private void isValidKm( int km) {
        if (km < 0) {
            throw new RuntimeException();
        }
    }
}
