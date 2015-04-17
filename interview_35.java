public class interview_35{

	public static void main(String[] args){
		String str = "abaccdeff";
		interview_35 solution = new interview_35();

		System.out.println(solution.solute(str));
		String str2 = "We are students",sub2 = "aeiou";
		System.out.println(solution.solute2(str2,sub2));
	}

	public char solute(String str){
		int len = str.length();
		int[] hash = new int[256];

		for(int i=0;i<len;i++){
			char ch = str.charAt(i);
			hash[ch]++;
		}

		for(int i=0;i<len;i++){
			char ch = str.charAt(i);
			if(hash[ch] == 1)
				return ch;
		}

		return '\0';
	}

	public String solute2(String str,String sub){
		int subLen = sub.length();
		boolean[] hash = new boolean[256];

		for(int i=0;i<subLen;i++){
			char ch = sub.charAt(i);
			hash[ch] = true;
		}

		StringBuilder sb = new StringBuilder();
		int len = str.length();
		for(int i=0;i<len;i++){
			char ch = str.charAt(i);
			if(!hash[ch])
				sb.append(ch);
		}

		return sb.toString();

	}
}