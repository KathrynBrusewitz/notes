/*--------------------------------------------------------------------

  Bellevue Class: PROG 111
  Term/Date:      Fall 10/28/2013
  Instructor:     Robert Main
  
  Project #:      6A
  File Name:      judge-scores.cpp
  Programmer:     Kathryn Brusewitz

 --------------------------------------------------------------------*/

#include <iostream>  // Defines objects and classes used for stream I/O
#include <iomanip>   // Provides functions for manipulating stream I/O 

const int MIN_SCORE = 0;
const int MAX_SCORE = 10;

void getJudgeData(double &);
double calcScore(double, double, double, double, double);
double findHighest(double, double, double, double, double);
double findLowest(double, double, double, double, double);
void printLines();

int main() {

    double score1, score2, score3, score4, score5, finalScore;

    // Display program heading
    printLines();
    std::cout << "\n      Average five judge's scores between 1-10" << std::endl;
    printLines();
    std::cout << std::endl;

    // Enter score for each judge
    getJudgeData(score1);
    getJudgeData(score2);
    getJudgeData(score3);
    getJudgeData(score4);
    getJudgeData(score5);

    // Calculate score average
    finalScore = calcScore(score1, score2, score3, score4, score5);

    // Display the final score
    printLines();
    std::cout << std::endl;
    std::cout << std::showpoint << std::fixed << std::setprecision(1);
    std::cout << "FINAL SCORE: " << finalScore << std::endl << std::endl;
    printLines();
    std::cout << std::endl;

    // Prevent Console Window from closing
    std::cin.ignore(std::cin.rdbuf()->in_avail());
    std::cout << "\nPress only the 'Enter' key to exit program: ";
    std::cin.get();

    return 0;
}

// Asks for and validates the reference variable passed in.

void getJudgeData(double &score) {

    std::cout << "Enter a judge's score: ";
    std::cin >> score;

    while (score < MIN_SCORE || score > MAX_SCORE) {

        if (std::cin.fail()) {              // If failed to extract (a non-number was entered)
            std::cin.clear();               // Reset back to goodbit so we can use ignore()
            std::cin.ignore(1000, '\n');    // Clear out the bad input from the stream
            std::cout << "That's not a number." << std::endl;
        }

        std::cout << "Score must be between " << MIN_SCORE << "-" << MAX_SCORE << ". Re-enter score: ";
        std::cin >> score;
    }

    std::cout << std::endl;
}


// Calculates and returns the average of the 3 scores that remain after dropping
// the highest and lowest scores.

double calcScore(double a, double b, double c, double d, double e) {
    double averageScore, highest, lowest;

    highest = findHighest(a, b, c, d, e);
    lowest = findLowest(a, b, c, d, e);

    averageScore = (a + b + c + d + e - highest - lowest) / 3;

    return averageScore;
}

double findLowest(double a, double b, double c, double d, double e) {
    double lowestScore;

    if (a < b && a < c && a < d && a < e)
        lowestScore = a;
    else if (b < c && b < d && b < e)
        lowestScore = b;
    else if (c < d && c < e)
        lowestScore = c;
    else if (d < e)
        lowestScore = d;
    else
        lowestScore = e;

    return lowestScore;
}

double findHighest(double a, double b, double c, double d, double e) {
    double highestScore;

    if (a > b && a > c && a > d && a > e)
        highestScore = a;
    else if (b > c && b > d && b > e) 
        highestScore = b;
    else if (c > d && c > e)
        highestScore = c;
    else if (d > e)
        highestScore = d;
    else
        highestScore = e;

    return highestScore;
}

void printLines() {
    for (int i = 0; i < 51; i++) 
        std::cout << "=";
    std::cout << std::endl;
}
