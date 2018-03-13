/*--------------------------------------------------------------------
  
  Project: Rainfall Statistics
  File: Rainfall.cpp
  Kathryn Brusewitz

 --------------------------------------------------------------------*/

#include "Rainfall.h"

Rainfall::Rainfall() {
    for (int i = 0; i < M; i++) {
        stats[i] = 0.0;
    }
}

Rainfall::Rainfall(double a[M]) {
    for (int i = 0; i < M; i++) {
        stats[i] = a[i];
    }
}

void Rainfall::getData(double a[M]) {
    for (int i = 0; i < M; i++) {
        stats[i] = a[i];
    }
}

double Rainfall::getInches(int m) {
    return stats[m-1];
}

double Rainfall::totalRainfall() {
    double total;
    for (int i = 0; i < M; i++) {
        total += stats[i];
    }
    return total;
}

double Rainfall::averageRainfall() {
    return totalRainfall() / M;
}

int Rainfall::driestMonth() {
    double least = stats[0];
    int month = 0;
    for (int i = 1; i < M; i++) { 
        if (stats[i] < least) {
            least = stats[i];
            month = i;
        }
    }
    return month + 1;
}

int Rainfall::wettestMonth() {
    double most = stats[0];
    int month = 0;
    for (int i = 1; i < M; i++) { 
        if (stats[i] > most) {
            most = stats[i];
            month = i;
        }
    }
    return month + 1;
}