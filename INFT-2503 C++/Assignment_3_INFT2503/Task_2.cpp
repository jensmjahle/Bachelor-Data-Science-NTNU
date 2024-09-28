//*************Task 2*************//

#include "Circle.hpp"
#include <iostream>

using namespace std;

void task_2() {
  Circle circle(5);

  double area = circle.get_area();
  cout << "Arealet er lik " << area << endl;

  double circumference = circle.get_circumference();
  cout << "Omkretsen er lik " << circumference << endl;
}
