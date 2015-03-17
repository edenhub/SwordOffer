public class interview_10{

	// public int numOfOne(int n){
	// 	int sum = 0;
	// 	if(n < 0){
	// 		sum = 1;
	// 		n = -n;
	// 	}

	// 	while(n!=0){
	// 		if(n%2 == 1)
	// 			sum++;
	// 		n /= 2;
	// 	}

	// 	return sum;
	// }

	public int numOfOne_2(int n){
		int cnt = 0;

		while(n !=0){
			cnt++;

			n = (n - 1) & n;
		}

		return cnt;
	}

	public static void main(String[] args){
		interview_10 solution = new interview_10();
		// System.out.println(solution.numOfOne(-9));
		System.out.println(solution.numOfOne_2(-9));
	}
}