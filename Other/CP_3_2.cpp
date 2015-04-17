#include <iostream>
#include <cstring>

using namespace std;

const int L=10;
const char c[10][5] = {
    "",
    "",
    "ABC",
    "DEF",
    "GHI",
    "JKL",
    "MNO",
    "PQRS",
    "TUV",
    "WXYZ",
};

char res[L]={"\0"};

void dfs(const char *number,int& pos,char *res){
    int len = strlen(number);

    if(pos >= len){
        cout<<res<<endl;
        return;
    }

    char ch=number[pos];
    int subLen = strlen(c[ch-'0']);
    for(int i=0;i<subLen;i++){
        res[pos] = c[ch-'0'][i];
        pos++;
        dfs(number,pos,res);
        pos--;
        res[pos]='\0';
    }
}

int main(){
    string number("4242");
    int pos=0;
    dfs(number.c_str(),pos,res);

    return 0;
}