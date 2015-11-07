//
//  shapeMain.cpp
//  CSC340HW#9P1
//  Hung Do
//  ID: 913160981
//  Hung95do@yahoo.com
//  Xcode
//  Created by Hung Do on 5/17/15.
//  Copyright (c) 2015 Hung Do. All rights reserved.
//

#include <iostream>

#include "Figure.h"

#include "Rectangle.h"

#include "Triangle.h"

using std::cout;

int main()

{
    
    Triangle tri;
    
    tri.draw();
    
    
    
    cout << "\nDerived class Triangle object calling" << " center().\n";
    
    tri.center();
    
    
    
    Rectangle rect;
    
    rect.draw();
    
    cout << "\nDerived class Rectangle object calling" << " center().\n";
    
    rect.center();
    
    return 0;
    
}
