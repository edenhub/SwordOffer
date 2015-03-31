public class interview_33{

	public static void main(String[] args){
		int[] lines = {3,32,321};

		interview_33 solution = new interview_33();
		solution.solute(lines);
	}

	public int cmp(int x,int y){
		String first = String.valueOf(x)+String.valueOf(y);
		String second = String.valueOf(y)+String.valueOf(x);

		return first.compareTo(second);
	}

	public void solute(int[] lines){
		if(lines == null) return;
		int len = lines.length;
		sort(lines,0,len-1);

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<len;i++){
			sb.append(String.valueOf(lines[i]));
		}

		System.out.println(sb.toString());

	}

	public void sort(int[] lines,int s,int e){
		if(s>=e) return;

		int idx = partition(lines,s,e);
		sort(lines,s,idx-1);
		sort(lines,idx+1,e);
	}

	public int partition(int[] lines,int s,int e){
		int tmp = lines[s];
		int low = s,high = e;

		while(low < high){
			while(low < high && cmp(tmp,lines[high])<=0) high--;
			lines[low] = lines[high];

			while(low < high && cmp(tmp,lines[low]) >=0) low++;
			lines[high] = lines[low];
		}

		lines[low] = tmp;

		return low;
	}
}