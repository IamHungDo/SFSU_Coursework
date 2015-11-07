//  poly.cpp
//  CSC340HW#4
//  Hung Do
//  ID: 913160981
//  Hung95do@yahoo.com
//  Xcode
//  Created by Hung Do on 3/11/15.
//  Copyright (c) 2015 Hung Do. All rights reserved.

#include "poly.h"
#include <iostream>
using namespace std;

poly::poly() {
    
}
//Print out the polynomial. If it sees no degree, it will not print out an X. It will print out a + for all positive values except the biggest degree to avoid having a + in the beginning.
void poly::printOut() {
    for(int i = maxDegree-1; i>=0; i--) {
        if(coeff[i] == 0){
            //if coefficient equals 0, ignore
            continue;
        }
        if(coeff[i]<0) {
            cout<<coeff[i];
            if(i!= 0) {
                cout<<"x^"<<i;
            }
        }else{
            if(coeff[i]==0) {
                cout<<coeff[i];
                if(i!= 0) {
                    cout<<"x^"<<i;
                }
            } else if(coeff[i+1]!=coeff[maxDegree]) {
                cout<<"+";}
            cout<<coeff[i];
            if(i!= 0) {
                cout<<"x^"<<i;
                
            }
        }
        
    }
    cout<<endl;
}
// This method retreieves the polynomial from the user. The elements are the degrees and the last element of the array contains the biggest degree.
void poly::getCoeffInput() {
    int tempcoe = 0;
    cout<<"Enter how long you want your polynomial to be: i.e,3 "<<endl;
    cin>>maxDegree;
    for(int x = 0; x<=maxDegree-1; x++) {
        cout<<"Enter your coefficients one at a time from smallest degree to biggest degree"<<endl;
        cin>>tempcoe;
        coeff[x] = tempcoe;
    }
};

//Retrieves the highest degree
int poly::getHighestDeg() const {
    return maxDegree;
}
//Finds the corresponding coefficient with the degree input and returns it.
double poly::getCoe(int power) const {
    int tempPower = 0;
    for(int x = 0; x<=maxDegree; x++) {
        if(x==power) {
            tempPower = coeff[x];
            break;
        }
    }
    return tempPower;
}
//Asks for the user input of the degree, locates the coefficient and changes it.
void poly::changeCoeff(int newCoefficient, int deg) {
    for(int x= 0; x<=maxDegree;x++) {
        if(x == deg) {
            coeff[x] = newCoefficient;
            break;
        }
    }
}
//Multiplies the whole polynomial by a desired number.
void poly::scalarMult(int mult) {
    for(int x = 0; x<maxDegree; x++) {
        coeff[x] = mult*coeff[x];
    }
}
// Overloaded method where you can add your polynomial to a 2nd polynomial. The results are returned as a third polynomial object.
poly poly::add(poly g) {
    poly third;
    int temp = 0;
    if(maxDegree>g.maxDegree){
        temp = maxDegree;
    }else{
        temp = g.maxDegree;
    }
    third.maxDegree=temp;
    for(int x = 0; x<=temp; x++) {
        third.coeff[x] = coeff[x] + g.coeff[x];
    }
    return third;
}
//Divides the whole polynomial by a number. This works if you divide by a double. This allows the numbers to show its decimal places.
poly poly::operator/(double scalar) {
    poly dividePoly;
    dividePoly.maxDegree = maxDegree;
    for(int x = 0; x<maxDegree; x++) {
        dividePoly.coeff[x] = (coeff[x]/scalar);
    }
    return dividePoly;
}
//Negates a polynomial, which is simply multiplying the whole polynomial by -1
poly poly::operator-() {
    poly negate;
    negate.maxDegree = maxDegree;
    for(int x = 0; x<=maxDegree; x++) {
        negate.coeff[x] = coeff[x]*(-1);
    }
    return negate;
}
//Overloaded method of "put". This requires a special function called friend. You have to have a friend in your implementation file in order to overload the method with a put operator. Hence, you can't do that if you're not friends.
ostream& operator<<(ostream& out, poly& polypoly) {
    for(int i = polypoly.maxDegree-1; i>=0; i--) {
        if(polypoly.coeff[i] == 0){
            //if coefficient equals 0, ignore
            continue;
        }
        if(polypoly.coeff[i]<0) {
            out<<polypoly.coeff[i];
            if(i!= 0) {
                out<<"x^"<<i;
            }
        }else{
            if(polypoly.coeff[i]==0) {
                out<<polypoly.coeff[i];
                if(i!= 0) {
                    out<<"x^"<<i;
                }
            } else if(polypoly.coeff[i+1]!=polypoly.coeff[polypoly.maxDegree]) {
                out<<"+";}
            out<<polypoly.coeff[i];
            if(i!= 0) {
                out<<"x^"<<i;
                
            }
        }
        
    }
    cout<<endl;
    return out;
}