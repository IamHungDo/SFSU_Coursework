
//  listExcept.h
//  CSC340HW#8P2
//  Hung Do
//  ID: 913160981
//  Hung95do@yahoo.com
//  Xcode
//  Created by Hung Do on 5/4/15.
//  Copyright (c) 2015 Hung Do. All rights reserved.
//

#ifndef _LIST_EXCEPTIONS_H
#define _LIST_EXCEPTIONS_H

#include <stdexcept>
#include <string>

using namespace std;

class ListIndexOutOfRangeException : public out_of_range
{
public:
    
    /**/
    ListIndexOutOfRangeException(const string & message = "")
    : out_of_range(message.c_str())
    { }  // end constructor
    /**/
    //virtual const char* what() const throw()
    //{return "list: out of range";}
}; // end ListIndexOutOfRangeException


class ListException : public logic_error
{
public:
    
    /**/
    ListException(const string & message = "")
    : logic_error(message.c_str())
    { }  // end constructor
    /**/
    // virtual const char* what() const throw()
    //{return "list: logic error";}  //list is full
}; // end ListException

#endif
