
public class interview_6{

	public static class Node{
		char data;
		Node left,right;

		Node(){}

		Node(char data){
			this.data = data;
			left = right = null;
		}
	}

	public Node solutionPreIn(char[] preOrder,char[] inOrder){
		int len = preOrder.length;
		Node root = null;
		if(len > 0)
			root = new Node();

		preMidCreate(root,preOrder,0,inOrder,0,preOrder.length);

		return root;
	}

	public Node solutionPostIn(char[] postOrder,char[] inOrder){
		int len = inOrder.length;
		Node root = null;
		if(len > 0)
			root = new Node();

		postInCreate(root,postOrder,len-1,inOrder,0,len);

		return root;
	}

		// PreMidCreateTree(pn->left, i+1, j, m-j);            
		// m-j为左子树字符串长度
        // PreMidCreateTree(pn->right, i+(m-j)+1, m+1, len-1-(m-j));    
        // len-1-(m-j)为右子树字符串长度
	public void preMidCreate(Node root,char[] preOrder,int preS,
						char[] inOrder,int inS,int subLen){

		if(subLen <= 0){
			root = null;
			return;
		}

		char data = preOrder[preS];
		root.data = data;
		int m = positionInMid(inOrder,data);

		int lenLeft = m - inS,lenRight = subLen-1-(m-inS);
		if(lenLeft > 0)
			root.left = new Node();
		if(lenRight > 0)
			root.right = new Node();

		preMidCreate(root.left,preOrder,preS+1,inOrder,inS,lenLeft);
		preMidCreate(root.right,preOrder,preS+(m-inS)+1,inOrder,m+1,lenRight);
	}

 		// PostMidCreateTree(pn->left, i-1-(len-1-(m-j)), j, m-j);
 		// 注意参数:m-j左子树的长度,len-1-(m-j)右子树的长度
        // PostMidCreateTree(pn->right, i-1, m+1, len-1-(m-j));
	public void postInCreate(Node root,char[] postOrder,
			int postE,char[] inOrder,int inS,int subLen){
		if(subLen <= 0)
			return;

		char data = postOrder[postE];
		root.data = data;
		int m = positionInMid(inOrder,data);

		int lenLeft = m - inS,lenRight = subLen - 1 - (m - inS);

		if(lenLeft > 0)
			root.left = new Node();
		if(lenRight > 0)
			root.right = new Node();

		postInCreate(root.left,postOrder,postE - 1 - lenRight,inOrder,inS,lenLeft);
		postInCreate(root.right,postOrder,postE - 1,inOrder,m+1,lenRight);
	}

	public int positionInMid(char[] inOrder,char ch){
		for(int i=0;i<inOrder.length;i++){
			if(inOrder[i] == ch)
				return i;
		}

		return -1;
	}

	public static void PreOrder(Node root){
		if(root!=null){
			System.out.print(root.data);
			PreOrder(root.left);
			PreOrder(root.right);
		}
	}

	public static void InOrder(Node root){
		if(root!=null){
			InOrder(root.left);
			System.out.print(root.data);
			InOrder(root.right);
		}
	}

	public static void PostOrder(Node root){
		if(root!=null){
			PostOrder(root.left);
			PostOrder(root.right);
			System.out.print(root.data);
		}
	}

	public static void main(String[] args){
		char[] preOrder = "ABDHLEKCFG".toCharArray();
		char[] inOrder = "HLDBEKAFCG".toCharArray();
		char[] postOrder = "LHDKEBFGCA".toCharArray();

		interview_6 s = new interview_6();
		Node root1 = s.solutionPreIn(preOrder,inOrder);
		interview_6.PreOrder(root1);
		System.out.println();
		interview_6.InOrder(root1);
		System.out.println("\n<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

		Node root2 = s.solutionPostIn(postOrder,inOrder);
		interview_6.InOrder(root2);
		System.out.println();
		interview_6.PostOrder(root2);
		System.out.println();
	}
}