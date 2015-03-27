import java.util.*;

public class interview_25{
	public static void main(String[] args){
		TreeNode node11 = new TreeNode(10);
		TreeNode node12 = new TreeNode(5);
		TreeNode node13 = new TreeNode(12);
		TreeNode node14 = new TreeNode(4);
		TreeNode node15 = new TreeNode(7);

		node11.left = node12;
		node11.right = node13;
		node12.left = node14;
		node12.right = node15;

		interview_25 solution = new interview_25();
		solution.solute(node11,22);
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

	public void solute(TreeNode root,int sum){
		if(root == null) return;
		ArrayList<TreeNode> path = new ArrayList<TreeNode>();
		findWay(root,sum,path,0);
	}

	public void findWay(TreeNode root,int sum,ArrayList<TreeNode> path,int curr){
		curr += root.data;
		path.add(root);
		boolean isLeaf = (root.left == null && root.right == null);

		if(sum == curr && isLeaf){
			for(TreeNode node : path)
				System.out.print(node.data+" ");
			System.out.println();
		}

		if(root.left != null){
			findWay(root.left,sum,path,curr);
		}

		if(root.right != null){
			findWay(root.right,sum,path,curr);
		}

		path.remove(root);
	}
}