//
//  vectorImp.h
//  CSC340HW#8
//  Hung Do
//  ID: 913160981
//  Hung95do@yahoo.com
//  Xcode
//  Created by Hung Do on 5/4/15.
//  Copyright (c) 2015 Hung Do. All rights reserved.
//

#ifndef __CSC340HW_8__vectorImp__
#define __CSC340HW_8__vectorImp__

#include <stdio.h>
#include <iostream>

class theVector {
public:
    //Big 3 along with friend and =
    theVector();
    theVector(const theVector& copy);
    theVector operator = (const theVector& set);
    friend std::ostream& operator<<(std::ostream& out, const theVector v);
    ~theVector();
    //Accessors
    int getCapacity();
    int getSize();
    bool checkEmpty();
    //Mutators
    void erase(int x);
    void eraseRange(int x, int y);
    void insert(int x, int y);
    void pop();
    void push(double num);
    void resize(int newSize);
    void shrink();
private:
    int size;
    double *vectorArray;
    int capSize;
};
#endif /* defined(__CSC340HW_8__vectorImp__) */
