
#include <iostream>
#include <set>

#include "Set.h"



using namespace std;
class Task2 {
public:
    static void run()
    {
        cout << "Task2" << endl;

        Set set1;
        Set set2;
        Set set3;
        Set set4;

        set1.add(1);
        set1.add(4);
        set1.add(5);

        set2.add(3);
        set2.add(4);
        set2.add(8);
        set2.add(8); //should not be added, because its already in the set

        set3 = set1;
        set4 = set1+set2;

        cout <<"Set 1: " << set1 << endl;
        cout <<"Set 2: " << set2 << endl;
        cout <<"Set 3 = set 1: " << set3 <<endl;
        cout <<"Set 4 = set 1 union set 2: " << set4 << endl;
    }
};
