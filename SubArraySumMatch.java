/*
San Wong
hswong1@uci.edu
*/

public class SubArraySumMatch {

	/*
	Given an array of numbers (integer) and a target value T. Find how many continuous sub-array
	that would add up to the target value.
	
	First, solve the case where all numbers in the array are positive. Naive approach
	would result in O(n^2) run time. Linear time is possible.
	
	Then, consider the case where both positive and negative numbers.
	
	a:[4,6,3,7,10]		T=10
	Brainstorm: Naive approach (consider all the sub array) --------------------------------------
	
	Sub-array				Sum		is it T?
	4						4		No
	4,6						10		Yes (increment count)
	Stop (since it is all positive. increasing subarray won't do any good)
	
	increment i
	6						6		No
	6,3						9		No
	6,3,7					16		No (But it is greater than T)
	Stop
	
	increment i
	3						3		No
	3,7						10		Yes (increment count)
	Stop
	
	increment i
	7						7		No
	7,10					17		No (But greater than T)
	Stop
	
	increment i
	10						10		Yes (increment count)
	
	ENDD-------------------------------------------------------------------------------------------
	
	SlidingWindow approach
	a:[4,6,3,7,10]		T=10

	cumSum = [0, 4, 10, 13, 20, 30]
	Go through the cumSum array
	consider 2 pointers (i,j)
	tempSum = cumSum[j] - cumSum[i]
	if (tempSum < T) increment j, keep i the same
	if (tempSum == T) count++; increment j
	if (tempSum > T) increment i, keep j the same
	
	*/
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("[4,6,3,7,10]		T=10");
		System.out.println("Expected count: 3, [4,6],[3,7],[10]");
		int[] a = {4,6,3,7,10};
		int[] b = {4,6,3,7,-10};
		System.out.println("With naivePositive approach: " + naivePositive(a,10));
		System.out.println("With naiveAllCase approach: " + naiveAllCase(a,10));
		System.out.println("With SlidingWindow approach: " + slidingWindow(a,10));
		System.out.println();
		
		System.out.println("Deal with array that can have negative numbers");
		System.out.println("[4,6,3,7,-10]		T=10");
		System.out.println("Expected count: 3. [4,6],[3,7],[4,6,3,7,-10]");
		System.out.println("With naiveAllCase approach: " + naiveAllCase(b,10));
		System.out.println("With SlidingWindow approach: " + slidingWindow(b,10));
		System.out.println();
		System.out.println("My Sliding Window approach won't work on array with negative number because when 'tempSum > T', I increment index i. This act neglect the posibility of having a negative number in the array that can balance the surplus" );


	}
	
	public static int naivePositive(int[] a, int T){
		int count = 0;
		int tempSum = 0;
		
		for (int i=0; i<a.length; i++){
			innerloop:
			for (int j = i; j<a.length; j++){
				tempSum += a[j];
				
				if(tempSum < T){
					//Do nothing. j can keep increment
				}
				
				if(tempSum == T){
					count++;
					//Reset tempSum
					tempSum = 0;
					// break out from innerloop. So that i would increment but not j
					break innerloop;
				}
				
				if(tempSum > T){
					tempSum = 0;
					break innerloop;
				}
			}// End of innerloop
		}// End of outerloop
		
		
		return count;
	}// End of naivePositive approach
	
	public static int naiveAllCase(int[] a, int T){
		int count = 0;
		
		for (int i=0; i<a.length; i++){
			int tempSum = 0;
			for (int j = i; j<a.length; j++){
				tempSum += a[j];
				
				if(tempSum == T){
					count++;
				}

			}// End of innerloop
		}// End of outerloop
		return count;
	}// End of naiveAllCase approach
	
	
	public static int slidingWindow(int[] a, int T){
		int count = 0;
		int tempSum = 0;

		
		int[] cumSum = new int[a.length+1];
		cumSum[0] = 0;
		//System.out.print("cumSum[0]: "+cumSum[0]);
		//System.out.println();
		for (int k =1; k<cumSum.length; k++){
			cumSum[k] = cumSum[k-1] + a[k-1];
			//System.out.println("cumSum: "+cumSum[k]);
		}
		
		int i = 0;
		int j;
		
			
			for (j=i+1;j<cumSum.length; j++){
				//System.out.println("New iternation");
				tempSum = cumSum[j]-cumSum[i];
				//System.out.println("i: " + i+ "  j: " + j+ "  tempSum: " + tempSum);
				
				if (tempSum < T){
					//System.out.println("tempSum<T");
					//System.out.println();
				}
				
				if (tempSum == T){
					//System.out.println("tempSum==T");
					//System.out.println();
					count++;
				}
				
				if (tempSum > T){
					//System.out.println("tempSum>T");
					//System.out.println();
					i++;
					j--;
				}
			}
			
		
		return count;
	}// End of slidingWindows
	
	public static int ultimateMethod(int[] a, int T){
		int count=0;
		
		
		return count;
	}

}
