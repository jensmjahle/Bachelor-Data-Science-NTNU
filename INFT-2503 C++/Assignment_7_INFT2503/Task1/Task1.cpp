
#include <iostream>
#include "Fraction.h"

using namespace std;
class Task1 {
public:
    static void run()
    {
        cout << "Task1" << endl;
        Fraction f1(1, 2);
        Fraction f2(1, 3);

        cout <<"f1 = " << f1 << endl;
        cout <<"f2 = " << f2 << endl;

        f1 = f1 + 5;
        f2 = 5 + f2;

        cout <<"f1 + 5 = " << f1 << endl;
        cout <<"5 + f2 = " << f2 << endl << endl;
    }


};
