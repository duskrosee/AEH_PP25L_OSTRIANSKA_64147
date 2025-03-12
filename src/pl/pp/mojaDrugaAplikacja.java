package pl.pp;

import java.util.Scanner;

public class mojaDrugaAplikacja {
    public static void main(String[] args) {

        double x = 10;
        double y = 2;

        Scanner scanner = new Scanner(System.in);

        var result = x + y;
        System.out.println("x + y = " + result);

        result = x - y;
        System.out.println("x - y = " + result);

        result = x * y;
        System.out.println("x * y = " + result);

        result = x / y;
        System.out.println("x / y = " + result);

        result = x % y;
        System.out.println("x % y = " + result);

        System.out.println("Wpisz dwie liczby rozdzielone klawiszem Enter:");
        double first = scanner.nextDouble();
        double second = scanner.nextDouble();

        System.out.println("x + y = " + (first + second));
    }
}





package pl.pp;

public class mojaDrugaAplikacja {
    public static void main(String[] args) {

        int x = 10;
        System.out.println("x = " + x);

        int doubleX = 2 * x;
        System.out.println("Dwukrotność x = " + doubleX);

        int xSquared = x * x;
        System.out.println("x^2 = " + xSquared);
    }
}




package pl.pp;

import java.util.Scanner

public class mojaDrugaAplikacja {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Proszę podaj pełny wiek w latach:");
        int ageInYears = scanner.nextInt();

        long ageInSeconds = ageInYears * 31536000;

        System.out.println("Oto podany wiek w przelczeniu na sekundy: " + ageInSeconds);

        scanner.close();
    }
}