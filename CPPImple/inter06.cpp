#include <iostream>

using namespace std;

template<class T>
struct Node{
    T val;
    Node *left,*right;

    Node(){}
    Node(T _val):val(_val),left(0),right(0){}

};

void reBuild(char* preOrder,char* inOrder,int treeLen,Node<char>*& root){
    if(preOrder == NULL  || inOrder == NULL ) return;

    char tmp = *preOrder;
    Node<char> *tmpNode = new Node<char>(tmp);

    if(root == 0)
        root = tmpNode;

    if(treeLen == 1) return;

    char* tmpStart = inOrder;
    char* tmpInOrder = inOrder;
    int tmpCnt = 0;

    while(*preOrder != *tmpStart){
        if(preOrder == NULL || tmpStart == NULL) break;
        tmpCnt++;

        if(tmpCnt > treeLen) break;

        tmpStart++;
    }

    int leftLen = tmpStart - tmpInOrder;
    int rightLen = treeLen - leftLen - 1;

    if(leftLen > 0)
        reBuild(preOrder+1,inOrder,leftLen,root->left);
    
    if(rightLen > 0)
        reBuild(preOrder+leftLen+1,inOrder+leftLen+1,rightLen,root->right);
}

void travel(Node<char>* root){
    if(root != NULL){
        cout<<root->val<<" ";
        travel(root->left);
        travel(root->right);
    }
}


int main(){
    const int TREELEN = 6;
    char preOrder[TREELEN] = {'a','b','d','c','e','f'};
    char inOrder[TREELEN] = {'d','b','a','e','c','f'};

    Node<char> *root = 0;

    reBuild(preOrder,inOrder,TREELEN,root);
    travel(root);
    return 0;
}