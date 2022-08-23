
/*
Assume you have an array of length n initialized with all 0's and are given k update operations.

Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.

Return the modified array after all k operations were executed.

Example:

Input: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
Output: [-2,0,3,5,3]
Explanation:

Initial state:
[0,0,0,0,0]

After applying operation [1,3,2]:
[0,2,2,2,0]

After applying operation [2,4,3]:
[0,2,5,5,3]

After applying operation [0,2,-2]:
[-2,0,3,5,3]


 */
public class RangeAddition_370 {
    public int[] getModifiedArray(int length, int[][] updates) {
       int[] ans = new int[length];

       for(int[] update : updates){
           int startIndex = update[0];
           int endIndex = update[1];
           int increment = update[2];

           ans[startIndex] = ans[startIndex] + increment;

           if(endIndex +1 < length)
               ans[endIndex] = ans[endIndex] - increment;

       }

       int prefix =0;
       for(int i=0; i<length; i++){
           prefix += ans[i];
           ans[i] = prefix;
       }
       return ans;


    }

    public static void main(String[] args){
        int[][]  updates = new int[3][3];
        updates[0] = new int[]{1, 3, 2};
        updates[1] = new int[]{2,4,3};
        updates[2] = new int[]{0,2,-2};
        RangeAddition_370 rangeAddition = new RangeAddition_370();
        rangeAddition.getModifiedArray(5, updates);
    }

}
