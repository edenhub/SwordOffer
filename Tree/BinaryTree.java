package TestNormalSec;

public class BinaryTree<T>{
	public static void main(String[] args){
		BinaryTree<Character> bt = new BinaryTree();
		BinaryTree<Character>.TreeNode<Character> node0 =
				bt.newNode('0');

		BinaryTree<Character>.TreeNode<Character> node1 =
				bt.newNode('1');

		BinaryTree<Character>.TreeNode<Character> node2 =
				bt.newNode('2');

		BinaryTree<Character>.TreeNode<Character> node3 =
				bt.newNode('3');

		BinaryTree<Character>.TreeNode<Character> node4 =
				bt.newNode('4');

		BinaryTree<Character>.TreeNode<Character> node5 =
				bt.newNode('5');

		node0.left = node1;
		node0.right = node2;

		node1.left = node3;
		node1.right = node4;

		node2.right = node5;

		bt.preTraveRecursion(node0);
		System.out.println();
		bt.inTraveRecursion(node0);
		System.out.println();
		bt.postTraveRecursion(node0);
	}

	class TreeNode<T>{
		T data;
		TreeNode<T> left,right;

		public TreeNode(T data){
			this.data = data;
			left = null;
			right = null;
		}

		public TreeNode(T data,TreeNode<T> left,TreeNode<T> right){
			this.data = data;
			this.left = left;
			this.right = right;
		}

		public String toString(){
			return data.toString();
		}
	}

	public TreeNode<T> newNode(T data){
		return new TreeNode(data);
	}

	public TreeNode<T> newNode(T data,TreeNode<T> left,TreeNode<T> right){
		return new TreeNode(data,left,right);
	}

	public void preTraveRecursion(TreeNode<T> root){
		if(root!=null){
			System.out.print(root);
			preTraveRecursion(root.left);
			preTraveRecursion(root.right);
		}
	}

	public void inTraveRecursion(TreeNode<T> root){
		if(root!=null){
			inTraveRecursion(root.left);
			System.out.print(root);
			inTraveRecursion(root.right);
		}
	}

	public void postTraveRecursion(TreeNode<T> root){
		if(root!=null){
			postTraveRecursion(root.left);
			postTraveRecursion(root.right);
			System.out.print(root);
		}
	}
}