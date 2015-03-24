import java.util.*;

public class interview_19{
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

	public void solute1(TreeNode root){
		if(root == null) return;
		if(root.left == null && root.right == null) return;

		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;

		if(root.left != null)
			solute1(root.left);
		if(root.right != null)
			solute1(root.right);
	}

	public void solute2(TreeNode root,TreeNode target){
		if(root == null) return;
		if(root.left == null && root.right == null) return;

		target.data = root.data;

		if(root.left != null){
			target.right = new TreeNode();
			solute2(root.left,target.right);
		}
		if(root.right != null){
			target.left = new TreeNode();
			solute2(root.right,target.left);
		}
	}

	public void solute3(TreeNode root){
		Stack<TreeNode> stack = new Stack();
		if(root == null) return;
		stack.push(root);


		while(!stack.empty()){
			TreeNode top = stack.pop(),tmp;

			// if(top!= null){
				tmp = top.left;
				top.left = top.right;
				top.right = tmp;

				if(top.left != null)
					stack.push(top.left);
				if(top.left != null)
					stack.push(top.right);
			// }
		}
	}

	public void traveTreePre(TreeNode root){
		if(root!=null){
			System.out.print(root.data+" ");
			traveTreePre(root.left);
			traveTreePre(root.right);
		}
	}

	public void traveTreeIn(TreeNode root){
		if(root != null){
			traveTreeIn(root.left);
			System.out.print(root.data+" ");
			traveTreeIn(root.left);
		}
	}

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


		interview_19 solution = new interview_19();
		solution.traveTreePre(node11);
		// System.out.println();
		// solution.traveTreeIn(node11);
		System.out.println();
		// solution.solute1(node11);
		// solution.traveTreePre(node11);
		// System.out.println();
		// solution.traveTreeIn(node11);
		// TreeNode target = new TreeNode();
		solution.solute3(node11);
		solution.traveTreePre(node11);
	}
}