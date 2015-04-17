public class interview_47{

	public static void main(String[] args){
		int num1 = 5,num2 = 17;

		interview_47 solution = new interview_47();
		System.out.println(solution.solute(num1,num2));
	}

	public int solute(int num1,int num2){
		int sum=0,carry=0;

		do{
			sum = num1 ^ num2;
			carry = (num1 & num2) << 1;

			num1 = sum;
			num2 = carry;
		}while(num2!=0);

		return num1;
	}
}