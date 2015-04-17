public class interview_38{

	public static void main(String[] args){
		int[] lines = {1,2,3,3,3,3,4,5};

		interview_38 solution = new interview_38();
		System.out.println(solution.solute(lines,3));
	}

	public int solute(int[] lines,int tgt){

		int first = firstIdx(lines,tgt);
		int last = lastIdx(lines,tgt);

		if(first == -1 || last == -1) return -1;
		else return last - first + 1;

	}

	public int firstIdx(int[] lines,int tgt){

		int s = 0,e = lines.length-1;
		int m = 0;

		while(s<=e){
			m = (s + e) / 2;

			int curr = lines[m];
			if(curr < tgt){
				s = m+1;
			}else if(curr > tgt){
				e = m - 1;
			}else{
				if((m>0 && lines[m-1] != tgt) || m == 0)
					return m;
				else
					e = m-1;
			}
		}

		return -1;			
	}

	public int lastIdx(int[] lines,int tgt){
		int s = 0,e = lines.length-1;
		int m = 0;

		while(s<=e){
			m = (s + e) / 2;
			int curr = lines[m];
			if(curr<tgt){
				s = m + 1;
			}else if(curr > tgt){
				e = m - 1;
			}else{
				if((m<e && lines[m+1]!=tgt) || m == e)
					return m;
				else
					s = m + 1;
			}
		}

		return -1;
	}
}