public class interview_26{
	public static class ComplexListNode{
		public int value;
		public ComplexListNode next,subling;

		public ComplexListNode(){
			value = -1;
			next = subling = null;
		}

		public ComplexListNode(int value){
			this.value = value;
			next = subling = null;
		}

		public ComplexListNode(int value,ComplexListNode next,ComplexListNode subling){
			this.value = value;
			this.next = next;
			this.subling = subling;
		}
	}

	public static void main(String[] args){
		ComplexListNode n5 = new ComplexListNode(5);
		ComplexListNode n4 = new ComplexListNode(4);
		ComplexListNode n3 = new ComplexListNode(3);
		ComplexListNode n2 = new ComplexListNode(2);
		ComplexListNode n1 = new ComplexListNode(1);

		n1.next = n2;n1.subling = n3;
		n2.next = n3;n2.subling = n4;
		n3.next = n4;n3.subling = n5;
		n4.next = n5;n4.subling = n2;

		interview_26 solution = new interview_26();
		solution.dumpList(n1);

		ComplexListNode clone = solution.solute(n1);
		solution.dumpList(clone);
		solution.dumpList(n1);

	}

	public void dumpList(ComplexListNode head){
		ComplexListNode pt = head;

		while(pt!= null){
			System.out.print(pt.value+" ");
			if(pt.next!=null)
				System.out.print(pt.next.value+" ");
			if(pt.subling!= null)
				System.out.print(pt.subling.value);
			pt = pt.next;
			System.out.println();
		}
	}

	public ComplexListNode solute(ComplexListNode head){
		if(head == null) return null;

		ComplexListNode node = head;
		while(node!=null){
			ComplexListNode clone = new ComplexListNode(node.value);
			clone.next = node.next;
			node.next = clone;
			node = clone.next;
		}

		node = head;
		while(node != null){
			ComplexListNode sublingNode=null;
			sublingNode = node.next;
			if(node.subling != null)
				sublingNode.subling = node.subling.next;
			node = sublingNode.next;
		}

		node = head;
		ComplexListNode cloneHead=null,sublingNode = null;

		cloneHead = sublingNode = node.next;
		node.next = sublingNode.next;
		node = node.next;
		while(node != null){
			sublingNode.next = node.next;
			sublingNode = sublingNode.next;
			node.next = sublingNode.next;
			node = node.next;
		}

		return cloneHead;
	}
}