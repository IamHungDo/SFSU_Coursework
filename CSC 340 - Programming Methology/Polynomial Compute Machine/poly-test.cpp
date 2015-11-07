//  poly-test.cpp
//  CSC340HW#4
//  Hung Do
//  ID: 913160981
//  Hung95do@yahoo.com
//  Xcode
//  Created by Hung Do on 3/11/15.
//  Copyright (c) 2015 Hung Do. All rights reserved.

#include <iostream>
#include "poly.h"
using namespace std;

/*This is a test file, it will ask the user to input the polynomial of their choice. This will then create
 an object to store the polynomial. Then it prompt the user to enter a number that coressponds to what they want to do.*/

int main() {
    poly p;
    p.getCoeffInput();
    int userChoice;
    bool flag = true;
    cout<<"Your polynomial is ";
    p.printOut();
    cout<<endl;
    do {
        cout<<"---------Menu--------"<<endl;
        cout<<"[1] Get highest degree"<<endl;
        cout<<"[2] Get coefficient"<<endl;
        cout<<"[3] Change coefficient"<<endl;
        cout<<"[4] Multiply polynomial by a scalar"<<endl;
        cout<<"[5] Add two polynomials"<<endl;
        cout<<"[6] Divide the polynomial by a scalar"<<endl;
        cout<<"[7] Negate the polynomial"<<endl;
        cout<<"[8] Print using the overloaded put"<<endl;
        cout<<"[9] Print out the polynomial"<<endl;
        cout<<"[10] Exit"<<endl;
        cin>>userChoice;
        
        if(userChoice == 1) {
            int temp = p.getHighestDeg();
            cout<<"Your highest degree is "<<temp<<endl;
            
        }else if (userChoice == 2) {
            int userPower = 0;
            int temp1 = p.getCoe(userPower);
            cout<<"What coefficient would you like to be returned? Enter the degree of it"<<endl;
            cin>>userPower;
            temp1 = p.getCoe(userPower);
            cout<<"The returned coefficient is "<<temp1<<endl;
            
        }else if (userChoice == 3) {
            int changeNum;
            int changePower;
            cout<<"Which coefficient would you like to change? Enter the corresponding degree"<<endl;
            cin>>changePower;
            cout<<"What would you like to change the coefficient to?"<<endl;
            cin>>changeNum;
            p.changeCoeff(changeNum, changePower);
            cout<<"Your updated polynomial is: ";
            p.printOut();
        }else if (userChoice == 4) {
            int multi =0;
            cout<<"What would you like to multiply your coefficients with? Enter a number"<<endl;
            cin>>multi;
            p.scalarMult(multi);
            cout<<"Your new updated polynomial is: ";
            p.printOut();
        }else if (userChoice == 5) {
            poly g;
            cout<<"Now enter your 2nd polynomial. ";
            g.getCoeffInput();
            cout<<"Your second polynomial is:" <<endl;
            g.printOut();
            cout<<"Your added result is ";
            poly pgadd = p.add(g);
            pgadd.printOut();
        }else if (userChoice ==6) {
            double divide;
            cout<<"What would you like to divide your polynomial with?"<<endl;
            cin>>divide;
            poly pgdiv = p.operator/(divide);
            pgdiv.printOut();
        }else if (userChoice ==7) {
            poly pgn = p.operator-();
            pgn.printOut();
        }else if (userChoice ==8) {
            cout<<"Put operator output: ";
            cout<<p;
        }else if (userChoice == 9) {
            p.printOut();
        }else if (userChoice == 10) {
            flag = false;
        }
        
    } while (flag);
    
}
