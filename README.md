# Assignment 2: Algorithmic Analyis and Peer Code Review  
### Student B – Max-Heap Implementation  

**Name:** Aslan Muratov  
**University:** Astana IT University  
**Group:** SE-2425  

---

## 📖 Overview  
This repository contains the implementation of **Max-Heap** with `increaseKey` and `extractMax` operations, as part of **Assignment 2**.  
The project follows Maven structure and includes:  
- Implementation code (`src/main/java/`)  
- Unit tests (`src/test/java/`)  
- Performance tracker and CLI benchmark runner  
- Empirical results in CSV + performance plots  

---

## 🚀 Features  
- Max-Heap implementation in Java  
- `increaseKey` and `extractMax` operations  
- Performance tracking (comparisons, swaps, memory usage)  
- CLI interface for testing with input sizes (n = 100, 1000, 10000, 100000)  
- Unit tests with JUnit5 (edge cases included)  
- Benchmarks + CSV export  

---

## 🛠️ Repository Structure  

```

assignment2-maxheap/
├── src/main/java/
│   ├── algorithms/MaxHeap.java
│   ├── metrics/PerformanceTracker.java
│   └── cli/BenchmarkRunner.java
├── src/test/java/
│   └── algorithms/MaxHeapTest.java
├── docs/
│   ├── analysis-report.pdf
│   └── performance-plots/
├── README.md
└── pom.xml

````

---

## 📊 Usage  

### 1. Build the project  
```bash
mvn clean install
````

### 2. Run tests

```bash
mvn test
```

### 3. Run benchmarks

```bash
java -cp target/assignment2-maxheap-1.0-SNAPSHOT.jar cli.BenchmarkRunner
```

Benchmark results will be exported as CSV into `docs/performance-plots/`.

---

## 📈 Complexity Analysis

* **Time Complexity**

  * Best: Ω(n log n)
  * Average: Θ(n log n)
  * Worst: O(n log n)

* **Space Complexity**

  * O(n)

Performance plots and empirical results are available in `docs/performance-plots/`.

---

## 👥 Pair Work

* **Student A**: Min-Heap Implementation
* **Student B (me)**: Max-Heap Implementation

Each partner analyzes the other’s implementation and produces an **analysis report** in PDF.

---

## 📑 Deliverables

* ✅ Implementation (this repo)
* ✅ Tests & benchmarks
* ✅ Performance plots
* ✅ `docs/analysis-report.pdf`




