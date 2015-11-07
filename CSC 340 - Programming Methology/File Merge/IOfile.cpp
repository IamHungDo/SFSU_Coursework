//
//  IOfile.cpp
//  HungDo-MatrixMult
//  ID: 913160981
//  Hung95do@yahoo.com
//  Xcode
//  Created by Hung Do on 2/21/15.
//  Copyright (c) 2015 Hung Do. All rights reserved.

#include <iostream>
#include <fstream>
#include <string>

using namespace std;
/*This function here takes the user input of the file names as the parameter. Then, the function pushes the strings into the fstreams
 */
string mergeFiles (string x, string y) {
    fstream file1(x);
    fstream file2(y);
    ofstream output("results.txt");
    //Check if the file is found or not
    if(file1.fail()) {
        cerr<<"Cannot open first file"<<endl;
    };
    if(file2.fail()) {
        cerr<<"Cannot open second file"<<endl;
    };
    //Pushes the integers into variables.
    int dataFile1 =1;
    int dataFile2 =2;
    file1 >> dataFile1;
    file2 >> dataFile2;
    //This checks if data1 numbers are less than data2, if they are, then it pushes the number into the output file. Vice versa
    while (!file1.fail() && !file2.fail())
    {
        if (dataFile1 <= dataFile2)
        {
            output << dataFile1 << std::endl;
            file1 >> dataFile1;
        }
        else
        {
            output << dataFile2 << std::endl;
            file2 >> dataFile2;
        }
    }
    
    cout<<"The output file is named: results.txt" <<endl;
    // Closes the files for safety
    file1.close();
    file2.close();
    return x;
}


int main() {
    string name1;
    cout<<"Enter the name of your 1st file :"<<endl;
    cin>>name1;
    string name2;
    cout<<"Enter the name of your 2nd file :"<<endl;
    cin>>name2;
    
    mergeFiles(name1, name2);
    
}