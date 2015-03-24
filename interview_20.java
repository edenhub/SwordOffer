public class interview_20{

	public static void main(String[] args){
		int[][] datas = {
			{1,2,3,4},
			{5,6,7,8},
			{9,10,11,12},
			{13,14,15,16}
		};

		int[][] datas2 = {
			{1,2,3},
			{4,5,6},
			{7,8,9}
		};

		interview_20 solution = new interview_20();
		solution.solute(datas2);
	}

	public void solute(int[][] datas){
		int n = datas.length-1;

		int s1 = 0,e1 = n;
		int s2 = 1,e2 = n;
		int s3 = n -1 ,e3 = 0;
		int s4 = n-1,e4 = 1;

		int curr = 0;

		while(s1 <= n / 2){
			for(int i=s1;i<=e1;i++)
				System.out.print(datas[s1][i]+" ");

			for(int i=s2;i<=e2;i++)
				System.out.print(datas[i][e1]+" ");

			for(int i=s3;i>=e3;i--)
				System.out.print(datas[e2][i]+" ");

			for(int i=s4;i>=e4;i--)
				System.out.print(datas[i][e3]+" ");

			s1++; e1--;
			s2++; e2--;
			s3--; e3++;
			s4--; e4++;
		}
	}
}