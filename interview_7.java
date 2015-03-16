import java.util.*;

class interview_7<T>{
	private Stack<T> s1,s2;

	public interview_7(){
		s1 = new Stack<T>();
		s2 = new Stack<T>();
	}

	public interview_7 appendTail(T node){
		s1.push(node);

		return this;
	}

	public T deleteHead(){
		T res = null;

		if(!s2.empty())
			res = s2.pop();
		else{

			if(s1.empty())
				return res;

			while(!s1.empty()){
				s2.push(s1.pop());
			}

			res = s2.pop();
		}

		return res;
	}

	public static void main(String[] args){
		interview_7<Integer> solution = new interview_7<Integer>();

		solution.appendTail(3).appendTail(8).appendTail(7);
		System.out.println(solution.deleteHead());
		System.out.println(solution.deleteHead());
	}
}