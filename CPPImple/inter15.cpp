#include <iostream>
#include <stack>

using namespace std;

struct LinkNode{
    int val;
    LinkNode *next;

    LinkNode(){}
    LinkNode(int _val):val(_val),next(0){}
};

LinkNode* tailK(LinkNode *head,int k){
    if(head == NULL ) return NULL;

    stack<LinkNode*> st;
    LinkNode *pt = head;

    int size = 0;

    while(pt!=NULL){
        st.push(pt);
        pt = pt->next;
        size++;
    }

    if(size < k) return NULL;

    LinkNode *tgt;
    while(k>0){
        tgt = st.top();
        st.pop();
        k--;
    }

    return tgt;

}

LinkNode* tail(LinkNode *head,int k){
    if(k == 0 ) return NULL;
    LinkNode *pre,*post;

    pre = head;

    while(pre!=NULL && k>0){
        pre = pre->next;
        k--;
    }

    if(k!=0) return NULL;

    post = head;

    while(pre!=NULL){
        pre = pre->next;
        post = post->next;
    }

    return post;
}

int main(){
    LinkNode *n1 = new LinkNode(1);
    LinkNode *n2 = new LinkNode(2);
    LinkNode *n3 = new LinkNode(3);
    LinkNode *n4 = new LinkNode(4);
    LinkNode *n5 = new LinkNode(5);
    LinkNode *n6 = new LinkNode(6);

    n1->next = n2;
    n2->next = n3;
    n3->next = n4;
    n4->next = n5;
    n5->next = n6;

    LinkNode *tgt = tail(n1,3);
    if(tgt!=NULL)
        cout<<tgt->val<<endl;
    else
        cout<<"wrong"<<endl;


    return 0;
}