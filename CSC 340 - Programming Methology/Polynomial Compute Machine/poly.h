
//  poly.h
//  CSC340HW#4
//  Hung Do
//  ID: 913160981
//  Hung95do@yahoo.com
//  Xcode
//  Created by Hung Do on 3/11/15.
//  Copyright (c) 2015 Hung Do. All rights reserved.

#include<iostream>
#ifndef CSC340HW_4_poly_h
#define CSC340HW_4_poly_h
class poly {
public:
    //In order to overload the "put" operator, we must include this friend function.
    friend std::ostream& operator<<(std::ostream& out, poly& polyOut);
    poly();
    //Accessors
    int getHighestDeg() const;
    double getCoe(int power) const;
    //Mutators
    void changeCoeff(int newCoefficient, int deg);
    void scalarMult(int mult);
    void getCoeffInput();
    void printOut();
    poly add(poly g);
    poly operator/(double scalar);
    poly operator-();
private:
    double coeff [10];
    int maxDegree; //Also the length of the array.
};
#endif