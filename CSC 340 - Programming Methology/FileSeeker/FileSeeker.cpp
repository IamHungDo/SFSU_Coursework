//
//  randomAccess.cpp
//  HungDo-andomAccess
//  ID: 913160981
//  Hung95do@yahoo.com
//  Xcode
//  Created by Hung Do on 2/23/15.
//  Copyright (c) 2015 Hung Do. All rights reserved.

#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <sstream>
using namespace std;

int main() {
    
    int holder;
    vector<int> tempArray;
    // Here is the declaration of the of the file class
    string fileName = "file1.txt";
    fstream file1;
    file1.open(fileName.c_str(), ios::in|ios::out);
    //Check if the file opened or not. If not, then return an error.
    if(file1.fail()) {
        cerr << "Cannot open file" << endl;
    };
    
    //Jump to the 6000th position with this
    file1.seekp(30000, file1.beg);
    //Push in every value after the 6000 position
    while(file1>>holder) {
        if (!file1.eof())
            tempArray.push_back(holder);
    }
    
    file1.clear();
    file1.seekp(30000, file1.beg);
    file1.width(4);
    // Add in the numbers after the 6000th position. We are using stringstream class to convert the integers to a string. After that, we write into the file.
    for (int i=7777; i<7782; i++){
        stringstream ss;
        ss << i;
        string myString = ss.str();
        file1.write(myString.c_str(), 4);
        file1.write("\n", 1);
    }
    
    
    //After adding in 7777-7781, we add in the all the values in the tempArray.
    for (int i=0; i<=tempArray.size(); i++){
        stringstream ss;
        ss << tempArray[i];
        file1.fill('0');
        file1.width(4);
        string myString = ss.str();
        file1 << myString.c_str();
        file1.write("\n", 1);
    }
    
    
    
    file1.close();
    
    
}
