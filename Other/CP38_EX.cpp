#include <iostream>
#include <vector>

using namespace std;

class Node{
public:
    int data;
    Node *left,*right;

    Node():data(0),left(0),right(0){}
    Node(int _data):data(_data),left(0),right(0){}
};

void buildTree(Node *root,vector<int>& stack,int currSum,int targetSum){
    if(root == NULL) return;

    currSum += root->data;
    stack.push_back(root->data);
    if(root->left == NULL && root->right == NULL && currSum == targetSum){
        vector<int>::const_iterator iter = stack.begin();
        while(iter!=stack.end()){
            cout<<*iter++<<" ";
        }
        cout<<endl;
    }

    if(root->left != NULL)
        buildTree(root->left,stack,currSum,targetSum);

    if(root->right != NULL)
        buildTree(root->right,stack,currSum,targetSum);

    stack.pop_back();
}

int main(){
    Node n10(10),n12(12),n5(5),n4(4),n2(2),n7(7);

    n10.left = &n5;
    n10.right = &n12;

    n5.left = &n4;
    n5.right = &n7;

    vector<int> stack;
    int currSum=0,targetSum=22;

    buildTree(&n10,stack,currSum,targetSum);

    return 0;
}