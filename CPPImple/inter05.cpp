#include <iostream>
#include <stack>

using namespace std;

template <class T>
struct Node{
    T data;
    Node *next;

    Node(T _data):data(_data),next(0){}

    Node* nextNode(Node *nextN){
        next = nextN;
        return this;
    }
};

template <class T>
void dumpLink(Node<T> *head){
    stack<T> st;
    Node<T> *pt = head;

    while(pt != NULL){
        st.push(pt->data);
        pt=pt->next;
    }

    while(!st.empty()){
        cout<<st.top()<<" ";
        st.pop();
    }
};

int main(){
    Node<int> *n1 = new Node<int>(2);
    Node<int> *n2 = new Node<int>(5);
    Node<int> *n3 = new Node<int>(9);
    Node<int> *n4 = new Node<int>(4);
    Node<int> *n5 = new Node<int>(3);

    n1->next = n2;
    n2->next = n3;
    n3->next = n4;
    n4->next = n5;

    dumpLink(n1);


    return 0;
}