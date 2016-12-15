/*--------------------------------------------------------------------
  
  Project: Rainfall Statistics
  File: main.cpp
  Kathryn Brusewitz

 --------------------------------------------------------------------*/

#include <iostream>
#include <string>
#include "Rainfall.h"

std::string month (int m) {
    switch (m) {
        case 1: return "January";
        case 2: return "February";
        case 3: return "March";
        case 4: return "April";
        case 5: return "May";
        case 6: return "June";
        case 7: return "July";
        case 8: return "August";
        case 9: return "September";
        case 10: return "October";
        case 11: return "November";
        case 12: return "December";
        default: return "unknown";
    }
}

void displayReport(Rainfall r) {
    std::cout << "Rainfall Statistics For Your Area:" << std::endl;
    std::cout << "Driest Month: " << month(r.driestMonth()) << " with " << r.getInches(r.driestMonth()) << " inches." << std::endl;
    std::cout << "Wettest Month: " << month(r.wettestMonth()) << " with " << r.getInches(r.wettestMonth()) << " inches." << std::endl;
    std::cout << "Total Rainfall: " << r.totalRainfall() << " inches." << std::endl;
    std::cout << "Average Rainfall: " << r.averageRainfall() << " inches." << std::endl;
}

int main () {

    double a[12];

    std::cout << "Enter your rain statistics in inches for the following months: " << std::endl;
    for (int i = 0; i < 12; i++) {
        std::cout << month(i+1) << ": ";
        std::cin >> a[i];
    }

    Rainfall bellevue(a);
    displayReport(bellevue);

    return 0;
}