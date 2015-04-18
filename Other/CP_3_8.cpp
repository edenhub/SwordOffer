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

int maxLen=0;

inline void buildTree(Node *root){
    if(root == NULL) return;

    if(root->left == NULL){
        root->leftLen = 0;
    }else{
        buildTree(root->left);
    }

    if(root->right == NULL){
        root->rightLen = 0;
    }else{
        buildTree(root->right);
    }

    if(root->left != NULL){
        int tmpMax=0;
        if(root->left->leftLen > root->left->rightLen)
            tmpMax = root->left->leftLen;
        else
            tmpMax = root->left->rightLen;

        root->leftLen = tmpMax+1;
    }

    if(root->right != NULL){
        int tmpMax=0;
        if(root->right->leftLen > root->right->rightLen)
            tmpMax = root->right->leftLen;
        else
            tmpMax = root->right->rightLen;

        root->rightLen = tmpMax+1;
    }

    if(root->leftLen + root->rightLen > maxLen)
        maxLen = root->leftLen+root->rightLen;
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

    buildTree(&n9);

    cout<<maxLen<<endl;

    return 0;
}