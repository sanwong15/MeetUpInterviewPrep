/*
San Wong
hswong1@uci.edu
*/

public class validbracketsKthread {
	/*
	 * We are trying to do a brackets expression validation with K thread. With this, we can improve our performance from O(n) to O(n/k)
	 * 
		 *index		0 1 2 3 4 5 
		 *			( ( ( ) ) )
		 *
		 *if k = 2. i.e split it into 2 subarray
		 *len = 6. stepSize = 6/2 = 3
		 *1st array: 0 : mp-1 => 0: 2
		 *2nd array: mp: len-1 => 3:5
		 *
		 *if k = 3  stepSize = 6/3 = 2
		 *1st: 0:1
		 *2nd 2:3
		 *3rd 4:5
		 *
		 *Assume we have k thread to do the following work at the same time
		 *We scan through each subString and asign "+1" to open bracket, "-1" to negative bracket
		 *
		 *Consider ( ( ( ) ) ) 
		 *So we will get +1 +1 +1 -1 -1 -1. Imagine we have 2 thread. The first subString will return +3 and the second subString will return -3
		 *The sum of both subString must be ZERO in order to have BALANCED bracket expression.
		 *
		 *However, this is not always true
		 *Imagine case: ( ) ) ( ( )
		 *1st subString we will get -1 and 2nd subString will get +1. Sum of both will give you ZERO. And this is obvious NOT BALANCED
		 *If Zero is revisited. The next value can't be "-1"
		 *
		 *
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "((()))";
		System.out.println("With two thread, is " + test+ " a valid statment?    " + kTreadCheck(test,2));
		System.out.println("With three thread, is " + test+ " a valid statment?    " + kTreadCheck(test,3));
		
		System.out.println();
		String test1 = "(()()(";
		System.out.println("With two thread, is " + test1+ " a valid statment?    " + kTreadCheck(test1,2));
		System.out.println("With three thread, is " + test1+ " a valid statment?    " + kTreadCheck(test1,3));
		
		System.out.println();
		String test2 = "))))((";
		System.out.println("With two thread, is " + test2+ " a valid statment?    " + kTreadCheck(test2,2));
		System.out.println("With three thread, is " + test2+ " a valid statment?    " + kTreadCheck(test2,3));

	}// End of main
	
	public static boolean kTreadCheck(String s, int k){
		String[] a = splitString(s,k);
		int size = a.length;
		int[] holder = new int[size];
		int i = 0;
		
		for (String e: a){
			int tempSum = 0;
			
			for (int j=0; j<e.length(); j++){
				if (e.charAt(j) == '('){
					tempSum++;
				}else if (e.charAt(j) == ')'){
					tempSum--;
				}else if (j!=0 && tempSum==0 && e.charAt(j+1) == ')'){
					return false;
				}
			}
			
			holder[i] = tempSum;
			i++;
		}
		
		int totalSum = 0;
		for (int h: holder){
			totalSum += h;
		}
		
		if (totalSum != 0){
			return false;
		}else{
			return true;
		}

	}
		
		//Split the input String
		public static String[] splitString(String s, int interval) {
		    int arrayLength = (int) Math.ceil(((s.length() / (double)interval)));
		    String[] result = new String[arrayLength];
		 
		    int j = 0;
		    int lastIndex = result.length - 1;
		    for (int i = 0; i < lastIndex; i++) {
		        result[i] = s.substring(j, j + interval);
		        j += interval;
		    } //Add the last bit 
		    result[lastIndex] = s.substring(j);
		 
		    return result;
		} 
	

}
