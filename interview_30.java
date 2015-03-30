public class interview_30{

	public static void main(String[] args){
		int[] lines = {4,5,1,6,2,7,3,8};

		interview_30 solutioin = new interview_30();
		solutioin.solute(lines,4);
	}

	public void solute(int[] lines,int k){

		int s = 0,e = lines.length-1;
		int idx = partition(lines,s,e);

		while(idx != k-1){
			if(idx > k-1){
				e = idx - 1;
				idx = partition(lines,s,e);
			}else if(idx < k-1){
				s = idx + 1;
				idx = partition(lines,s,e);
			}
		}

		for(int i=0;i<k;i++)
			System.out.print(lines[i]+" ");
	}

	public int partition(int[] lines,int s,int e){
		int tmp = lines[s];
		int low = s,high = e;

		while(low < high){
			while(low < high && tmp <= lines[high]) high--;
			lines[low] = lines[high];

			while(low < high && tmp >= lines[low]) low++;
			lines[high] = lines[low];
		}

		lines[low] = tmp;
		return low;
	}
}