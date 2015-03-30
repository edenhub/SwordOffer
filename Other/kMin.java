public class kMin{

	public static void main(String[] args){
		int[] lines = {1,2,3,2,2,2,5,4,2};
		kMin solution = new kMin();

		System.out.println(solution.solute(lines,7));

	}

	public int solute(int[] lines,int k){

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

		return lines[idx];
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