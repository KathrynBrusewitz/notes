/*--------------------------------------------------------------------

  Bellevue Class: PROG 111
  Term/Date:      Fall 10/28/2013
  Instructor:     Robert Main
  
  Project #:      6B
  File Name:      population.cpp
  Programmer:     Kathryn Brusewitz

 --------------------------------------------------------------------*/

#include <iostream>  // Defines objects and classes used for stream I/O
#include <iomanip>   // Defines functions for manipulating stream I/O

const int MIN_YEARS = 1;
const int MIN_POPULATION = 2;
const int MIN_BIRTHS = 0;
const int MIN_DEATHS = 0;

void getPopulationData(int &, int &, int &, int &);
double calcPopulationSize(int, double, double);
void printPopulationResults(int, int, int, int);
void printLines();
void printHeading();
void printResultsHeading();

int main() {
    int startPop, birthsPerYear, deathsPerYear, numYears;

    printHeading();

    getPopulationData(startPop, birthsPerYear, deathsPerYear, numYears);

    printResultsHeading();
    printPopulationResults(startPop, birthsPerYear, deathsPerYear, numYears);
    
    std::cin.ignore(std::cin.rdbuf()->in_avail());
    std::cout << "\nPress only the 'Enter' key to exit program: ";
    std::cin.get();

    return 0;
}

void getPopulationData(int &startSize, int &numBirths, int &numDeaths, int &numYears) {

    do {
        std::cout << "What is the starting size of the population? ";
        std::cin >> startSize;
        if (startSize < MIN_POPULATION)
            std::cout << "Error: Starting size must be at least " << MIN_POPULATION << " people." << std::endl << std::endl;
    } while (startSize < MIN_POPULATION);

    std::cout << std::endl;

    do {
        std::cout << "How many births in one year? ";
        std::cin >> numBirths;
        if (numBirths < MIN_BIRTHS)
            std::cout << "Error: Number of births can't be below " << MIN_BIRTHS << "." << std::endl << std::endl;
    } while (numBirths < MIN_BIRTHS);

    std::cout << std::endl;

    do {
        std::cout << "How many deaths in one year? ";
        std::cin >> numDeaths;
        if (numDeaths < MIN_DEATHS)
            std::cout << "Error: Number of deaths can't be below " << MIN_DEATHS << "." << std::endl << std::endl;
    } while (numDeaths < MIN_DEATHS);

    std::cout << std::endl;

    do {
        std::cout << "How many years do you want displayed? ";
        std::cin >> numYears;
        if (numYears < MIN_YEARS)
            std::cout << "Error: You must enter " << MIN_YEARS << " or more years." << std::endl << std::endl;
    } while (numYears < MIN_YEARS);
}

/*--------------------------------------------------------------------

  Calculates and returns the new population size for a single year.

 --------------------------------------------------------------------*/

double calcPopulationSize(int previousPop, double birthRate, double deathRate) {
    return (previousPop * (1 + birthRate) * (1 - deathRate));
}

/*--------------------------------------------------------------------

  Prints the population for each year. 
  Calls calcPopulationSize() for a single year, displays population, 
  and repeats for the next year, until the loop finishes or the 
  population declined to 1 person or less.

 --------------------------------------------------------------------*/

void printPopulationResults(int startSize, int numBirths, int numDeaths, int numYears) {
    int currentSize = startSize, 
        previousSize;

    double birthRate = (((numBirths * 1000) / startSize) * .001), // # of births per 1000 people
           deathRate = (((numDeaths * 1000) / startSize) * .001); // # of deaths per 1000 people

    bool stopLoop = false;
    int yearCount = 1;

    while (yearCount <= numYears && stopLoop != true) {

        // Set previous population size to current size
        previousSize = currentSize;

        // int currentSize truncates the returned double
        currentSize = calcPopulationSize(previousSize, birthRate, deathRate);

        // Stop printing if currentSize is 1 or less
        if (currentSize == 1) {
            std::cout << "Year " << std::setw(8)  << std::left << yearCount
                            << std::setw(15) << std::left << "1" << "Population has died out." << std::endl
                            << std::setw(58) << std::right << "Can't reproduce with 1 person." << std::endl;
            stopLoop = true;
        } else if (currentSize <= 0) {
            std::cout << "Year " << std::setw(8)  << std::left << yearCount
                            << std::setw(15) << std::left << "0" << "Population has died out." << std::endl;
            stopLoop = true;
        } else {
            std::cout << "Year " << std::setw(8) << std::left << yearCount << currentSize << std::endl;
            yearCount++;
        }
    }
}

void printLines() {
    std::cout << std::endl;
    for (int i = 0; i < 60; i++)
        std::cout << "=";
    std::cout << std::endl << std::endl;
}

void printHeading() {
    printLines();
    std::cout << std::setw(41) << std::right << "POPULATION PROJECTION" << std::endl << std::endl;
    std::cout << std::setw(46) << std::right << "Predicts the size of a population" << std::endl;
    std::cout << std::setw(43) << std::right << "at the end of each year."  << std::endl;
    printLines();
}

void printResultsHeading() {
    std::cout << std::endl << std::endl;
    std::cout << std::setw(40) << std::right << "POPULATION RESULTS" << std::endl << std::endl << std::endl;

    std::cout <<  "End of...    Population     Notes" << std::endl;
    for (int i = 0; i < 60; i++)
        std::cout << "-";
    std::cout << std::endl;
}
