package org.java.esercitazione;

import java.math.BigDecimal;
import java.time.LocalDate;

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

//MILESTONE 3 (BONUS)
//Alla classe Biglietto aggiungere i seguenti attributi:
//● data: LocalDate
//● flessibile: boolean
//Entrambi gli attributi vanno valorizzati nel costruttore.
//Aggiungere due costanti:
//● durata normale: 30 giorni (int)
//● durata flessibile: 90 giorni (int)
//Aggiungere un metodo (calcolaDataScadenza: LocalDate) che calcola la data di
// scadenza del biglietto, applicando la durata normale o flessibile in base al
// parametro flessibile(boolean). Nel metodo che calcola il prezzo,
// se il biglietto è flessibile, maggiorare il prezzo del 10%.
//Modificare la classe Biglietteria in modo che, alla creazione del Biglietto,
// valorizzi la data con la data odierna e il parametro flessibile in base alla
// scelta dell’utente. Dopo aver stampato il prezzo del biglietto, stampare a video
// anche la data di scadenza.
public class Biglietto {
    private int age;
    private int km;
    private LocalDate date;
    private boolean isItFlexible;
    public Biglietto(int age, int km, boolean isItFlexible) {
        isValidAge(age);
        this.age = age;
        isValidKm(km);
        this.km = km;
      this.date = date;
      this.isItFlexible = isItFlexible;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isItFlexible() {
        return isItFlexible;
    }

    public void setItFlexible(boolean itFlexible) {
        isItFlexible = itFlexible;
    }

    public BigDecimal calcolaPrezzo() {
        final double costoKm = 0.21;
        BigDecimal prezzoBase = new BigDecimal(costoKm);
        BigDecimal prezzoFinale = prezzoBase.multiply(BigDecimal.valueOf(km));
        prezzoFinale = calcolaSconto(prezzoFinale);
        final BigDecimal aumento = new BigDecimal(0.10);
        if(isItFlexible){
            prezzoFinale = prezzoFinale.add(aumento.multiply(prezzoFinale));
        }

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

public LocalDate calcolaDataDiScadenza(){
        final int durataNormale = 30;
        final int durataFlessibile = 90;
      if(isItFlexible){
          return date.plusDays(durataFlessibile);
      }
      return date.plusDays(durataNormale);

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
