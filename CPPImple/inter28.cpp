#include <iostream>
#include <algorithm>

using namespace std;

void find(char *str,int pos,int len){
    if(pos == len)
        cout<<str<<endl;
    for(int i=pos;i<len;i++){
        swap(str[pos],str[i]);
        find(str,pos+1,len);
        swap(str[pos],str[i]);
    }
}

void find2(char *str,int pos,int len){
    
}

int main(){
    char str[] = {'a','b','c','\0'};
    find(str,0,3);
}