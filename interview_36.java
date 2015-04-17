public class interview_36{

	public static void main(String[] args){
		int[] lines = {7,5,6,4};

		interview_36 solution = new interview_36();

		System.out.println(solution.solute(lines));
	}

	public int solute(int[] lines){
		if(lines == null) return 0;
		else
			return merge(lines,0,lines.length-1);
	}

	public int merge(int[] lines,int s,int e){
		if(s>=e) return 0;

		int m = (e + s) / 2;

		int left = merge(lines,s,m);
		int right = merge(lines,m+1,e);

		int[] tmp = new int[e-s+1];
		int k=e-s,i=m,j=e,cnt=0;

		while(i>=s && j>m){
			if(lines[i] > lines[j]){
				cnt += j - m;
				tmp[k--] = lines[i--];
			}else{
				tmp[k--] = lines[j--];
			}
		}

		while(i>=s){
			tmp[k--] = lines[i--];
		}

		while(j>m){
			tmp[k--] = lines[j--];
		}

		for(int ii=s,ik=0;ii<=e;ii++,ik++){
			lines[ii] = tmp[ik];
		}

		return cnt+left+right;


	}
}