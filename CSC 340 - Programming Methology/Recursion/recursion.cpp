//  recursionImp.cpp
//  CSC340Hw#7
//  Hung Do
//  hung95do@yahoo.com
//  ID: 913160981
//  Xcode
//  Created by Hung Do on 4/23/15.
//  Copyright (c) 2015 Hung Do. All rights reserved.
//

#include "recursionImp.h"
#include <iostream>

using namespace std;
//Constructor that makes every element equal to 0
theArray::theArray() {
    for(int x =0; x<100;x++) {
        fixedArray[x] = 0;
    }
}
//Get the size of the fixed array
int theArray::getSize() {
    return size;
}
//Ask the user how many numbers would they like to input. Then, ask them to input it one by one.
void theArray::makeArray() {
    int tempStore = 0;
    cout<<"How many integers would you like to enter?"<<endl;
    cin >> size;
    cout<<"Enter your integers one by one"<<endl;
    for(int x = 0; x<=size-1; x++) {
        cin>>tempStore;
        fixedArray[x] = tempStore;
    }
}
//Recursive algorithm that prints the array starting from the last index to the first index.
void theArray::printReverse(int Asize) {
    if(Asize ==0) {
        cout<<fixedArray[0];
    } else {
        cout<<fixedArray[Asize];
        printReverse(Asize-1);
        
    }
}

//Goes through every array index to find the largest number. Largest number is a private variable in the header that will update everytime an index is greater than it. Then, when the size reeaches 0, the algorithm passes the largest value in findI to return its index. After that has happened, the largest number is returned along the index.
int theArray::largestNumber(int Asize) {
    if(Asize == 0) {
        if(fixedArray[0]> largestNum) {
            largestNum = fixedArray[0];
        };
        cout<<"The index of "<<findI(largestNum)<<", contains the largest value ";
    } else {
        if(fixedArray[Asize]>=largestNum) {
            largestNum = fixedArray[Asize];
        }
        largestNumber(Asize-1);
    }
    return largestNum;
}
// This is the algorithm that returns the index of the largest number.
int theArray::findI(int element) {
    int tempStoreI= 0;
    for(int i = 0; i<size;i++) {
        if(fixedArray[i]==element) {
            tempStoreI = i;
        }
    }
    return tempStoreI;
}
// This finds the kth smallest number by asking for the user input of the k value. Next, it  sets the pivot to the partition method in compare values with the pivot. If the values compared to the pivot are smaller, then move them, if not then do nothing.
int theArray::findK(int k, int first, int last) {
    int pivotIndex = partitionAl(first, last);
    if(k < pivotIndex - first+1)
        return findK(k, first, pivotIndex-1);
    else if(k == pivotIndex - first+1)
        return fixedArray[pivotIndex];
    else
        return findK(k-(pivotIndex-first+1), pivotIndex+1, last);
    
    
}

//The method needed to extend the kth smallest number method.
int theArray::partitionAl(int p, int r) {
    int tempSwap;
    int tempSwap2;
    int pivot = fixedArray[r];
    int i = p-1;
    for(int j = p; j<=r-1; j++) {
        if (fixedArray[j] <= pivot) {
            i = i+1;
            tempSwap = fixedArray[i];
            fixedArray[i] = fixedArray[j];
            fixedArray[j] = tempSwap;
        }
    }
    tempSwap2 =  fixedArray[i+1];
    fixedArray[i+1] = fixedArray[r];
    fixedArray[r] = tempSwap2;
    return i+1;
}
//Sort the array from decreasing to increasing through the partition.
void theArray:: quicksortIncrease(int low, int high) {
    if (low < high) {
        int p = partitionAl(low, high);
        quicksortIncrease(low, p - 1);
        quicksortIncrease(p + 1, high);
    }
}

void theArray:: quicksortDecrease(int low, int high) {
    if (low < high) {
        int p = partitionAl(low, high);
        quicksortIncrease(low, p - 1);
        quicksortIncrease(p + 1, high);
    }
}
//Overloaded operator that prints out the array
ostream& operator<<(std::ostream& out, theArray& arrayOut) {
    if(arrayOut.keepIndex == arrayOut.getSize()-1) {
        out<<arrayOut.fixedArray[arrayOut.keepIndex];
    } else {
        out<<arrayOut.fixedArray[arrayOut.keepIndex];
        arrayOut.keepIndex = arrayOut.keepIndex+1;
        out<<arrayOut;
    }
    return out;
}

void theArray::resetIndex() {
    keepIndex = 0;
}
