import java.io.*;
import java.util.*;

public class DoubleSorter {
    private List<Double> values = new ArrayList<>();

    public void readFromKeyboard(Scanner sc) {
        System.out.print("Enter number of values: ");
        int count = sc.nextInt();
        System.out.println("Enter " + count + " double values:");
        for (int i = 0; i < count; i++) {
            values.add(sc.nextDouble());
        }
    }

    public void readFromFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            values.add(Double.parseDouble(line));
        }
        reader.close();
    }

    public void writeToFile(String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (Double val : values) {
            writer.write(val.toString());
            writer.newLine();
        }
        writer.close();
    }

    public void printToScreen() {
        for (Double val : values) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public void sort() {
        Collections.sort(values);
    }

    public void logResults(long read, long sort, long write, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write("Java Time Measurements:\n");
            writer.write("Read:  " + read + " ms\n");
            writer.write("Sort:  " + sort + " ms\n");
            writer.write("Write: " + write + " ms\n");
            writer.write("--------------------------\n");
        } catch (IOException e) {
            System.out.println("Error writing log: " + e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        DoubleSorter ds = new DoubleSorter();
        Scanner sc = new Scanner(System.in);

        System.out.print("Input options:\n1. Keyboard\n2. File\nChoice: ");
        int inputChoice = sc.nextInt();

        long startRead = System.currentTimeMillis();
        if (inputChoice == 1) {
            ds.readFromKeyboard(sc);
        } else if (inputChoice == 2) {
            System.out.print("Enter input filename: ");
            String filename = sc.next();
            ds.readFromFile(filename);
        } else {
            System.out.println("Invalid input choice.");
            return;
        }
        long endRead = System.currentTimeMillis();

        long startSort = System.currentTimeMillis();
        ds.sort();
        long endSort = System.currentTimeMillis();

        System.out.print("Output options:\n1. Screen\n2. File\nChoice: ");
        int outputChoice = sc.nextInt();

        long startWrite = System.currentTimeMillis();
        if (outputChoice == 1) {
            ds.printToScreen();
        } else if (outputChoice == 2) {
            System.out.print("Enter output filename: ");
            String filename = sc.next();
            ds.writeToFile(filename);
        } else {
            System.out.println("Invalid output choice.");
            return;
        }
        long endWrite = System.currentTimeMillis();

        long readTime = endRead - startRead;
        long sortTime = endSort - startSort;
        long writeTime = endWrite - startWrite;

        System.out.println("\n⏱️ Time (Java):");
        System.out.println("Read:  " + readTime + " ms");
        System.out.println("Sort:  " + sortTime + " ms");
        System.out.println("Write: " + writeTime + " ms");

        ds.logResults(readTime, sortTime, writeTime, "log_java.txt");
    }
}
