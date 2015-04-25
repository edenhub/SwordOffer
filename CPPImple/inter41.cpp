#include <iostream>

using namespace std;

pair<int,int> findTgt(int *data,int len,int tgt){
    int s=0,e=len-1;
    while(s<=e){
        int curr = data[s]+data[e];
        if(curr == tgt) return pair<int,int>(s,e);
        else if(curr < tgt) s++;
        else e--;
    }

    return pair<int,int>(-1,-1);
}

int sumRange(int s,int e){
    return (s+e)*(e-s+1)/2;
}

void printTgt(int tgt){
    int s=1,e=2,bound=(tgt+1)/2;

    while(e<=bound){
        int curr = sumRange(s,e);
        if(curr == tgt){
            cout<<"From "<<s<<" to "<<e<<endl;
            e++;
        }else if(curr < tgt) e++;
        else s++;
    }
}

int main(){
    int const MAX=7;
    int data[MAX] = {0,1,2,4,7,11,15};

    pair<int,int> res = findTgt(data,MAX,15);
    cout<<res.first<<" "<<res.second<<endl;
    printTgt(3n);

    return 0;
}