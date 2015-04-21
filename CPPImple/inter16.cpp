#include <iostream>

using namespace std;

struct LinkNode{
    int val;
    LinkNode *next;

    LinkNode(){}
    LinkNode(int _val):val(_val),next(0){}
};

LinkNode* reverse(LinkNode * head){
    LinkNode* p1,*p2,*p3;

    p1 = head;
    p2 = p1->next;
    p1->next = 0;
aa
    while(p2!=NULL){
        p3 = p2->next;
        p2->next = p1;
        p1 = p2;
        p2 = p3;
    }

    return p1;
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

    n1->next = n2;
    n2->next = n3;
    n3->next = n4;
    n4->next = n5;
    n5->next = n6;

    dump(n1);
    LinkNode *r = reverse(n1);
    dump(r);


    return 0;
}