#include <iostream>

using namespace std;

pair<int,int> findTgt(int *data,int len){
    if(len < 2) throw "error";
    if(len == 2) return pair<int,int>(data[0],data[1]);

    int tmp=data[0];
    for(int i=1;i<len;i++)
        tmp ^= data[i];

    int pos=0;
    while((tmp&1) ==0){
        pos++;
        tmp>>=1;
    }

    int one=0,zero=0;
    int part = 1<<pos;
    for(int i=0;i<len;i++){
        if((data[i]&part)){
            one ^= data[i];
        }else{
            zero ^= data[i];
        }
    }

    return pair<int,int>(one,zero);

}

int main(){
    const int size = 8;
    int data[]={2,4,3,6,3,2,5,5};

    pair<int,int> res = findTgt(data,size);
    cout<<res.first<<" :"<<res.second<<endl;

    return 0;
}