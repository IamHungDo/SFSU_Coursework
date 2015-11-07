//
//  personnel.cpp
//  CSC340HW#9P2
//  Hung Do
//  ID: 913160981
//  Hung95do@yahoo.com
//  Xcode
//  Created by Hung Do on 5/17/15.
//  Copyright (c) 2015 Hung Do. All rights reserved.
//

#include "dayOfYear.h"
#include "person.h"
#include "employee.h"

int main()
{
    double rate = 5;
    double interest = 0.10;
    int duration1 = 5;
    DayOfYear date = DayOfYear(1,1,2015);
    Employee coolguy (500, 500, date);
    coolguy.getUserInput(interest, rate);
    coolguy.changeBaseSal(coolguy.getBaseSal()+(coolguy.getBaseSal()*coolguy.retrieveInterest()));
    coolguy.setDuration(duration1);
    coolguy.set_id(1234);
    coolguy.set_name("coolguy");
    coolguy.add_email("coolguyiscool@mail.sfsu.edu");
    coolguy.set_birthday(date);
    coolguy.getUserInput(interest, rate);
    coolguy.output();
}