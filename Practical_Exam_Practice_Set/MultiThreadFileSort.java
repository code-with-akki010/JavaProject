import java.io.*;
import java.util.*;

// Thread to read names from file
class ReaderThread extends Thread {
    private List<String> names;
    private String inputFile;

    public ReaderThread(List<String> names, String inputFile) {
        this.names = names;
        this.inputFile = inputFile;
    }

    @Override
    public void run() {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            synchronized (names) {
                while ((line = br.readLine()) != null) {
                    names.add(line.trim());
                }
            }
            System.out.println("Reading completed from " + inputFile);
        } catch (IOException e) {
            System.out.println("Error while reading file: " + e.getMessage());
        }
    }
}

// Thread to sort and write names to new file
class SorterThread extends Thread {
    private List<String> names;
    private String outputFile;

    public SorterThread(List<String> names, String outputFile) {
        this.names = names;
        this.outputFile = outputFile;
    }

    @Override
    public void run() {
        try {
            synchronized (names) { 
                Collections.sort(names);
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
                for (String name : names) {
                    bw.write(name);
                    bw.newLine();
                }
            }
            System.out.println("Sorting & writing completed to " + outputFile);
        } catch (IOException e) {
            System.out.println("Error while writing file: " + e.getMessage());
        }
    }
}

// Main Class
public class MultiThreadFileSort {
    public static void main(String[] args) {
        List<String> names = Collections.synchronizedList(new ArrayList<>());

        String inputFile = "names.txt";         // Input file (must exist)
        String outputFile = "sorted_names.txt"; // Output file

        ReaderThread reader = new ReaderThread(names, inputFile);
        SorterThread sorter = new SorterThread(names, outputFile);

        try {
            // Start reader
            reader.start();
            reader.join(); // Wait until reading is done

            // Start sorter
            sorter.start();
            sorter.join(); // Wait until sorting is done

            System.out.println("Process finished successfully.");
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }
    }
}
