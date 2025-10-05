package cli;

import algorithms.MaxHeap;
import metrics.PerformanceTracker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class BenchmarkRunner {

    public static void main(String[] args) {
        // Размеры массивов для теста
        int[] sizes = {100, 1000, 5000, 10000, 50000};
        String csvFile = "performance.csv";

        if (args.length > 0) {
            csvFile = args[0];
        }

        try (FileWriter writer = new FileWriter(csvFile)) {
            writer.write("size,comparisons,swaps,array_accesses\n");

            for (int n : sizes) {
                PerformanceTracker tracker = new PerformanceTracker();
                MaxHeap heap = new MaxHeap(n, tracker);

                Random rand = new Random();

                for (int i = 0; i < n; i++) {
                    heap.insert(rand.nextInt(100000));
                }

                while (!heap.isEmpty()) {
                    heap.extractMax();
                }

                System.out.println("Benchmark completed for n = " + n);
                System.out.println(tracker);

                writer.write(n + "," + tracker.getComparisons() + "," +
                        tracker.getSwaps() + "," + tracker.getArrayAccesses() + "\n");
            }

            System.out.println("All performance metrics saved to " + csvFile);
        } catch (IOException e) {
            System.err.println("Error writing CSV file: " + e.getMessage());
        }
    }
}
