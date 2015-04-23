#include <iostream>
#include <algorithm>

using namespace std;

void shift(int* data,int size,int pos){
    if(pos > size) return;
    int i=pos,child = 2*i+1,t = data[pos];

    while(child<size){
        if(child+1<size && data[child] < data[child+1]) child = child+1;
        if(data[i] < data[child]){
            data[i] = data[child];
            i = child;
            child = i*2+1;
        }else break;
    data[i] = t;
    }

}

void buildHeap(int* data,int size){
    for(int i=(size-1)/2;i>=0;i--)
        shift(data,size,i);
}

void heapSort(int* data,int size){
    buildHeap(data,size);

    for(int n=size-1;n>=0;n--){
        swap(data[n],data[0]);
        shift(data,n,0);
    }
}

void dump(int* data,int size){
    for(int i=0;i<size;i++)
        cout<<data[i]<<" ";
    cout<<endl;
}

int miniK(int* data,int size,int k){
    if(k >= size) return -1;
    int heap[k],idx=0;
    for(;idx<k;idx++)
        heap[idx] = data[idx];

    buildHeap(heap,k);

    for(int i = idx;i<size;i++){
        if(data[i] < heap[0]){
            heap[0] = data[i];
            shift(heap,k,0);
        }
    }

    heapSort(heap,k);
    dump(heap,k);

    return 0;


} 

int main(){
    int data[]={90,1,23,83,2,1,9,2,43,21,8,8};
    make_heap(data,data+12);
    sort_heap(data,data+12);
    dump(data,12);
    //  dump(data,12);
    // heapSort(data,12);
    // dump(data,12);
    // miniK(data,12,3);
    return 0;
}