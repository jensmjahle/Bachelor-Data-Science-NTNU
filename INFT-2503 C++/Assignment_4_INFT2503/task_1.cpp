#include "task_1.h"


#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool findDouble(const vector<double>& v, double value, int startPosition, int endPosition) {
    if (startPosition < 0 || endPosition > v.size() || startPosition >= endPosition) {
        return false; // Invalid range
    }
    auto it = find(v.begin() + startPosition, v.begin() + endPosition, value);
    return it != v.begin() + endPosition;
}


void task_1() {
    vector<double> v = {1.1, 2.2, 3.3, 4.4, 5.5};

    cout << "The vector elements are: ";
    for (const auto i : v) {
        cout << i << " ";
    }
    cout << endl;

    //Use of front() and back()
    cout << "The front vector element are: " << v.front() << endl;
    cout << "The back vector element are: " << v.back() << endl;

    //Use of emplace
    v.emplace( v.begin()+1, 6.6); // Insert 6.6 at the second position
    cout << "The vector elements after emplace are: ";
    for (const auto i : v) {
        cout << i << " ";
    }
    cout << endl;
    cout << "The front vector element after emplace are: " << v.front() << endl;

    // Use of find()
    cout << boolalpha; // Enable boolean output as "true" or "false"
    cout << "The element 3.3 is found in the vector (positions 0 to " << v.size() << "): " << findDouble(v, 3.3, 0, v.size()) << endl;
    cout << "The element 7.7 is found in the vector (positions 0 to " << v.size() << "): " << findDouble(v, 7.7, 0, v.size()) << endl;
    cout << "The element 6.6 is found in the vector (positions 0 to " << v.size() << "): " << findDouble(v, 6.6, 0, v.size()) << endl;
    cout << "The element 6.6 is found in the vector (positions 0 to 2): " << findDouble(v, 6.6, 0, 2) << endl;
    cout << "The element 6.6 is found in the vector (positions 3 to 5): " << findDouble(v, 6.6, 3, 5) << endl;
}

