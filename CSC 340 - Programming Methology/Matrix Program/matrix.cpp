//  matrix.cpp
//  CSC340HW#4
//  Hung Do
//  ID: 913160981
//  Hung95do@yahoo.com
//  Xcode
//  Created by Hung Do on 3/11/15.
//  Copyright (c) 2015 Hung Do. All rights reserved.

#include "matrix.h"
#include <iostream>
#include <vector>

using namespace std;
//Constructor for the matrix
matrix::matrix(){
    mat.resize(0);
    for(int i = 0; i<mat.size();i++){
        for(int j = 0; i<0;j++){
            mat[i].resize(0);
        }
    }
    
    
}

matrix::matrix(vector<vector<int>> vOV) {
    mat.resize(vOV.size());
    for(int i = 0; i<vOV.size();i++){
        mat[i].resize(vOV.size());
    }

    for(int i = 0; i<mat.size(); i++) {
        for(int x = 0; x<mat.size(); x++) {
            mat[i][x] = vOV[i][x];
        }
    }
}
//Get the value at position i,j
int matrix::getValue(int i, int j) {
    return mat[i][j];
}
//Set the value at position i,j
void matrix::setValue(int i, int j, int v) {
    mat[i][j] = v;
}
//Set the dimension and initialize everything to 0
void matrix::setDimension(int d) {
    dim = d;
    mat.resize(dim);
    for(int i = 0; i<mat.size();i++) {
        mat[i].resize(dim);
    }
    
    for(int i = 0; i<mat.size(); i++) {
        for(int x = 0; x<mat.size(); x++) {
            mat[i][x] = 0;
        }
    }
}
//Replaces the rows of the matrix to be the columns of the matrix by using a temp array
matrix matrix::tranposeMatrix() {
    matrix tempMatrix;
    tempMatrix.setDimension(mat.size());
    for(int x = 0;x<mat.size();x++) {
        for(int i = 0; i<mat.size();i++) {
            tempMatrix.mat[x][i] = mat[i][x] ;
        }
    }
    return tempMatrix;
}
//Using the friend function, we print out the matrix using the put operator. This also requires the method to be overloaded.
ostream& operator<<(ostream& out, matrix& matOut) {
    out << "========matrix==========\n";
    for (int i=0; i<matOut.mat.size(); i++) {
        for (int j=0; j<matOut.mat[0].size(); j++ ){
            out << matOut.mat[i][j] << " ";
        }
        out << endl;
    }
    return out;
}
//Checks the dimensions of both matrices, if they match, go ahead and multiply them. If not, print out the error
matrix matrix::operator*(matrix two) {
    matrix mult;
    if((mat[0].size()==mat.size()&& two.mat.size()==two.mat[0].size())&&mat[0].size()==two.mat.size()) {
            int tempHolder = 0;
            mult.setDimension(mat.size());
                for( int x = 0; x<mult.mat.size(); x++) {
                    for( int i = 0; i<mult.mat.size(); i++) {
                        for(int e = 0; e<mult.mat[0].size(); e++) {
                            tempHolder += (mat[x][e] * two.mat[e][i]);
                }
                mult.mat[x][i] = tempHolder;
                tempHolder = 0;
            }
        }
        
    }else {
        cout<<"This cannot compute since the columns in matrixA is not equal to the rows in matrixB"<<endl;
    }
    return mult;
}
//Simply just multiplies the matrix with a given scalar from the user
matrix matrix::operator*(int scalar) {
    matrix tempMult;
    tempMult.setDimension(mat.size());
    for(int x = 0;x<mat.size();x++) {
        for(int i = 0; i<mat.size();i++) {
            tempMult.mat[x][i] = (mat[x][i]*scalar) ;
        }
    }

    return tempMult;
}
//Checks the dimensions in order to subtract. If yes, then subtract both matrices. If not, then output the error
matrix matrix::operator-(matrix two) {
    matrix tempSub;
    tempSub.setDimension(mat.size());
    if((mat[0].size()==mat.size()&& two.mat.size()==two.mat[0].size())&&mat[0].size()==two.mat.size()) {
    for(int x = 0;x<mat.size();x++) {
        for(int i = 0; i<mat.size();i++) {
            tempSub.mat[x][i] = (mat[x][i]-two.mat[x][i]) ;
        }
    }
    } else {
        cout<<"This cannot compute since the columns in matrixA is not equal to the rows in matrixB. So the return is just all zeros"<<endl;
    }
    return tempSub;
}
