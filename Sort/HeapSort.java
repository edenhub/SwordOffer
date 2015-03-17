import java.util.*;

//if start from 0,then node i may have left child 2*i+1 and right child 2*i+2
//and node i have parent (i-1)/2 (down)
//and the size = length - 1

//if start from 1,then node i may have left child 2*1 and right child 2*i+1
//and node i have parent i/2 (down)
//and the size = length

public class HeapSort<T>{
	private Comparator<T> comparator;

	public HeapSort(Comparator<T> comparator){
		this.comparator = comparator;
	}

	public void sort(T[] data){
		buildHeap(data);
		int len = data.length;

		//start from the end,exchange node 0 and curr,adjust fron node 0 to curr
		for(int i=len-1;i>=0;i--){
			T tmp = data[0];
			data[0] = data[i];
			data[i] = tmp;

			adjust(data,0,i);
		}
	}

	public void buildHeap(T[] data){
		for(int i=(data.length - 1)/2; i>=0;i--)
			adjust(data,i,data.length-1);
	}

	public void dumpData(T[] data){
		for(T d : data)
			System.out.print(d+" ");
		System.out.println();
	}

	public void adjust(T[] data,int i,int len){
		// int len = data.length;
		T temp = data[i];

		if(i>len) return;

		int child = i*2 + 1; //left child
		while(child <len){
			if(child+1 < len && comparator.compare(data[child],data[child+1])<0)
				child += 1;

			if(comparator.compare(data[i],data[child]) < 0){
				data[i] = data[child];
				i = child;
				child = i*2+1;
			}else{
				break;
			}

			data[i] = temp; //put the target in each level 
		}
	}

	public static void main(String[] args){
		HeapSort<Integer> heapSort = new HeapSort(
			new Comparator<Integer>(){

				public int compare(Integer o1,Integer o2){
					if(o1 < o2) return -1;
					else if(o1 > o2) return 1;
					else return 0;
				}
			}
		);

		Integer[] data = {90,1,23,83,2,1,9,2,43,21,8,8};

		heapSort.sort(data);

		heapSort.dumpData(data);
	}
}