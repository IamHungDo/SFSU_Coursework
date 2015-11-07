//
//  dayOfYear.cpp
//  CSC340HW#9P2
//  Hung Do
//  ID: 913160981
//  Hung95do@yahoo.com
//  Xcode
//  Created by Hung Do on 5/17/15.
//  Copyright (c) 2015 Hung Do. All rights reserved.
//
#include "dayOfYear.h"
#include <iostream>

using namespace std;

DayOfYear::DayOfYear():day(1),month(1),year(2009)
{
    /*  day  =1;
     month =1;
     year =2009;
     */
}


DayOfYear::DayOfYear(int new_day, int new_month, int new_year)
{
    day  =new_day;
    month =new_month;
    year =new_year;
}

void DayOfYear::output() const
{
    cout << "("<< day << " ,"  << month << " " << year <<")"<<endl;
}

int DayOfYear::get_day()
{
    return day;
}

int DayOfYear::get_month()
{
    return month;
}

int DayOfYear::get_year()
{
    return year;
}

void DayOfYear::set_day(int new_day)
{
    day = new_day;
}

bool equal(DayOfYear date1, DayOfYear date2)
{
    if  ( (date1.day == date2.day) && (date1.month==date2.month) && (date1.year == date2.year) )
        return true;
    else
        return false;
}
