#include <iostream>
#include <sstream>
#include <vector>

using namespace std;

void dump(vector<int>& res,int n){
    if(n==0) {
        
        vector<int>::iterator iter = res.begin();
        while(iter!=res.end()){
            if(*iter != 0) break;
            iter++;
        }

        if(iter == res.end()) return;
        while(iter!=res.end()) cout<<*iter++;
        cout<<endl;


        return;
    }

    for(int i=0;i<=9;i++){
        res.push_back(i);
        dump(res,n-1);
        res.pop_back();
    }
}

int main(){
    vector<int> res;
    dump(res,10);

    return 0;
}