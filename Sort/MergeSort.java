import java.util.*;

public class MergeSort<T>{
	private Comparator<T> comparator;

	public MergeSort(Comparator<T> comparator){
		this.comparator = comparator;
	}

	public void sort(T[] data,T[] temp){
		int len = data.length-1;

		mergeSort(data,0,len,temp);
	}

	//first recure mergeSort for left array and right array
	//the merge left and right arrray
	public void mergeSort(T[] data,int s,int e,T[] temp){
		if(s<e){
			int m = (s + e) / 2;
			mergeSort(data,s,m,temp);
			mergeSort(data,m+1,e,temp);
			mergeArray(data,s,m,e,temp);
		}
	}

	public void mergeArray(T[] data,int s,int m,int e,T[] temp){
		int e1 = m,s2 = m+1;
		int i=s,j=s2,k=s;

		while(i<=e1 && j<=e){
			if(comparator.compare(data[i],data[j]) < 0)
				temp[k++] = data[i++];
			else
				temp[k++] = data[j++];
		}

		while(i<=e1){
			temp[k++] = data[i++];
		}

		while(j<=e){
			temp[k++] = data[j++];
		}

		for(int z=s;z<=e;z++)
			data[z] = temp[z];
	}

	public void dumpData(T[] data){
		for(T d : data)
			System.out.print(d+" ");
		System.out.println();
	}

	public static void main(String[] args){
		MergeSort<Integer> mergeSort = new MergeSort(
			new Comparator<Integer>(){

				public int compare(Integer o1,Integer o2){
					if(o1 < o2) return -1;
					else if(o1 > o2) return 1;
					else return 0;
				}
			}
		);

		Integer[] data = {90,1,23,83,2,1,9,2,43,21,8,8},temp = new Integer[data.length];

		mergeSort.sort(data,temp);

		mergeSort.dumpData(data);
	}
}