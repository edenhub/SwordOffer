#include <iostream>

using namespace std;

int findOnce(int* line,int size){
    if(size == 0) throw "error";
    int curr,sum;

    curr = line[0];
    sum = 1;
    for(int i=1;i<size;i++){
        if(sum == 0) {
            curr = line[i];
            sum==1;
        }else if(curr != line[i]) sum--;
        else{
            curr = line[i];
            sum++;
        }
    }

    return curr;
}

int main(){
    int line[]={1,2,3,2,2,2,5,4,2};
    int res = findOnce(line,9);
    cout<<res<<endl;

    return 0;
}