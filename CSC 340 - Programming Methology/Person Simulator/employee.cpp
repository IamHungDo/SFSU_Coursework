//
//  employee.cpp
//  CSC340HW#9P2
//  Hung Do
//  ID: 913160981
//  Hung95do@yahoo.com
//  Xcode
//  Created by Hung Do on 5/17/15.
//  Copyright (c) 2015 Hung Do. All rights reserved.
//

#include "employee.h"
#include <iostream>
using namespace std;

//Constructors and the big 3
//Declare values to 0;
Employee:: Employee() {
    currentSal = 0.0;
    baseSal = 0.0;
    duration = 0;
    interestArray = NULL;
}
//Second constructor to take in values from main
Employee::Employee(double baseSalary, double currentSalary, DayOfYear currentDate): Person() {
    baseSal = baseSalary;
    currentSal = currentSalary;
    interestArray = new double[getDuration()];
}
//Operator in which to set objects equal to each other, one of the big threes
void Employee::operator=(const Employee& rhs) {
    
    (*this).Employee::operator=(rhs);
    currentSal = rhs.currentSal;
    baseSal = rhs.currentSal;
    interestArray = rhs.interestArray;
    duration = rhs.duration;
    
    if(duration <= 0) {
        interestArray = NULL;
    } else {
        interestArray = new double[duration];
        for( int i = 0; i<duration; i++) {
            interestArray[i] = rhs.interestArray[i];
        }
    }
}

// Copy constructor needed in big 3.
Employee::Employee(const Employee& std):Person(std) {
    currentSal = std.currentSal;
    baseSal = std.baseSal;
    date = std.date;
    duration = std.duration;
    if(duration<= 0) {
        interestArray = NULL;
    } else {
        interestArray = new double[duration];
        for( int i = 0; i<duration; i++) {
            interestArray[i] = std.interestArray[i];
        }
    }
}

//Destructor needed in big 3
Employee::~Employee(){
    if(interestArray!= NULL) {
        delete [] interestArray;
        interestArray = NULL;
        duration = 0;
    }
}


//Accessor

//Get year duration
int Employee:: getDuration() const {
    return duration;
}
//Get current salary
double Employee:: getCurrentSal() const {
    return currentSal;
}
//Get base salary
double Employee:: getBaseSal() const {
    return baseSal;
}
//Get value at element
double Employee:: getRate(int element) const {
    return interestArray[element];
}
DayOfYear Employee:: getDate() {
    return date;
}
//Retrieve the interest after computing
double Employee:: retrieveInterest() const {
    int temp = placeholder;
    for(int x = 1; x<getDuration(); x++) {
        temp = placeholder*(1+interestArray[x]);
    }
    return temp;
}



//Mutators
//Set year
void Employee:: setDuration(int d) {
    duration = d;
}
//Utilize the array
void Employee::getUserInput(int x, double rate)
{
    if (x>=1 && x<=getDuration()) {
        interestArray[ x-1 ] = rate;
    }
}
//Change current salary
void Employee:: changeCurrentSal(double newCurr) {
    currentSal = newCurr;
}
//Change base salary
void Employee:: changeBaseSal(double newBase) {
    baseSal = newBase;
}
//Change date
void Employee:: changeDate(int d, int m, int y) {
    DayOfYear(d,m,y);
}
//Taken from Yang's student.cpp
ostream& operator<<(ostream& out, const Employee& std)
{
    DayOfYear bday;
    bday = std.get_birthday();
    
    out << "------------------------------\n";
    out << "id=" << std.get_id() <<endl;
    out   << "name=" << std.get_name() << endl;
    out << "birthday=" << bday.get_day();
    out << "-" << bday.get_month();
    out << "-" << bday.get_year() << endl;
    out << "#emails=" <<std.get_num_emails()<<endl;
    out << " 1st email=" << std.getEmail(0)<<endl;
    out << "base salary="<<std.getBaseSal()<<endl;
    out << "current salary="<< std.getCurrentSal() <<endl;
    out << "rate=" << std.retrieveInterest() <<endl;
    out << "year=" << std.getDuration()<<endl;
    out << "------------------------------\n";
    
    return out;
}


void Employee::output() const
{
    DayOfYear bday;
    bday = get_birthday();
    
    cout << "------------------------------\n";
    cout << "id=" << get_id() <<endl;
    cout   << "name=" << get_name() << endl;
    cout << "birthday=" << bday.get_day();
    cout << "-" << bday.get_month();
    cout << "-" << bday.get_year() << endl;
    cout << "#emails=" <<get_num_emails()<<endl;
    cout << " 1st email=" <<getEmail(0)<<endl;
    cout << "base salary="<<getBaseSal()<<endl;
    cout << "current salary="<<getCurrentSal() <<endl;
    cout << "rate=" <<retrieveInterest() <<endl;
    cout << "year=" <<getDuration()<<endl;
    cout << "------------------------------\n";
    
}



