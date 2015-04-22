#include <iostream>

using namespace std;

struct BinaryTreeNode{
    int val;
    BinaryTreeNode *left,*right;

    BinaryTreeNode(){}
    BinaryTreeNode(int _val):val(_val),left(0),right(0){}
};

BinaryTreeNode* mirror(BinaryTreeNode* root){
    if(root!=0){
        BinaryTreeNode* tmp = new BinaryTreeNode(root->val);
        tmp->left = mirror(root->right);
        tmp->right = mirror(root->left);

        return tmp;
    }

    return 0;
}

void mirrorSelf(BinaryTreeNode* root){
    if(root==0) return;
    if(root->left==0 && root->right==0) return;

    BinaryTreeNode* tmp = root->left;
    root->left = root->right;
    root->right = tmp;

    mirrorSelf(root->left);
    mirrorSelf(root->right);
}

void mirrorI(BinaryTreeNode* root){
    if(root==0) return;

    BinaryTreeNode* tmpL = root->left;
    BinaryTreeNode* tmpR = root->right;

    root->left = tmpR;
    root->right = tmpL;

    mirrorI(root->left);
    mirrorI(root->right);
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
    BinaryTreeNode *n12=new BinaryTreeNode(18);
    BinaryTreeNode *n13=new BinaryTreeNode(9);
    BinaryTreeNode *n14=new BinaryTreeNode(2);
    BinaryTreeNode *n15=new BinaryTreeNode(12);
    BinaryTreeNode *n16=new BinaryTreeNode(7);

    n11->left = n12; 
    n12->left = n13; n12->right = n14;
    n14->left = n15; n14->right = n16;

    traveTree(n11);
    cout<<endl;
    BinaryTreeNode* tmp = mirror(n11);
    traveTree(tmp);
    cout<<endl;
    mirrorI(tmp);
    traveTree(tmp);
    cout<<endl;

    return 0;
}