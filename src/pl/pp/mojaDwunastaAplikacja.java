package pl.pp;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class mojaDwunastaAplikacja  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputPath = "";
        String outputPath = "";
        boolean validInputFile = false;


        while (!validInputFile) {
            System.out.println("Podaj ścieżkę do pliku wejściowego:");
            inputPath = scanner.nextLine();
            try {

                Files.readAllLines(Paths.get(inputPath));
                validInputFile = true;
            } catch (IOException e) {
                System.out.println("Plik nie istnieje lub nie można go otworzyć. Spróbuj ponownie.");
            }
        }


        System.out.println("Podaj ścieżkę do pliku wyjściowego:");
        outputPath = scanner.nextLine();

        try {

            List<String> lines = Files.readAllLines(Paths.get(inputPath));
            int lineCount = lines.size();


            System.out.println("Liczba linii w pliku: " + lineCount);


            String fileName = Paths.get(inputPath).getFileName().toString();
            List<String> outputLines = new ArrayList<>();
            outputLines.add("Nazwa pliku: " + fileName);
            outputLines.add("Liczba linii: " + lineCount);


            Files.write(Paths.get(outputPath), outputLines);
            System.out.println("Wynik zapisano do pliku: " + outputPath);

        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas operacji na plikach:");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}