#include <iostream>

using namespace std;

pair<int,int> isExit(int* data,int rows,int cols,int tgt){
    pair<int,int> pos(-1,-1);
    int row = rows -1;
    int col = cols - 1;
    int idx_r=0,idx_c=col;

    while(idx_r <= row && idx_c >=0){
        int curr = data[idx_r*rows + idx_c];

        if(curr == tgt){
            pos.first = idx_r+1;
            pos.second = idx_c+1;
            return pos;
        }else if(curr > tgt) idx_c--;
        else idx_r++;
    }

    return pos;
}

int main(){
    int data[]={1,2,8,9,2,4,9,12,4,7,10,13,6,8,11,15};

    pair<int,int> pos = isExit(data,4,4,7);

    cout<<pos.first<<" : "<<pos.second<<endl;

    return 0;
}