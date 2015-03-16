import java.util.*;

public class interview_7_3<T>{
	private ArrayDeque<T> q1,q2;

	public interview_7_3(){
		q1 = new ArrayDeque();
		q2 = new ArrayDeque();
	}

	public interview_7_3 push(T node){
		if(q1.size() > 0)
			q1.add(node);

		else if(q2.size() > 0)
			q2.add(node);

		else 
			q1.add(node);

		return this;
	}

	public boolean isEmpty(){
		return q1.size() == 0 && q2.size() == 0;
	}

	public T pop(){
		if(q2.size() == 0){
			while(q1.size() != 1){
				q2.add(q1.remove());
			}

			return q1.remove();
		}else if(q1.size() == 0){
			while(q2.size() != 1){
				q1.add(q2.remove());
			}

			return q2.remove();
		}else
			return null;
	}


	public static void main(String[] args){
		interview_7_3<Integer> solution = new interview_7_3<Integer>();

		solution.push(9).push(2).push(3).push(7);

		System.out.println(solution.pop());
		System.out.println(solution.pop());
	}

}