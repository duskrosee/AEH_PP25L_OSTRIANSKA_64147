package pl.pp;

import java.util.Random;
import java.util.Scanner;

public class mojaPiataAplikacja {
    public static void main(String[] args) {
        int rows = 15;
        int starCount = 30;

        for (int i = 0; i < rows; i++) {

            if (i == 0 || i == rows - 1) {

                String result = "-".repeat(30);
                System.out.print(result);
            } else {
                for (int j = 0; j < starCount; j++) {
                    if ((i == 3 && (j == 8 || j == 9 || j == 10 || j == 15)) ||
                            (i == 4 && (j == 8 || j == 9 || j == 10 || j == 14)) ||
                            (i == 5 && j == 13) ||
                            (i == 6 && j == 12) ||
                            (i == 7 && j == 11) ||
                            (i == 8 && j == 10) ||
                            (i == 9 && j == 9) ||
                            (i == 10 && (j == 8 || j == 13 || j == 14|| j == 15)) ||
                            (i == 11 && (j == 7 || j == 13 || j == 14 || j == 15))) {
                        System.out.print("%");
                    } else {
                        System.out.print("*");
                    }
                }
            }

            System.out.println("|");
        }
    }
}