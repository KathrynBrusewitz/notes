/*--------------------------------------------------------------------

  Bellevue Class: PROG 111
  Term/Date:      Fall 11/21/2013
  Instructor:     Robert Main
  
  Project #:      8
  File Name:      main.cpp
  Programmer:     Kathryn Brusewitz

  Uses stats class to retrieve and analyze data for a years worth 
  of rainfall. Reports total rainfall, average rainfall, and months 
  with the most and least rainfall.

 --------------------------------------------------------------------*/

#include <iostream>  // Defines objects and classes used for stream I/O
#include "Stats.h"   // Class Definition header file
#include <iomanip>   // For manipulating input/output stream
#include <windows.h> // For setting cursor positions
#include <string>

const int NUM_MONTHS = 12;

void placeCursor(HANDLE, int, int);

int main() {

    std::string month[NUM_MONTHS] = { "January", "February", "March", "April", "May", 
        "June", "July", "August", "September", "October", "November", "December" };
    int highestMonth;
    int lowestMonth;
    double userInput;

    Stats rainfallStats;

    // Create handle to the standard output screen
    HANDLE screen = GetStdHandle(STD_OUTPUT_HANDLE);

    std::cout << "This program analyzes a year's worth of rainfall data.\n\n";
    std::cout << "Enter the amount of rainfall for the month in inches: \n\n";

    // Print Form (Months)
    for (int i = 0; i < NUM_MONTHS; i++)
        std::cout << month[i] << ":" << std::endl;

    // User Input
    for (int i = 0; i < NUM_MONTHS; i++) {
        placeCursor(screen, (4 + i), 12);
        std::cin >> userInput;
        if(!rainfallStats.storeValue(userInput)) 
            std::cout << "Error: Can't add more values" << std::endl;
    }

    // Find months with most and least rainfall
    highestMonth = rainfallStats.highest();
    lowestMonth  = rainfallStats.lowest();

    // Display Report
    std::cout << "\n             Rain Report for the Year";
    std::cout << std::fixed << std::setprecision(2) << std::endl << std::endl;
    std::cout << "Total rainfall: " << rainfallStats.total() << " inches" << std::endl;
    std::cout << "Average rainfall: " << rainfallStats.average() << " inches" << std::endl;
    std::cout << "The most rain fell in " << month[highestMonth] << " with ";
    std::cout << rainfallStats.getValue(highestMonth) << " inches." << std::endl;
    std::cout << "The least rain fell in " << month[lowestMonth] << " with ";
    std::cout << rainfallStats.getValue(lowestMonth) << " inches." << std::endl;

    // Prevent the Console Window from closing during debug mode
    std::cin.ignore(std::cin.rdbuf()->in_avail());
    std::cout << "\nPress only the 'Enter' key to exit program: ";
    std::cin.get();
    

    return 0;
}

void placeCursor(HANDLE screen, int row, int col) {
    COORD position;
    position.Y = row;
    position.X = col;
    SetConsoleCursorPosition(screen, position);
}
