#include <iostream>
#include <bitset>

using namespace std;

struct State{
    bitset<3> s;

    State(){
        s[2]=1;
    }
};

char findOne(string& str){
    int size = str.size();
    if(size == 1) return str[0];
    State tmp[128];

    for(int i=0;i<size;i++){
        char ch = str[i];
        State &ste = tmp[ch];
        if(ste.s[2]){
            ste.s[2] = 0; ste.s[1] = 1; ste.s[0] = 0;
        }else if(ste.s[1]){
            ste.s[2] = 0; ste.s[1] = 0; ste.s[0] = 1;
        }else continue;
    }

    for(int i=0;i<size;i++){
        char ch = str[i];
        State ste = tmp[ch];
        if(ste.s[1]){
            return ch;
        }
    }

    throw "error";

}

int main(){
    string str = "abaccdeff";
    char res = findOne(str);
    cout<<res<<endl;
}