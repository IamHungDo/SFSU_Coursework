//
//  Problem2.cpp
//  HungDo-CSC340-HW#1
//  ID: 913160981
//  Email: hung95do@yahoo.com
//  Xcode
//  Created by Hung Do on 2/14/15.
//  Copyright (c) 2015 Hung Do. All rights reserved.
//



#include <iostream>
#include "vector"

using namespace std;
//The readData method takes the vector address and pushes it into a vector.
void readData(vector<int> &myVec) {
    int userInput = 0;
    cout<<"Enter your set of numbers:  Ex: 1 9 2 3 4"<<endl;
    
    
    while(cin.peek() != '\n'){
        cin>>userInput;
        myVec.push_back(userInput);
    }
    
}
//This method takes a vector as the parameter and prints out what the user input.
void printVector (vector <int> &myVec) {
    for(int i = 0; i<myVec.size(); i++) {
        cout<<myVec[i]<<" ";
    }
}
//This method is called Selection Sort, in which it interates through the unsorted array or vector to sort it in order.
void selectionSort(vector <int> &myVec) {
    int x,j;
    int min;
    for (j = 0; j < myVec.size()-1; j++) {
        min = j;
        for ( x = j+1; x < myVec.size(); x++) {
            if (myVec[x] < myVec[min]) {
                min = x;
            }
        }
        
        if(min != j) {
            swap(myVec[j], myVec[min]);
        }
        
    }
}



int main() {
    
    vector<int> myVec;
    
    readData(myVec);
    
    printVector(myVec);
    
    cout<<endl;
    
    selectionSort(myVec);
    
    printVector(myVec);
    
    return 0;
    
}
