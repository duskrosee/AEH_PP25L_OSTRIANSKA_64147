package pl.pp;

import java.util.Random;
import java.util.Scanner;

public class mojaCzwartaAplikacja {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        new Random();
        boolean continueCalculating = true;
        while (continueCalculating) {
            System.out.println("Choose operation: 1) Add 2) Subject 3) Multiply 4) Divide 5) Exit");
            int choice = scanner.nextInt();

            if (choice == 5) {
                continueCalculating = false;
                continue;
            }

            System.out.println("Enter first number: ");
            double num1 = scanner.nextDouble();
            System.out.println("Enter second number:");
            double num2 = scanner.nextDouble();

            switch (choice) {
                case 1:
                    System.out.println("Result: " + (num1 + num2));
                    break;
                case 2:
                    System.out.println("Result: " + (num1 - num2));
                    break;
                case 3:
                    System.out.println("Result: " + num1 * num2);
                    break;
                case 4:
                    if (num2 != 0 ) {
                    System.out.println("Result: " + (num1 / num2));
                } else {
                    System.out.println("Cannot divide by zero!");
                }
                break;
                default:
                    System.out.println("Invalid operation. Please try again.");
            }
        }

            scanner.close();
        }
    }