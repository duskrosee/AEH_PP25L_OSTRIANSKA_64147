package pl.pp;

abstract class Pojazd {
    protected String nrRejestracyjny;
    protected String numerVin;
    protected String kolor;
    protected double cena;
    protected double spalanie;
    protected String poziomPaliwa;
    protected double przebieg;

    public Pojazd(String nrRejestracyjny, String numerVin, String kolor, double cena, double spalanie, String poziomPaliwa, double przebieg) {
        this.nrRejestracyjny = nrRejestracyjny;
        this.numerVin = numerVin;
        this.kolor = kolor;
        this.cena = cena;
        this.spalanie = spalanie;
        this.poziomPaliwa = poziomPaliwa;
        this.przebieg = przebieg;
    }


    public abstract void zatankuj();

    public void sprawdz() {
        System.out.println("Sprawdzanie pojazdu: " + nrRejestracyjny);
        System.out.println("VIN: " + numerVin);
        System.out.println("Kolor: " + kolor);
        System.out.println("Cena: " + cena);
        System.out.println("Spalanie: " + spalanie);
        System.out.println("Poziom paliwa: " + poziomPaliwa);
        System.out.println("Przebieg: " + przebieg);
    }
}

interface typPaliwa {
    String getTypPaliwa();
}


class Osobowe extends Pojazd implements typPaliwa {
    private int liczbaDrzwi;

    public Osobowe(String nrRejestracyjny, String numerVin, String kolor, double cena, double spalanie, String poziomPaliwa, double przebieg, int liczbaDrzwi) {
        super(nrRejestracyjny, numerVin, kolor, cena, spalanie, poziomPaliwa, przebieg);
        this.liczbaDrzwi = liczbaDrzwi;
    }

    @Override
    public void zatankuj() {
        System.out.println("Tankowanie pojazdu osobowego: " + nrRejestracyjny);
        poziomPaliwa = "Pelny";
    }

    @Override
    public String getTypPaliwa() {
        return "benzyna";
    }
}

class Ciezarowka extends Pojazd implements typPaliwa {
    private double ladownosc;

    public Ciezarowka(String nrRejestracyjny, String numerVin, String kolor, double cena, double spalanie, String poziomPaliwa, double przebieg, double ladownosc) {
        super(nrRejestracyjny, numerVin, kolor, cena, spalanie, poziomPaliwa, przebieg);
        this.ladownosc = ladownosc;
    }

    @Override
    public void zatankuj() {
        System.out.println("Tankowanie ciezarowki: " + nrRejestracyjny);
        poziomPaliwa = "Pelny";
    }

    @Override
    public String getTypPaliwa() {
        return "diesel";
    }
}

class Motocykl extends Pojazd implements typPaliwa {
    private boolean posiadaDostawke;

    public Motocykl(String nrRejestracyjny, String numerVin, String kolor, double cena, double spalanie, String poziomPaliwa, double przebieg, boolean posiadaDostawke) {
        super(nrRejestracyjny, numerVin, kolor, cena, spalanie, poziomPaliwa, przebieg);
        this.posiadaDostawke = posiadaDostawke;
    }

    @Override
    public void zatankuj() {
        System.out.println("Tankowanie motocykla: " + nrRejestracyjny);
        poziomPaliwa = "Pelny";
    }

    @Override
    public String getTypPaliwa() {
        return "benzyna";
    }
}


class SprzetBudowlany extends Pojazd implements typPaliwa {
    private double przepracowaneGodziny;

    public SprzetBudowlany(String nrRejestracyjny, String numerVin, String kolor, double cena, double spalanie, String poziomPaliwa, double przebieg, double przepracowaneGodziny) {
        super(nrRejestracyjny, numerVin, kolor, cena, spalanie, poziomPaliwa, przebieg);
        this.przepracowaneGodziny = przepracowaneGodziny;
    }

    @Override
    public void zatankuj() {
        System.out.println("Tankowanie sprzetu budowlanego: " + nrRejestracyjny);
        poziomPaliwa = "Pelny";
    }

    @Override
    public String getTypPaliwa() {
        return "diesel";
    }
}

public class mojaCzternastaAplikacja {
    public static void main(String[] args) {
        Osobowe osobowe = new Osobowe("KR12345", "VIN001", "Czerwony", 50000, 7.5, "Polowa", 15000, 5);
        Ciezarowka ciezarowka = new Ciezarowka("KR67890", "VIN002", "Niebieski", 120000, 20.0, "Pusty", 30000, 10.0);
        Motocykl motocykl = new Motocykl("KR11122", "VIN003", "Czarny", 15000, 5.0, "Polowa", 5000, true);
        SprzetBudowlany sprzet = new SprzetBudowlany("KR33344", "VIN004", "Zolty", 80000, 15.0, "Pusty", 20000, 1000.0);

        System.out.println("Testowanie osobowego:");
        osobowe.sprawdz();
        osobowe.zatankuj();
        System.out.println("Typ paliwa: " + osobowe.getTypPaliwa());
        System.out.println();

        System.out.println("Testowanie ciezarowki:");
        ciezarowka.sprawdz();
        ciezarowka.zatankuj();
        System.out.println("Typ paliwa: " + ciezarowka.getTypPaliwa());
        System.out.println();

        System.out.println("Testowanie motocykla:");
        motocykl.sprawdz();
        motocykl.zatankuj();
        System.out.println("Typ paliwa: " + motocykl.getTypPaliwa());
        System.out.println();

        System.out.println("Testowanie sprzetu budowlanego:");
        sprzet.sprawdz();
        sprzet.zatankuj();
        System.out.println("Typ paliwa: " + sprzet.getTypPaliwa());
    }
}