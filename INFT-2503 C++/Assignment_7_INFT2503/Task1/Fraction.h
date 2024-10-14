
#ifndef FRACTION_H
#define FRACTION_H


#pragma once
#include <compare>
#include <ostream>

class Fraction {
public:
    int numerator;
    int denominator;

    Fraction();
    Fraction(int numerator, int denominator);
    void set(int numerator_, int denominator_ = 1);
    Fraction operator+(const Fraction &other) const;
    Fraction operator+(int integer) const;
    Fraction operator-(const Fraction &other) const;
    Fraction operator*(const Fraction &other) const;
    Fraction operator/(const Fraction &other) const;
    Fraction operator-() const;
    Fraction &operator++(); // Preinkrement
    Fraction &operator--(); // Predekrement
    Fraction &operator+=(const Fraction &other);
    Fraction &operator-=(const Fraction &other);
    Fraction &operator*=(const Fraction &other);
    Fraction &operator/=(const Fraction &other);
    Fraction &operator=(const Fraction &other);
    bool operator==(const Fraction &other) const;
    bool operator!=(const Fraction &other) const;
    bool operator<=(const Fraction &other) const;
    bool operator>=(const Fraction &other) const;
    bool operator<(const Fraction &other) const;
    bool operator>(const Fraction &other) const;
    friend std::ostream &operator<<(std::ostream &out, const Fraction &fraction);

private:
    void reduce();
    int compare(const Fraction &other) const;
};

Fraction operator+(int integer, const Fraction &other); // Addition 5 + f

#endif //FRACTION_H
