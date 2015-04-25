#include <iostream>
#include <cmath>
using namespace std;

struct BinaryTreeNode{
    int val,deep;
    BinaryTreeNode *left,*right;

    BinaryTreeNode(){}
    BinaryTreeNode(int _val):val(_val),left(0),right(0){deep=0;}
};

bool isBal=true;
void isBalance(BinaryTreeNode*& root){
    if(root == 0) {
        return;
    }

    isBalance(root->left);  
    isBalance(root->right);

    int leftDeep,rightDeep;
    if(root->left == 0) leftDeep = 0; else leftDeep = root->left->deep;
    if(root->right == 0) rightDeep = 0; else rightDeep = root->right->deep;

    root->deep = (leftDeep > rightDeep) ? leftDeep+1 : rightDeep+1;
    if(abs(leftDeep - rightDeep) > 1) {
        isBal = false;
        return;
    }else{
    }
}

bool isBalance2(BinaryTreeNode* root,int& deep){
    if(root == 0){
        deep = 0;
        return true;
    }

    int leftDeep,rightDeep;
    bool isLeftBal = isBalance2(root->left,leftDeep);
    bool isRightBal = isBalance2(root->right,rightDeep);

    if(isLeftBal && isRightBal){
        if(abs(leftDeep - rightDeep)<=1) {
        deep = (leftDeep > rightDeep) ? leftDeep+1 : rightDeep+1;
        return true;}
    }

    return false;
}

int main(){
    BinaryTreeNode *n1=new BinaryTreeNode(1);
    BinaryTreeNode *n2=new BinaryTreeNode(2);
    BinaryTreeNode *n3=new BinaryTreeNode(3);
    BinaryTreeNode *n4=new BinaryTreeNode(4);
    BinaryTreeNode *n5=new BinaryTreeNode(5);
    BinaryTreeNode *n6=new BinaryTreeNode(6);
    BinaryTreeNode *n7=new BinaryTreeNode(7);

    n1->left = n2; n1->right = n3;
    n2->left = n4; n2->right = n5;
    n4->left = n6;
    n6->left = n7;

    int deep=0;
    bool res = isBalance2(n1,deep);
    cout<<res<<endl;

    return 0;
}