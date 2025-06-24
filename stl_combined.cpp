#include <iostream>
#include <fstream>
#include <vector>
#include <algorithm>
#include <chrono>
using namespace std;
using namespace chrono;

class DoubleVectorStorage {
private:
    vector<double> values;

public:
    void readFromKeyboard() {
        int size;
        cout << "Enter number of values: ";
        cin >> size;
        values.clear();
        cout << "Enter " << size << " double values:\n";
        for (int i = 0; i < size; ++i) {
            double val;
            cin >> val;
            values.push_back(val);
        }
    }

    void readFromFile(const string& filename) {
        ifstream file(filename);
        double val;
        values.clear();
        while (file >> val) {
            values.push_back(val);
        }
        file.close();
    }

    void writeToFile(const string& filename) const {
        ofstream file(filename);
        for (double val : values) {
            file << val << "\n";
        }
    }

    void printToScreen() const {
        for (double val : values) {
            cout << val << " ";
        }
        cout << "\n";
    }

    void sortValues() {
        sort(values.begin(), values.end());
    }
};

void logResults(const string& filename, long readTime, long sortTime, long writeTime) {
    ofstream log(filename, ios::app);
    log << "C++ STL Time Measurements:\n";
    log << "Read:  " << readTime << " ms\n";
    log << "Sort:  " << sortTime << " ms\n";
    log << "Write: " << writeTime << " ms\n";
    log << "--------------------------\n";
}

int main() {
    DoubleVectorStorage ds;
    string inputFile, outputFile;
    int inputChoice, outputChoice;

    cout << "Input options:\n1. Keyboard\n2. File\nEnter choice: ";
    cin >> inputChoice;

    auto startRead = high_resolution_clock::now();
    if (inputChoice == 1) {
        ds.readFromKeyboard();
    } else if (inputChoice == 2) {
        cout << "Enter input filename: ";
        cin >> inputFile;
        ds.readFromFile(inputFile);
    } else {
        cerr << "Invalid input choice.\n";
        return 1;
    }
    auto endRead = high_resolution_clock::now();

    auto startSort = high_resolution_clock::now();
    ds.sortValues();
    auto endSort = high_resolution_clock::now();

    cout << "Output options:\n1. Screen\n2. File\nEnter choice: ";
    cin >> outputChoice;

    auto startWrite = high_resolution_clock::now();
    if (outputChoice == 1) {
        ds.printToScreen();
    } else if (outputChoice == 2) {
        cout << "Enter output filename: ";
        cin >> outputFile;
        ds.writeToFile(outputFile);
    } else {
        cerr << "Invalid output choice.\n";
        return 1;
    }
    auto endWrite = high_resolution_clock::now();

    // Calculate and log time
    long readTime = duration_cast<milliseconds>(endRead - startRead).count();
    long sortTime = duration_cast<milliseconds>(endSort - startSort).count();
    long writeTime = duration_cast<milliseconds>(endWrite - startWrite).count();

    cout << "\n⏱️ Time (C++):\n";
    cout << "Read:  " << readTime << " ms\n";
    cout << "Sort:  " << sortTime << " ms\n";
    cout << "Write: " << writeTime << " ms\n";

    logResults("log_cpp.txt", readTime, sortTime, writeTime);

    return 0;
}
