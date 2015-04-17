public class interview_39{

	public static void main(String[] args){
		TreeNode node11 = new TreeNode(10);
		TreeNode node12 = new TreeNode(5);
		TreeNode node13 = new TreeNode(12);
		TreeNode node14 = new TreeNode(4);
		TreeNode node15 = new TreeNode(7);
		TreeNode node16 = new TreeNode(8);
		TreeNode node17 = new TreeNode(9);

		node11.left = node12;
		node11.right = node13;
		node12.left = node14;
		node12.right = node15;
		node15.right = node16;
		node16.right = node17;

		interview_39 solution = new interview_39();
		int deep = solution.solute1(node11);

		System.out.println(deep);

		boolean res = solution.solute2(node11);
		System.out.println(res);
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

	public static class Deep{
		public int deep;

		public Deep(){this.deep = 0;}
		public Deep(int deep){ this.deep = deep;}
	}

	public int solute1(TreeNode root){
		if(root == null) return 0;
		else if(root.left == null && root.right == null) return 1;

		int left = solute1(root.left);
		int right = solute1(root.right);

		return (left > right) ? left+1 : right+1;
	}

	public boolean solute2(TreeNode root){
		Deep deep = new Deep();
		return isBalance(root,deep);
	}

	public boolean isBalance(TreeNode root,Deep deep){
		if(root == null){
			deep.deep = 0;
			return true;
		}

		Deep left = new Deep(),right = new Deep();

		boolean isLeft = isBalance(root.left,left);
		boolean isRight = isBalance(root.right,right);

		if(isLeft && isRight){
			int step = left.deep - right.deep;
			if(step <= 1 && step >= -1){
				deep.deep = 1 + ((left.deep > right.deep) ? left.deep : right.deep);
				return true;
			}
		}

		return false;
	}
}