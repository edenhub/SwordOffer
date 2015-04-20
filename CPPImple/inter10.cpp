#include <iostream>

using namespace std;

int cnt1(int n){
    int cnt=0,pos=1;

    while(pos){
        if(n & pos) cnt++;
        pos <<= 1;
    }

    return cnt;
}

int cnt2(int n){
    int cnt=0;

    while(n){
        n = n & ( n -1);
        cnt++;
    }

    return cnt;
}

int main(){
    int T;
    while(1){
        cin>>T;

        if(cnt1(T) == cnt2(T) )
             cout<<"right"<<endl;
        else 
            cout<<"wrong"<<endl;
    }

    return 0;
}