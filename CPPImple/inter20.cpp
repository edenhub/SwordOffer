#include <iostream>

using namespace std;

void dumpMatrix(int* data,int rows,int cols){
    for(int i=0;i<cols;i++){
        for(int j=0;j<rows;j++)
            cout<<*(data+cols*i+j)<<" ";
        cout<<endl;
    }
}

void dump(int* data,int rows,int cols){
    int n = cols-1;
    int s1 = 0, e1 = n;
    int s2 = 1, e2 = n;
    int s3 = n-1, e3 = 0;
    int s4 = n-1, e4 = 1;

    while(s1<=rows/2){
        for(int i=s1;i<=e1;i++)
            cout<<*(data+cols*s1+i)<<" ";

        for(int i=s2;i<=e2;i++)
            cout<<*(data+cols*i+e1)<<" ";

        for(int i=s3;i>=e3;i--)
            cout<<*(data+cols*e2+i)<<" ";

        for(int i=s4;i>=e4;i--)
            cout<<*(data+cols*i+e3)<<" ";

        s1++; e1--;
        s2++; e2--;
        s3--; e3++;
        s4--; e4++;
    }
}

int main(){
    int data[]={1,2,3,4,
                5,6,7,8,
                9,10,11,12,
                13,14,15,16};

    dump(data,4,4);

    return 0;
}