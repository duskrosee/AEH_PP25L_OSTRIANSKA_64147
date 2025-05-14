package pl.pp;

public class mojaDziesiataAplikacja {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, -3, -2, -1};
        int[] result = countAndSumElements(input);

        if (result.length == 0) {
            System.out.println("Pusta tablica lub null");
        } else {
            System.out.println("Liczba ujemnych: " + result[0]);
            System.out.println("Suma dodatnich: " + result[1]);
        }


    }

    public static int[] countAndSumElements(int[] input) {
        if (input == null || input.length == 0) {
            return new int[0];
        }

        int countNegative = 0;
        int sumPositive = 0;

        for (int value : input) {
            if (value < 0) {
                countNegative++;
            } else if (value > 0) {
                sumPositive += value;
            }
        }

        return new int[] {countNegative, sumPositive};
    }
}
