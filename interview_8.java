public class interview_8{

	public int solute(int[] data){
		int l = 0,h = data.length-1;

		int m=0;
		while(data[l] >= data[h]){
			if(h - l == 1){
				m = h;
				break;
			}
			m = (l + h) / 2;

			if(data[l] == data[h] && data[m] == data[l])
				return midInOrder(data,l,h);
			else if(data[l] <= data[m])
				l = m;
			else if(data[h] >= data[m])
				h = m;
		}

		return data[m];
	}

	public int midInOrder(int[] data,int s,int e){
		int res = data[s];

		for(int i=s+1;i<=e;i++)
			if(data[i] < res)
				return data[i];
			else
				res = data[i];

		return res;

	}

	public static void main(String[] args){
		int[] test1 = {3,4,5,1,2};
		int[] test2 = {1,0,1,1,1};
		int[] test3 = {1,1,1,0,1};
		interview_8 solution = new interview_8();
		System.out.println(solution.solute(test1));
		System.out.println(solution.solute(test2));
		System.out.println(solution.solute(test3));
	}
}