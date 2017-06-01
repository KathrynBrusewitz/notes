#ifndef RAINFALL_H
#define RAINFALL_H

/*--------------------------------------------------------------------
  
  Project: Rainfall Statistics
  File: Rainfall.h
  Kathryn Brusewitz

 --------------------------------------------------------------------*/

class Rainfall {
private:
    static const int M = 12;
    double stats[M];
public:
    Rainfall();
    Rainfall(double [M]);
    void getData(double [M]);
    double getInches(int);
    double totalRainfall();
    double averageRainfall();
    int driestMonth();
    int wettestMonth();
};

#endif