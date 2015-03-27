public class interview_24_2{
	public static void main(String[] args){
		interview_24_2 solution = new interview_24_2();
		int[] datas = {7,4,6,5};
		boolean res = solution.solute(datas,0,datas.length-1);
		System.out.println(res);
	}

	public boolean solute(int[] datas,int start,int end){
		if(datas == null) return false;
		if(end < start) return false;
		if(start == end) return true
;
		int root = datas[end];
		
		int i = start;
		for(;i<end;i++){
			if(datas[i] > root) break;
		}

		int j=i;
		for(;j<end;j++){
			if(datas[j] < root) return false;
		}

		boolean left = true;
		if(i>start){
			left = solute(datas,start,i-1);
		}

		boolean right = true;
		if(j<end){
			right = solute(datas,i,end-1);
		}

		return left && right;
	}
}