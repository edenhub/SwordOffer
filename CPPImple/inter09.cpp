#include <iostream>

using namespace std;

long long reFun(int n){
    if(n == 0) return 0;
    if(n == 1) return 1;

    return reFun(n-1) + reFun(n-2);
}

long long fun(int n){
    if(n < 0) return -1;
    int fir=0,sec=1,tmp;

    if(n>1){
        for(int i=2;i<=n;i++){
            tmp = fir;
            fir = sec;
            sec = tmp + fir;
        }
        return sec;
    }else if( n == 1) return 1;
    else return 0;
}

int main(){

    const int MAX = 34;
    if(reFun(MAX) == fun(MAX))
        cout<<"right"<<endl;
    else
        cout<<"wrong"<<endl;
    
    return 0;
}