#include <iostream>

using namespace std;

int findBeg(int *data,int len,int tgt){
    int low = 0,high=len-1;

    while(low <= high){
        int mid = (low+high)/2;
        if(tgt == data[mid]){
            if(mid == 0 || data[mid-1] != tgt) return mid;
            high = mid;
        }else if(tgt < data[mid]) high = mid;
        else low = mid;
    }

    return -1;
}

int findEnd(int *data,int len,int tgt){
    int low=0,high=len-1;

    while(low <= high){
        int mid = (low+high)/2;
        if(tgt == data[mid]){
            if(mid == len-1 || data[mid +1] != tgt) return mid;
            low = mid;
        }else if(tgt < data[mid]) high = mid;
        else low = mid; 
    }

    return -1;
}

int main(){
    const int size = 8;
    int  data[]={1,2,3,3,3,3,4,5};
    int left = findBeg(data,size,3);
    int right = findEnd(data,size,3);
    if(left == -1 && right == -1) cout<<0;
    else if(left==-1 || right == -1) cout<<1;
    else cout<<right - left+1;
}