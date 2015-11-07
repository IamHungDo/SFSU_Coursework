//
//  q2Exception.cpp
//  CSC340HW5P2
//  Hung Do
//  ID: 913160981
//  Hung95do@yahoo.com
//  Xcode
//  Created by Hung Do on 4/6/15.
//  Copyright (c) 2015 Hung Do. All rights reserved.
//

#include <stdio.h>
#include "q2ExceptionHeader.h"

using namespace std;
//This here checks if the user deposits a negetive amount, if yes, then throw the exception.
double Account::deposit(double amount)throw(myException_Negative_Deposit)
{
    myException_Negative_Deposit e;
    if (amount > 0)
        balance += amount;
    else
        throw e;
    return balance;
}
// This here checks if the user over draws or draws a negative value. Throw e if it overdraws or throw i if its a negative.
double Account::withdraw(double amount)throw(myException_OverDraw,myException_Negative_Withdraw)
{
    myException_OverDraw e;
    myException_Negative_Withdraw i;
    if((amount > balance)) {
        throw e;
    } else if(amount<0) {
        throw i;
    } else
        balance -= amount;
    return balance;
}
