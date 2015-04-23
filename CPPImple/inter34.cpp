#include <iostream>

using namespace std;

int min(int u2,int u3,int u5){
    int min = u2;
    if(u2 <= u3) min = u2;
    else min = u3;
    if(min > u5) min = u5;
    return min; 
}

int findK(int k){
    int tmp[k]; tmp[0] = 1;

    int u2=0,u3=0,u5=0;
    int idx=1;
    while(idx<k){
        int curr = min(tmp[u2]*2,tmp[u3]*3,tmp[u5]*5);
        tmp[idx] = curr;

        while(tmp[u2]*2 <= tmp[idx]) ++u2;
        while(tmp[u3]*3 <= tmp[idx]) ++u3;
        while(tmp[u5]*5 <= tmp[idx]) ++u5;

        idx++;
    }

    return tmp[idx-1];
}

int main(){
    int res = findK(4);
    cout<<res<<endl;

    return 0;
}