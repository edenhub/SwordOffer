#include <iostream>

using namespace std;

const double INF = 1e-9;

int dcmp(double fir,double sec){
    if(fir - sec > INF) return 1;
    else if(fir - sec < -INF) return -1;
    else return 0;
}

double PowerNormal(double b,int e){
    int res=1;
    
    while(0 < e--) res *= b;

    return res;
}

double Power(double base,int exponent){
    if(dcmp(base,0.0) == 0) throw "error";
    if(exponent == 0) throw "wrong";

    double res=1.0;
    if(exponent > 0) res = PowerNormal(base,exponent);
    else{
        exponent = -exponent;
        res = 1.0/Power(base,exponent);
    }

    return res;
}

int main(){
    cout<<Power(2,-2);

    return 0;
}