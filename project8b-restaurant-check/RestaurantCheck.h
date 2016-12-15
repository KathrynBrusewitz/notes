#pragma once

/*--------------------------------------------------------------------
  
  Project: Restaurant Check
  File: RestaurantCheck.h
  Kathryn Brusewitz

 --------------------------------------------------------------------*/

class RestaurantCheck {
private:
    static const int MENU_ITEMS = 10;
    static const int MAX_CHOICES = 5;
    static const std::string itemDesc[MENU_ITEMS];
    static const double itemCost[MENU_ITEMS];
    static int userChoices[MAX_CHOICES];
    double taxRate;
    double tipRate;
public:
    RestaurantCheck();
    RestaurantCheck(double, double);
    void setTaxRate(double);
    void setTipRate(double);
    bool testTaxRate(double);
    bool testTipRate(double);
    void presentMenu();
    void placeOrder();
    void issueCheck();
    double calculateTax(double);
    double calculateTip(double);
    static double MIN_TAX_RATE() { return 1.0; };
    static double MAX_TAX_RATE() { return 12.0; };
    static double MIN_TIP_RATE() { return 5.0; };
    static double MAX_TIP_RATE() { return 15.0; };
};