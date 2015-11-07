//
//  Rectangle.h
//  CSC340HW#9P1
//  Hung Do
//  ID: 913160981
//  Hung95do@yahoo.com
//  Xcode
//  Created by Hung Do on 5/17/15.
//  Copyright (c) 2015 Hung Do. All rights reserved.
//
#ifndef __CSC340HW_9P1__shapeImp__
#define __CSC340HW_9P1__shapeImp__

#include "Figure.h"

//Inherit figure
class Rectangle :  public Figure {
public:
    void draw();
    void erase();
};


#endif /* defined(__CSC340HW_9P1__shapeImp__) */
