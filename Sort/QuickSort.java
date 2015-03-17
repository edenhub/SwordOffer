import java.util.*;

public class QuickSort<T>{

	private Comparator<T> comparator;

	public QuickSort(Comparator<T> comparator){
		this.comparator = comparator;
	}

	public void sort(T[] data){
		sortCore(data,0,data.length-1);
	}

	public void sortCore(T[] data,int start,int end){
		if(start >= end)
			return;

		int index = partition(data,start,end);
		sortCore(data,start,index-1);
		sortCore(data,index+1,end);
	}

	public int partition(T[] data,int start,int end){
		T temp = data[start];

		int i=start,j=end;

		while(i<j){

			while(i < j &&comparator.compare(data[j],temp) >= 0)
				j--;

			data[i] = data[j];

			while(i < j &&comparator.compare(data[i],temp) <= 0)
				i++;
			data[j] = data[i];
		}

		data[i] = temp;

		return i;
	}

	public void dumpData(T[] data){
		for(T d : data)
			System.out.print(d+" ");
		System.out.println();
	} 

	public static void main(String[] args){
		QuickSort<Integer> quickSort = new QuickSort(
			new Comparator<Integer>(){

				public int compare(Integer o1,Integer o2){
					if(o1 < o2) return -1;
					else if(o1 > o2) return 1;
					else return 0;
				}
			}
		);

		Integer[] data = {90,1,23,83,2,1,9,2,43,21,8};

		quickSort.sort(data);

		quickSort.dumpData(data);
	}


}