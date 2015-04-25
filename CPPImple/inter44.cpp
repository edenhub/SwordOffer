#include <iostream>
#include <set>

using namespace std;

bool isSeq(int *data,int size){
    set<int> numbers;
    int size_kings;

    for(int i=0;i<size;i++){
        if(data[i] == 0)
            size_kings++;
        else
            numbers.insert(data[i]);
    }

    int size_nums = numbers.size();

    if((size_nums+size_kings) != size) return false;

    if(size_nums == size){
        set<int>::iterator iter = numbers.begin();
        set<int>::reverse_iterator riter = numbers.rbegin();

        if( (*riter - *iter + 1 ) == 5 ) return true;
        else return false;
    }

    if(size_nums < size){
        set<int>::iterator iter = numbers.begin();
        set<int>::reverse_iterator riter = numbers.rbegin();


        if((*riter -*iter+1) >size) return false;
        return true;
    }
}

int main(){
    const int SIZE = 5;
    int data[]={2,4,5,0,0};

    bool res = isSeq(data,SIZE);
    cout<<res<<endl;

    return 0;
}