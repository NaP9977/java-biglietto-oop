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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BigDecimal calcolaPrezzo() {
        final double costoKm = 0.21;
        BigDecimal prezzoBase = new BigDecimal(costoKm);
        BigDecimal prezzoFinale = prezzoBase.multiply(BigDecimal.valueOf(km));
        prezzoFinale = calcolaSconto(prezzoFinale);

        return prezzoFinale;
    }

    public BigDecimal calcolaSconto(BigDecimal prezzoFinale) {
        final BigDecimal scontoOver65 = new BigDecimal(0.40);
        final BigDecimal scontoMinorenni = new BigDecimal(0.20);

        if(age > 65){
            prezzoFinale = prezzoFinale.multiply(BigDecimal.ONE.subtract(scontoOver65));}
else if(age < 18){
    prezzoFinale = prezzoFinale.multiply(BigDecimal.ONE.subtract(scontoMinorenni));
}
return prezzoFinale;
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

    @Override
    public String toString() {
        return "Biglietto = " +
                "Età del passeggero =" + age +
                ", Km da percorrere" + km + calcolaPrezzo();

    }
}
