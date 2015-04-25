#include <iostream>
#include <sstream>
#include <algorithm>

using namespace std;

bool cmp(int fir,int sec){
    ostringstream o1,o2;
    o1<<fir<<sec;
    o2<<sec<<fir;

    return o1.str()<o2.str();
}

string mins(int* data,int len){
    if(len == 0) throw "error";
    if(len == 1) return ""+data[0];

    sort(data,data+len,cmp);
    ostringstream oss;
    for(int i=0;i<len;i++)
        oss<<data[i];

    return oss.str();
}

int main(){
    int data[]={3,32,321};
    string res= mins(data,3);
    cout<<res<<endl;

    return 0;
}