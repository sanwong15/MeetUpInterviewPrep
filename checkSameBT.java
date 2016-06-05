
public class checkSameBT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		
		LetterTreeNode A1 = new LetterTreeNode('a');
		LetterTreeNode B1 = new LetterTreeNode('b');
		LetterTreeNode C1 = new LetterTreeNode('c');
		LetterTreeNode D1 = new LetterTreeNode('d');
		LetterTreeNode E1 = new LetterTreeNode('e');
		LetterTreeNode F1 = new LetterTreeNode('f');
		LetterTreeNode G1 = new LetterTreeNode('g');
		
		A1.left = B1;
		A1.right = C1;
		B1.left = D1;
		B1.right = E1;
		C1.left = F1;
		C1.right = G1;
		
		System.out.println("Is A and A1 tree the same? " + isSame(A,A1));
		
		LetterTreeNode A2 = new LetterTreeNode('a');
		LetterTreeNode B2 = new LetterTreeNode('b');
		LetterTreeNode C2 = new LetterTreeNode('c');
		LetterTreeNode D2 = new LetterTreeNode('d');
		LetterTreeNode E2 = new LetterTreeNode('e');
		LetterTreeNode F2 = new LetterTreeNode('f');
		LetterTreeNode G2 = new LetterTreeNode('g');
		
		A2.left = C2;
		A2.right = B2;
		B2.left = D2;
		B2.right = E2;
		C2.left = F2;
		C2.right = G2;
		
		System.out.println("Is A and A2 tree the same? " + isSame(A,A2));

		LetterTreeNode A3 = new LetterTreeNode('a');
		LetterTreeNode B3 = new LetterTreeNode('b');
		LetterTreeNode C3 = new LetterTreeNode('c');
		LetterTreeNode D3 = new LetterTreeNode('d');
		LetterTreeNode E3 = new LetterTreeNode('e');
		LetterTreeNode F3 = new LetterTreeNode('f');
		LetterTreeNode G3 = new LetterTreeNode('g');
		LetterTreeNode H3 = new LetterTreeNode('h');
		
		A3.left = B3;
		A3.right = C3;
		B3.left = D3;
		B3.right = E3;
		C3.left = F3;
		C3.right = G3;
		D3.left = H3;
		
		System.out.println("Is A and A3 tree the same? " + isSame(A,A3));
	}
	
	public static boolean isSame(LetterTreeNode a, LetterTreeNode b){
		if (a == null && b == null){
			return true;
		}
			
		if(a != null && b != null){
			return (a.data == b.data && isSame(a.left, b.left) && isSame(a.right, b.right));
		}
			return false;
	}

}
