/*
Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Different from the previous question where weight is increasing from root to leaf, now the weight is defined from bottom up. i.e., the leaf level integers have weight 1, and the root level integers have the largest weight.

Example 1:

Input: [[1,1],2,[1,1]]
Output: 8
Explanation: Four 1's at depth 1, one 2 at depth 2.
Example 2:

Input: [1,[4,[6]]]
Output: 17
Explanation: One 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17.

 */

import java.util.*;
public class NestedListWeightSumII_364 {

    public int depthSumInverse(List<NestedInteger> nestedList){
       Queue<NestedInteger> queue = new ArrayDeque<>(nestedList);

       int levelWiseSum = 0;
       int totoalSum = 0;
       while(!queue.isEmpty()){

           for(int i=0; i< queue.size(); i++){
               NestedInteger ni = queue.poll();
               if(ni.isInteger()){
                   levelWiseSum += ni.getInteger();
               }else {
                   queue.add(ni);
               }
           }
          totoalSum +=levelWiseSum;
       }

       return totoalSum;
    }
}

/*
interface NestedInteger {
     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     public boolean isInteger();

     // @return the single integer that this NestedInteger holds, if it holds a single integer
     // Return null if this NestedInteger holds a nested list
     public Integer getInteger();

     // @return the nested list that this NestedInteger holds, if it holds a nested list
     // Return empty list if this NestedInteger holds a single integer
     public List<NestedInteger> getList();
}

 */
