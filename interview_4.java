import java.util.*;

public class interview_4{

	public static void main(String[] args){
		char[] string = new char[30];
		string[0]='w';
		string[1]=' ';
		string[2]='a';
		string[3]=' ';
		string[4]=' ';
		string[5]='c';
		string[6]='\0';

		interview_4 instance = new interview_4();
		int res = instance.solution(string,30);

		System.out.println(res + " : "+new String(string));
	}

	
	public int solution(char[] string,int size){
		int blanks = 0,idx=0,length=0;

		while(string[idx] != '\0'){
			length++;
			if(string[idx] == ' ')
				blanks++;

			idx++;
		}

		int tail = length + blanks*2;

		if(tail > size)
			return 1;

		int p1=length,p2=tail;

		while(p1>=0 && p2 >=0){
			char ch = string[p1];

			if(ch == ' '){
				string[p2--]='0';
				string[p2--]='2';
				string[p2--]='%';
				p1--;
				
			}else{
				string[p2--] = string[p1--];
			}
		}

		return 0;
	}
}