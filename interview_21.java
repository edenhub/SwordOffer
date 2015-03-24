import java.util.*;

public class interview_21<T>{
	private Stack<T> ctn,tmp;
	private Comparator<T> comparator;

	public interview_21(){
		ctn = new Stack<T>();
		tmp = new Stack<T>();
	}

	public void push(T data){
		ctn.push(data);
		if(tmp.empty())
			tmp.push(data);
		else{
			T min = tmp.peek();
			if(comparator.compare(min,data) <= 0)
				tmp.push(min);
			else
				tmp.push(data);
		}
	}

	public T pop(){
		T res = ctn.pop();
		tmp.pop();

		return res;
	}

	public T min(){
		return tmp.peek();
	}

	public static void main(String[] args){
		
	}
}