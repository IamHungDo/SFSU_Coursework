//
//  MatrixMult.cpp
//  HungDo-MatrixMult
//  ID: 913160981
//  Hung95do@yahoo.com
//  Xcode
//  Created by Hung Do on 2/20/15.
//  Copyright (c) 2015 Hung Do. All rights reserved.

#include <iostream>
#include <vector>
using namespace std;

void multiply_matrices(vector<vector<int>> &matrixA, vector<vector<int>> &matrixB) {
    int tempHolder = 0;
    
//This nested loop here compares matrix A and B to see if both rows and columns match up
//This is appropriate for such dimensions like 2x2 - 2x2.
    
    if((matrixA[0].size()==matrixA.size()&& matrixB.size()==matrixB[0].size())) {
        vector<vector<int>> result(matrixA.size(), vector<int>(matrixB[0].size()));
        for( int x = 0; x<result.size(); x++) {
            for( int i = 0; i<result.size(); i++) {
                for(int e = 0; e<result[0].size(); e++) {
                        tempHolder += (matrixA[x][e] * matrixB [e][i]);
                }
                result[x][i] = tempHolder;
                tempHolder = 0;
            }
        }
        // Print out the result
        cout << "=====matrixResult==========\n";
        for (int i=0; i<result.size(); i++) {
            for (int j=0; j<result[0].size(); j++ ){
                cout << result[i][j] << " ";
            }
            cout << endl;
        }

/*
 This here compares the column of A and the row of B to see if they are the same. If they are not, then the multiplication will not work
 */
    } else if(matrixA[0].size()!=matrixB.size()) {
            cout<<"This cannot compute since the columns in matrixA is not equal to the rows in matrixB"<<endl;
        }
/*
This nested loop here compares matrix A and B to see if both rows are the same and columns are diffferent
This is appropriate for such dimensions like 3x2 - 2x2.
*/
    else if((matrixA[0].size()==matrixB.size()&& matrixA.size()> matrixB[0].size())) {
        vector<vector<int>> result(matrixA.size(), vector<int>(matrixB[0].size()));
        for( int x = 0; x<result.size(); x++) {
            for( int i = 0; i<result[0].size(); i++) {
                for(int e = 0; e<result[0].size(); e++) {
                    tempHolder += (matrixA[x][e] * matrixB [e][i]);
                }
                result[x][i] = tempHolder;
                tempHolder = 0;
                
                
            
        }

        }
        // Print out the result
        cout << "=====matrixResult==========\n";
        for (int i=0; i<result.size(); i++) {
            for (int j=0; j<result[0].size(); j++ ){
                cout << result[i][j] << " ";
            }
            cout << endl;
        }
    }
    
    /*
This nested loop here compares matrix A and B to see if both rows are the same and columns are diffferent
This is appropriate for such dimensions like 2x2 - 2x3.
    */
    else if((matrixA[0].size()==matrixB.size()&& matrixA.size()< matrixB[0].size())) {
        vector<vector<int>> result(matrixA.size(), vector<int>(matrixB[0].size()));
        for( int x = 0; x<result.size(); x++) {
            for( int i = 0; i<=result[0].size(); i++) {
                for(int e = 0; e<result.size(); e++) {
                    tempHolder += (matrixA[x][e] * matrixB [e][i]);
                }
                result[x][i] = tempHolder;
                tempHolder = 0;
                
                
            }
        
        }
        // Print out the result
        cout << "=====matrixResult==========\n";
        for (int i=0; i<result.size(); i++) {
            for (int j=0; j<result[0].size(); j++ ){
                cout << result[i][j] << " ";
            }
            cout << endl;
        }
        
    }
    /*
This compares if column A and row B match up. It also compares if row A and column B matches up.
This is appropiate for such dimensions like 3x2 - 2x3
     */
    else if((matrixA[0].size()==matrixB.size()&& matrixA.size()>matrixA[0].size())) {
        vector<vector<int>> result(matrixA.size(), vector<int>(matrixB[0].size()));
            for( int x = 0; x<result.size(); x++) {
                for( int i = 0; i<result.size(); i++) {
                    for(int e = 0; e<=1; e++) {
                        tempHolder += (matrixA[x][e] * matrixB [e][i]);
                    }
                    result[x][i] = tempHolder;
                    tempHolder = 0;
                    
                    
                }
            
            }
        // Print out the result
        cout << "=====matrixResult==========\n";
        for (int i=0; i<result.size(); i++) {
            for (int j=0; j<result[0].size(); j++ ){
                cout << result[i][j] << " ";
            }
            cout << endl;
        }
    }
/*
This compares if column A and row B match up. It also compares if row A and column B matches up.
This is appropiate for such dimensions like 2x3 - 3x2
*/
     else {
        vector<vector<int>> result(matrixA.size(), vector<int>(matrixB[0].size()));
        for( int x = 0; x<result.size(); x++) {
            for( int i = 0; i<result.size(); i++) {
                for(int e = 0; e<=result[0].size(); e++) {
                    tempHolder += (matrixA[x][e] * matrixB [e][i]);
                }
                result[x][i] = tempHolder;
                tempHolder = 0;
                
                
            }
        }
         // Print out the result
         cout << "=====matrixResult==========\n";
         for (int i=0; i<result.size(); i++) {
             for (int j=0; j<result[0].size(); j++ ){
                 cout << result[i][j] << " ";
             }
             cout << endl;
         }
     }
    
     
    }

int main()
{
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
    cout<<"Enter your set of numbers.....Ex: for (2x2), enter 4 numebers in a sucession of 1 2 3 4. For (3x3), enter 9 numbers in sucession. Etc"<<endl;
    int userInput;
    for (int i=0; i<matrixA.size(); i++) {
        for (int j=0; j<matrixA[0].size(); j++ ){
                cin>>userInput;
                matrixA[i][j] = userInput;
        }
        cout<<endl;
    }
    //Prints matrix A
    cout << "========matrixA==========\n";
    for (int i=0; i<matrixA.size(); i++) {
        for (int j=0; j<matrixA[0].size(); j++ ){
            cout << matrixA[i][j] << " ";
        }
        cout << endl;
    }
    
    // Prompts user for matrix B
    int Brows = 0;
    int Bcols = 0;
    cout<<"How many ROWS would you like in Matrix B?"<<endl;
    cin>>Brows;
    cout<<"How many COLUMNS would you like in Matrix B"<<endl;
    cin>>Bcols;
    //Creates matrix B
    vector<vector<int>> matrixB(Brows, vector<int>(Bcols));
    
    // Sets the array values equal to the user input
    cout<<"Enter your set of numbers.....Ex: for (2x2), enter 4 numebers in a sucession of 1 2 3 4. For (3x3), enter 9 numbers in sucession. Etc"<<endl;
    cout<<endl;
    int BuserInput;
    for (int i=0; i<matrixB.size(); i++) {
        for (int j=0; j<matrixB[0].size(); j++ ){
            cin>>BuserInput;
            matrixB[i][j] = BuserInput;
        }
        cout<<endl;
    }
    //Prints out matrix B
    cout << "========matrixB==========\n";
    for (int i=0; i<matrixB.size(); i++) {
        for (int j=0; j<matrixB[0].size(); j++ ){
            cout << matrixB[i][j] << " ";
        }
        cout << endl;
    }
    
    multiply_matrices(matrixA, matrixB);
    
    

}
