#pragma once

//*************Task 1*************//

const double pi = 3.141592;

class Circle {
public:
  Circle(double radius_);  // changed "circle" to "Circle"
  double get_area() const; // changed return type to double instead of int
  double get_circumference() const;

private: // added : after "private"
  double radius;
}; // added ";"

// ==> Implementasjon av klassen Circle

Circle::Circle(double radius_) : radius(radius_) { // removed public declaration and initialized radius correctly
}

double Circle::get_area() const { // changed type to double and added const
  return pi * radius * radius;
}

double Circle::get_circumference() const { // added double
  return 2.0 * pi * radius;                // removed unnecessary and not initialized variable "circumference"
}
