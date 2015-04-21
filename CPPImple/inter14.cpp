#include <iostream>

using namespace std;

void transfer(int data[],int len){
    if(len = 0 ) throw "error";

    if(len == 1) return;

    int low = 0,high = len-1;
    int tmp = data[low];
    while(low < high){
        while(low < high && (data[high]&1) == 0) high--;
        data[low] = data[high];

        while(low < high && (data[low]&1) == 1) low++;
        data[high] = data[low];
    }

    data[low] = tmp;

}

void dump(int data[],int len){
    for(int i=0;i<len;i++)
        cout<<data[i]<<" ";
    cout<<endl;
}

int main(){
    int data[] = {2,1,3,4};

    transfer(data,4);
    dump(data,4);

    return 0;
}