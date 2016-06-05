import java.util.Queue;
import java.util.LinkedList;

/*
 * San Wong
 * hswong1@uci.edu
 * 
 * Print out a tree on a level order manner
 */
public class LevelOrderPrintTree {

	public static void main(String[] args) {
		//Construct a Tree
		LetterTreeNode A = new LetterTreeNode('a');
		LetterTreeNode B = new LetterTreeNode('b');
		LetterTreeNode C = new LetterTreeNode('c');
		LetterTreeNode D = new LetterTreeNode('d');
		LetterTreeNode E = new LetterTreeNode('e');
		LetterTreeNode F = new LetterTreeNode('f');
		LetterTreeNode G = new LetterTreeNode('g');
				
		A.left = B;
		A.right = C;
		B.left = D;
		B.right = E;
		C.left = F;
		C.right = G;
		
		System.out.println("BFS Print Tree");
		System.out.println("Max Depth: " + MaxDepth(A));
		BFSPrint(A);
		
		System.out.println();
		System.out.println("Level Order Print Tree");
		printLevelOrder(A);
		
		

	}
	
	public static void BFSPrint(LetterTreeNode root){
		Queue<LetterTreeNode> q = new LinkedList<LetterTreeNode>();
		q.add(root);
		
		while(!q.isEmpty()){
			LetterTreeNode current = q.remove();
			System.out.print(current.data);
			if(current.left!=null) q.add(current.left);
			if(current.right!=null) q.add(current.right);
			
		}
	}
	
	public static int MaxDepth(LetterTreeNode root){
		if(root == null) return 0;
		
		return 1+Math.max(MaxDepth(root.left), MaxDepth(root.right));
	}
	
	public static void printLevelOrder(LetterTreeNode root){
		int h = MaxDepth(root);
		for (int i=1; i<=h; i++){
			printGivenLevel(root,i);
			System.out.println();
		}
	}
	
	public static void printGivenLevel(LetterTreeNode root, int i){
		if(root == null) return;
		
		if(i == 1){
			System.out.print(root.data);
		}else{
			printGivenLevel(root.left,i-1);
			printGivenLevel(root.right,i-1);
		}
		
		
	}

}
