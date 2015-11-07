//  recursionImp.h
//  CSC340Hw#7
//  Hung Do
//  hung95do@yahoo.com
//  ID: 913160981
//  Xcode
//  Created by Hung Do on 4/23/15.
//  Copyright (c) 2015 Hung Do. All rights reserved.

#include <iostream>
#ifndef __CSC340Hw_7__recursionImp__
#define __CSC340Hw_7__recursionImp__

class theArray {
public:
    //Overload printout
    friend std::ostream& operator<<(std::ostream& out, theArray& arrayOut);
    //Constructor
    theArray();
    int getSize();
    int largestNumber(int Asize);
    int findK(int target, int beg, int end);
    int partitionAl(int firstHalf, int secondHalf);
    int findI(int element);
    void printReverse(int Asize);
    void makeArray();
    void quicksortIncrease(int low, int high);
    void quicksortDecrease(int low, int high);
    void resetIndex();
private:
    int fixedArray [100];
    int size;
    int largestNum = 0;
    int keepIndex = 0;
};

#endif /* defined(__CSC340Hw_7__recursionImp__) */
