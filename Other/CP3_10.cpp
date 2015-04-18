#include <iostream>

using namespace std;

class Node{
public:
    int leftLen,rightLen;
    char data;
    Node *left,*right;

    Node():leftLen(0),rightLen(0),data('\0'),left(NULL),right(NULL){}
    Node(char _data):leftLen(0),rightLen(0),data(_data),left(NULL),right(NULL){}
};

void printLevelK(Node *root,int k){
    if(!root || k<0) return;

    if(k==0){
        cout<<root->data<<" ";
    }

    printLevelK(root->left,k-1);
    printLevelK(root->right,k-1);
}

int main(){
     Node n1('A'),n2('B'),n3('C'),n4('D'),n5('E'),n6('F'),n7('G'),n8('H'),n9('I');

    n9.left = &n8;
    n9.right = &n7;

    n8.left = &n6;
    n8.right = &n5;

    n7.left = &n4;
    n7.right = &n3;

    n6.left = &n2;

    n4.right = &n1;

    printLevelK(&n9,2);

    return 0;
}