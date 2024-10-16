//
// Created by jmjahle on 14.10.24.
//

#include "Set.h"
#include <algorithm>



Set::Set() {}

void Set::add(int integer) {
    bool exists = false;

    for(int i : set) {
        if(i == integer) {
            exists = true;
            break;
        }
    }
    if (!exists) {
        set.push_back(integer);
    }
}

Set Set::operator+(const Set &other) const {
    Set result = *this;
    for(int num : other.set) {
    result.add(num);
    }
    return result;
}

Set &Set::operator=(const Set &other) {
    if (this != &other) {
        set = other.set;
    }
    return *this;
}


ostream &operator<<(ostream &out, const Set &set) {
    out << "{ ";
    for (int num : set.set) {
        out << num << " ";
    }
    out << "}";
    return out;
}




