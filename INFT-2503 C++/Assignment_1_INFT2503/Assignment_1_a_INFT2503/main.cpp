#include <iostream>
#include <limits>

int main() {
  // initialize variables
  const int length = 5;
  int underTen = 0;
  int betweenTenAndTwenty = 0;
  int aboveTwenty = 0;

  double input = 0.0;

  // loops thru 5 times
  for (int i = 0; i < length; i++) {

    // checks if the input is a double
    while (1) {
      std::cout << "Type in temperature number " << i + 1 << ": ";
      if (std::cin >> input) {
        break;
      } else {
        std::cout << "Invalid input. Please type in a valid number (use \".\" not \",\" in decimals) \n";
        std::cin.clear();
        std::cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
      }
    }

    // categorize input into correct interval
    if (input < 10.0) {
      underTen++;
    } else if (input >= 10.0 && input <= 20.0) {
      betweenTenAndTwenty++;
    } else if (input > 20.0) {
      aboveTwenty++;
    } else {
      std::cout << "invalid input \n";
    }
  }

  // print the results in the terminal
  std::cout << "Temperatures bellow 10: " << underTen << "\n";
  std::cout << "Temperatures between 10 and 20: " << betweenTenAndTwenty << "\n";
  std::cout << "Temperatures above 20: " << aboveTwenty << "\n";
}
