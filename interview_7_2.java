import java.util.*;

public class interview_7_2<T>{

	private ArrayDeque<T> q1,q2;

	public interview_7_2(){
		q1 = new ArrayDeque<T>();
		q2 = new ArrayDeque<T>();
	}

	public interview_7_2 push(T node){
		if(isEmpty() || q1.isEmpty())
			q1.add(node);
		else
			q2.add(node);

		return this;
	}

	public boolean isEmpty(){
		return q1.isEmpty() && q2.isEmpty();
	}

	public void insertToQueue(ArrayDeque<T> q,T node){
		q.add(node);
	}

	public T deleteFromQueue(ArrayDeque<T> src,ArrayDeque<T> dest){
		T target = null;

		while(!src.isEmpty()){
			target = src.remove();
			if(!src.isEmpty())
				dest.add(target);
		}

		return target;
	}

	public T remove(){
		if(isEmpty())
			return null;

		if(!q1.isEmpty())
			return deleteFromQueue(q1,q2);
		else
			return deleteFromQueue(q2,q1);
	}

	public static void main(String[] args){
		interview_7_2<Integer> solution = new interview_7_2<Integer>();

		solution.push(9).push(0).push(7).push(6);

		System.out.println(solution.remove());
		System.out.println(solution.remove());

	}
}