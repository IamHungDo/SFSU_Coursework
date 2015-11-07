//
//  listMain.cpp
//  CSC340HW#8P2
//  Hung Do
//  ID: 913160981
//  Hung95do@yahoo.com
//  Xcode
//  Created by Hung Do on 5/4/15.
//  Copyright (c) 2015 Hung Do. All rights reserved.
//

#include <iostream>
#include "listImp.h"

using namespace std;

int main()
{
    
    bool flag = true;
    int userChoice;
    List a;
    List b;
    
    do {
        cout<<"---------Menu--------"<<endl;
        cout<<"[1] Insert"<<endl;
        cout<<"[2] Remove"<<endl;
        cout<<"[3] Get size"<<endl;
        cout<<"[4] Check integer"<<endl;
        cout<<"[5] Reverse"<<endl;
        cout<<"[6] Overload print"<<endl;
        cout<<"[7] Exit"<<endl;
        cin>>userChoice;
        if(userChoice == 1) {
            int count;
            int num = 0;
            cout<<"Enter the number of times you would like to insert"<<endl;
            cin>>count;
            for(int x = 1; x<=count; x++) {
                cout<<"Enter a number 1 by 1"<<endl;
                cin>>num;
                a.insert(x, num);
            }
            cout<<"Insert complete. Print in menu to see result"<<endl;
        }if(userChoice == 2) {
            try {
                int index = 0;
                cout<<"What index would you like to remove?"<<endl;
                cin>>index;
                a.remove(index);
                cout<<"Removed"<<endl;
            } catch (ListIndexOutOfRangeException e) {
                cout<<"Index must be greater than 0 and less then the list size"<<endl;
            }
        }if(userChoice == 3) {
            cout<<"The size is: "<<a.getLength()<<endl;
        }if(userChoice == 4) {
            int num;
            cout<<"Enter the number you want to check"<<endl;
            cin>>num;
            cout<<a.checkInt(num)<<endl;;
        }if(userChoice == 5) {
            a.reverse();
            cout<<"Reverse complete. Print in menu to check"<<endl;
        }if(userChoice == 6) {
            cout<<a<<endl;
        }if(userChoice == 7) {
            flag = false;
        }} while (flag);
}