public class interview_42{

	public static void main(String[] args){
		interview_42 solution = new interview_42();
		char[] str1 = "i am a student.".toCharArray();

		solution.solute1(str1);

		System.out.println(new String(str1));

		char[] str2 = "abcdefg".toCharArray();
		solution.solute2(str2,2);
		System.out.println(new String(str2));
	}

	public void solute1(char[] str){
		int len = str.length;

		reversePart(str,0,len-1);

		int idxS=0,idxE=-1;

		for(int i=0;i<len;i++){
			if(str[i] == ' '){
				idxS = idxE;
				idxE = i;
				reversePart(str,idxS+1,idxE-1);
			}
		}

		idxS = idxE;
		idxE = len-1;
		reversePart(str,idxS+1,idxE);
	}

	public void solute2(char[] str,int k){
		int len = str.length-1;

		reversePart(str,0,len);
		reversePart(str,0,len-k);
		reversePart(str,len-k+1,len);
	}

	public void reversePart(char[] str,int s,int e){
		if(s>=e) return;

		while(s<e){
			char tmp = str[s];
			str[s] = str[e];
			str[e] = tmp;
			s++;
			e--;
		}
	}
}