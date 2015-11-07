//
//  vectorMain.cpp
//  CSC340HW#8
//  Hung Do
//  ID: 913160981
//  Hung95do@yahoo.com
//  Xcode
//  Created by Hung Do on 5/4/15.
//  Copyright (c) 2015 Hung Do. All rights reserved.
//

#include <iostream>
#include "vectorImp.h"
using namespace std;

int main()
{
    bool flag = true;
    theVector v;
    int userChoice;
    int amount;
    int number = 0;
    cout<<"How many values would you like to push?"<<endl;
    cin>>amount;
    for(int x = 0; x<amount; x++) {
        cout<<"Enter a number 1 by 1"<<endl;
        cin>>number;
        v.push(number);
    }
    cout<<v<<endl;
    do {
        cout<<"---------Menu--------"<<endl;
        cout<<"[1] Overload print"<<endl;
        cout<<"[2] Push more values"<<endl;
        cout<<"[3] Pop value"<<endl;
        cout<<"[4] Get capacity"<<endl;
        cout<<"[5] Get size"<<endl;
        cout<<"[6] Erase an element"<<endl;
        cout<<"[7] Insert an element"<<endl;
        cout<<"[8] Resize"<<endl;
        cout<<"[9] Shrink to fit"<<endl;
        cout<<"[10] Erase an array element"<<endl;
        cout<<"[-1] Exit"<<endl;
        cin>>userChoice;
        if(userChoice == 1) {
            cout<<v<<endl;
        }if(userChoice == 2) {
            int many;
            int num = 0;
            cout<<"How many values would you like to push?"<<endl;
            cin>>many;
            for(int x = 0; x<many; x++) {
                cout<<"Enter a number 1 by 1"<<endl;
                cin>>num;
                v.push(num);
            }
        }if(userChoice == 3) {
            v.pop();
        }if(userChoice == 4) {
            cout<<"The capacity is: "<<v.getCapacity()<<endl;;
        }if(userChoice == 5) {
            cout<<"The size is: "<<v.getSize()<<endl;;
        }if(userChoice == 6) {
            int pos = 0;
            cout<<"Enter the element position"<<endl;
            cin>>pos;
            v.erase(pos);
        }if(userChoice == 7) {
            int num;
            int pos;
            cout<<"What number would you like to insert?"<<endl;
            cin>>num;
            cout<<"What position would you like to insert to?"<<endl;
            cin>>pos;
            v.insert(pos, num);
        }if(userChoice == 8) {
            int newSize;
            cout<<"Enter your new size."<<endl;
            cin>>newSize;
            v.resize(newSize);
        }if(userChoice == 9) {
            v.shrink();
        }if(userChoice == 10) {
            int pos1;
            int pos2;
            cout<<"Enter your first position."<<endl;
            cin>>pos1;
            cout<<"Enter your second position."<<endl;
            cin>>pos2;
            v.eraseRange(pos1, pos2);
        }if(userChoice == -1){
            flag = false;
        }} while (flag);
    
    
    
    
}