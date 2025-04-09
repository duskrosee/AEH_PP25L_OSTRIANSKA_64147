import java.math.BigInteger;
import java.util.Scanner;

public class mojaSzostaAplikacja {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Podaj liczbę N, dla której chcesz obliczyć silnię: ");
            long N;
            try {
                N = scanner.nextLong();
            } catch (Exception e) {
                System.out.println("Błąd: Proszę podać poprawną liczbę całkowitą.");
                scanner.close();
                return;
            }

            scanner.close();

            long startTimeIterative = System.nanoTime();
            BigInteger resultIterative = factorialIterative(N);
            long endTimeIterative = System.nanoTime();
            long executionTimeIterative = (endTimeIterative - startTimeIterative) / 1000000;
            System.out.println("Silnia z " + N + " (iteracyjna) = " + resultIterative);
            System.out.println("Metoda iteracyjna zajmuje " + executionTimeIterative + "ms");

            long startTimeRecursive = System.nanoTime();
            BigInteger resultRecursive = factorialRecursive(N);
            long endTimeRecursive = System.nanoTime();
            long executionTimeRecursive = (endTimeRecursive - startTimeRecursive) / 1000000;
            System.out.println("Silnia z " + N + " (rekurencyjna) = " + resultRecursive);
            System.out.println("Metoda rekurencyjna zajmuje " + executionTimeRecursive + "ms");
        }

        public static BigInteger factorialIterative(long n) {
            if (n < 0) {
                throw new IllegalArgumentException("Silnia nie jest zdefiniowana dla liczb ujemnych");
            }
            if (n == 0 || n == 1) {
                return BigInteger.ONE;
            }
            BigInteger result = BigInteger.ONE;
            for (long i = 2; i <= n; i++) {
                result = result.multiply(BigInteger.valueOf(i));
            }
            return result;
        }

        public static BigInteger factorialRecursive(long n) {
            if (n < 0) {
                throw new IllegalArgumentException("Silnia nie jest zdefiniowana dla liczb ujemnych");
            }
            if (n == 0 || n == 1) {
                return BigInteger.ONE;
            }
            return BigInteger.valueOf(n).multiply(factorialRecursive(n - 1));
        }
    }
