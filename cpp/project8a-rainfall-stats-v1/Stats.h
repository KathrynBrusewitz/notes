#pragma once
#ifndef STATS_H
#define STATS_H

/*--------------------------------------------------------------------

  Bellevue Class: PROG 111
  Term/Date:      Fall 11/21/2013
  Instructor:     Robert Main
  
  Project #:      8
  File Name:      Stats.h
  Programmer:     Kathryn Brusewitz

  Stats stores values to be analyzed. This list of values can be used 
  to find and return the total and average and the index of the 
  lowest and highest value.

 --------------------------------------------------------------------*/

class Stats {
private:
	static const int ARRAY_SIZE = 30;

	double statArray[ARRAY_SIZE];
	int	index;

public:
	Stats(void);

	bool storeValue(double);
	double getValue(int) const;
	double total() const;
	double average() const;
	int	highest() const;
	int	lowest() const;
};

#endif
