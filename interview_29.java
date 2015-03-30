public class interview_29{

	public static void main(String[] args){
		int[] lines = {1,2,3,2,2,2,5,4,2};

		interview_29 solution = new interview_29();

		System.out.println(solution.solute(lines));
	}

	public int solute(int[] lines){
		int trg=lines[0],num=1;

		for(int i=1;i<lines.length;i++){
			int curr = lines[i];

			if(num == 0) {
				trg = lines[i];
				num = 1;
			 }

			if(curr == trg) num++;
			else if(curr != trg) num--;

		}

		return trg;
	}
}