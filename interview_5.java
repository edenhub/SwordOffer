import java.util.*;

public class interview_5{

	public static void main(String[] args){
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(3);
		list.add(4);
		list.add(5);

		interview_5 instance = new interview_5();
		LinkedList<Integer> res = instance.solution(list);

		for(Integer i : res)
			System.out.print(i);
		System.out.println();
	}

	public <T> LinkedList<T> solution(LinkedList<T> list){
		Stack<T> stack = new Stack();
		LinkedList<T> res = new LinkedList<T>();
		for(T elem : list){
			stack.push(elem);
		}

		while(!stack.empty()){
			res.add(stack.pop());
		}

		return res;
	}
}