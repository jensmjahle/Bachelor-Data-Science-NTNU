#include <fstream>
#include <iostream>
#include <limits>

void read_temperatures(double temperatures[], int length);
void categorize_temperatures(double temperatures[], int length, int &bellowTen, int &betweenTenAndTwenty, int &aboveTwenty);

int main() {

  const int length = 5;
  double temperatures[5];
  int bellowTen = 0;
  int betweenTenAndTwenty = 0;
  int aboveTwenty = 0;

  // read temperatures from file
  read_temperatures(temperatures, length);

  // prints out the temperatures read from a file
  for (int i = 0; i < length; i++) {
    if (temperatures[i] == -9999) {
      std::cout << "Temperature from file nr. " << i + 1 << " is invalid \n";
    } else {
      std::cout << "Temperature from file nr. " << i + 1 << ": " << temperatures[i] << "\n";
    }
  }

  // categorize temperatures
  categorize_temperatures(temperatures, length, bellowTen, betweenTenAndTwenty, aboveTwenty);

  // print the results in the terminal
  std::cout << "\nTemperatures bellow 10: " << bellowTen << "\n";
  std::cout << "Temperatures between 10 and 20: " << betweenTenAndTwenty << "\n";
  std::cout << "Temperatures above 20: " << aboveTwenty << "\n";
}

// reads temperatures from a file
void read_temperatures(double temperatures[], int length) {
  const char filename[] = "numberfile.dat";
  std::ifstream file;
  file.open(filename);

  // checks that the file is found
  if (!file) {
    std::cout << "An error occurred while reading file, exiting program";
    exit(EXIT_FAILURE); // exiting the program
  }

  double number;
  for (int i = 0; i < length; i++) {

    if (file >> number) {
      temperatures[i] = number;
    } else {
      std::cout << "Temperature nr. " << i + 1 << " is invalid \n \n";
      file.clear();
      file.ignore(1, ' '); // Skip the invalid character// Clear the error state
                           //  file.ignore(std::numeric_limits<std::streamsize>::max(), '\n'); // Skip to the next line or next valid input
      temperatures[i] = -9999;
    }
  }
  file.close();
}

// categorizes the temperatures in the correct interval
void categorize_temperatures(double temperatures[], int length, int &bellowTen, int &betweenTenAndTwenty, int &aboveTwenty) {
  for (int i = 0; i < length; i++) {
    // categorize input into correct interval
    if (temperatures[i] == -9999) {
      continue;
    } else if (temperatures[i] < 10.0) {
      bellowTen++;
    } else if (temperatures[i] >= 10.0 && temperatures[i] <= 20.0) {
      betweenTenAndTwenty++;
    } else if (temperatures[i] > 20.0) {
      aboveTwenty++;
    } else {
      std::cout << "invalid input \n";
    }
  }
}
