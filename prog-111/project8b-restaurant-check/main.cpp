/*--------------------------------------------------------------------
  
  Project: Restaurant Check
  File: main.cpp
  Kathryn Brusewitz

 --------------------------------------------------------------------*/

#include <iostream>          // Defines objects and classes used for stream I/O
#include <iomanip>           // Defines output stream manipulators
#include "RestaurantCheck.h" // Defines data members of class: RestaurantCheck

int main() {
    double taxRate;
    double tipRate;
    int index = 0;
    RestaurantCheck myRestaurant;

    std::cout << "PROG-111: Project #8, Version 2 Solution" << std::endl;

    do {
        std::cout << "Enter the tax rate, as a %: ";
        std::cin >> taxRate;
    } while (!myRestaurant.testTaxRate(taxRate));
    
    do {
        std::cout << "Enter the tip, as a %: ";
        std::cin >> tipRate;
    } while (!myRestaurant.testTipRate(tipRate));

    myRestaurant.setTaxRate(taxRate);
    myRestaurant.setTipRate(tipRate);

    std::cout << "Here are our current menu items:" << std::endl;
    std::cout << std::fixed << std::showpoint << std::setprecision(2);
    myRestaurant.presentMenu();

    myRestaurant.placeOrder();

    myRestaurant.issueCheck();

    std::cout << std::endl << "Press \"Enter\" to Exit the program: ";
    std::cin.get();

    return 0;
}