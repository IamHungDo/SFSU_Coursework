//
//  q2Main.cpp
//  CSC340HW5P2
//  Hung Do
//  ID: 913160981
//  Hung95do@yahoo.com
//  Xcode
//  Created by Hung Do on 4/6/15.
//  Copyright (c) 2015 Hung Do. All rights reserved.
//

#include <iostream>
#include "q2ExceptionHeader.h"
#include <exception>
using namespace std;

int main () {
    Account a1;
    double des;
    double with;
    int userChoice;
    bool flag = true;
    //I made a userfriendly menu of desposit and withdraw.
    do {
        cout<<endl;
        cout<<"+++++Welcome to your bank+++++"<<endl;
        cout<<"-------Menu--------"<<endl;
        cout<<"Press 1 to deposit"<<endl;
        cout<<"Press 2 to withdraw"<<endl;
        cout<<"Press 3 to Quit"<<endl;
        cout<<"Your balance is : "<<a1.getBalance()<<endl;
        cin>>userChoice;
        
        //If user picks 1, ask for deposit value, then catch the exception if the value is negative.
        if(userChoice == 1) {
            cout<<"How much would you like to deposit?"<<endl;
            cin>>des;
            try{
                a1.deposit(des);
            }catch(myException_Negative_Deposit i) {
                cout<<i.what()<<endl;
            }
        }
        //If user picks 2, ask the withdraw, if overdraw, then catch the overdraw exception e. If withdraw is negative, then catch the negative value.
        if (userChoice ==2) {
            cout<<"How much would you like to withdraw?"<<endl;
            cin>>with;
            try {
                a1.withdraw(with);
            } catch(myException_OverDraw e) {
                cout<<e.what()<<endl;
            } catch(myException_Negative_Withdraw i) {
                cout<<i.what()<<endl;
            }
        }
        //Exit the program if the user is bored.
        if(userChoice == 3) {
            flag = false;
        }
    } while (flag);
    return 0;
}
