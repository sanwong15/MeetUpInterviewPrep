/*
 * San Wong
 * hswong1@uci.edu
 * 
 * Equilibrium index of an array is an index such that the sum of elements
 *  at lower indexes is equal to the sum of elements at higher indexes.
 */
public class EquilibriumIndexOfArray {

	public static void main(String[] args) {
		int[] test1 = {-7,1,5,2,-4,3,0};
		
		System.out.println("The equilibrium index: " +equilibrium(test1));
	}
	
	public static int equilibrium(int[] arr){
		int index = 0;
		int len = arr.length;
		int[] sumFromLeft = new int[len-2];
		int[] sumFromRight = new int[len-2];
		
		int[] temp1 = new int[len];
		temp1[0] = arr[0];
		for (int i=1; i<len; i++){
			temp1[i] = temp1[i-1] + arr[i];
		}
		
		System.out.println("Show temp1 array");
		for(int e: temp1){
			System.out.print(e + "  ");
		}
		System.out.println();
		
		for (int i=0; i<sumFromLeft.length; i++){
			sumFromLeft[i] = temp1[i];
		}
		
		System.out.println("Show sumFromLeft array");
		for(int e: sumFromLeft){
			System.out.print(e + "  ");
		}
		System.out.println();
		
		
		int[] temp2 = new int[len];
		temp2[len-1] = arr[len-1];
		
		for (int i=len-2; i>=0; i--){
			temp2[i] = temp2[i+1] + arr[i];
		}
		
		System.out.println("Show temp2 array");
		for(int e: temp2){
			System.out.print(e + "  ");
		}
		System.out.println();
		
		for (int i=2; i<len; i++){
			sumFromRight[i-2] = temp2[i];
		}
		
		System.out.println("Show sumFromRight array");
		for(int e: sumFromRight){
			System.out.print(e + "  ");
		}
		System.out.println();

		//Find index now.
		int len1 = sumFromLeft.length;
		for (int i=0; i<len1;i++){
			if (sumFromLeft[i] == sumFromRight[i]){
				index = i;
			}
		}
		
		return index+1; //We need to adjust the index here because we take away index 0 at first.
		
	}

}
