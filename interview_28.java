public class interview_28{

	public static void main(String[] args){
		char[] str = {'a','b','c'};

		interview_28 solution = new interview_28();
		solution.solute(str);
	}

	public void solute(char[] str){
		if(str == null)
			return;
		permutation(str,0);
	}

	public void permutation(char[] str,int start){
		int len = str.length;
		if(start == len){
			System.out.println(new String(str));
		}else{
			for(int i=start;i<len;i++){
				char tmp = str[i];
				str[i] = str[start];
				str[start] = tmp;

				permutation(str,start+1);

				tmp = str[i];
				str[i] = str[start];
				str[start] = tmp;
			}
		}
	}
}