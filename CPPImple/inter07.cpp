#include <iostream>
#include <stack>


using namespace std;

template<class T>
class Queue{
public:
    stack<T> inSt,outSt;

    Queue(){}

    void appendTail(T val);
    T deleteHead();
};

template<class T> void  Queue<T>::appendTail(T val){
    inSt.push(val);
}
template<class T>  T  Queue<T>::deleteHead(){
    if(!outSt.empty()){
        T tmp = outSt.top();
        outSt.pop();

        return tmp;
    }else if(!inSt.empty()){
        while(!inSt.empty()){
            outSt.push(inSt.top());
            inSt.pop();
        }

        return deleteHead();
    }else{
        throw "empty queue";
    }
}

int main(){
    Queue<int> qu;
    qu.appendTail(1);
    qu.appendTail(3);
    cout<<qu.deleteHead();
    cout<<qu.deleteHead();
    qu.deleteHead();

    return 0;
}