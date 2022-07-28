/*
LeetCode 358
Given a non-empty string s and an integer k, rearrange the string such that the same characters are at least distance k from each other.

All input strings are given in lowercase letters. If it is not possible to rearrange the string, return an empty string "".

Example 1:

Input: s = "aabbcc", k = 3
Output: "abcabc"
Explanation: The same letters are at least distance 3 from each other.
Example 2:

Input: s = "aaabc", k = 3
Output: ""
Explanation: It is not possible to rearrange the string.
Example 3:

Input: s = "aaadbbcc", k = 2
Output: "abacabcd"
Explanation: The same letters are at least distance 2 from each other.
 */

public class RearrangeStringKDistanceApart_358 {
    public String rearrangeString(String s, int k) {

        int[] counts = new int[26];
        int[] indexPositions = new int[26];

        StringBuilder sb = new StringBuilder();

        for(char ch : s.toCharArray()){
            ++counts[ch-'a'];
        }

        for(int i=0; i<s.length(); i++){
            int pos = getNextLetter(counts, indexPositions, i);
            System.out.println(pos);
            if(pos == -1)
                return "";
            counts[pos]--;
            indexPositions[pos] = i+k;
            char ch = (char)('a' + pos);
            sb.append(ch);
        }

        return sb.toString();
    }

    private int getNextLetter(int[] counts, int[] indexPositions , int index){

        int maxCount = -1;
        int pos = -1;

        for(int i=0; i<26; i++){
            if(counts[i] >0 && counts[i] > maxCount && index >= indexPositions[i]){
                maxCount = counts[i];
                pos = i;
            }
        }

        return pos;
    }

    public static void main(String[]  args){
        RearrangeStringKDistanceApart_358 rearrangeStringKDistanceApart = new RearrangeStringKDistanceApart_358();
       // System.out.println("output of aaadbbcc , 2 : " +rearrangeStringKDistanceApart.rearrangeString("aaadbbcc", 2));
        System.out.println("out put of  aaabc, 3 : " +rearrangeStringKDistanceApart.rearrangeString("aaabc" , 3));
    }
}
