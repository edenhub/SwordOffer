public class interview_31{

	public static void main(String[] args){
		interview_31 solution = new interview_31();

		int[] lines = {1,-2,3,10,-4,7,2,-5};
		System.out.println(solution.solute(lines));
	}

	public int solute(int[] lines){
		int len = lines.length;
		int[] tmps = new int[len];
		tmps[0] = lines[0];

		int max = tmps[0];

		for(int i=1;i<len;i++){
			int pre = tmps[i-1];

			if(pre <= 0) tmps[i] = lines[i];
			else tmps[i] = pre+lines[i];

			if(tmps[i] > max)
				max = tmps[i];
		}

		return max;
	}
}