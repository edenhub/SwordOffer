import java.util.*;

public class interview_23{
	public static void main(String[] args){
		TreeNode node11 = new TreeNode(11);
		TreeNode node12 = new TreeNode(12);
		TreeNode node13 = new TreeNode(13);
		TreeNode node14 = new TreeNode(14);
		TreeNode node15 = new TreeNode(15);
		TreeNode node16 = new TreeNode(16);
		TreeNode node17 = new TreeNode(17);
		TreeNode node18 = new TreeNode(18);
		TreeNode node19 = new TreeNode(19);

		node11.left = node12;
		node11.right = node13;
		node12.left = node14;
		node12.right = node15;
		node13.left = node16;
		node15.left = node17;
		node15.right = node18;
		node18.left = node19;

		interview_23 solution = new interview_23();
		solution.solute(node11);
	}

	public static class TreeNode{
		public int data;
		public TreeNode left,right;

		public TreeNode(){
			this.left = this.right = null;
		}

		public TreeNode(int data){
			this();
			this.data = data;
		}

		public TreeNode(int data,TreeNode left,TreeNode right){
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	public void solute(TreeNode root){
		if(root == null) return ;

		ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>();
		TreeNode curr;
		queue.add(root);

		while(!queue.isEmpty()){
			curr = queue.remove();
			System.out.print(curr.data+" ");
			if(curr.left != null)
				queue.add(curr.left);
			if(curr.right != null)
				queue.add(curr.right);
		}
	}
}