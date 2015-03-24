public class interview_18{

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

		TreeNode node25 = new TreeNode(15);
		TreeNode node27 = new TreeNode(17);
		TreeNode node28 = new TreeNode(18);

		node25.left = node27;
		node25.right = node28;

		interview_18 solution = new interview_18();
		boolean res = solution.check(node11,node25);
		System.out.println(res);
	}

	public boolean check(TreeNode rootSrc,TreeNode rootSub){
		if(rootSrc == null || rootSub == null)
			return false;

		boolean res = false;

		if(rootSrc.data == rootSub.data)
			res = hasSubTree(rootSrc,rootSub);

		if(!res)
			res = check(rootSrc.left,rootSub);

		if(!res)
			res = check(rootSrc.right,rootSub);

		return res;
	}

	public boolean hasSubTree(TreeNode rootSrc,TreeNode rootSub){
		if(rootSrc == null)
			return false;
		if(rootSub == null)
			return true;

		if(rootSrc.data != rootSub.data)
			return false;

		return hasSubTree(rootSrc.left,rootSub.left) && hasSubTree(rootSrc.right,rootSub.right);
	}
}