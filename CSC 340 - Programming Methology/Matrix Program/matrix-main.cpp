//  matrix-main.cpp
//  CSC340HW#4
//  Hung Do
//  ID: 913160981
//  Hung95do@yahoo.com
//  Xcode
//  Created by Hung Do on 3/11/15.
//  Copyright (c) 2015 Hung Do. All rights reserved.

#include <iostream>
#include <vector>
#include "matrix.h"

using namespace std;

int main() {
    //Prompts the user to input the dimensions of the matrix A
    int rows = 0;
    int cols = 0;
    cout<<"How many ROWS would you like in Matrix A?"<<endl;
    cin>>rows;
    cout<<"How many COLUMNS would you like in Matrix A"<<endl;
    cin>>cols;
    //Creates matrix A
    vector<vector<int>> matrixA(rows, vector<int>(cols));
    
    // Sets the array values equal to the user input
    cout<<"Enter your set of numbers.....Ex: for (2x2), enter 4 numbers in a sucession of 1 2 3 4. For (3x3), enter 9 numbers in sucession. Etc"<<endl;
    int userInput;
    for (int i=0; i<matrixA.size(); i++) {
        for (int j=0; j<matrixA[0].size(); j++ ){
            cin>>userInput;
            matrixA[i][j] = userInput;
        }
        cout<<endl;
    }
 
    matrix m1 = matrixA;

    //Enter a number that corresponds with the menu. This will call each function and manipulate the matrix.
    int userChoice;
    bool flag = true;
    cout<<"Your matrix looks like this:"<<endl;
    cout<<m1;
    do {
        
        cout<<"---------Menu--------"<<endl;
        cout<<"[1] Retrieve value at position i,j"<<endl;
        cout<<"[2] Set a value at position i,j"<<endl;
        cout<<"[3] Transpose"<<endl;
        cout<<"[4] Multiply matrices"<<endl;
        cout<<"[5] Multiply a matrix by a scalar value"<<endl;
        cout<<"[6] Subtract matrices"<<endl;
        cout<<"[7] Print using the overloaded put"<<endl;
        cout<<"[8] Set rows/cols and everything to 0"<<endl;
        cout<<"[9] Exit"<<endl;
        cin>>userChoice;
        //Retrieve is value
        if(userChoice == 1) {
            int userRow;
            int userCol;
            int storePos;
            cout<<"Enter the position of where you want to retrieve the value. First enter the row coordinate"<<endl;
            cin>>userRow;
            cout<<"Now enter the column coordinate"<<endl;
            cin>>userCol;
            storePos = m1.getValue(userRow, userCol);
            cout<<"The value at position ("<<userRow<<","<<userCol<<") is "<<storePos<<endl;
        //Set a value
        }else if (userChoice == 2) {
            int userRow;
            int userCol;
            int changeVal;
            int storePos;
            cout<<"Enter the position of where you want to change the value. First enter the row coordinate"<<endl;
            cin>>userRow;
            cout<<"Now enter the column coordinate"<<endl;
            cin>>userCol;
            cout<<"Enter the your new value"<<endl;
            cin>>changeVal;
            m1.setValue(userRow, userCol, changeVal);
            storePos = m1.getValue(userRow, userCol);
            cout<<"The value at position ("<<userRow<<","<<userCol<<") is now "<<storePos<<endl;
        //Transpose
        }else if (userChoice == 3) {
            matrix tempM = m1.tranposeMatrix();
            cout<<tempM;
        //Multiply by a matrix
        }else if (userChoice == 4) {
            int Brows = 0;
            int Bcols = 0;
            cout<<"How many ROWS would you like in Matrix B?"<<endl;
            cin>>Brows;
            cout<<"How many COLUMNS would you like in Matrix B"<<endl;
            cin>>Bcols;
            vector<vector<int>> matrixB(Brows, vector<int>(Bcols));
            cout<<"Enter your set of numbers for your second matrix.....Ex: for (2x2), enter 4 numbers in a sucession of 1 2 3 4. For (3x3), enter 9 numbers in sucession. Etc"<<endl;
            int userInputB;
            for (int i=0; i<matrixB.size(); i++) {
                for (int j=0; j<matrixB[0].size(); j++ ){
                    cin>>userInputB;
                    matrixB[i][j] = userInputB;
                }
            }
            matrix m2 = matrixB;
            matrix resultMat;
            resultMat.setDimension(Brows);
            resultMat = m1.operator*(m2);
            cout<<resultMat;
            //Multiply by a scalar
        }else if (userChoice == 5) {
            int scalar;
            matrix tempM;
            cout<<"Enter the scalar value in which you want to multiply with"<<endl;
            cin>>scalar;
            tempM = m1.operator*(scalar);
            cout<<tempM;
        //Subtract matrices
        }else if (userChoice ==6) {
            int Crows = 0;
            int Ccols = 0;
            cout<<"How many ROWS would you like in Matrix B?"<<endl;
            cin>>Crows;
            cout<<"How many COLUMNS would you like in Matrix B"<<endl;
            cin>>Ccols;
            vector<vector<int>> matrixB(Crows, vector<int>(Ccols));
            cout<<"Enter your set of numbers for your second matrix.....Ex: for (2x2), enter 4 numbers in a sucession of 1 2 3 4. For (3x3), enter 9 numbers in sucession. Etc"<<endl;
            int userInputC;
            for (int i=0; i<matrixB.size(); i++) {
                for (int j=0; j<matrixB[0].size(); j++ ){
                    cin>>userInputC;
                    matrixB[i][j] = userInputC;
                }
            }
            matrix m3 = matrixB;
            matrix resultMatS;
            resultMatS.setDimension(Crows);
            resultMatS = m1.operator-(m3);
            cout<<resultMatS;
       //Output using ostream
        }else if (userChoice ==7) {
            cout<<"Put operator output: "<<endl;
            cout<<m1;
        //Set dimenions and all zeros
        }else if (userChoice ==8) {
            int setD;
            cout<<"Enter a dimension to set the matrix to. Ex: 2 for 2x2 and 3 for 3x3"<<endl;
            cin>>setD;
            m1.setDimension(setD);
            cout<<"Your dimension has been set and initialized to all zeros"<<endl;
        //Exit
        }else if (userChoice ==9) {
            flag = false;
        }
    } while (flag);
    
    
}
