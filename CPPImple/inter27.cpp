#include <iostream>
#include <stack>

using namespace std;

struct BinaryTreeNode{
    int val;
    BinaryTreeNode *left,*right;

    BinaryTreeNode(){}
    BinaryTreeNode(int _val):val(_val),left(0),right(0){}
};

BinaryTreeNode* parse(BinaryTreeNode* root){
    BinaryTreeNode* head = new BinaryTreeNode(),*tail;
    tail = head;

    stack<BinaryTreeNode*> st;
    BinaryTreeNode* pt = root;

    while(pt!=0 || !st.empty()){
        while(pt!=0){
            st.push(pt);
            pt = pt->left;
        }

        if(!st.empty()){
            pt = st.top(); st.pop();

            // cout<<pt->val<<" ";
            tail->right = pt;
            pt->left = tail;
            tail = pt;

            pt = pt->right;
        }
    }
    // cout<<endl;

    return head->right;
}

void dump(BinaryTreeNode* list){
    while(list!=NULL){
        cout<<list->val<<" - ";
        if(list->left!=0)
            cout<<list->left->val<<" - ";
        cout<<"---"<<endl;
        list = list->right;
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

    BinaryTreeNode* root =  parse(n11);
    dump(root);

}