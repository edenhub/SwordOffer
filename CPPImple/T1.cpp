#include <iostream>
#include <set>
#include <memory.h>
#include <algorithm>

using namespace std;

set<string> cnter;

    set<int> fib;
void init(){
fib.insert(1);
fib.insert(2);
fib.insert(3);
fib.insert(5);
fib.insert(8);
fib.insert(13);
fib.insert(21);
fib.insert(34);
fib.insert(55);
fib.insert(89);
}

int flag[128];
void printfLuck(string& str,int s,int e){
    memset(flag,0,sizeof(flag));
    string sub = str.substr(s,e-s+1);

    set<char> inner;
    for(int i=s;i<=e;i++){
        inner.insert(str[i]);
    }

    int sum = inner.size();
    set<int>::iterator iter= fib.find(sum);
    if(iter == fib.end() ) return;
    cnter.insert(sub);

    // for(int i=s;i<=e;i++){
    //     flag[str[i]]++;
    // }

    // for(int i=s;i<=e;i++){
    //     int curr = flag[str[i]];
    //     if(curr == 101) continue;
    //     set<int>::iterator iter = fib.find(curr);
    //     if(iter == fib.end()) break;
    //     cnter.insert(sub);
    //     flag[str[i]] = 101;
    // }
}

int main(){

    string str;
    cin>>str;

    init();
    int size = str.size();
    for(int i=0;i<size;i++){
        for(int j=i;j<size;j++){
            printfLuck(str,i,j);
        }
    }

    // sort(cnter.begin(),cnter.end());
    set<string>::iterator iter = cnter.begin();
    while(iter!=cnter.end()){
        cout<<*iter++<<endl;
    }

    return 0;
}