import java.util.*;

public class interview_12{

	public static void main(String[] args){
		new interview_12().solute(3);
	}

	public void solute(int n){
		char[] numbers = new char[n];

		for(int i=0;i<n;i++)
			numbers[i] = '0';

		for(char i='0';i<='9';i++){
			numbers[0] = i;
			solute(numbers,0);
		}
	}

	public void solute(char[] numbers,int index){
		if(index == numbers.length-1){
			dumpString(numbers);
			return;
		}

		for(char i='0';i<='9';i++){
			numbers[index+1] = i;
			solute(numbers,index+1);
		}
	}

	public void dumpString(char[] numbers){
		boolean isHead = true;
		for(int i=0;i<numbers.length;i++){
			if(numbers[i] == '0' && isHead)
				continue;
			isHead = false;
			System.out.print(numbers[i]);
		}
			
		System.out.println();
	}
}