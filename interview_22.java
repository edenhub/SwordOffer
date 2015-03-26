import java.util.*;

public class interview_22{

	public static void main(String[] args){
		int[] pushList = {1,2,3,4,5};
		int[] popList = {4,3,5,2,1};

		interview_22 solution = new interview_22();
		boolean res = solution.check(pushList,popList);
		System.out.println(res);
	}

	public boolean check(int[] pushList,int[] popList){
		if(pushList == null || popList == null)
			return false;
		
		if(pushList.length != popList.length)
			return false;

		int len = pushList.length;
		int idxPush=0,idxPop=0;
		Stack<Integer> stack = new Stack<Integer>();

		while(idxPush < len && idxPop < len){
			stack.push(pushList[idxPush]);
			if(pushList[idxPush] != popList[idxPop]){
				idxPush++;
			}else{
				stack.pop();
				idxPop++;
				idxPush++;
			}
		}

		boolean res = true;
		while(!stack.empty()){
			if(stack.pop() !=popList[idxPop++]){
				res = false;
				break;
			}
		}

		return res;
	}
}