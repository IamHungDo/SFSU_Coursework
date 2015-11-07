//
//  Problem1.cpp
//  HungDo-CSC340-HW#1
//  ID: 913160981
//  Email: hung95do@yahoo.com
//  Xcode
//  Created by Hung Do on 2/12/15.
//  Copyright (c) 2015 Hung Do. All rights reserved.
//

#include <iostream>
#include <sstream>
#include <vector>
using namespace std;

// This struct will be mainly used to hold all the unique words and their frequencies
struct WordFreq {
    int freq;
    string word;
};

struct MostFreq {
    int mfreq;
    string mword;
};



/*The method getLeastFreqLetter takes the paragraph input and finds out the frequency of each occuring letter. This is done by
 taking each element of the paragraph and subtracting it by 'a', which is value 97 in ASCII. This results in the paragraph element that
 we want to increment by.
 */
void getLeastFreqLetter(string p) {
    int letterFreq [26];
    char tempCharHolder = 'a';
    int index = 1;
    int min = 1;
    vector<char> freqHold;
    
    for(int i = 0;i<26;i++) {
        letterFreq [i] = 0;
    }
    
    for(int i = 0;i<p.length();i++) {
        index = (p[i] - 97);
        if(index<=25&&index>=0) {
            letterFreq[index]++;
        }
        
    }
    //Here I am pushing in any value that equals the min
    for(int o = 0; o<26;o++) {
        if(letterFreq[o]<=min && letterFreq[o]!=0) {
            min = letterFreq [o];
            tempCharHolder = o+97;
            freqHold.push_back(tempCharHolder);
        }
        
    }
    // This prints out all the values with lowest fequencies
    cout<<"The least frequent occuring letter(s) is:"<<endl;
    for(int m = 0; m<freqHold.size(); m++) {
        cout<<freqHold[m]<<":"<<min<<endl;
    }
    
    
    
}



vector<WordFreq> countWordFreq (string p) {
    int index = 0;
    string hold; string hold2;
    vector<WordFreq> wf(100);
    
    //What this does here is remove any punctuation in order to make it easier to locate the whitespaces in between them.
    
    for(int i =0; i<p.length(); i++) {
        if(p[i] == ' '|| p[i] == '.' || p[i] == ',' || p[i] == ';' || p[i] == '?'){
            if(p[i+1] == ' '){
                p.erase(i, 1);
            }
        }
    }
    
    /*This for-loop seeks for any white spaces that occur in the paragraph. Once it is seeked, this will combine all the
     elements together before the white space.
     */
    for(int j = 0;j<p.length();j++) {
        if(p[j] == ' '|| p[j] == '.' || p[j] == ',' || p[j] == ';' || p[j] == '?') {
            wf[index].word = hold;
            wf[index].freq = 1;
            hold.clear();
            index++;
            continue;
        }
        hold += p[j];
    }
    wf.resize(index);
    
    //This here goes through the wf vector, deletes the duplicates and adds to the frequency of the original
    for(int x = 0; x<wf.size();x++) {
        hold2 = wf[x].word;
        for(int j= x+1; j<wf.size();j++) {
            if(hold2 == wf[j].word){
                wf[x].freq++;
                wf.erase(wf.begin()+j);
                j--;
            }
        }
    }
    //Finally, here we print out the contents to the user
    cout<<endl;
    cout<<"The following is the list of words and their frequency: "<<endl;
    for(int q = 0; q<wf.size();q++){
        cout<<wf[q].word<<" "<<wf[q].freq<<endl;
    }
    
    return wf;
}

vector <MostFreq> getMostFreqWord(string p) {
    int index = 0;
    int max= 1;
    string maxWord = "hello";
    string hold; string hold2;
    vector<MostFreq> mf(100);
    string tempStringHolder;
    vector<string> mostHold;
    string temp3;
    int temp4;
    
    //What this does here is remove any punctuation in order to make it easier to locate the whitespaces in between them.
    
    for(int i =0; i<p.length(); i++) {
        if(p[i] == ' '|| p[i] == '.' || p[i] == ',' || p[i] == ';' || p[i] == '?'){
            if(p[i+1] == ' '){
                p.erase(i, 1);
            }
        }
    }
    
    /*This for-loop seeks for any white spaces that occur in the paragraph. Once it is seeked, this will combine all the
     elements together before the white space.
     */
    for(int j = 0;j<p.length();j++) {
        if(p[j] == ' '|| p[j] == '.' || p[j] == ',' || p[j] == ';' || p[j] == '?') {
            mf[index].mword = hold;
            mf[index].mfreq = 1;
            hold.clear();
            index++;
            continue;
        }
        hold += p[j];
    }
    //This nested loop here is important to count up the frequencies of each word. It deletes the duplicates and adds the frequency to the original
    for(int x = 0; x<mf.size();x++) {
        temp3 = mf[x].mword;
        for(int j= x+1; j<mf.size();j++) {
            if(temp3 == mf[j].mword){
                mf[x].mfreq++;
                mf.erase(mf.begin()+j);
                j--;
            }
        }
    }
    
    //This loops through all the struct's frequencies and chooses the highest one. It also prints the word on the side
    cout<<"The most frequent word and its frequency is: "<<endl;
    for( int n = 0; n<mf.size();n++) {
        temp4 = mf[n].mfreq;
        for(int e = n+1; e<mf.size();e++) {
            if(temp4>mf[e].mfreq&&temp4>max) {
                max = mf[n].mfreq;
                maxWord = mf[n].mword;
            }
        }
    }
    cout<<maxWord<<" "<<max<<endl;
    
    
    
    
    
    return mf;
}

int main() {
    string paragraph;
    cout<<"Enter your paragraph\n";
    getline(cin, paragraph);
    cout<<"You have entered the following:"<<paragraph<<"\n";
    for(int x = 0;x<paragraph.length();x++) {
        if(paragraph[x]>='A'&& paragraph[x]<='Z') {
            paragraph[x] = paragraph[x]+32; // This function here changes all the upper case letters into lower case by adding 32 in ASCII.
        }
    }
    getLeastFreqLetter(paragraph);
    countWordFreq(paragraph);
    getMostFreqWord(paragraph);
    
    return 0;
}


