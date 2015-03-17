public class interview_9{

	public long solute(int n){
		long first = 0,second = 1,sum=0;

		if(n==0)
			return first;

		if(n==1)
			return second;

		for(long i=2;i<=n;i++){
			sum = first + second;

			first = second;
			second = sum;
		}

		return sum;
	}

	public static void main(String[] args){
		interview_9 solution = new interview_9();

		long res = solution.solute(100);

		System.out.println(res);
	}
}