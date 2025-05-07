public class mojaDziewiataAplikacja {

    private int numerMagazynu;
    private int dostepnaPrzestrzenMagazynowa;
    private String nazwaWlascicielaMagazynu;
    private String email;
    private String numerTelefonu;

    public int getNumerMagazynu() {
        return numerMagazynu;
    }

    public void setNumerMagazynu(int numerMagazynu) {
        this.numerMagazynu = numerMagazynu;
    }

    public int getDostepnaPrzestrzenMagazynowa() {
        return dostepnaPrzestrzenMagazynowa;
    }

    public void setDostepnaPrzestrzenMagazynowa(int dostepnaPrzestrzenMagazynowa) {
        this.dostepnaPrzestrzenMagazynowa = dostepnaPrzestrzenMagazynowa;
    }

    public String getNazwaWlascicielaMagazynu() {
        return nazwaWlascicielaMagazynu;
    }

    public void setNazwaWlascicielaMagazynu(String nazwaWlascicielaMagazynu) {
        this.nazwaWlascicielaMagazynu = nazwaWlascicielaMagazynu;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumerTelefonu() {
        return numerTelefonu;
    }

    public void setNumerTelefonu(String numerTelefonu) {
        this.numerTelefonu = numerTelefonu;
    }

    public void dodajTowar(int iloscJednostekTowaru) {
        if (dostepnaPrzestrzenMagazynowa >= iloscJednostekTowaru) {
            dostepnaPrzestrzenMagazynowa -= iloscJednostekTowaru;
            System.out.println("Dodano " + iloscJednostekTowaru + " jednostek towaru. Pozostała przestrzeń magazynowa: " + dostepnaPrzestrzenMagazynowa + " jednostek.");
        } else {
            System.out.println("Nie można dodać " + iloscJednostekTowaru + " jednostek towaru. Dostępna przestrzeń: " + dostepnaPrzestrzenMagazynowa + " jednostek.");
        }
    }

    public void usunTowar(int iloscJednostekTowaru) {
        int zajetaPrzestrzen = 5000 - dostepnaPrzestrzenMagazynowa; // Zakładamy, że początkowa przestrzeń to 5000
        if (zajetaPrzestrzen >= iloscJednostekTowaru) {
            dostepnaPrzestrzenMagazynowa += iloscJednostekTowaru;
            System.out.println("Usunięto " + iloscJednostekTowaru + " jednostek towaru. Pozostała przestrzeń magazynowa: " + dostepnaPrzestrzenMagazynowa + " jednostek.");
        } else {
            System.out.println("Nie można usunąć " + iloscJednostekTowaru + " jednostek towaru. Zajęta przestrzeń: " + zajetaPrzestrzen + " jednostek.");
        }
    }

    public String sprawdzZajetosc() {
        int zajetaPrzestrzen = 5000 - dostepnaPrzestrzenMagazynowa; // Zakładamy, że początkowa przestrzeń to 5000
        return "Zajęta przestrzeń: " + zajetaPrzestrzen + " jednostek. Dostępna przestrzeń: " + dostepnaPrzestrzenMagazynowa + " jednostek.";
    }

    public void aktualizujKontakt(String email, String numerTelefonu) {
        this.email = email;
        this.numerTelefonu = numerTelefonu;
        System.out.println("Zaktualizowano dane kontaktowe. Nowy email: " + email + ", nowy numer telefonu: " + numerTelefonu);
    }

    public static void main(String[] args) {
        mojaDziewiataAplikacja magazyn = new mojaDziewiataAplikacja();
        magazyn.setNumerMagazynu(1);
        magazyn.setDostepnaPrzestrzenMagazynowa(3000);
        magazyn.setNazwaWlascicielaMagazynu("Jan Kowalski");
        magazyn.setEmail("jan.kowalski@magazyn.pl");
        magazyn.setNumerTelefonu("+48 123 456 789");

        System.out.println("Stan początkowy:");
        System.out.println(magazyn.sprawdzZajetosc());

        magazyn.dodajTowar(1000);
        magazyn.usunTowar(2500);
        System.out.println(magazyn.sprawdzZajetosc());

        magazyn.aktualizujKontakt("nowyemail@magazyn.pl", "+48 123 456 789");

        System.out.println("Za mało miejsca w magazynie:");
        magazyn.dodajTowar(2500);
    }
}