import java.util.ArrayList;
import java.util.List;

/*
 * San Wong
 * hswong1@uci.edu
 * 
 * Print out the Tree (Pre-Order) and track where you at.
 */
public class trackTreeNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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

		printTreeCurrentNode(A,D,"*",0);
		
		System.out.println("Now track the current node during  Pre-Order travsing");
		ArrayList<LetterTreeNode> listOFNode = new ArrayList<LetterTreeNode>();
		preOrder(A,listOFNode);
		
		for (LetterTreeNode n: listOFNode){
			System.out.println("Current Node: " + n.data);
			printTreeCurrentNode(A,n,"*",0);
			System.out.println();
		}

	}
	
	public static void printTreeCurrentNode(LetterTreeNode root, LetterTreeNode current, String comment, int level){
		if (root == null) return;
		
		for(int i=0; i<level; i++){
			System.out.print("   ");
		}
		
		
		System.out.print(root.data);
		if (root.data.equals(current.data)){
			System.out.println(comment);
		}
		System.out.println();
		
		printTreeCurrentNode(root.left,current,comment,level+1);
		printTreeCurrentNode(root.right,current,comment,level+1);
		
	}
	
	public static void preOrder(LetterTreeNode root, List<LetterTreeNode> list){
		if (root == null) return;
		
		list.add(root);
		preOrder(root.left, list);
		preOrder(root.right, list);
	}

}

//For Reference
/*
class LetterTreeNode{
	LetterTreeNode left;
	LetterTreeNode right;
	Object data;
	
	//Constructor
	public LetterTreeNode(Object d){
		this.data = d;
	}
}
*/
