public class interview_15{
	public static class ListNode{
		public int value;
		public ListNode next;

		public ListNode(){}

		public ListNode(int value){
			this.value = value;
			this.next = null;
		}

		public ListNode(int value,ListNode next){
			this(value);
			this.next = next;
		}
	}

	public static void main(String[] args){
		ListNode n5 = new ListNode(5);
		ListNode n4 = new ListNode(4,n5);
		ListNode n3 = new ListNode(3,n4);
		ListNode n2 = new ListNode(2,n3);
		ListNode n1 = new ListNode(1,n2);

		interview_15 solution = new interview_15();
		ListNode t = solution.solute(n1,0);
		if(t != null)
			System.out.println(t.value);
		else
			System.out.println("==");
	}

	public void dump(ListNode first){
		while(first != null)
			System.out.print(first.value+" ");
		System.out.println();
	}

	public ListNode solute(ListNode first,int k){
		if(first == null)
			return null;

		ListNode pt,target;
		int idx=0;

		pt = first;
		target = first;

		while(pt!=null){
			if(idx < k) idx++;
			else{
				target = target.next;
			}
			pt = pt.next;
		}

		if(idx < k)
			return null;

		return target;
	}
}