#include <iostream>

using namespace std;

int transf(char *str,int len){
    char *ch=str;

    int cnt=0,size=0;
    while(*ch != '\0'){
        if(*ch == ' ') cnt++;
        ch++;
        size++;
    }

    size += 2*cnt;
    if(size>len) return 1;

    ch--;
    str[size--]='\0';
    while(ch != str){
        if(*ch != ' ')
            str[size] = *ch;
        else{
            str[size] = '0';
            str[--size] = '2';
            str[--size] = '%';
        }

        --size;
        --ch;
    }

    return 0;

}

int main(){
    char str[30]={'w','e',' ','a','r','e',' ','h','a','p','p','y','\0'};
    int res = transf(str,30);
    cout<<res<<endl;
    if(res ==0) cout<<str<<endl;
    return 0;
}