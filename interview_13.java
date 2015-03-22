public class interview_13{

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

		public boolean equal(Object o){
			if(o == null) return false;

			ListNode node = (ListNode)o;

			if(this.value == node.value)
				return true;
			else
				return false;
		}
	}

	public static void main(String[] args){
		ListNode n5 = new ListNode(5);
		ListNode n4 = new ListNode(4,n5);
		ListNode n3 = new ListNode(3,n4);
		ListNode n2 = new ListNode(2,n3);
		ListNode n1 = new ListNode(1,n2);
		ListNode head = new ListNode();
		head.next = n1;

		interview_13 solution = new interview_13();
		solution.dumpList(head);
		System.out.println("============");
		// solution.solute(head,n5);
		// solution.solute(head,n3);
		solution.solute(head,n1);	
		solution.dumpList(head);
	}

	public void dumpList(ListNode head){
		ListNode p = head.next;

		while(p != null){
			System.out.print(p.value+" ");
			p = p.next;
		}
		System.out.println();
	}

	public void solute(ListNode head,ListNode node){
		if(head == null || head.next == null)
			return;

		if(node.next == null && head.next == node){
			node = null;
			head.next = null;
			return;
		}

		if(node.next == null){
			ListNode p = head;
			while(p.next != node){
				p = p.next;
			}

			p.next = null;
			node = null;
			return;
		}

		ListNode p = node.next;
		node.value = p.value;
		node.next = p.next;
		p = null;
	}


}