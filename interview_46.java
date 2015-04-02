public class interview_46{

	public static void main(String[] args){
		interview_46 solution = new interview_46();

		int res =solution.solute(4);


		System.out.println(res);
	}

	public static int N = 0;
	public static int Sum = 0;

	public interview_46(){
		N++;
		Sum += N;

		System.out.println(Sum);
	}

	public static void reset(){
		N = 0;
		Sum = 0;
	}

	public static int getSum(){
		return Sum;
	}

	public int solute(int n){
		reset();

		interview_46[] ins = new interview_46[n];

		return interview_46.getSum();
	}
}