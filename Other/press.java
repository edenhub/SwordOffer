import java.util.*;

// * > + > - > /
public class press{

	public static void main(String[] args) throws Exception{
		String str = "2*3-4+1+1/4";

		int a = '*',b = '+',c='-',d='/';

		System.out.println(a+" : "+b+" : "+c+" : "+d);

		System.out.println(new press().run(str.toCharArray()));
	}

	public int run(char[] line) throws Exception{
		int len = line.length;
		char[] postLine = new char[len];
		int idx=0;
		Stack<Character> temp = new Stack<Character>();

		for(int i=0;i<len;i++){
			 char ch = line[i];

			 if(ch == '*' || ch == '/' || ch == '+' || ch == '-'){
			 	if(temp.isEmpty()){
			 		temp.push(ch);
			 	}else{
			 		char top = temp.peek();
			 		if(ch < top){
			 			temp.push(ch);
			 		}else{
			 			while(!temp.isEmpty())
							postLine[idx++] = temp.pop();
			 			temp.push(ch);
			 		}
			 	}
			 }else{
			 	postLine[idx++] = ch;
			 }
		}

		while(!temp.isEmpty())
			postLine[idx++] = temp.pop();

		System.out.println(Arrays.toString(postLine));

		Stack<Integer> nums = new Stack<Integer>();

		for(int i=0;i<idx;i++){
			char ch = postLine[i];
			if('0' <= ch && ch <= '9'){
				nums.push(ch - '0');
			}else{
				int y = nums.pop();
				int x = nums.pop();
				int res = 0;
				switch(ch){
					case '+' :
						res = calA(x,y); break;
					case '*' :
						res = calB(x,y); break;
					case '-' :
						res = calC(x,y); break;
					case '/' :
						res = calD(x,y); break;
				}
				nums.push(res);
			}
		}

		return nums.pop();
	}

	//+
	public int calA(int x,int y){
		return x+y;
	}

	//*
	public int calB(int x,int y){
		return x * y;
	}

	//-
	public int calC(int x,int y){
		return x - y;
	}

	// /
	public int calD(int x,int y) throws Exception{
		if(y == 0)
			throw new Exception("error");

		return x / y;
	}
}