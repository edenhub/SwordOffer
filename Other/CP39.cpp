#include <iostream>

using namespace std;

class Node{
public:
    char data;
    Node *left,*right;

    Node():data('\0'),left(NULL),right(NULL){}
    Node(char _data):data(_data),left(NULL),right(NULL){}
};

inline void ReBuild(char* preOrder,char* inOrder,int treeLen,Node** root){
    if(preOrder == NULL || inOrder == NULL) return;

    Node *tmpRoot = new Node(*preOrder);

    if(*root == NULL){
        *root = tmpRoot;
    }

    if(treeLen == 1) return;

    char *tmpInOrder = inOrder;
    char *tmpLeftEnd = inOrder;
    int tmpLen=0;

    while(*preOrder != *tmpLeftEnd){
        if(preOrder == NULL || tmpLeftEnd == NULL) return;

        tmpLen++;

        if(tmpLen > treeLen) break;
        tmpLeftEnd++;
    }

    int leftTreeLen = (int)(tmpLeftEnd - tmpInOrder);
    int rightTreeLen = treeLen - leftTreeLen -1;

    if(leftTreeLen > 0)
        ReBuild(preOrder+1,inOrder,leftTreeLen,&((*root)->left));
    if(rightTreeLen > 0)
        ReBuild(preOrder+leftTreeLen+1,inOrder+leftTreeLen+1,rightTreeLen,&((*root)->right));

}

void travelTree(Node* root){
    if(root!=NULL){
        cout<<root->data<<" ";
        travelTree(root->left);
        travelTree(root->right);
    }
}

int main(){
    const int TREELEN = 6;
    char preOrder[TREELEN] = {'a','b','d','c','e','f'};
    char inOrder[TREELEN] = {'d','b','a','e','c','f'};

    Node *root = NULL;
    ReBuild(preOrder,inOrder,TREELEN,&root);
    cout<<"end"<<endl;
    travelTree(root);

    return 0;
}