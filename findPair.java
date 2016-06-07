import java.io.*;
import java.util.*;


class Solution {
  public static void main(String[] args) {
      int[] test1 ={1,2,10,0};
      int target1 = 3;
    
      int[] test2 = {100,2,10,0};
      int target2 = 3;
    
    System.out.println(existPair(test1,target1));
    System.out.println(existPair(test2,target2));
    }
  
  
  public static boolean existPair(int[] test, int target){
    HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
    
    int i;
    
    for (i=0; i<test.length; i++) {
      map.put(test[i], target-test[i]);
    }
    

    
    for (i=0; i<test.length; i++){
      int val = map.get(test[i]);
      return (map.containsKey(val));
    }
    
    return true;
    
  }
  
  
  
}