#pragma once
#include <string>

double sales_tax = 1.25;

class Commodity {
public:
  Commodity(std::string name_, int id_, double price_);
  std::string get_name() const;
  int get_id() const;
  double get_price() const;
  double get_price(double quantity) const;
  void set_price(double new_price);
  double get_price_with_sales_tax(double quantity) const;

private:
  std::string name;
  int id;
  double price;
};

Commodity::Commodity(std::string name_, int id_, double price_) : name(name_), id(id_), price(price_) {}

std::string Commodity::get_name() const {
  return name;
}

int Commodity::get_id() const {
  return id;
}

double Commodity::get_price(double quantity) const {
  return price * quantity;
}

double Commodity::get_price() const {
  return price;
}

void Commodity::set_price(double new_price) {
  price = new_price;
}

double Commodity::get_price_with_sales_tax(double quantity) const {
  return price * sales_tax * quantity;
}
