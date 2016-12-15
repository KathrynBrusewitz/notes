/*--------------------------------------------------------------------

  Bellevue Class: PROG 111
  Term/Date:      Fall 11/04/2013
  Instructor:     Robert Main
  
  Project #:      7A
  File Name:      monthly-budget.cpp
  Programmer:     Kathryn Brusewitz

 --------------------------------------------------------------------*/

#include <iostream>  // Defines objects and classes used for stream I/O
#include <iomanip>   // Defines functions for manipulating I/O
#include <windows.h> // To set cursor positions
#include <cmath>     // Math.abs()

struct MonthlyBudget {
    double housing,
           utilities,
           houseExp,
           transport,
           food,
           medical,
           insurance,
           entertain,
           clothing,
           misc;

    MonthlyBudget(double h = 500.00, double u = 150.00, double hE = 65.00, double t = 50.00, 
                  double f = 250.00, double me = 30.00, double i = 100.00, double e = 150.00, 
                  double c = 75.00,  double mi = 50.00) {   
        housing     = h;
        utilities   = u;
        houseExp    = hE;
        transport   = t;
        food        = f;
        medical     = me;
        insurance   = i;
        entertain   = e;
        clothing    = c;
        misc        = mi;       
    }
};

void placeCursor(HANDLE, int, int);
void displayPrompts(HANDLE, MonthlyBudget);
void getUserInput(HANDLE, MonthlyBudget&);
void displayData(HANDLE, MonthlyBudget, MonthlyBudget);

/*--------------------------------------------------------------------

  main() creates a handle to the standard output screen so that the 
  cursor can be repositioned later. 

  Also creates two MonthlyBudget objects:
  One for the student's budget, the other for the user's expenditures.
  
  Then displays the form to the user before asking for input, and a 
  table of the differences between the budget and expenses.

 --------------------------------------------------------------------*/

int main() {

    // Get the handle to standard output device (console)
    HANDLE screen = GetStdHandle(STD_OUTPUT_HANDLE);

    MonthlyBudget budget;   // Student budget
    MonthlyBudget user;     // User expenditures

    // Display the form before user input
    displayPrompts(screen, budget);
    getUserInput(screen, user);

    // Display the budget comparison
    displayData(screen, budget, user);

    // Prevent Console Window from closing
    placeCursor(screen, 56, 8);
    std::cin.ignore(std::cin.rdbuf()->in_avail());
    std::cout << "\nPress only the 'Enter' key to exit program: ";
    std::cin.get();

    return 0;
}

/*--------------------------------------------------------------------
  
  placeCursor() creates a COORD struct and sets its X and Y positions
  for the cursor with the integers specified through the arguments
  and then sets the cursor position.

 --------------------------------------------------------------------*/

void placeCursor(HANDLE screen, int row, int col) {
    COORD position;
    position.Y = row;
    position.X = col;
    SetConsoleCursorPosition(screen, position);
}

/*--------------------------------------------------------------------
  
  displayPrompts() creates and displays a form prompt. Displays the 
  budget for each category and leaves right side for future user input.

 --------------------------------------------------------------------*/

void displayPrompts(HANDLE screen, MonthlyBudget budget) {
    placeCursor(screen, 1, 12);
    std::cout << "Enter the amounts you spent in the past month."    << std::endl;
    placeCursor(screen, 4, 10);
    std::cout << "Category           Budget           Your Expenses" << std::endl;
    placeCursor(screen, 5, 10);
    std::cout << "-------------------------------------------------" << std::endl;

    std::cout << std::fixed << std::setprecision(2);
    placeCursor(screen, 6, 10);
    std::cout << "Housing:           $" << budget.housing    << std::endl;
    placeCursor(screen, 8, 10);
    std::cout << "Utilities:         $" << budget.utilities  << std::endl;
    placeCursor(screen, 10, 10);
    std::cout << "Household:         $" << budget.houseExp   << std::endl;
    placeCursor(screen, 12, 10);
    std::cout << "Transportation:    $" << budget.transport  << std::endl;
    placeCursor(screen, 14, 10);
    std::cout << "Food:              $" << budget.food       << std::endl;
    placeCursor(screen, 16, 10);
    std::cout << "Medical:           $" << budget.medical    << std::endl;
    placeCursor(screen, 18, 10);
    std::cout << "Insurance:         $" << budget.insurance  << std::endl;
    placeCursor(screen, 20, 10);
    std::cout << "Entertainment:     $" << budget.entertain  << std::endl;
    placeCursor(screen, 22, 10);
    std::cout << "Clothing:          $" << budget.clothing   << std::endl;
    placeCursor(screen, 24, 10);
    std::cout << "Miscellaneous:     $" << budget.misc       << std::endl;
}

/*--------------------------------------------------------------------

  getUserInput() sets cursor at each entry field inside the form. 
  Waits for user to enter their expense in the past month for that 
  category and stores it inside users MonthlyObject.

 --------------------------------------------------------------------*/

void getUserInput(HANDLE screen, MonthlyBudget& user) {
    double num;
    placeCursor(screen, 6, 46);
    std::cin >> user.housing;
    placeCursor(screen, 8, 46);
    std::cin >> user.utilities;
    placeCursor(screen, 10, 46);
    std::cin >> user.houseExp;
    placeCursor(screen, 12, 46);
    std::cin >> user.transport;
    placeCursor(screen, 14, 46);
    std::cin >> user.food;
    placeCursor(screen, 16, 46);
    std::cin >> user.medical;
    placeCursor(screen, 18, 46);
    std::cin >> user.insurance;
    placeCursor(screen, 20, 46);
    std::cin >> user.entertain;
    placeCursor(screen, 22, 46);
    std::cin >> user.clothing;
    placeCursor(screen, 24, 46);
    std::cin >> user.misc;
}

/*--------------------------------------------------------------------

  displayData() calculates how much the user is over or under the 
  students budget for the month for each category and the students 
  total budget for the entire month.

 --------------------------------------------------------------------*/

void displayData(HANDLE screen, MonthlyBudget budget, MonthlyBudget user) {
    double cHo = (user.housing - budget.housing),
           cU = (user.utilities - budget.utilities),
           cHE = (user.houseExp - budget.houseExp),
           cT = (user.transport - budget.transport),
           cF = (user.food - budget.food),
           cMe = (user.medical - budget.medical),
           cI = (user.insurance - budget.insurance),
           cE = (user.entertain - budget.entertain),
           cC = (user.clothing - budget.clothing),
           cMi = (user.misc - budget.misc),
           monthTotal = (cHo + cU + cHE + cT + cF + cMe + cI + cE + cC + cMi);

    placeCursor(screen, 28, 26);
    std::cout << "Budget Comparison" << std::endl;
    placeCursor(screen, 30, 10);
    std::cout << "Category           Over Budget       Under Budget" << std::endl;
    placeCursor(screen, 31, 10);
    std::cout << "-------------------------------------------------" << std::endl;

    std::cout << std::fixed << std::setprecision(2);
    placeCursor(screen, 32, 10);
    std::cout << "Housing:           ";
    if (cHo >= 0) {
        placeCursor(screen, 32, 29);
        std::cout << "+" << cHo << std::endl;
    } else {
        placeCursor(screen, 32, 47);
        std::cout << cHo << std::endl;
    }

    placeCursor(screen, 34, 10);
    std::cout << "Utilities:         ";
    if (cU >= 0) {
        placeCursor(screen, 34, 29);
        std::cout << "+" << cU << std::endl;
    } else {
        placeCursor(screen, 34, 47);
        std::cout << cU << std::endl;
    }

    placeCursor(screen, 36, 10);
    std::cout << "Household:         ";
    if (cHE >= 0) {
        placeCursor(screen, 36, 29);
        std::cout << "+" << cHE << std::endl;
    } else {
        placeCursor(screen, 36, 47);
        std::cout << cHE << std::endl;
    }

    placeCursor(screen, 38, 10);
    std::cout << "Transportation:    ";
    if (cT >= 0) {
        placeCursor(screen, 38, 29);
        std::cout << "+" << cT << std::endl;
    } else {
        placeCursor(screen, 38, 47);
        std::cout << cT << std::endl;
    }

    placeCursor(screen, 40, 10);
    std::cout << "Food:              ";
    if (cF >= 0) {
        placeCursor(screen, 40, 29);
        std::cout << "+" << cF << std::endl;
    } else {
        placeCursor(screen, 40, 47);
        std::cout << cF << std::endl;
    }

    placeCursor(screen, 42, 10);
    std::cout << "Medical:           ";
    if (cMe >= 0) {
        placeCursor(screen, 42, 29);
        std::cout << "+" << cMe << std::endl;
    } else {
        placeCursor(screen, 42, 47);
        std::cout << cMe << std::endl;
    }

    placeCursor(screen, 44, 10);
    std::cout << "Insurance:         ";
    if (cI >= 0) {
        placeCursor(screen, 44, 29);
        std::cout << "+" << cI << std::endl;
    } else {
        placeCursor(screen, 44, 47);
        std::cout << cI << std::endl;
    }

    placeCursor(screen, 46, 10);
    std::cout << "Entertainment:     ";
    if (cE >= 0) {
        placeCursor(screen, 46, 29);
        std::cout << "+" << cE << std::endl;
    } else {
        placeCursor(screen, 46, 47);
        std::cout << cE << std::endl;
    }

    placeCursor(screen, 48, 10);
    std::cout << "Clothing:          ";
    if (cC >= 0) {
        placeCursor(screen, 48, 29);
        std::cout << "+" << cC << std::endl;
    } else {
        placeCursor(screen, 48, 47);
        std::cout << cC << std::endl;
    }

    placeCursor(screen, 50, 10);
    std::cout << "Miscellaneous:     ";
    if (cMi >= 0) {
        placeCursor(screen, 50, 29);
        std::cout << "+" << cMi << std::endl;
    } else {
        placeCursor(screen, 50, 47);
        std::cout << cMi << std::endl;
    }

    placeCursor(screen, 53, 8);
    if (monthTotal >= 0) 
        std::cout << "You are $" << monthTotal << " over the total budget for the month." << std::endl;
    else
        std::cout << "You are $" << std::abs(monthTotal) << " under the total budget for the month." << std::endl;
}
