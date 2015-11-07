//
//  Header.h
//  CSC340HW5P2
//  Hung Do
//  ID: 913160981
//  Hung95do@yahoo.com
//  Xcode
//  Created by Hung Do on 4/6/15.
//  Copyright (c) 2015 Hung Do. All rights reserved.
//

#ifndef CSC340HW5P2_q2ExceptionHeader_h
#define CSC340HW5P2_q2ExceptionHeader_h

#include <iostream>
#include <stdexcept>

using namespace std;
//This exception here takes care all any negetive deposit value.
class myException_Negative_Deposit: public exception
{
public:
    virtual const char* what() const throw()
    {
        return "You may not deposit a negetive amount of money";
    }
    
};
//This exception here takes care of if the user takes out more than the balance
class myException_OverDraw: public exception
{
public:
    virtual const char* what() const throw()
    {
        return "You may not withdraw more than your balance";
    }
    
};
//This exception here takes care of negetive withdrawals
class myException_Negative_Withdraw: public exception
{
public:
    virtual const char* what() const throw()
    {
        return "You may not withdraw a negative amount";
    }
    
};

class Account{
public:
    //Its better to use inline here since there are few instructions
    inline Account():balance(0) {
    };
    inline Account(double initialDeposit):balance( initialDeposit){
    };
    inline double getBalance(){
        return balance;
    };
    //For these two methods, we throw the exceptions for both of them.
    double deposit(double amount)throw(myException_Negative_Deposit);
    double withdraw(double amount)throw(myException_OverDraw, myException_Negative_Withdraw);
private:
    //Keep check of the current balance
    double balance;
};

#endif
