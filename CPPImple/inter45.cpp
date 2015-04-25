#include <iostream>

using namespace std;

struct Node{
    int val;
    Node *next;

    Node():val(-1),next(0){};
    Node(int _val):val(_val),next(0){}
};

void build(Node*& node,int n){
    if(n<0) return;
    Node *tail;
    node->val = 0;
    tail=node;
    for(int i=1;i<n;i++){
        Node* nNode = new Node(i);
        tail->next = nNode;
        tail = nNode;
    }

    tail->next = node;
}
void dumpNode(Node* node){
    Node *tail = node->next;
    cout<<node->val<<" ";
    while(tail != node){
        cout<<tail->val<<" ";
        tail = tail->next;
    }
    cout<<endl;
}
int findM(Node*& node,int m,int n){
    if(n == 1) return node->val;
    int pos=0;
    while(++pos < m-1){
        node = node->next;
    }

    Node *next = node->next;
    node->next = next->next;
    delete next;
    return findM(node,m,n-1);
}



int main(){
    const int n=5;
    Node* node = new Node();
    build(node,n);
    int res = findM(node,3,n);
    cout<<res<<endl;

    return 0;
}