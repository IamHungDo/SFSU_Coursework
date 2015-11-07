//
//  employee.h
//  CSC340HW#9P2
//  Hung Do
//  ID: 913160981
//  Hung95do@yahoo.com
//  Xcode
//  Created by Hung Do on 5/17/15.
//  Copyright (c) 2015 Hung Do. All rights reserved.
//
#ifndef __CSC340HW_9P2__Employee__
#define __CSC340HW_9P2__Employee__

#include <stdio.h>
#include "person.h"
#include "dayOfYear.h"

class Employee: public Person {
public:
    //Constuctors and the big 3
    Employee();
    Employee(double baseSalary, double currentSalary, DayOfYear currentDate);
    void operator=(const Employee& rhs);
    Employee(const Employee& std);
    ~Employee();
    
    //Accessor
    int getDuration() const;
    double getCurrentSal() const;
    double getBaseSal() const;
    double getRate(int element) const;
    DayOfYear getDate();
    double retrieveInterest() const;
    
    //Mutator
    void setDuration(int d);
    void getUserInput(int times, double rate);
    void changeCurrentSal(double newCurr);
    void changeBaseSal(double newBase);
    void changeDate(int d, int m, int y);
    
    //Friend
    friend ostream & operator <<( ostream & out, const Employee&std);
    virtual void output() const;
private:
    int duration;
    DayOfYear date;
    double currentSal;
    double baseSal;
    double *interestArray;
    int placeholder = 1;
};

#endif /* defined(__CSC340HW_9P2__Employee__) */
