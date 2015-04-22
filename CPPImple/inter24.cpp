#include <iostream>
#include <stack>
#include <string.h>

using namespace std;

struct BinaryTreeNode{
    int val;
    BinaryTreeNode *left,*right;

    BinaryTreeNode(){}
    BinaryTreeNode(int _val):val(_val),left(0),right(0){}
};

void preTravel(BinaryTreeNode* root){
    stack<BinaryTreeNode*> st;
    BinaryTreeNode* pt;

    st.push(root);

    while(!st.empty()){
        pt = st.top(); st.pop();

        cout<<pt->val<<" ";
        if(pt->right!=0) st.push(pt->right);
        if(pt->left!=0) st.push(pt->left);
    }
}

void inTravel(BinaryTreeNode* root){
    stack<BinaryTreeNode*> st;
    BinaryTreeNode* pt,*tmp;

    pt = root;

    while(pt!=0 || !st.empty()){
        while(pt!=0){
            st.push(pt);
            pt = pt->left;
        }

        if(!st.empty()){
            tmp = st.top(); st.pop();
            cout<<tmp->val<<" ";
            pt = tmp->right;
        }
    }
}

void postTravelDS(BinaryTreeNode* root){
    stack<BinaryTreeNode*> stIn,stOut;
    BinaryTreeNode* pt = root;
    stIn.push(root);

    while(!stIn.empty()){
        pt = stIn.top(); stIn.pop();

        stOut.push(pt);

        if(pt->left != 0) stIn.push(pt->left);
        if(pt->right != 0) stIn.push(pt->right);
    }

    while(!stOut.empty()){
        cout<<stOut.top()->val<<" ";
        stOut.pop();
    }
}

struct PostBinTreeNode{
    int val;
    bool isFir;

    PostBinTreeNode *left,*right;

    PostBinTreeNode(){}
    PostBinTreeNode(int _val):val(_val),left(0),right(0){}
};

void postTravel(PostBinTreeNode* root){
    stack<PostBinTreeNode*> st;
    PostBinTreeNode *pt,*tmp;
    pt = root;

    while(!st.empty() || pt!=0){
        while(pt!=0){
            st.push(pt);
            pt = pt->left;
        }

        if(!st.empty()){
            tmp = st.top(); st.pop();

            if(tmp->isFir){
                tmp->isFir = false;
                st.push(tmp);
                pt = tmp->right;
            }else{
                cout<<tmp->val<<" ";
            }
        }

    }
}

bool isPostSeq(PostBinTreeNode* root,int* seq,int size){
    int idx=0;

    stack<PostBinTreeNode*> st;
    PostBinTreeNode *pt,*tmp;
    pt = root;

    while(pt!=0 || !st.empty()){
        while(pt!=0){
            st.push(pt);
            pt = pt->left;
        }

        if(!st.empty()){
            tmp = st.top(); st.pop();
            if(tmp->isFir){
                tmp->isFir = false;
                st.push(tmp);
                pt = tmp->right;
            }else{
                // cout<<tmp->val<<" ";
                // cout<<seq[idx++]<<" : "<<tmp->val<<endl;
                if(seq[idx++] != tmp->val) return false; 
            }
        }
    }

    return true;
}

int main(){
    PostBinTreeNode *n11=new PostBinTreeNode(8);
    PostBinTreeNode *n12=new PostBinTreeNode(18);
    PostBinTreeNode *n13=new PostBinTreeNode(9);
    PostBinTreeNode *n14=new PostBinTreeNode(12);
    PostBinTreeNode *n15=new PostBinTreeNode(2);
    PostBinTreeNode *n16=new PostBinTreeNode(7);

    n11->left = n12; 
    n12->left = n13; n12->right = n14;
    n14->left = n15; n14->right = n16;

    // postTravel(n11);
    cout<<endl;
    int seq[]={9,2,7,12,18,8};
    bool res = isPostSeq(n11,seq,6);
    cout<<res<<endl;


     BinaryTreeNode *n1=new BinaryTreeNode(8);
    BinaryTreeNode *n2=new BinaryTreeNode(18);
    BinaryTreeNode *n3=new BinaryTreeNode(9);
    BinaryTreeNode *n4=new BinaryTreeNode(12);
    BinaryTreeNode *n5=new BinaryTreeNode(2);
    BinaryTreeNode *n6=new BinaryTreeNode(7);

    n1->left = n2; 
    n2->left = n3; n2->right = n4;
    n4->left = n5; n4->right = n6;
    inTravel(n1);
    cout<<endl;
    postTravelDS(n1);
    cout<<endl;

    

    return 0;
}