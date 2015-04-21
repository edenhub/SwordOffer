#include <iostream>

using namespace std;

struct LinkNode{
    int val;
    LinkNode *next;

    LinkNode(){}
    LinkNode(int _val):val(_val),next(0){}
};

LinkNode* merge(LinkNode* link1,LinkNode* link2){
    if(link1 == NULL && link2== NULL) return NULL;
    if(link1 == NULL) return link2;
    (link2 == NULL) return link1; 

    LinkNode* head = new LinkNode(),*tmp1=link1,*tmp2=link2,*tail;
    tail = head;

    while(tmp1!=NULL && tmp2!=NULL){
        if(tmp1->val < tmp2->val){
            tail->next = tmp1;
            tmp1 = tmp1->next;
            tail = tail->next;
        }else{
            tail->next = tmp2;
            tmp2 = tmp2->next;
            tail = tail->next;
        }
    }

    while(tmp1!=NULL){
        tail->next = tmp1;
        tmp1 = tmp1->next;
        tail = tail->next;
    }

    while(tmp2!=NULL){
        tail->next = tmp2;
        tmp2 = tmp2->next;
        tail = tail->next;
    }

    return head->next;

}

void dump(LinkNode* l){
    LinkNode* pt = l;

    while(pt!=NULL){
        cout<<pt->val<<" ";
        pt = pt->next;
    }

    cout<<endl;
}


int main(){
    LinkNode *n1 = new LinkNode(1);
    LinkNode *n2 = new LinkNode(2);
    LinkNode *n3 = new LinkNode(3);
    LinkNode *n4 = new LinkNode(4);
    LinkNode *n5 = new LinkNode(5);
    LinkNode *n6 = new LinkNode(6);

    n1->next = n3;
    n3->next = n5;

    n2->next = n4;
    n4->next = n6;

    dump(n1);
    dump(n2);

    LinkNode* r=merge(n1,n2);
    dump(r);


    return 0;
}