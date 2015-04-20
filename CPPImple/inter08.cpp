#include <iostream>

using namespace std;

int seqFind(int data[],int len){
    int idx=0;

    int min = data[idx++];
    while(idx<len){
        if(min > data[idx]){
            return data[idx];
        }

        min = data[idx];
        idx++;
    }

    return data[0];
}

int binFind(int data[],int len){
    int low=0,high = len-1;
    int mid = 0;

    while(data[low] > data[high]){
            mid = (high + low) / 2;
            if(data[mid] < data[high])
                low = mid;
            else if(data[low] > data[mid])
                high = mid;
            else{
                return seqFind(data,len);
            }
    }

    return data[low];
}

int main(){
    int data[]={3,4,5,1,2};

    int res = binFind(data,5);
    cout<<res<<endl;

    return 0;
}