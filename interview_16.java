public class interview_16{

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

	public void dumpList(ListNode first){
		ListNode p = first;
		while(p!=null){
			System.out.print(p.value + " ");
			p = p.next;
		}
		System.out.println();
	}

	public static void main(String[] args){
		ListNode n5 = new ListNode(5);
		ListNode n4 = new ListNode(4,n5);
		ListNode n3 = new ListNode(3,n4);
		ListNode n2 = new ListNode(2,n3);
		ListNode n1 = new ListNode(1,n2);

		interview_16 solution = new interview_16();
		solution.dumpList(n1);
		ListNode t = solution.solute(n1);
		solution.dumpList(t);
	}

	public ListNode solute(ListNode first){
		if(first == null)
			return null;
		
		ListNode p1=first,p2=p1.next,p3;

		first.next = null;

		while(p2!=null){
			p3 = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = p3;
		}

		return p1;
	}
}