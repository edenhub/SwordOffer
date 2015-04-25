 #include <iostream>
#include <algorithm>

using namespace std;

int maxSub(int* data,int len){
    if(len <0) throw "error";
    int dp[len],max = data[0];

    dp[0] = data[0];
    for(int i=1;i<len;i++){
        if(dp[i-1] <=0) dp[i] = data[i];
        else dp[i] = data[i]+dp[i-1];
        if(max < dp[i]) max = dp[i];
    }


    return max;
}

int maxSub2(int* data,int len){
    int res=data[0],max=data[0];

    for(int i=1;i<len;i++){
        if(res <= 0) res = data[i];
        else res = data[i] + res;

        if(max < res) max = res;
    }

    return max;
}

int main(){
    int data[]={1,-2,3,10,-4,7,2,-5};
    int res = maxSub2(data,8);

    cout<<res<<endl;

    return 0;
}