//  matrix.h
//  CSC340HW#4
//  Hung Do
//  ID: 913160981
//  Hung95do@yahoo.com
//  Xcode
//  Created by Hung Do on 3/11/15.
//  Copyright (c) 2015 Hung Do. All rights reserved.

#include <vector>
#include <iostream>
#ifndef Hw_4Problem2_matrix_h
#define Hw_4Problem2_matrix_h
class matrix {
public:
    friend std::ostream& operator<<(std::ostream& out, matrix& matOut); //Overload the put operator
matrix();
matrix(std::vector<std::vector<int>> vOV);
//Accessors
    int getValue(int i, int j);
//Mutators
    void setDimension(int d);
    void setValue(int i,int j,int v);
    matrix tranposeMatrix();
    matrix operator*(matrix two);
    matrix operator*(int scalar);
    matrix operator-(matrix two);
private:
    int dim;
    std::vector<std::vector<int>> mat;
};
#endif
