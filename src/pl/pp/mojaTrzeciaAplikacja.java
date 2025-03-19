package pl.pp;

import java.util.Scanner;

public class mojaTrzeciaAplikacja {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double fahrenheit;

        while (true) {
            System.out.println("Podaj temperaturę w skali Fahrenheit (wprowadż -1, aby zakończyć: ");
            fahrenheit = scanner.nextDouble();

            if (fahrenheit == -1) {
                System.out.println("Zakończenie programu...");
                break;
            }

                double celsius;
                celsius = (fahrenheit - 32) / 1.8;
                double kelvin = celsius + 273.16;

                System.out.printf("Temperatura: %.2f F to %.2f C i %.2f K\n", fahrenheit, celsius, kelvin);
            }
            scanner.close();
        }
    }