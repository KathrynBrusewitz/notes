/*--------------------------------------------------------------------
  
  Project: Restaurant Check
  File: RestaurantCheck.cpp
  Kathryn Brusewitz

 --------------------------------------------------------------------*/

#include "iostream"
#include <string>
#include <iomanip> 
#include "RestaurantCheck.h"

RestaurantCheck::RestaurantCheck() { taxRate = 6.5; tipRate = 15; }
RestaurantCheck::RestaurantCheck(double tx, double tp) { taxRate = tx; tipRate = tp; }

void RestaurantCheck::setTaxRate(double tx) { taxRate = tx; }
void RestaurantCheck::setTipRate(double tp) { tipRate = tp; }

bool RestaurantCheck::testTaxRate(double tx) {
    return (tx >= MIN_TAX_RATE() && tx <= MAX_TAX_RATE());
}

bool RestaurantCheck::testTipRate(double tr) {
    return (tr >= MIN_TIP_RATE() && tr <= MAX_TIP_RATE());
}

const std::string RestaurantCheck::itemDesc[] = { "Fried Chicken", "Chicken Fried Steak", "Rib Eye Steak", "T-Bone Steak", "Chicken Soup", "Soup of Day", "Meatloaf Sandwich", "Club Sandwich", "Chef's First Choice", "Catch of Day" };
const double RestaurantCheck::itemCost[] = { 12.50, 13.25, 14.99, 12.99, 5.59, 6.00, 9.90, 9.90, 8.99, 19.00 };
int RestaurantCheck::userChoices[] = { -1, -1, -1, -1, -1 };

void RestaurantCheck::presentMenu() {
    std::cout << std::fixed << std::showpoint << std::setprecision(2);
    for (int index = 0; index < MENU_ITEMS; index ++) {
        std::cout << "Menu Item:  " << std::setw(4) << (index + 1);
        std::cout << ": " << std::setw(30) << itemDesc[index] << std::setw(7) << "$ " << itemCost[index] << std::endl;
    }
}

void RestaurantCheck::placeOrder() {
    int itemSelected;
    std::cout << "Choose menu items by entering a number from 1 through " << MENU_ITEMS << "." << std::endl;
    std::cout << "To finish order, enter any other number outside of range (e.g. 0)." << std::endl;
    for (int itemCount = 0; itemCount < MAX_CHOICES; itemCount++) {
        std::cin >> itemSelected;
        if (itemSelected > 0 && itemSelected < MENU_ITEMS + 1) {
            userChoices[itemCount] = itemSelected - 1; // If user entered "1" for "Fried Chicken", userChoices[0] will have value "0"
        } else { break; };
    }
    /* UNCOMMENT IF YOU WANT TO SEE USERCHOICES[]
    std::cout << "Print out userChoices array to make sure it's correct: ";
    for (int i = 0; i < MAX_CHOICES; i++) { std::cout << userChoices[i] << " "; }
    std::cout << std::endl;
    */
}

void RestaurantCheck::issueCheck() {
    double subTotal = 0.0;
    std::cout << "TERRI'S RESTAURANT" << std::endl << "GUEST CHECK" << std::endl;
    for (int i = 0; i < MAX_CHOICES; i++) {
        if (userChoices[i] != -1) {
            std::cout << itemDesc[userChoices[i]] << " " << itemCost[userChoices[i]] << std::endl;
            subTotal += itemCost[userChoices[i]];
        }
    }
    std::cout << "Sub Total: " << subTotal << std::endl;
    std::cout << "Tax: " << calculateTax(subTotal) << std::endl;
    std::cout << "Tip: " << calculateTip(subTotal) << std::endl;
    std::cout << "Grand Total: " << (subTotal + calculateTax(subTotal) + calculateTip(subTotal)) << std::endl;
}

double RestaurantCheck::calculateTax(double t) { return t * (taxRate * .01); }
double RestaurantCheck::calculateTip(double t) { return t * (tipRate * .01); }