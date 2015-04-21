#include <iostream>

using namespace std;

struct ListNode{
    int val;
    ListNode *next;

    ListNode(int _val):val(_val),next(0){}
};

void dumpList(ListNode *head){
    ListNode *pt=head;

    while(pt!=NULL){
        cout<<pt->val<<" ";
        pt=pt->next;
    }

    cout<<endl;
}

void deleteNode(ListNode *head,ListNode *pos){
    if(pos->next == NULL) throw "error";

    ListNode *next = pos->next;

    pos->val = next->val;
    pos->next = next->next;

    delete next;
}

int main(){
    ListNode *n1=new ListNode(1);
    ListNode *n2 = new ListNode(2);
    ListNode *n3 = new ListNode(3);

    n1->next = n2;
    n2->next = n3;

    dumpList(n1);
    deleteNode(n1,n2);
    dumpList(n1);

    return 0;
}