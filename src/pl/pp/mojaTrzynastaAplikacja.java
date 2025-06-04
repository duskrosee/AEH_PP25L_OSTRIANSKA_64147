package pl.pp;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class mojaTrzynastaAplikacja {





    public static void main(String[] args) {


        Scanner consoleScanner = new Scanner(System.in);



        Path inputFilePath = getInputPath(consoleScanner);


        Path outputFilePath = getOutputPath(consoleScanner);


        processFiles(inputFilePath, outputFilePath);



        consoleScanner.close();


        System.out.println("Processing complete. Check the output file: " + outputFilePath.toString());


    }





    private static Path getInputPath(Scanner scanner) {


        Path path = null;


        while (true) {


            System.out.print("Enter the path to the input text file: ");


            String filePathString = scanner.nextLine();


            File inputFile = new File(filePathString);





            if (inputFile.exists() && inputFile.isFile()) {


                path = Paths.get(filePathString);


                break;


            } else {


                System.out.println("Error: File does not exist or is not a regular file. Please try again.");


            }


        }


        return path;


    }





    private static Path getOutputPath(Scanner scanner) {


        System.out.print("Enter the path for the output file: ");


        String filePathString = scanner.nextLine();


        return Paths.get(filePathString);


    }





    private static void processFiles(Path inputFilePath, Path outputFilePath) {


        Map<String, Integer> wordFrequencies = new HashMap<>();


        int totalWordCount = 0;


        String inputFileName = inputFilePath.getFileName().toString();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath.toFile()))) {


            String line;


            while ((line = reader.readLine()) != null) {

                String[] words = line.toLowerCase().split("\\s+"); // regex for one or more whitespace chars


                for (String rawWord : words) {


                    String cleanedWord = rawWord.replaceAll("[^a-zA-Z]", "");


                    if (!cleanedWord.isEmpty()) {


                        totalWordCount++;


                        wordFrequencies.put(cleanedWord, wordFrequencies.getOrDefault(cleanedWord, 0) + 1);


                    }


                }


            }


        } catch (IOException e) {


            System.err.println("Error reading the input file: " + e.getMessage());

            return; // stop processing if read fails


        }



        System.out.println("\n--- Analysis Results ---");


        System.out.println("Input file: " + inputFileName);


        System.out.println("Total words: " + totalWordCount);


        System.out.println("Word Frequencies:");


        for (Map.Entry<String, Integer> entry : wordFrequencies.entrySet()) {


            System.out.println(entry.getKey() + ": " + entry.getValue());


        }


        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(outputFilePath.toFile())))) {


            writer.println("Input file: " + inputFileName);


            writer.println("Total words: " + totalWordCount);


            writer.println("\nWord Frequencies:");


            for (Map.Entry<String, Integer> entry : wordFrequencies.entrySet()) {


                writer.println(entry.getKey() + ": " + entry.getValue());


            }


        } catch (IOException e) {


            System.err.println("Error writing to the output file: " + e.getMessage());
        }


    }


}