#include <iostream>
#include <set>
#include <map>
#include <sstream>
#include <vector>
#include <stdio.h>
#include <stdlib.h>

using namespace std;


map<char,set<char> > templa;

void init(){
    set<char> t0; t0.insert('0'); 
    set<char> t1;
    t1.insert('0');
    for(char ch='1';ch <= '9';ch++)
        t1.insert(ch);
    set<char> t2;
    t2.insert('0');t2.insert('2');t2.insert('3');t2.insert('5');t2.insert('6');t2.insert('8');t2.insert('9');
    set<char> t3;
    t3.insert('3');t3.insert('6');t3.insert('9');
    set<char> t4;
    t4.insert('4');t4.insert('5');t4.insert('6');t4.insert('7');t4.insert('8');t4.insert('9');t4.insert('0');
    set<char> t5;
    t5.insert('5');t5.insert('6');t5.insert('8');t5.insert('9');t5.insert('0');
    set<char> t6;
    t6.insert('6');t6.insert('9');
    set<char> t7;
    t7.insert('7');t7.insert('8');t7.insert('9');
    set<char> t8;
    t8.insert('8');t8.insert('9');t8.insert('0');
    set<char> t9;
    t9.insert('9');

    templa['0']=t0;templa['1']=t1;templa['2']=t2;templa['3']=t3;templa['4']=t4;templa['5']=t5;templa['6']=t6;templa['7']=t7;templa['8']=t8;templa['9']=t9;
}


void dumpVector(vector<char>& st){
    vector<char>::iterator iter = st.begin();
    while(iter!=st.end())
        cout<<*iter++;
    cout<<endl;
}

void run(vector<char>& st,string& str,int pos){
    if(st.size() == str.size()){
        dumpVector(st);
        return;
    }
}

int main(){

    return 0;
}