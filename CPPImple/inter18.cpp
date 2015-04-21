#include <iostream>

using namespace std;

struct BinaryTreeNode{
    int val;
    BinaryTreeNode *left,*right;

    BinaryTreeNode(){}
    BinaryTreeNode(int _val):val(_val),left(0),right(0){}
};

bool hasSameStruct(BinaryTreeNode* rootA,BinaryTreeNode* rootB){
    if(rootB ==NULL) return true;
    if(rootA == NULL) return false;

    if(rootA->val != rootB->val) return false;
    else
        return hasSameStruct(rootA->left,rootB->left) && hasSameStruct(rootA->right,rootB->right);
}

bool isSubTree(BinaryTreeNode* rootA,BinaryTreeNode* rootB){
    bool res = false;

    if(rootA!=NULL && rootB!=NULL){
        if(rootA->val == rootB->val)
            res = hasSameStruct(rootA,rootB);

        if(!res)
            res = isSubTree(rootA->left,rootB);

        if(!res)
            res = isSubTree(rootA->right,rootB);
    }
    return res;
}

void traveTree(BinaryTreeNode* root){
    if(root != NULL){
        cout<<root->val<<" ";
        traveTree(root->left);
        traveTree(root->right);
    }
}


int main(){
    BinaryTreeNode *n11=new BinaryTreeNode(8);
    BinaryTreeNode *n12=new BinaryTreeNode(8);
    BinaryTreeNode *n13=new BinaryTreeNode(9);
    BinaryTreeNode *n14=new BinaryTreeNode(2);
    BinaryTreeNode *n15=new BinaryTreeNode(2);
    BinaryTreeNode *n16=new BinaryTreeNode(7);

    n11->left = n12; 
    n12->left = n13; n12->right = n14;
    n14->left = n15; n14->right = n16;

    traveTree(n11);
    cout<<endl;

    BinaryTreeNode *n21=new BinaryTreeNode(8);
    BinaryTreeNode *n22=new BinaryTreeNode(9);
    BinaryTreeNode *n23=new BinaryTreeNode(1);

    n21->left = n22;
    n21->right = n23;
    traveTree(n21);
    cout<<endl;
    bool res = isSubTree(n11,n21);
    cout<<res<<endl;

    return 0;
}