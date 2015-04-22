#include <iostream>
#include <stack>

using namespace std;

template<class T>
class Stack{
public:
    stack<T> vals;
    stack<T> mins;

    T min();
    T pop();
    void push(T val);
};

template<class T> T Stack<T>::min(){
    return mins.top();
}
template<class T> T Stack<T>::pop(){
    mins.pop();

    return vals.pop();
}
template<class T> void Stack<T>::push(T val){
    T tmp = min();

    if(vals.empty() || tmp > val)
        mins.push(val);
    else
        mins.push(tmp);

    vals.push(val);
}

int main(){

    return 0;
}