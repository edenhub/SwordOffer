#include <iostream>

using namespace std;


int maxExpand(char* str,int len,int s,int e){

    while(s>=0 && e<=len && str[s] == str[e]){
        s--;
        e++;
    }

    return e-s-1;
}

int maxPara(char* str,int len){
    int size=0;
    for(int i=0;i<len;i++){
        int left = maxExpand(str,len,i,i);
        if(left>size) size = left;

        int right = maxExpand(str,len,i,i+1);
        if(right>size) size = right;
    }

    return size;
}

int main(){
    char str[]={'a','b','a'};
    cout<<maxPara(str,3);


    return 0;
}