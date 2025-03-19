package pl.pp;

import java.util.Scanner;

public class mojaTrzeciaAplikacja {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dni;
        while (true) {
            System.out.println("Podaj liczbę dni");
            dni = scanner.nextInt();

            if (dni < 0) {
                System.out.println("Zakończenie programu...");
                break;
            }
            int tygodnie = dni / 7;
            int resztaDni = dni % 7;

            System.out.println(dni + " dni to " + tygodnie + " tygodnie i " + resztaDni + " dni. ");
        }

        scanner.close();
    }
}