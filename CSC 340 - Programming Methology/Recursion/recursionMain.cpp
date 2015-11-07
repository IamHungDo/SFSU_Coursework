//
//  recursionMain.cpp
//  CSC340Hw#7
//  Hung Do
//  hung95do@yahoo.com
//  ID: 913160981
//  Xcode
//  Created by Hung Do on 4/23/15.
//  Copyright (c) 2015 Hung Do. All rights reserved.
//

#include <iostream>
#include "recursionImp.h"

using namespace std;

int main() {
    bool flag = true;
    theArray a1;
    a1.makeArray();
    int userChoice;
    int findthek;
    
    do {
        cout<<"---------Menu--------"<<endl;
        cout<<"[1] Print using overloaded method"<<endl;
        cout<<"[2] Find largest num"<<endl;
        cout<<"[3] Find kth smallest"<<endl;
        cout<<"[4] Reverse array"<<endl;
        cout<<"[5] Sort from decreasing to increasing"<<endl;
        cout<<"[6] Exit"<<endl;
        cin>>userChoice;
        if(userChoice == 1) {
            cout<<"Your array is: "<<a1<<endl;
            a1.resetIndex();
        }if(userChoice == 2) {
            cout<<a1.largestNumber(a1.getSize()-1)<<endl;
        }if(userChoice == 3) {
            cout<<"Enter your k"<<endl;
            cin>>findthek;
            cout<<"The "<<findthek<<"th smallest number is: "<<a1.findK(findthek, 0, a1.getSize()-1)<<endl;
        }if(userChoice == 4) {
            cout<<"The inverse is: ";
            a1.printReverse(a1.getSize()-1);
            cout<<endl;
        }if(userChoice ==5) {
            a1.quicksortIncrease(0, a1.getSize()-1);
            cout<<"Sorted: "<<a1<<endl;
        }if(userChoice == 6) {
            flag = false;
        }
    } while(flag);
    
    
}
