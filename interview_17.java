public class interview_17{
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
		interview_17 solution = new interview_17();
		ListNode n5 = new ListNode(15);
		ListNode n4 = new ListNode(11,n5);
		ListNode n3 = new ListNode(8,n4);
		ListNode n2 = new ListNode(3,n3);
		ListNode n1 = new ListNode(1,n2);

		ListNode n25 = new ListNode(19);
		ListNode n24 = new ListNode(14,n25);
		ListNode n23 = new ListNode(7,n24);
		ListNode n22 = new ListNode(3,n23);
		ListNode n21 = new ListNode(2,n22);

		solution.dumpList(n1);
		solution.dumpList(n21);

		ListNode target = solution.merge(n1,n21);
		solution.dumpList(target);


	}

	public ListNode merge(ListNode list1,ListNode list2){
		if(list1 == null) return list2;
		if(list2 == null) return list1;

		ListNode head = new ListNode(),p1,p2,tail;

		p1 = list1;
		p2 = list2;
		tail = head;

		while(p1 != null && p2 != null){
			if(p1.value <= p2.value){
				tail.next = p1;
				tail = tail.next;
				p1 = p1.next;
			}else{
				tail.next = p2;
				tail = tail.next;
				p2 = p2.next;
			}
		}

		while(p1 != null){
			tail.next = p1;
			tail = tail.next;
			p1 = p1.next;
		}

		while(p2 != null){
			tail.next = p2;
			tail = tail.next;
			p2 = p2.next;
		}

		return head.next;
	}

	public void dumpList(ListNode first){
		ListNode p = first;
		while(p!=null){
			System.out.print(p.value + " ");
			p = p.next;
		}
		System.out.println();
	}
}