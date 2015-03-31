//没写
public class interview_32{

	public static void main(String[] args){
		interview_32 solution = new interview_32();

		solution.preTest();
	}

	public int solute(int n){

		int cnt = 0,last=0;

		boolean isFirst = true;

		while(n!=0){
			if (isFirst){
				isFirst = false;
				last = n % 10;
			}
			n /= 10;
			cnt++;
		}


	}

	public void preTest(){
		int n=231;

		int cnt = 0,last = 0;

		while(n!=0){
			last = n % 10;
			n /= 10;
		}

		System.out.println(cnt+" : "+last);
	}
}