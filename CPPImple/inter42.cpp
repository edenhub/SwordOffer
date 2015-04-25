#include <iostream>
#include <algorithm>
#include <string.h>

using namespace std;

bool isLetter(char ch){
    return ('A'<=ch && ch<='Z') || ('a'<=ch && ch<='z');
}

void reverse(char *str,int len,int s,int e){
    if(s<0 || e > len) return;

    while(s<=e){
        swap(str[s],str[e]);
        s++;
        e--;
    }
}

void transfer2(char *str,int len,int k){
    int size = len-1;
    reverse(str,len,0,size);
    reverse(str,len,0,size-k);
    reverse(str,len,size-k+1,size);
}

void transfer(char *str,int len){
    reverse(str,len,0,len-1);
    int s,e;
    for(int i=0;i<len;i++){
        if(isLetter(str[i])){
            s = i;
            break;
        }
    }

    for(int i=len-1;i>=0;i--){
        if(isLetter(str[i])){
            e = i;
            break;
        }
    }

    if(s>=e) return;
    int next = s;

    for(;next<=e;next++){
        if(!isLetter(str[next]) && isLetter(str[s])){
            reverse(str,len,s,next-1);
            s = next;
        }

        if(!isLetter(str[s]) && isLetter(str[next])){
            s = next;
        }
    }

    reverse(str,len,s,next-1);
}

int main(){
    char str[] = "#Hello , World !";
    int size = strlen(str);
    cout<<str<<endl;
    transfer(str,size);
    cout<<str<<endl;
    char str2[]="abcdefg";
    int size2 = strlen(str2);
    transfer2(str2,size2,2);
    cout<<str2<<endl;   

    return 0;
}