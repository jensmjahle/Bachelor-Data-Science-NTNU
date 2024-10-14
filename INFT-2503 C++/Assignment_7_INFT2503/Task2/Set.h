//
// Created by jmjahle on 14.10.24.
//

#ifndef SET_H
#define SET_H
#include <ostream>
#include <vector>
#pragma once

using namespace std;

class Set {
public:
    std::vector<int> set;
    Set();
    Set &operator=(const Set &other);
    friend std::ostream &operator<<(std::ostream &out, const Set &set);
    void add(int integer);
    Set operator+(const Set &other) const;

};





#endif //SET_H
