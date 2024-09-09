#include <iostream>

void assignment_1() {
  int i = 3;
  int j = 5;
  int *p = &i;
  int *q = &j;
  
  std::cout << "*************Assignment 1************* \n\n";
  
  std::cout << "Variable i -> value: " << i << " address: " << &i << "\n";
  std::cout << "Variable j -> value: " << j << " address: " << &j << "\n";
  std::cout << "Variable p -> value: " << *p << " address: " << p << "\n";
  std::cout << "Variable q -> value: " << *q << " address: " << q << "\n \n";
  
  *p = 7; // value of i changes to 7
  std::cout << "Variable i -> value: " << i << " address: " << &i << "\n";
  std::cout << "Variable j -> value: " << j << " address: " << &j << "\n";
  std::cout << "Variable p -> value: " << *p << " address: " << p << "\n";
  std::cout << "Variable q -> value: " << *q << " address: " << q << "\n \n";
  
  *q += 4; // value of j changes to 9
  std::cout << "Variable i -> value: " << i << " address: " << &i << "\n";
  std::cout << "Variable j -> value: " << j << " address: " << &j << "\n";
  std::cout << "Variable p -> value: " << *p << " address: " << p << "\n";
  std::cout << "Variable q -> value: " << *q << " address: " << q << "\n \n";
  
  *q = *p + 1; // value of j changes to 8 (value of i plus 1)
  std::cout << "Variable i -> value: " << i << " address: " << &i << "\n";
  std::cout << "Variable j -> value: " << j << " address: " << &j << "\n";
  std::cout << "Variable p -> value: " << *p << " address: " << p << "\n";
  std::cout << "Variable q -> value: " << *q << " address: " << q << "\n \n";
  
  p = q; // p points to same address as q -> int j
  std::cout << "Variable i -> value: " << i << " address: " << &i << "\n";
  std::cout << "Variable j -> value: " << j << " address: " << &j << "\n";
  std::cout << "Variable p -> value: " << *p << " address: " << p << "\n";
  std::cout << "Variable q -> value: " << *q << " address: " << q << "\n \n";
  
  std::cout << *p << " " << *q << "\n \n";
  
  std::cout << "*************Assignment 1 completed************* \n\n";
}

void assignment_4() {
  
  std::cout << "*************Assignment 4************* \n\n";
  
  // Original code
  // int a = 5;
  // int &b;           b is defined as a reference but it is never initialized, resulting in an error.
  // int *c;
  // c = &b;           b is a reference and is currently uninitialized and has no address.
  // *a = *b + *c;     a is an int not a pointer and can therefore not be used with a "*". b is also a reference not a pointer.
  // &b =2;            &b is the address to b and cannot be assigned a value. 
  
  // Fixed code
  int a = 5;
  int &b = a;        //b must refer to a valid variable when initialized.       
  int *c;
  c = &a;            //since b is a reference it does not make sense to ask for its address directly. It gives more sense to use &a
  a = b + *c;        //removed the "*" before a and b
  b =2;             //removed "&" before "b". It now changes the value of "a" since "b" refers to "a".
  
  std::cout << "*************Assignment 4 completed************* \n\n";
}

void assignment_5() {
  std::cout << "*************Assignment 5 ************* \n\n";
  
  double number = 0.0;
  double *pointer = &number;
  double &ref = number;
  
  number = 4.0;
  std::cout <<"Number assigned directly: " << number << "\n";
  
  *pointer = 10.0;
  std::cout <<"Number assigned using pointer: " << number << "\n";
  
  ref = 3.0;
  std::cout <<"Number assigned using reference: " << number << "\n\n";
  
  std::cout << "*************Assignment 5 completed************* \n\n";
}

int find_sum(const int *table, int length) {
  int result = 0;
  for (int i = 0; i < length; i++) {
    result = result + table[i];
  }
  return result;
}

void assignment_6() {
  std::cout << "*************Assignment 6 ************* \n\n";
  
  int table[20];
  int *pointer;
  pointer = table;
  
  for (int i = 0; i < 20; i++) {
    table[i] = i+1;
  }
  
  int sum1 = find_sum(pointer, 10);
  pointer = pointer + 10; //pointer starts on table[10] 
  int sum2 = find_sum(pointer, 5);
  pointer = pointer + 5; //pointer starts on table[15]
  int sum3 = find_sum(pointer, 5);
  
  std::cout << "Sum of first 10 numbers: " << sum1 <<"\n";
  std::cout << "Sum of 5 next numbers: " << sum2 <<"\n";
  std::cout << "Sum of last 5 numbers: " << sum3 <<"\n\n";
  
  std::cout << "*************Assignment 6 completed************* \n\n";
}

int main() {
  //Run all the assignments at the same time or comment out some for a cleaner terminal
 assignment_1();
 assignment_4();
 assignment_5();
 assignment_6();
 return 0;
}
