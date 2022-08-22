/*
Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:

answer[i] % answer[j] == 0, or
answer[j] % answer[i] == 0
If there are multiple solutions, return any of them.



Example 1:

Input: nums = [1,2,3]
Output: [1,2]
Explanation: [1,3] is also accepted.
Example 2:

Input: nums = [1,2,4,8]
Output: [1,2,4,8]
 */
import java.util.*;
public class LargestDivisibleSubset_368 {

    public static void main(String[] args){
       int[] nums = {1,2,3, 4,5, 8};
        LargestDivisibleSubset_368 largestDivisibleSubset_368 = new LargestDivisibleSubset_368();
        largestDivisibleSubset_368.largestDivisibleSubset(nums);
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
      int n= nums.length;
      List<Integer> ans = new ArrayList<>();
      // sizeEndsAt[i] := largest size ends at nums[i]
      int[] sizeEndsAt = new int[n];
        // prevIndex[i] := the best index s.t.
        // 1. nums[i] % nums[prevIndex[i]] == 0 and
        // 2. can increase the size of the subset
      int[] prevIndex = new int[n];
      int maxSize =0;   // max size of the subset
      int index = -1;   // track the best ending index

      Arrays.fill(sizeEndsAt, 1);
      Arrays.fill(prevIndex, -1);
      Arrays.sort(nums);

      // fix max ending num in the subset first

      for(int i=0; i<n; i++){
          for (int j = i - 1; j >= 0; --j){
              if (nums[i] % nums[j] == 0 && sizeEndsAt[i] < sizeEndsAt[j] + 1) {
                  sizeEndsAt[i] = sizeEndsAt[j] + 1;
                  prevIndex[i] = j;
              }
          }

          if (maxSize < sizeEndsAt[i]) {
              maxSize = sizeEndsAt[i];
              index = i; // update the best ending index
          }
      }
      while (index != -1) {
          ans.add(nums[index]);
          index = prevIndex[index];
      }

      return ans;
    }
}
