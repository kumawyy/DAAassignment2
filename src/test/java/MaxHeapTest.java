package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class MaxHeapTest {

    @Test
    void testInsertAndGetMax() {
        PerformanceTracker tracker = new PerformanceTracker();
        MaxHeap heap = new MaxHeap(10, tracker);
        heap.insert(10);
        heap.insert(20);
        heap.insert(5);
        assertEquals(20, heap.getMax());
    }

    @Test
    void testExtractMax() {
        PerformanceTracker tracker = new PerformanceTracker();
        MaxHeap heap = new MaxHeap(10, tracker);
        heap.insert(10);
        heap.insert(20);
        heap.insert(15);
        assertEquals(20, heap.extractMax());
        assertEquals(15, heap.getMax());
    }

    @Test
    void testIncreaseKey() {
        PerformanceTracker tracker = new PerformanceTracker();
        MaxHeap heap = new MaxHeap(10, tracker);
        heap.insert(10);
        heap.insert(20);
        heap.insert(5);
        heap.increaseKey(2, 25);
        assertEquals(25, heap.getMax());
    }

    @Test
    void testEmptyHeap() {
        PerformanceTracker tracker = new PerformanceTracker();
        MaxHeap heap = new MaxHeap(10, tracker);
        assertThrows(IllegalStateException.class, heap::getMax);
    }

    @Test
    void benchmarkMaxHeap() {
        int[] sizes = {100, 1000, 5000, 10000};
        String csvFile = "docs/performance-plots/performance.csv";

        java.io.File folder = new java.io.File("docs/performance-plots");
        if (!folder.exists()) folder.mkdirs();

        try (FileWriter writer = new FileWriter(csvFile)) {
            writer.write("size,comparisons,swaps,array_accesses\n");

            for (int n : sizes) {
                PerformanceTracker tracker = new PerformanceTracker();
                MaxHeap heap = new MaxHeap(n, tracker);
                Random rand = new Random();

                for (int i = 0; i < n; i++) heap.insert(rand.nextInt(100000));
                while (!heap.isEmpty()) heap.extractMax();

                System.out.println("Benchmark for n=" + n + " done. " + tracker);

                writer.write(n + "," + tracker.getComparisons() + "," +
                        tracker.getSwaps() + "," + tracker.getArrayAccesses() + "\n");
            }

            System.out.println("CSV saved to " + csvFile);

        } catch (IOException e) {
            e.printStackTrace();
            fail("Failed to write CSV file");
        }
    }
}
