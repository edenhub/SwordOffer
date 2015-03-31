import java.util.*;

public class interview_37{

	public static void main(String[] args){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		
		n1.easyNext(n2).easyNext(n3).easyNext(n6).easyNext(n7);
		n4.easyNext(n5).easyNext(n6).easyNext(n7);

		interview_37 solution = new interview_37();

		ListNode same = solution.solute1(n1,n4);

		System.out.println(same.data);
		
	}

	public static class ListNode{
		public int data;
		public ListNode next;

		public ListNode(){
			this.next = null;
		}

		public ListNode(int data){
			this.data = data;
			this.next = null;
		}

		public ListNode(int data,ListNode next){
			this.data = data;
			this.next = next;
		}

		public ListNode easyNext(ListNode next){
			this.next = next;

			return next;
		}
	}

	public ListNode solute2(ListNode first,ListNode second){
		Stack<ListNode> stF = new Stack<ListNode>();
		Stack<ListNode> stS = new Stack<ListNode>();

		pushToStack(first,stF);
		pushToStack(second,stS);
		ListNode same = null;

		while(stF.peek() == stS.peek()){
			same = stF.pop();
			stS.pop();
		}

		return same;
	}

	public void pushToStack(ListNode list,Stack<ListNode> st){
		ListNode pt = list;

		while(pt!=null){
			st.push(pt);
			pt = pt.next;
		}
	}

	public ListNode solute1(ListNode first,ListNode second){
		int lenF = calLen(first),lenS= calLen(second);
		ListNode ptA,ptB;

		int step = lenF - lenS;
		if(step == 0){
			return findFirstSame(first,second);
		}else if(step > 0){
			ptA = first;
			while(step!=0){
				ptA = ptA.next;
				step--;
			}
			ptB = second;
			return findFirstSame(ptA,ptB);
		}else{
			ptB = first;
			while(step!=0){
				ptB = ptB.next;
				step--;
			}
			ptA = first;
			return findFirstSame(ptA,ptB);
		}
	}

	public ListNode findFirstSame(ListNode first,ListNode second){
		ListNode ptF=first,ptS=second;

		while(ptF.data != ptS.data){
			ptF = ptF.next;
			ptS = ptS.next;
		}

		return ptF;
	}

	public int calLen(ListNode list){
		ListNode pt = list;
		int cnt = 0;
		while(pt!=null){
			cnt++;
			pt = pt.next;
		}

		return cnt;
	}
}