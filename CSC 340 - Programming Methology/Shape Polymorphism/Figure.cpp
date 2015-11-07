//
//  Figure.cpp
//  CSC340HW#9P1
//  Hung Do
//  ID: 913160981
//  Hung95do@yahoo.com
//  Xcode
//  Created by Hung Do on 5/17/15.
//  Copyright (c) 2015 Hung Do. All rights reserved.
//
#include "Figure.h"
#include <iostream>

using namespace std;
//Call figure draw
void Figure::draw() {
    cout<<"Calling Figure::draw()"<<endl;
}
//Call figure erase
void Figure::erase()  {
    cout<<"Calling Figure::erase()"<<endl;
}
//Call figure center
void Figure::center() {
    cout<<"Calling Figure::center()"<<endl;
    draw();
    erase();
}


