//
//  Figure.h
//  CSC340HW#9P1
//  Hung Do
//  ID: 913160981
//  Hung95do@yahoo.com
//  Xcode
//  Created by Hung Do on 5/17/15.
//  Copyright (c) 2015 Hung Do. All rights reserved.
//

#ifndef __CSC340HW_9P1__Figure__
#define __CSC340HW_9P1__Figure__

#include <stdio.h>
//Parent class
class Figure {
public:
    virtual void draw();
    virtual void erase();
    void center();
};

#endif /* defined(__CSC340HW_9P1__Figure__) */
