//
//  person.h
//  CSC340HW#9P2
//  Hung Do
//  ID: 913160981
//  Hung95do@yahoo.com
//  Xcode
//  Created by Hung Do on 5/17/15.
//  Copyright (c) 2015 Hung Do. All rights reserved.
//


#ifndef __CSC340HW_9P2__Person__
#define __CSC340HW_9P2__Person__

#include <iostream>
#include <string>
#include "dayOfYear.h"

using namespace std;

class Person{
public:
    //equalID() returns true:have the same ID; false: otherwise
    friend bool equalID(const Person & person1, const Person &Person2);//
    ~Person(); //destructor: to release any memory that has been allocated to the object
    Person(); //default constructor: id=-1, name="NA", birthday="1/1/2000"
    Person( int new_id, string new_name, DayOfYear date); //constructor that initializes
    //id to new_id, name to new_name, and birthday to date
    Person(const Person & someone); //copy constructor: construct a new object as a copy of "someone"
    void operator= (const Person &rhs); //assign the object on the right-hand-side to the left-hand-side
    virtual void output() const; //print out a person's info.
    int get_id() const; //return the id of a Person object
    string get_name() const; //return the name of a Person object
    const DayOfYear get_birthday() const; //return the birthday of a Person object
    string getEmail( int i) const; //return the i-th email if exists; o.w: return "NA"
    void set_id(int new_id); //change a person's id to new_id
    void set_name(string new_name); // change a person's name to new_name
    void set_birthday(DayOfYear new_Date); //change a person's birthday to new_date
    void add_email( string the_email); //add the_email to the list
    int  get_num_emails() const;
private:
    int id;
    string name;
    DayOfYear birthday;
    string *emails; //list of email addresses
    int numEmails;
};

void print( const Person& someone);  //print out a person's id and name
bool sameID(const Person& person1, const Person& person2);//true:have the same ID; false: otherwise
//search whether there exists a student on the studentList with id=key
bool searchStudent( Person *studentList, int num_students, int key);

#endif /* defined(__CSC340HW_9P2__Person__) */
