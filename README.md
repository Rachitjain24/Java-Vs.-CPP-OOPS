# 🔢 Double Value Sorter – C++ STL and Java

This project contains two implementations of a program that:

- Reads `double` values from keyboard or file
- Sorts them in ascending order
- Outputs to screen or file
- Measures and logs execution time for:
  - Reading input
  - Sorting
  - Writing output

---

## 📁 Files

| File Name           | Description                                     |
|--------------------|-------------------------------------------------|
| `stl_combined.cpp` | C++ STL version (uses `vector` and `sort`)      |
| `DoubleSorter.java`| Java version (uses `ArrayList` and `Collections.sort`) |
| `log_cpp.txt`      | Auto-generated time log for C++ version         |
| `log_java.txt`     | Auto-generated time log for Java version        |
| `data.txt`         | Sample input file (optional)                    |
| `README.md`        | This file                                       |

---

## 🧱 Requirements

### ✅ C++ (on Linux or WSL)

- g++ 11 or newer

### ✅ Java

- JDK 11 or newer (recommended: OpenJDK 17)

---

## ⚙️ Compilation & Execution

### 🔹 Compile and run C++ program:

```bash
g++ stl_combined.cpp -o stl_combined -std=c++11
./stl_combined
````

### 🔹 Compile and run Java program:

```bash
javac DoubleSorter.java
java DoubleSorter
```

---

## 🧪 Example Workflow

### Input File (e.g. `data.txt`):

```
3.2
1.5
4.7
0.8
2.1
```

### Output Options:

* To **screen**: displays sorted values
* To **file**: saves sorted values to file (you specify filename)

---

## ⏱️ Time Logging

Each run automatically appends time measurement logs to:

* `log_cpp.txt` — for C++ version
* `log_java.txt` — for Java version

### Example log output:

```
Java Time Measurements:
Read:  6 ms
Sort:  10 ms
Write: 7 ms
--------------------------
```

---

## 🧪 Generate Large Test Data (Optional)

```bash
python3 -c "import random; [print(random.uniform(0, 10000)) for _ in range(10000)]" > data.txt
```

---

## 📊 Performance Notes

* C++ STL is fastest due to optimized `std::sort`
* Java is close in sorting, but slightly slower in file I/O
* C++ classical (bubble sort) is **significantly slower** and not included in this version

---

## 📌 Project Goal

This project is part of an assignment to compare classical C++ vs modern STL and Java, evaluating performance and code clarity.

---

## 📝 Author

* Developed by Rachit Jain
* For academic demonstration and performance benchmarking
