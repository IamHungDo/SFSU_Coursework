//
//  vectorImp.cpp
//  CSC340HW#8
//  Hung Do
//  ID: 913160981
//  Hung95do@yahoo.com
//  Xcode
//  Created by Hung Do on 5/4/15.
//  Copyright (c) 2015 Hung Do. All rights reserved.
//

#include "vectorImp.h"
using namespace std;
//One of the big threes, this is how you declare a dynamic array
theVector::theVector():size(0), capSize(0), vectorArray(NULL) {
    
}
//We need a copy constructor when implementing a dynamic array. Here, we set the copy parameter equal to the object.
theVector::theVector(const theVector& copy) {
    capSize = copy.capSize;
    size = copy.size;
    if(capSize<=0) {
        vectorArray = NULL;
    } else {
        vectorArray = new double[capSize];
        for(int x = 0; x<size;x++) {
            vectorArray[x] = copy.vectorArray[x];
        }
    }
}
//In order to do the assignment operator, we must use the =. We return *this because we have to return the object from the left hand side.
theVector theVector::operator=(const theVector& set) {
    if(capSize>0) {
        delete [] vectorArray;
    }
    capSize = set.capSize;
    size = set.size;
    if(capSize<0) {
        vectorArray = NULL;
    } else {
        
        vectorArray = new double[capSize];
        for(int x = 0; x<size; x++) {
            vectorArray[x] = set.vectorArray[x];
        }
    }
    return *this;
}
//This is the deconstructor. Since we are using C++, we have to delete and memory manage manually.
theVector::~theVector() {
    if(vectorArray!=NULL) {
        delete [] vectorArray;
        vectorArray = NULL;
        size = 0;
        capSize = 0;
    }
}

int theVector::getCapacity() {
    return capSize;
}
int theVector:: getSize() {
    return size;
}
bool theVector::checkEmpty() {
    if(size == 0)
        return true;
    else
        return false;
}
//This checks if the size is greater than the user input in order to be in the array bound. After that, it creates a temp array. The first for loop copys all the way to x. Then the next for loop copies all the values after x.
void theVector::erase(int x) {
    if(size>x) {
        double *temp = NULL;
        temp = new double[capSize];
        for(int o = 0; o<x; o++) {
            temp[x] = vectorArray[x];
        }
        for(int i = x; i<size-1; i++) {
            temp[i] =  vectorArray[i+1];
        }
        delete [] vectorArray;
        vectorArray = temp;
        size--;
        cout<<"Erased element at "<<x<<", print out in menu to see result."<<endl;
    } else {
        cout<<"You cannot erase an element greater than the array size"<<endl;
    }
    
}
//This erases from the first position to the second position.
void theVector:: eraseRange(int x, int y) {
    int combination = x+y;
    double *temp = NULL;
    temp = new double[capSize];
    
    for(int i = 0; i<x;i++) {
        temp[i] = vectorArray[i];
    }
    for(int o = x; o<size-combination;o++) {
        temp[o] = vectorArray[o+y-x];
    }
    delete [] vectorArray;
    vectorArray = temp;
    size = size-combination;
}

//Insert a number into the vector. This is how it works. The x is the positiion and the y is the number. The for loop copies all the way to x then stops. The next index will be the value of y.Then the second foo loop copies all the way from x to size.
void theVector::insert(int x, int y) {
    if(size>x) {
        double *temp = NULL;
        if(capSize>size) {
            temp = new double[capSize];
        } else {
            temp = new double[capSize];
            capSize++;
        }
        for(int o=0; o<x; o++) {
            temp[o] = vectorArray[o];
        }
        temp[x] = y;
        for(int m = x; m<size;m++) {
            temp[m+1] = vectorArray[m];
        }
        delete [] vectorArray;
        vectorArray = temp;
        size++;
        cout<<"You have inserted "<<y<<", print out in menu to see result"<<endl;
    }else {
        cout<<"Please insert within the size range."<<endl;
    }
    
}
//This function removes the element at the end of the line. By creating a temp and not including the last element of the array.
void theVector::pop() {
    double *temp = NULL;
    temp = new double[capSize];
    for(int x = 0; x<size-1;x++) {
        temp[x] = vectorArray[x];
    }
    delete [] vectorArray;
    vectorArray = temp;
    size--;
    
}
void theVector::push(double num) {
    //If the capicity is ever 0, then all we have to do is set the first element to 0 and then add 1 to capsize and size.
    if(capSize == 0) {
        vectorArray = new double [1];
        vectorArray [0] = num;
        capSize++;
        size++;
        //Right here, if the capicity is higher than the size, we push a value at the end of the array and then add 1 to the size of it.
    } else if (capSize>size) {
        vectorArray[size] = num;
        size++;
        //We need a temp here in order to push the number at the end of the array. After we do that, we delete the current array, then set the current array with the temp array/ We add 1 to size and capSize;
    } else {
        double *temp = NULL;
        temp = new double[capSize+1];
        
        for(int x = 0; x<size; x++) {
            temp[x] = vectorArray[x];
        }
        temp[size] = num;
        delete [] vectorArray;
        vectorArray = temp;
        capSize++;
        size++;
    }
    
}
//Double the array if there is not enough room. This function changes the size by doubleing the array along with keeping the same values. If you resize smaller, then you will lose some of the values. In the if statement, the for loop copies all the way to size and then for the elements after the size it sets them to 0. The else statement operates when the resize is smaller than the array size.
void theVector::resize(int newSize) {
    if(newSize>size) {
        double *temp = NULL;
        temp = new double[capSize];
        for(int x = 0; x<size; x++) {
            temp[x] = vectorArray[x];
        }
        for(int i = size; i<newSize;i++) {
            temp[i] = 0;
        }
        delete [] vectorArray;
        vectorArray = temp;
        size = newSize;
        capSize = newSize;
    } else {
        double *temp = NULL;
        temp = new double[capSize];
        for(int x = 0;x<size;x++) {
            temp[x] = vectorArray[x];
        }
        delete [] vectorArray;
        vectorArray = temp;
        size = newSize;
    }
    
}
//We shrink the array if there are any excess capacity by using this.
void theVector::shrink() {
    if(capSize>size) {
        double *temp = NULL;
        temp = new double[size];
        for(int x = 0; x<size; x++) {
            temp[x] = vectorArray[x];
        }
        delete [] vectorArray;
        vectorArray = temp;
        capSize = size;
    }
    
}
//This is an overloaded output operator to print out the array.
ostream& operator<<(ostream& out, const theVector v) {
    out<<"Your vector array is: ";
    for(int x = 0; x<v.size; x++) {
        out<<" "<<v.vectorArray[x];
    }
    return out;
}