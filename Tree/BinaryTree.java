package TestNormalSec;

import java.util.*;

public class BinaryTree<T>{
	public static void main(String[] args){
		testTrave();
	}

	public static void testTrave(){
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
		System.out.println("\n----------------");
		bt.preTraveNoRecursion(node0);
		System.out.println();
		bt.inTraveNoRecursion(node0);
		System.out.println();
		bt.postTraveNoRecursion(node0);
		System.out.println();
		bt.postTraveNoRecursion2(node0);
	}

	/*
		TreeNode
	*/

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

	/*
		递归遍历
	*/
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

	/*
		递归遍历
	*/

	/*
		非递归遍历
	*/

	//先序非递归，若当前节点非空，先将右节点进栈，再将左节点进栈
	//循环直到栈为空
	public void preTraveNoRecursion(TreeNode<T> root){
		if(root == null)
			return;

		Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();

		stack.push(root);

		while(!stack.empty()){
			TreeNode<T> e = stack.pop();
			System.out.print(e);
			if(e.right != null)
				stack.push(e.right);
			if(e.left != null)
				stack.push(e.left);
		}
	}

	//若当前节点非空，将左子节点链上的点全部进栈
	//出栈，访问栈顶元素，再将当前节点指向右子节点
	//循环直到结束
	public void inTraveNoRecursion(TreeNode<T> root){
		if(root == null)
			return;

		Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
		TreeNode<T> pt = root;

		while(pt!= null || !stack.empty()){
			while(pt!=null){
				stack.push(pt);
				pt = pt.left;
			}

			if(!stack.empty()){
				pt = stack.pop();
				System.out.print(pt);
				pt = pt.right;
			}
		}
	}

	//双(T,O)栈后续非递归遍历
	//先将根节点进T栈
	//当T栈非空时，出栈访问栈顶元素，若非空则进O栈
	//若左右子节点非空，则分别进T栈
	//遍历O栈
	public void postTraveNoRecursion(TreeNode<T> root){
		if(root == null)
			return;

		Stack<TreeNode<T>> stack = new Stack<TreeNode<T>>();
		Stack<TreeNode<T>> output = new Stack<TreeNode<T>>();
		TreeNode<T> pt = root;

		stack.push(pt);

		while(!stack.empty()){
			pt = stack.pop();
			output.push(pt);

			if(pt.left!=null)
				stack.push(pt.left);

			if(pt.right!=null)
				stack.push(pt.right);
		}

		while(!output.empty()){
			System.out.print(output.pop());
		}
	}

	//增加一变量，标示当前节点出现在栈顶的次数
	//每个结点都两次出现在栈顶，只有在第二次出现在栈顶时，才能访问它
	//从当前节点开始，将节点标记为第一次访问，若左子树非空，则循环进栈
	//栈顶出栈，判断当前节点是否为第二次出现在栈顶，若是则直接访问
	//若不是，则更改标记，并将该节点进栈，同时间当前节点指向栈顶右子节点
	public void postTraveNoRecursion2(TreeNode<T> root){
		Stack<PostNode<T>> stack = new Stack<PostNode<T>>();
		TreeNode<T> pt = root;
		PostNode<T> temp;

		while(pt!=null || !stack.empty()){

			while(pt!=null){
				PostNode<T> node = new PostNode<T>(pt);
				stack.push(node);
				pt = pt.left;
			}

			if(!stack.empty()){
				temp = stack.pop();

				if(temp.isFirst){
					temp.isFirst = false;
					stack.push(temp);
					pt = temp.node.right;
				}else{
					System.out.print(temp.node);
				}
			}
		}
	}

	class PostNode<T>{
		TreeNode<T> node;
		boolean isFirst;

		public PostNode(TreeNode<T> node){
			this.node = node;
			isFirst = true;
		}

		public PostNode(TreeNode<T> node,boolean isFirst){
			this.node = node;
			this.isFirst = isFirst;
		}
	}

	/*
		非递归遍历
	*/
}